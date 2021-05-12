"""
print("Hola mundo")

number = 3
number = "Hola"

print(number)

print("Introduzca un numero: ") # esto es un comentario de una linea
number1 = int(input())

print("Introduzca otro numero: ")
number2 = float(input())


print("El usuario ha introducido " + str(number1) + " y " + str(number2))
print("La suma de ambos es " + str(number1 + number2))

print("Introduzca su nombre completo: ")
nombre = input()

print("Hola " + nombre)

is_dark = True
is_rainy = True

print("¿Salgo a la calle? " + str(not (is_dark and is_rainy)))
"""
#Metodo para calcular la exponencial
def pow(base, exponent):
    return base**exponent

print("Introduzca la base: ")
base = int(input())
print("Introduzca el exponente: ")
exponent = int(input())

print(str(base) + "^" + str(exponent) + " es " + str(pow(base, exponent)))


def sqrt(value):
    return pow(value,0.5)

print("La raiz de " + str(base) + " es " + str(sqrt(base)))

def greeting(greet = "Buenos dias", name = "Carlos"):
    print(greet + " " + name)

greeting("Buenos tardes")

class Car:
    def __init__(self,company,price,maximum_speed):
        self.company = company
        self.price = price
        self.maximum_speed = maximum_speed

    def __str__(self):
        return "El Coche " + self.company + " puede ir a " + str(self.maximum_speed) + "km/h y cuesta " + str(self.price) + "€"
    
    def is_faster(self,other_car):
        return self.maximum_speed > other_car.maximum_speed

car1 = Car("Toyota",8000,120)
car2 = Car("Ferrari",30000,300)

print(car1)
print(car2)

if car1.is_faster(car2):
    print("El coche de " + car1.company + " es mas rapido que el coche de " + car2.company)
else:
    print("El coche de " + car1.company + " es mas lento que el coche de " + car2.company)