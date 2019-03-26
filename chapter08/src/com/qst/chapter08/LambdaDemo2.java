package com.qst.chapter08;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaDemo2 {

	public static void main(String[] args) {

		List<String> arrNames1 = Arrays.asList("QST青软实训", "锐聘学院", "感知教育",
				"人力资源服务", "欢迎您");
		// 重写Comparator接口中的compare()方法实现排序
		Collections.sort(arrNames1, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return b.compareTo(a);
			}
		});
		// 使用Lambda表达式遍历输出
		arrNames1.forEach((x) -> System.out.println(x));
		System.out.println("----------------------------------");

		List<String> arrNames2 = Arrays.asList("QST青软实训", "锐聘学院", "感知教育",
				"人力资源服务", "欢迎您");
		// 使用Lambda表达式简化方法的重写
		Collections.sort(arrNames2, (a, b) -> b.compareTo(a));
		arrNames2.forEach((x) -> System.out.println(x));
	}
}
