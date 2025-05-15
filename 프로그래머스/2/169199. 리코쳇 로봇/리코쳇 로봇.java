import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int solution(String[] board) {
		Point start = new Point(-1, -1, 0);
		Point goal = new Point(-1, -1);

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length(); j++) {
				if (board[i].charAt(j) == 'R') {
					start.x = i;
					start.y = j;
					break;
				}

				if (board[i].charAt(j) == 'G') {
					goal.x = i;
					goal.y = j;
					break;
				}
			}
			if (start.x != -1 && goal.x != -1) {
				break;
			}
		}

		int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

		boolean[][] visited = new boolean[board.length][board[0].length()];
		Queue<Point> queue = new LinkedList<>();
		queue.offer(start);
		visited[start.x][start.y] = true;

		while (!queue.isEmpty()) {
			Point current = queue.poll();

			if (current.x == goal.x && current.y == goal.y) {
				return current.count;
			}

			for (int[] direction : directions) {
				int nextX = current.x;
				int nextY = current.y;

				while (true) {
					int tempX = nextX + direction[0];
					int tempY = nextY + direction[1];

					if (tempX < 0 || tempX >= board.length || tempY < 0 || tempY >= board[tempX].length()
						|| board[tempX].charAt(tempY) == 'D') {
						break;
					}

					nextX = tempX;
					nextY = tempY;
				}

				if (!visited[nextX][nextY]) {
					visited[nextX][nextY] = true;
					queue.offer(new Point(nextX, nextY, current.count + 1));
				}
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