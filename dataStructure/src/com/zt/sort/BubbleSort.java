package com.zt.sort;

import com.zt.search.DataSource;

public class BubbleSort {
	public static int[] array = { 1, 3, 3, 6, 34,-435, 90 };
	public static void main(String[] args) {
		
			bubbleSort(array);
			printArray(array);
	}

	/**
	 * 按照升序排序
	 * @param array
	 */
	public static void bubbleSort(int[] array){
		for (int i = 0; i < array.length; i++) {
			
			for (int j = i+1; j < array.length; j++) {
				int temp = array[i];
				if (temp > array[j]) {
					array[i] = array[j];
					array[j] = temp;
					
				}
				
			}
		}
		
	}
	
	public static void printArray(int[] array){
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i] + "\t");
		}
	}
}
