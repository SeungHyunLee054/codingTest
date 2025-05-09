import java.util.ArrayList;
import java.util.List;

class Solution {
	public int[][] solution(int n) {
		List<int[]> list = new ArrayList<>();
		dfs(n, 1, 2, 3, list);

		return list.toArray(int[][]::new);
	}

	private void dfs(int n, int from, int by, int to, List<int[]> list) {
		if (n == 1) {
			list.add(new int[] {from, to});
			return;
		}

		dfs(n - 1, from, to, by, list);
		list.add(new int[] {from, to});
		dfs(n - 1, by, from, to, list);
	}
}