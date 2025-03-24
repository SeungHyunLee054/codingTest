import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        List<Integer> list = map.values().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toUnmodifiableList());
        while (k > 0) {
            k -= list.get(answer);
            answer++;
        }

        return answer;
    }
}