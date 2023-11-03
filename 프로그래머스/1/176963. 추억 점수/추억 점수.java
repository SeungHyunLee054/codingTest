import java.util.HashMap;

class Solution {
        public int[] solution(String[] name, int[] yearning, String[][] photo) {
            HashMap<String, Integer> hm = new HashMap<>();
            for (int i = 0; i < name.length; i++) {
                hm.put(name[i], yearning[i]);
            }

            int[] answer = new int[photo.length];
            int idx = 0;
            for (String[] s1 : photo) {
                for (String s2 : s1) {
                    if (hm.containsKey(s2)) {
                        answer[idx] += hm.get(s2);
                    }
                }
                idx++;
            }
            
            return answer;
        }
    }