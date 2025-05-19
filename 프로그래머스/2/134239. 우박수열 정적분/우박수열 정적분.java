import java.util.ArrayList;
import java.util.List;

class Solution {
	public double[] solution(int k, int[][] ranges) {
		List<Integer> list = new ArrayList<>();
		list.add(k);
		while (list.get(list.size() - 1) > 1) {
			int num = list.get(list.size() - 1);

			if (num % 2 == 0) {
				list.add(num / 2);
			} else {
				list.add(num * 3 + 1);
			}
		}

		List<Double> areas = new ArrayList<>();
		for (int i = 0; i < list.size() - 1; i++) {
			int a = list.get(i);
			int b = list.get(i + 1);
			areas.add((a + b) / 2.0);
		}

		double[] dp = new double[areas.size() + 1];
		for (int i = 0; i < areas.size(); i++) {
			dp[i + 1] = dp[i] + areas.get(i);
		}

		List<Double> result = new ArrayList<>();
		for (int[] range : ranges) {
			int start = range[0];
			int end = list.size() - 1 + range[1];

			if (start > end) {
				result.add(-1.0);
			} else {
				result.add(dp[end] - dp[start]);
			}
		}

		return result.stream().mapToDouble(Double::doubleValue).toArray();
	}
}