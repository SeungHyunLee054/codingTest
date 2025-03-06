import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        List<String> cardList = new ArrayList<>();
        cardList.addAll(Arrays.asList(cards1));
        cardList.addAll(Arrays.asList(cards2));
        List<String> goalList = new ArrayList<>(Arrays.asList(goal));
        if (!cardList.containsAll(goalList)) {
            return "No";
        }

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