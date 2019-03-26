package com.qst.chapter01;

import java.nio.CharBuffer;

public class NIOBufferDemo {

	public static void main(String[] args) {
		// ����Buffer
		CharBuffer buff = CharBuffer.allocate(8);    // ��
		System.out.println("capacity: "	+ buff.capacity());
		System.out.println("limit: " + buff.limit());
		System.out.println("position: " + buff.position());
		// ����Ԫ��
		buff.put('a');
		buff.put('b');
		buff.put('c');      // ��
		System.out.println("��������Ԫ�غ�position = "
			+ buff.position());
		// ����flip()����
		buff.flip();	  // ��
		System.out.println("ִ��flip()��limit = " + buff.limit());
		System.out.println("position = " + buff.position());
		// ȡ����һ��Ԫ��
		System.out.println("��һ��Ԫ��(position=0)��" + buff.get());  // ��
		System.out.println("ȡ��һ��Ԫ�غ�position = "
			+ buff.position());
		// ����clear����
		buff.clear();     // ��
		System.out.println("ִ��clear()��limit = " + buff.limit());
		System.out.println("ִ��clear()��position = "
			+ buff.position());
		System.out.println("ִ��clear()�󣬻��������ݲ�û�б������"
			+ "������Ԫ��Ϊ��" +  buff.get(2));    // ��
		System.out.println("ִ�о��Զ�ȡ��position = "
			+ buff.position());

	}

}
