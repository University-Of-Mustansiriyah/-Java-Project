import org.w3c.dom.html.HTMLLabelElement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoginFrame
{
    public  LoginFrame() {
        JFrame f = new JFrame();
        Font font = new Font("Arial", Font.BOLD, 25);
        Font font2 = new Font("Arial", Font.ITALIC, 20);

        JLabel lbltitle = new JLabel("LogIn Screen");
        JLabel lblusername = new JLabel("User Name : ");
        JLabel lblpassword = new JLabel("Password : ");
        JButton btnNote = new JButton("Dont Have An Account ?");
        JTextField txtusername = new JTextField();
        JPasswordField txtpassword = new JPasswordField();
        JButton btnLogin = new JButton("Log In ");
        btnNote.setFont(font2);
        btnNote.setBounds(20, 300, 350, 30);
        btnNote.setForeground(Color.RED);

        f.add(btnNote);

        btnLogin.setFont(font2);
        txtpassword.setFont(font2);
        txtusername.setFont(font2);
        lblpassword.setFont(font2);
        lblusername.setFont(font2);
        lbltitle.setFont(font);

        btnLogin.setBounds(135, 200, 120, 30);
        lblusername.setBounds(30, 85, 140, 25);
        lblpassword.setBounds(30, 130, 140, 25);
        lbltitle.setBounds(120, 30, 160, 30);
        txtusername.setBounds(150, 85, 150, 30);
        txtpassword.setBounds(150, 130, 150, 30);

        lbltitle.setForeground(Color.RED);

        f.add(btnLogin);
        f.add(txtusername);
        f.add(txtpassword);
        f.add(lblpassword);
        f.add(lblusername);
        f.add(lbltitle);

        btnNote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new Sign_inFrame();
            }
        });
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setSize(400, 400);
        f.setTitle("Login Frame");
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setVisible(true);


    }
}