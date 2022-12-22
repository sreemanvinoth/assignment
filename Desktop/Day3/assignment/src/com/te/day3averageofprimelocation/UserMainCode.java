package com.te.day3averageofprimelocation;

import java.text.DecimalFormat;

public class UserMainCode {

	public static Double averageElements(Integer[] numbers) {
		DecimalFormat deciFormate = new DecimalFormat("#.##");
		Integer count = 0;
		Double sum = 0.0;
		Integer i = 0;
		for (int index = 0; index < numbers.length; index++) {
			for (int j = 1; j <= index; j++) {
				if (index == 0 || index == 1)
					break;
				if (index % j == 0)
					count++;
			}
			System.out.println(" " + count);
			if (count == 2) {
				i++;
				sum += numbers[index];
			}
			count = 0;
		}
		Double average = sum / i;
		String avg = deciFormate.format(average);

		return Double.parseDouble(avg);
	}

}
