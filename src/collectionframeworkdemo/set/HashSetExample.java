package collectionframeworkdemo.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


/**
 * boolean add(E e)             - 주어진 객체를 저장, 객체가 성공적으로 저장되면 true를 리턴하고 중복 객체면 false를 리턴
 * boolean contains(Object o)   - 주어진 객체가 저장되어 있는지 여부
 * boolean isEmpty()            - 컬렉션이 비어있는지 조사
 */
public class HashSetExample {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();

        set.add("Java");
        set.add("JDBC");
        set.add("Servlet/JSP");
        set.add("Java");        // 저장이 안됨.
        set.add("IBATIS");

        int size = set.size();
        System.out.println("총 객체수: " + size);

        Iterator<String> iterator = set.iterator(); // 반복자 얻기
        while(iterator.hasNext()) {
            String element = iterator.next();
            System.out.println("\t" + element);
        }

        set.remove("JDBC");
        set.remove("IBATIS");

        System.out.println("총 객체수: " + set.size());

        iterator = set.iterator();
        while(iterator.hasNext()) {
            String element = iterator.next();
            System.out.println("\t" + element);
        }

        set.clear();
        if(set.isEmpty()) {
            System.out.println("비어 있음");
        }

    }
}
