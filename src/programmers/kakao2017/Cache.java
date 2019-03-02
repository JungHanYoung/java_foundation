package programmers.kakao2017;


import java.util.LinkedList;

public class Cache {

    public static void main(String[] args) {

        check(3,
                new String[] {
                        "Jeju",
                        "Pangyo",
                        "Seoul",
                        "NewYork",
                        "LA",
                        "Jeju",
                        "Pangyo",
                        "Seoul",
                        "NewYork",
                        "LA"
                });
        check(3,
                new String[]{
                        "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"});

        check(2,
                new String[]{
                        "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"});

        check(2,
                new String[]{
                        "Jeju", "Pangyo", "NewYork", "newyork"});

    }

    private static void check(int cacheSize, String[] cities) {
        int result = solution(cacheSize, cities);
        System.out.println("result: " + result);
    }

    private static int solution(int cacheSize, String[] cities) {

        int seconds = 0;
        LinkedList<String> queue = new LinkedList<>();

        for(String city : cities) {
            city = city.toLowerCase();
            if(queue.indexOf(city) < 0) {
                seconds += 5;
                System.out.println("No: 캐시에 " + city + "가 없습니다. 추가합니다. 5s");
                if(queue.size() >= cacheSize) {
                    String temp = queue.poll();
                    System.out.println("\t" + "캐시 데이터가 꽉차" + temp + "를 밀어냅니다.");
                }
                queue.offer(city);
            } else {
                seconds += 1;
                System.out.println("Yes: 캐시에 " + city + "가 확인되었습니다. 1s");
            }
            System.out.println(queue);
        }

        return seconds;
    }
}
