import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String X, String Y) {
        Map<Integer, Integer> mapX = new HashMap<>();
        Map<Integer, Integer> mapY = new HashMap<>();
        for (int i = 0; i <= 9; i++) {
            mapX.put(i, 0);
            mapY.put(i, 0);
        }

        for (String s : X.split("")) {
            int i = Integer.parseInt(s);
            mapX.put(i, mapX.get(i) + 1);
        }
        for (String s : Y.split("")) {
            int i = Integer.parseInt(s);
            mapY.put(i, mapY.get(i) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            if (mapX.containsKey(i) && mapY.containsKey(i)) {
                for (int j = 0; j < Math.min(mapX.get(i), mapY.get(i)); j++) {
                    list.add(i);
                }

            }
        }

        if (list.isEmpty()) {
            return "-1";
        }

        if (list.stream().allMatch(x -> x == 0)) {
            return "0";
        }

        return list.stream()
                .sorted(Collections.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }
}