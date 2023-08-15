package classes;

public class Book {

    // Variables
    private static int bookId = 1;
    private final int id;
    private final String title;
    private final String author;
    private final String publisher;
    private final String genre;
    private final String bookType;
    private boolean availability;

    // Constructor
    public Book(String title, String author, String publisher, String genre, String bookType) {
        this.id = bookId++;
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
    public int getBookId() {
        return id;
    }
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
