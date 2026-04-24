import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sign_inFrame
{
    public  Sign_inFrame(){

        JFrame f=new JFrame();
        Font font=new Font("Arial",Font.BOLD,25);
        Font font2=new Font("Arial",Font.ITALIC,20);
        JLabel lbltitle=new JLabel("Sign In Screen");
        JLabel lblFullName=new JLabel("Full Name : ");
        JLabel lblusername=new JLabel("User Name : ");
        JLabel lblpassword=new JLabel("Password : ");
        JTextField txtFullname=new JTextField();
        JTextField txtusername=new JTextField();
        JPasswordField txtpassword=new JPasswordField();
        JButton btnSignIn=new JButton("Sign In ");
        JButton btnNote=new JButton("Already Have An Account ?");

        btnNote.setFont(font2);
        txtFullname.setFont(font2);
        lblFullName.setFont(font2);
        btnSignIn.setFont(font2);
        txtpassword.setFont(font2);
        txtusername.setFont(font2);
        lblpassword.setFont(font2);
        lblusername.setFont(font2);
        lbltitle.setFont(font);

        btnNote.setBounds(20,300,350,30);
        btnSignIn.setBounds(135,250,120,30);
        lblFullName.setBounds(30,85,140,25);
        lblusername.setBounds(30,130,140,25);
        lblpassword.setBounds(30,175,140,25);
        lbltitle.setBounds(100,30,200,30);
        txtFullname.setBounds(150,85,150,30);
        txtusername.setBounds(150,130,150,30);
        txtpassword.setBounds(150,175,150,30);

        btnNote.setForeground(Color.RED);
        lbltitle.setForeground(Color.RED);

        f.add(btnNote);
        f.add(lblFullName);
        f.add(txtFullname);
        f.add(btnSignIn);
        f.add(txtusername);
        f.add(txtpassword);
        f.add(lblpassword);
        f.add(lblusername);
        f.add(lbltitle);
        btnSignIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String fullName = txtFullname.getText().trim();
                String username = txtusername.getText().trim();
                String password = new String(txtpassword.getPassword()).trim();
                if (fullName.isEmpty() || username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(f, "Please fill all fields!");
                    return;
                }
                for (Staff s : StaffPanal.staffList) {
                    if (s.getUsername().equals(username)) {
                        JOptionPane.showMessageDialog(f, "Username already exists!");
                        return;
                    }
                }
                Staff newStaff = new Staff(username, password, fullName, "Cashier", "Male");
                StaffPanal.staffList.add(newStaff);
                JOptionPane.showMessageDialog(f, "Account created successfully!");
                f.dispose();
                new LoginFrame();
            }
        });
        btnNote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new LoginFrame();
            }
        });

        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setSize(400,400);
        f.setTitle("Sign In Frame");
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setVisible(true);
    }
}