package com.te.day6stringoccurance;

import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Enter the string1:");
		String string1 = scanner.next();
		
		System.out.println("Enter the string2:");
		String string2 = scanner.next();
		
		Integer result = UserMainCode.getSubString(string1,string2);
	}

}
