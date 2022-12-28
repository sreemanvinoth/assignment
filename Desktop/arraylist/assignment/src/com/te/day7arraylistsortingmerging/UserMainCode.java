package com.te.day7arraylistsortingmerging;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserMainCode {

	public static List<Integer> sortMergedArrayList(List<Integer> asList1, List<Integer> asList2) {

		List<Integer> list = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();

		list.addAll(asList1);
		list.addAll(asList2);

		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++) {
			if (i == 2 || i == 6 || i == 8) {
				list2.add(list.get(i));
			}
		}

		return list2;
	}

}
