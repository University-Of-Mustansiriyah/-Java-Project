import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
public class StaffPanal extends JPanel
{
    JTable table;
    DefaultTableModel model;
    ArrayList<Staff> staffList = new ArrayList<>();
    public StaffPanal() {
        setLayout(null);

        staffList.add(new Staff("R1", "Ra1234", "Rahman MHD", "Chef", "Male"));
        staffList.add(new Staff("A1", "Al8356", "Ali", "Manager", "Male"));
        staffList.add(new Staff("S1", "Sa1983", "Sara", "Cashier", "Female"));
        String[] columns = {"Username", "Password", "Full Name", "Role", "Gender"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(180, 200, 900, 400);
        add(scroll);

        Font font = new Font("Arial", Font.BOLD, 40);
        Font fonttable=new Font("Arial", Font.ITALIC, 25);
        table.setRowHeight(35);
        table.setFont(fonttable);
        Font fontHeader=new Font("Arial",Font.BOLD,30);
        table.getTableHeader().setFont(fontHeader);
        table.getTableHeader().setForeground(Color.ORANGE);

        JLabel lbltitle=new JLabel("Staff Management");
        lbltitle.setBounds(450,30,400,40);
        lbltitle.setFont(font);
        lbltitle.setForeground(Color.RED);
        add(lbltitle);
        Font font2 = new Font("Arial", Font.ITALIC, 25);

        JButton btnAdd=new JButton("Add Employee");
        btnAdd.setBounds(150,100,250,40);
        btnAdd.setFocusPainted(false);
        btnAdd.addActionListener(e -> add_Employee());
        btnAdd.setFont(font2);
        add(btnAdd);

        JButton btnDelete=new JButton("Delete Employee");
        btnDelete.setBounds(500,100,250,40);
        btnDelete.setFont(font2);
        btnDelete.addActionListener(e -> deleteEmployee());
        add(btnDelete);

        JButton btnEdit=new JButton("Edit Employee");
        btnEdit.setBounds(850,100,250,40);
        btnEdit.setFont(font2);
        btnEdit.addActionListener(e ->EditEmployee());
        add(btnEdit);
        refreshTable();
    }
    private void refreshTable() {
        model.setRowCount(0);
        for (Staff s : staffList) {
            model.addRow(new Object[]{
                    s.getUsername(),
                    s.getPassword(),
                    s.getFullName(),
                    s.getRole(),
                    s.getGender()
            });
        }
    }
    private void add_Employee(){
        JFrame frame = new JFrame("Add Employee");
        frame.setSize(400, 350);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel lblUser = new JLabel("Username:");
        lblUser.setBounds(20, 20, 100, 25);
        JTextField txtUser = new JTextField();
        txtUser.setBounds(120, 20, 200, 25);

        JLabel lblPass = new JLabel("Password:");
        lblPass.setBounds(20, 60, 100, 25);
        JTextField txtPass = new JTextField();
        txtPass.setBounds(120, 60, 200, 25);

        JLabel lblName = new JLabel("Full Name:");
        lblName.setBounds(20, 100, 100, 25);
        JTextField txtName = new JTextField();
        txtName.setBounds(120, 100, 200, 25);

        JLabel lblRole = new JLabel("Role:");
        lblRole.setBounds(20, 140, 100, 25);
        String[] roles = {"Chef", "Cashier", "Manager"};
        JComboBox<String> cbRole = new JComboBox<>(roles);
        cbRole.setBounds(120, 140, 200, 25);

        JLabel lblGender = new JLabel("Gender:");
        lblGender.setBounds(20, 180, 100, 25);
        String[] genders = {"Male", "Female"};
        JComboBox<String> cbGender = new JComboBox<>(genders);
        cbGender.setBounds(120, 180, 200, 25);

        JButton btnSave = new JButton("Save");
        btnSave.setBounds(120, 230, 100, 30);

        frame.add(lblUser);
        frame.add(txtUser);
        frame.add(lblPass);
        frame.add(txtPass);
        frame.add(lblName);
        frame.add(txtName);
        frame.add(lblRole);
        frame.add(cbRole);
        frame.add(lblGender);
        frame.add(cbGender);
        frame.add(btnSave);

        btnSave.addActionListener(e -> {

            Staff s = new Staff(
                    txtUser.getText(),
                    txtPass.getText(),
                    txtName.getText(),
                    cbRole.getSelectedItem().toString(),
                    cbGender.getSelectedItem().toString()
            );

            staffList.add(s);
            refreshTable();
            frame.dispose();
        });

        frame.setVisible(true);
    }

    private void deleteEmployee() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select an employee first!");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete this employee?",
                "Confirm Delete", JOptionPane.YES_NO_OPTION
        );
        if (confirm == JOptionPane.YES_OPTION) {
            staffList.remove(selectedRow);
            refreshTable();
        }
    }
    private void EditEmployee() {

        int selected = table.getSelectedRow();

        if (selected == -1) {
            JOptionPane.showMessageDialog(this, "Select employee first!");
            return;
        }
        Staff old = staffList.get(selected);
        JFrame frame = new JFrame("Edit Employee");
        frame.setSize(400, 350);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        JTextField txtUser = new JTextField(old.getUsername());
        txtUser.setBounds(120, 20, 200, 25);
        JTextField txtPass = new JTextField(old.getPassword());
        txtPass.setBounds(120, 60, 200, 25);
        JTextField txtName = new JTextField(old.getFullName());
        txtName.setBounds(120, 100, 200, 25);
        String[] roles = {"Chef", "Cashier", "Manager"};
        JComboBox<String> cbRole = new JComboBox<>(roles);
        cbRole.setSelectedItem(old.getRole());
        cbRole.setBounds(120, 140, 200, 25);
        String[] genders = {"Male", "Female"};
        JComboBox<String> cbGender = new JComboBox<>(genders);
        cbGender.setSelectedItem(old.getGender());
        cbGender.setBounds(120, 180, 200, 25);
        JButton btnSave = new JButton("Update");
        btnSave.setBounds(120, 230, 100, 30);
        frame.add(new JLabel("Username:")).setBounds(20, 20, 100, 25);
        frame.add(txtUser);
        frame.add(new JLabel("Password:")).setBounds(20, 60, 100, 25);
        frame.add(txtPass);
        frame.add(new JLabel("Full Name:")).setBounds(20, 100, 100, 25);
        frame.add(txtName);
        frame.add(new JLabel("Role:")).setBounds(20, 140, 100, 25);
        frame.add(cbRole);
        frame.add(new JLabel("Gender:")).setBounds(20, 180, 100, 25);
        frame.add(cbGender);
        frame.add(btnSave);
        btnSave.addActionListener(e -> {
            staffList.set(selected, new Staff(
                    txtUser.getText(),
                    txtPass.getText(),
                    txtName.getText(),
                    cbRole.getSelectedItem().toString(),
                    cbGender.getSelectedItem().toString()
            ));
            refreshTable();
            frame.dispose();
        });
        frame.setVisible(true);
    }
}