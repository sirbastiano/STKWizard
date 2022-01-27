from STKBridge.Connection import STK
from STKBridge.eval import evaluator, new_evaluator

class Pipeline(STK):

     def __init__(self):
          super().__init__()
          print("STK initialized.")
     

     def genSol(self, X: list):
          assert(len(X)==6)
          
          a, i, RAAN, NumPlanes, NumSatxPlane, RAANincerement = X 

          SeedDict = {'a':a, 'e':0,'i':i, 'w':0, 'RAAN':RAAN, 'M':10.5}
          ConstDict = {'NumPlanes':NumPlanes, 'NumSatsPerPlane':NumSatxPlane, 'InterPlaneTrueAnomalyIncrement': 5, 'RAANIncrement': RAANincerement, 'ColorByPlane': 'Yes'}
          #####################################################
          super().addSatellite(SatName='mysat', params=SeedDict)
          super().addSensor(SatName='mysat', SenName='Sensor1', params={'coneAngle':15, 'angularResolution':0.1, 'AzEl':[90,-90], 'maxRange':1200})
          super().WalkerDelta(SatName='mysat', params=ConstDict)
          super().CreateConstellationObject(ConstellationName='Sensors')
          super().CreateChainObject(pathObjToAdd=['Constellation/AllUsers', 'Constellation/Sensors'], chainName='Chain')
          usersList, AccessDict = super()._computeChain(chainName='Chain')
          
          # mWin, mGap = evaluator(usersList, AccessDict)
          # solution_old = [mWin, mGap, ConstDict['NumSatsPerPlane']*ConstDict['NumPlanes']]

          solution = new_evaluator(usersList, AccessDict)

          super()._reset()
          return solution


     def test(self, X: list):
          assert(len(X)==6)
          
          a, i, RAAN, NumPlanes, NumSatxPlane, RAANincerement = X 

          SeedDict = {'a':a, 'e':0,'i':i, 'w':0, 'RAAN':RAAN, 'M':10.5}
          ConstDict = {'NumPlanes':NumPlanes, 'NumSatsPerPlane':NumSatxPlane, 'InterPlaneTrueAnomalyIncrement': 5, 'RAANIncrement': RAANincerement, 'ColorByPlane': 'Yes'}
          #####################################################
          super().addSatellite(SatName='mysat', params=SeedDict)
          super().addSensor(SatName='mysat', SenName='Sensor1', params={'coneAngle':15, 'angularResolution':0.1, 'AzEl':[90,-90], 'maxRange':1200})
          super().WalkerDelta(SatName='mysat', params=ConstDict)
          super().CreateConstellationObject(ConstellationName='Sensors')
          super().CreateChainObject(pathObjToAdd=['Constellation/AllUsers', 'Constellation/Sensors'], chainName='Chain')
          usersList, AccessDict = super()._computeChain(chainName='Chain')
          mWin, mGap = evaluator(usersList, AccessDict)
          solution = [mWin, mGap, ConstDict['NumSatsPerPlane']*ConstDict['NumPlanes']]
          return solution[0]