package com.qst.chapter01;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {

	public static void main(String[] args) {
		
		// 声明文件字节输入流
		FileInputStream fis = null;
		try {
			// 实例化文件字节输入流
			fis = new FileInputStream(
					"src\\com\\qst\\chapter01\\FileInputStreamDemo.java");
			// 创建一个长度为1024的字节数组作为缓冲区
			byte[] bbuf = new byte[1024];
			// 用于保存实际读取的字节数
			int hasRead = 0;
			// 使用循环重复读文件中的数据
			while ((hasRead = fis.read(bbuf)) > 0) {
				// 将缓冲区中的数据转换成字符串输出
				System.out.print(new String(bbuf, 0, hasRead));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭文件输入流
				fis.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}
}
