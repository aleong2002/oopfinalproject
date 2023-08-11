import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryGUI extends JFrame {
    private final JPanel contentPane;
    public LibraryGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
     // MemberGUI
        JButton btnMemberGUI = new JButton("Members");
        btnMemberGUI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	MemberGUI memfrm = new MemberGUI();
                memfrm.show();;
            }
        });
        btnMemberGUI.setBounds(50, 50, 150, 29);
        contentPane.add(btnMemberGUI);
        
     // BookGUI
        JButton btnBookGUI = new JButton("Books");
        btnBookGUI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	BookGUI bookfrm = new BookGUI();
                bookfrm.show();;
            }
        });
        btnBookGUI.setBounds(250, 50, 150, 29);
        contentPane.add(btnBookGUI);
        

        // Add Book
        JButton btnAddBook = new JButton("Add Book");
        btnAddBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(ABORT);
            }
        });
        btnAddBook.setBounds(50, 100, 150, 29);
        contentPane.add(btnAddBook);

        // Remove Book
        JButton btnRemoveBook = new JButton("Remove Book");
        btnRemoveBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(ABORT);
            }
        });
        btnRemoveBook.setBounds(250, 100, 150, 29);
        contentPane.add(btnRemoveBook);

        // Add Member
        JButton btnAddMember = new JButton("Add Member");
        btnAddMember.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(ABORT);
            }
        });
        btnAddMember.setBounds(50, 150, 150, 29);
        contentPane.add(btnAddMember);

        // Remove Member
        JButton btnRemoveMember = new JButton("Remove Member");
        btnRemoveMember.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(ABORT);
            }
        });
        btnRemoveMember.setBounds(250, 150, 150, 29);
        contentPane.add(btnRemoveMember);

        // Search Book
        JButton btnsearchBook = new JButton("Search Book");
        btnsearchBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(ABORT);
            }
        });
        btnsearchBook.setBounds(150, 200, 150, 29);
        contentPane.add(btnsearchBook);

        // Exit button
        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(ABORT);
            }
        });
        btnExit.setBounds(150, 250, 150, 29);
        contentPane.add(btnExit);
    }
}
