package com.qst.chapter01;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NIO2PathDemo {
	public static void main(String[] args) {
		// 以当前路径来创建Path对象
		Path path = Paths.get(".");
		System.out.println("path里包含的路径数量：" + path.getNameCount());
		System.out.println("path的根路径：" + path.getRoot());
		// 获取path对应的绝对路径。
		Path absolutePath = path.toAbsolutePath();
		System.out.println(absolutePath);
		// 获取绝对路径的根路径
		System.out.println("absolutePath的根路径：" + absolutePath.getRoot());
		// 获取绝对路径所包含的路径数量
		System.out.println("absolutePath里包含的路径数量："
				+ absolutePath.getNameCount());
		System.out.println(absolutePath.getName(3));
		// 以多个String来构建Path对象
		Path path2 = Paths.get("g:", "publish", "codes");
		System.out.println(path2);
	}
}
