import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
	public int[] solution(int[] fees, String[] records) {
		Map<String, Map<String, List<Integer>>> map = new HashMap<>();

		for (String record : records) {
			String[] rs = record.split(" ");
			String[] ts = rs[0].split(":");
			int time = Integer.parseInt(ts[0]) * 60 + Integer.parseInt(ts[1]);

			map.put(rs[1], map.getOrDefault(rs[1], new HashMap<>()));
			map.get(rs[1]).put(rs[2], map.get(rs[1]).getOrDefault(rs[2], new ArrayList<>()));
			map.get(rs[1]).get(rs[2]).add(time);
			if (!map.get(rs[1]).containsKey("OUT")) {
				map.get(rs[1]).put("OUT", new ArrayList<>());
			}
		}

		Map<String, Integer> res = new HashMap<>();

		for (Map.Entry<String, Map<String, List<Integer>>> entry : map.entrySet()) {
			List<Integer> out = entry.getValue().get("OUT");
			List<Integer> in = entry.getValue().get("IN");
			if (out.size() < in.size()) {
				out.add(23 * 60 + 59);
			}

			int countTime = 0;
			for (int i = 0; i < out.size(); i++) {
				countTime += out.get(i) - in.get(i);
			}

			int fee = 0;
			if (countTime > fees[0]) {
				countTime -= fees[0];
				fee += fees[1];
				fee += countTime % fees[2] == 0 ? (countTime / fees[2]) * fees[3] :
					countTime / fees[2] * fees[3] + fees[3];
			} else {
				fee += fees[1];
			}
			res.put(entry.getKey(), fee);
		}

		List<Integer> resList =
			res.keySet().stream().sorted().map(res::get).collect(Collectors.toUnmodifiableList());

		return resList.stream().mapToInt(i -> i).toArray();
	}
}