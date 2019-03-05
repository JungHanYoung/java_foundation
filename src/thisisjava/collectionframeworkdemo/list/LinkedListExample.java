package thisisjava.collectionframeworkdemo.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * LinkedList는 인접 참조를 링크해서 체인으로 관리.
 * 특정 인덱스의 객체를 제거하면 앞뒤 링크만 변경이 된다.
 * ArrayList는 특정 인덱스의 객체 제거시 전체요소의 인덱스가 1씩 앞으로 땡겨진다.
 *
 * 그렇기에 객체 삭제와 삽입이 많이 일어나는 곳은 ArrayList보다 LinkedList가 좋은 성능을 발휘
 */
public class LinkedListExample {

    public static void main(String[] args) {

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new LinkedList<>();


        System.out.println("ArrayList 걸린시간: " + secondTest(list1) + "ns");

        System.out.println("LinkedList 걸린시간: " + secondTest(list2) + "ns");
    }

    private static long secondTest(List<String> list) {
        long startTime = System.nanoTime();
        for(int i = 0; i < 10000; i++) {
            list.add(0, String.valueOf(i));
        }
        return System.nanoTime() - startTime;
    }
}
