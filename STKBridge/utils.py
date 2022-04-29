

def getVarFromTxt(varstring:str='APP_VISIBLE =', txt_path='STK_CONFIG.txt'):
     """ Helper to read variables from txt """
     with open(txt_path,'r') as f:
          variables = [x.replace('\n','') for x in f.readlines()]

     for var in variables:
          if var.startswith(varstring):
               myvar=var.split(varstring)[-1].replace(' ','')
               if myvar == 'False':
                    myvar = False
               else:
                    myvar = True

     return myvar



def main():
     print('Executing main function')

if __name__ == '__main__':
     main()