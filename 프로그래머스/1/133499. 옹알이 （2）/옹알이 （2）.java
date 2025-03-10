class Solution {
    public int solution(String[] babbling) {
        String[] sayingWords = new String[]{"aya", "ye", "woo", "ma"};
        int answer = 0;

        for (int i = 0; i < babbling.length; i++) {
            if (babbling[i].contains(sayingWords[0] + sayingWords[0]) ||
                    babbling[i].contains(sayingWords[1] + sayingWords[1]) ||
                    babbling[i].contains(sayingWords[2] + sayingWords[2]) ||
                    babbling[i].contains(sayingWords[3] + sayingWords[3])) {
                continue;
            }

            babbling[i] = babbling[i].replace(sayingWords[0], " ");
            babbling[i] = babbling[i].replace(sayingWords[1], " ");
            babbling[i] = babbling[i].replace(sayingWords[2], " ");
            babbling[i] = babbling[i].replace(sayingWords[3], " ");
            babbling[i] = babbling[i].replace(" ", "");

            if (babbling[i].isEmpty()) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{"aya", "yee", "u", "maa"}));
    }
}