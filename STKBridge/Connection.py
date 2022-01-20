from win32api import GetSystemMetrics
import comtypes
import os
from comtypes.client import GetActiveObject, CreateObject

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

        # Generate Walker-Delta:
        cmd = f'Walker */Satellite/{SatName} Type Custom NumPlanes {params["NumPlanes"]} NumSatsPerPlane {params["NumSatsPerPlane"]} InterPlaneTrueAnomalyIncrement {params["InterPlaneTrueAnomalyIncrement"]} RAANIncrement {params["RAANIncrement"]} ColorByPlane {params["ColorByPlane"]}'
        # cmd = f'Walker */Satellite/{SatName} Type Custom NumPlanes {params["NumPlanes"]} NumSatsPerPlane {params["NumSatsPerPlane"]} InterPlaneTrueAnomalyIncrement {params["InterPlaneTrueAnomalyIncrement"]} RAANIncrement {params["RAANIncrement"]} ColorByPlane {params["ColorByPlane"]} ConstellationName {params["ConstellationName"]}'
        self.root.ExecuteCommand(cmd)



    def chainAnalysis(root,chainPath,objsToAdd,startTime,stopTime,exportFileName):
        # TODO: modificare!!!!
        chain = root.GetObjectFromPath(chainPath)
        chain2 = chain.QueryInterface(STKObjects.IAgChain)
        chain2.Objects.RemoveAll()
        for obj in objsToAdd:
            chain2.Objects.Add(obj)
        chain2.ClearAccess()
        chain2.ComputeAccess()
        cmd = 'ReportCreate '+chainPath+' Type Export Style "Bent Pipe Comm Link" File "'+exportFileName+'" TimePeriod "'+str(startTime)+'" "'+str(stopTime)+'" TimeStep 60'
        root.ExecuteCommand(cmd)
        df = pd.read_csv(exportFileName)
        df = df[df.columns[:-1]]
        return df










def main():
     print("Starting main function.")


if __name__ == '__main__':
     main()
     print("Completed")


