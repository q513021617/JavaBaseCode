package com.qst.chapter01;


import java.io.FileInputStream;
import java.io.ObjectInputStream;

//反序列化
public class ObjectInputStreamDemo {

	public static void main(String[] args) {

		// 创建一个ObjectInputStream对象输入流
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:\\PersonObject.txt"))) {
			// 从ObjectInputStream对象输入流中读取一个对象，并强制转换成Person对象
			Person person =(Person)ois.readObject();	
			System.out.println("序列化完毕！读出的对象信息如下：");
			System.out.println(person);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
