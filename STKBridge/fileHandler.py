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
        

        def ConnectToSTK(self, version=11,scenarioPath = cwd+'\\Project',scenarioName='MyProject'):
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










def main():
     print("Starting main function.")


if __name__ == '__main__':
     main()
     print("Completed")


