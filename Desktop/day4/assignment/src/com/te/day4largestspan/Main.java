package com.te.day4largestspan;

import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Enter the size of array:");
		Integer size = scanner.nextInt();
		System.out.println("Enter the elements:");
		Integer [] number = new Integer[size];
		for (int i = 0; i < number.length; i++) {
			number[i] = scanner.nextInt();
		}
		
		Integer result = UserMainCode.getLargestSpan(number);
		
		System.out.println(result);
	}

}
