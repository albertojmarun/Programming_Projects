print("Introduce un número:")
numero = int(input())

print("Del 0 al", numero, "están los siguiente número pares:")

for x in list(range(1, numero + 1)):
    
    if x % 2 == 0:
        
        if x + 1 == numero or x == numero:
            print(x)
        else:
            print(x, end=", ")