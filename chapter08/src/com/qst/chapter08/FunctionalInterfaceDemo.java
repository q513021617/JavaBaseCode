package com.qst.chapter08;

public class FunctionalInterfaceDemo {

	public static void main(String[] args) {
		// 传统方式实现函数式接口中的抽象方法
		FIConverter<String, Integer> converter1 = new FIConverter<String, Integer>() {
			@Override
			public Integer convert(String from) {
				return Integer.valueOf(from);
			}
		};
		// 调用convert()方法，将字符串转换成整数
		Integer a = converter1.convert("88");
		System.out.println(a);

		// Lambda表达式方式实现函数式接口中的抽象方法
		FIConverter<String, Integer> converter2 = (from) -> Integer
				.valueOf(from);
		Integer b = converter2.convert("123");
		System.out.println(b);

		System.out.println(a + b);
	}

}
