class Solution {
	public int[] solution(int[] sequence, int k) {
		int[] answer = {0, Integer.MAX_VALUE};

		int left = 0;
		int right = 0;
		int sum = 0;

		while (right <= sequence.length) {
			if (sum < k) {
				if (right == sequence.length) {
					break;
				}
				sum += sequence[right++];
			} else {
				if (sum == k) {
					if (((right - left - 1) < (answer[1] - answer[0])) ||
						((right - left - 1) == (answer[1] - answer[0]) && left < answer[0])) {
						answer[0] = left;
						answer[1] = right - 1;
					}
				}

				sum -= sequence[left++];
			}
		}

		return answer;
	}
}