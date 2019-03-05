package algorithm.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {

    public static void main(String[] args) {

        Queue<Integer> queue = new PriorityQueue<>();

        queue.offer(15);
        queue.offer(10);
        queue.offer(20);
        queue.offer(18);
        queue.offer(12);

        queue.stream()
                .forEach(System.out::println);
    }
}
