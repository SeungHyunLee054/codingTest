import java.util.LinkedList;
import java.util.Queue;

class Solution {
	int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	public int solution(String[] maps) {
		Point start = null;
		Point lever = null;
		Point exit = null;

		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[i].length(); j++) {
				if (maps[i].charAt(j) == 'S') {
					start = new Point(i, j);
				} else if (maps[i].charAt(j) == 'L') {
					lever = new Point(i, j);
				} else if (maps[i].charAt(j) == 'E') {
					exit = new Point(i, j);
				}
			}
		}

		int toLever = bfs(maps, start, lever);
		int toExit = bfs(maps, lever, exit);

		if (toLever == -1 || toExit == -1) {
			return -1;
		}

		return toLever + toExit;
	}

	private int bfs(String[] maps, Point start, Point Target) {
		boolean[][] visited = new boolean[maps.length][maps[0].length()];
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(start.x, start.y, 0));
		visited[start.x][start.y] = true;

		while (!queue.isEmpty()) {
			Point current = queue.poll();
			if (current.x == Target.x && current.y == Target.y) {
				return current.count;
			}

			for (int[] dir : dirs) {
				int nx = current.x + dir[0];
				int ny = current.y + dir[1];

				if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length() || visited[nx][ny]
					|| maps[nx].charAt(ny) == 'X') {
					continue;
				}

				visited[nx][ny] = true;
				queue.offer(new Point(nx, ny, current.count + 1));
			}
		}

		return -1;
	}

	class Point {
		int x;
		int y;
		int count;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Point(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
}