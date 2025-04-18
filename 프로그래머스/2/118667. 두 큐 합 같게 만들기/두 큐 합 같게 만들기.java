import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int solution(int[] queue1, int[] queue2) {
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();

		long sum1 = 0;
		long sum2 = 0;
		for (int i : queue1) {
			q1.offer(i);
			sum1 += i;
		}
		for (int i : queue2) {
			q2.offer(i);
			sum2 += i;
		}

		long total = sum1 + sum2;
		if (total % 2 != 0) {
			return -1;
		}

		int cnt = 0;
		while (cnt <= queue1.length * 3) {
			if (sum1 == sum2) {
				return cnt;
			}

			if (sum1 > sum2) {
				int tmp = q1.poll();
				sum1 -= tmp;
				sum2 += tmp;
				q2.offer(tmp);
			} else {
				int tmp = q2.poll();
				sum2 -= tmp;
				sum1 += tmp;
				q1.offer(tmp);
			}

			cnt++;
		}

		return -1;
	}
}