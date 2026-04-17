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
        add(lbltitle);
        JScrollPane scroll=new JScrollPane(orderList);
        scroll.setBounds(20,220,300,400);
        add(scroll);
        details.setBounds(350,220,500,500);
        details.setFont(new Font("Arail",Font.ITALIC,30));
        details.setEditable(false);
        add(details);
        orderList.setFont(new Font("Arial",Font.PLAIN,30));
        orderList.setForeground(Color.red);
        JButton btnAdd=new JButton("New Order");
        JButton btnAddITem=new JButton("Add Item");
        JButton btnserve=new JButton("Serve");
        JButton btnpay=new JButton("Pay");
        Font font2=new Font("Arail",Font.ITALIC,30);
        btnAdd.setBounds(150,150,200,40);
        btnAddITem.setBounds(400,150,200,40);
        btnserve.setBounds(650,150,200,40);
        btnpay.setBounds(900,150,200,40);
        btnAdd.setFont(font2);
        btnAddITem.setFont(font2);
        btnserve.setFont(font2);
        btnpay.setFont(font2);

        add(btnAdd);
        add(btnAddITem);
        add(btnserve);
        add(btnpay);
        btnAdd.addActionListener(e -> {
            String tableInput = JOptionPane.showInputDialog("Enter Table Number (1-12):");

            if (tableInput != null && !tableInput.isEmpty()) {
                try {
                    int tableNum = Integer.parseInt(tableInput);
                    if (tableNum >= 1 && tableNum <= 12) {
                        orders.add(new Order(tableNum));
                        refresh();
                    } else {
                        JOptionPane.showMessageDialog(this,
                                "Error: Table number must be between 1 and 12!",
                                "Invalid Input",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this,
                            "Error: Please enter a valid numeric value!",
                            "Invalid Input",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnAddITem.addActionListener(e -> {
            int index = orderList.getSelectedIndex();
            if (index == -1) return;
            String item = JOptionPane.showInputDialog("Item Name:");
            String price = JOptionPane.showInputDialog("Price:");
            orders.get(index).addItem(item, Double.parseDouble(price));
            refresh();

        });
        btnserve.addActionListener(e -> {
            int index = orderList.getSelectedIndex();
            if (index == -1) return;
            orders.get(index).setStatus("Served");
            refresh();
        });
        btnpay.addActionListener(e -> {
            int index = orderList.getSelectedIndex();
            if (index == -1) return;
            orders.get(index).setStatus("Paid");
            refresh();
        });
        orderList.addListSelectionListener(e -> showDetails());
        refresh();
        showDetails();
    }

    private void refresh() {
        listModel.clear();
        for (Order o : orders) {
            listModel.addElement("Table " + o.getTableNum() + " - " + o.getStatus());
        }
        showDetails();
    }
    private void showDetails() {

        int index = orderList.getSelectedIndex();
        if (index == -1) return;
        Order o = orders.get(index);
        String text = "Table: " + o.getTableNum() + "\n";
        text += "Status: " + o.getStatus() + "\n\n";
        text += "Items:\n";
        for (String i : o.getItems()) {
            text += "- " + i + "\n";
        }
        text += "\nTotal: " + o.getTotal();
        details.setText(text);
    }
}
