package com.te.digits;

public class UserMainCode {
	
	public static Integer countSeven(Integer num) {
		Integer count = 0;
		if (num > -1) {
			while (num > 0) {
				Integer last = num % 10;
				if (last == 7) {
					count++;
				}
				num = num / 10;
			}
			return count;
		} else {
			return 0;
		}
	}

}
