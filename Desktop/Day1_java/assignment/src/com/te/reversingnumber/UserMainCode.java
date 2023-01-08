package com.te.reversingnumber;

public class UserMainCode {
	
	public static Integer reverseNumber(int number) {
		
		int reverse = 0;
		System.err.println("drfgwsr");
		while(number != 0) {
			int last = number % 10;
			
			reverse = reverse*10 + last;
			number/=10;
		}
		
		return reverse;
		
	}
	
}
