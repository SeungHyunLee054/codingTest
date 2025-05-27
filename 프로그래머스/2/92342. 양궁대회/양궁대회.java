class Solution {
	int maxDiff = 0;
	int[] result = {-1};

	public int[] solution(int n, int[] info) {
		dfs(0, n, new int[11], info);

		return result;
	}

	private void dfs(int idx, int remain, int[] ryan, int[] apeach) {
		if (idx == 11) {
			if (remain > 0) {
				ryan[10] += remain;
			}

			int rScore = 0;
			int aScore = 0;
			for (int i = 0; i <= 10; i++) {
				if (ryan[i] == 0 && apeach[i] == 0) {
					continue;
				}
				if (ryan[i] > apeach[i]) {
					rScore += 10 - i;
				} else {
					aScore += 10 - i;
				}
			}

			if (rScore > aScore) {
				int diff = rScore - aScore;
				if (diff > maxDiff) {
					maxDiff = diff;
					result = ryan.clone();
				} else if (diff == maxDiff) {
					for (int i = 10; i >= 0; i--) {
						if (ryan[i] > result[i]) {
							result = ryan.clone();
							break;
						} else if (ryan[i] < result[i]) {
							break;
						}
					}
				}
			}
			if (remain > 0) {
				ryan[10] -= remain;
			}

			return;
		}

		if (remain > apeach[idx]) {
			ryan[idx] = apeach[idx] + 1;
			dfs(idx + 1, remain - ryan[idx], ryan, apeach);
			ryan[idx] = 0;
		}

		dfs(idx + 1, remain, ryan, apeach);
	}
}