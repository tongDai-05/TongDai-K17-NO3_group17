package qli_thuvien.src;
public class User{
    private String id;
    private String name;

    public User(String id, String name){
        this.id = id;
        this.name = name;
    }
    public void displayInfo(){
        System.out.println("["+ id +"]" + name);
    }
}