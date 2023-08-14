package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;



public class MemberGUI extends JFrame {
	private final JPanel contentPane;
	private Library library;

	public MemberGUI(Library library) {
		this.library = library;
		List<Member> members = library.getMemberList();
		ArrayList<String> memberDisplay = new ArrayList<String>();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Members");

		// Done button
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnDone.setBounds(175, 20, 89, 29);
		contentPane.add(btnDone);
		
		if (members.isEmpty()) {
			String noMem = "No current members.";
			JLabel NM = new JLabel(noMem);
			NM.setBounds(20, 60, 200, 16);
			contentPane.add(NM);
		}
		
		else {
			
			for (Member m : members) {
				String name = m.getName(); 
				memberDisplay.add(name);
				
				String email = m.getEmail(); 
				memberDisplay.add("\n\t Email: " + email);
				
				String phone = m.getPhone(); 
				memberDisplay.add("\n\t Phone: " + phone);
				
				String id = String.valueOf(m.getMemberId());
				memberDisplay.add("\n\t ID: " + id);
				
				if (!(m.getBorrowedBooks().isEmpty())) {
					for (Book b : m.getBorrowedBooks()) {
						memberDisplay.add("\n\t" + b.getTitle());
					}
				}
				else {
					memberDisplay.add("\n\t No books borrowed.");
				}
				
				memberDisplay.add ("\n");
				
			}

		}

		JList<String> memberList = new JList<String>(memberDisplay.toArray(new String[memberDisplay.size()]));
		
		JScrollPane bookScrollPane = new JScrollPane(memberList);
		bookScrollPane.setBounds(50, 85, 350, 200);
		contentPane.add(bookScrollPane);
		
		JLabel rb = new JLabel("Select member ID and enter book title: ");
		rb.setBounds(20, 300, 400, 16);
        contentPane.add(rb);
		
		JTextField bk = new JTextField();
		bk.setBounds(20, 320, 350, 26);
		contentPane.add(bk);
		bk.setColumns(10);
		
		JLabel m = new JLabel();
		m.setBounds(20, 390, 400, 16);
        contentPane.add(m);
		
		
		JButton btnBorrowBook = new JButton("Borrow");
		btnBorrowBook.addActionListener(new ActionListener() {
			String message;
			String book;
            public void actionPerformed(ActionEvent e) {
            	book = bk.getText();
                String memID = String.valueOf(memberList.getSelectedValue()).substring(7);
                

                for (Member mem : members) {
                	if (String.valueOf(mem.getMemberId()).equals(memID)) {
    
                		for (Book b : library.getBookList()) {
                			if (book.equals(b.getTitle())) {

                				message = mem.borrowBook(b);
                				
                				m.setText(message);;
                        		
                			}
                		}
                	}
                }
                
               
            }
        });
		btnBorrowBook.setBounds(200, 360, 130, 29);
        contentPane.add(btnBorrowBook);
		
		JButton btnReturnBook = new JButton("Return");
		btnReturnBook.addActionListener(new ActionListener() {
			String message;
			String book;
            public void actionPerformed(ActionEvent e) {
            	book = bk.getText();
            	String memID = String.valueOf(memberList.getSelectedValue()).substring(7);

                for (Member mem : members) {
                	if (String.valueOf(mem.getMemberId()).equals(memID)) {
    
                		for (Book b : mem.getBorrowedBooks()) {
                			if (book.equals(b.getTitle())) {
                				message = mem.returnBook(b);
                				
                        		break;
                               
                			}
                		}
                	}
                }
                
               
            }
        });
		btnReturnBook.setBounds(20, 360, 130, 29);
        contentPane.add(btnReturnBook);

	}

}
