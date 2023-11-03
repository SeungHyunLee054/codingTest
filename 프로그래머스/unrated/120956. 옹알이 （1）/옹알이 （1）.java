import java.util.Arrays;

class Solution {
    public int solution(String[] babbling) {
        String[] shout = {"aya", "ye", "woo", "ma"};
        for (int i = 0; i < babbling.length; i++) {
            for (String s : shout) {
                if (babbling[i].contains(s)) {
                    babbling[i] = babbling[i].replace(s, "1");
                }
            }
            babbling[i] = babbling[i].replace("1", "");
        }

        return (int) Arrays.stream(babbling).filter(x -> x.equals("")).count();
    }
}