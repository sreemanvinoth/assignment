package com.te.day4mediancalculation;

import java.util.Arrays;

public class UserMainCode {

	public static Integer calculateMedian(Integer[] numbers) {
		Integer sum = 0;
		Double avg = 0.0;
		Arrays.sort(numbers);
		for (Integer integer : numbers) {
			System.out.print(integer + " ");
		}
		System.out.println();
		if (numbers.length % 2 == 0) {

			for (int i = numbers.length / 2 - 1; i <= numbers.length / 2; i++) {
				sum += numbers[i];
			}
			avg = (sum.doubleValue() / 2) + 0.5;

		} else {
			for (int i = numbers.length / 2; i <= numbers.length / 2; i++) {
				sum += numbers[i];
			}
			return sum;

		}

		return avg.intValue();
	}
	
	

}
