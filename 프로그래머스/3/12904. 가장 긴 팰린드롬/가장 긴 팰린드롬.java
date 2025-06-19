class Solution {
	public int solution(String s) {
		int answer = 0;

		// [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
		System.out.println("Hello Java");

		for (int i = 0; i < s.length(); i++) {
			int odd = expand(i, i, s);
			int even = expand(i, i + 1, s);

			answer = Math.max(answer, Math.max(odd, even));
		}

		return answer;
	}

	private int expand(int left, int right, String s) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left -= 1;
			right += 1;
		}

		return right - left - 1;
	}
}