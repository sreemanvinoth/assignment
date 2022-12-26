package com.te.day6reversesplit;

public class UserMainCode {

	public static String reshape(String string, String special) {
		StringBuffer reverse = new StringBuffer();
		for (int i = string.length() - 1; i >= 0; i--) {

			reverse.append(string.toString().charAt(i) + special);
		}
		String result = reverse.deleteCharAt(reverse.length()-1).toString();
		System.out.println();
		return result;
	}

}
