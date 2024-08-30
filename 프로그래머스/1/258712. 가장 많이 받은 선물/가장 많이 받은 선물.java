class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[] giftVal = new int[friends.length];
        int[][] giftTrade = new int[friends.length][friends.length];
        for (int i = 0; i < gifts.length; i++) {
            String[] present = gifts[i].split(" ");
            int toIdx = 0;
            int fromIdx = 0;
            for (int j = 0; j < friends.length; j++) {
                if (friends[j].equals(present[0])) {
                    giftVal[j] += 1;
                    fromIdx = j;
                } else if (friends[j].equals(present[1])) {
                    giftVal[j] -= 1;
                    toIdx = j;
                }
            }

            giftTrade[fromIdx][toIdx] += 1;
        }

        for (int i = 0; i < friends.length; i++) {
            int tmp = 0;
            for (int j = 0; j < friends.length; j++) {
                if (i == j) {
                    continue;
                }

                if (giftTrade[i][j] > giftTrade[j][i]) {
                    tmp++;
                } else if (giftTrade[i][j] == giftTrade[j][i]) {
                    if (giftVal[i] > giftVal[j]) {
                        tmp++;
                    }
                }
            }

            answer = Math.max(answer, tmp);
        }
        return answer;
    }
}