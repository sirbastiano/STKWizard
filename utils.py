# import numpy as np


# def computeSunSyncInclination(a,e):
#      a = 6778 
#      e = 0
#      mu    = 398600.440      #% Earth’s gravitational parameter [km^3/s^2]
#      Re = 6378               #% Earth radius [km]
#      J2  = 0.0010826269      #% Second zonal gravity harmonic of the Earth
#      we = 1.99106e-7    #% Mean motion of the Earth in its orbit around the Sun [rad/s]
#      #  Input
#      # Alt = 250:5:1000     #% Altitude,Low Earth orbit (LEO)
#      # a   = Alt + Re       #% Mean semimajor axis [km]
#      # e   = 0.0            #% Eccentricity

#      h = a*(1 - e**2)     # % [km]
#      n = (mu/(a**3))**0.5 # % Mean motion [s-1]
#      tol = 1e-10         # % Error tolerance
#      # % Initial guess for the orbital inclination
#      i0 = 180/np.pi * np.arccos(-2/3*(h/Re)**(2*we/(n*J2)))
#      err = 1e1
#      while(err >= tol ):
#           #   J2 perturbed mean motion
#           pp  = n*(1 + 1.5*J2*(Re/h)**2 *(1 - e**2)**0.5* (1 - 3/2*(np.sin(i0)*180/np.pi)**2));
#           i = 180/np.pi*np.arccos(-2/3*(h/Re)**2*we/(pp*J2))
#           err = abs(i - i0)
#           i0 = i
     
#      return i0









# # GetObject From Path
# root.GetObjectFromPath('Facility/'+facName)



# # __INIT__ with win32
# # NOTE: To run these code snippets, see FAQ "Getting Started STK COM integration using Python" at http://agiweb.force.com/faqs
# from win32com.client import Dispatch
# import os
# from comtypes.client import CreateObject

# # Start new instance of STK using win32com
# uiApplication = Dispatch('STK11.Application')
# uiApplication.Visible = True

# # Start new instance of STK using comtypes
# uiApplication = CreateObject('STK11.Application')
# uiApplication.Visible = True

# # Get our IAgStkObjectRoot interface
# root = uiApplication.Personality2

# cwd = os.getcwd()
# scenarioPath, scenarioName= cwd+'\\Project', 'MyProject'
# root.LoadScenario(scenarioPath+'\\'+scenarioName+'.sc')



# # ADD FACILITY FILE
# # IAgStkObjectRoot root: STK Object Model Root
# facility = root.CurrentScenario.Children.New(8, 'MyFacility')  # eFacility
# # IAgFacility facility: Facility Object
# facility2 = facility.QueryInterface(STKObjects.IAgFacility)
# facility2.Position.AssignGeodetic(41.9849, 21.4039, 0)  # Latitude, Longitude, Altitude

# # Set altitude to height of terrain
# facility2.UseTerrain = True

# # Set altitude to a distance above the ground
# facility2.HeightAboveGround = .05   # km