package frames;

import classes.Book;
import classes.Library;

public class Main {
    public static Library library = new Library();

    public static void main(String[] args) {
        LibraryGUI libfrm = new LibraryGUI();
        libfrm.show();
        
        Book b = new Book("Title", "author", "publisher", "synopsis", "type");
    }
}
