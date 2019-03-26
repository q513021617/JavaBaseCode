package com.qst.chapter01;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class BufferedInputStreamDemo {

	public static void main(String[] args) {
		// 定义一个BufferedInputStream类型的变量
		BufferedInputStream bi = null;
		try {
			// 利用FileInputStream对象创建一个输入缓冲流
			bi = new BufferedInputStream(new FileInputStream("src\\com\\qst\\chapter01\\BufferedInputStreamDemo.java"));
			int result = 0;
			//循环读数据
			while ((result = bi.read()) != -1) {
				//输出
				System.out.print((char) result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭缓冲流
				bi.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

}
