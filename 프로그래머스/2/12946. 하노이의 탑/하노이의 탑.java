import java.util.ArrayList;
import java.util.List;

class Solution {
	List<int[]> list = new ArrayList<>();

	public int[][] solution(int n) {
		dfs(n, 1, 2, 3);

		return list.toArray(int[][]::new);
	}

	private void dfs(int n, int from, int by, int to) {
		if (n == 1) {
			list.add(new int[] {from, to});
			return;
		}

		dfs(n - 1, from, to, by);
		list.add(new int[] {from, to});
		dfs(n - 1, by, from, to);
	}
}