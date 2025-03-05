import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> student1 = new ArrayList<>();
        List<Integer> student2 = new ArrayList<>();
        List<Integer> student3 = List.of(3, 3, 1, 1, 2, 2, 4, 4, 5, 5);
        for (int i = 1; i < 6; i++) {
            student1.add(i);
            if (i != 2) {
                student2.add(2);
                student2.add(i);
            }
        }

        int[] result = new int[3];
        for (int i = 0; i < answers.length; i++) {
            int ans = answers[i];

            if (ans == student1.get(i % 5)) {
                result[0]++;
            }
            if (ans == student2.get(i % 8)) {
                result[1]++;
            }
            if (ans == student3.get(i % 10)) {
                result[2]++;
            }
        }

        if (result[0] > result[1] && result[0] > result[2]) {
            return new int[]{1};
        } else if (result[1] > result[0] && result[1] > result[2]) {
            return new int[]{2};
        } else if (result[2] > result[0] && result[2] > result[1]) {
            return new int[]{3};
        } else if (result[0] == result[1] && result[0] > result[2]) {
            return new int[]{1, 2};
        } else if (result[0] == result[2] && result[0] > result[1]) {
            return new int[]{1, 3};
        } else if (result[1] > result[0]) {
            return new int[]{2, 3};
        } else {
            return new int[]{1, 2, 3};
        }

    }
}