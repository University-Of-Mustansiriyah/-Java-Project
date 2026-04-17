public class Table {
    private  int num;
    private  String status;
    private int seats;
    public Table(int num,int seats){
        this.num=num;
        this.status="Empty";
        this.seats=seats;
    }
    public  int getNum(){
        return  num;
    }
    public  String getStatus(){
        return status;
    }
    public  void setStatus(String status){
        this.status=status;
    }
    public  int getSeats(){
        return seats;
    }
}