import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        Map<Character, Integer> map = new HashMap<>();
        for (String s : keymap) {
            for (int j = 0; j < s.length(); j++) {
                map.put(s.charAt(j), Math.min(map.getOrDefault(s.charAt(j), j + 1), j + 1));
            }
        }

        for (int i = 0; i < targets.length; i++) {
            for (int j = 0; j < targets[i].length(); j++) {
                char tmp = targets[i].charAt(j);
                if (map.containsKey(tmp)) {
                    answer[i] += map.get(tmp);
                } else {
                    answer[i] = -1;
                    break;
                }
            }
        }

        return answer;
    }
}