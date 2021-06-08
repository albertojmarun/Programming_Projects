"""
    Book Program that creates a Book Class
    @version 1.0
    @author Alberto Jose Marun Indriago
"""
# BOOK CLASS
class Book:
    """
        Constructor of the Book Class.
        @param (Object) Self is the the object itself.
        @param (int) Price is the value of the book (Default value = 0).
        @param (String) Title of the Book (Default value = "").
        @param (String) Author of the Book (Default value = "").
    """
    def __init__(self, price = 0, title = "", author = ""):
        self.price = price
        self.title = title
        self.author = author
    
    """
        Copy an existing book and paste the information on the object itself.
        @param (Object) Object itself.
        @param (Book) The Book to copy the information.
    """
    def copy(self, book):
        self.price = book.price
        self.title = book.title
        self.author = book.author
    
    """
        String format of the Book.
        @param (Object) Object itself.
    """
    def __str__(self):
        return (self.title + " de " + self.author + " cuesta " + str(self.price) + " €.")

# The code below is a little demonstration of the code.
"""
libro = Book(195, "EL Sextete", "FCBARCELONA")
print(libro)

libro2 = Book()
print(libro2)

libro2.copy(libro)
print(libro2)
"""