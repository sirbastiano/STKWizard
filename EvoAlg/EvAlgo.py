import numpy as np
import pandas as pd


class GA:

     def __init__(self, popSize, nGenerations, nVar, nObj, toKeep):
          # Input:
          # popSize: size of the population
          # nGenerations: number of generations
          # nVar: number of variables
          # nObj: number of objectives
          # toKeep: number of parents to maintain throughout the generations
          self.popSize = popSize
          self.nGenerations = nGenerations
          self.idxGen = 0 # index of generations
          self.nVar = nVar
          self.nObj = nObj
          self.toKeep = toKeep



     def main(self):
          while( self.idxGen < self.nGenerations):
               self.popolate()
               self.evaluate(function=lambda x: sum(x))
               self.survival(nParents=10, sortBy='Eval')
               self.idxGen += 1




     def Sampling(self):
          x = np.full(self.nVar, None)
         
          x[0] = np.random.randint(6428,6928)      # a
          x[1] = np.random.randint(80,120)         # i
          x[2] = np.random.randint(60,100)         # RAAN
          x[3] = np.random.randint(1,15)            # NumPlanes
          x[4] = np.random.randint(1,15)            # NumSatxPlane
          # MAX 150 SATELLITES CONDITION:
          while(x[3]*x[4])>150:
               x[3] = np.random.randint(1,150)      # NumPlanes
               x[4] = np.random.randint(1,150)      # NumSatxPlane
          x[5] = np.random.random(1)[0]*10         # InterRAAN

          return x

     def popolate(self):
          # First population generated randomically
          if self.idxGen == 0:
               data = np.zeros(6)
               for i in range(self.popSize):
                    x = self.Sampling()
                    data = np.vstack((data,x))
               data=data[1:,:] # remove first row
               df = pd.DataFrame(data, columns=['a','i','RAAN','NumPlanes','NumSatxPlane','InterRAAN'])
               df.to_csv(f'gen_{self.idxGen}.csv')
          
          
          else:
               df = pd.DataFrame(columns=['a','i','RAAN','NumPlanes','NumSatxPlane','InterRAAN'])

               for idx in range(self.popSize):
                    if idx < self.toKeep:
                         individual = self.dfParents.iloc[idx,~self.dfParents.columns.str.contains('Eval')]
                         # TODO: admit to keep the solution.
                    else:
                         r = np.random.rand()
                         if r < 0.5:
                              individual = self.Crossover()
                         else:
                              individual = self.Mutate()
                    
                    df = df.append(individual)
               df.to_csv(f'gen_{self.idxGen}.csv')
          
          return df



     def evaluate(self, function):
          # initialize
          evals = []
          # Read Inputs
          df = pd.read_csv(f'gen_{self.idxGen}.csv')
          df = df.loc[:, ~df.columns.str.contains('^Unnamed')]
          for index, row in df.iterrows():
               sol = function(row.to_list()) # Evaluate
               evals.append(sol)             # Store 

          if self.nObj > 1:
               for idx in range(self.nObj):
                    score = [x[idx] for x in evals]
                    df.insert(df.shape[1], f'Eval_{idx}', score)
               
          else:
               df.insert(df.shape[1], 'Eval', evals)
               

          df.to_csv(f'gen_{self.idxGen}.csv')
          return True

     def survival(self, nParents, sortBy='Eval'):
          # Mating: pick parents
          df = pd.read_csv(f'gen_{self.idxGen}.csv')
          df = df.loc[:, ~df.columns.str.contains('^Unnamed')]
          df = df.sort_values(by=sortBy, ascending=False)

          self.dfParents = df.iloc[:nParents, :].reset_index(drop = True)



     def Crossover(self):

          def pickRandomParents(df: pd.DataFrame):
               # init 
               g1Idx,g2Idx = np.random.randint(0,df.shape[0]), np.random.randint(0,df.shape[0])
               while(g1Idx == g2Idx):
                    g1Idx,g2Idx = np.random.randint(0,df.shape[0]), np.random.randint(0,df.shape[0])

               g1 = df.iloc[g1Idx, ~df.columns.str.contains('Eval')]
               g2 = df.iloc[g2Idx, ~df.columns.str.contains('Eval')]

               return g1,g2

          
          a,b = pickRandomParents(self.dfParents)
          a,b = a.values,b.values
          assert a.shape == b.shape

          genome = np.full(self.nVar, None)
          for idx in range(len(a)):
               if idx == 3:
                    r = np.random.rand()
                    if r < 0.5:
                         genome[idx] = a[idx]
                         genome[idx+1] = a[idx+1]
                    else:
                         genome[idx] = b[idx]
                         genome[idx+1] = b[idx+1]
               elif idx == 4:
                    continue
               else:
                    r = np.random.rand()
                    if r < 0.5:
                         genome[idx] = a[idx]
                    else:
                         genome[idx] = b[idx]

          individual = pd.DataFrame([genome],columns=['a','i','RAAN','NumPlanes','NumSatxPlane','InterRAAN'])
          return individual


     def Mutate(self):
          # Pick a casual Parent and mutate it
          idx = np.random.randint(0,self.dfParents.shape[0])
          Parent = self.dfParents.iloc[idx, ~self.dfParents.columns.str.contains('Eval')]
          
          arrParent = Parent.values

          a = np.random.randint(-100,100)
          i = np.random.randint(-40,40)
          RAAN = np.random.randint(-40,40)
          # NumPlanes = np.random.randint(0,3)
          # NumSatxPlane = np.random.randint(0,3)

          # while((NumPlanes+arrParent[3])*(NumSatxPlane+arrParent[4])>150):
          #      NumPlanes = np.random.randint(0,3)
          #      NumSatxPlane = np.random.randint(0,3)
     
          InterRAAN = np.random.rand()

          genome = [arrParent[0]+a, arrParent[1]+i, arrParent[2]+RAAN, arrParent[3], arrParent[4], arrParent[5]]
          # genome = [arrParent[0]+a, arrParent[1]+i, arrParent[2]+RAAN, arrParent[3]+NumPlanes, arrParent[4]+NumSatxPlane, arrParent[5]]

          individual = pd.DataFrame([genome],columns=['a','i','RAAN','NumPlanes','NumSatxPlane','InterRAAN'])
          return individual



     def duplicateRemover(self):
          df = pd.read_csv(f'gen_{self.idxGen}.csv')
          df = df.loc[:, ~df.columns.str.contains('^Unnamed')]
          
          while(df.shape[0] < self.popSize):
               # Dropping duplicates
               df.drop_duplicates(keep = False, inplace = True) 
               
               if df.shape[0] < self.popSize:
                    data = np.full(6, None)
                    for i in range(self.popSize-df.shape[0]):
                         x = self.Sampling()
                         data = np.vstack((data,x))
                    data=data[1:,:] # remove first row
                    Added_df = pd.DataFrame(data, columns=['a','i','RAAN','NumPlanes','NumSatxPlane','InterRAAN'])
                    
                    df = df.append(Added_df)
               
          
          
          df.to_csv(f'gen_{self.idxGen}.csv')
     
