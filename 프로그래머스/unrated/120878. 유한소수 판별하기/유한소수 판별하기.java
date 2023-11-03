class Solution {
    public int solution(int a, int b) {
        int gcd = gcd(a, b);
        int b2 = b / gcd;
        while (b2 % 2 == 0 || b2 % 5 == 0) {
            if (b2 % 2 == 0) {
                b2 /= 2;
            }
            if (b2 % 5 == 0) {
                b2 /= 5;
            }
        }
        int answer = 2;
        if (b2 == 1) {
            answer = 1;
        }

        return answer;
    }

    public int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}