class Solution {
	public long solution(int[] sequence) {
		long answer = 0;

		long max1 = 0;
		long max2 = 0;
		long cur1 = 0;
		long cur2 = 0;

		for (int i = 0; i < sequence.length; i++) {
			int plusPurse = (i % 2 == 0) ? 1 : -1;
			int minusPurse = (i % 2 == 0) ? -1 : 1;

			cur1 = Math.max(sequence[i] * plusPurse, cur1 + sequence[i] * plusPurse);
			max1 = Math.max(max1, cur1);
			cur2 = Math.max(sequence[i] * minusPurse, cur2 + sequence[i] * minusPurse);
			max2 = Math.max(max2, cur2);
		}

		answer = Math.max(max1, max2);
		return answer;
	}
}