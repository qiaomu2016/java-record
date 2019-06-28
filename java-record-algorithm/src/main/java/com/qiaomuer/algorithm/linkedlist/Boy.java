package com.qiaomuer.algorithm.linkedlist;

/**
 * <p>
 * Boy类
 * </p>
 * @author qiaomuer
 * @since 1.0
 */
public class Boy {

	/**
	 * 编号
	 */
	public int no;

	/**
	 * 指向下一个节点
	 */
	public Boy next;

	public Boy(int no) {
		this.no = no;
	}

	@Override
	public String toString() {
		return "Boy{" + "no=" + no + '}';
	}
}
