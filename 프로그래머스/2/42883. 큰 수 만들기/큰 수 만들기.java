import java.util.Stack;

class Solution {
	public String solution(String number, int k) {
		Stack<Character> stack = new Stack<>();
		int cnt = 0;
		
		for (char c : number.toCharArray()) {
			while (!stack.isEmpty() && cnt < k && stack.peek() < c) {
				stack.pop();
				cnt++;
			}
			stack.push(c);
		}

		while (cnt < k) {
			stack.pop();
			cnt++;
		}

		StringBuilder sb = new StringBuilder();
		for (char c : stack) {
			sb.append(c);
		}

		return sb.toString();
	}
}