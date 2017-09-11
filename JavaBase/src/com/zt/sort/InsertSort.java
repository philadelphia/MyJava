package com.zt.sort;

public class InsertSort {
	private static int[] array= {1,3,3,6,34,2,4325,23,45,0,-1,-4,-435,90};
	public static void main(String[] args) {
		insertSort(array);
	}
	
	public  static void insertSort(int[] array){
		System.out.println("---------------befort sort-----------------");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
		}
		for (int i = 0; i < array.length-1; i++) {
			for(int j = i + 1; j > 0; j--){
				if(array[j-1] <= array[j]){
					break;
				}
				int temp = array[j];
				array[j] = array[j-1];
				array[j-1] = temp;
				
			}
			
		}
		System.out.println();
		
		System.out.println("------------after sort------------" );

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
		}
		
	}

}
