class Solution {
	public int[] solution(int rows, int columns, int[][] queries) {
		int[][] matrix = new int[rows][columns];
		int num = 1;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = num++;
			}
		}

		int[] answer = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			int[] query = queries[i];
			answer[i] = rotate(query, matrix);
		}

		return answer;
	}

	private int rotate(int[] query, int[][] matrix) {
		int startX = query[0] - 1;
		int startY = query[1] - 1;
		int endX = query[2] - 1;
		int endY = query[3] - 1;
		int tmp = matrix[startX][startY];
		int min = tmp;

		for (int i = startX; i < endX; i++) {
			matrix[i][startY] = matrix[i + 1][startY];
			min = Math.min(min, matrix[i][startY]);
		}

		for (int i = startY; i < endY; i++) {
			matrix[endX][i] = matrix[endX][i + 1];
			min = Math.min(min, matrix[endX][i]);
		}

		for (int i = endX; i > startX; i--) {
			matrix[i][endY] = matrix[i - 1][endY];
			min = Math.min(min, matrix[i][endY]);
		}

		for (int i = endY; i > startY + 1; i--) {
			matrix[startX][i] = matrix[startX][i - 1];
			min = Math.min(min, matrix[startX][i]);
		}

		matrix[startX][startY + 1] = tmp;

		return min;
	}
}