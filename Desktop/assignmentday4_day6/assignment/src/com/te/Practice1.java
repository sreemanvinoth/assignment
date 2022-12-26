package com.te;

import java.util.Scanner;

public class Practice1 {
static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		String rev = "";
		String string = "vinoth";

		for (int i = string.length()-1; i >= 0; i--) {

			rev += string.charAt(i);

		}
		System.out.println("Before Reversing:" + string);
		System.out.println("after Reversing:" + rev);
		
		usingStringBuffer();
	}

	private static void usingStringBuffer() {

		StringBuffer str = new StringBuffer(scanner.next());
		StringBuffer str1 = str.reverse();
		
		if(str.toString().equals(str1.reverse().toString())) {
			System.out.println("palindrome");
		}
		
		else {
			StringBuffer newReverse = new StringBuffer();
			for (int i = str.length()-1; i >= 0; i--) {
				
				newReverse.append(str.toString().charAt(i)+"-");
			}
			newReverse.deleteCharAt(newReverse.length()-1);
			System.out.println(newReverse);
			
		}
			//System.out.println("not palindrome");
		
	}
	
	
	
	
}

