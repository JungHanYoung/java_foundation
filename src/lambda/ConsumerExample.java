package lambda;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;


/**
 * 자바 8부터 빈번히 사용되는 함수적 인터페이스는 java.util.function 표준 API패키지로 제공한다.
 * 자바 function패키지의 함수적 인터페이스는 크게 Consumer, Supplier, Function, Operator, Predicate로 구분
 *
 * Consumer
 * - 매개값은 있고, 리턴값이 없다.
 *      - 리턴값이 없는 accept()메소드를 가지고 있음.
 *      - 매개값을 소비하는 역할
 */
public class ConsumerExample {

    public static void main(String[] args) {
        Consumer<String> consumer1 = t -> System.out.println(t + "8");
        consumer1.accept("java");

        BiConsumer<String, String> consumer2 = (t, u) -> System.out.println(t + u);
        consumer2.accept("Java", "8");

        DoubleConsumer doubleConsumer = d -> System.out.println("Java" + d);
        doubleConsumer.accept(8.0);

        ObjIntConsumer<String> objIntConsumer = (t, i) -> System.out.println(t + i);
        objIntConsumer.accept("Java", 8);
    }
}
