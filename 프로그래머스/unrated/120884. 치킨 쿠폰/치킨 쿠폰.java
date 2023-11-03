class Solution {
    public int solution(int chicken) {
        if (chicken < 10) {
            return 0;
        }

        int answer = 0;
        int coupon = chicken;
        while (coupon >= 10) {
            int nChicken = coupon / 10;
            answer += nChicken;
            coupon = coupon % 10 + nChicken;
        }
        return answer;
    }
}