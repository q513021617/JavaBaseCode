package com.qst.chapter08;

//产品类Product
class Product {
	String name; // 名称
	int quantity; // 产量

	Product() {
	}

	Product(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "产品：" + this.name + " 产量：" + this.quantity;
	}
}

// 子产品类ChildP继承Product
class ChildP extends Product {
	ChildP() {
	}

	ChildP(String name, int quantity) {
		super(name, quantity);
	}

	@Override
	public String toString() {
		return "子产品：" + this.name + " 产量：" + this.quantity;
	}
}

// 产品工厂（函数式接口）
@FunctionalInterface
interface ProductFactory<P extends Product> {
	P create(String name, int quantity);
}

public class ConstructorMethodReferenceDemo {

	public static void main(String[] args) {
		ProductFactory<Product> productFactory = Product::new;
		Product p1 = productFactory.create("打印机", 1000);
		System.out.println(p1);

		ProductFactory<ChildP> childPFactory = ChildP::new;
		ChildP p2 = childPFactory.create("复印机", 100);
		System.out.println(p2);
	}

}
