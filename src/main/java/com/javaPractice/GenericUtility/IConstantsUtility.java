package com.javaPractice.GenericUtility;

/**
 * This Interface consists of all the required constants
 * Why interface variables are by default public static and final?
 * Interface variables are static because java interfaces cannot be instantiated on their own.
 * The value of the variable must be assigned in a static context in which no instance exists.
 * The final modifier ensures the value assigned to the interface variable is a 
 * true constant that cannot be re-assigned.
 * In other words, interfaces can declare only constants, not instance variables.
 * @author Prashant
 *
 */
public interface IConstantsUtility {
	
	//If you are using Forward Slashes (/) then you have to use it once like /
		//If you are using Backward Slashes (\) then you have to use it twice like \\
		
		String PropertyFilePath=".\\src\\test\\resources\\commonData.properties";
		String ExcelFilePath=".\\src\\test\\resources\\testData.xlsx";
		String ScreenshotsPath="./Screenshots/";
		String ReportsPath="./Reports/";
		String DatabaseURL="jdbc:mysql://localhost:3306/sonoo";
		String DatabaseUsername="root";
		String DatabasePassword="root";

}
