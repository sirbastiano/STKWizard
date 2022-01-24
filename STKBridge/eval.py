import pandas as pd 
import numpy as np

def evaluator(objectList, AccessDict, printOut=False):
     allDurations, allGaps = [], []
     for user in objectList:
          if user[:5] != "mysat":
               grabber1 = list(AccessDict[user]['durations'])
               grabber2 = list(AccessDict[user]['gaps'])
               for elem in grabber1:
                    allDurations.append(elem)

               for elem in grabber2:
                    allGaps.append(elem)

     meanListenWindow = np.mean(allDurations)
     meanGaps = np.mean(allGaps)
     if printOut:
          print(f'Mean Listening Windows Time (s): {meanListenWindow}')
          print(f'Mean Listening Windows Gap (s): {meanGaps}')

     return meanListenWindow, meanGaps