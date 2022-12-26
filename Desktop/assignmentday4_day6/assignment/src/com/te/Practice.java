package com.te;

public class Practice {

	public static void main(String[] args) {
		String myStr = "Hello";
		String myStr1 = new String("Java");
		System.out.println(myStr.hashCode());
		myStr = "java";
		myStr1 = "hello";
		if (myStr == myStr1) {
			System.out.println("same");
		} else
			System.out.println("not Same");
		System.out.println(myStr.hashCode());
	}

}
