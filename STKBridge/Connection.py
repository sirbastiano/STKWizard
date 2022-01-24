from win32api import GetSystemMetrics
import comtypes
import os
from comtypes.client import GetActiveObject, CreateObject
import pandas as pd

FIRST_RUN_EVER = False

if FIRST_RUN_EVER==False:
     from comtypes.gen import STKUtil
     from comtypes.gen import STKObjects

cwd = os.getcwd()


class STK:

    def __init__(self):
        

        def ConnectToSTK(self, version=11,scenarioPath = cwd+'\\Project',scenarioName='Inserimento'):
        # Connect to STK
            # Launch or connect to STK
            try:
                app = GetActiveObject('STK{}.Application'.format(version))
                root = app.Personality2
                root.Isolate()
            except:
                app = CreateObject('STK{}.Application'.format(version))
                app.Visible = True
                app.UserControl= True
                root = app.Personality2
                root.Isolate()
                try:
                    root.LoadScenario(scenarioPath+'\\'+scenarioName+'.sc')
                except:    
                    root.NewScenario(scenarioName)
            root.UnitPreferences.SetCurrentUnit('DateFormat','Epsec')
            root.ExecuteCommand('Units_SetConnect / Date "Epsec"')

            self.scenario = root.CurrentScenario
            self.sc=self.scenario.QueryInterface(STKObjects.IAgScenario)

            return root
        
        try:
            self.root = ConnectToSTK(self)
            print("Connection execution successfully")
        except:
            print("Connection execution not working.")

    def getByName(self, objectName: str):
        try:
            obj = self.root.CurrentScenario.Children(objectName) # Get Walker object from scenario opened.
            name=obj.InstanceName
            print(f'Object: {name} fetched.')
            return obj
        except:
            print('Object not found.')

    def addSatellite(self, SatName: str, params: dict):
        try:
            # First satellite object must be created:
            sat = self.root.CurrentScenario.Children.New(18, SatName)  # eSatellite
            # IAgStkObjectRoot root: STK Object Model Root
            satellite = sat.QueryInterface(STKObjects.IAgSatellite) # Interface
        except:
            print('Not possible to create Satellite.')
        try:
            self.root.ExecuteCommand('SetUnits / km') # Default Connect Units are meters
            self.root.ExecuteCommand(f'SetState */Satellite/{SatName} Classical J4Perturbation "UseAnalysisStartTime" "UseAnalysisStopTime" 60 ICRF "UseAnalysisStartTime" {params["a"]} {params["e"]} {params["i"]} {params["w"]} {params["RAAN"]} {params["M"]}')
            print('Satellite Added!')
        except:
            print('Not possible to modify Sat propagation.')

    def addSensor(self, SatName: str, SenName: str, params: dict):
        sat = self.getByName(SatName)
        # sensor = <satellite_name>.Children.New(STKObjects.eSensor,'MySensor')
        sensor = sat.Children.New(20,SenName) # eSensor
        sensor2 = sensor.QueryInterface(STKObjects.IAgSensor)
        # IAgSensor sensor: Sensor object
        # Change pattern and set
        # sensor2.CommonTasks.SetPatternRectangular(20,25)
        sensor2.CommonTasks.SetPatternSimpleConic(ConeAngle=params['coneAngle'], AngularResolution=params['angularResolution'])
        # Change pointing and set
        sensor2.CommonTasks.SetPointingFixedAzEl(params['AzEl'][0],params['AzEl'][1],1) # eAzElAboutBoresightRotate
        # Change location and set
        # sensor2.SetLocationType(0) # eSnFixed
        self.root.ExecuteCommand(f'SetConstraint */Satellite/{SatName}/Sensor/{SenName}  Range Max {str(params["maxRange"])} ')



        
    def WalkerDelta(self, SatName: str, params: dict):
        
        self.NumPlanes = params["NumPlanes"]
        self.NumSatsPerPlane = params["NumSatsPerPlane"]
        self.NumSatellites = self.NumPlanes * self.NumSatsPerPlane

        # Generate Walker-Delta:
        cmd = f'Walker */Satellite/{SatName} Type Custom NumPlanes {params["NumPlanes"]} NumSatsPerPlane {params["NumSatsPerPlane"]} InterPlaneTrueAnomalyIncrement {params["InterPlaneTrueAnomalyIncrement"]} RAANIncrement {params["RAANIncrement"]} ColorByPlane {params["ColorByPlane"]}'
        # cmd = f'Walker */Satellite/{SatName} Type Custom NumPlanes {params["NumPlanes"]} NumSatsPerPlane {params["NumSatsPerPlane"]} InterPlaneTrueAnomalyIncrement {params["InterPlaneTrueAnomalyIncrement"]} RAANIncrement {params["RAANIncrement"]} ColorByPlane {params["ColorByPlane"]} ConstellationName {params["ConstellationName"]}'
        self.root.ExecuteCommand(cmd)
        print("Walker Delta constellation generated.")



        
    def CreateConstellationObject(self, ConstellationName='Sensors'):
        # Helper function:
        def AuxilPlanes(N: int):
            assert N > -1
            if N < 9:
                stringa = '0'+str(N+1)
                return stringa
            else:
                return str(N+1)

        constellation = self.root.CurrentScenario.Children.New(6, ConstellationName)  # eConstellation Object
        constellation2 = constellation.QueryInterface(STKObjects.IAgConstellation)

        for p in range(self.NumPlanes):
            for n in range(self.NumSatsPerPlane):
                # constellation2.Objects.Add(f'*/Satellite/mysat{str(p+1)}{AuxilPlanes(n)}/Sensor/Sensor1')
                constellation2.Objects.Add(f'*/Satellite/mysat{str(p+1)}{str(n+1)}/Sensor/Sensor1')
 


    def CreateChainObject(self, pathObjToAdd: list, chainName: str):
        assert len(pathObjToAdd) > 0
        
        chain = self.root.CurrentScenario.Children.New(4, chainName)  # eChain
        chain2 = chain.QueryInterface(STKObjects.IAgChain)

        for elem in pathObjToAdd:
            chain2.Objects.Add(elem)
        
        print(f"Chain ({chainName}) object with sensors generated.")

    def _computeChain(self, chainName: str):
        # Helper function to compute the gaps between accesses
        def promptGaps(starters,enders):
            gaps = ()
            for ii in range(len(enders)):
                if ii==0:
                    gaps += (86400-enders[-1]+starters[0],)
                else:
                    gaps += (starters[ii]-enders[ii-1],)
            return gaps


        chain = self.getByName('Chain')
        chain2 = chain.QueryInterface(STKObjects.IAgChain)

        # Clear all precedent access of the chain
        chain2.ClearAccess()
        # Compute the chain
        chain2.ComputeAccess()
        # Extract the data
        chainDataProvider = chain.DataProviders.GetDataPrvIntervalFromPath("Object Access")
        chainResults = chainDataProvider.Exec(self.sc.StartTime, self.sc.StopTime)

        objectList = [] # list of users
        AccessDict = {} # dictionary of access

        # Loop through all users access intervals
        for intervalNum in range(chainResults.Intervals.Count - 1):
            
            # Get interval
            interval = chainResults.Intervals[intervalNum]
            
            # Get data for interval
            objectName = interval.DataSets.GetDataSetByName("Strand Name").GetValues()[0]
            durations = interval.DataSets.GetDataSetByName("Duration").GetValues()
            StartTimes = interval.DataSets.GetDataSetByName("Start Time").GetValues()
            StopTimes = interval.DataSets.GetDataSetByName("Stop Time").GetValues()
            # Add data
            objectList.append(objectName)
            AccessDict[objectName] = {'startTimes':StartTimes, 'stopTimes':StopTimes, 'durations':durations, 'gaps': promptGaps(StartTimes, StopTimes)}
        
        print(f"Chain access computation for chain ({chainName}) executed.")


        return objectList, AccessDict
        
    def _reset(self):

        SensorsConstellation = self.getByName('Sensors')
        SensorsConstellation.Unload()

        sat = self.getByName('mysat')
        sat.Unload()

        # def AuxilPlanes(N: int):
        #     assert N > -1
        #     if N < 9:
        #         stringa = '0'+str(N+1)
        #         return stringa
        #     else:
        #         return str(N+1)

        for p in range(self.NumPlanes):
            for n in range(self.NumSatsPerPlane):
                sat = self.getByName(f'mysat{str(p+1)}{str(n+1)}')
                sat.Unload()

        chain = self.getByName('Chain')
        chain.Unload()

        print("Reset completed successfully.")



    def chainReport(root,chainPath,objsToAdd,startTime,stopTime,exportFileName, StyleName='Individual Object Access', pathObjToAdd=[]):
        chain = root.GetObjectFromPath(chainPath)
        chain2 = chain.QueryInterface(STKObjects.IAgChain)
        chain2.Objects.RemoveAll()

        chain2.ClearAccess()
        if len(pathObjToAdd) > 0:
            for elem in pathObjToAdd:
                chain2.Objects.Add(elem)
        # chain2.Objects.Add('Constellation/AllUsers')
        # chain2.Objects.Add('Constellation/Sensors')
        # Compute the chain
        chain2.ComputeAccess()

        if len(objsToAdd) > 0:
            for obj in objsToAdd:
                chain2.Objects.Add(obj)
        chain2.ClearAccess()
        chain2.ComputeAccess()
        cmd = 'ReportCreate '+chainPath+' Type Export Style "'+StyleName+'" File "'+exportFileName+'" TimePeriod "'+str(startTime)+'" "'+str(stopTime)+'" TimeStep 5 Summary Include'
        root.ExecuteCommand(cmd)
        df = pd.read_csv('Project'+exportFileName)
        df = df[df.columns[:-1]]
        return df










def main():
     print("Starting main function.")


if __name__ == '__main__':
     main()
     print("Completed")


