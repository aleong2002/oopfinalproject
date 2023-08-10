public class Book {

    // Variables
    private String title;
    private String author;
    private String publisher;
    private String synopsis;
    private String bookType;
    private boolean availability;

    // Constructor
    public Book(String title, String author, String publisher, String synopsis, String bookType) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.synopsis = synopsis;
        this.bookType = bookType;
        this.availability = true; // Every book added starts as available
    }

    // Getting/Setting availability of the book
    public boolean checkAvailability() {
        return availability;
    }

    public void reserveBook() {
        this.availability = false;
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

    public String getSynopsis() {
        return synopsis;
    }

    public String getBookType() {
        return bookType;
    }
}
