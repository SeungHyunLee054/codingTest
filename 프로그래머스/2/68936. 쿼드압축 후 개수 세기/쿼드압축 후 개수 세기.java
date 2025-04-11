class Solution {
	public int[] solution(int[][] arr) {
		return compress(arr, 0, 0, arr.length);
	}

	private int[] compress(int[][] arr, int x, int y, int size) {
		int first = arr[x][y];
		boolean flag = true;

		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (arr[i][j] != first) {
					flag = false;
					break;
				}
			}

			if (!flag) {
				break;
			}
		}

		if (flag) {
			return first == 0 ? new int[] {1, 0} : new int[] {0, 1};
		}

		int half = size / 2;
		int[] result = new int[] {0, 0};
		int[] dx = {0, half};
		int[] dy = {half, 0};
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				int[] tmp = compress(arr, x + dx[i], y + dy[j], half);
				result[0] += tmp[0];
				result[1] += tmp[1];
			}
		}

		return result;
	}
}