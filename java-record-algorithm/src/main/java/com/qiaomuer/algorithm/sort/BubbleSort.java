package com.qiaomuer.algorithm.sort;

import java.util.Arrays;

/**
 * <p>
 * 冒泡排序
 * </p>
 * @author qiaomuer
 * @since 1.0
 */
public class BubbleSort {

	public static void main(String[] args) {
		int arr[] = {6, 1, 4, 9, 7, 10, 5, -1};
		bubbleSort(arr);
		System.out.printf(Arrays.toString(arr));
	}

	public static void bubbleSort(int[] arr) {
		// 临时变量
		int temp = 0;
		// 标识是否有进行过交换
		boolean flag = false;

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					flag = true;
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			if (!flag) {
				break;
			} else {
				flag = false;
			}
		}
	}
}
