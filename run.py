from Core.EvAlgo import GA
from STKBridge.Pipe import Pipeline


def main():
     f = Pipeline()

     class Optimizer(GA):

          def __init__(self, popSize, nGenerations, nVar, nObj, toKeep, nParents=25):
               super().__init__(popSize=popSize, nGenerations=nGenerations, nVar=nVar, nObj=nObj, toKeep=toKeep, nParents=nParents)
               self.idxGen = 0

          def run(self, startWith=None):
               if startWith is not None:
                    self.idxGen = startWith+1
                    super().InitialPopIdx(startWith) # Obtain Parents
                    
               while self.idxGen < self.nGenerations:
                    super().popolate()
                    super().duplicateRemover()
                    super().evaluate(function=lambda x: f.genSol(x))
                    super().survival(sortBy='Eval')
                    print(f'Gen {self.idxGen} completed.')
                    self.idxGen += 1


     Alg = Optimizer(popSize=20, nGenerations = 50, nVar=6, nObj=1, toKeep=5)
     Alg.run(startWith=2)


if __name__ == '__main__':
     main()