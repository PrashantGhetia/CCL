package practice;

import java.util.Scanner;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Interview {
	@Test
	public void test() {
		/*
		 * You are given an array of numbers e.g. int[] numbers = {4, 1, 6, 2, 3, 2, 7, 8, 1, 1}. Get all unique numbers from the given array
		 */
		
		int [] numbers = {4, 1, 6, 2, 3, 2, 7, 8, 1, 1};
		
		for(int i=0; i<numbers.length;i++) {
			boolean flag = true;
			for(int j =i+1; j<numbers.length-j;j++) {
				
				if(numbers[i]==numbers[j]) {
					break;
				}
//				if(numbers[i]!=numbers[j]) {
//					flag = true;
//					
//				}
				
				
			}
			if(flag==true) {
				System.out.println(numbers[i]);
			}
			
			
		}
	
	}
	

}
