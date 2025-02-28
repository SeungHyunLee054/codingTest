class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append(' ');
                continue;
            }

            int ascii = s.charAt(i);
            int forwardAscii = ascii + n;

            if ((ascii <= 90 && forwardAscii > 90) || forwardAscii > 122) {
                forwardAscii -= 26;
            }

            sb.append((char) forwardAscii);
        }

        return sb.toString();
    }
}