package com.javaPractice.javaPractice;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Palindrome_Number {
	@Test
	public void palindrome_Number() { ////Number-->121--> Reversed Number-->121 -->Palindrome Number
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Number");
		int number = sc.nextInt();
		int enteredNumber = number;
		int reversedNumber = 0;
		while(number != 0) {
			int lastDigit = number % 10;
			reversedNumber = reversedNumber * 10 + lastDigit;
			number = number / 10;
		}
		System.out.println("Entered Number: "+enteredNumber);
		System.out.println("Reversed Number: "+reversedNumber);
		if(enteredNumber == reversedNumber) {
			System.out.println(enteredNumber + " is Palindrome Number");
		}
		else {
			System.out.println(enteredNumber + " is Not Palindrome Number");
		}
	}

}
