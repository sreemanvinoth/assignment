package com.te.day4fetchmiddlecharacter;

import java.util.Scanner;

public class Main {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Enter the String:");
		String string = scanner.next();
		
		String str = UserMaincode.getMiddleChar(string);
		
		System.out.println(str);
	}
}
