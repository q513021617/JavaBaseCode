package com.qst.chapter01;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReaderDemo {

	public static void main(String[] args) {
		// 声明一个BufferedReader流的对象
		BufferedReader br = null;
		try {
			// 实例化BufferedReader流，连接FileReader流用于读文件
			br = new BufferedReader(new FileReader(
					"src\\com\\qst\\chapter01\\ReaderDemo.java"));
			String result = null;
			//循环读文件，一次读一行
			while ((result = br.readLine()) != null) {
				//输出
				System.out.println(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭缓冲流
				br.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

}
