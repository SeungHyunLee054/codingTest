class Solution {
    public String solution(String polynomial) {
        int xSum = 0;
        int sum = 0;
        for (String s : polynomial.split(" ")) {
            if (s.contains("x")) {
                String tmp = s.replace("x", "");
                if (tmp.equals("")) {
                    xSum++;
                } else {
                    xSum += Integer.parseInt(tmp);
                }
            } else {
                if (s.equals("+")) {
                    continue;
                }
                sum += Integer.parseInt(s);
            }
        }

        StringBuilder sb = new StringBuilder();
        if (sum != 0 && xSum != 0) {
            if (xSum == 1) {
                sb.append("x + ").append(sum);
            } else {
                sb.append(xSum).append("x + ").append(sum);
            }
        } else if (sum == 0 && xSum != 0) {
            if (xSum == 1) {
                sb.append("x");
            } else {
                sb.append(xSum).append("x");
            }
        } else {
            sb.append(sum);
        }

        return sb.toString();
    }
}