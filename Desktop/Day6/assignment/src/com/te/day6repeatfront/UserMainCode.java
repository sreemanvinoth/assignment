package com.te.day6repeatfront;

public class UserMainCode {

	public static String repeatFirstThreeCharacters(String aString, Integer count) {

		String result = "";
//		if (aString.length() >= 3) {
//			result = aString.substring(0, 3);
//		} else if (aString.length() < 3) {
//			result += aString;
//		}
		for (int i = 0; i < count; i++) {
			if (aString.length() >= 3) {
				result += aString.substring(0, 3);
			} else if (aString.length() < 3) {
				result += aString;
			}
		}
		// result = result.repeat(3);
		return result;
	}

}
