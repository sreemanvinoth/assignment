package com.te.day4removingvowels;

import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the string:");
		String string = scanner.next();
		
		String str = UserMainCode.removeEvenVowels(string);
		
		System.out.println(str);
	}

}
