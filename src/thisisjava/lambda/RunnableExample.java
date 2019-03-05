package thisisjava.lambda;

/**
 * 자바에서 제공되는 표준 API에서 한 개의 추상 메소드를 가지는 인터페이스들은
 * 모두 람다식을 이용해 익명 구현 객체로 표현이 가능하다.
 */
public class RunnableExample {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            for(int i = 0; i < 10; i++) {
                System.out.println(i);
            }
;       };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(() -> {
            for(int i = 10; i < 20; i++) {
                System.out.println(i);
            }
        });
        Thread thread3 = new Thread(new MyRunnable());
        thread3.start();
        thread2.start();
        thread1.start();
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            for(int i = 0; i < 1000; i++) {
                System.out.println(i);
            }
        }
    }
}
