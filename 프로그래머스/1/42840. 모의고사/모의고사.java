import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> firstStudent = List.of(1, 2, 3, 4, 5);
        List<Integer> secondStudent = List.of(2, 1, 2, 3, 2, 4, 2, 5);
        List<Integer> thirdStudent = List.of(3, 3, 1, 1, 2, 2, 4, 4, 5, 5);

        int[] score = new int[3];
        for (int i = 0; i < answers.length; i++) {
            int ans = answers[i];

            if (ans == firstStudent.get(i % 5)) {
                score[0]++;
            }
            if (ans == secondStudent.get(i % 8)) {
                score[1]++;
            }
            if (ans == thirdStudent.get(i % 10)) {
                score[2]++;
            }
        }

        int maxScore = Arrays.stream(score).max().getAsInt();

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if (maxScore == score[i]) {
                answer.add(i + 1);
            }
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}