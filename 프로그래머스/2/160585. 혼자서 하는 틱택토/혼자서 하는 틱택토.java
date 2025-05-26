import java.util.Arrays;

class Solution {
	String[] board;

	public int solution(String[] board) {
		this.board = board;

		int oCnt = (int)Arrays.stream(board)
			.flatMapToInt(String::chars)
			.filter(c -> c == 'O')
			.count();
		int xCnt = (int)Arrays.stream(board)
			.flatMapToInt(String::chars)
			.filter(c -> c == 'X')
			.count();

		if (xCnt > oCnt || oCnt - xCnt > 1) {
			return 0;
		}

		boolean oWin = isWin('O');
		boolean xWin = isWin('X');

		if (oWin && xWin) {
			return 0;
		}

		if (oWin && oCnt <= xCnt) {
			return 0;
		}

		if (xWin && oCnt != xCnt) {
			return 0;
		}

		return 1;
	}

	private boolean isWin(char c) {
		for (int i = 0; i < 3; i++) {
			if (board[i].charAt(0) == c && board[i].charAt(1) == c && board[i].charAt(2) == c) {
				return true;
			}
		}

		for (int i = 0; i < 3; i++) {
			if (board[0].charAt(i) == c && board[1].charAt(i) == c && board[2].charAt(i) == c) {
				return true;
			}
		}

		if (board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c) {
			return true;
		}

		if (board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c) {
			return true;
		}

		return false;
	}
}