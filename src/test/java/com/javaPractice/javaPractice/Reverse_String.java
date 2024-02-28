package com.javaPractice.javaPractice;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Reverse_String {
	Scanner sc = new Scanner(System.in);
	String string = sc.nextLine();
	String reverse = "";
	
	@Test(priority = 1, description = "Approach-1: Using String Buffer Class")
	public void reverse_String_Using_String_Buffer_Class() {
		StringBuffer sbuf = new StringBuffer();
		System.out.println("Approach-1: Using String Buffer Class");
		System.out.println(sbuf.append(string).reverse());
	}
	
	@Test(priority = 2, description = "Approach-2: Using String Builder Class")
	public void reverse_String_Using_String_Builder_Class() {
		StringBuilder sbui = new StringBuilder();
		System.out.println("Approach-2: Using String Builder Class");
		System.out.println(sbui.append(string).reverse());
	}
	
	@Test(priority = 3, description = "Approach-3: Using Concatenation Operator")
	public void reverse_String_Using_Concatenation_Operator() {
		for(int i = string.length() - 1 ; i >= 0 ; i--) {
			reverse = reverse + string.charAt(i);
		}
		System.out.println("Approach-3: Using Concatenation Operator");
		System.out.println(reverse);
	}
	
	@Test(priority = 4, description = "Approach-4: Using While Loop")
	public void reverse_String_Using_While_Loop() {
		int i = string.length();
		System.out.println("Approach-4: Using While Loop");
		while(i > 0) {
			System.out.print(string.charAt(i-1));
			i--;
		}
		System.out.println();
	}
	
	@Test(priority = 5, description = "Approach-5: Using Character Array")
	public void reverse_String_Using_Character_Array() {
		char array[] = string.toCharArray();
		System.out.println("Approach-5: Using Character Array");
		for(int j = array.length - 1 ; j >= 0 ; j--) {
			System.out.print(array[j]);
		}
		System.out.println();
	}
	
	@Test(priority = 6, description = "Approach-6: Using Split Method")
	public void reverse_String_Using_Split_Method(){
		String token[] = string.split("");
		System.out.println("Approach-6: Using Split Method");
		for(int k = token.length - 1 ; k >= 0 ; k--) {
			System.out.print(token[k]);
		}
		System.out.println();
	}

}
