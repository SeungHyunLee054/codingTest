class Solution {
    private final int MOD = 10007;

    public int solution(int n, int[] tops) {
        int answer = 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            int top = tops[i];
            int triangle = top == 0 ? 3 : 4;
            int j = i + 1;
            if (i == 0) {
                dp[j] = triangle;
            } else {
                dp[j] = (triangle * dp[i] - dp[i - 1] + MOD) % MOD;
            }
        }
        answer = dp[n];

        return answer;
    }
}