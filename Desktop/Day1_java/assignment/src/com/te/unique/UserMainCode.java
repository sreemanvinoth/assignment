package com.te.unique;

public class UserMainCode {

	public static String getUnique(Integer num) {
		boolean unique = true;
		String str = Integer.toString(num);
		for (Integer i = 0; i < str.length(); i++) {
			for (Integer j = i+1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					unique = false;
				}
			}

		}
		if (unique == true) {
			return "unique";
		} else {
			return "not unique";
		}
	}
	
}
