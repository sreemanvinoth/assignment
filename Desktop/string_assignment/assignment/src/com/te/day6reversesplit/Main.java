package com.te.day6reversesplit;

import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the String:");
		String string = scanner.next();
		System.out.println("enter the special character");
		String special = scanner.next();
		
		String result = UserMainCode.reshape(string,special);
		System.out.println(result);
	}

}
