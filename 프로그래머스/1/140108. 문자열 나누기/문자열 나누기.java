class Solution {
    public int solution(String s) {
        int answer = 0;

        char x = s.charAt(0);
        int equalCnt = 1;
        int notEqualCnt = 0;

        int idx = 1;
        int len = s.length();
        if (len == 1) {
            answer++;
        }
        while (idx < len) {
            if (x == s.charAt(idx)) {
                equalCnt++;
            } else if (x != s.charAt(idx)) {
                notEqualCnt++;
            }

            if (equalCnt == notEqualCnt) {
                answer++;
                if (idx + 1 >= len) {
                    break;
                }
                x = s.charAt(idx + 1);
                idx++;
                equalCnt = 1;
                notEqualCnt = 0;
            }

            idx++;
            if (idx + 1 >= len) {
                answer++;
                break;
            }
        }

        return answer;
    }
}