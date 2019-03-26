package com.qst.chapter08;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

//并行数组操作
public class ParallelArraysDemo {

	public static void main(String[] args) {
		// 定义一个长度为20000的数组
		Integer[] arrayOfLong = new Integer[20000];
		// 使用parallelSetAll()方法对数组进行赋值
		Arrays.parallelSetAll(arrayOfLong, index -> ThreadLocalRandom.current()
				.nextInt(1000000));

		// 输出前十个数
		System.out.println("未排序的前10个数：");
		Arrays.stream(arrayOfLong).limit(10)
				.forEach(i -> System.out.print(i + " "));
		System.out.println();

		// 使用parallelSort()方法对数组进行排序
		Arrays.parallelSort(arrayOfLong);
		// 输出前十个数
		System.out.println("排序后的前10个数：");
		Arrays.stream(arrayOfLong).limit(10)
				.forEach(i -> System.out.print(i + " "));
		System.out.println();

		// 将数组转换成List集合
		List<Integer> list = Arrays.asList(arrayOfLong);
		// 按照奇数、偶数对数组进行分组
		Map<Boolean, List<Integer>> groupByOdd = list.parallelStream().collect(
				Collectors.groupingBy(x -> x % 2 == 0));
		// 输出前10个奇数
		System.out.println("前10个奇数：");
		groupByOdd.get(false).parallelStream().limit(10)
				.forEach(i -> System.out.print(i + " "));
		System.out.println();
		// 输出前10个偶数
		System.out.println("前10个奇数：");
		groupByOdd.get(true).parallelStream().limit(10)
				.forEach(i -> System.out.print(i + " "));
		System.out.println();

		System.out.println("前10个5的倍数：");
		// 对数组进行过滤，过滤出5的倍数,并输出前10个
		list.parallelStream().filter(x -> x % 5 == 0).limit(10)
				.forEach(i -> System.out.print(i + " "));
		System.out.println();
	}

}
