package frames;

import classes.Book;
import classes.Library;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;
import javax.swing.*;

public class SearchBookGUI extends JFrame{
    private final JPanel contentPane;
    private final Library library;
    private JList<Book> bookList;

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

        // Done button
        JButton btnDone = new JButton("Done");
        btnDone.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnDone.setBounds(235, 50, 100, 29);
        contentPane.add(btnDone);

        JScrollPane bookScrollPane = new JScrollPane();
        bookScrollPane.setBounds(50, 100, 350, 200);
        contentPane.add(bookScrollPane);

        // search button
        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(115, 50, 100, 29);
        contentPane.add(btnSearch);


        JLabel NR = new JLabel();
        NR.setBounds(20, 80, 200, 16);
        contentPane.add(NR);

        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<Book> results = library.searchBook(search.getText());
                ArrayList<String> resultsString = new ArrayList<>();

                if (results.isEmpty()) {
                    String noResults = "Sorry, no results were found.";
                    NR.setText(noResults);
                }
                else {
                    for (Book b : results) {
                        String title = b.getTitle();
                        resultsString.add(title);

                        String author = b.getAuthor();
                        resultsString.add("\n\t Author: " + author);

                        String publisher = b.getPublisher();
                        resultsString.add("\n\t Publisher: " + publisher);

                        String genre = b.getGenre();
                        resultsString.add("\n\t Genre: " + genre);

                        String bookType = b.getBookType();
                        resultsString.add("\n\t Paperback/Hardback: " + bookType);

                        boolean avail = b.getAvailability();
                        String availability;
                        if (avail) {
                            availability = "Available. 1 copy left.";
                        }
                        else {
                            availability = "All copies in use.";
                        }
                        resultsString.add("\n\t Availability: " + availability);
                        resultsString.add ("\n");

                    }

                    JList<String> displayList = new JList<String>(resultsString.toArray(new String[resultsString.size()]));
                    bookScrollPane.setViewportView(displayList);

                }

            }
        });

    }

}