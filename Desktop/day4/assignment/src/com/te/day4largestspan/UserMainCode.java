package com.te.day4largestspan;

public class UserMainCode {

	public static Integer getLargestSpan(Integer[] number) {
		Integer count = 0;
		Integer maxNumber = 0;
		Integer maxCount = 0;
		for (int i = 0; i < number.length; i++) {
			for (int j = 0; j < number.length; j++) {
				if (number[i] == number[j] && count >= 0) {
					count++;
					maxCount = count;
				}
				if ((number[i] != number[j] || i > j) && count > 1)
					count++;
			}
			if (maxCount > count) {
				maxCount = count;
				maxNumber = i;
			}
			count = 0;
		}

		return maxNumber;
	}

}
