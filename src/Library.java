import java.util.ArrayList;
import java.util.List;

public class Library {

    // Variables
    private List<Book> books;
    private List<Member> members;

    // Constructor
    public Library() {
        this.books = new ArrayList<>(); // Library starts with no books
        this.members = new ArrayList<>(); // Library starts with no members
    }

    // Book methods
    public void addBook(String title, String author, String publisher, String synopsis, String type) {
        Book b = new Book (title, author, publisher, synopsis, type);
        books.add(b);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public Book searchBook(String title) { // Could possibly add different ways to search (author, publisher...)
        for(Book book : books) {
            if(book.getTitle().equalsIgnoreCase(title)) { // Search is not case sensitive
                return book;
            }
        }
        return null; // Return null if no book is found with the given title (could replace with error message)
    }

    // Member methods
    public void addMember(String name, String email, String phone) {
        Member m = new Member(name, email, phone);
        members.add(m);
    }

    public void removeMember(Member member) {
        members.remove(member);
    }

    // Getters
    // No setters, these lists have their own functions to change them (above)
    public List<Book> getBookList() {
        return books;
    }

    public List<Member> getMemberList() {
        return members;
    }
}
