package practice;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Reverse_Number {
	Scanner sc = new Scanner(System.in);
	int number = sc.nextInt();
	int enteredNumber = number;
	int reversedNumber = 0;
	String numberToStringWithSign = String.valueOf(number);
	String numberToStringWithoutSign = String.valueOf(number).replace("-", "");

	@Test
	public void test_1() {
		while(enteredNumber!=0) {
			int lastDigit = enteredNumber%10;
			reversedNumber=reversedNumber*10+lastDigit;
			enteredNumber/=10;
		}
		System.out.println(reversedNumber);
	}
	
	@Test
	public void test_2() {
		StringBuffer sbuf = new StringBuffer();
		if(number>0) {
			System.out.println(sbuf.append(numberToStringWithSign).reverse());
		}
		if(number<0) {
			System.out.println("-"+sbuf.append(numberToStringWithoutSign).reverse());
		}
	}
	
	@Test
	public void test_3() {
		StringBuilder sbui = new StringBuilder();
		if(number>0) {
			System.out.println(sbui.append(numberToStringWithSign).reverse());
		}
		if(number<0) {
			System.out.println("-"+sbui.append(numberToStringWithoutSign).reverse());
		}
	}
	
	@Test
	public void test_4() {
		if(number>0) {
			char [] digits = numberToStringWithSign.toCharArray();
			for(int i=0;i<=digits.length/2;i++) {
				char temp = digits[i];
				digits [i] = digits[digits.length-i-1];
				digits[digits.length-i-1] = temp;
			}
			System.out.print(Integer.parseInt(String.valueOf(digits)));
		}
		if(number<0) {
			char [] digits = numberToStringWithoutSign.toCharArray();
			for(int i=0;i<=digits.length/2;i++) {
				char temp = digits [i];
				digits [i] = digits [digits.length-i-1];
				digits [digits.length-i-1] = temp;
			}
			System.out.print("-"+Integer.parseInt(String.valueOf(digits)));
		}
		System.out.println();
	}
	
	@Test
	public void test_5() {
		if(number>0) {
			for(int i=numberToStringWithSign.length()-1;i>=0;i--) {
				System.out.print(numberToStringWithSign.charAt(i));
			}
		}
		if(number<0) {
			System.out.print("-");
			for(int i=numberToStringWithoutSign.length()-1;i>=0;i--) {
				System.out.print(numberToStringWithoutSign.charAt(i));
			}
		}
		System.out.println();
	}
	
	
}
