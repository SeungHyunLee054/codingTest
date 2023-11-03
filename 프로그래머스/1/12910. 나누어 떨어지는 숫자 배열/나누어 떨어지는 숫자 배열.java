import java.util.ArrayList;
import java.util.Arrays;

class Solution {
        public int[] solution(int[] arr, int divisor) {
            if (arr.length < 1) {
                return null;
            }

            int cnt = 0;
            Arrays.sort(arr);
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % divisor == 0) {
                    list.add(arr[i]);
                    cnt++;
                }
            }
            int[] answer;

            if (cnt>0){
                answer = new int[cnt];
                for (int i = 0; i < cnt; i++) {
                    answer[i] = list.get(i);
                }
            }else {
                answer=new int[1];
                answer[0]=-1;
            }

            return answer;
        }
    }