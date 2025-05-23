class Solution {
	public int solution(String name) {
		int answer = 0;

		for (int i = 0; i < name.length(); i++) {
			char cur = name.charAt(i);

			answer += Math.min(Math.abs(cur - 'A'), Math.abs('Z' - cur + 1));
		}

		int move = name.length() - 1;
		for (int i = 0; i < name.length(); i++) {
			int next = i + 1;

			while (next < name.length() && name.charAt(next) == 'A') {
				next++;
			}

			int leftToRight = i + i + name.length() - next;
			int rightToLeft = i + 2 * (name.length() - next);

			move = Math.min(move, Math.min(leftToRight, rightToLeft));
		}

		return answer + move;
	}
}