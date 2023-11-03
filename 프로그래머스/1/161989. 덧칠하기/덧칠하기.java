class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int end = section[0] + m - 1;
        for (int s : section) {
            if (end < s) {
                answer++;
                end = s + m - 1;
            }
        }

        return answer;
    }
}