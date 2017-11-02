package com.zt.search;

public class LineSearch {

	public static void main(String[] args) {
//		int index = find(DataSource.array, 2);
//		System.out.println("index = " + index);
		int index = find(DataSource.array, 200);
		System.out.println("index = " + index);
	
	}

	public static int find(int[] array, int num){
		if(array == null || array.length == 0){
			return -1;
		}
		
		for (int i = 0; i < array.length; i++) {
			if(array[i] == num)
				return i;
			
		}

		return -1;
		
	}
}