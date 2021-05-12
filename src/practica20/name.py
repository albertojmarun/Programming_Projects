print("Identificate")
name = str(input())

print(name)

if(len(name) < 10):
    print("¡Hola %s!" % (name))
elif(len(name) >= 10 and len(name) < 15):
    print("¡Buenos Días %s!" % (name))
else:
    print("¡Un placer conocerle %s!" % (name))