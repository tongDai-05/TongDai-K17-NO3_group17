import java.util.*;

public class TestStudent {
    public static void main(String[] args) {
        Student s1 = new Student("Fred", 3.0F);
        Student s2 = new Student("Sam", 3.5F);
        Student s3 = new Student("Steve", 2.1F);

        // So sánh GPA giữa s3 và s2
        if (s3.compareTo((Object) s2) < 0)
            System.out.println(s3.getName() + " has a lower GPA than " + s2.getName());

        // Tạo TreeSet và thêm sinh viên vào
        Set studentSet = new TreeSet();
        studentSet.add(s1);
        studentSet.add(s2);
        studentSet.add(s3);

        // Duyệt qua Set bằng Iterator
        Iterator i = studentSet.iterator();
        System.out.println("Students sorted by GPA:");
        while (i.hasNext())
            System.out.println(((Student) i.next()).getName());
    }
}
