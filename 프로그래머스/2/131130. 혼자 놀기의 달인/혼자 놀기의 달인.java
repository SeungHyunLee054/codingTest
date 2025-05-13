import java.util.ArrayList;
import java.util.List;

class Solution {
	int[] cards;
	boolean[] visited;

	public int solution(int[] cards) {
		this.cards = cards;
		this.visited = new boolean[cards.length];

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < cards.length; i++) {
			if (!visited[i]) {
				list.add(dfs(i));
			}
		}

		list.sort((a, b) -> b - a);
		if (list.size() < 2) {
			return 0;
		}

		return list.get(0) * list.get(1);
	}

	private int dfs(int index) {
		if (visited[index]) {
			return 0;
		}

		int count = 1;
		visited[index] = true;
		count += dfs(cards[index] - 1);

		return count;
	}
}