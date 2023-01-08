package com.te.reversingnumber;

import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the integer: ");

		int number = scanner.nextInt();

		System.out.println("Before Reversing integer:" + number);
		int result = UserMainCode.reverseNumber(number);

		System.out.println("Reversed integer: " + result);
	}

}
