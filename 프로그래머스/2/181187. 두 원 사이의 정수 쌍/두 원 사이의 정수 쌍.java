class Solution {
	public long solution(int r1, int r2) {
		long answer = 0;

		for (long x = 0; x <= r2; x++) {
			long y1 = (long)Math.floor(Math.sqrt((long)r2 * r2 - x * x));
			long y2 = (x <= r1) ? (long)Math.ceil(Math.sqrt((long)r1 * r1 - x * x)) : 0;

			answer += y1 - y2 + 1;
		}

		return answer * 4 - (r2 - r1 + 1) * 4L;
	}
}