import java.util.HashMap;

class Solution {
        public int solution(String[][] clothes) {
            HashMap<String, Integer> hm = new HashMap<>();
            for (int i = 0; i < clothes.length; i++) {
                hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 1) + 1);
            }

            int answer = 1;
            for (String key : hm.keySet()) {
                answer *= hm.get(key);
            }
            return answer - 1;
        }
    }