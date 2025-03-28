import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> map = new HashMap<>();
        boolean flag = true;

        for (int i = 0; i <= Math.max(0, discount.length - 10); i++) {
            for (int j = i; j < i + 10; j++) {
                map.put(discount[j], map.getOrDefault(discount[j], 0) + 1);
            }

            for (int j = 0; j < want.length; j++) {
                if (map.get(want[j]) == null || map.get(want[j]) < number[j]) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                answer++;
            }

            flag = true;
            map.clear();
        }

        return answer;
    }
}