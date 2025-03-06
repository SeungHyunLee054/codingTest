class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int idx = 0;
        int c1Idx = 0;
        int c2Idx = 0;
        while (idx < goal.length) {
            if (c1Idx < cards1.length && goal[idx].equals(cards1[c1Idx])) {
                c1Idx++;
                idx++;
            } else if (c2Idx < cards2.length && goal[idx].equals(cards2[c2Idx])) {
                c2Idx++;
                idx++;
            } else {
                return "No";
            }
        }

        return "Yes";
    }
}