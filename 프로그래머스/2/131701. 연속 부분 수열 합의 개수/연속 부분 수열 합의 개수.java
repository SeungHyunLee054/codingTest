import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        int[] prefixSum = new int[2 * n + 1];
        for (int i = 1; i <= 2 * n; i++) {
            prefixSum[i] = prefixSum[i - 1] + elements[(i - 1) % n];
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                set.add(prefixSum[i + j] - prefixSum[j]);
            }
        }

        return set.size();
    }
}