import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
	public long solution(int[] weights) {
		long answer = 0;

		Map<Double, Integer> map = new HashMap<>();
		int[] seats = {2, 3, 4};

		for (int weight : weights) {
			Set<Double> ratios = new HashSet<>();
			for (int seat1 : seats) {
				for (int seat2 : seats) {
					ratios.add(weight * (double)seat1 / seat2);
				}
			}

			for (Double ratio : ratios) {
				if (map.containsKey(ratio)) {
					answer += map.get(ratio);
				}
			}

			map.put(weight * 1.0, map.getOrDefault(weight * 1.0, 0) + 1);
		}

		return answer;
	}
}