
public class Main {
    public static LibraryGUI library = new LibraryGUI();
    public static MemberGUI member = new MemberGUI();
    public static BookGUI book = new BookGUI();

    public static void main(String[] args) {
        LibraryGUI libfrm = new LibraryGUI();
        libfrm.show();
        
        Book b = new Book("Title", "author", "publisher", "synopsis", "type");
    }
}
