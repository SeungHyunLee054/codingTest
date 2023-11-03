class Solution {
    int answer = 0;
    int[] ch;

    public void DFS(int k, int cnt, int[][] dungeons) {
        answer = Math.max(answer, cnt);
        for (int i = 0; i < dungeons.length; i++) {
            if (k >= dungeons[i][0] && ch[i] == 0) {
                ch[i] = 1;
                DFS(k - dungeons[i][1], cnt + 1, dungeons);
                ch[i] = 0;
            }
        }
    }

    public int solution(int k, int[][] dungeons) {
        ch = new int[dungeons.length];
        DFS(k, 0, dungeons);
        return answer;
    }
}