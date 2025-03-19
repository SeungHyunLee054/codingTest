class Solution {
    public String solution(String s) {
        String answer;

        String[] sArr = s.split(" ");
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;

        for (String str : sArr) {
            maxVal = Math.max(maxVal, Integer.parseInt(str));
            minVal = Math.min(minVal, Integer.parseInt(str));
        }

        answer = minVal + " " + maxVal;

        return answer;
    }
}