"""
    Investigation Program: Binary and Text Files.
    @version 1.0
    @author Alberto Jose Marún Indriago
"""

# The pickle class is imported.
import pickle

"""
    Person Class
"""
class Persona:
    """
        Initialize the Persona class.
        @param self The class itself.
        @param nombre (String) Name of the Person.
        @param apellido (String) Last Name of the Person.
        @param edad (int) Age of the Person.
    """
    def __init__(self, nombre = "", apellido = "", edad = 0):
        self.nombre = nombre;
        self.apellido = apellido;
        self.edad = edad;
    
    """
        Converts in string format the variable.
        @param self Indicates the object itself.
    """
    def __str__(self):
        return (self.nombre + " - " + self.apellido + " - " + str(self.edad) + "\n")
    
    """
        Convert from a string to a Person.
        @param self (Object) The class.
        @param person_string (String) 
    """
    def conversion(self, person_string):
        information = person_string.split(" - ")
        self.nombre = information[0]
        self.apellido = information[1]
        self.edad = information[2]

"""
    Select the Type of File the program is going to open
    The two options are Binary and Text Files.
"""
def selectTypeFile():
    file_type = -1
    
    print("Hey, Welcome to MEDAC FILE MANAGER:")
    print("Which type of File you want to open?")
    print("[0] Binary File")
    print("[1] Text File")
    print("Introduce your option:", end=" ")
    
    file_type = int(input())
    
    while file_type != 0 and file_type != 1:
        print("\nIncorrect option. Please select one of the above.")
        print("[0] Binary File")
        print("[1] Text File")
        print("Introduce your option:", end=" ")
        file_type = int(input())
    
    if(file_type == 1):
        file_type = ""
        
    elif(file_type == 0):
        file_type = "b"
        
    return file_type

"""
    Select the name of the file, and if the name of the file doesn't include the extension, added.
    @param type (String) Type of the file (Binary or Text File).
"""
def selectFileName(type):
    print("Introduce the name of the file:", end=" ")
    file_name = str(input())
    
    if(not(file_name.endswith(".txt")) and type == ""):
        file_name += ".txt"
    
    elif(not(file_name.endswith(".bin")) and type == "b"):
        file_name += ".bin"
    
    return file_name

"""
    Select the file to operate on the Program.
"""
def readFile(file_name, type):
    file = open(file_name, ( "a" + type + "+"))
    file.seek(0, 0)
    people = []
    
    if(type == ""):
        lines = file.read().splitlines()
        
        for line in lines:
            persona = Persona()
            persona.conversion(line)
            people.append(persona)
        
        file.close()
    
    if(type == "b"):
        while 1:
            try:
                people = pickle.load(file)
            except (EOFError):
                break
        
        file.close()

    return people

"""
    Print the Student List Menu
"""
def printMenu():
    print("_____________________________________")
    print("\nWelcome to the Students List:")
    print("[0] See the Actual Students List.")
    print("[1] Add another Student.")
    print("[2] Remove an Student.")
    print("[3] Clear the Student List.")
    print("[4] Save changes.")
    print("[5] Turn Off.")
    print("Introduce the option:", end=" ")
    return int(input())

"""
    See the Actual Student List.
    @param people (List) Student List registered.
"""
def showStudentList(people):
    
    if(len(people) > 0):
        print("\nStudent List of MEDAC")
        for person in people:
            print("\t%s" % str(person), end="")
    else:
        print("\nThe student List is empty, please add an Student.")
"""
    Add a new Student to the List.
    @param people (List) Student list from a file, to add a new student at the end.
"""
def addNewStudent(people):
    print("\nCongratulations for the New Student!")
    persona = Persona()
    
    print("\tIntroduce the First Name:", end=" ")
    persona.nombre = str(input())
    
    print("\tIntroduce the Last Name:", end=" ")
    persona.apellido = str(input())
    
    print("\tIntroduce the Age:", end=" ")
    persona.edad = str(input())
    
    print("NEW STUDENT INFORMATION: %s" % persona, end="")
    people.append(persona)

"""
    Add a new Student from the List.
    @param people (List) Student list from a file, to remove an student.
"""
def removeAnStudent(people):
    count = 0
    print("\nStudent List to Remove:")
    print("If you don't want to remove a Student, type a negative number")
    
    for person in people:
        print("\t- [%d] %s" % (count, str(person)), end="")
        count += 1
        
    print("Introduce the Index of the Student to remove:", end=" ")
    index = int(input())
        
    while (index >= len(people)):
        print("Incorrect index, introduce a valid index.")
        print("Introduce the Index of the Student to remove:", end=" ")
        index = int(input())
        
    if(index >= 0 and index < len(people)):
        people.pop(index)
        print("Student removed", end="")

"""
    Clear the Student List from the program.
    @param (List) Student List.
"""
def clearStudentList(people):
    print("\nAre you sure that you want to clear the list?")
    print("If you are sure, introduce 1:", end =" ")
    clear = int(input())
        
    if clear == 1:
        print("You already clear the List.")
        people.clear()
    else:
        print("You introduce something different to 1. The List won't be cleared.")

"""
    Write the List into the specified file.
    @param people (List) Student List.
    @param file_name (String) Route of the File.
    @param file_type (String) Type of the File: Binary or Text.
"""
def writeStudentList(people, file_name, file_type):
    file = open(file_name, ("w" + file_type))
    
    if(file_type == ""):
        for person in people:
            file.write(str(person))
    elif(file_type == "b"):
        pickle.dump(people, file)
    
    print("\nThe Student List is saved!")
    print("File Name: %s" % file_name)
    file.close()

"""
    Say Good Bye to the User.
"""
def sayGoodBye():
    print("Thank you! See you later.\n")
    exit()

"""
    Pause on the execution of the Program.
"""
def pressEnter():
    print("\nPress enter to next.", end=" ")
    str(input())

# Investigation Program Demonstration.
file_type = selectTypeFile()
file_name = selectFileName(file_type)

people = readFile(file_name, file_type)

option = printMenu()
while option >= 0 and option <= 5:
    while not(option >= 0 and option <= 5):
        print("ERROR: Introduce option doesn't exist.")
        option = printMenu()

    if option == 0:
        showStudentList(people)

    if option == 1:
        addNewStudent(people)

    if option == 2:
        removeAnStudent(people)

    if option == 3:
        clearStudentList(people)

    if option == 4:
        writeStudentList(people, file_name, file_type)
    
    if option == 5:
        sayGoodBye()
    
    pressEnter()
    option = printMenu()