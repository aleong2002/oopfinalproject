package frames;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ManageBooks extends JFrame {
    private JPanel contentPane;
    private JTextField txtTitle;
    private JTextField txtAuthor;
    private JTextField txtPublisher;
    private JTextField txtGenre;
    private JTextField txtType;
    private JButton btnAddBook;
    private JButton btnRemoveBook;
    private JButton btnCancel;
    private JList<Book> bookList;
    private Library library;

    public ManageBooks(Library library) {
        this.library = library;

        setTitle("Manage Books");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        txtTitle = new JTextField();
        txtTitle.setBounds(100, 20, 130, 26);
        contentPane.add(txtTitle);
        txtTitle.setColumns(10);

        txtAuthor = new JTextField();
        txtAuthor.setBounds(100, 60, 130, 26);
        contentPane.add(txtAuthor);
        txtAuthor.setColumns(10);

        txtPublisher = new JTextField();
        txtPublisher.setBounds(100, 100, 130, 26);
        contentPane.add(txtPublisher);
        txtPublisher.setColumns(10);

        txtGenre = new JTextField();
        txtGenre.setBounds(100, 140, 130, 26);
        contentPane.add(txtGenre);
        txtGenre.setColumns(10);

        txtType = new JTextField();
        txtType.setBounds(180, 180, 120, 26);
        contentPane.add(txtType);
        txtType.setColumns(10);

        JLabel lblTitle = new JLabel("Title");
        lblTitle.setBounds(20, 20, 80, 16);
        contentPane.add(lblTitle);

        JLabel lblAuthor = new JLabel("Author");
        lblAuthor.setBounds(20, 60, 80, 16);
        contentPane.add(lblAuthor);

        JLabel lblPublisher = new JLabel("Publisher");
        lblPublisher.setBounds(20, 100, 80, 16);
        contentPane.add(lblPublisher);

        JLabel lblGenre = new JLabel("Genre");
        lblGenre.setBounds(20, 140, 80, 16);
        contentPane.add(lblGenre);

        JLabel lblType = new JLabel("Paperback/Hardcover");
        lblType.setBounds(20, 180, 160, 16);
        contentPane.add(lblType);

        btnAddBook = new JButton("Add Book");
        btnAddBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = txtTitle.getText();
                String author = txtAuthor.getText();
                String publisher = txtPublisher.getText();
                String genre = txtGenre.getText();
                String type = txtType.getText();

                library.addBook(title, author, publisher, genre, type);
                updateBookList();
            }
        });
        btnAddBook.setBounds(250, 20, 100, 29);
        contentPane.add(btnAddBook);

        btnRemoveBook = new JButton("Remove Book");
        btnRemoveBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Book selectedBook = bookList.getSelectedValue();
                if (selectedBook != null) {
                    library.removeBook(selectedBook);
                    updateBookList();
                }
            }
        });
        btnRemoveBook.setBounds(250, 60, 130, 29);
        contentPane.add(btnRemoveBook);

        btnCancel = new JButton("Done");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnCancel.setBounds(250, 100, 100, 29);
        contentPane.add(btnCancel);

        bookList = new JList<>();
        JScrollPane bookScrollPane = new JScrollPane(bookList);
        bookScrollPane.setBounds(400, 20, 300, 230);
        contentPane.add(bookScrollPane);

        updateBookList();
    }

    private void updateBookList() {
        List<Book> books = library.getBookList();
        bookList.setCellRenderer(new BookCellRenderer());

        DefaultListModel<Book> model = new DefaultListModel<>();
        for (Book book : books) {
            model.addElement(book);
        }
        bookList.setModel(model);
    }

    private class BookCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof Book) {
                setText(((Book) value).getTitle());
            }
            return this;
        }
    }
}
