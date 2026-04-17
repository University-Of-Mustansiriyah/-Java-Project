import java.util.ArrayList;

public class Order
{
    private  int tablenum;
    private String  status;
    private ArrayList<String>items;
    private double total;
    public Order(int totalnum){
        this.tablenum =totalnum;
        this.status="pending";
        this.items=new ArrayList<>();
        this.total=0;
    }
    public  int getTableNum(){
        return tablenum;
    }
    public  String getStatus(){
        return  status;
    }
    public void setStatus(String  status){
        this.status=status;
    }
    public ArrayList<String>getItems(){
        return items;
    }
    public double getTotal(){
        return total;
    }
    public void addItem(String item,double price){
        items.add(item);
        total+=price;
    }
}
