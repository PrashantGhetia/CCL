package practice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddDaysToCurrentDAte {
	public static void main(String[] args) {
		DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
		Date date = new Date();
		//Feb 8, 2024
		System.out.println("Today's Date: "+dateFormat.format(date));
		System.out.println("Add 3 Days to Current Date: "+addSubstractDate(14));
		System.out.println("Substract 3 Days from Current Date: "+addSubstractDate(-14));
	}

	public static String addSubstractDate(int n) {
		DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, n);
		String result = dateFormat.format(cal.getTime());
		return result;
	}
}
