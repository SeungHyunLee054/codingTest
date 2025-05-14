import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	int[][] pickax = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};

	public int solution(int[] picks, String[] minerals) {
		int answer = 0;

		int pickSum = Arrays.stream(picks).sum() * 5;

		List<int[]> mineralList = new ArrayList<>();
		for (int i = 0; i < pickSum && i < minerals.length; i += 5) {
			int[] block = new int[3];
			for (int j = i; j < i + 5 && j < pickSum && j < minerals.length; j++) {
				switch (minerals[j]) {
					case "diamond" -> block[0]++;
					case "iron" -> block[1]++;
					case "stone" -> block[2]++;
				}
			}
			mineralList.add(block);
		}

		mineralList.sort((a, b) -> {
			int aTired = a[0] * pickax[2][0] + a[1] * pickax[2][1] + a[2];
			int bTired = b[0] * pickax[2][0] + b[1] * pickax[2][1] + b[2];
			return bTired - aTired;
		});

		int idx = 0;
		for (int i = 0; i < 3; i++) {
			while (picks[i] > 0 && idx < mineralList.size()) {
				int[] cur = mineralList.get(idx++);
				answer += cur[0] * pickax[i][0] + cur[1] * pickax[i][1] + cur[2] * pickax[i][2];
				picks[i]--;
			}
		}

		return answer;
	}
}