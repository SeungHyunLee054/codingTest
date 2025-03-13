class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            int cnt = 0;
            while (cnt < index) {
                c = (char) (c > 121 ? c - 25 : c + 1);

                if (!skip.contains(String.valueOf(c))) {
                    cnt++;
                }
            }

            sb.append(c);
        }

        return sb.toString();
    }
}