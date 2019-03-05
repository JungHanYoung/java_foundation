package thisisjava.lambda;

import java.util.function.IntSupplier;


/**
 * Supplier
 * - 매개변수가 없고 리턴값이 있다.
 * - getXXX()메소드를 가진다.
 */
public class SupplierExample {

    public static void main(String[] args) {

        IntSupplier intSupplier = () -> {
            int num = (int) (Math.random() * 6) + 1;
            return num;
        };

        int num = intSupplier.getAsInt();
        System.out.println("눈의 수: " + num);
    }
}
