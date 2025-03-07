import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            if (i == 1) {
                list.add(1);
                continue;
            }

            int count = 0;
            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) {
                    count++;
                } else if (i % j == 0) {
                    count += 2;
                }
            }
            list.add(count);
        }

        int sum = list.stream().filter(x -> x <= limit).mapToInt(x -> x).sum();
        long count = list.stream().filter(x -> x > limit).count();
        answer = (int) (sum + (count * power));

        return answer;
    }
}