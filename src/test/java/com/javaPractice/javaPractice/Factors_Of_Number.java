package com.javaPractice.javaPractice;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Factors_Of_Number {
	@Test
	public void factors_Of_Number() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Number");
		int number = sc.nextInt();
		int enteredNumber = number;
		
		System.out.print("Factors of "+enteredNumber+" are: ");
		
		//If Entered Number is Positive
		if(enteredNumber > 0) {
			for(int i = 1 ; i <= number ; i++) {
				if(number % i == 0) {
					System.out.print(i+ ", ");
				}
			}
		}
		
		/**
		 * The for loop is iterated until i <= number is false.
		 * In each iteration, whether number is exactly divisible by i is checked
		 * (condition for i to be the factor of number) and the value of i is incremented by 1.
		 */
		
		//If Entered Number is Negative
		if(enteredNumber < 0) {
			for(int i = number ; i <= Math.abs(number) ; i++) {
				if(i == 0) {
					continue;
				}
				else {
					if(number % i == 0) {
						System.out.print(i+ ", ");
					}
				}
			}
		}
		
		/**
		 * In the above example, we have computed all the factors of a negative number.
		 * Here, the for loop runs from Negative Number to Positive Number.
		 * And, when the value of i is 0, the iteration is skipped.
		 * Otherwise, there will be an exception.
		 */
		
		System.out.println();
		
	}

}
