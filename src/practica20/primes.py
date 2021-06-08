"""
    Program that have a function that analyze if a number is prime or not and a demonstration of it.
    @version 1.0
    @author Alberto Jose Marun Indriago
"""

"""
    Function that recibes a number, and returns if it is prime (True) or not (false).
    @param numero (int) Number to analyze if it is prime or not.
"""
def isPrimeNumber( numero ):
    for x in range(2, numero):
        
        if numero % x == 0:
            return False
        
    return True

# Demonstratation of code that ask the user 3 Numbers and tells him if it is prime or not.
for x in range(3):
    print("Introduce un número:")
    number = int(input())
    
    if isPrimeNumber(number):
        print("Es primo.")
    else:
        print("No es primo.")