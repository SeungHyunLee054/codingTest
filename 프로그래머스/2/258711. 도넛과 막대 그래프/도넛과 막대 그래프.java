import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int[] solution(int[][] edges) {
        Map<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            if (!map.containsKey(edges[i][0])) {
                map.put(edges[i][0], new int[]{0, 1});
            } else {
                map.put(edges[i][0], new int[]{map.get(edges[i][0])[0], map.get(edges[i][0])[1] + 1});
            }
            if (!map.containsKey(edges[i][1])) {
                map.put(edges[i][1], new int[]{1, 0});
            } else {
                map.put(edges[i][1], new int[]{map.get(edges[i][0])[0] + 1, map.get(edges[i][1])[1]});
            }
        }

        int v = 0;
        int g = 0;
        int cnt8 = 0;
        int cntD = 0;
        int cntL = 0;
        for (int key : map.keySet()) {
            int in = map.get(key)[0];
            int out = map.get(key)[1];

            if (in == 0 && out >= 2) {
                v = key;
                g = out;
            }
            if (in > 0 && out == 2) {
                cnt8++;
            }
            if (out == 0) {
                cntL++;
            }
        }
        cntD = g - cnt8 - cntL;

        return new int[]{v, cntD, cntL, cnt8};
    }
}