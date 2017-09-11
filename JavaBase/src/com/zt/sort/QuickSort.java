package com.zt.sort;

public class QuickSort {

	private static int[] array = { 1, 3, 3, 6, 34, 2, 4325, 23, 45, 0, -1, -4, -435, 90 };

	public static void main(String[] args) {
		new QuickSort().quick(array);
	}

	public static void quickSort(int[] array) {
		System.out.println("---------------befort sort-----------------");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
		}

		int start = 0;
		int end = array.length - 1;
		int temp = array[start];
		while (start <= end) {
			int middle = (start + end) / 2;

			while (array[start] < array[middle] && start < end) {
				start++;
			}
			while (array[middle] < array[end] && start < end) {
				end--;
			}

		}

		System.out.println();

		System.out.println("------------after sort------------");

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
		}

	}

	public int getMiddle(int[] list, int low, int high) {
		int tmp = list[low]; // 数组的第一个作为中轴
		while (low < high) {
			while (low < high && list[high] >= tmp) {
				high--;
			}

			list[low] = list[high]; // 比中轴小的记录移到低端
			while (low < high && list[low] <= tmp) {
				low++;
			}

			list[high] = list[low]; // 比中轴大的记录移到高端
		}
		list[low] = tmp; // 中轴记录到尾
		return low; // 返回中轴的位置
	}

	public void _quickSort(int[] list, int low, int high) {
		if (low < high) {
			int middle = getMiddle(list, low, high); // 将list数组进行一分为二
			_quickSort(list, low, middle - 1); // 对低字表进行递归排序
			_quickSort(list, middle + 1, high); // 对高字表进行递归排序
		}
	}

	public void quick(int[] array) {
		System.out.println("---------------befort sort-----------------");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
		}

		if (array.length > 0) { // 查看数组是否为空
			_quickSort(array, 0, array.length - 1);
		}
		
		System.out.println();

		System.out.println("------------after sort------------");

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
		}
	}

}
