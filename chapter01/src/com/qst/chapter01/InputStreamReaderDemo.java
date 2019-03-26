package com.qst.chapter01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderDemo {

	public static void main(String[] args) {
		try (
		// ��Sytem.in��׼������InputStream�ֽ���ת����Reader�ַ���
		InputStreamReader reader = new InputStreamReader(System.in);
				// ����ͨReader��װ��BufferedReader
				BufferedReader br = new BufferedReader(reader)) {
			String line = null;
			// ����ѭ����ʽ��һ��һ�еĶ�ȡ
			while ((line = br.readLine()) != null) {
				// �����ȡ���ַ���Ϊ"exit"�������˳�
				if (line.equals("exit")) {
					System.exit(1);
				}
				// ��ӡ��ȡ������
				System.out.println("��������Ϊ:" + line);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

}
