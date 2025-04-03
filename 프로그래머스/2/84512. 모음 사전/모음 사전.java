class Solution {
	public int solution(String word) {
		String dic = "AEIOU";
		int[] weights = new int[5];

		for (int i = 0; i < weights.length; i++) {
			for (int j = 0; j < 5 - i; j++) {
				weights[i] += (int)Math.pow(5, j);
			}
		}

		int answer = 0;
		for (int i = 0; i < word.length(); i++) {
			answer += dic.indexOf(word.charAt(i)) * weights[i] + 1;
		}

		return answer;
	}
}
