package com.qst.chapter01;

import java.io.Serializable;

//定义一个可以序列化的Person实体类
public class Person implements Serializable {
	private String name;
	private int age;
	private String address;

	public Person(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String toString() {
		
		return "姓名："+this.name+",年龄："+this.age+",地址："+this.address;
	}
}
