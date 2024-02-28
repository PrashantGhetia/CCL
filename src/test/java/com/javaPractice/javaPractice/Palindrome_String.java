package com.javaPractice.javaPractice;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Palindrome_String {  //madam--> Reversed String--> madam --> Palindrome String
	@Test
	public void palindrome_String() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String");
		String string = sc.nextLine();
		String enteredString = string;
		String reversedString = "";
		for(int i = string.length()-1 ; i >= 0 ; i--) {
			reversedString = reversedString + string.charAt(i);
		}
		System.out.println("Entered String : "+enteredString);
		System.out.println("Reversed String : "+reversedString);
		if(enteredString.equals(reversedString)) {
			System.out.println(enteredString + " is Palindrome String");
		}
		else {
			System.out.println(enteredString + " is Not Palindrome String");
		}
	}

}
