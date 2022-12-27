package com.te.day4removing10;

public class UserMainCode {

	public static Integer[] removeTens(Integer[] number) {
		Integer result[] = new Integer[number.length];
		for (int i = 0, j = 0; i < number.length; i++) {
			if (!(number[i] == 10)) {
				result[j++] = number[i];
			}
		}
		return result;
	}

}
