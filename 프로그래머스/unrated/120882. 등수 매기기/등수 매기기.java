import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[] solution(int[][] score) {
        List<Integer> result = new ArrayList<>();
        for (int[] i : score) {
            int eng = i[0];
            int math = i[1];
            result.add(eng + math);
        }
        result.sort(Comparator.reverseOrder());
        int[] answer = new int[score.length];
        for (int i = 0; i < score.length; i++) {
            answer[i] = result.indexOf(score[i][0] + score[i][1]) + 1;
        }

        return answer;
    }
}