def isPrimeNumber( numero ):
    for x in range(2, numero):
        
        if numero % x == 0:
            return False
        
    return True

for x in range(3):
    print("Introduce un número:")
    number = int(input())
    
    if isPrimeNumber(number):
        print("Es primo.")
    else:
        print("No es primo.")