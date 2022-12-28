package com.te.day7elementsinarraylist;

import java.util.ArrayList;
import java.util.List;

public class UserMainCode {
	
	public static List arrayListSubtractor(List<String> string1,List<String> string2) {
		List<String> list1 = new ArrayList<String>(string1);
		list1.removeAll(string2);
		
		List<String> list2 = new ArrayList<String>(string2);
		list2.removeAll(string1);
		
		List<String> result = new ArrayList<String>(list1);
		result.addAll(list2);
		
		return result;
	}

}
