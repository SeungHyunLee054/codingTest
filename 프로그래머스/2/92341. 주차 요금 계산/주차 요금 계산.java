import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	int[] fees;
	Map<String, List<Integer>> times = new HashMap<>();

	public int[] solution(int[] fees, String[] records) {
		this.fees = fees;

		for (String record : records) {
			String[] rs = record.split(" ");
			String[] ts = rs[0].split(":");
			int time = Integer.parseInt(ts[0]) * 60 + Integer.parseInt(ts[1]);

			times.putIfAbsent(rs[1], new ArrayList<>());
			times.get(rs[1]).add(time);
		}

		Map<String, Integer> fee = getFee();

		return fee.entrySet().stream()
			.sorted(Map.Entry.comparingByKey())
			.mapToInt(Map.Entry::getValue)
			.toArray();
	}

	private Map<String, Integer> getFee() {
		Map<String, Integer> result = new HashMap<>();
		for (Map.Entry<String, List<Integer>> entry : times.entrySet()) {
			List<Integer> values = entry.getValue();
			if (values.size() % 2 != 0) {
				values.add(23 * 60 + 59);
			}

			int totalTime = 0;
			for (int i = 0; i < values.size(); i += 2) {
				totalTime += values.get(i + 1) - values.get(i);
			}

			int fee = fees[1];
			if (totalTime > fees[0]) {
				fee += (int)(Math.ceil((double)(totalTime - fees[0]) / fees[2]) * fees[3]);
			}

			result.put(entry.getKey(), fee);
		}
		return result;
	}
}