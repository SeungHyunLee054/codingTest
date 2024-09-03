import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int solution(int coin, int[] cards) {
        int answer = 1;
        int n = cards.length;
        List<Integer> drawCards = Arrays.stream(cards, 0, n / 3).boxed().collect(Collectors.toList());
        List<Integer> newCards = new ArrayList<>();

        int idx = n / 3;
        while (idx < n) {
            int newCard1 = cards[idx];
            int newCard2 = cards[idx + 1];
            newCards.add(newCard1);
            newCards.add(newCard2);

            boolean flag = false;

            for (int i = 0; i < drawCards.size(); i++) {
                int p = (n + 1) - drawCards.get(i);
                if (drawCards.contains(p) && p != drawCards.get(i)) {
                    drawCards.remove(Integer.valueOf(p));
                    drawCards.remove(drawCards.get(i));
                    flag = true;
                    answer += 1;
                    idx += 2;
                    break;
                }
            }
            if (flag) {
                continue;
            }

            if (coin >= 1) {
                for (int i = 0; i < drawCards.size(); i++) {
                    int p = (n + 1) - drawCards.get(i);
                    if (newCards.contains(p) && p != drawCards.get(i)) {
                        drawCards.remove(drawCards.get(i));
                        newCards.remove(Integer.valueOf(p));
                        flag = true;
                        coin -= 1;
                        answer += 1;
                        idx += 2;
                        break;
                    }
                }
            }
            if (flag) {
                continue;
            }

            if (coin >= 2) {
                for (int i = 0; i < newCards.size(); i++) {
                    int p = (n + 1) - newCards.get(i);
                    if (newCards.contains(p) && p != newCards.get(i)) {
                        newCards.remove(newCards.get(i));
                        newCards.remove(Integer.valueOf(p));
                        flag = true;
                        coin -= 2;
                        answer += 1;
                        idx += 2;
                        break;
                    }
                }
            }
            if (flag) {
                continue;
            }
            break;
        }

        return answer;
    }
}