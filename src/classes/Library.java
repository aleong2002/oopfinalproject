package classes;

import classes.Book;

import java.util.ArrayList;
import java.util.List;

public class Library {

    // Variables
    private List<Book> books;
    private List<Member> members;

    // Constructor
    public Library() {
        this.books = new ArrayList<>(); // classes.Library starts with no books
        this.members = new ArrayList<>(); // classes.Library starts with no members
    }

    // classes.Book methods
    public void addBook(String title, String author, String publisher, String genre, String type) {
        Book b = new Book (title, author, publisher, genre, type);
        books.add(b);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public ArrayList searchBook(String search) { 
    	ArrayList<Book> results = new ArrayList<>();
        for(Book book : books) {
            if(book.getTitle().contains(search)) { // Search is not case sensitive
                results.add(book);
            }
            else if (book.getAuthor().contains(search)) { // Search is not case sensitive
            	results.add(book);
            }
            else if (book.getPublisher().contains(search)) { // Search is not case sensitive
            	results.add(book);
            }
            else if (book.getGenre().contains(search)) { // Search is not case sensitive
            	results.add(book);
            }
        }
        return results; // Return null if no book is found with the given title (could replace with error message)
    }

    // classes.Member methods
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
