import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        Character[] personality = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        for (int i = 0; i < 8; i++) {
            map.put(personality[i], 0);
        }

        for (int i = 0; i < survey.length; i++) {
            String s = survey[i];

            char c1 = s.charAt(0);
            char c2 = s.charAt(1);
            if (choices[i] == 1) {
                map.put(c1, map.get(c1) + 3);
            } else if (choices[i] == 2) {
                map.put(c1, map.get(c1) + 2);
            } else if (choices[i] == 3) {
                map.put(c1, map.get(c1) + 1);
            } else if (choices[i] == 5) {
                map.put(c2, map.get(c2) + 1);
            } else if (choices[i] == 6) {
                map.put(c2, map.get(c2) + 2);
            } else if (choices[i] == 7) {
                map.put(c2, map.get(c2) + 3);
            }

        }

        if (map.get('R') >= map.get('T')) {
            sb.append('R');
        } else {
            sb.append('T');
        }

        if (map.get('C') >= map.get('F')) {
            sb.append('C');
        } else {
            sb.append('F');
        }

        if (map.get('J') >= map.get('M')) {
            sb.append('J');
        } else {
            sb.append('M');
        }

        if (map.get('A') >= map.get('N')) {
            sb.append('A');
        } else {
            sb.append('N');
        }

        return sb.toString();
    }
}