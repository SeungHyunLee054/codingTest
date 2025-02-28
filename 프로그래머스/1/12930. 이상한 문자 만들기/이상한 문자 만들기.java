class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ", -1);
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                if (j % 2 == 0) {
                    sb.append(word.substring(j, j + 1).toUpperCase());
                } else {
                    sb.append(word.substring(j, j + 1).toLowerCase());
                }
            }

            if (i != words.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}