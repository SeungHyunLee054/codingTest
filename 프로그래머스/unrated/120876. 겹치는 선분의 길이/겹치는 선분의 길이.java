class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] rail = new int[201];
        for (int[] line : lines) {
            for (int i = line[0] + 100; i < line[1] + 100; i++) {
                rail[i]++;
            }
        }
        for (int item : rail) {
            if (item > 1) {
                answer++;
            }
        }
        
        return answer;
    }
}