package algorithm.dynamic;

public class MaxProduct {

//    public static void main(String[] args) {
////        int result = maxProduct(new int[]{-2, 0, -1});
////        System.out.println("result: " + result);
//    }

    public int maxProduct(int[] nums) {
        // d[i][0] -> +
        // d[i][1] -> -
        int[][] d = new int[nums.length][2];
        d[0][0] = nums[0];
        d[0][1] = nums[0];

        for(int i = 1; i < nums.length; i++) {
            int c = nums[i];
            d[i][0] = Math.max(c * d[i - 1][0], c * d[i-1][1]);
            d[i][1] = Math.min(c * d[i-1][0], c * d[i-1][1]);
        }
        int max = d[0][0];
        for(int i = 0; i < nums.length; i++) {
            if(d[i][0] > max)
                max = d[i][0];
        }

        return max;
    }
//
//    private static int maxProduct(int[] nums) {
//
//        // d[i][0] -> +
//        // d[i][1] -> -
//        int[][] d = new int[nums.length][2];
//        d[0][0] = nums[0];
//        d[0][1] = nums[0];
//
//        for(int i = 1; i < nums.length; i++) {
//            int c = nums[i];
//            d[i][0] = Math.max(c * d[i - 1][0], c * d[i-1][1]);
//            d[i][1] = Math.min(c * d[i-1][0], c * d[i-1][1]);
//        }
//        int max = d[0][0];
//        for(int i = 0; i < nums.length; i++) {
//            if(d[i][0] > max)
//                max = d[i][0];
//        }
//
//        return max;
//    }
}
