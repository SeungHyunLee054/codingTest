import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	int[][] directions = {{1, 0}, {0, 1}, {-1, -1}};

	public int[] solution(int n) {
		int[][] triangle = new int[n][n];

		int x = 0;
		int y = 0;
		int num = 1;
		int dir = 0;
		int totalCnt = n * (n + 1) / 2;
		for (int i = 0; i < totalCnt; i++) {
			triangle[x][y] = num++;

			int nx = x + directions[dir][0];
			int ny = y + directions[dir][1];

			if (nx < 0 || nx >= n || ny < 0 || ny >= n || triangle[nx][ny] != 0) {
				dir = (dir + 1) % 3;
				nx = x + directions[dir][0];
				ny = y + directions[dir][1];
			}

			x = nx;
			y = ny;
		}

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				list.add(triangle[i][j]);
			}
		}

		return list.stream().mapToInt(i -> i).toArray();
	}
}