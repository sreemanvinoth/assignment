package com.te;

import java.util.Scanner;

public class StringPractice {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the string: ");
		char[] string = scanner.next().toCharArray();
		Integer result = 0;
		for (int j = 0; j < string.length; j++) {
		Character ch = string[j];
			if(ch.isDigit(string[j])) {
				result += Integer.parseInt(ch.toString());
			}
			
		}
		System.out.println(result);

	}

}
