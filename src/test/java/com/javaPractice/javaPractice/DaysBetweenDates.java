package com.javaPractice.javaPractice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import org.testng.annotations.Test;

public class DaysBetweenDates {
	@Test
	public void test1() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First Date");
		String firstInput = sc.nextLine();
		//2024-03-01 20:14:29
		System.out.println("Enter Second Date");
		String secondInput = sc.nextLine();
		//2024-03-31 20:14:29
        final LocalDate firstDate = LocalDate.parse(firstInput, formatter);
        final LocalDate secondDate = LocalDate.parse(secondInput, formatter);
        final long days = ChronoUnit.DAYS.between(firstDate, secondDate);
        System.out.println("Days between: " + days);
	}

}
