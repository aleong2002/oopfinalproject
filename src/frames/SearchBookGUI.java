package frames;

import classes.Book;
import classes.Library;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.ArrayList;

public class SearchBookGUI extends JFrame {
    private final JPanel contentPane;
    private final Library library;
    private final JScrollPane bookScrollPane;
    private final JLabel NR = new JLabel();

    public SearchBookGUI(Library library) {
        this.library = library;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        setTitle("Search Catalog");

        // search field
        JTextField search = new JTextField();
        search.setBounds(50, 20, 350, 26);
        contentPane.add(search);
        search.setColumns(10);

        // Add a listener to the search field to automatically update the search results
        search.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateSearchResults(search.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateSearchResults(search.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateSearchResults(search.getText());
            }
        });

        JButton btnDone = new JButton("Done");
        btnDone.addActionListener(e -> dispose());
        btnDone.setBounds(175, 50, 100, 29);
        contentPane.add(btnDone);

        bookScrollPane = new JScrollPane();
        bookScrollPane.setBounds(50, 100, 350, 200);
        contentPane.add(bookScrollPane);

        NR.setBounds(20, 80, 200, 16);
        contentPane.add(NR);

        // Show full book list when the search bar is empty
        updateSearchResults("");
    }

    private void updateSearchResults(String query) {
        ArrayList<Book> results = library.searchBook(query);
        ArrayList<String> resultsString = new ArrayList<>();

        if (results.isEmpty()) {
            NR.setText("Sorry, no results were found.");
        } else {
            NR.setText("");
            for (Book b : results) {
                resultsString.add(b.getTitle());
                resultsString.add("\n\t Author: " + b.getAuthor());
                resultsString.add("\n\t Id: " + b.getBookId());
                resultsString.add("\n\t Publisher: " + b.getPublisher());
                resultsString.add("\n\t Genre: " + b.getGenre());
                resultsString.add("\n\t Paperback/Hardback: " + b.getBookType());
                resultsString.add("\n\t Availability: " + (b.getAvailability() ? "1 copy left." : "All copies in use."));
                resultsString.add("\n");
            }
        }

        JList<String> displayList = new JList<>(resultsString.toArray(new String[0]));
        bookScrollPane.setViewportView(displayList);
    }
}
