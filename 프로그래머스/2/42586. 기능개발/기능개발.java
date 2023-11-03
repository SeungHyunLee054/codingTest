import java.util.*;

class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            if (progresses.length > 100 || speeds.length > 100) {
                return null;
            }
            for (int i = 0; i < progresses.length; i++) {
                if (progresses[i] >= 100) {
                    return null;
                } else if (speeds[i] > 100) {
                    return null;
                }
            }

            Queue<Integer> queue = new LinkedList();

            for (int i = 0; i < progresses.length; i++) {
                int day = (100 - progresses[i]) / speeds[i];
                if ((100 - progresses[i]) % speeds[i] == 0) {
                    queue.add(day);
                } else {
                    queue.add(day + 1);
                }
            }

            ArrayList<Integer> list = new ArrayList<>();
            int data = queue.poll();
            int cnt = 1;

            while (!queue.isEmpty()) {
                if (data >= queue.peek()) {
                    cnt++;
                    queue.poll();
                } else {
                    list.add(cnt);
                    cnt = 1;
                    data = queue.poll();
                }
            }
            
            list.add(cnt);

            int[] answer = new int[list.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = list.get(i);
            }

            return answer;
        }
    }