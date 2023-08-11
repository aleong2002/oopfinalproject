package frames;

import classes.Book;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class BookGUI extends JFrame {
    private final JPanel contentPane;

    public BookGUI() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setBounds(100, 100, 450, 400);
    	contentPane = new JPanel();
    	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    	setContentPane(contentPane);
    	contentPane.setLayout(null);

    	Book b = new Book("Title", "author", "publisher", "genre", "type");
    	//Title
    	String title = b.getTitle(); 
    	JLabel titleT = new JLabel(title);
    	titleT.setBounds(20, 30, 89, 16);
    	contentPane.add(titleT);
    	
    	//author
    	String author = b.getAuthor(); 
    	JLabel authorA = new JLabel(author);
    	authorA.setBounds(20, 80, 89, 16);
    	contentPane.add(authorA);
    	
    	//publisher
    	String publisher = b.getPublisher(); 
    	JLabel publ = new JLabel(publisher);
    	publ.setBounds(20, 130, 89, 16);
    	contentPane.add(publ);
    	
    	//genre
    	String genre = b.getGenre();
    	JLabel lblGenre = new JLabel(genre);
		lblGenre.setBounds(20, 180, 89, 16);
    	contentPane.add(lblGenre);
    	
    	//book type
    	String bookType = b.getBookType();
    	JLabel BT = new JLabel(bookType);
    	BT.setBounds(20, 230, 89, 16);
    	contentPane.add(BT);
    	
    	//get Availability
    	String avail = String.valueOf(b.getAvailability()); 
    	JLabel availability = new JLabel(avail);
    	availability.setBounds(20, 280, 89, 16);
    	contentPane.add(availability);

    }
    
}
