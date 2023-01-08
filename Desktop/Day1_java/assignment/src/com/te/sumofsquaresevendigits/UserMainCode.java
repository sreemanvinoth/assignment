package com.te.sumofsquaresevendigits;

public class UserMainCode {

	public static Integer sumOfSquaresOfEvenDigits(Integer number) {

		int sum = 0;

		while (number != 0) {
			int last = number % 10;
			if (last % 2 == 0) {
				sum = last * last + sum;
			}
			number/=10;
		}
		return sum;

	}

}
