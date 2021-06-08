"""
    Tell the user to introduce his name and say hello depending on the length of his Name.
    @version 1.0
    @author Alberto Jose Marun Indriago
"""
# Tell the user to introduce his name.
print("Identificate")
name = str(input())

# Depending on the Length of the Name, say Hello in one way or another.
if(len(name) < 10):
    print("¡Hola %s!" % (name))
    
elif(len(name) >= 10 and len(name) < 15):
    print("¡Buenos Días %s!" % (name))
    
else:
    print("¡Un placer conocerle %s!" % (name))