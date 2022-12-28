package com.te.day7vowelsarraylists;

import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the size");
		Integer size = scanner.nextInt();
		String [] strings = new String[size];
		for (int i = 0; i < strings.length; i++) {
			strings[i]=scanner.next();
		}
		
		List<String> result = UserMainCode.matchCharacter(strings);
		for (String string : result) {
			System.out.println(string);
		}
	}

}
