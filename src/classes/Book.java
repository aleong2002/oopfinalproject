package classes;

public class Book {

    // Variables
    private String title;
    private String author;
    private String publisher;
    private String genre;
    private String bookType;
    private boolean availability;

    // Constructor
    public Book(String title, String author, String publisher, String genre, String bookType) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.genre = genre;
        this.bookType = bookType;
        this.availability = true; // Every book added starts as available
    }

    // Getting/Setting availability of the book
    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean b) {
        this.availability = b;
    }

    // Getters
    // No setters, not sure if any book information should be changed after a book is created
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getGenre() {
        return genre;
    }

    public String getBookType() {
        return bookType;
    }
}
