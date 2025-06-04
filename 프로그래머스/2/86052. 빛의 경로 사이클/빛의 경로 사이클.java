import java.util.ArrayList;
import java.util.List;

class Solution {
	public int[] solution(String[] grid) {
		List<Integer> cycles = new ArrayList<>();
		int rows = grid.length;
		int cols = grid[0].length();
		boolean[][][] visited = new boolean[rows][cols][4];
		int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				for (int d = 0; d < 4; d++) {
					if (!visited[r][c][d]) {
						int len = 0;
						int currR = r;
						int currC = c;
						int currD = d;

						while (true) {
							if (visited[currR][currC][currD]) {
								if (currR == r && currC == c && currD == d) {
									cycles.add(len);
								}
								break;
							}

							visited[currR][currC][currD] = true;
							char instr = grid[currR].charAt(currC);

							if (instr == 'L')
								currD = (currD + 3) % 4;
							else if (instr == 'R')
								currD = (currD + 1) % 4;

							int[] dir = dirs[currD];
							currR = (currR + dir[0] + rows) % rows;
							currC = (currC + dir[1] + cols) % cols;
							len++;
						}
					}
				}
			}
		}

		return cycles.stream().sorted().mapToInt(i -> i).toArray();
	}
}
