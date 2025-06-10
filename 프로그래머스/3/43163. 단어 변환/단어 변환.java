import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int solution(String begin, String target, String[] words) {
		if (!Arrays.asList(words).contains(target)) {
			return 0;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(begin, 0));
		boolean[] visited = new boolean[words.length];

		while (!queue.isEmpty()) {
			Node cur = queue.poll();

			if (cur.word.equals(target)) {
				return cur.depth;
			}

			for (int i = 0; i < words.length; i++) {
				if (visited[i] || !isOneLetterDiff(cur.word, words[i])) {
					continue;
				}

				visited[i] = true;
				queue.offer(new Node(words[i], cur.depth + 1));
			}
		}

		return 0;
	}

	private boolean isOneLetterDiff(String a, String b) {
		int diff = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				diff++;
			}

			if (diff > 1) {
				return false;
			}
		}

		return diff == 1;
	}

	class Node {
		String word;
		int depth;

		public Node(String word, int depth) {
			this.word = word;
			this.depth = depth;
		}
	}
}