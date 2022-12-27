package com.te.day6playingwithstring;

public class UserMainCode {

	public static String formString(String[] stringElements, Integer nElement) {
		String result = "";
		for (int i = 0; i < stringElements.length; i++) {
			if (stringElements[i].length() >= nElement) {
				char[] charArray = stringElements[i].toCharArray();
				result += charArray[nElement - 1];
			} else if (stringElements[i].length() < nElement) {
				result += "$";
			}
		}

		return result;
	}
}
