package com.qiaomuer.algorithm.stack;

/**
 * <p>
 * 定义一个栈
 * </p>
 * @author qiaomuer
 * @since 1.0
 */
public class ArrayStack {

	/**
	 * 栈的大小
	 */
	private int maxSize;

	/**
	 * 数组模拟栈，数据放在该数组中
	 */
	private int[] stack;

	/**
	 * top表示栈顶，初始化为-1
	 */
	private int top = -1;

	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		this.stack = new int[maxSize];
	}

	/**
	 * 栈满
	 * @return
	 */
	public boolean isFull() {
		return top == maxSize - 1;
	}

	/**
	 * 栈空
	 * @return
	 */
	public boolean isEmpty() {
		return top == -1;
	}

	/**
	 * 入栈
	 * @param value
	 */
	public void push(int value) {
		if (isFull()) {
			System.out.println("栈满");
			return;
		}
		top++;
		stack[top] = value;
	}

	/**
	 * 出栈
	 * @return
	 */
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("栈空，没有数据");
		}
		int value = stack[top];
		top--;
		return value;
	}

	/**
	 * 显示
	 */
	public void list() {
		if (isEmpty()) {
			System.out.println("栈空，没有数据");
			return;
		}
		for (int i = top; i >= 0; i--) {
			System.out.printf("stack[%d]=%d\n", i, stack[i]);
		}
	}

	/**
	 * 获取栈顶的值
	 * @return
	 */
	public int peek(){
		return stack[top];
	}

	/**
	 * 返回运算符的优先级，优先级由程序员来确定，优先级使用数字表示
	 * 数字越大，则优先级越高
	 * @param oper
	 * @return
	 */
	public static int priority(int oper) {
		if (oper == '*' || oper == '/') {
			return 1;
		} else if (oper == '+' || oper == '-') {
			return 0;
		} else {
			return -1;
		}

	}

	/**
	 * 判断是不是一个运算符
	 * @param oper
	 * @return
	 */
	public static boolean isOper(char oper) {
		return oper == '*' || oper == '/' || oper == '+' || oper == '-' || oper == '(' || oper == ')';
	}

	/**
	 * 计算
	 * @param num1
	 * @param num2
	 * @param oper
	 * @return
	 */
	public static int cal(int num1, int num2, int oper) {
		int res = 0;
		switch (oper) {
			case '+':
				res = num1 + num2;
				break;
			case '-':
				res = num1 - num2;
				break;
			case '*':
				res = num1 * num2;
				break;
			case '/':
				res = num1 / num2;
				break;
			default:
				break;
		}
		return res;
	}
}
