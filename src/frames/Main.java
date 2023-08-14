package frames;

import classes.Library;

public class Main {
    public static Library library = new Library();

    public static void main(String[] args) {
        LibraryGUI libfrm = new LibraryGUI();
        libfrm.show();
    }
}
