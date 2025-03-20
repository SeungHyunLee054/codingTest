class Solution {
    public int[] solution(String s) {
        int zeroCnt = 0;
        int toBinaryCnt = 0;
        while (s.length() > 1) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zeroCnt++;
                }
            }

            String deletedZero = s.replaceAll("0", "");
            s = Integer.toBinaryString(deletedZero.length());
            toBinaryCnt++;
        }

        return new int[]{toBinaryCnt, zeroCnt};
    }
}