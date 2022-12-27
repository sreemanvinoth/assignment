package com.te.day4formingnewword;

import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the string:");
		String string = scanner.next();
		System.out.println("Enter a positive integer:");
		Integer number = scanner.nextInt();
		
		String str = UserMainCode.formNewWord(string,number);
		
		System.out.println(str);
	}
}
