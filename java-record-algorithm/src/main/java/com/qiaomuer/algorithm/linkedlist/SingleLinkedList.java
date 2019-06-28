package com.qiaomuer.algorithm.linkedlist;

import java.util.Stack;

/**
 * <p>
 * 单链表
 * </p>
 * @author qiaomuer
 * @since 1.0
 */
public class SingleLinkedList {

	/**
	 * 先初始化一个头节点，头节点不要动，不存放具体的数据
	 */
	public HeroNode head = new HeroNode(0, "", "");

	/**
	 * 添加节点到单向链表,不考虑编号顺序
	 * 思路：
	 * 1.找到当前链表的最后节点
	 * 2.将最后这个节点的next指向 新的节点
	 * @param node
	 */
	public void add(HeroNode node) {
		HeroNode tempNode = head;
		while (true) {
			if (tempNode.next == null) {
				break;
			}
			tempNode = tempNode.next;
		}
		tempNode.next = node;
	}

	/**
	 * 添加节点到单向链表,需考虑编号顺序
	 * 限制：如果有这个排名，则添加失败，并给出提示
	 * @param node
	 */
	public void addByOrder(HeroNode node) {
		HeroNode tempNode = head;
		// 用于标志添加的编号是否已经存在
		boolean flag = false;
		while (true) {
			if (tempNode.next == null) {
				break;
			}
			if (tempNode.next.no > node.no) {
				break;
			} else if (tempNode.next.no == node.no) {
				flag = true;
				break;
			}
			tempNode = tempNode.next;
		}
		if (flag) {
			System.out.printf("准备插入的节点的编号%d已经存在，不能加入\n", node.no);
		} else {
			node.next = tempNode.next;
			tempNode.next = node;
		}
	}

	/**
	 * 根据节点的no进行更新
	 * @param node
	 */
	public void updateNode(HeroNode node) {
		// 用于标志节点是否找到
		boolean flag = false;
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		HeroNode tempNode = head.next;
		while (true) {
			if (tempNode == null) {
				break;
			}
			if (tempNode.no == node.no) {
				flag = true;
				break;
			}
			tempNode = tempNode.next;
		}
		if (flag) {
			tempNode.name = node.name;
			tempNode.nickName = node.nickName;
		}
	}

	/**
	 * 根据节点的no 删除节点
	 * @param node
	 */
	public void delNode(HeroNode node) {
		HeroNode tempNode = head;
		// 用于标志节点是否找到
		boolean flag = false;
		if (tempNode.next == null) {
			System.out.println("链表为空");
			return;
		}
		while (true) {
			if (tempNode.next == null) {
				break;
			}
			if (tempNode.next.no == node.no) {
				flag = true;
				break;
			}
			tempNode = tempNode.next;
		}
		if (flag) {
			tempNode.next = tempNode.next.next;
		}
	}

	/**
	 * 显示链表
	 */
	public void list() {
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		HeroNode tempNode = head.next;
		while (true) {
			if (tempNode == null) {
				break;
			}
			System.out.println(tempNode);
			tempNode = tempNode.next;
		}
	}

	/**
	 * 获取链接的长度(如果有头结点,则不包括头结点)
	 * @return
	 */
	public static int getLength(HeroNode head) {
		if (head.next == null) {
			return 0;
		}
		HeroNode tempNode = head.next;
		int length = 0;
		while (tempNode != null) {
			length++;
			tempNode = tempNode.next;
		}
		return length;
	}

	/**
	 * 查询单链表中倒数第index个结点
	 * @param head
	 * @param index
	 * @return
	 */
	public static HeroNode findLastIndexNode(HeroNode head, int index) {

		// 1.获取链表的长度
		int size = getLength(head);
		if (index > size || index <= 0) {
			return null;
		}
		// 2.获取要查找位置 (size - index) 的结点即可
		HeroNode tempNode = head.next;
		for (int i = 0; i < size - index; i++) {
			tempNode = tempNode.next;
		}
		return tempNode;
	}

	/**
	 * 反转单链表
	 * @param head
	 */
	public static void reversetList(HeroNode head) {
		// 没有节点或只有一个节点 不用 反转
		if (head.next == null || head.next.next == null) {
			return;
		}
		HeroNode reversetHead = new HeroNode(0, "", "");
		HeroNode cur = head.next;
		// 指向当前节点的下一个节点
		HeroNode next;
		// 遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reversetHead 的最新端
		while (cur != null) {
			// 先暂时保存当前节点的下一个节点，因为后面需要使用
			next = cur.next;
			// 将cur的下一个节点指向新的链表的最新端
			cur.next = reversetHead.next;
			// 将cur 连接到新的链表上
			reversetHead.next = cur;
			// 让cur后移
			cur = next;
		}
		// 将head.next 指向 reversetHead.next，实现单链表的反转
		head.next = reversetHead.next;
	}


	/**
	 * 通过栈方式逆序打印
	 * @param head
	 */
	public static void reversePrintByStack(HeroNode head) {
		if (head.next == null) {
			return;
		}
		Stack<HeroNode> stack = new Stack<>();

		HeroNode cur = head.next;
		while (cur!=null){
			stack.push(cur);
			cur = cur.next;
		}
		while(stack.size()>0){
			System.out.println(stack.pop());
		}
	}
}
