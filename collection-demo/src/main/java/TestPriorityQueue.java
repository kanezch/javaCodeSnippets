import java.util.PriorityQueue;
import java.util.Queue;

public class TestPriorityQueue {
    public static void main(String[] args) {
        Queue<Student> studentQueue =new PriorityQueue<>();

        Student stu1 = Student.builder().age(7).name("luke").height(1.1f).build();
        Student stu2 = Student.builder().age(5).name("allen").height(1.2f).build();
        Student stu3 = Student.builder().age(6).name("wyli").height(1.3f).build();

        studentQueue.add(stu1);
        studentQueue.add(stu2);
        studentQueue.add(stu3);

        System.out.println(studentQueue.poll());
        System.out.println(studentQueue.poll());
        System.out.println(studentQueue.poll());
    }

}
