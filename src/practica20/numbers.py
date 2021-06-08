"""
    Let the user introduce two numbers, and then make the principal mathematical operations with them.
    @version 1.0
    @author Alberto Jose Marun Indriago
"""
# Introduce the First Number to Operate.
print("Introduce the first number")
first_number = int(input())

# Introduce the Second Number to Operate.
print("Introduce the second number")
second_number = int(input())

# Let the user knows which are the introduced numbers.
print("Numeros:")
print(str(first_number), " y ", str(second_number))

# Print Sum of both numbers.
print("Suma (%d + %d) = %d" % (first_number, second_number, (first_number + second_number)))

# Print substraction of both numbers.
print("Resta (%d - %d) = %d" % (first_number, second_number, (first_number - second_number)))

# Print multiplication of both numbers.
print("Multiplicacion (%d * %d) = %d" % (first_number, second_number, (first_number * second_number)))

# Print division of both numbers.
print("Division (%d / %d) = %d" % (first_number, second_number, (first_number / second_number)))