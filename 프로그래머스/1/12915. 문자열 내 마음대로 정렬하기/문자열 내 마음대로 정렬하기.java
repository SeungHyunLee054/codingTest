import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        List<String> list = new ArrayList<>();

        for (String s : strings) {
            list.add(s.charAt(n) + s);
        }

        answer = list.stream()
                .sorted()
                .map(s -> s.substring(1))
                .toArray(String[]::new);

        return answer;
    }
}