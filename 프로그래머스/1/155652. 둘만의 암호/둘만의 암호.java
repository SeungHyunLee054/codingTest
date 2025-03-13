class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;

        for (int i = 0; i < s.length(); i++) {
            int ascii = s.charAt(i);

            int j = 0;
            int repeat = index;
            while (j < repeat) {
                int nextAscii = ascii > 121 ? ascii - 25 : ascii + 1;
                for (int k = 0; k < skip.length(); k++) {
                    if (nextAscii == skip.charAt(k)) {
                        flag = true;
                        break;
                    }
                }

                if (flag) {
                    repeat += 1;
                    flag = false;
                }

                ascii = nextAscii;
                j++;
            }
            sb.append((char) ascii);
        }

        return sb.toString();
    }
}