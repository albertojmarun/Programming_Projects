print("Introduce los segundos de un tiempo:")
seconds = int(input())

minutes = int( seconds / 60)

seconds = int(seconds % 60)

hours = int(minutes / 60)

minutes = int( minutes % 60)

days = int(hours / 24)

hours = int(hours % 24)

if days >= 1:
    print(days, "día", end="")
    if days > 1:
        print("s", end="")
    print(" ", end="")

if hours >= 1:
    print(hours, "hora", end="")
    if hours > 1:
        print("s", end="")
    print(" ", end="")

if minutes >= 1:
    print(minutes, "minuto", end="")
    if minutes > 1:
        print("s", end="")
    print(" ", end="")

if seconds >= 1:
    print(seconds, "segundo", end="")
    if seconds > 1:
        print("s", end="")

print("\n")