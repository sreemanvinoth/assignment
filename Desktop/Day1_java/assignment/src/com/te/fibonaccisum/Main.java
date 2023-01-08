package com.te.fibonaccisum;

import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
		Integer value=UserMainCode.getSumOfNifbos(scanner.nextInt());
		System.out.println(value);
	}
}
