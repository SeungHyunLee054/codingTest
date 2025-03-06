import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);
        int box = score.length / m;
        if (box == 0) {
            return answer;
        }

//        for (int i = box - 1; i >= 0; i--) {
//            if (box > 1) {
//                answer += score[i * m] * m;
//            } else {
//                answer += score[(i + 1) * m] * m;
//            }
//        }

        for (int i = (score.length % m); i < score.length; i += m) {
            answer += score[i] * m;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(4, 3, new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}));
        System.out.println(solution.solution(3, 4, new int[]{1, 2, 3, 1, 2, 3, 1}));
    }
}