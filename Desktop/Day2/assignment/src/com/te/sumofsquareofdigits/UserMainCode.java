package com.te.sumofsquareofdigits;

public class UserMainCode {

	public static Integer getSumOfSquareOfDigits(Integer number) {
		Integer sum=0;
		while(number!=0) {
			int last = number%10;
			sum += last*last;//sum = sum + (last*last)
			number/=10;
		}
		
		return sum;
	}

}
