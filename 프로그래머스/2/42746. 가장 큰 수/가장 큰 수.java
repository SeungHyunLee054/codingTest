import java.util.ArrayList;
import java.util.List;

class Solution {
	public String solution(int[] numbers) {
		List<String> list = new ArrayList<>();
		for (int number : numbers) {
			list.add(String.valueOf(number));
		}

		list.sort((a, b) -> (b + a).compareTo(a + b));

		StringBuilder sb = new StringBuilder();
		for (String s : list) {
			sb.append(s);
		}

		if (sb.toString().startsWith("0")) {
			return "0";
		}

		return sb.toString();
	}
}