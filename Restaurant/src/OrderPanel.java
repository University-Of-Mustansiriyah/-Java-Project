import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class OrderItem {
    String name;
    int qty;
    double price;

    public OrderItem(String name, int qty, double price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public double getTotal() {
        return qty * price;
    }

    @Override
    public String toString() {
        return name + " x" + qty + " = $" + getTotal();
    }
}

public class OrderPanel extends JPanel {

    ArrayList<Order> orders;

    DefaultListModel<String> listModel = new DefaultListModel<>();
    JList<String> orderList = new JList<>(listModel);

    JTextArea details = new JTextArea();
    private TablesPanel tablesPanel;

    public void setTablesPanel(TablesPanel tablesPanel) {
        this.tablesPanel = tablesPanel;
    }

    public OrderPanel() {

        orders = OrderManager.orders;

        setLayout(null);
        setBackground(Color.WHITE);

        Font font = new Font("Arial", Font.BOLD, 40);

        JLabel lbltitle = new JLabel("Table Management");
        lbltitle.setBounds(450, 30, 400, 40);
        lbltitle.setFont(font);
        lbltitle.setForeground(Color.RED);
        add(lbltitle);

        JScrollPane scroll = new JScrollPane(orderList);
        scroll.setBounds(20, 220, 300, 400);
        add(scroll);

        details.setBounds(350, 220, 500, 500);
        details.setFont(new Font("Arial", Font.ITALIC, 20));
        details.setEditable(false);
        add(details);

        orderList.setFont(new Font("Arial", Font.PLAIN, 20));
        orderList.setForeground(Color.red);

        JButton btnserve = new JButton("Serve");
        JButton btnpay = new JButton("Pay");

        btnserve.setBounds(250, 150, 200, 40);
        btnpay.setBounds(700, 150, 200, 40);

        btnserve.setFont(new Font("Arial", Font.ITALIC, 20));
        btnpay.setFont(new Font("Arial", Font.ITALIC, 20));

        add(btnserve);
        add(btnpay);

        btnserve.addActionListener(e -> {
            int index = orderList.getSelectedIndex();
            if (index == -1) return;

            orders.get(index).setStatus("Served");

            if (tablesPanel != null) {
                tablesPanel.updateTableStatus(
                        orders.get(index).getTableNum(),
                        "Empty"
                );
            }
            refresh();
        });

        btnpay.addActionListener(e -> {
            int index = orderList.getSelectedIndex();
            if (index == -1) return;

            orders.get(index).setStatus("Paid");

            if (tablesPanel != null) {
                tablesPanel.updateTableStatus(
                        orders.get(index).getTableNum(),
                        "Empty"
                );
            }
            refresh();
        });

        orderList.addListSelectionListener(e -> showDetails());
        refresh();
    }
    public void refresh() {

        listModel.clear();

        for (Order o : orders) {
            listModel.addElement(
                    "Table " + o.getTableNum() + " - " + o.getStatus() + " - $" + o.getTotal()
            );
        }

        showDetails();
    }

    private void showDetails() {

        int index = orderList.getSelectedIndex();

        if (index == -1 || index >= orders.size()) {
            details.setText("");
            return;
        }

        Order o = orders.get(index);

        String text = "";
        text += "Table: " + o.getTableNum() + "\n";
        text += "Status: " + o.getStatus() + "\n";
        text += "---------------------\n";
        text += "Items:\n";

        if (o.getItems().isEmpty()) {
            text += "No items\n";
        } else {
            for (var i : o.getItems()) {
                text += "- " + i + "\n";
            }
        }

        text += "\n---------------------\n";
        text += "TOTAL Price: " + o.getTotal();

        details.setText(text);
    }
}