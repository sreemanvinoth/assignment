package com.te.sumofsquaresevendigits;

import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Enter the integer ");
		
		Integer number = scanner.nextInt();
		
		System.out.println(UserMainCode.sumOfSquaresOfEvenDigits(number));
	}

}
