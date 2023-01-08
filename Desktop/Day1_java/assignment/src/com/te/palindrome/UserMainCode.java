package com.te.palindrome;

public class UserMainCode {
	public static Integer addPalindromes(Integer start, Integer end) {
		Integer temp = 0;
		Integer rev = 0;
		Integer copy = 0;
		Integer sum = 0;
		for (Integer i = start; i <= end; i++) {
			temp = i;
			copy = i;
			while (temp > 0) {

				Integer last = temp % 10;
				rev = rev * 10 + last;
				temp = temp / 10;

				if (rev == copy) {
					sum = sum + copy;
				}
			}
			rev = 0;

		}
		if (sum > 0) {
			return sum;
		} else {
			return 0;
		}

	}
}
