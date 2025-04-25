import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
	public int solution(String[][] book_time) {
		int[][] time = new int[book_time.length][2];
		for (int i = 0; i < book_time.length; i++) {
			time[i][0] = parseTime(book_time[i][0]);
			time[i][1] = parseTime(book_time[i][1]) + 10;
		}

		Arrays.sort(time, (x, y) -> x[0] - y[0]);
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int[] t : time) {
			if (!pq.isEmpty() && pq.peek() <= t[0]) {
				pq.poll();
			}

			pq.offer(t[1]);
		}

		return pq.size();
	}

	private int parseTime(String time) {
		String[] tmp = time.split(":");

		return Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
	}
}