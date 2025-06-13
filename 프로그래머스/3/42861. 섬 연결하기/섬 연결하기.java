import java.util.Arrays;
import java.util.Comparator;

class Solution {
	int[] parent;

	public int solution(int n, int[][] costs) {
		int answer = 0;

		Arrays.sort(costs, Comparator.comparingInt(a -> a[2]));
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		int edge = 0;
		for (int[] cost : costs) {
			if (isConnected(cost[0], cost[1])) {
				answer += cost[2];
				if (++edge == n - 1) {
					break;
				}
			}
		}

		return answer;
	}

	private int find(int a) {
		return parent[a] == a ? a : (parent[a] = find(parent[a]));
	}

	private boolean isConnected(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b) {
			return false;
		}

		parent[Math.max(a, b)] = Math.min(a, b);
		return true;
	}
}