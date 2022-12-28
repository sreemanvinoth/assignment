package com.te.day7arrayliststringarray;

import java.util.Collections;
import java.util.List;

public class UserMainCode {

	public static String[] convertToStringArray(List<String> list) {

		String[] string = new String[list.size()];
		
		Collections.sort(list);
		
		string = list.toArray(string);
		
		return string;
	}

}
