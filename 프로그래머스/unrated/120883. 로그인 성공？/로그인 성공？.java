class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "";
        String id = id_pw[0];
        String pw = id_pw[1];
        for (String[] d : db) {
            String dId = d[0];
            String dPw = d[1];
            if (id.equals(dId) && pw.equals(dPw)) {
                answer = "login";
                break;
            }
            if (id.equals(dId)) {
                answer = "wrong pw";
            }
        }
        return answer.equals("") ? "fail" : answer;
    }
}