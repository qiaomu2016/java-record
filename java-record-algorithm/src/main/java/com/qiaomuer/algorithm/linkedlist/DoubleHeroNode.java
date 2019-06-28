package com.qiaomuer.algorithm.linkedlist;

/**
 * <p>
 * 双向节点
 * </p>
 * @author qiaomuer
 * @since 1.0
 */
public class DoubleHeroNode {

	public int no;
	public String name;
	public String nickName;
	/**
	 * 指向下一个节点
	 */
	public DoubleHeroNode next;

	/**
	 * 指向上一个节点
	 */
	public DoubleHeroNode pre;

	public DoubleHeroNode(int no, String name, String nickName) {
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "DoubleHeroNode{" + "no=" + no + ", name='" + name + '\'' + ", nickName='" + nickName + '\'' + '}';
	}
}
