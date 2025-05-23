import java.lang.reflect.Array;
import java.util.ArrayList;

public class StudentList{
    ArrayList<Student> st= new ArrayList<Student>(); //tạo một danh sách
    public ArrayList<Student> addStudent(Student stu){
        st.add(stu);
        return st;
    }
    public ArrayList<Student> getEditStudent(String fullname, int studentID){ // sửa 
        for(int i=0;i<st.size();i++){
            if(st.get(i).StudentId==studentID){
                System.out.print("true");
                st.get(i).fullname=fullname;
            }
        }
        return st;
    }
}
