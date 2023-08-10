import java.util.ArrayList;
import java.util.List;

public class Member {

    // Variables
    private int memberId;
    private String name;
    private String email;
    private String phone;
    private List<Book> borrowedBooks;

    // Constructor
    public Member(int memberId, String name, String email, String phone) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.borrowedBooks = new ArrayList<>(); // Every member added starts with no books
    }

    // Getting/Setting availability of the book
    public void borrowBook(Book book) {
        if(book.checkAvailability()) { // Making sure book is available
            book.reserveBook(); // Setting the book to be unavailable
            borrowedBooks.add(book);
        } else {
            System.out.println("Book is not available for borrowing.");
        }
    }

    public void returnBook(Book book) {
        if(borrowedBooks.contains(book)) { // Making sure the book was already borrowed
            borrowedBooks.remove(book);
            book.reserveBook(); // Setting the book to be available again
        }
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Getters
    // No setters, not sure if any member information should be changed after a member is created
    public int getMemberId() {
        return memberId;
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
