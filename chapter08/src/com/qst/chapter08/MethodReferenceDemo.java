package com.qst.chapter08;

public class MethodReferenceDemo {

	public static void main(String[] args) {
		// Lambda表达式方式实现函数式接口中的抽象方法
		FIConverter<String, Integer> converter1 = (from) -> Integer
				.valueOf(from);
		Integer a = converter1.convert("123");
		System.out.println(a);

		// ::方法引用的方式
		FIConverter<String, Integer> converter2 = Integer::valueOf;
		Integer b = converter2.convert("456");
		System.out.println(b);

		System.out.println(a + b);
	}

}
