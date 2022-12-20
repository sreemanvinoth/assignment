package com.te.sumnonprimenumber;

public class UserMainCode {
	static Integer validatedSum = 0;

	public static Integer addNumbers(Integer j) {

		validatedSum += j;//validatedSum = validatedSum + j;
				
		return validatedSum;

	}

	public static Integer validateNumber(Integer number) {
		int j = 1;
		Integer count = 0;
		
		while (j <= number) {
			for (int i = 1; i <= j; i++) {
				if (j == 1) {
					addNumbers(j);
				} else if (j % i == 0) {
					count++;
				}
			}
			if (count > 2)
				addNumbers(j);
			j++;
			count = 0;
		}
		return validatedSum;

	}

}
