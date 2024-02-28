package com.javaPractice.javaPractice;
import java.util.Arrays;
import java.util.Scanner;

import org.testng.annotations.Test;
/**
 * In a linear search, each element in the list is searched one after the other in a sequential manner
 * until it is found in the list.
 * Linear Search is a very simple search algorithm.
 * Here a sequential search is made over all items one by one.
 * Every item is checked and if a match is found then that particular item is returned,
 * otherwise the search continues till the end of the data collection.
 * @author Prashant
 *
 */
public class Linear_Search_In_Arrays {
	@Test
	public void linear_Search_In_Array() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements you want to store in the Array");
		int number = sc.nextInt();
		System.out.println("Enter the elements in the Array");
		String array[] = new String[number];
		for(int i = 0 ; i<number ; i++) {
			array[i]=sc.next();
		}
		System.out.println("Array: "+Arrays.toString(array));
		System.out.println("Enter the element you want to search");
		String search = sc.next();
		boolean flag = false;
		for(int i = 0 ; i < number ; i++) {
			if(search.equals(array[i])) {
				System.out.println("Searched element is found at "+i+" index position");
				
				flag = true;
			}
		}
		if(flag==false)
			System.out.println("Searched element is not present in List");
	}

}
