package com.qiaomuer.algorithm.linkedlist;

/**
 * <p>
 * 双向链表
 * </p>
 * @author qiaomuer
 * @since 1.0
 */
public class DoubleLinkedList {

	/**
	 * 先初始化一个头节点，头节点不要动，不存放具体的数据
	 */
	private DoubleHeroNode head = new DoubleHeroNode(0, "", "");

	public DoubleHeroNode getHead() {
		return head;
	}

	/**
	 * 添加一个节点
	 * @param data
	 */
	public void addNode(DoubleHeroNode data) {
		DoubleHeroNode tempNode = head;
		while (true) {
			if (tempNode.next == null) {
				break;
			}
			tempNode = tempNode.next;
		}
		tempNode.next = data;
		data.pre = tempNode;
	}

	/**
	 * 更新一个节点
	 * @param data
	 */
	public void updateNode(DoubleHeroNode data) {
		DoubleHeroNode tempNode = head.next;
		// 用于标识在链接中 是否 找到了data.no 的节点
		boolean flag = false;
		while (true) {
			if (tempNode == null) {
				break;
			}
			if (tempNode.no == data.no) {
				flag = true;
				break;
			}
			tempNode = tempNode.next;
		}
		if (flag) {
			tempNode.name = data.name;
			tempNode.nickName = data.nickName;
		} else {
			System.out.println("不存在该节点：" + data);
		}
	}

	/**
	 * 删除一个节点
	 * @param data
	 */
	public void delNode(DoubleHeroNode data){

		DoubleHeroNode tempNode = head.next;
		// 用于标识在链接中 是否 找到了data.no 的节点
		boolean flag = false;
		while (true) {
			if (tempNode == null) {
				break;
			}
			if (tempNode.no == data.no) {
				flag = true;
				break;
			}
			tempNode = tempNode.next;
		}

		if (flag) {
			tempNode.pre.next = tempNode.next;
			if (tempNode.next != null) {
				tempNode.next.pre = tempNode.pre;
			}
		}else{
			System.out.println("不存在该节点：" + data);
		}
	}

	public void list() {
		DoubleHeroNode tempNode = head.next;
		while (tempNode != null) {
			System.out.println(tempNode);
			tempNode = tempNode.next;
		}
	}

}
