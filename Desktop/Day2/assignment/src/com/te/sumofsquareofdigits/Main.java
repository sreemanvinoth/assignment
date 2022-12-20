package com.te.sumofsquareofdigits;

import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Enter the Positive integer:");
		Integer number = scanner.nextInt();
		
		Integer result=UserMainCode.getSumOfSquareOfDigits(number);
		System.out.println("The Sum of Square Of Digits Of "+number+" is: "+result);
		
	}

}
