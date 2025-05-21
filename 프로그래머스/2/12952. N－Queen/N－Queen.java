class Solution {
	int cnt = 0;
	int n;

	public int solution(int n) {
		this.n = n;
		boolean[] cols = new boolean[n];
		boolean[] rightDown = new boolean[2 * n - 1];
		boolean[] leftDown = new boolean[2 * n - 1];

		dfs(0, cols, rightDown, leftDown);

		return cnt;
	}

	private void dfs(int x, boolean[] cols, boolean[] rightDown, boolean[] leftDown) {
		if (x == n) {
			cnt++;
			return;
		}

		for (int i = 0; i < n; i++) {
			int d1 = x - i + n - 1;
			int d2 = x + i;

			if (cols[i] || rightDown[d1] || leftDown[d2]) {
				continue;
			}

			cols[i] = true;
			rightDown[d1] = true;
			leftDown[d2] = true;

			dfs(x + 1, cols, rightDown, leftDown);

			cols[i] = false;
			rightDown[d1] = false;
			leftDown[d2] = false;
		}
	}
}