package quanlithuvien;

import java.util.List;
import java.util.ArrayList;

public class Library {

    private List<Book> bookCollection = new ArrayList<>();

    // phương thức thêm sách
   public void addBooksFromInput(int index, Book book) {
    
   
    bookCollection.add(index, book); // Thêm cuốn sách tại vị trí chỉ định
    System.out.println("Added book at index " + index + ": " + book);
}


    // Phương thức để xóa sách khỏi thư viện theo ISBN
    public void removeBookByIsbn(String isbn) {
        bookCollection.removeIf(book -> book.getIsbn().equals(isbn));
    }
    // Phương thức để setup book

    public void setBook(int index, Book book) {
        
            bookCollection.set(index, book); // Thay thế cuốn sách tại vị trí chỉ định
            System.out.println("Book at index " + index + " has been updated.");
        

    }

    // phương thức để in sách
    public void printBookList() {
        System.out.println("Book list in the library:");
        for (Book book : bookCollection) {
            System.out.println(book);
        }
    }

}
