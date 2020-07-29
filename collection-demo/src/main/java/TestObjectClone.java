public class TestObjectClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student stu1 = Student.builder().name("luke").age(6).height(1.5f).build();

        Student stu2 = (Student) stu1.clone();

        System.out.println(stu2.equals(stu1));

    }
}
