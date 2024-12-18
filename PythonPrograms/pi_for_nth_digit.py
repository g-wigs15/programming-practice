# Program for finding pi to the nth digit
# This is a very common python interview question, hence why it was in the github for programming problems.
# The Chudnovsky algorithm will assist us in finding the nth digit of pi
# 

# imports
import math
from decimal import getcontext
from math import factorial
from decimal import Decimal, getcontext

# this function basically just gets you 'x' decimal places in 'Decimal'
# seems to set the global scope of all decimals to get printed out with what is defined
getcontext().prec = 15

# stores in 'result' the value of 7/15
result = Decimal('7') / Decimal('15')
print(result)

result = Decimal('6') / Decimal('9')
print(result)

# pi does not follow the rules of 'getcontext()' it looks like 
# removed pi from imports

# print (Decimal(pi))

pi_input = input("How many digits of pi do you want to be displayed? ")

getcontext().prec = int(pi_input)
MAX = 10000
pi = Decimal(0)

for k in range(MAX):
    pi = pi + Decimal(math.pow(16, -k)) * (Decimal(4/(8*k+1)) - Decimal(2/(8*k+4)) - Decimal(1/(8*k+5)) - Decimal(1/(8*k+6)))

print('pi would be: ' , pi)