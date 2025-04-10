import java.util.HashSet;
import java.util.Set;

class Solution {
	Set<Integer> set = new HashSet<>();

	public int solution(String numbers) {
		int answer = 0;

		permutation("", numbers);

		for (int i : set) {
			if (isPrime(i)) {
				answer++;
			}
		}

		return answer;
	}

	private void permutation(String prefix, String remain) {
		if (!prefix.isEmpty()) {
			set.add(Integer.parseInt(prefix));
		}

		for (int i = 0; i < remain.length(); i++) {
			permutation(prefix + remain.charAt(i), remain.substring(0, i) + remain.substring(i + 1));
		}
	}

	private boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}
}