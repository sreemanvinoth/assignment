package com.te.day7arrayliststringarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the size:");
		Integer size = scanner.nextInt();
		System.out.println("Enter the string elements:");
		List<String> list = new ArrayList<String>(size);

		for (int i = 0; i < size; i++) {
			list.add(scanner.next());

		}

		String[] result = UserMainCode.convertToStringArray(list);

		System.out.println(Arrays.toString(result));
	}

}
