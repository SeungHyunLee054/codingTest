class Solution {
    public int solution(String my_string) {
        int answer = 0;
        for (String s : my_string.split("[a-zA-Z]")) {
            answer += !s.equals("") ? Integer.parseInt(s) : 0;
        }

        return answer;
    }
}