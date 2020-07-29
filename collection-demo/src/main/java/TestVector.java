import java.util.Enumeration;
import java.util.Vector;

public class TestVector {
    public static void main(String[] args) {
        Vector<Student> students = new Vector<>();

        Student stu1 = Student.builder().age(7).name("luke").height(1.1f).build();
        Student stu2 = Student.builder().age(5).name("allen").height(1.2f).build();
        Student stu3 = Student.builder().age(6).name("wyli").height(1.3f).build();

        students.add(stu1);
        students.add(stu2);
        students.add(stu3);

        students.forEach(student -> System.out.println(student));

        Enumeration enumeration = students.elements();
        while (enumeration.hasMoreElements()){
            Student stu  = (Student) enumeration.nextElement();
            System.out.println("Find:"+stu);
            students.remove(stu); //so it is dangerous to remove elements in iteration
        }
        System.out.println("After remove:");
        students.forEach(student -> System.out.println(student));
    }
}
