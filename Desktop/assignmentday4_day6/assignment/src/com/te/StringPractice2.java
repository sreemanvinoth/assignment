package com.te;

import java.util.Scanner;

public class StringPractice2 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter a String: ");
		StringBuffer str = new StringBuffer(scanner.next());
		StringBuffer str1 = str.reverse();

		if (str.toString().equals(str1.reverse().toString())) {
			System.out.println("palindrome");
		}

		else {

			StringBuffer newReverse = new StringBuffer();
			for (int i = str.length() - 1; i >= 0; i--) {

				newReverse.append(str.toString().charAt(i) + "-");
			}
			newReverse.deleteCharAt(newReverse.length() - 1);
			System.out.print("Not Palindrome so (" + newReverse + ")");

		}

	}

}
