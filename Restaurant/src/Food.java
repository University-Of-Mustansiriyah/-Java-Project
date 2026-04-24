public class Food {

    private  String id, name,category,imagePath;
    private  double price;
    private  boolean available;

    public  Food(String id,String name,String category,double price,boolean available,String imagePath){
        this.id=id;
        this.name=name;
         this.category=category;
         this .price=price;
         this .available=available;
         this.imagePath=imagePath;
    }
    public  String getName() {
        return name;
    }

    public  String getId(){
        return  id;
    }
    public  double getPrice(){
        return  price;
    }
    public  String getCategory(){
        return  category;
    }
    public  boolean isAvailable(){
        return  available;
    }
    public  String getImage(){
        return  imagePath;
    }
    public  void setId(String id){
        this.id=id;
    }
    public  void setName(String name){
        this.name=name;
    }
    public  void  setCategory(String category){
        this.category=category;
    }
    public  void setPrice(double price){
        this.price=price;
    }
    public  void setAvailable(boolean isAvailable){
        this .available=isAvailable;
    }
    public  void setImage(String imagePath){
        this.imagePath=imagePath;
    }
}
