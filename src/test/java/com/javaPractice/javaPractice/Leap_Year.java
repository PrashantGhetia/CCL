package com.javaPractice.javaPractice;
/**
 * Leap Year contains 366 days, which comes once every four years. Every leap year corresponds to these facts :
 * A century year is a year ending with 00. A century year is a leap year only if it is divisible by 400.
 * A leap year (except a century year) can be identified if it is exactly divisible by 4.
 * A century year should be divisible by 4 and 100 both.
 * A non-century year should be divisible only by 4.
 * @author Prashant
 *
 */

import java.time.Year;
import java.util.Scanner;

import org.testng.annotations.Test;

public class Leap_Year {
	Scanner sc = new Scanner(System.in);
	int year = sc.nextInt();
	
	@Test(priority = 1, description = "Leap Year Using Conditions")
	public void leap_Year_Using_Conditions() {
		// 1st condition check- It is century leap year
        // 2nd condition check- It is leap year and not
        // century year
		if((year%400==0)||(year%4==0&&year%100!=0)) {
			// Both conditions true- Print leap year
            System.out.println(year + " : Leap Year");
		}
		else {
			// Any condition fails- Print Non-leap year
            System.out.println(year + " : Non - Leap Year");
		}
		
	}
	
	@Test(priority = 2, description = "Leap Year Using In Built Method isLeap()")
	public void leap_Year_Using_In_Built_Method() {
		Year checkYear = Year.of(year);
		if(checkYear.isLeap()) {
			System.out.println(year + " : Leap Year");
		}
		else {
			System.out.println(year + " : Non - Leap Year");
		}
	}

}
