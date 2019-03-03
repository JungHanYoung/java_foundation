package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParallelExample {

    public static void main(String[] args) {

        List<String> list = Arrays.asList(
                "홍길동", "신용권", "감자바",
                "람다식", "박병렬"
        );

        Stream<String> stream = list.stream();
        stream.forEach(ParallelExample::print);

        System.out.println();

        Stream<String> parallelStream = list.parallelStream();
        parallelStream.forEach(ParallelExample::print);
    }

    private static void print(String name) {
        System.out.println(name + " : " + Thread.currentThread().getName());
    }
}
