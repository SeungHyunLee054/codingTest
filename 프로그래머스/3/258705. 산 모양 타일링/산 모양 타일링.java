class Solution {
    private final int MOD = 10007;

    public int solution(int n, int[] tops) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = tops[0] == 0 ? 3 : 4;
        for (int i = 1; i < n; i++) {
            int top = tops[i];
            int triangle = top == 0 ? 3 : 4;
            dp[i + 1] = (triangle * dp[i] - dp[i - 1] + MOD) % MOD;
        }

        return dp[n];
    }
}