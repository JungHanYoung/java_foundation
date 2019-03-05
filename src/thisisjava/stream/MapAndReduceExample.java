package thisisjava.stream;

import java.util.Arrays;
import java.util.List;

public class MapAndReduceExample {

    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("홍길동", 10),
                new Student("신용권", 20),
                new Student("감자바", 30)
        );

        double avg = students.stream()
                .mapToInt(Student::getScore)
                .average()
                .getAsDouble();

        System.out.println("평균 : " + avg);
    }
}
