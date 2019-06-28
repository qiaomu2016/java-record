package com.qiaomuer.algorithm.recursion;

/**
 * <p>
 * 八皇后问题
 * </p>
 * @author qiaomuer
 * @since 1.0
 */
public class Queue8 {

	/**
	 * 八皇后问题，是一个古老而著名的问题，是回溯算法的典型案例。
	 * 该问题是国际西洋棋棋手马克斯·贝瑟尔于1848年提出：在8×8格的国际象棋上摆放八个皇后，使其不能互相攻击，
	 * 即任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法。
	 * 高斯认为有76种方案。1854年在柏林的象棋杂志上不同的作者发表了40种不同的解，
	 * 后来有人用图论的方法解出92种结果。
	 */


	/**
	 * 定义一个max表示其有多少个皇后
	 */
	int max = 8;

	/**
	 * 定义数组array，保存皇后放置位置的结果
	 * 理论上应该创建一个二维数组来表示棋盘，但是实际上通过算法，用一个一维数组即可以解决问题。
	 * array[8]={0,4,7,5,2,6,1,3} // 对应array下标表示第几行，即第几个皇后
	 * array[i]=val，val表示第i+1皇后，放在第i+1行的第val+1列
	 */
	int[] array = new int[max];

	static int count = 0;
	static int judgeCount = 0;

	public static void main(String[] args) {

		Queue8 queue8 = new Queue8();
		queue8.check(0);
		System.out.printf("一共有%d解法\n", count);
		System.out.printf("一其判断冲突的次数%d次", judgeCount);

	}

	/**
	 * 放置第n个皇后
	 * 注意: check是每一次递归时,进入到check中都有 for(int i=0;i<max;i++),因此会有回溯
	 * @param n
	 */
	private void check(int n) {
		if (n == max) {
			print();
			return;
		}

		for (int col = 0; col < max; col++) {
			// 先把当前这个皇后n,放到该行的第col列
			array[n] = col;
			// 判断当放置第n个皇后到col列时,是否冲突
			if (judge(n)) {
				// 不冲突
				// 接着放n+1个皇后，即开始递归
				check(n + 1);
			}
			// 如果冲突，就继续执行 array[n]=i；即将第n个皇后，放置在本行的 后移的一个位置
		}
	}


	private boolean judge(int n) {
		judgeCount++;
		for (int col = 0; col < n; col++) {
			// 说明：
			// 1. array[i] == array[n] 表示判断 第n个皇后是否和前面的n-1个皇后在同一列
			// 2. Math.abs(n - i) == Math.abs(array[n] - array[i])  表示判断 第n个皇后是否 和 第i皇后是否在同一斜线
			// 3. 判断是否在同一行，没有必要，n每次都在递增
			if (array[col] == array[n] || Math.abs(n - col) == Math.abs(array[n] - array[col])) {
				return false;
			}
		}
		return true;
	}


	private void print() {
		count++;
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "");
		}
		System.out.println();
	}
}
