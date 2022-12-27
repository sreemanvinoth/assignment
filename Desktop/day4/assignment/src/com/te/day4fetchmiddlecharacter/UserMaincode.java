package com.te.day4fetchmiddlecharacter;

public class UserMaincode {

	public static String getMiddleChar(String string) {

		Integer mid = (string.length() - 1) / 2;
		Integer nextMid = mid + 1;
		String result = "";

		for (int i = 0; i < string.length(); i++) {

			if (i == mid || i == nextMid) {
				result += string.charAt(i);
			}
		}

		return result;
	}

}
