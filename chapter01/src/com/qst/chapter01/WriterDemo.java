package com.qst.chapter01;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriterDemo {

	public static void main(String[] args) {

		// 建立一个从键盘接收数据的扫描器
		Scanner scanner = new Scanner(System.in);

		// 声明文件字符输出流
		FileWriter fw = null;
		try {
			// 实例化文件字符输出流
			fw = new FileWriter("D:\\mytest2.txt");
			System.out.println("请输入内容：");
			String str = scanner.nextLine();
			// 将数据写入文件中
			fw.write(str);
			System.out.println("已保存！");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭文件字符输出流
				fw.close();
				scanner.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

}
