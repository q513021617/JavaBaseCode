package com.qst.chapter08;

import java.util.Arrays;
import java.util.List;

public class LambdaDemo {
	public static void main(String[] args) {

		String[] names = { "QST青软实训", "锐聘学院", "感知教育", "人力资源服务", "欢迎您" };
		List<String> arrNames = Arrays.asList(names);

		// 传统的循环方式
		System.out.println("传统的循环方式输出:");
		for (String name : arrNames) {
			System.out.println(name);
		}
		System.out.println("--------------------------");

		// 在 Java 8 中使用 Lambda表达式输出
		System.out.println("使用 Lambda表达式输出:");
		arrNames.forEach((name) -> System.out.println(name));
		System.out.println("--------------------------");

		// 在 Java 8 中使用双冒号操作符::
		arrNames.forEach(System.out::println);

	}

}
