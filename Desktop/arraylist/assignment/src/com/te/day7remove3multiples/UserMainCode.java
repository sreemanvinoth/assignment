package com.te.day7remove3multiples;

import java.util.ArrayList;
import java.util.List;

public class UserMainCode {

	public static List<Integer> removeMultiplesOfThree(List<Integer> list) {
		List<Integer> integers = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			if ((i + 1) % 3 != 0) {
				integers.add(list.get(i));
			}
		}

		return list;
	}

}
