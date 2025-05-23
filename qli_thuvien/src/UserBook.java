package qli_thuvien.src;
import java.util.ArrayList;

public class UserBook{
    ArrayList<Book> list= new ArrayList<Book>();
    public ArrayList<Book> addBook(Book ub){
        list.add(ub);
        return list;
    }

    //cac em dang truy cap qua bien nen bien trong Book de public, con khong phai truy cap qua phuong thuc
    
    public ArrayList<Book> getEditBook(String masach,String tensach ){
        for(int i=0; i < list.size(); i++){
            if(list.get(i).masach == masach){
                System.out.print("true");
                list.get(i).tensach= tensach; 
            }
            
        }
        return list;
    }
    public ArrayList<Book> getDeleBook(String masach){
        for(int i=0; i< list.size(); i++){
            if(list.get(i).masach == MaSach){
            list.remove(i);
        }
      } return list;
    }
   
public void printUserBook(){
    int len = list.size();
    for(int i=0; i< len; i++){
        System.out.println("[" +list.get(i).masach + "]" +list.get(i).tensach+ "-" + trangthai);
    }
 }
}
