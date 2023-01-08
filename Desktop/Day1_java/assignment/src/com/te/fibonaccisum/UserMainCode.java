package com.te.fibonaccisum;

public class UserMainCode {
	static Integer getSumOfNifbos(Integer num) {
		Integer a = 0;
		Integer b = 1;
		Integer c = a + b;
		Integer sum = 0;
		while (num > 0) {
			sum = sum + a;
			a = b;
			b = c;
			c = a + b;
			num--;

		}
		return sum;

	}
}
