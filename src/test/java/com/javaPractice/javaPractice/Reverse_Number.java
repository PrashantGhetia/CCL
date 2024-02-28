package com.javaPractice.javaPractice;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Reverse_Number {
	Scanner sc = new Scanner(System.in);
	int number = sc.nextInt();
	int reverse = 0;
	int temp = number;
	String numberToStringWithSign = String.valueOf(number);
	String numberToStringWithoutSign = String.valueOf(number).replaceAll("-", "");
	
	
	@Test(priority = 1 , description = "Approach-1: Reverse Number Using Algorithm")
	public void reverse_Number_Using_Algorithm() {
		while(temp != 0) {
			int lastDigit = temp % 10;
			reverse = reverse * 10 + lastDigit;
			temp = temp / 10;
		}
		System.out.println("Approach-1: Reverse Number Using Algorithm");
		System.out.println(reverse);
	}
	
	@Test(priority = 2 ,description = "Approach-2: Using String Buffer Class")
	public void reverse_Number_Using_String_Buffer_Class() {
		StringBuffer sbuf = new StringBuffer();
		if(number>0) {
			System.out.println("Approach-2: Using String Buffer Class");
			System.out.println(sbuf.append(numberToStringWithSign).reverse());
		}
		if(number<0) {
			System.out.println("Approach-2: Using String Buffer Class");
			System.out.println("-"+sbuf.append(numberToStringWithoutSign).reverse());
		}
	}
	
	@Test(priority = 3 ,description = "Approach-3: Using String Builder Class")
	public void reverse_Number_Using_String_Builder_Class() {
		StringBuilder sbui = new StringBuilder();
		if(number>0) {
			System.out.println("Approach-3: Using String Builder Class");
			System.out.println(sbui.append(numberToStringWithSign).reverse());
		}
		if(number<0) {
			System.out.println("Approach-3: Using String Builder Class");
			System.out.println("-"+sbui.append(numberToStringWithoutSign).reverse());
		}
	}
	
	@Test(priority = 4 ,description = "Approach-4: Using Arrays")
	public void reverse_Number_Using_Arrays() {
		if(number>0) {
			char [] digits = String.valueOf(numberToStringWithSign).toCharArray();
			for(int i = 0 ; i < digits.length / 2 ; i++) {
				char temp = digits [i];
				digits [i] = digits [digits.length - i - 1];
				digits [digits.length - i - 1] = temp;
			}
			System.out.println("Approach-4: Using Arrays");
			System.out.println(Integer.parseInt(String.valueOf(digits)));
		}
		if(number<0) {
			char [] digits = String.valueOf(numberToStringWithoutSign).toCharArray();
			for(int i = 0 ; i < digits.length / 2 ; i++) {
				char temp = digits [i];
				digits [i] = digits [digits.length - i - 1];
				digits [digits.length - i - 1] = temp;
			}
			System.out.println("Approach-4: Using Arrays");
			System.out.print("-");
			System.out.println(Integer.parseInt(String.valueOf(digits)));
			
		}
		
	}
	
	@Test(priority = 5, description = "Approach-5: Using +(Concatenation) Operator")
	public void reverse_Number_Using_Concatenation_Operator(){
		if(number>0) {
			System.out.println("Approach-5: Using +(Concatenation) Operator");
			for(int i = numberToStringWithSign.length() - 1 ; i >= 0 ; i--) {
				System.out.print(numberToStringWithSign.charAt(i));
			}
		}
		if(number<0) {
			System.out.println("Approach-5: Using +(Concatenation) Operator");
			System.out.print("-");
			for(int i = numberToStringWithoutSign.length() - 1 ; i >= 0 ; i--) {
				System.out.print(numberToStringWithoutSign.charAt(i));
			}
		}
		System.out.println();
	}
	
	public static int reverseNumber(int number, int reversedNumber) {
	    if (number == 0) {
	        return reversedNumber;
	    }
	    reversedNumber = reversedNumber * 10 + number % 10;
	    return reverseNumber(number / 10, reversedNumber);
	}
	
	@Test(priority = 6, description = "Approach-6: Using Recursion")
	public void reverse_Number_Using_Recursion() {
		int reversedNumber = reverseNumber(number, 0);
		System.out.println("Approach-6: Using Recursion");
		System.out.println(reversedNumber);
	}

}
