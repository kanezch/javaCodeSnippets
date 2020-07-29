import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestArrayListComparator {

    private static class StudentAgeComparator implements Comparator{
        @Override
        public int compare(Object o1, Object o2) {
            Student stu1 = (Student)o1;
            Student stu2 = (Student)o2;
            return stu1.age - stu2.age;
        }
    }

    private static class StudentHeightComparator implements Comparator{
        @Override
        public int compare(Object o1, Object o2) {
            Student stu1 = (Student)o1;
            Student stu2 = (Student)o2;
            if (stu1.height - stu2.height > 0){
                return 1;
            }else if (stu1.height - stu2.height == 0){
                return 0;
            }else{
                return -1;
            }
        }
    }
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        Student stu1 = Student.builder().age(7).name("luke").height(1.3f).build();
        Student stu2 = Student.builder().age(5).name("allen").height(1.2f).build();
        Student stu3 = Student.builder().age(6).name("wyli").height(1.1f).build();

        students.add(stu1);
        students.add(stu2);
        students.add(stu3);

        System.out.println("Before Sort:");
        students.forEach(student -> System.out.println(student));

        Collections.sort(students, new StudentHeightComparator());

        System.out.println("After Sort:");
        students.forEach(student -> System.out.println(student));
    }
}
