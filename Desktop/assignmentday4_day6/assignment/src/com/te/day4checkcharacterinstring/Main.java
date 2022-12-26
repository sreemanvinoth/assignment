package com.te.day4checkcharacterinstring;

import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Enter the String: ");
		String string = scanner.nextLine();
		
		Integer result = UserMainCode.checkCharacters(string);

		System.out.println(result);
	}

}
