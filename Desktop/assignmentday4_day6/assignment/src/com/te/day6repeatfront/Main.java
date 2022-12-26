package com.te.day6repeatfront;

import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter a String:");
		String aString = scanner.next();
		System.out.println("Enter the positive integer:");
		Integer count = scanner.nextInt();
		
		String result = UserMainCode.repeatFirstThreeCharacters(aString,count);
		System.out.println(result);
	}

}
