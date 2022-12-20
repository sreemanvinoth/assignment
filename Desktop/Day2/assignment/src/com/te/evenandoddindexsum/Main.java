package com.te.evenandoddindexsum;

import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("Enter the positive integer");
		Integer number = scanner.nextInt();
		
		Integer result=UserMainCode.sumOfOddEvenPositioned(number);
		
		if (result==1) 
			System.out.println("yes");
		else
			System.out.println("no");
		
	}

}
