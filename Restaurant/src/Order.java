import java.util.ArrayList;

public class Order {

    private int tablenum;
    private String status;
    private ArrayList<OrderItem> items;
    private double total;

    public Order(int tablenum) {
        this.tablenum = tablenum;
        this.status = "pending";
        this.items = new ArrayList<>();
        this.total = 0;
    }

    public int getTableNum() {
        return tablenum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<OrderItem> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }
    public void addItem(String name, int qty, double price) {
        OrderItem item = new OrderItem(name, qty, price);
        items.add(item);
        total += item.getTotal();
    }
}