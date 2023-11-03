import java.util.Arrays;

class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        Arrays.sort(sides);
        int sideSum = sides[0] + sides[1];

        for (int i = 1; i <= sides[1]; i++) {
            if (i + sides[0] > sides[1]) {
                answer++;
            }
        }

        for (int i = sides[1] + 1; i < sideSum; i++) {
            answer++;
        }
        return answer;
    }
}