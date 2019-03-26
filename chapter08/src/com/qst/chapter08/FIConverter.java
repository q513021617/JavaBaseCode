package com.qst.chapter08;

//定义函数式接口
@FunctionalInterface
public interface FIConverter<F, T> {
	T convert(F from);
}
