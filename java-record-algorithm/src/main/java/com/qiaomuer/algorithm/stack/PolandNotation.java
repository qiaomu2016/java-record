package com.qiaomuer.algorithm.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <p>
 * 逆波兰表达式
 * </p>
 * @author qiaomuer
 * @since 1.0
 */
public class PolandNotation {

	public static void main(String[] args) {

		String expression = "((9/3)*2-5)+10-(6+9)*2-4";


		List<String> infixExpressionList = toInfixExpressionList(expression);
		//[(, (, 9, /, 3, ), *, 2, -, 5, ), +, 10, -, (, 6, +, 9, ), *, 2, -, 4]
		System.out.println(infixExpressionList);

		List<String> suffixExpressionList = parseSuffixExpressionList(infixExpressionList);
		// [9, 3, /, 2, *, 5, -, 10, +, 6, 9, +, 2, *, -, 4, -]
		System.out.println(suffixExpressionList);

		System.out.printf("%s=%d", expression, suffixExpressionCalc(suffixExpressionList));

	}

	/**
	 * 将中缀表达式对应的List =》 后缀表达式对应的List
	 * @param infixExpressionList
	 * @return
	 */
	public static List<String> parseSuffixExpressionList(List<String> infixExpressionList) {


		/**
		 *  将中缀表达式转换成后缀表达式算法：
		 * 　　1、从左至右扫描一中缀表达式。
		 * 　　2、若读取的是操作数，则判断该操作数的类型，并将该操作数存入操作数堆栈
		 * 　　3、若读取的是运算符
		 * 　　　　(1) 该运算符为左括号"("，则直接存入运算符堆栈。
		 * 　　　　(2) 该运算符为右括号")"，则输出运算符堆栈中的运算符到操作数堆栈，直到遇到左括号为止。
		 * 　　　　(3) 该运算符为非括号运算符：
		 * 　　　　　　(a) 若运算符堆栈栈顶的运算符为括号（只可能是左括号），则直接存入运算符堆栈。
		 * 　　　　　　(b) 若比运算符堆栈栈顶的运算符优先级高，则直接存入运算符堆栈。
		 * 　　　　　　(c) 若比运算符堆栈栈顶的运算符优先级低或相等，则不断输出栈顶运算符到操作数堆栈，直到栈顶没有运算符的优先级大于或者等于当前预算符（即栈顶存在运算符的话，优先级一定是小于当前运算符），最后将当前运算符压入运算符堆栈。
		 * 　　4、当表达式读取完成后运算符堆栈中尚有运算符时，则依序取出运算符到操作数堆栈，直到运算符堆栈为空。
		 */

		// 定义两个栈
		// 符号栈
		Stack<String> s1 = new Stack<>();

		// 由于s2这个栈，在整个转换过程中，没有pop操作，而且后面我们还需要逆序输出，因此比较麻烦
		// 这里就不用Stack<String>,直接使用List<String>
		List<String> s2 = new ArrayList<>();

		infixExpressionList.forEach(item -> {
			if (item.matches("\\d+")) {
				s2.add(item);
			} else if (item.equals("(")) {
				s1.push(item);
			}
			// 如果是右括号")",则依次弹出s1栈顶的运算符,并压入s2,直到遇到左括号为止，此时将这一对括号丢弃
			else if (item.equals(")")) {
				while (!s1.peek().equals("(")) {
					s2.add(s1.pop());
				}
				// 消除左括号
				s1.pop();
			} else {
				// 当item的优先级小于等于s1栈顶的运算符,将s1栈顶的运算符弹出并加入到s2中,并循环处理
				while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
					s2.add(s1.pop());
				}
				// 还需要将item压入栈
				s1.push(item);
			}
		});

		while (s1.size() != 0) {
			s2.add(s1.pop());

		}
		return s2;
	}

	static class Operation {
		private static int ADD = 1;
		private static int SUB = 1;
		private static int MUL = 2;
		private static int DIV = 2;

		public static int getValue(String operation) {
			int result = 0;
			switch (operation) {
				case "+":
					result = ADD;
					break;
				case "-":
					result = SUB;
					break;
				case "*":
					result = MUL;
					break;
				case "/":
					result = DIV;
					break;
				default:
					break;

			}
			return result;
		}
	}


	/**
	 * 将中缀表达的 每个字符 转换成 List
	 * @param expression
	 * @return
	 */
	public static List<String> toInfixExpressionList(String expression) {

		List<String> resultList = new ArrayList<>();
		int index = 0;
		String keepNum = "";
		char ch;
		do {
			// 如果ch是一个非数字,需要加到resultList中
			if ((ch = expression.charAt(index)) < 48 || (ch = expression.charAt(index)) > 57) {
				resultList.add("" + ch);
				index++;
			}
			// 为数字，需要考虑多位数
			else {
				keepNum = "";
				while (index < expression.length() && (ch = expression.charAt(index)) >= 48
						&& (ch = expression.charAt(index)) <= 57) {
					keepNum += ch;
					index++;
				}
				resultList.add(keepNum);
			}
		} while (index < expression.length());

		return resultList;
	}

	public static int suffixExpressionCalc(List<String> suffixExpressionList) {

		/**
		 * 逆波兰表达式求值算法：https://www.cnblogs.com/journal-of-xjx/p/5940030.html
		 * 　　1、从左到右依次扫描语法单元的项目。
		 * 　　2、如果扫描的项目是操作数，则将其压入操作数堆栈，并扫描下一个项目。
		 * 　　3、如果扫描的项目是一个二元运算符，则对栈的顶上两个操作数执行该运算。
		 * 　　4、如果扫描的项目是一个一元运算符，则对栈的最顶上操作数执行该运算(暂不考虑)。
		 * 　　5、将运算结果重新压入堆栈。
		 * 　　6、重复步骤2-5，堆栈中即为结果值。
		 *
		 * ((9/3)*2-5)+10-(6+9)*2-4
		 *  [9, 3, /, 2, *, 5, -, 10, +, 6, 9, +, 2, *, -, 4, -]
		 */

		// 创建栈，只需要一个栈即可
		Stack<String> stack = new Stack<>();
		suffixExpressionList.forEach(item -> {
			if (item.matches("\\d+")) {
				stack.push(item);
			} else {
				int num2 = Integer.parseInt(stack.pop());
				int num1 = Integer.parseInt(stack.pop());
				int res = 0;
				if (item.equals("+")) {
					res = num1 + num2;
				} else if (item.equals("-")) {
					res = num1 - num2;
				} else if (item.equals("*")) {
					res = num1 * num2;
				} else if (item.equals("/")) {
					res = num1 / num2;
				} else {
					throw new RuntimeException("运算符有误");
				}
				// 把res入栈
				stack.push("" + res);
			}
		});

		// 最后留在stack中的数据是运算结果
		return Integer.parseInt(stack.pop());
	}

}
