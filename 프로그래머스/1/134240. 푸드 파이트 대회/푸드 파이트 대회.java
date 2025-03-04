import java.util.ArrayList;
import java.util.List;

class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();

        for (int f : food) {
            list.add(f / 2);
        }

        for (int i = 1; i < list.size(); i++) {
            sb.append(String.valueOf(i).repeat(list.get(i)));
        }

        String reverse = sb.reverse().toString();
        sb.reverse().append(0).append(reverse);

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1, 3, 4, 6}));
    }
}