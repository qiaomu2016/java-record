package com.qiaomuer.algorithm.linkedlist;

/**
 * <p>
 * 单链表测试
 * </p>
 * @author qiaomuer
 * @since 1.0
 */
public class SingleLinkedListDemo {

	public static void main(String[] args) {

		HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
		HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
		HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
		HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

		SingleLinkedList singleLinkedList = new SingleLinkedList();
		singleLinkedList.addByOrder(hero1);
		singleLinkedList.addByOrder(hero2);
		singleLinkedList.addByOrder(hero3);
		singleLinkedList.addByOrder(hero4);
		singleLinkedList.list();

		System.out.println("----------------------------------");
		singleLinkedList.updateNode(new HeroNode(2, "卢俊义2", "玉麒麟"));
		singleLinkedList.list();

		System.out.println("----------------------------------");
		singleLinkedList.delNode(new HeroNode(2, "卢俊义2", "玉麒麟"));
		singleLinkedList.list();

		System.out.println("length:" + SingleLinkedList.getLength(singleLinkedList.head));

		System.out.println("node:" + SingleLinkedList.findLastIndexNode(singleLinkedList.head, 2));

		System.out.println("----------------------------------");
		SingleLinkedList.reversetList(singleLinkedList.head);
		singleLinkedList.list();

		System.out.println("----------------------------------");
		SingleLinkedList.reversePrintByStack(singleLinkedList.head);

	}
}
