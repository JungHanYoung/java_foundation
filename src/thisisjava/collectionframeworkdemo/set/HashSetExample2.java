package thisisjava.collectionframeworkdemo.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample2 {

    public static void main(String[] args) {

        Set<Member> set = new HashSet<>();

        set.add(new Member("홍길동", 30));
        set.add(new Member("홍길동", 30));

        System.out.println("총 객체수: " + set.size());
    }

    public static class Member {

        public String name;
        public int age;

        public Member(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int hashCode() {
            return name.hashCode() + age;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Member) {
                Member member = (Member) obj;
                return member.name.equals(name) && (member.age == age);
            } else {
                return false;
            }
        }
    }
}
