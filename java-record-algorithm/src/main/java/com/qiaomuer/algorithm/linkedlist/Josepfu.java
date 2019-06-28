package com.qiaomuer.algorithm.linkedlist;

/**
 * <p>
 * 约瑟夫问题
 * </p>
 * @author qiaomuer
 * @since 1.0
 */
public class Josepfu {

	public static void main(String[] args) {
		CircleSingleLinkedList circle = new CircleSingleLinkedList();
		circle.addBoy(10);
		circle.showBoy();
		System.out.println("----------------------------------");
		circle.countBoy(2,4,10);
	}
}
