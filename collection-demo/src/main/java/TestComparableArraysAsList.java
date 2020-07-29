import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestComparableArraysAsList {

    public static void main(String[] args) {

        Student stu1 = Student.builder().age(7).name("luke").height(1.3f).build();
        Student stu2 = Student.builder().age(5).name("allen").height(1.2f).build();
        Student stu3 = Student.builder().age(6).name("wyli").height(1.25f).build();
        Student stu4 = Student.builder().age(8).name("amy").height(1.5f).build();

        Student[] students = {stu1, stu2, stu3};

        List<Student> studentList = Arrays.asList(students);
        studentList.add(stu4);

        System.out.println("Before Sort:");
        studentList.forEach(student -> System.out.println(student));

        Collections.sort(studentList);

        System.out.println("After Sort:");
        studentList.forEach(student -> System.out.println(student));
    }
}
