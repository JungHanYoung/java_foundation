package thisisjava.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LambdaExpressionExample {

    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("홍길동", 90),
                new Student("신용권", 92)
        );

        Stream<Student> stream = students.stream();
        stream.forEach(student -> {
            String name = student.getName();
            int score = student.getScore();
            System.out.println(name + "-" + score);
        });
    }
}
