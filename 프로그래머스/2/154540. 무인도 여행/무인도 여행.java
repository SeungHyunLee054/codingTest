import java.util.ArrayList;
import java.util.List;

class Solution {
	public int[] solution(String[] maps) {
		int rows = maps.length;
		int cols = maps[0].length();
		boolean[][] visited = new boolean[rows][cols];
		List<Integer> list = new ArrayList<>();
		char[][] map = new char[rows][cols];

		for (int i = 0; i < rows; i++) {
			map[i] = maps[i].toCharArray();
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (!visited[i][j] && map[i][j] != 'X') {
					int days = dfs(i, j, map, visited);
					list.add(days);
				}
			}
		}

		if (list.isEmpty()) {
			return new int[] {-1};
		}

		return list.stream()
			.sorted()
			.mapToInt(i -> i)
			.toArray();
	}

	private int dfs(int x, int y, char[][] map, boolean[][] visited) {
		int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		int rows = map.length;
		int cols = map[0].length;
		visited[x][y] = true;
		int sum = map[x][y] - '0';

		for (int[] dir : dirs) {
			int nx = x + dir[0];
			int ny = y + dir[1];

			if (nx < 0 || ny < 0 || nx >= rows || ny >= cols || visited[nx][ny] || map[nx][ny] == 'X') {
				continue;
			}

			sum += dfs(nx, ny, map, visited);
		}

		return sum;
	}
}