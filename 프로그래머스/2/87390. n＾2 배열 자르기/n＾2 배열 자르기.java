class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int) (right - left);
        int[] answer = new int[len + 1];

        int idx = 0;
        for (long i = left; i <= right; i++) {
            answer[idx] = (int) (Math.max(i / n, i % n) + 1);
            idx++;
        }

        return answer;
    }
}