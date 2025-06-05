import java.util.TreeSet;

class Solution {
	public int[] solution(String[] operations) {
		TreeSet<Integer> set = new TreeSet<>();
		for (String operation : operations) {
			String[] split = operation.split(" ");
			String command = split[0];
			String num = split[1];

			if (command.equals("I")) {
				set.add(Integer.parseInt(num));
			} else if (command.equals("D")) {
				if (set.isEmpty()) {
					continue;
				}

				if (num.charAt(0) == '-') {
					set.pollFirst();
				} else {
					set.pollLast();
				}
			}
		}

		return set.isEmpty() ? new int[] {0, 0} : new int[] {set.last(), set.first()};
	}
}