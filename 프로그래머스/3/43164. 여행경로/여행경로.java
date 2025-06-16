import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
	Map<String, PriorityQueue<String>> map;
	List<String> result;

	public String[] solution(String[][] tickets) {
		map = new HashMap<>();
		for (String[] ticket : tickets) {
			String departure = ticket[0];
			String destination = ticket[1];

			map.computeIfAbsent(departure, k -> new PriorityQueue<>()).add(destination);
		}

		result = new LinkedList<>();
		dfs("ICN");

		return result.toArray(new String[0]);
	}

	private void dfs(String current) {
		while (map.containsKey(current) && !map.get(current).isEmpty()) {
			dfs(map.get(current).poll());
		}

		result.add(0, current);
	}
}