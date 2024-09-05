import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int m = land[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[] xOil = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[j][i] == -1 || land[j][i] == 0) {
                    continue;
                }
                int oil = 0;
                queue.offer(new int[]{i, j});
                int[] xL = new int[m];

                while (!queue.isEmpty()) {
                    int[] now = queue.poll();
                    int x = now[0];
                    int y = now[1];
                    if (x < 0 || y < 0 || x >= m || y >= n || land[y][x] == -1 || land[y][x] == 0) {
                        continue;
                    }
                    land[y][x] = -1;
                    xL[x] = 1;
                    oil += 1;

                    for (int k = 0; k < 4; k++) {
                        int nX = x + dx[k];
                        int nY = y + dy[k];
                        if (nX < 0 || nY < 0 || nX >= m || nY >= n || land[nY][nX] == -1 || land[nY][nX] == 0) {
                            continue;
                        }
                        queue.offer(new int[]{nX, nY});
                    }
                }

                for (int k = 0; k < m; k++) {
                    if (xL[k] == 1) {
                        xOil[k] += oil;
                    }
                }
            }
            answer = Math.max(answer, xOil[i]);
        }

        return answer;
    }
}