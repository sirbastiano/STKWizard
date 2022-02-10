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


def new_evaluator(objectList, AccessDict, printOut=False):
     nUsers, nWin = 0, 0
     for user in objectList:
          if user[:5] != "mysat":
               grabber1 = list(AccessDict[user]['durations'])
               # grabber2 = list(AccessDict[user]['gaps'])
               flag = False
               for elem in grabber1:
                    if float(elem) > 300:
                         nWin += 1
                         flag = True
               
               if flag:
                    nUsers += 1

     score = 0.6 * (nUsers) + 0.4 * (nWin)
     if printOut:
          print(f'Score: {score}')

     return score


def user_evaluator(objectList, AccessDict, nSats, printOut=False):
     nUsers =  0
     for user in objectList:
          if user[:5] != "mysat":
               grabber1 = list(AccessDict[user]['durations'])
               flag = False
               for elem in grabber1:
                    if float(elem) > 300:
                         flag = True
               
               if flag:
                    nUsers += 1

     score = max([nUsers / nSats, 0])
     if printOut:
          print(f'Score: {score}')

     return score

def double_evaluator(objectList, AccessDict, nSats, printOut=False):
     def checkUser(durations):
          for win in durations:
               if win > 360:
                    return True
               else:
                    return False

     def checkDoubleUser(durations):
          goodWin = [d for d in durations if d > 360]
          if len(goodWin) > 1:
               print(goodWin)
               return True
          else:
               return False

     servedUsersSingle = [x for x in objectList if (x[1:5] != "seed" and checkUser(AccessDict[x]['durations']))]
     servedUsersDouble = [y for y in servedUsersSingle if checkDoubleUser(AccessDict[y]['durations'])]
     
     nUsers = len(servedUsersSingle)
     score = nUsers + len(servedUsersDouble)

     if printOut:
          print(f'Score: {score}')

     return score, nUsers