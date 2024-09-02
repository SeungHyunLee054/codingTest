import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private List<int[]> diceCombi;
    private int n;

    public int[] solution(int[][] dice) {
        int[] answer = new int[n / 2];
        this.diceCombi = new ArrayList<>();
        this.n = dice.length;
        calCombi(0, 0, new int[n / 2]);
        int maxAWin = 0;

        for (int[] diceA : diceCombi) {
            List<Integer> aSum = new ArrayList<>();
            getDiceSum(0, 0, diceA, aSum, dice);
            aSum.sort(Integer::compareTo);

            int[] diceB = getOppositeDice(diceA);
            List<Integer> bSum = new ArrayList<>();
            getDiceSum(0, 0, diceB, bSum, dice);
            bSum.sort(Integer::compareTo);

            int aWin = compareAB(aSum, bSum);
            if (aWin > maxAWin) {
                maxAWin = aWin;
                answer = diceA;
            }
        }

        for (int i = 0; i < n / 2; i++) {
            answer[i]++;
        }

        return answer;
    }

    private int compareAB(List<Integer> aSum, List<Integer> bSum) {
        int cnt = 0;
        for (int a : aSum) {
            int start = 0;
            int end = bSum.size() - 1;

            while (start <= end) {
                int mid = start + (end - start) / 2;

                if (a > bSum.get(mid)) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            cnt += start;
        }

        return cnt;
    }

    private void getDiceSum(int cnt, int sum, int[] diceAB, List<Integer> diceSum, int[][] dice) {
        if (cnt == n / 2) {
            diceSum.add(sum);
            return;
        }

        for (int i = 0; i < 6; i++) {
            getDiceSum(cnt + 1, sum + dice[diceAB[cnt]][i], diceAB, diceSum, dice);
        }
    }

    private int[] getOppositeDice(int[] diceA) {
        boolean[] visited = new boolean[n];
        for (int dA : diceA) {
            visited[dA] = true;
        }

        int idx = 0;
        int[] diceB = new int[n / 2];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                diceB[idx] = i;
                idx++;
            }
        }

        return diceB;
    }

    private void calCombi(int start, int idx, int[] diceN) {
        if (idx == n / 2) {
            diceCombi.add(diceN.clone());
            return;
        }
        for (int i = start; i < n; i++) {
            diceN[idx] = i;
            calCombi(i + 1, idx + 1, diceN);
        }
    }
}