import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MemberGUI extends JFrame {
    private final JPanel contentPane;

    public MemberGUI() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setBounds(100, 100, 450, 400);
    	contentPane = new JPanel();
    	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    	setContentPane(contentPane);
    	contentPane.setLayout(null);
   
    	Member m = new Member("Name", "Email", "Phone");
    	//Name
    	String name = m.getName(); 
    	JLabel nameN = new JLabel(name);
    	nameN.setBounds(20, 30, 89, 16);
    	contentPane.add(nameN);
    	
    	//Email
    	String email = m.getEmail(); 
    	JLabel EM = new JLabel(email);
    	EM.setBounds(20, 80, 89, 16);
    	contentPane.add(EM);
    	
    	//Phone
    	String phone = m.getPhone(); 
    	JLabel PN = new JLabel(phone);
    	PN.setBounds(20, 130, 89, 16);
    	contentPane.add(PN);
    	
    	//ID
    	String id = String.valueOf(m.getID()); 
    	JLabel memid = new JLabel(id);
    	memid.setBounds(20, 180, 89, 16);
    	contentPane.add(memid);
    	
    	String books;
    	//books borrowed
    	if (m.getBorrowedBooks() != null) {
    		books = m.getBorrowedBooks().toString();
    	}
    	else {
    		books = "No books borrowed";
    	}
    	JLabel BB = new JLabel(books);
    	BB.setBounds(20, 230, 200, 16);
    	contentPane.add(BB);
    	
    }
    
}