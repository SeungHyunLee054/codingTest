import java.util.Arrays;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int[] rank = new int[]{6, 6, 5, 4, 3, 2, 1};

        int count = 0;
        for (int lotto : lottos) {
            if (Arrays.stream(win_nums).anyMatch(winNum -> winNum == lotto)) {
                count++;
            }
        }

        long magicNumber = Arrays.stream(lottos).filter(x -> x == 0).count();
        answer[0] = rank[(int) (count + magicNumber)];
        answer[1] = rank[count];

        return answer;
    }
}