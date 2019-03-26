package com.qst.chapter08;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



//枚举Status
enum Status {
	OPEN, CLOSED
}

// 任务类Task
class Task {
	private final Status status;// 状态
	private final Integer points;// 分数（复杂度）

	Task(final Status status, final Integer points) {
		this.status = status;
		this.points = points;
	}

	public Integer getPoints() {
		return points;
	}

	public Status getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return String.format("[%s, %d]", status, points);
	}
}

public class StreamDemo {

	public static void main(String[] args) {
		Collection<Task> tasks = Arrays.asList(
				new Task(Status.OPEN, 5),
				new Task(Status.OPEN, 13),
				new Task(Status.CLOSED, 8));

		// 使用传统方式统计状态为OPEN的任务总分
		int sum = 0;
		for (Task t : tasks) {
			if (t.getStatus() == Status.OPEN) {
				sum += t.getPoints();
			}
		}
		System.out.println("for循环统计状态为OPEN的任务总分为：" + sum);

		// 使用Stream流方式统计状态为OPEN的任务总分
		int totalPointsOfOpenTasks = tasks.stream()
				.filter(t -> t.getStatus() == Status.OPEN)
				.mapToInt(Task::getPoints).sum();

		System.out.println("使用Stream流方式统计状态为OPEN的任务总分为："
				+ totalPointsOfOpenTasks);

		// 使用Stream流方式计算所有任务总分
		int totalPoints = tasks.stream()
				.parallel()
				.map(Task::getPoints)
				.reduce(0, Integer::sum);

		System.out.println("所有任务总分: " + totalPoints);

		// 按照状态进行分组
		Map<Status, List<Task>> map = tasks.stream()
				.collect(Collectors.groupingBy(Task::getStatus));
		System.out.println(map);

	}

}
