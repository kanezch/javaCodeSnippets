import lombok.*;

import java.util.Objects;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Comparable{
    String name;
    int age;
    float height;

    @Override
    public int compareTo(Object o) {
        Student stu = (Student)o;

        //sort based on height
/*        if (this.height - stu.height > 0){
            return 1;
        }else if (this.height - stu.height == 0){
            return 0;
        }else{
            return -1;
        }*/

        //sort based on age
        return this.age - stu.age;
    }

    @Override
    public Object clone() {
        try {
            return (Student) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Student(this.getName(), this.getAge(), this.getHeight());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Float.compare(student.height, height) == 0 &&
                Objects.equals(name, student.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
/*    @Override
    public int hashCode() {
        return Objects.hash(name, age, height);
    }*/
}