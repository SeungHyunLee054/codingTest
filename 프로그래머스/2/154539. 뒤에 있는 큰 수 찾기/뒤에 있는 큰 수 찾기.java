import java.util.Stack;

class Solution {
	public int[] solution(int[] numbers) {
		int n = numbers.length;
		int[] answer = new int[n];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
				answer[stack.pop()] = numbers[i];
			}

			stack.push(i);
		}

		while (!stack.isEmpty()) {
			answer[stack.pop()] = -1;
		}

		return answer;
	}
}