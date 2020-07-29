import java.util.*;

public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList<Student> students = new LinkedList<>();

        Student stu1 = Student.builder().age(7).name("luke").height(1.1f).build();
        Student stu2 = Student.builder().age(5).name("allen").height(1.2f).build();
        Student stu3 = Student.builder().age(6).name("wyli").height(1.3f).build();

        students.add(stu1);
        students.add(stu2);
        students.add(stu3);

        students.forEach(student -> System.out.println(student));

        System.out.println("Test AddAll operations:");

        Student stu4 = Student.builder().age(8).name("foo").height(1.4f).build();
        Student stu5 = Student.builder().age(9).name("bar").height(1.5f).build();
//        Set<Student> newSet = new HashSet<>();
//        newSet.add(stu4);
//        newSet.add(stu5);
        Queue<Student> newStudents = new PriorityQueue<Student>();
        newStudents.add(stu4);
        newStudents.add(stu5);

        students.addAll(newStudents);

        students.forEach(student -> System.out.println(student));

        System.out.println("Test remove");
        students.removeFirst();
        students.removeLast();

        students.forEach(student -> System.out.println(student));
    }
}
