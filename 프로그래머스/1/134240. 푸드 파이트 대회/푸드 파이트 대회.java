import java.util.ArrayList;
import java.util.List;

class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();

        for (int f : food) {
            if (f % 2 != 0) {
                list.add((f - 1) / 2);
            } else {
                list.add(f / 2);
            }
        }

        for (int i = 1; i < list.size(); i++) {
            sb.append(String.valueOf(i).repeat(Math.max(0, list.get(i))));
        }

        String reverse = sb.reverse().toString();
        sb.reverse().append(0).append(reverse);

        return sb.toString();
    }
}