import java.util.Arrays;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        int clickCnt = Integer.MAX_VALUE;
        for (int i = 0; i < targets.length; i++) {
            for (int j = 0; j < targets[i].length(); j++) {
                String tSub = targets[i].substring(j, j + 1);
                for (String s : keymap) {
                    if (s.contains(tSub)) {
                        for (int l = 0; l < s.length(); l++) {
                            String sSub = s.substring(l, l + 1);
                            if (sSub.equals(tSub)) {
                                clickCnt = Math.min(clickCnt, l + 1);
                                break;
                            }
                        }
                    }
                }
                if (clickCnt != Integer.MAX_VALUE) {
                    answer[i] += clickCnt;
                } else {
                    answer[i] = -1;
                    break;
                }
                clickCnt = Integer.MAX_VALUE;
            }
        }

        return answer;
    }
}