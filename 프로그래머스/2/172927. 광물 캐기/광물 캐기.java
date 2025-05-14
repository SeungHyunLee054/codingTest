import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	int[][] pickax = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};

	public int solution(int[] picks, String[] minerals) {
		int answer = 0;

		int pickSum = Arrays.stream(picks).sum() * 5;

		List<Mine> mineralList = new ArrayList<>();
		for (int i = 0; i < pickSum && i < minerals.length; i += 5) {
			Mine mine = new Mine(0, 0, 0);
			for (int j = i; j < i + 5 && j < pickSum && j < minerals.length; j++) {
				switch (minerals[j]) {
					case "diamond" -> mine.diamond++;
					case "iron" -> mine.iron++;
					case "stone" -> mine.stone++;
				}
			}
			mineralList.add(mine);
		}

		mineralList.sort(Mine::compareTo);

		int idx = 0;
		for (int i = 0; i < 3; i++) {
			while (picks[i] > 0 && idx < mineralList.size()) {
				Mine mine = mineralList.get(idx++);
				answer += mine.diamond * pickax[i][0] + mine.iron * pickax[i][1] + mine.stone * pickax[i][2];
				picks[i]--;
			}
		}

		return answer;
	}

	class Mine implements Comparable<Mine> {
		int diamond;
		int iron;
		int stone;

		public Mine(int diamond, int iron, int stone) {
			this.diamond = diamond;
			this.iron = iron;
			this.stone = stone;
		}

		@Override
		public int compareTo(Mine o) {
			int a = this.diamond * 25 + this.iron * 5 + this.stone;
			int b = o.diamond * 25 + o.iron * 5 + o.stone;
			return b - a;
		}
	}
}