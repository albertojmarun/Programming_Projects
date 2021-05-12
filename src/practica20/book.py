class Book:
    def __init__(self, price = 0, title = "", author = ""):
        self.price = price
        self.title = title
        self.author = author
    
    def copy(self, book):
        self.price = book.price
        self.title = book.title
        self.author = book.author
    
    def __str__(self):
        return (self.title + " de " + self.author + " cuesta " + str(self.price) + " €.")