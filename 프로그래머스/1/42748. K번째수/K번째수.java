import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int value = commands[i][2];

            int[] temp = Arrays.copyOfRange(array, start - 1, end);
            Arrays.sort(temp);

            answer[i] = temp[value - 1];
        }

        return answer;
    }
}