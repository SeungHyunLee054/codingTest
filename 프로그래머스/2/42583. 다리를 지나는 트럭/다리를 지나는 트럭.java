import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

class Solution {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		Map<Integer, Integer> passingTrucks = new LinkedHashMap<>();
		int time = 0;
		int idx = 0;
		int currentWeight = 0;

		while (idx < truck_weights.length || !passingTrucks.isEmpty()) {
			time++;

			Iterator<Map.Entry<Integer, Integer>> it = passingTrucks.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<Integer, Integer> entry = it.next();
				if (time - entry.getValue() >= bridge_length) {
					currentWeight -= truck_weights[entry.getKey()];
					it.remove();
				} else {
					break;
				}
			}

			if (idx < truck_weights.length && currentWeight + truck_weights[idx] <= weight) {
				passingTrucks.put(idx, time);
				currentWeight += truck_weights[idx];
				idx++;
			}
		}

		return time;
	}
}