import java.util.ArrayList;
import java.util.Collections;

public class TestArrayListComparable {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        Student stu1 = Student.builder().age(7).name("luke").height(1.1f).build();
        Student stu2 = Student.builder().age(5).name("allen").height(1.2f).build();
        Student stu3 = Student.builder().age(6).name("wyli").height(1.3f).build();

        students.add(stu1);
        students.add(stu2);
        students.add(stu3);

        System.out.println("Before Sort:");
        students.forEach(student -> System.out.println(student));

        Collections.sort(students);

        System.out.println("After Sort:");
        students.forEach(student -> System.out.println(student));
    }
}
