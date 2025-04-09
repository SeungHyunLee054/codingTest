import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<int[]> queue = new LinkedList<>();
		int time = 0;
		int curtWeight = 0;
		int idx = 0;

		while (idx < truck_weights.length || !queue.isEmpty()) {
			time++;

			if (!queue.isEmpty() && time - queue.peek()[1] >= bridge_length) {
				curtWeight -= queue.poll()[0];
			}

			if (idx < truck_weights.length && curtWeight + truck_weights[idx] <= weight) {
				queue.offer(new int[] {truck_weights[idx], time});
				curtWeight += truck_weights[idx];
				idx++;
			}
		}

		return time;
	}
}