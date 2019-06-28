package com.qiaomuer.algorithm.linkedlist;

/**
 * <p>
 * 单链表测试
 * </p>
 * @author qiaomuer
 * @since 1.0
 */
public class DoubleLinkedListDemo {

	public static void main(String[] args) {

		DoubleHeroNode hero1 = new DoubleHeroNode(1, "宋江", "及时雨");
		DoubleHeroNode hero2 = new DoubleHeroNode(2, "卢俊义", "玉麒麟");
		DoubleHeroNode hero3 = new DoubleHeroNode(3, "吴用", "智多星");
		DoubleHeroNode hero4 = new DoubleHeroNode(4, "林冲", "豹子头");

		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		doubleLinkedList.addNode(hero1);
		doubleLinkedList.addNode(hero2);
		doubleLinkedList.addNode(hero3);
		doubleLinkedList.addNode(hero4);
		doubleLinkedList.list();

		System.out.println("----------------------------------");
		doubleLinkedList.updateNode(new DoubleHeroNode(2, "卢俊义2", "玉麒麟"));
		doubleLinkedList.list();

		System.out.println("----------------------------------");
		doubleLinkedList.delNode(new DoubleHeroNode(2, "卢俊义2", "玉麒麟"));
		doubleLinkedList.list();

	}
}
