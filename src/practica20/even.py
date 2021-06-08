"""
    Find which are the Even from Zero (0) to a Number Introduced.
    @version 1.0
    @author Alberto Jose Marun Indriago
"""
# Introduce a positive number.
print("Introduce un número:")
numero = int(input())

# If the number is greater than zero (0) print which are the even numbers.
if(numero > 0):
    print("Del 0 al", numero, "están los siguiente número pares:")
    
    for x in list(range(1, numero + 1)):
        
        if x % 2 == 0:
            
            if x + 1 == numero or x == numero:
                print(x)
            else:
                print(x, end=", ")

# There are no even numbers on the negative numbers.
else:
    print("No hay numeros pares desde el zero a número negativos.")