package com.qiaomuer.algorithm.stack;

/**
 * <p>
 * 测试类
 * </p>
 * @author qiaomuer
 * @since 1.0
 */
public class ArrayStackDemo {

	public static void main(String[] args) {

		ArrayStack stack = new ArrayStack(10);
		stack.push(1);
		stack.push(1);
		stack.push(1);
		stack.push(1);
		stack.push(1);
		stack.push(1);
		stack.push(1);
		stack.push(1);
		stack.push(1);
		stack.push(10);
		stack.list();
		int value = stack.pop();
		System.out.println("pop:" + value);
		System.out.println("--------------------------------");
		stack.list();
	}
}
