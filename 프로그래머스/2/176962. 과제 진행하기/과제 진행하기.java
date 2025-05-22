import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

class Solution {
	public String[] solution(String[][] plans) {
		PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> a.startTime - b.startTime);

		for (String[] plan : plans) {
			String[] time = plan[1].split(":");
			int hour = Integer.parseInt(time[0]) * 60;
			int minute = Integer.parseInt(time[1]);

			pq.offer(new Task(plan[0], hour + minute, Integer.parseInt(plan[2])));
		}

		List<String> list = new ArrayList<>();
		Stack<Task> stack = new Stack<>();
		while (!pq.isEmpty()) {
			Task curTask = pq.poll();
			int curTime = curTask.startTime;

			while (!pq.isEmpty() && pq.peek().startTime >= curTime) {
				int availableTime = pq.peek().startTime - curTime;

				if (availableTime >= curTask.during) {
					curTime += curTask.during;
					list.add(curTask.subject);

					if (!stack.isEmpty()) {
						curTask = stack.pop();
					} else {
						curTask = null;
						break;
					}
				} else {
					curTask.during -= availableTime;
					stack.push(curTask);
					break;
				}
			}

			if (curTask != null && pq.isEmpty()) {
				list.add(curTask.subject);
				while (!stack.isEmpty()) {
					list.add(stack.pop().subject);
				}
			}
		}

		return list.toArray(String[]::new);
	}

	class Task {
		String subject;
		int startTime;
		int during;

		public Task(String subject, int startTime, int during) {
			this.subject = subject;
			this.startTime = startTime;
			this.during = during;
		}
	}
}