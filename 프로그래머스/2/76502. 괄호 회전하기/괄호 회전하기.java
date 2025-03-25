import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;

        Stack<String> stack = new Stack<>();
        boolean flag = true;

        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(i) + s.substring(0, i);

            for (String subSp : sub.split("")) {
                if (subSp.equals("(") || subSp.equals("{") || subSp.equals("[")) {
                    stack.push(subSp);
                } else if (stack.isEmpty()) {
                    flag = false;
                    break;
                } else {
                    if (stack.peek().equals("(") && subSp.equals(")")) {
                        stack.pop();
                    } else if (stack.peek().equals("{") && subSp.equals("}")) {
                        stack.pop();
                    } else if (stack.peek().equals("[") && subSp.equals("]")) {
                        stack.pop();
                    } else {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag && stack.isEmpty()) {
                answer++;
            }

            flag = true;
            stack.clear();
        }

        return answer;
    }
}