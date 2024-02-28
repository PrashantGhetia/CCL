package com.javaPractice.javaPractice;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Interest {
	@Test
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Initial Invested Amount");
		double initialInvestedAmount = sc.nextDouble();
		double investedAmount = initialInvestedAmount;
		System.out.println("Enter Number of Days");
		int numberOfDays = sc.nextInt();
		System.out.println("Enter Interest Rate Per Day");
		double interestRatePerDay = sc.nextDouble();

		for (int i = 1; i <= numberOfDays; i++) {
			System.out.print("Day: " + i + " ==> ");
			Double interestEarnedPerDay = investedAmount * interestRatePerDay / 100;
			//interestEarnedPerDay = Double.parseDouble(new DecimalFormat("####.####").format(interestEarnedPerDay));
			double interestEarnedPerDay1 = (int)(Math.round(interestEarnedPerDay * 100))/100.0;
			//System.out.println("Interest: " + interestEarnedPerDay);
			System.out.println("Interest: " + interestEarnedPerDay1);
			investedAmount = investedAmount + interestEarnedPerDay;
			//investedAmount = Double.parseDouble(new DecimalFormat("####.####").format(investedAmount));
			double investedAmount1 = (int)(Math.round(investedAmount * 100))/100.0;
			//System.out.println("       Total Amount: " + investedAmount);
			System.out.println("       Total Amount: " + investedAmount1);
			System.out.println();

		}

	}

}
