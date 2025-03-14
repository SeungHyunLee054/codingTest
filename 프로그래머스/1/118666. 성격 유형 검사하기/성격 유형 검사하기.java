import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        char[][] personality = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
        int[] score = {0, 3, 2, 1, 0, 1, 2, 3};
        for (char[] c : personality) {
            map.put(c[0], 0);
            map.put(c[1], 0);
        }

        for (int i = 0; i < choices.length; i++) {
            if (choices[i] < 4) {
                map.put(survey[i].charAt(0), map.get(survey[i].charAt(0)) + score[choices[i]]);
            } else if (choices[i] > 4) {
                map.put(survey[i].charAt(1), map.get(survey[i].charAt(1)) + score[choices[i]]);
            }
        }

        for (char[] c : personality) {
            sb.append(map.get(c[0]) >= map.get(c[1]) ? c[0] : c[1]);
        }

        return sb.toString();
    }
}