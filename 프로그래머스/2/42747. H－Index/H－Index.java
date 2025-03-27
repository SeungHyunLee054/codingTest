import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        int maxVal = Math.max(Arrays.stream(citations).max().getAsInt(), citations.length);
        while (answer <= maxVal) {
            int tmp = answer;
            if (Arrays.stream(citations).filter(citation -> citation >= tmp).count() < answer) {
                answer -= 1;
                break;
            }

            answer++;
        }

        return answer;
    }
}