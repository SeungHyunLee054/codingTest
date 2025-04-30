import java.util.ArrayList;
import java.util.List;

class Solution {
	int[][] dir1 = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	int[][] dir2 = {{2, 0}, {-2, 0}, {0, 2}, {0, -2}};
	int[][] diag = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

	public int[] solution(String[][] places) {
		List<Integer> list = new ArrayList<>();
		for (String[] place : places) {
			list.add(validDistinct(place));
		}

		return list.stream()
			.mapToInt(x -> x)
			.toArray();
	}

	private int validDistinct(String[] place) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (place[i].charAt(j) == 'P') {
					if (!check(place, i, j)) {
						return 0;
					}
				}
			}
		}

		return 1;
	}

	private boolean check(String[] place, int x, int y) {
		for (int[] d : dir1) {
			int nx = x + d[0];
			int ny = y + d[1];
			if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && place[nx].charAt(ny) == 'P') {
				return false;
			}
		}

		for (int[] d : dir2) {
			int nx = x + d[0];
			int ny = y + d[1];
			int mx = x + d[0] / 2;
			int my = y + d[1] / 2;
			if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && place[nx].charAt(ny) == 'P' && place[mx].charAt(my) != 'X') {
				return false;
			}
		}

		for (int[] d : diag) {
			int nx = x + d[0];
			int ny = y + d[1];
			if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && place[nx].charAt(ny) == 'P') {
				if (place[x].charAt(ny) != 'X' || place[nx].charAt(y) != 'X') {
					return false;
				}
			}
		}

		return true;
	}
}