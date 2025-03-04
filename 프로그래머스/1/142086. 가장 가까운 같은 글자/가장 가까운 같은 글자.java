import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                int index = map.get(c);
                answer[i] = i - index;
                map.put(c, i);
            } else {
                map.put(c, i);
                answer[i] = -1;
            }
        }

        return answer;
    }
}