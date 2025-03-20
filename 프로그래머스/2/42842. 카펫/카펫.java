import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int brown, int yellow) {
        int totalCnt = yellow + brown;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= totalCnt / 2; i++) {
            if (totalCnt % i == 0) {
                list.add(i);
            }
        }
        int width = 0;
        int height = 0;
        for (int i : list) {
            width = totalCnt / i;
            if ((i - 2) * (width - 2) == yellow) {
                height = totalCnt / width;
                break;
            }
        }

        return new int[]{width, height};
    }
}