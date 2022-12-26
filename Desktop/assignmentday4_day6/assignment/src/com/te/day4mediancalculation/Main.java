package com.te.day4mediancalculation;

import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the size ");
		Integer size = scanner.nextInt();
		System.out.println("Enter the elements");
		Integer numbers[] = new Integer[size];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = scanner.nextInt();
		}
		Integer result = UserMainCode.calculateMedian(numbers);
		System.out.println(result);
	}

}
