public class Staff
{
    private  String username,password,fullName,role,gender;
    public  Staff(String username,String password,String fullName,String role,String gender){

        this.username=username;
        this.password=password;
        this.fullName=fullName;
        this.role=role;
        this.gender=gender;
    }
    public String  getUsername(){
        return  username;
    }
    public  String getPassword(){
        return  password;
    }
    public  String  getRole(){
        return  role;
    }
    public  String  getGender(){
        return gender;
    }
    public  String  getFullName(){
        return  fullName;
    }
    public  void setFullName(String fullName){
        this.fullName=fullName;
    }
    public  void setUsername(String username){
        this.username=username;
    }
    public  void setPassword(String password){
        this.password=password;
    }
    public  void setRole(String role){
        this.role=role;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
}