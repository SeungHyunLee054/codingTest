import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    static class Node implements Comparable<Node> {
        int town;
        int time;

        Node(int town, int time) {
            this.town = town;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] r : road) {
            graph.get(r[0]).add(new Node(r[1], r[2]));
            graph.get(r[1]).add(new Node(r[0], r[2]));
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            if (curNode.time > dist[curNode.town]) {
                continue;
            }

            for (Node next : graph.get(curNode.town)) {
                int newTime = curNode.time + next.time;
                if (newTime < dist[next.town]) {
                    dist[next.town] = newTime;
                    pq.offer(new Node(next.town, newTime));
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }


        return answer;
    }
}