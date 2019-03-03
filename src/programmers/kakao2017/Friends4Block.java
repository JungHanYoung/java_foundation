package programmers.kakao2017;

public class Friends4Block {

    public static void main(String[] args) {
        solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"});
        System.out.println();
        solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"});
    }

    private static int solution(int m, int n, String[] board) {

        int answer = 0;

        boolean isDeleteBlock;
        boolean[][] brokenBlocks = new boolean[m][n];

        do {
            isDeleteBlock = false;
            for(int row = 0; row < m - 1; row++) {
                // 열
                char[] rowToChars1 = board[row].toCharArray();
                char[] rowToChars2 = board[row + 1].toCharArray();
                for(int col = 0; col < n - 1; col++) {
                    // m,n | m,n+1 | m+1,n | m+1,n+1 체크
                    if(rowToChars1[col] == rowToChars1[col+1] &&
                            rowToChars1[col] == rowToChars2[col] &&
                            rowToChars1[col] == rowToChars2[col+1]) {

                        brokenBlocks[row][col] = true;
                        brokenBlocks[row][col+1] = true;
                        brokenBlocks[row+1][col] = true;
                        brokenBlocks[row+1][col+1] = true;

                        isDeleteBlock = true;
                    }
                }
            }

            if(isDeleteBlock) {
//                StringBuilder sb = new StringBuilder();
                int flag = -1;
//                boolean flag = false;
                // 만약 블록이 제거되었다면 제거된 위치에 따라 블록들이 아래로 내려가야 겠지?
                for(int col = 0; col < n; col++) {
                    for(int row = m - 1; row >= 0; row--) {
                        if(brokenBlocks[row][col]) {
                            flag = row;
                        } else if(!brokenBlocks[row][col] && flag >= 0) {
                            // row: 깨지지 않은 블록의 행위치
                            // flag: 깨진 블록의 행위치
                            // - 깨진 블록에 row를 넣고 차이만큼 채워넣어야된다.
                            for(int i = 0; i < flag - row && row - i >= 0; i++) {
                                String replace = board[row - i].substring(0, col)
                                        + board[flag - i].charAt(col) + board[row - i].substring(col + 1);
//                                sb
//                                        .append(board[row])
//                                        .setCharAt(col, board[row].charAt(col));
//                                String replace = sb.toString();
                                board[row] = replace;
                            }
                        }
                    }
                }
                System.out.println("블록이 깨지고 난 후의 재정렬이 되었다.");
                for(int row = 0; row < 0; row++) {
                    System.out.println(board[row]);
                }
            }
        } while(isDeleteBlock);
        // 행



        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(brokenBlocks[i][j] ? "#" : board[i].toCharArray()[j]);
            }
            System.out.println();
        }

//        for(String row : board) {
//            for(char col : row.toCharArray()) {
//
//            }
//        }

        /**
         * TODO
         * - 2x2에 같은 블록이 있는 경우, 해당 블록을 제거하는 로직.
         *
         * - 일단 0 ~ m-1, 0 ~ n-1까지 [m, n], [m+1, n], [m, n+1], [m+1, n+1]체크
         *      - 해당하는 2x2블록이 같은 문자여야 한다.
         *      - 없어진 블록에 대해서 기억할 boolean 2차 배열을 할당해야할 듯.
         * - 1번째에 블록들이 사라지면 사라진 위치에 위의 블록들이 채워지게된다.
         *  - 사라진 블록들의 위치가 boolean 2차 배열에 있을 것.
         *  -
         *
         */

        return answer;
    }
}
