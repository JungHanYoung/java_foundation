package programmers.summercoding;

import java.util.Arrays;

public class Budget {

    public static void main(String[] args) {
        int result1 = solution(new int[]{1,3,2,5,4}, 9);
        System.out.println(result1);
        int result2 = solution(new int[]{2,2,3,3}, 10);
        System.out.println(result2);
    }

    private static int solution(int[] d, int budget) {
        int sum = 0;
        int answer = 0;
        Arrays.sort(d);
        for(int i = 0; i < d.length ; i++) {
            if(sum + d[i] > budget) {
                break;
            } else {
                answer++;
                sum += d[i];
            }
        }
        return answer;
    }
}
