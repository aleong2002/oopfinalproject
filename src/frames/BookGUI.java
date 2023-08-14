package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class BookGUI extends JFrame {
	private final JPanel contentPane;
	private Library library;

	public BookGUI(Library library) {
		this.library = library;
		List<Book> books = library.getBookList();
		ArrayList<String> bookDisplay = new ArrayList<String>();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Catalog");

		// Done button
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnDone.setBounds(175, 20, 89, 29);
		contentPane.add(btnDone);

		// catalog is empty
		if (books.isEmpty()) {
			String emptyLib = "Catalog is empty.";
			JLabel EL = new JLabel(emptyLib);
			EL.setBounds(20, 60, 200, 16);
			contentPane.add(EL);
		}

		// catalog is not empty
		else {
			
			
			for (Book b : books) {
				String title = b.getTitle(); 
				bookDisplay.add(title);
				
				String author = b.getAuthor(); 
				bookDisplay.add("\n\t Author: " + author);
				
				String publisher = b.getPublisher(); 
				bookDisplay.add("\n\t Publisher: " + publisher);
				
				String genre = b.getGenre();
				bookDisplay.add("\n\t Genre: " + genre);
				
				String bookType = b.getBookType();
				bookDisplay.add("\n\t Paperback/Hardback: " + bookType);
				
				boolean avail = b.getAvailability(); 
				String availability;
				if (avail) {
					availability = "Available. 1 copy left.";
				}
				else {
					availability = "All copies in use.";
				}
				bookDisplay.add("\n\t Availability: " + availability);
				bookDisplay.add ("\n");
				
			}

		}

		// display catalog in JScrollPane
		
		JScrollPane bookScrollPane = new JScrollPane();
		bookScrollPane.setBounds(50, 85, 350, 200);
		contentPane.add(bookScrollPane);
		
		JList<String> bookList = new JList<String>(bookDisplay.toArray(new String[bookDisplay.size()]));	    
		
		bookScrollPane.setViewportView(bookList);

	}

}
