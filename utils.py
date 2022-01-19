# GetObject From Path
root.GetObjectFromPath('Facility/'+facName)



# __INIT__ with win32
# NOTE: To run these code snippets, see FAQ "Getting Started STK COM integration using Python" at http://agiweb.force.com/faqs
from win32com.client import Dispatch
import os
from comtypes.client import CreateObject

# Start new instance of STK using win32com
uiApplication = Dispatch('STK11.Application')
uiApplication.Visible = True

# Start new instance of STK using comtypes
uiApplication = CreateObject('STK11.Application')
uiApplication.Visible = True

# Get our IAgStkObjectRoot interface
root = uiApplication.Personality2

cwd = os.getcwd()
scenarioPath, scenarioName= cwd+'\\Project', 'MyProject'
root.LoadScenario(scenarioPath+'\\'+scenarioName+'.sc')



# ADD FACILITY FILE
# IAgStkObjectRoot root: STK Object Model Root
facility = root.CurrentScenario.Children.New(8, 'MyFacility')  # eFacility
# IAgFacility facility: Facility Object
facility2 = facility.QueryInterface(STKObjects.IAgFacility)
facility2.Position.AssignGeodetic(41.9849, 21.4039, 0)  # Latitude, Longitude, Altitude

# Set altitude to height of terrain
facility2.UseTerrain = True

# Set altitude to a distance above the ground
facility2.HeightAboveGround = .05   # km