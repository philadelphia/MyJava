package com.zt.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.Collections;

public class BinarySearch {
	private static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) {
		
		list.add(1);
		list.add(4);
		list.add(5);
		list.add(43);
		list.add(43);
		list.add(45);
		list.add(124);
		list.add(156);
//		System.out.println("index == " + find(list, 16, 0 , list.size()));
//		System.out.println("findByRecusive index == " + findByRecusive(list, 16, 0 , list.size()));
		System.out.println("index == " + find(list, 43, 0 , list.size()));
		
		System.out.println("findByRecusive index == " + findByRecusive(list, 43, 0 , list.size()));


		
	}
	
	public static int find(List<Integer> list, int num,int left, int right){
		if(list == null || list.size() == 0){
			return -1;
		}
		
		while(left <= right){
			int middle = (left + right) / 2;
			if(list.get(middle) < num){
				left ++;
			}else if(list.get(middle) > num){
				right --;
			}else {
				return middle;
			}
			
		}

		return -1;
		
	}
	
	public static int findByRecusive(List<Integer> list, int num,int left, int right){
		if(list == null || list.size() == 0){
			return -1;
		}
		
		while(left < right){
			int middle = (left + right) / 2;
			if(list.get(middle) < num){
				find(list, num, left++, right);
			}else if(list.get(middle) > num){
				find(list, num, left, right--);
			}else {
				return middle;
			}
			
		}

		return -1;
		
	}
}