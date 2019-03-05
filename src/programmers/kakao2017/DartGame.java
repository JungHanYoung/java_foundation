package programmers.kakao2017;

import java.util.Stack;

public class DartGame {

    public int solution(String dartResult) {
        int answer = 0;

        /**
         * 예제	dartResult	answer	설명
         * 1	1S2D*3T	    37	    11 * 2 + 22 * 2 + 33
         * 2	1D2S#10S	9	    12 + 21 * (-1) + 101
         * 3	1D2S0T	    3	    12 + 21 + 03
         * 4	1S*2T*3S	23	    11 * 2 * 2 + 23 * 2 + 31
         * 5	1D#2S*3S	5	    12 * (-1) * 2 + 21 * 2 + 31
         * 6	1T2D3D#	    -4	    13 + 22 + 32 * (-1)
         * 7	1D2S3T*	    59	    12 + 21 * 2 + 33 * 2
         */

        /**
         * 스택을 이용해야할듯?
         *
         */

        Stack<Integer> integerStack = new Stack<>();

        for(int i = 0; i < dartResult.length(); i++) {
            char ch = dartResult.charAt(i);
            // 숫자
            if(48 <= ch && ch <= 57) {
                if(dartResult.charAt(i+1) == '0') {
                    i++;
                    integerStack.push(10);
                } else {
                    integerStack.push(ch - 48);
                }
            } else if(ch == '*') { // *
                int num1, num2 = Integer.MIN_VALUE;
                num1 = integerStack.pop();
                if(!integerStack.isEmpty()) {
                    num2 = integerStack.pop();
                }
                if(num2 > Integer.MIN_VALUE) {
                    integerStack.push(num2 * 2);
                }
                integerStack.push(num1 * 2);
            } else if(ch == '#') {
                integerStack.push(integerStack.pop() * -1);
            } else {    // 보너스
                int num = integerStack.pop();
                switch(ch) {
                    case 'D':
                        num = num*num;
                        break;
                    case 'T':
                        num = num*num*num;
                        break;
                    default:
                        break;
                }
                integerStack.push(num);
            }

        }

        answer = integerStack.stream()
                .mapToInt(Integer::intValue)
                .sum();

        return answer;
    }
}
