class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        String toK = Integer.toString(n, k);
        String[] nums = toK.split("0");

        for (String num : nums) {
            if (!num.isEmpty()) {
                long numLong = Long.parseLong(num);
                if (isPrime(numLong)) {
                    answer++;
                }
            }
        }

        return answer;
    }

    private boolean isPrime(long n) {
        if (n < 2) {
            return false;
        }

        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}