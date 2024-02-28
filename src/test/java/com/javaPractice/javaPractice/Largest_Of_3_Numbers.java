package com.javaPractice.javaPractice;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Largest_Of_3_Numbers {
	Scanner sc = new Scanner(System.in);
	int a = sc.nextInt();
	int b = sc.nextInt();
	int c = sc.nextInt();

	@Test(priority = 1, description = "Approach-1: Using if-else..if Condition")
	public void largest_Of_3_Numbers_Using_If_Else_Condition() {
		if (a >= b && a >= c) {
			System.out.println("Largest: " + a);
		} else if (b >= a && b >= c) {
			System.out.println("Largest: " + b);
		} else {
			System.out.println("Largest: " + c);
		}
	}

	@Test(priority = 2, description = "Approach-2: Using Ternary Operator")
	public void largest_Of_3_Numbers_Using_Ternary_Operator() {
		// variable_name = (expression) ? value if true:value if false
		int temp = a > b ? a : b;
		int largest = c > temp ? c : temp;
		System.out.println("Largest: " + largest);
	}

	@Test(priority = 3, description = "Approach-3: Using Nested If Condition")
	public void largest_Of_3_Numbers_Using_Nested_If_Condition() {
		if(a >= b) {
			if(a >= c) {
				System.out.println("Largest: "+a);
			}
			else {
				System.out.println("Largest: "+c);
			}
		}
		else {
			if(b >= c) {
				System.out.println("Largest: "+b);
			}
			else {
				System.out.println("Largest: "+c);
			}
		}
	}

}
