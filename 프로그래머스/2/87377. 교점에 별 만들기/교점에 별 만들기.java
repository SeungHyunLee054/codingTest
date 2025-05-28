import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
	public String[] solution(int[][] line) {
		Set<Point> set = new HashSet<>();
		long minX = Long.MAX_VALUE;
		long maxX = Long.MIN_VALUE;
		long minY = Long.MAX_VALUE;
		long maxY = Long.MIN_VALUE;

		for (int i = 0; i < line.length; i++) {
			long a1 = line[i][0];
			long b1 = line[i][1];
			long c1 = line[i][2];

			for (int j = i + 1; j < line.length; j++) {
				long a2 = line[j][0];
				long b2 = line[j][1];
				long c2 = line[j][2];

				long den = a1 * b2 - a2 * b1;

				if (den == 0) {
					continue;
				}

				long xNum = b1 * c2 - b2 * c1;
				long yNum = c1 * a2 - c2 * a1;

				if (xNum % den != 0 || yNum % den != 0) {
					continue;
				}

				long x = xNum / den;
				long y = yNum / den;

				set.add(new Point(x, y));
				minX = Math.min(minX, x);
				maxX = Math.max(maxX, x);
				minY = Math.min(minY, y);
				maxY = Math.max(maxY, y);
			}
		}

		int width = (int)(maxX - minX + 1);
		int height = (int)(maxY - minY + 1);

		String[][] grid = new String[height][width];
		for (String[] row : grid) {
			Arrays.fill(row, ".");
		}

		for (Point p : set) {
			int x = (int)(p.x - minX);
			int y = (int)(maxY - p.y);
			grid[y][x] = "*";
		}

		String[] answer = new String[height];
		for (int i = 0; i < height; i++) {
			answer[i] = String.join("", grid[i]);
		}

		return answer;
	}

	class Point {
		long x;
		long y;

		Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}
}