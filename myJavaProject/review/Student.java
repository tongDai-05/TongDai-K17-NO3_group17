public class Student implements Comparable {
    private String name;
    private float gpa;

    public Student(String name, float gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public Student() {}

    public String getName() {
        return name;
    }

    public float getGpa() {
        return gpa;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Student)) return -1;
        Student other = (Student) o;
        if (other.gpa < gpa) return 1;
        else if (other.gpa > gpa) return -1;
        else return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Student)) return false;
        Student other = (Student) o;
        return this.gpa == other.gpa;
    }

    @Override
    public int hashCode() {
        return Float.valueOf(gpa).hashCode();
    }
}
