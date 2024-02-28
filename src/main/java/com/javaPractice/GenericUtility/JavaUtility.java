package com.javaPractice.GenericUtility;

import java.util.Date;
import java.util.Random;

/**
 * This class contains java specific generic methods
 * @author Prashant
 *
 */
public class JavaUtility {
	/**
	 * This method will generate a random number for every execution
	 * @return
	 */
	public int getRandomNumber() {
		Random r = new Random();  //Imported from java.util package
		int randomNumber = r.nextInt(1000);
		return randomNumber;
	}
	/**
	 * This method will provide System date
	 * @return
	 */
	public String getSystemDate() {
		Date d = new Date();  //Imported from java.util package
		String date = d.toString();
		return date;
	}
	/**
	 * This method will provide System date in specific format
	 * @return
	 */
	public String getSystemDateInFormat() {      // Sun    Mar    19   00:13:12  IST  2023  (System Date Format)
		Date d = new Date();                     //  0      1      2      3       4     5   (Index)
		String[] dArr = d.toString().split(" "); //(Day) (Month) (Date) (Time)   ()  (Year) (Attributes)
		String date = dArr[2];
		String month = dArr[1];
		String year = dArr[5];
		String time = dArr[3].replaceAll(":", "-");
		String currentDateAndTIme = date+" "+month+" "+year+" "+time;
		return currentDateAndTIme;	
	}

}
