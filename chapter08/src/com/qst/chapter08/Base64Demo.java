package com.qst.chapter08;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Demo {

	public static void main(String[] args) {
		// 定义一个字符串
		String text = "Base64 class in Java 8!";

		// Base64编码
		String encoded = Base64.getEncoder()
				.encodeToString(text.getBytes(StandardCharsets.UTF_8));
		System.out.println(encoded);

		// Base64解码
		String decoded = new String(
				Base64.getDecoder().decode(encoded),
				StandardCharsets.UTF_8);
		System.out.println(decoded);
	}

}
