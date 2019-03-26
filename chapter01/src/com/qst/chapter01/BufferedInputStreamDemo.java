package com.qst.chapter01;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class BufferedInputStreamDemo {

	public static void main(String[] args) {
		// ����һ��BufferedInputStream���͵ı���
		BufferedInputStream bi = null;
		try {
			// ����FileInputStream���󴴽�һ�����뻺����
			bi = new BufferedInputStream(new FileInputStream("src\\com\\qst\\chapter01\\BufferedInputStreamDemo.java"));
			int result = 0;
			//ѭ��������
			while ((result = bi.read()) != -1) {
				//���
				System.out.print((char) result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// �رջ�����
				bi.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

}
