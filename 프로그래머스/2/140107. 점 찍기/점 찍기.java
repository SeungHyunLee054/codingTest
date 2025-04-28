class Solution {
	public long solution(int k, int d) {
		long answer = 0;

		for (long i = 0; i * k <= d; i++) {
			long max = (long)Math.sqrt(((long)d * d) - Math.pow(i * k, 2));

			answer += (max / k) + 1;
		}

		return answer;
	}
}