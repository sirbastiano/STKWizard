# from Core.EvAlgo import GA
from Core.EvAlgo_serious import GA
from STKBridge.Pipe import Pipeline


def main():
     f = Pipeline()

     class Optimizer(GA):

          def __init__(self, popSize, nGenerations, nVar, nObj, toKeep, nParents, toRand):
               super().__init__(popSize=popSize, nGenerations=nGenerations, nVar=nVar, nObj=nObj, toKeep=toKeep, nParents=nParents, toRand=toRand)
               self.idxGen = 0

          def run(self, startWith=None):
               if startWith is not None:
                    self.idxGen = startWith+1
                    super().InitialPopIdx(startWith) # Obtain Parents
                    
               while self.idxGen < self.nGenerations:
                    super().popolate()
                    super().duplicateRemover()
                    # parms: SELECT --> 0: WinMean || 1: WinMultiple || 2: Double Users || 3: striano_evaluator
                    # super().evaluate(function=lambda x: f.genSol2(x, SELECT = 3, CONE_ANGLE = 20))
                    super().evaluate(function=lambda x: f.genSol3(x, SELECT = 3, CONE_ANGLE = 15))
                    super().survival(sortBy='Eval')
                    print(f'Gen {self.idxGen} completed.')
                    self.idxGen += 1

     
     Alg = Optimizer(popSize=100, nGenerations=20, nVar=6, nObj=1, toKeep=5, nParents=20, toRand=30)
     Alg.run(startWith=9)
     # Alg.run()


if __name__ == '__main__':
     main()