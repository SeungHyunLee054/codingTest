import java.util.Stack;

class Solution {
	public int solution(int[] order) {
		Stack<Integer> stack = new Stack<>();
		int idx = 0;
		int value = 1;
		while (value <= order.length) {
			if (order[idx] == value) {
				idx += 1;
				value += 1;
			} else if (!stack.isEmpty() && stack.peek() == order[idx]) {
				stack.pop();
				idx += 1;
			} else {
				stack.push(value);
				value += 1;
			}

			while (!stack.isEmpty() && stack.peek() == order[idx]) {
				stack.pop();
				idx += 1;
			}

		}

		return idx;
	}
}