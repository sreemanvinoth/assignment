package com.te.checksumofodddigits;

public class UserMainCode {

	public static int checkSum(int number) {
		int sum = 0;
		while (number != 0) {
			int last = number % 10;

			if (last % 2 == 1) {
				sum += last;
			}
			number/=10;

		}
		if (sum % 2 == 1)
			return 1;
		else
			return -1;

	}

}
