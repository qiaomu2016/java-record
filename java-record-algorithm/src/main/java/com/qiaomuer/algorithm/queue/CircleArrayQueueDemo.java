package com.qiaomuer.algorithm.queue;

import java.util.Scanner;

/**
 * <p>
 * 测试类
 * </p>
 * @author qiaomuer
 * @since 1.0
 */
public class CircleArrayQueueDemo {

	public static void main(String[] args) {
		// 创建一个环形队列，大小设置为4，其队列的有效数据最大是3
		CircleArray queue = new CircleArray(4);
		// 接收用户输入
		char key;
		Scanner scanner = new Scanner(System.in);

		boolean loop = true;
		while (loop) {
			key = scanner.next().charAt(0);
			switch (key) {
				// 显示队列所有数据
				case 's':
					queue.showQueue();
					break;
				// 添加数据到队列
				case 'a':
					System.out.println("输入一个数");
					queue.addQuque(scanner.nextInt());
					break;
				// 获取队列的数据，出队列
				case 'g':
					int res = queue.getQuque();
					System.out.printf("取出的数据是%d\n", res);
					break;
				case 'h':
					res = queue.head();
					System.out.printf("头节点的数据是%d\n", res);
					break;
				// 退出
				case 'e':
					scanner.close();
					loop = false;
					break;
				default:
					break;
			}
		}
	}
}
