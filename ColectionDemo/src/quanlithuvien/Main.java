package quanlithuvien;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Create some book instances
        Book book1 = new Book("1984", "George Orwell", "123456789");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "987654321");
        Book book3 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "456789123");

        // Add books to the library
        library.addBooksFromInput(0, book1);
        library.addBooksFromInput(1, book2);
        library.addBooksFromInput(2, book3);

        // Print the current list of books
        library.printBookList();

        // Update a book
        Book book4 = new Book("Brave New World", "Aldous Huxley", "123456789");
        library.setBook(0, book4); // Replacing the first book

        // Print the updated list of books
        library.printBookList();

        // Remove a book by ISBN
        library.removeBookByIsbn("987654321");

        // Print the final list of books
        library.printBookList();
    }
}
