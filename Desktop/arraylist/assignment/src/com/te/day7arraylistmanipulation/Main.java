package com.te.day7arraylistmanipulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the size:");
		Integer size = scanner.nextInt();
		List<Integer> integers1 = new ArrayList<Integer>(size);
		List<Integer> integers2 = new ArrayList<Integer>(size);
		System.out.println("List 1:");
		for (int i = 0; i < size; i++) {

			integers1.add(scanner.nextInt());
		}
		System.out.println("List 2:");
		for (int i = 0; i < size; i++) {

			integers2.add(scanner.nextInt());
		}

		List<Integer> result = UserMainCode.generateOddEvenList(integers1, integers2);

		System.out.println(result);

	}
}
