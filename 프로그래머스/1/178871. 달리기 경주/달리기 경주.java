import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        String[] answer = new String[players.length];

        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
            answer[i] = players[i];
        }

        for (String calling : callings) {
            int curIdx = map.get(calling);
            int prevIdx = curIdx - 1;

            String prevPlayer = answer[prevIdx];

            answer[prevIdx] = calling;
            answer[curIdx] = prevPlayer;

            map.put(calling, prevIdx);
            map.put(prevPlayer, curIdx);
        }

        return answer;
    }
}