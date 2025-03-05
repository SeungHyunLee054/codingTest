import java.util.Arrays;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        int[] honor = new int[k];
        Arrays.fill(honor, -1);
        for (int i = 0; i < score.length; i++) {
            if (i < k) {
                honor[i] = score[i];
            } else {
                Arrays.sort(honor);
                honor[0] = Math.max(score[i], honor[0]);
            }

            answer[i] = Arrays.stream(honor)
                    .filter(x -> x >= 0)
                    .min()
                    .getAsInt();
        }

        return answer;
    }
}