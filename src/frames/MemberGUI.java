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
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

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
			JScrollPane memberScrollPane = new JScrollPane();
			memberScrollPane.setBounds(50, 85, 350, 200);
			contentPane.add(memberScrollPane);
			
			for (Member m : members) {
				String name = m.getName(); 
				memberDisplay.add(name);
				
				String email = m.getEmail(); 
				memberDisplay.add("\n\t Email: " + email);
				
				String phone = m.getPhone(); 
				memberDisplay.add("\n\t Phone: " + phone);
				
				int id = m.getMemberId();
				memberDisplay.add("\n\t ID: " + id);
				
				if (!(m.getBorrowedBooks().isEmpty())) {
					for (Book b : m.getBorrowedBooks()) {
						memberDisplay.add(b.getTitle() + ", by " + b.getAuthor());
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

	}

}
