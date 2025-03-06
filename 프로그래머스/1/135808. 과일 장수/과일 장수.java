import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);
        int box = score.length / m;
        if (box == 0) {
            return answer;
        }

        for (int i = (score.length % m); i < score.length; i += m) {
            answer += score[i] * m;
        }

        return answer;
    }
}