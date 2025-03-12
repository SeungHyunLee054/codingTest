class Solution {
    public int solution(String s) {
        int answer = 0;

        char x = s.charAt(0);
        int equalCnt = 1;
        int notEqualCnt = 0;
        String copyStr = s;

        int idx = 1;
        int len = s.length();
        if (len == 1) {
            answer++;
        }
        while (idx < len) {
            if (x == copyStr.charAt(idx)) {
                equalCnt++;
            } else if (x != copyStr.charAt(idx)) {
                notEqualCnt++;
            }

            if (equalCnt == notEqualCnt) {
                answer++;
                if (idx + 1 >= len) {
                    break;
                }
                copyStr = copyStr.substring(idx + 1);
                x = copyStr.charAt(0);
                len = copyStr.length();
                idx = 0;
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