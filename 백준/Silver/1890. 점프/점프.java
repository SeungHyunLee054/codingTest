import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void scan() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] board = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dpJump(N, board);
    }

    public static void dpJump(int N, int[][] board) {
        long[][] dp = new long[N + 1][N + 1];
        dp[1][1] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int moveCnt = board[i][j];
                if (moveCnt == 0) {
                    break;
                }
                if (dp[i][j] >= 1 && moveCnt != 0) {
                    if (j + board[i][j] <= N) {
                        dp[i][j + moveCnt] += dp[i][j];
                    }
                    if (i + moveCnt <= N) {
                        dp[i + moveCnt][j] += dp[i][j];
                    }
                }
            }
        }
        System.out.println(dp[N][N]);
    }

    public static void main(String[] args) throws IOException {
        scan();
    }
}
