package com.te.day4formingnewword;

public class UserMainCode {

	public static String formNewWord(String string, Integer number) {
		
		String str = "";
		int length = string.length()-number;
		
		for (int i = 0; i < number+number; i++) {
			if(i<number) {
				str+=string.charAt(i);
			}
			else if(length<string.length()) {
				str+=string.charAt(length);
				length++;
			}
		}
		
		return str;
	}
	
	

}
