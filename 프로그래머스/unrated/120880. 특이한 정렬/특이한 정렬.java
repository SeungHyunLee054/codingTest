import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] numlist, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : numlist) {
            map.put(num, Math.abs(n - num));
        }
        List<Map.Entry<Integer, Integer>> collect =
                map.entrySet().stream()
                        .sorted((x, y) -> x.getValue().equals(y.getValue()) ? y.getKey() - x.getKey() : x.getValue() - y.getValue()).collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : collect) {
            result.add(entry.getKey());
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}