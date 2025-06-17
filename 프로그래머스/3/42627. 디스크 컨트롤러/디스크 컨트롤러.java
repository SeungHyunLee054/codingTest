import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
	public int solution(int[][] jobs) {
		int answer = 0;
		int idx = 0;
		int cnt = 0;
		int total = 0;
		int end = 0;

		Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

		while (cnt < jobs.length) {
			while (idx < jobs.length && jobs[idx][0] <= end) {
				pq.add(jobs[idx++]);
			}

			if (pq.isEmpty()) {
				end = jobs[idx][0];
			} else {
				int[] cur = pq.poll();
				total += cur[1] + end - cur[0];
				end += cur[1];
				cnt++;
			}
		}

		answer = total / jobs.length;
		return answer;
	}
}