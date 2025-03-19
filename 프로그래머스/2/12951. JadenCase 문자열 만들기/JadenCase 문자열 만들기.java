class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] sArr = s.split(" ", -1);

        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i].isEmpty()) {
                if (i == sArr.length - 1) {
                    break;
                }

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

            if (i < sArr.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}