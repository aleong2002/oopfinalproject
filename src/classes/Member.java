package classes;

import java.util.ArrayList;
import java.util.List;

public class Member {

    // Variables
    private static int memberId = 1;
    private final int id;
    private String name;
    private String email;
    private String phone;
    private List<Book> borrowedBooks;

    // Constructor
    public Member(String name, String email, String phone) {
        this.id = memberId++;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.borrowedBooks = new ArrayList<>(); // Every member added starts with no books
    }

    // Getting/Setting availability of the book
    public String borrowBook(Book book) {
        if(book.getAvailability()) { // Making sure book is available
            book.setAvailability(false); // Setting the book to be unavailable
            borrowedBooks.add(book);
            return ("Book borrowed successfully.");
        } else {
            return ("Book is not available for borrowing.");
        }
    }

    public String returnBook(Book book) {
        if(borrowedBooks.contains(book)) { // Making sure the book was already borrowed
            borrowedBooks.remove(book);
            book.setAvailability(true); // Setting the book to be available again
            return ("Book returned successfully.");
        }
        return ("Book has not been borrowed.");
        
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Getters
    // No setters, not sure if any member information should be changed after a member is created
    public int getMemberId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
