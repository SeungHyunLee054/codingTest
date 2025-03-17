import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String term : terms) {
            String[] s = term.split(" ");
            map.put(s[0], Integer.parseInt(s[1]));
        }

        String[] tDate = today.split("\\.");
        int tYear = Integer.parseInt(tDate[0]);
        int tMonth = Integer.parseInt(tDate[1]);
        int tDay = Integer.parseInt(tDate[2]);

        for (int i = 0; i < privacies.length; i++) {
            String privacy = privacies[i];
            String[] privacyArr = privacy.split(" ");
            String[] pDate = privacyArr[0].split("\\.");
            int pYear = Integer.parseInt(pDate[0]);
            int pMonth = Integer.parseInt(pDate[1]);
            int pDay = Integer.parseInt(pDate[2]);

            pMonth += map.get(privacyArr[1]);

            pYear += (pMonth - 1) / 12;
            pMonth = (pMonth - 1) % 12 + 1;

            pDay -= 1;

            if (pDay == 0) {
                pMonth -= 1;
                pDay = 28;
                if (pMonth == 0) {
                    pMonth = 12;
                    pYear -= 1;
                }
            }

            if (tYear > pYear ||
                    (tYear == pYear && tMonth > pMonth) ||
                    (tYear == pYear && tMonth == pMonth && tDay > pDay)) {
                ans.add(i + 1);
            }

        }

        return ans.stream().mapToInt(i -> i).sorted().toArray();
    }
}