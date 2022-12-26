package com.te.day4finddigits;

import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Enter a double value: ");
		Double number = scanner.nextDouble();

		String result = UserMainCode.findNoDigits(number);

		System.out.println(result);
	}

}
