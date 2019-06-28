package com.qiaomuer.algorithm.linkedlist;

/**
 * <p>
 * 环形单向链表
 * </p>
 * @author qiaomuer
 * @since 1.0
 */
public class CircleSingleLinkedList {

	/**
	 * 创建一个first节点，当前没有编号
	 */
	private Boy first;

	/**
	 * 添加nums个节点，构成环形链表
	 * @param nums
	 */
	public void addBoy(int nums) {
		if (nums < 1) {
			return;
		}
		// 辅助指针，帮助构建环形链表
		Boy curBoy = null;
		for (int i = 1; i <= nums; i++) {
			Boy boy = new Boy(i);
			if (i == 1) {
				first = boy;
				first.next = first;
			} else {
				curBoy.next = boy;
				boy.next = first;
			}
			curBoy = boy;
		}
	}

	/**
	 * 遍历
	 */
	public void showBoy() {
		if (first == null) {
			return;
		}
		Boy temp = first;
		do {
			System.out.println(temp);
			temp = temp.next;
		} while (temp != first);
	}

	/**
	 * 计算小孩的出圈顺序
	 * @param startNo 表示从第几个小孩开始数数
	 * @param countNum 表示数几下
	 * @param nums 表示最初有多个小孩在圈中
	 */
	public void countBoy(int startNo, int countNum, int nums) {
		if (first == null || startNo < 1 || startNo > nums) {
			return;
		}
		// 创建一个辅助变量，事先应该指向环形链表的最后一个节点
		Boy helper = first;
		while (true) {
			if (helper.next == first) {
				break;
			}
			helper = helper.next;
		}

		// 小孩报数前，先让first和helper移动k-1次
		for (int j = 0; j < startNo - 1; j++) {
			first = first.next;
			helper = helper.next;
		}

		// 当孩报数时，让first和helper同时移动m-1次，然后出圈
		while (true) {
			// 说明圈中只有一个节点
			if (helper == first) {
				break;
			}

			for (int j = 0; j < countNum - 1; j++) {
				first = first.next;
				helper = helper.next;
			}

			// 这时first指向的节点，就是要出圈的小孩节点
			System.out.printf("小孩%d出圈\n", first.no);
			first = first.next;
			helper.next = first;
		}

		System.out.printf("最后留在圈中的小孩编号%d\n", first.no);

	}
}
