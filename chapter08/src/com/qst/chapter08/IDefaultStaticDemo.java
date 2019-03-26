package com.qst.chapter08;

public class IDefaultStaticDemo {
	public static void main(String[] args) {
		//可以直接访问接口的静态方法
		System.out.println(IDefaultStatic.msg());
		//声明IDefaultStatic接口对象，并实现该接口中的抽象方法
		IDefaultStatic ids1=new IDefaultStatic(){
			@Override
			public double calculate(int a) {
				//在实现类中可以直接使用默认方法
				return this.sqrt(a*100);
			}
		};
		//通过接口实现类的对象调用默认方法
		System.out.println(ids1.sqrt(16));
		//通过接口实现类的对象调用抽象方法
		System.out.println(ids1.calculate(16));
		System.out.println("--------------------");
		
		//声明IDefaultStatic接口对象，并实现该接口中的抽象方法,并重写默认方法
		IDefaultStatic ids2=new IDefaultStatic(){
			//实现抽象方法
			@Override
			public double calculate(int a) {
				//在实现类中可以直接使用默认方法
				return this.sqrt(a*100);
			}
			//重写默认方法
			@Override
			public double sqrt(int a) {
				return IDefaultStatic.super.sqrt(a*10000);
			}
		};
		//通过接口实现类的对象调用默认方法
		System.out.println(ids2.sqrt(16));
		//通过接口实现类的对象调用抽象方法
		System.out.println(ids2.calculate(16));

	}

}
