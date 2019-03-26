package com.qst.chapter01;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//序列化
public class ObjectOutputStreamDemo {

	public static void main(String[] args) {

		// 创建一个ObjectOutputStream对象输出流
		try (ObjectOutputStream obs = new ObjectOutputStream(new FileOutputStream("d:\\PersonObject.txt"))) {
			// 创建一个Person类型的对象
			Person person = new Person("张三", 25, "青岛");
			// 把对象写入到文件中
			obs.writeObject(person);
			obs.flush();
			System.out.println("序列化完毕！");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
