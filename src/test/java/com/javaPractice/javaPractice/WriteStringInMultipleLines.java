package com.javaPractice.javaPractice;

import java.util.Scanner;

import org.apache.poi.util.SystemOutLogger;
import org.testng.annotations.Test;

public class WriteStringInMultipleLines {
	@Test
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Stringg with White Spaces");
		String string = sc.nextLine();
		
		String[] words=string.split("\\s");//splits the string based on whitespace  
		//using java foreach loop to print elements of string array  
//		for(String w:words){  
//		System.out.println(w);  
//		}  
		String converted = "";
		
		for(int i=0; i<=words.length-1;i++) {
			converted = converted + words[i] + "\n";
		}
		System.out.println(converted);
		
		
	}

}
