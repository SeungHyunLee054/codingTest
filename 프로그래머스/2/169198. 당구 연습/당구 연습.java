import java.util.ArrayList;
import java.util.List;

class Solution {
	public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
		int[] answer = new int[balls.length];

		for (int i = 0; i < balls.length; i++) {
			int bX = balls[i][0];
			int bY = balls[i][1];
			List<Integer> list = new ArrayList<>();

			if (bY != startY || bX >= startX) {
				int mx = -bX;
				int my = bY;
				int distance = calDistance(startX, startY, mx, my);
				list.add(distance);
			}

			if (bY != startY || bX <= startX) {
				int mx = 2 * m - bX;
				int my = bY;
				int distance = calDistance(startX, startY, mx, my);
				list.add(distance);
			}

			if (bX != startX || bY >= startY) {
				int mx = bX;
				int my = -bY;
				int distance = calDistance(startX, startY, mx, my);
				list.add(distance);
			}

			if (bX != startX || bY <= startY) {
				int mx = bX;
				int my = 2 * n - bY;
				int distance = calDistance(startX, startY, mx, my);
				list.add(distance);
			}

			answer[i] = list.stream().min(Integer::compareTo).get();
		}

		return answer;
	}

	private int calDistance(int x1, int y1, int x2, int y2) {
		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
	}
}