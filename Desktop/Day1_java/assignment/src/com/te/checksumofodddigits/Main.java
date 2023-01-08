package com.te.checksumofodddigits;

import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Enter a positive integer: ");
		Integer number = scanner.nextInt();

		Integer result = UserMainCode.checkSum(number);
		System.out.println(result);

//		if (1 == result)
//			System.out.println("Sum of Odd digits is odd");
//		else
//			System.out.println("sum of Odd digits is even");

	}

}
