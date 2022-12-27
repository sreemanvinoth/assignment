package com.te.day4triplets;

public class UserMainCode {

	public static Boolean checkTriplets(Integer[] numbers) {
		Integer count = 0;
		Integer last = 0;
		Boolean result = false;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				if (numbers[i] == numbers[j]) {
					count++;
					last = j;
				}
				if (count == 3 && (i - last == 2)) {
					result = true;
					break;
				}
			}
			count = 0;
		}
		return result;
	}

}
