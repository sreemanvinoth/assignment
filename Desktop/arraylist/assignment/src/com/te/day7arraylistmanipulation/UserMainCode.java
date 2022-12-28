package com.te.day7arraylistmanipulation;

import java.util.ArrayList;
import java.util.List;

public class UserMainCode {

	public static List<Integer> generateOddEvenList(List<Integer> integers1, List<Integer> integers2) {
		List<Integer> integers = new ArrayList<Integer>(integers1.size());
		for (int i = 0; i < integers1.size(); i++) {
			for (int j = 0; j < integers2.size(); j++) {
				if (integers1.get(i) % 2 != 0 && j % 2 != 0) {
					integers.add(integers1.get(i));
					break;
				} else if (integers1.get(i) % 2 == 0 && j % 2 == 0) {
					integers.add(integers2.get(i));
					break;
				}
			}
			
		}
		return integers;

	}
}
