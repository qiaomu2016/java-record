package com.qiaomuer.algorithm.stack;

/**
 * <p>
 * 实现简单计算器
 * </p>
 * @author qiaomuer
 * @since 1.0
 */
public class Calculator {

	public static void main(String[] args) {

		// 需要计算的表达式
		String expression = "6*3*2-15+10-6+9+8-4";

		// 创建两个栈,一个数据栈,一个符号栈
		ArrayStack numStack = new ArrayStack(10);
		ArrayStack operStack = new ArrayStack(10);

		// 定义需要的相关变量
		// 用于扫描
		int index = 0;
		int num1 = 0;
		int num2 = 0;
		int oper = 0;
		int res = 0;

		// 将每次扫描得到char保存至ch
		char ch;
		// 用于拼接多位数
		String keepNum = "";

		while (true) {
			// 依次得到 expression的每一个字符
			ch = expression.substring(index, index + 1).charAt(0);
			// 对ch 进行判断
			// 如果是符号
			if (operStack.isOper(ch)) {
				// 判断当前的符号栈是否为空
				if (!operStack.isEmpty()) {
					// 如果当前的符号栈有值，就进行比较，如果当前的操作数的优先级少于或者等于栈中的操作数
					// 就需要从数栈中pop出两个数，再从符号栈pop出一个符号，进行运算，将得到的结果，入数栈
					// 然后将当前的操作符入符号栈
					if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
						num1 = numStack.pop();
						num2 = numStack.pop();
						oper = operStack.pop();
						res = numStack.cal(num2, num1, oper);

						numStack.push(res);
						operStack.push(ch);
					} else {
						operStack.push(ch);
					}
				} else {
					operStack.push(ch);
				}

			}
			// 如果是数,则直接入数栈
			else {
				// 处理多位数
				// 注：
				// 1.当处理多位数时，不能发现是一个数就立即入栈，因为他可能是多位数
				// 2.在处理数时，需要向expression的表达式的index后再看一位，如果是数就进行扫描，如果是符号才入栈
				// 3.因此我们需要定义一个变量 字符串，用于拼接
				keepNum += ch;

				// 如果ch已经是 expression 的最后一位，则直接入栈
				if (index == expression.length() - 1) {
					numStack.push(Integer.parseInt(keepNum));
				} else {
					// 判断下一字会是不是数字，如果是数字，就继续扫描，如果是运算符，则入栈
					if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
						numStack.push(Integer.parseInt(keepNum));
						// 重点：注意要清空
						keepNum = "";
					}
				}
			}
			index++;
			if (index >= expression.length()) {
				break;
			}
		}

		// 当表达式扫描完比，就顺序的从 数栈 及 符号栈 中pop出相应的 数 和 符号 进行运算
		while (true) {
			if (operStack.isEmpty()) {
				break;
			}
			num1 = numStack.pop();
			num2 = numStack.pop();
			oper = operStack.pop();
			res = numStack.cal(num2, num1, oper);
			numStack.push(res);
		}

		// 将数栈的最后数,pop出数栈
		res = numStack.pop();
		System.out.printf("表达式%s=%d", expression, res);
	}
}
