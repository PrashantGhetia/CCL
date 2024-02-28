package com.javaPractice.javaPractice;

import java.util.Locale;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakeData {
	@Test
	public void test() {
		Faker fakeData = new Faker(new Locale("en-IND"));
		System.out.println(fakeData.name().firstName());
		System.out.println(fakeData.name().lastName());
		System.out.println(fakeData.name().fullName());
		System.out.println(fakeData.address().city());
		System.out.println(fakeData.address().city());
		System.out.println(fakeData.address().city());
		System.out.println(fakeData.address().fullAddress());
	}

}
