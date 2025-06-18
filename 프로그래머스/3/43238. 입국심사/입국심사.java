import java.util.Arrays;

class Solution {
	public long solution(int n, int[] times) {
		long answer = 0;

		Arrays.sort(times);
		long left = 1;
		long right = (long)times[times.length - 1] * n;

		while (left <= right) {
			long mid = (left + right) / 2;
			long total = 0;
			for (int i = 0; i < times.length; i++) {
				total += mid / times[i];
			}

			if (total >= n) {
				answer = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return answer;
	}
}