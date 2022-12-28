package com.te.day7vowelsarraylists;

import java.util.ArrayList;
import java.util.List;

public class UserMainCode {

	public static List<String> matchCharacter(String[] strings) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < strings.length; i++) {
			if ((strings[i].charAt(0) == 'a' || strings[i].charAt(0) == 'e' || strings[i].charAt(0) == 'i'
					|| strings[i].charAt(0) == 'o' || strings[i].charAt(0) == 'u')
					&& (strings[i].charAt(strings[i].length() - 1) == 'a'
							|| strings[i].charAt(strings[i].length() - 1) == 'e'
							|| strings[i].charAt(strings[i].length() - 1) == 'i'
							|| strings[i].charAt(strings[i].length() - 1) == 'o'
							|| strings[i].charAt(strings[i].length() - 1) == 'u')) {
				list.add(strings[i]);
			}
		}

		return list;
	}

}
