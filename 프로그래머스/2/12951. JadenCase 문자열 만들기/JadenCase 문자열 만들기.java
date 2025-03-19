class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] sArr = s.split(" ", -1);

        int lastWord = sArr.length - 1;
        while (lastWord >= 0 && sArr[lastWord].isEmpty()) {
            lastWord--;
        }

        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i].isEmpty()) {
                sb.append(" ");
                continue;
            }

            if (!sArr[i].substring(0, 1).chars().allMatch(Character::isDigit)) {
                sb.append(sArr[i].substring(0, 1).toUpperCase())
                        .append(sArr[i].substring(1).toLowerCase());
            } else {
                sb.append(sArr[i].charAt(0))
                        .append(sArr[i].substring(1).toLowerCase());
            }

            if (i < lastWord) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}