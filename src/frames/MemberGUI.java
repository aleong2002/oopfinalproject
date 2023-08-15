package frames;

import classes.Book;
import classes.Library;
import classes.Member;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MemberGUI extends JFrame {
	private final JPanel contentPane;
	private final Library library;

	public MemberGUI(Library library) {
		this.library = library;
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Members");

		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(e -> dispose());
		btnDone.setBounds(175, 20, 89, 29);
		contentPane.add(btnDone);

		JList<Member> memberList = new JList<>(library.getMemberList().toArray(new Member[0]));
		memberList.setCellRenderer(new MemberRenderer());

		JScrollPane bookScrollPane = new JScrollPane(memberList);
		bookScrollPane.setBounds(50, 85, 350, 200);
		contentPane.add(bookScrollPane);

		JLabel rb = new JLabel("Select member and enter book id: ");
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
		btnBorrowBook.addActionListener(e -> {
			String bookId = bk.getText();
			Member selectedMember = memberList.getSelectedValue();

			if (selectedMember != null) {
				Book bookToBorrow = null;
				for (Book b : library.getBookList()) {
					if (bookId.equals(String.valueOf(b.getBookId()))) {
						bookToBorrow = b;
						break;
					}
				}

				if (bookToBorrow != null) {
					String message = selectedMember.borrowBook(bookToBorrow);
					m.setText(message);
					refreshMemberList(memberList);
				}
			} else {
				m.setText("No member selected.");
			}
		});
		btnBorrowBook.setBounds(200, 360, 130, 29);
		contentPane.add(btnBorrowBook);

		JButton btnReturnBook = new JButton("Return");
		btnReturnBook.addActionListener(e -> {
			String bookId = bk.getText();
			Member selectedMember = memberList.getSelectedValue();

			if (selectedMember != null) {
				Book bookToReturn = null;
				for (Book b : selectedMember.getBorrowedBooks()) {
					if (bookId.equals(String.valueOf(b.getBookId()))) {
						bookToReturn = b;
						break;
					}
				}
				String message = selectedMember.returnBook(bookToReturn);
				m.setText(message);
			} else {
				m.setText("No member selected.");
			}
		});
		btnReturnBook.setBounds(20, 360, 130, 29);
		contentPane.add(btnReturnBook);
	}

	private void refreshMemberList(JList<Member> memberList) {
		DefaultListModel<Member> model = new DefaultListModel<>();
		for (Member m : library.getMemberList()) {
			model.addElement(m);
		}
		memberList.setModel(model);
		memberList.revalidate();
		memberList.repaint();
	}

	class MemberRenderer extends JTextArea implements ListCellRenderer<Member> {
		@Override
		public Component getListCellRendererComponent(
				JList<? extends Member> list, Member member, int index,
				boolean isSelected, boolean cellHasFocus) {

			StringBuilder sb = new StringBuilder();
			sb.append(member.getName());
			sb.append("\n\t Email: ").append(member.getEmail());
			sb.append("\n\t Phone: ").append(member.getPhone());
			sb.append("\n\t ID: ").append(member.getMemberId());
			for (Book b : member.getBorrowedBooks()) {
				sb.append("\n\t ").append(b.getTitle());
			}

			setText(sb.toString());

			if (isSelected) {
				setBackground(list.getSelectionBackground());
				setForeground(list.getSelectionForeground());
			} else {
				setBackground(list.getBackground());
				setForeground(list.getForeground());
			}

			return this;
		}
	}
}
