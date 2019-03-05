package algorithm.dynamic;

public class MinPathSum {

//    public static void main(String[] args) {
//        int[][] grid = new int[][]{
//                {1,3,1},
//                {1,5,1},
//                {4,2,1}
//        };
//        int result = MinPathSum(grid);
//
//        System.out.println("result: " + result);
//    }

    public int minPathSum(int[][] grid) {
        // 해당 경로까지 도달하기까지 소모될 값을 저장할 배열!
        int[][] d = new int[grid.length][grid[0].length];

        // 시작점의 배열 요소는 자체가 최단경로이므로 grid와 같게한다.
        d[0][0] = grid[0][0];

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                // 시작점을 제외하고 for문을 돌리도록함.
                if(i==0 && j==0) continue;

                // 순회할때, 현재 요소의 위쪽과 왼쪽의 최단경로를 비교하고,
                // 작은 값을 현재 위치의 grid와 더해 최단경로 배열에 넣어준다.

                // 현재 위치에서 위쪽 또는 왼쪽 위치의 요소가 없을 경우가 있다.
                // ex) 현재 위치가 왼쪽에 붙어있거나, 위쪽에 붙어있는 경우에 그렇다.
                // 해당 위치의 경우에는 비교해야하는 up, left를 유효하지 않은 값으로 넣어준다.
                // 아래의 경우는 up과 left중 작은 것을 뽑아야 함으로, int의 최대값을 넣어주었다.
                int up = (i>0) ? d[i-1][j] : Integer.MAX_VALUE;
                int left = (j>0) ?  d[i][j-1] : Integer.MAX_VALUE;

                // 현재 위치의 왼쪽요소와 위쪽요소를 비교하고 작은 값과 현재위치의 grid요소를 더함.
                d[i][j] = Math.min(left, up) + grid[i][j];
//                System.out.println("해당 요소까지 최단경로 grid[" + i + "][" + j + "]" + "=" + d[i][j] );
            }
        }

        // 도착점 위치의 요소를 출력해주면 끝.
        return d[grid.length-1][grid[0].length-1];
    }

//    private static int MinPathSum(int[][] grid) {
//        // 해당 경로까지 도달하기까지 소모될 값을 저장할 배열!
//        int[][] d = new int[grid.length][grid[0].length];
//
//        // 시작점의 배열 요소는 자체가 최단경로이므로 grid와 같게한다.
//        d[0][0] = grid[0][0];
//
//        for(int i = 0; i < grid.length; i++) {
//            for(int j = 0; j < grid[0].length; j++) {
//                // 시작점을 제외하고 for문을 돌리도록함.
//                if(i==0 && j==0) continue;
//
//                // 순회할때, 현재 요소의 위쪽과 왼쪽의 최단경로를 비교하고,
//                // 작은 값을 현재 위치의 grid와 더해 최단경로 배열에 넣어준다.
//
//                // 현재 위치에서 위쪽 또는 왼쪽 위치의 요소가 없을 경우가 있다.
//                // ex) 현재 위치가 왼쪽에 붙어있거나, 위쪽에 붙어있는 경우에 그렇다.
//                // 해당 위치의 경우에는 비교해야하는 up, left를 유효하지 않은 값으로 넣어준다.
//                // 아래의 경우는 up과 left중 작은 것을 뽑아야 함으로, int의 최대값을 넣어주었다.
//                int up = (i>0) ? d[i-1][j] : Integer.MAX_VALUE;
//                int left = (j>0) ?  d[i][j-1] : Integer.MAX_VALUE;
//
//                // 현재 위치의 왼쪽요소와 위쪽요소를 비교하고 작은 값과 현재위치의 grid요소를 더함.
//                d[i][j] = Math.min(left, up) + grid[i][j];
//                System.out.println("해당 요소까지 최단경로 grid[" + i + "][" + j + "]" + "=" + d[i][j] );
//            }
//        }
//
//        // 도착점 위치의 요소를 출력해주면 끝.
//        return d[grid.length-1][grid[0].length-1];
//    }
}
