package com.te.day7elementsinarraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Enter the size of list1: ");
		Integer size = scanner.nextInt();
		
		List<String> list = new ArrayList<String>();
		System.out.println("Enter the list1");
		for (int i = 0; i < size; i++) {
			list.add(scanner.next());
		}
		System.out.println("Enter the size of list2:");
		Integer size2 = scanner.nextInt();
		
		List<String> list2 = new ArrayList<String>();
		System.out.println("Enter the list2");
		for (int i = 0; i < size2; i++) {
			list2.add(scanner.next());
		}
		
		List<String> result = UserMainCode.arrayListSubtractor(list, list2);
		for (String string : result) {
			System.out.println(string);
		}
		
		
	}

}
