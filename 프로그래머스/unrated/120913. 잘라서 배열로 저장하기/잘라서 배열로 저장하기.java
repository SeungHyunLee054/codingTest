class Solution {
    public String[] solution(String my_str, int n) {
        String[] answer;

        if (my_str.length() % n == 0) {
            answer = new String[my_str.length() / n];
        } else {
            answer = new String[my_str.length() / n + 1];
        }

        StringBuilder sb = new StringBuilder(my_str);
        for (int i = 0; i < answer.length; i++) {
            if (sb.length() < n) {
                answer[i] = sb.toString();
                break;
            }
            answer[i] = sb.substring(0, n);
            sb.delete(0, n);
        }

        return answer;
    }
}