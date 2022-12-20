package com.te.programminglogic;

public class UserMainCode {

	public static Integer getLuckySum(Integer[] numbers) {
		Integer luckySum = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 13) {
				++i;
			} else {
				luckySum = numbers[i] + luckySum;
			}
		}
		return luckySum;
	}

}
