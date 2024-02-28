package com.javaPractice.javaPractice;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Count_Number_Of_Digits_In_Integer {
	Scanner sc = new Scanner(System.in);
	int number = sc.nextInt();
	
	@Test(priority = 1, description = "Count Number of Digits in Integer Using While Loop")
	public void count_Number_Of_Digits_In_Integer_Using_While_Loop() {
		int enteredNumber = number;
		int count = 0;
		while(enteredNumber!=0) {
			enteredNumber = enteredNumber / 10;
			count++;
		}
		System.out.println("Total Number of Digits in "+number+" is "+count);
	}
	
	@Test(priority = 2, description = "Count Number of Digits in Integer Using String.valueOf() Method")
	public void count_Number_Of_Digits_In_Integer_Using_String_value_Of_Method() {
		String string = String.valueOf(number).replaceAll("-", "");
		int length = string.length();
		System.out.println("Total Number of Digits in "+number+" is "+length);
	}
	
	@Test(priority = 3, description = "Count Number of Digits in Integer Using Concatenation Operator")
	public void count_Number_Of_Digits_In_Integer_Using_Concatenation_Operator() {
		String string = ""+number;
		int length = string.replaceAll("-", "").length();
		System.out.println("Total Number of Digits in "+number+" is "+length);
	}

}
