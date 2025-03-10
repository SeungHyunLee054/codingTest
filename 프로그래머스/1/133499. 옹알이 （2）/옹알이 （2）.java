class Solution {
    public int solution(String[] babbling) {
        String[] sayingWords = new String[]{"aya", "ye", "woo", "ma"};
        int answer = 0;

        for (String babblingWord : babbling) {
            if (babblingWord.contains(sayingWords[0] + sayingWords[0]) ||
                    babblingWord.contains(sayingWords[1] + sayingWords[1]) ||
                    babblingWord.contains(sayingWords[2] + sayingWords[2]) ||
                    babblingWord.contains(sayingWords[3] + sayingWords[3])) {
                continue;
            }

            babblingWord = babblingWord.replace(sayingWords[1], " ");
            babblingWord = babblingWord.replace(sayingWords[2], " ");
            babblingWord = babblingWord.replace(sayingWords[3], " ");
            babblingWord = babblingWord.replace(sayingWords[0], " ");
            babblingWord = babblingWord.replace(" ", "");

            if (babblingWord.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}