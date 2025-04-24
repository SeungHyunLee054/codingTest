import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            List<List<Integer>> graph = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < wires.length; j++) {
                if (j == i) {
                    continue;
                }
                graph.get(wires[j][0]).add(wires[j][1]);
                graph.get(wires[j][1]).add(wires[j][0]);
            }

            boolean[] visited = new boolean[n + 1];
            int count = dfs(1, graph, visited);

            int diff = Math.abs(n - count - count);
            answer = Math.min(answer, diff);
        }


        return answer;
    }

    private int dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        int count = 1;

        for (int g : graph.get(node)) {
            if (!visited[g]) {
                count += dfs(g, graph, visited);
            }
        }

        return count;
    }
}