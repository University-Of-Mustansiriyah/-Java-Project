import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class OrderManager {
    public static ArrayList<Order> orders = new ArrayList<>();
}

public class FoodPanel extends JPanel {

    ArrayList<Food> foodList = new ArrayList<>();
    JPanel foodContainer;
    private OrderPanel orderPanel;
    public void setOrderPanel(OrderPanel orderPanel) {
        this.orderPanel = orderPanel;
    }
    private TablesPanel tablesPanel;
    public void setTablesPanel(TablesPanel tablesPanel) {
        this.tablesPanel = tablesPanel;
    }
    public FoodPanel() {

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        foodContainer = new JPanel();
        foodContainer.setLayout(new GridLayout(0, 4, 20, 20));
        foodContainer.setBackground(Color.WHITE);


        JScrollPane scroll = new JScrollPane(foodContainer);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        scroll.setBorder(null);

        add(scroll, BorderLayout.CENTER);
        foodContainer.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        loadData();
        drawFoods();
    }

    private void loadData() {

        foodList.add(new Food("F1","Burger","Meal",5.5,true,"/Images/burger.jpg"));
        foodList.add(new Food("F2","Pizza","Meal",7.0,true,"/Images/pizza.jpg"));
        foodList.add(new Food("F3","Fries","Meal",3.0,true,"/Images/fries.jpg"));
        foodList.add(new Food("F4","Shawarma","Meal",6.0,true,"/Images/shawarma.jpg"));
        foodList.add(new Food("F5","Steak","Meal",12.0,true,"/Images/steak.jpg"));
        foodList.add(new Food("F6","Coffee","Drink",2.5,true,"/Images/coffee.jpg"));
        foodList.add(new Food("F7","Tea","Drink",1.5,true,"/Images/tea.jpg"));
        foodList.add(new Food("F8","Cola","Drink",2.0,true,"/Images/cola.jpg"));
        foodList.add(new Food("F9","Juice","Drink",3.0,true,"/Images/juice.jpg"));
        foodList.add(new Food("F10","Pasta","Meal",8.0,true,"/Images/pasta.jpg"));
        foodList.add(new Food("F11","Cake","Dessert",3.5,true,"/Images/cake.jpg"));
        foodList.add(new Food("F12","Salad","Meal",4.5,true,"/Images/salad.jpg"));
        foodList.add(new Food("F13","Milkshake","Drink",3.5,true,"/Images/milkshake.jpg"));
    }

    private void drawFoods() {

        foodContainer.removeAll();

        for (Food food : foodList) {
            foodContainer.add(createFoodCard(food));
        }

        foodContainer.revalidate();
        foodContainer.repaint();
    }

    private JPanel createFoodCard(Food food) {

        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        card.setBackground(Color.WHITE);

        ImageIcon icon = new ImageIcon(getClass().getResource(food.getImage()));
        Image img = icon.getImage().getScaledInstance(180, 120, Image.SCALE_SMOOTH);
        JLabel imgLabel = new JLabel(new ImageIcon(img));
        imgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel name = new JLabel(food.getName());
        JLabel price = new JLabel("$" + food.getPrice());
        JLabel category = new JLabel(food.getCategory());

        name.setAlignmentX(Component.CENTER_ALIGNMENT);
        price.setAlignmentX(Component.CENTER_ALIGNMENT);
        category.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton addBtn = new JButton("Add");
        addBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        addBtn.addActionListener(e -> {

            JTextField qtyField = new JTextField();

            String[] typeOptions = {"Dine In", "Take Away"};
            JComboBox<String> typeBox = new JComboBox<>(typeOptions);

            String[] tables = new String[12];
            for (int i = 0; i < 12; i++) {
                tables[i] = String.valueOf(i + 1);
            }
            JComboBox<String> tableBox = new JComboBox<>(tables);

            JPanel panel = new JPanel(new GridLayout(0,1));
            panel.add(new JLabel("Food: " + food.getName()));
            panel.add(new JLabel("Quantity:"));
            panel.add(qtyField);
            panel.add(new JLabel("Type:"));
            panel.add(typeBox);
            panel.add(new JLabel("Table (if Dine In):"));
            panel.add(tableBox);

            int result = JOptionPane.showConfirmDialog(
                    this,
                    panel,
                    "Add Item",
                    JOptionPane.OK_CANCEL_OPTION
            );

            if (result == JOptionPane.OK_OPTION) {

                int qty;

                try {
                    qty = Integer.parseInt(qtyField.getText());

                    if (qty <= 0) {
                        JOptionPane.showMessageDialog(this, "Quantity must be greater than 0!");
                        return;
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid number!");
                    return;
                }

                String type = (String) typeBox.getSelectedItem();

                int table = -1;

                if (type.equals("Dine In")) {
                    table = Integer.parseInt((String) tableBox.getSelectedItem());

                    if (tablesPanel != null) {
                        tablesPanel.updateTableStatus(table, "Busy");
                    }
                }

                Order order = findOrCreateOrder(table);
                order.addItem(food.getName(), qty, food.getPrice());

                if (orderPanel != null) {
                    orderPanel.refresh();
                }

                JOptionPane.showMessageDialog(this, "Item Added Successfully!");
            }
        });

        card.setPreferredSize(new Dimension(200, 260));
        card.add(Box.createVerticalStrut(10));
        card.add(imgLabel);
        card.add(Box.createVerticalStrut(10));
        card.add(name);
        card.add(price);
        card.add(category);
        card.add(Box.createVerticalStrut(10));
        card.add(addBtn);

        return card;
    }

    private Order findOrCreateOrder(int table) {

        for (Order o : OrderManager.orders) {
            if (o.getTableNum() == table && o.getStatus().equals("pending")) {
                return o;
            }
        }

        Order newOrder = new Order(table);
        OrderManager.orders.add(newOrder);
        return newOrder;
    }
}