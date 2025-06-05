import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
	public int[] solution(String[] operations) {
		int[] answer = {};

		PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> min = new PriorityQueue<>();
		for (String operation : operations) {
			String[] split = operation.split(" ");
			String command = split[0];
			String num = split[1];

			if (command.equals("I")) {
				max.offer(Integer.parseInt(num));
				min.offer(Integer.parseInt(num));
			} else if (command.equals("D")) {
				if (max.isEmpty()) {
					continue;
				}

				if (num.charAt(0) == '-') {
					Integer minVal = min.poll();
					max.remove(minVal);
				} else {
					Integer maxVal = max.poll();
					min.remove(maxVal);
				}
			}
		}

		return max.isEmpty() && min.isEmpty() ? new int[] {0, 0} : new int[] {max.peek(), min.peek()};
	}
}