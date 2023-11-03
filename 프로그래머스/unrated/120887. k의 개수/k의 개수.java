class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for (int l = i; l <= j; l++) {
            char[] array = String.valueOf(l).toCharArray();
            for (char c : array) {
                if (Character.digit(c, 10) == k) {
                    answer++;
                }
            }
        }
        return answer;
    }
}