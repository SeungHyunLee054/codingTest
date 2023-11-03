class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) {
                    for (int k = 0; k < dx.length; k++) {
                        if (i + dx[k] < 0 || i + dx[k] >= board.length || j + dy[k] < 0 || j + dy[k] >= board.length || board[i + dx[k]][j + dy[k]] != 0) {
                            continue;
                        }

                        board[i + dx[k]][j + dy[k]] = 3;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}