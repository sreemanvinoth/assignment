package com.te.day4addandreverse;

public class UserMainCode {

	public static Integer addAndReverse(Integer[] number, Integer number2) {

		Integer sum = 0;

		for (Integer integer : number) {
			if (integer > number2)
				sum += integer;
		}
		StringBuffer revSum = new StringBuffer();
		revSum.append(sum.toString()).reverse();

		return Integer.parseInt(revSum.toString());
	}

}
