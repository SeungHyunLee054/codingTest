import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        Arrays.sort(targets, (x, y) -> x[1] - y[1]);
        int end = targets[0][1];

        for (int i = 1; i < targets.length; i++) {
            if (targets[i][0] < end) {
                continue;
            }
            answer++;
            end = targets[i][1];
        }
        
        return answer;
    }
}