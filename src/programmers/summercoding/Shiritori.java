package programmers.summercoding;

import java.util.*;

public class Shiritori {

    public static void main(String[] args) {
        int[] result = solution(
                3,
                new String[]{
                        "tank",
                        "kick",
                        "know",
                        "wheel",
                        "land",
                        "dream",
                        "mother",
                        "robot",
                        "tank"
                }
                );
        print(result);

        int[] result1 = solution(
                2,
                new String[]{
                        "hello",
                        "one",
                        "even",
                        "never",
                        "now",
                        "world",
                        "draw"
                }
        );
        print(result1);

    }

    private static void print(int[] target) {
        for(int i : target) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int[] solution(int n, String[] words) {
        int[] answers = {0, 0};
        Queue<Integer> queue = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        Set<String> set = new HashSet<>();

        int loop = 0;

        for(int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        for(int i = 0; i < words.length; i++) {
            int seq = queue.poll();
            if(seq == 1) loop++;

            /* TODO: 첫번째 단어를 제외하고 앞 단어와의 비교를 해야함. */
            if(i != 0 && stack.peek().charAt(stack.peek().length() - 1) != words[i].charAt(0)) {
                answers[0] = seq;
                answers[1] = loop;
                break;
            }
            stack.push(words[i]);
            /* TODO: 중복 단어 체크 */
            if(!set.add(words[i])) {
                answers[0] = seq;
                answers[1] = loop;
                break;
            }
            queue.offer(seq);
        }

//        int i = 0;

//        do {
//
//            int seq = queue.poll();
//            if(seq == 1) loop++;
//
//            if(!set.add(words[i])) {
//
//            }
//
//        }while(stack.peek().charAt(stack.peek().length() - 1) == words[i].charAt(0));

//        for(String word : words) {
//            int seq = queue.poll();
//            if(seq == 1) { /* TODO 한바퀴 돈 것을 확인해야함. */
//                loop++;
//            }
//            /* TODO 이전 단어의 끝음을 따르는 지 확인해야. */
//            if(stack.peek().charAt(stack.peek().length() - 1) == word.charAt(0)) {
//                System.out.println("앞 단어의 끝음을 따르지 않음!");
//                answers[0] = loop;
//                answers[1] = seq;
//                break;
//            }
//            System.out.println(seq + ": " + word);
//            if(!set.add(word) /* TODO 중복 단어를 체크해야함. */) {
//                System.out.println("단어 중복을 확인했습니다!");
//                answers[0] = loop;
//                answers[1] = seq;
//                break;
//            }
//            queue.offer(seq);
//        }

        return answers;
    }
}
