import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ManageMembers extends JFrame{
	private JPanel contentPane;
    private JTextField txtName;
    private JTextField txtEmail;
    private JTextField txtPhone;
    private JButton btnAddMember;
    private JButton btnRemoveMember;
    private JButton btnCancel;
    private JList<Book> borrowedBooks;
    private JList<Member> membersList;
    private Library library;
    private Member member;
    
    public ManageMembers(Library library) {
        this.library = library;

        setTitle("Manage Members");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        txtName = new JTextField();
        txtName.setBounds(100, 20, 130, 26);
        contentPane.add(txtName);
        txtName.setColumns(10);

        txtEmail = new JTextField();
        txtEmail.setBounds(100, 60, 130, 26);
        contentPane.add(txtEmail);
        txtEmail.setColumns(10);

        txtPhone = new JTextField();
        txtPhone.setBounds(100, 100, 130, 26);
        contentPane.add(txtPhone);
        txtPhone.setColumns(10);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(20, 20, 80, 16);
        contentPane.add(lblName);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(20, 60, 80, 16);
        contentPane.add(lblEmail);

        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(20, 100, 80, 16);
        contentPane.add(lblPhone);

        btnAddMember = new JButton("Add Member");
        btnAddMember.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText();
                String email = txtEmail.getText();
                String phone = txtPhone.getText();

                library.addMember(name, email, phone);
                updateMembersList();
            }
        });
        btnAddMember.setBounds(250, 20, 140, 29);
        contentPane.add(btnAddMember);

        btnRemoveMember = new JButton("Remove Member");
        btnRemoveMember.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Member selectedMember = membersList.getSelectedValue();
                if (selectedMember != null) {
                    library.removeMember(selectedMember);
                    updateMembersList();
                }
            }
        });
        btnRemoveMember.setBounds(250, 60, 140, 29);
        contentPane.add(btnRemoveMember);

        btnCancel = new JButton("Done");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnCancel.setBounds(250, 100, 100, 29);
        contentPane.add(btnCancel);

        membersList = new JList<>();
        JScrollPane bookScrollPane = new JScrollPane(membersList);
        bookScrollPane.setBounds(400, 20, 300, 230);
        contentPane.add(bookScrollPane);

        updateMembersList();
    }

    private void updateMembersList() {
        List<Member> members = library.getMemberList();
        membersList.setCellRenderer(new MemberCellRenderer());

        DefaultListModel<Member> model = new DefaultListModel<>();
        for (Member member : members) {
            model.addElement(member);
        }
        membersList.setModel(model);
    }

    private class MemberCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof Member) {
                setText(((Member) value).getName());
            }
            return this;
        }
    }
    
}
