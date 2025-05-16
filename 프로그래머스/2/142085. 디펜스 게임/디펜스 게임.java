import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
	public int solution(int n, int k, int[] enemy) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		int solider = n;
		int invincible = k;
		for (int i = 0; i < enemy.length; i++) {
			solider -= enemy[i];
			pq.offer(enemy[i]);

			if (solider < 0) {
				if (invincible > 0) {
					invincible--;
					solider += pq.poll();
				} else {
					return i;
				}

			}
		}

		return enemy.length;
	}
}