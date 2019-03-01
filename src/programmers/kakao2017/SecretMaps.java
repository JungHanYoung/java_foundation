package programmers.kakao2017;

public class SecretMaps {

    public static void main(String[] args) {

        String[] result1 = solution(
                5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28}
                );
        String[] result2 = solution(
                6, new int[]{46, 33, 33, 22, 31, 50}, new int[]{27, 56, 19, 14, 14, 10}
                );

        print(result1);
        print(result2);
    }

    private static void print(String[] target) {
        for(String str : target) {
            System.out.println(str);
        }
        System.out.println();
    }

    private static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answers = new String[n];


        for(int j = 0; j < n; j++) {
            StringBuffer sb = new StringBuffer();

            for(int i = n - 1; i >= 0; i--) {
                int temp = (int) Math.pow(2, i);
                int arr1Temp = (arr1[j] & temp) / temp;
                int arr2Temp = (arr2[j] & temp) / temp;
                if(arr1Temp == 1 || arr2Temp == 1) {
                    sb.append('#');
                } else {
                    sb.append(' ');
                }
            }
            answers[j] = sb.toString();
        }


        return answers;
    }
}
