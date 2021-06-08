"""
    Find if a number introduced is divisible by 7.
    @version 1.0
    @author Alberto Jose Marun Indriago
"""
numero = 1 # Set the number to one (1) to make the first residual different to one.

# If the residual from the division is different to zero, keep in the while.
while numero % 7 != 0:
    print("Introduce un número")
    numero = int(input())

# When the number is divisible by seven (7) let the user know.
print("El", numero, "es divisible entre 7")