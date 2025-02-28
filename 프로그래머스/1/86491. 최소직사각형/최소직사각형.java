class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxVal = 0;
        int minMaxVal = 0;

        for (int[] size : sizes) {
            int bigVal = Integer.max(size[0], size[1]);
            int smallVal = Integer.min(size[0], size[1]);

            maxVal = Integer.max(maxVal, bigVal);
            minMaxVal = Integer.max(minMaxVal, smallVal);
        }

        answer = maxVal * minMaxVal;

        return answer;
    }
}