class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[]{0, 0};
        for (String s : keyinput) {
            if (s.equals("left")) {
                if (answer[0] <= board[0] / 2 * -1) {
                    continue;
                }
                answer[0]--;
            }

            if (s.equals("right")) {
                if (answer[0] >= board[0] / 2) {
                    continue;
                }
                answer[0]++;
            }

            if (s.equals("up")) {
                if (answer[1] >= board[1] / 2) {
                    continue;
                }
                answer[1]++;
            }

            if (s.equals("down")) {
                if (answer[1] <= board[1] / 2 * -1) {
                    continue;
                }
                answer[1]--;
            }
        }

        return answer;
    }
}