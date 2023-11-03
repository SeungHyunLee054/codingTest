import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {

            // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
//            System.out.println("Hello Java");

            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < arr.length; i++) {
                if (stack.empty()) {
                    stack.push(arr[i]);
                } else {
                    if (stack.peek().equals(arr[i])) {
                        stack.pop();
                    }
                    stack.push(arr[i]);
                }
            }
        
            int[] answer = new int[stack.size()];
            for (int i = stack.size() - 1; i >= 0; i--) {
                answer[i] = stack.pop();
            }
        
            return answer;
        }
}