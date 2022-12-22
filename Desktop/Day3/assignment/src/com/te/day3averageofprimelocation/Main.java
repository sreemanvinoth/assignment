package com.te.day3averageofprimelocation;

import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("Enter the size of array:");
		Integer size = scanner.nextInt();
		Integer [] numbers = new Integer[size];
		System.out.println("Enter the elements:");
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = scanner.nextInt();
		}
		
		Double average = UserMainCode.averageElements(numbers);
		System.out.println("Average of prime location"+" :"+average);
	}

}
