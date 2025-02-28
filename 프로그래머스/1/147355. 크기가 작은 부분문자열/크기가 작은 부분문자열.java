class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int tLen = t.length();
        int pLen = p.length();
//        int intP = Integer.parseInt(p);
        long longP = Long.parseLong(p);

        for (int i = 0; i <= (tLen - pLen); i++) {
            String subStr = t.substring(i, i + pLen);
//            int intT = Integer.parseInt(subStr);
            long longT = Long.parseLong(subStr);
            if (longT <= longP) {
                answer++;
            }
        }
        return answer;
    }
}