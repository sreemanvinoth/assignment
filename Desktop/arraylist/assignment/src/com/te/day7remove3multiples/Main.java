package com.te.day7remove3multiples;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the size:");
		Integer size = scanner.nextInt();
		List<Integer> list = new ArrayList<>(size);
		for (int i = 0; i < size; i++) {
			
			list.add(scanner.nextInt());
			
		}
		List<Integer> result = UserMainCode.removeMultiplesOfThree(list);
		for (Integer integer : result) {
			System.out.println(integer);
		}
	}

}
