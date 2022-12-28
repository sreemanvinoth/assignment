package com.te.day7arraylistsortingmerging;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		List<Integer> asList1 = new ArrayList<Integer>();
		Integer [] integers = new Integer[5];
		//List<Integer> asList = Arrays.asList(integers);
		System.out.println("list1");
		for (int i = 0; i < 5; i++) {
			integers[i]=scanner.nextInt();
		}
		asList1 = Arrays.asList(integers);
		Integer [] integers2 = new Integer[5];
		System.out.println("list2");
		List<Integer> asList2 = new ArrayList<Integer>();
		
		for (int i = 0; i < 5; i++) {
			integers2[i]=scanner.nextInt();
		}
		asList2 = Arrays.asList(integers2);
		List<Integer> result = UserMainCode.sortMergedArrayList(asList1,asList2);
		for (Integer integer : result) {
		System.out.println(integer);	
		}
	}
}
