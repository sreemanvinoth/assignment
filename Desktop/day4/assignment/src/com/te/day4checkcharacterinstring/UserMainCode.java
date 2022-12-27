package com.te.day4checkcharacterinstring;

public class UserMainCode {

	public static Integer checkCharacters(String string) {

		if(string.charAt(0) == string.charAt(string.length()-1)) {
		
			return 1;
		}
		return -1;
	}

}
