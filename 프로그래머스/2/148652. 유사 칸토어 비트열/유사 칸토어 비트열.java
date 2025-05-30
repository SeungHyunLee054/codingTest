class Solution {
	public int solution(int n, long l, long r) {
		return countOne(n, l - 1, r - 1);
	}

	private int countOne(int n, long l, long r) {
		if (n == 0) {
			return 1;
		}

		int cnt = 0;
		long size = (long)Math.pow(5, n - 1);

		for (int i = 0; i < 5; i++) {
			long start = i * size;
			long end = start + size - 1;

			if (r < start || l > end) {
				continue;
			}

			if (i == 2) {
				continue;
			}

			long newL = Math.max(l, start) - start;
			long newR = Math.min(r, end) - start;
			cnt += countOne(n - 1, newL, newR);
		}

		return cnt;
	}
}