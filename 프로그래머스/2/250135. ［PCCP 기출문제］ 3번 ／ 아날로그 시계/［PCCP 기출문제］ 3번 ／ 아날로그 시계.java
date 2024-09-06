class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;

        int startTime = h1 * 3600 + m1 * 60 + s1;
        int endTime = h2 * 3600 + m2 * 60 + s2;

        if (startTime % 360 == 0 || startTime % 360 == 12) {
            answer += 1;
        }

        while (startTime < endTime) {
            double sAngle = (double) (startTime * 6) % 360;
            double mAngle = ((double) startTime / 10) % 360;
            double hAngle = ((double) startTime / 120) % 360;

            double sAnglePost = (double) ((startTime + 1) * 6) % 360;
            double mAnglePost = ((double) (startTime + 1) / 10) % 360;
            double hAnglePost = ((double) (startTime + 1) / 120) % 360;

            if (sAnglePost == 0) {
                sAnglePost = 360;
            }
            if (mAnglePost == 0) {
                mAnglePost = 360;
            }
            if (hAnglePost == 0) {
                hAnglePost = 360;
            }

            if (sAngle < hAngle && sAnglePost >= hAnglePost) {
                answer += 1;
            }
            if (sAngle < mAngle && sAnglePost >= mAnglePost) {
                answer += 1;
            }
            if (mAnglePost == hAnglePost) {
                answer -= 1;
            }

            startTime++;
        }

        return answer;
    }
}