package thisisjava.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


/**
 * Predicate
 * - 매개 변수와 boolean 리턴값이 있는 testXXX()메소드를 가지고 있다.
 * - 매개값을 조사해 trueㄷ 또는 false를 리턴하는 역할을 한다.
 */
public class PredicateExample {

    private static List<Student> list = Arrays.asList(
            new Student("홍길동", "남자", 90),
            new Student("김순희", "여자", 90),
            new Student("감자바", "남자", 95),
            new Student("박한나", "여자", 92)
    );

    /**
     *
     * @param predicate: Student 객체를 내보내는 predicate이다. 해당 값은 test메소드를 통해 분기가능.
     * @return
     *
     * predicate.test(Student) : boolean값으로 분기하는 메소드
     */
    public static double avg(Predicate<Student> predicate) {
        int count = 0, sum = 0;

        for(Student student : list) {
            if(predicate.test(student)) {
                count++;
                sum += student.getScore();
            }
        }

        return (double) sum / count;
    }

    public static void main(String[] args) {
        double maleArg = avg(t -> t.getSex().equals("남자"));
        System.out.println("남자 평균 점수: " + maleArg);

        double femaleArg = avg(t -> t.getSex().equals("여자"));
        System.out.println("여자 평균 점수: " + femaleArg);
    }

    private static class Student {

        private String name;
        private String sex;
        private int score;


        public Student(String name, String sex, int score) {
            this.name = name;
            this.sex = sex;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public String getSex() {
            return sex;
        }

        public int getScore() {
            return score;
        }
    }
}
