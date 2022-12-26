package com.te.day4finddigits;

public class UserMainCode {

	public static String findNoDigits(Double number) {

		String doubleString = String.valueOf(number);
		Integer decimal = doubleString.indexOf(".");
		

		return doubleString.substring(0, decimal).length() + ":" + doubleString.substring(decimal + 1).length();
	}

}
