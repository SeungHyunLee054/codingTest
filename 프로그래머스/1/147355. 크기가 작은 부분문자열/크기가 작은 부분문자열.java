class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int tLen = t.length();
        int pLen = p.length();
        long longP = Long.parseLong(p);

        for (int i = 0; i <= (tLen - pLen); i++) {
            String subStr = t.substring(i, i + pLen);
            long longT = Long.parseLong(subStr);
            if (longT <= longP) {
                answer++;
            }
        }
        return answer;
    }
}