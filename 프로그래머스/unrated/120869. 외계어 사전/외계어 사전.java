class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        for (String s1 : dic) {
            int cnt = 0;
            for (String s2 : spell) {
                if (s1.contains(s2)) {
                    cnt++;
                }
            }
            if (cnt == spell.length) {
                answer = 1;
                break;
            }
        }

        return answer;
    }
}