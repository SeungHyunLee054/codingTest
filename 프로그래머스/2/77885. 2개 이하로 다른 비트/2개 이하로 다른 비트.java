import java.util.ArrayList;
import java.util.List;

class Solution {
	public long[] solution(long[] numbers) {
		List<Long> list = new ArrayList<>();
		for (long number : numbers) {
			if (number % 2 == 0) {
				list.add(number + 1);
			} else {
				long bit = 1L;
				while ((number & bit) != 0) {
					bit <<= 1;
				}
				number = number + bit - (bit >> 1);
				list.add(number);
			}
		}

		return list.stream().mapToLong(Long::longValue).toArray();
	}
}