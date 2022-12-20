package com.te.programminglogic;

import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Integer numbers[] = new Integer[3];
		System.out.println("Enter three number: ");
		for (int i = 0; i < 3; i++) {
			System.out.print("number "+(i+1)+": ");
			numbers[i]=scanner.nextInt();
		}
		System.out.println(UserMainCode.getLuckySum(numbers));
	}

}
