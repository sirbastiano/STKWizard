import numpy as np
import pandas as pd


class GA:

     def __init__(self, popSize, nGenerations, nVar, nObj, toKeep, nParents):
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
          self.nParents = nParents
          self.cols = ['a1','a2','RAAN1','RAAN2']



     def main(self):
          while( self.idxGen < self.nGenerations):
               self.popolate()
               self.evaluate(function=lambda x: sum(x))
               self.survival(nParents=10, sortBy='Eval')
               self.idxGen += 1




     def Sampling(self):
          x = np.full(self.nVar, None)
         
          x[0] = np.random.randint(6778,6888)        # a1
          x[1] = np.random.randint(6778,6888)        # a2
          x[2] = np.random.randint(0,360)            # RAAN1
          x[3] = np.random.randint(0,360)            # RAAN2
          return x


     def popolate(self):
          # First population generated randomically
          if self.idxGen == 0:
               data = np.zeros(self.nVar)
               for i in range(self.popSize):
                    x = self.Sampling()
                    data = np.vstack((data,x))
               data=data[1:,:] # remove first row
               df = pd.DataFrame(data, columns=self.cols)
               df.to_csv(f'gen_{self.idxGen}.csv')
          
          
          else:
               df = pd.DataFrame(columns=self.cols)

               for idx in range(self.popSize):
                    if idx < self.toKeep:
                         individual = self.dfParents.drop(columns = ['Eval','Users']).iloc[idx,:]
                         # individual = self.dfParents.iloc[idx,~self.dfParents.columns.str.contains('Eval') or ~self.dfParents.columns.str.contains('Users')]
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
               print(f"Individual n.{index} of Gen {self.idxGen} prompted.")

          if self.nObj > 1:
               for idx in range(self.nObj):
                    df.insert(df.shape[1], f'Eval_{idx}', evals[idx,:])
               
          else:
               score = [x[0] for x in evals]
               df.insert(df.shape[1], 'Eval', score)
               nUsers = [x[1] for x in evals]
               df.insert(df.shape[1], 'Users', nUsers)
               

          df.to_csv(f'gen_{self.idxGen}.csv')
          return True

     def survival(self, sortBy='Eval'):
          # Mating: pick parents
          df = pd.read_csv(f'gen_{self.idxGen}.csv')
          df = df.loc[:, ~df.columns.str.contains('^Unnamed')]
          df = df.sort_values(by=sortBy, ascending=False)

          self.dfParents = df.iloc[:self.nParents, :].reset_index(drop = True)
          self.dfParents

     def InitialPopIdx(self, idx):
          df = pd.read_csv(f'gen_{idx}.csv')
          df = df.loc[:, ~df.columns.str.contains('^Unnamed')]
          df = df.sort_values(by='Eval', ascending=False)

          self.dfParents = df.iloc[:self.nParents, :].reset_index(drop = True)
          self.dfParents


     def Crossover(self):

          def pickRandomParents(df: pd.DataFrame):
               # init 
               g1Idx,g2Idx = np.random.randint(0,df.shape[0]), np.random.randint(0,df.shape[0])
               while(g1Idx == g2Idx):
                    g1Idx,g2Idx = np.random.randint(0,df.shape[0]), np.random.randint(0,df.shape[0])

               df = df.drop(columns=['Eval','Users'])
               g1 = df.iloc[g1Idx, :]
               g2 = df.iloc[g2Idx, :]

               # g1 = df.iloc[g1Idx, ~self.dfParents.columns.str.contains('Eval') or ~self.dfParents.columns.str.contains('Users')]
               # g2 = df.iloc[g2Idx, ~self.dfParents.columns.str.contains('Eval') or ~self.dfParents.columns.str.contains('Users')]

               return g1,g2

          
          a,b = pickRandomParents(self.dfParents)
          a,b = a.values,b.values
          assert a.shape == b.shape

          genome = np.full(self.nVar, None)
          for idx in range(len(a)):
               r = np.random.rand()
               if r < 0.5:
                    genome[idx] = a[idx]
               else:
                    genome[idx] = b[idx]

          individual = pd.DataFrame([genome], columns=self.cols)
          return individual


     def Mutate(self):
          # Pick a casual Parent and mutate it
          idx = np.random.randint(0,self.dfParents.shape[0])
          # Parent = self.dfParents.iloc[idx, ~self.dfParents.columns.str.contains('Eval')]
          Parent = self.dfParents.drop(columns = ['Eval','Users']).iloc[idx,:]

          arrParent = Parent.values

          a1 = np.random.randint(-20,20)
          a2 = np.random.randint(-20,20)
          RAAN1 = np.random.randint(-40,40)
          RAAN2 = np.random.randint(-40,40)
          # NumPlanes = np.random.randint(0,3)
          # NumSatxPlane = np.random.randint(0,3)

          # while((NumPlanes+arrParent[3])*(NumSatxPlane+arrParent[4])>150):
          #      NumPlanes = np.random.randint(0,3)
          #      NumSatxPlane = np.random.randint(0,3)
     
          # InterRAAN = np.random.rand()

          genome = [arrParent[0]+a1, arrParent[1]+a2, arrParent[2]+RAAN1, arrParent[3]+RAAN2]
          # genome = [arrParent[0]+a, arrParent[1]+i, arrParent[2]+RAAN, arrParent[3]+NumPlanes, arrParent[4]+NumSatxPlane, arrParent[5]]

          individual = pd.DataFrame([genome], columns=self.cols)
          return individual



     def duplicateRemover(self):
          df = pd.read_csv(f'gen_{self.idxGen}.csv')
          df = df.loc[:, ~df.columns.str.contains('^Unnamed')]
          df.drop_duplicates(keep = False, inplace = True) 
          
          while(df.shape[0] < self.popSize):
               # Dropping duplicates
               df.drop_duplicates(keep = False, inplace = True) 
               
               if df.shape[0] < self.popSize:
                    data = np.full(self.nVar, None)
                    for i in range(self.popSize-df.shape[0]):
                         x = self.Sampling()
                         data = np.vstack((data,x))
                    data=data[1:,:] # remove first row
                    Added_df = pd.DataFrame(data, columns=self.cols)
                    
                    df = df.append(Added_df)
               
          
          
          df.to_csv(f'gen_{self.idxGen}.csv')
     
