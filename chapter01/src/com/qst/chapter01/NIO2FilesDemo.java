package com.qst.chapter01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class NIO2FilesDemo {
	public static void main(String[] args) {
		try {
			// 复制文件
			Files.copy(
					Paths.get("src\\com\\qst\\chapter01\\NIO2FilesDemo.java"),
					new FileOutputStream("a.txt"));
			// 判断NIO2FilesDemo.java文件是否为隐藏文件
			System.out.println("NIO2FilesDemo.java是否为隐藏文件："
					+ Files.isHidden(Paths
							.get("src/com/qst/chapter09/NIO2FilesDemo.java")));
			// 一次性读取FilesTest.java文件的所有行
			List<String> lines = Files.readAllLines(Paths.get("src", "com",
					"qst", "chapter09", "NIO2FilesDemo.java"), Charset
					.forName("gbk"));
			System.out.println("行数：" + lines.size());
			// 判断指定文件的大小
			System.out.println("a.txt文件的大小为：" + Files.size(Paths.get("a.txt")));
			List<String> poem = new ArrayList<>();
			poem.add("使用NIO.2技术");
			poem.add("往文件中写内容");
			// 直接将多个字符串内容写入指定文件中
			Files.write(Paths.get("pome.txt"), poem, Charset.forName("gbk"));
			FileStore cStore = Files.getFileStore(Paths.get("C:"));
			// 判断C盘的总空间，可用空间
			System.out.println("C:共有空间：" + cStore.getTotalSpace());
			System.out.println("C:可用空间：" + cStore.getUsableSpace());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
