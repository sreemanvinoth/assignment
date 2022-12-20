package com.te.sumnonprimenumber;

import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("Enter the positive integer");
		Integer number = scanner.nextInt();
		
		
		Integer result = UserMainCode.validateNumber(number);
		System.out.println("Sum of NON Prime Numbers until "+number+" - "+result);
	}

}
