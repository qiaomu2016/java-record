package com.qiaomuer.algorithm.queue;

/**
 * <p>
 * 循环数组对象
 * </p>
 * @author qiaomuer
 * @since 1.0
 */
public class CircleArray {

	/**
	 * 数组的最大容量
	 */
	private int maxSize;

	/**
	 * 存在数据的数组，模拟队列
	 */
	private int[] arr;

	/**
	 * 指向队列的第一个元素，初始值为0
	 */
	private int front;

	/**
	 * 指向队列的最后一个元素的后一个位置，初始值为0
	 */
	private int rear;

	public CircleArray(int maxSize) {
		this.maxSize = maxSize;
		arr = new int[maxSize];
	}

	/**
	 * 判断队列是否已经满
	 * @return
	 */
	public boolean isFull() {
		return (rear + 1) % maxSize == front;
	}

	/**
	 * 判断队列是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return rear == front;
	}

	/**
	 * 添加数据到队列
	 * @param data
	 */
	public void addQuque(int data) {
		// 先判断队列是否已满
		if (isFull()) {
			System.out.println("队列已满 ，不能加入数据");
			return;
		}
		// 直接将数据加入rear位置
		arr[rear] = data;
		// 将rear后移
		rear = (rear + 1) % maxSize;
	}

	/**
	 * 获取队列的数据，出队列
	 * @return
	 */
	public int getQuque() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空 ，不能获取数据");
		}
		int data = arr[front];
		front = (front + 1) % maxSize;
		return data;
	}

	/**
	 * 显示队列所有数据
	 */
	public void showQueue() {
		if (isEmpty()) {
			System.out.println("队列为空 ，不能获取数据");
			return;
		}
		for (int i = front; i < front + size(); i++) {
			System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
		}
	}

	/**
	 * 获取当前队列有效数据的个数
	 * @return
	 */
	public int size() {
		return (rear + maxSize - front) % maxSize;
	}

	/**
	 * 显示队列的头数据，注意不是取出数据
	 * @return
	 */
	public int head() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空 ，不能获取数据");
		}
		return arr[front];
	}
}
