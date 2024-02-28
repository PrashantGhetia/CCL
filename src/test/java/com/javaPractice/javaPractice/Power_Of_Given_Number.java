package com.javaPractice.javaPractice;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Power_Of_Given_Number {
	Scanner sc = new Scanner(System.in);
	int baseNumber = sc.nextInt();
	int exponentNumber = sc.nextInt();

	@Test(priority = 1, description = "Power of a given Number Using For Loop", enabled = true)
	public void power_Of_Given_Number_Using_For_Loop() {
		int base = baseNumber;
		int exponent = exponentNumber;
		int result = 1;
		for (int i = 0; i < exponent; i++) {
			result *= base;
		}
		System.out.println(baseNumber + " raised to the power of " + exponentNumber + " is " + result);
	}

	@Test(priority = 2, description = "Power of a given Number Using While Loop", enabled = true)
	public void power_Of_Given_Number_Using_While_Loop() {
		int base = baseNumber;
		int exponent = exponentNumber;
		int result = 1;
		while (exponent > 0) {
			result *= base;
			exponent--;
		}
		System.out.println(baseNumber + " raised to the power of " + exponentNumber + " is " + result);
	}

	public static int power(int base, int exponent) {
		if (exponent == 0) {
			return 1;
		} else {
			return base * power(base, exponent - 1);
		}
	}

	@Test(priority = 3, description = "Power of a given Number Using Recursion", enabled = true)
	public void power_Of_Given_Number_Using_Recursion() {
		int base = baseNumber;
		int exponent = exponentNumber;
		int result = power(base, exponent);
		System.out.println(baseNumber + " raised to the power of " + exponentNumber + " is " + result);
	}
	
	@Test(priority = 4, description = "Power of a given Number Using Math.pow() Method", enabled = true)
	public void power_Of_Given_Number_Using_MathPow_Method() {
		int base = baseNumber;
		int exponent = exponentNumber;
		double _base = Double.valueOf(base);
		double _exponent = Double.valueOf(exponent);
		double result = Math.pow(_base, _exponent);
		System.out.println(_base + " raised to the power of " + _exponent +" is "+result);
	}
}