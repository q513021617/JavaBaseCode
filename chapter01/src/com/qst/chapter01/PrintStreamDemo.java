package com.qst.chapter01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamDemo {

	public static void main(String[] args) {

		try (PrintStream ps = new PrintStream(new FileOutputStream(
				"D:\\test.txt"))) {
			// 使用PrintStream打印一个字符串
			ps.println("这是PrintStream打印流往文件中写数据！");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
