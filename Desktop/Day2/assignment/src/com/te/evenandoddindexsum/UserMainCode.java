package com.te.evenandoddindexsum;

public class UserMainCode {

	public static int sumOfOddEvenPositioned(int number) {

		int oddSum = 0;
		int evenSum = 0;

		for (int i = 0; number != 0; i++) {
			int last = number % 10;
			if (i % 2 == 0) {
				oddSum = last + oddSum;
			} else {

				evenSum = last + evenSum;
			}
			number /= 10;

		}
		return oddSum == evenSum ? 1 : -1;

	}

}
