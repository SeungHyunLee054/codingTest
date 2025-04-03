class Solution {
	private static final String VOWELS = "AEIOU";
	private int count = 0;
	private int result = 0;

	public int solution(String word) {
		dfs("", word);
		return result;
	}

	private void dfs(String current, String target) {
		if (current.equals(target)) {
			result = count;
			return;
		}

		if (current.length() == 5) {
			return;
		}

		for (int i = 0; i < VOWELS.length(); i++) {
			count++;
			dfs(current + VOWELS.charAt(i), target);
			if (result != 0)
				return;
		}
	}
}
