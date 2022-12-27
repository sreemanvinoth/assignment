package com.te.day4removingvowels;

public class UserMainCode {

	public static String removeEvenVowels(String string) {

		String str = "";
		Integer[] index = {};
		StringBuffer buf = new StringBuffer(string);

		for (int i = 0; i < buf.length(); i++) {
			if (i % 2 == 0) {
				buf.deleteCharAt(i);
			}
		}
		System.out.println(buf);

		for (int i = 0; i < string.length(); i++) {
			if (i % 2 == 0) {
				if (string.charAt(i) != 'a' && string.charAt(i) != 'e' && string.charAt(i) != 'i'
						&& string.charAt(i) != 'o' && string.charAt(i) != 'u' && string.charAt(i) != 'A'
						&& string.charAt(i) != 'E' && string.charAt(i) != 'I' && string.charAt(i) != 'O'
						&& string.charAt(i) != 'U') {
					str = str + string.charAt(i);
				}
			}
		}
		System.out.println(string);
		return str;
	}
}
