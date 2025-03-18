class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        String[] op = {"N", "E", "S", "W"};

        int x = 0, y = 0;

        String[][] park2D = new String[park.length][park[0].length()];

        for (int i = 0; i < park2D.length; i++) {
            for (int j = 0; j < park2D[0].length; j++) {
                park2D[i][j] = String.valueOf(park[i].charAt(j));
                if (park2D[i][j].equals("S")) {
                    x = i;
                    y = j;
                }
            }
        }

        logicLoop:
        for (String s : routes) {
            String[] tmp = s.split(" ");
            int n = Integer.parseInt(tmp[1]);
            for (int k = 0; k < 4; k++) {
                if (tmp[0].equals(op[k])) {
                    for (int l = 1; l <= n; l++) {
                        if (x + dx[k] * n < 0 || x + dx[k] * n >= park2D.length || y + dy[k] * n < 0 || y + dy[k] * n >= park2D[0].length || park2D[x + dx[k] * l][y + dy[k] * l].equals("X")) {
                            continue logicLoop;
                        }
                    }

                    x += dx[k] * n;
                    y += dy[k] * n;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = x;
        answer[1] = y;

        return answer;
    }
}