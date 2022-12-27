package com.te.day4addandreverse;

import java.util.Scanner;

public class Main {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Enter the size of array:");
		Integer size = scanner.nextInt();
		System.out.println("Enter the elements:");
		Integer number [] = new Integer[size];
		for (int i = 0; i < number.length; i++) {
			number[i] = scanner.nextInt();
			
		}
		System.out.println("Enter the number to sum above it:");
		Integer number2 = scanner.nextInt();
		
		Integer result = UserMainCode.addAndReverse(number,number2);
		System.out.println(result);
	}
}
