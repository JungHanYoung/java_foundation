package programmers.practice;


public class CenterLetter {

    public static void main(String[] args) {

    }

    public static String solution(String s) {

        char[] chars = s.toCharArray();

        StringBuffer sb = new StringBuffer();

        if(chars.length % 2 == 0) {
            return sb
                    .append(chars[chars.length / 2 - 1])
                    .append(chars[chars.length / 2])
                    .toString();
        } else {
            return sb
                    .append(chars[chars.length / 2])
                    .toString();
        }
    }
}
