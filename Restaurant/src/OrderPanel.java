import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class OrderPanel extends JPanel
{
    ArrayList<Order>orders=new ArrayList<>();
    DefaultListModel<String>listModel=new DefaultListModel<>();
    JList<String> orderList=new JList<>(listModel);

    JTextArea details=new JTextArea();
    public OrderPanel(){
        setLayout(null);
        setBackground(Color.WHITE);
        Font font = new Font("Arial", Font.BOLD, 40);
        JLabel lbltitle = new JLabel("Table Management");
        lbltitle.setBounds(450, 30, 400, 40);
        lbltitle.setFont(font);
        lbltitle.setForeground(Color.RED);
        add(lbltitle);    }

}
