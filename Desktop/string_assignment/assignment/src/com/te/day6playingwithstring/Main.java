package com.te.day6playingwithstring;

import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Enter the size:");
		Integer size = scanner.nextInt();
		System.out.println("Enter the String elements:");
		String [] stringElements = new String [size];
		for (int i = 0; i < stringElements.length; i++) {
			stringElements[i] = scanner.next();
		}
		System.out.println("Enter the nth element:");
		Integer nElement = scanner.nextInt();
		String result = UserMainCode.formString(stringElements, nElement);
		System.out.println(result);
	}
}
