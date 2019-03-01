package programmers.hashing;

import java.util.*;

public class hashing1 {

    public static void main(String[] args) {

        /**
         * 문제풀이...
         * - 어떻게 해야되나
         * - 마라톤 참가 선수들의 이름은 중복될 수 있다. -> 중복될 수 있기 때문에
         *      HashSet으로 값을 넣는다면 중복제거되어 3번케이스를 넘어가지 못할것이다.
         * - HashMap -> key, value -> key: 마라톤선수 이름, value: 해당 이름을 가진 선수의 명수 **채택
         * - participant로 Map을 만든다.
         *
         *
         */

        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        String result = solution(participant, completion);

        System.out.println(result);

    }

    public static String solution(String[] participant, String[] completion) {

        Map<String, Integer> party = new HashMap<>();
        for(String pant : participant) {
            party.put(pant, party.getOrDefault(pant, 0) + 1);
        }

        for(String comp : completion) {
            Integer integer = party.get(comp);
            party.put(comp, integer - 1);
        }

        Iterator<Map.Entry<String, Integer>> iterator = party.entrySet().iterator();
        String answer = null;
        while(iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            if(next.getValue() == 1) {
                answer = next.getKey();
                break;
            }
        }

        return answer;
    }
}
