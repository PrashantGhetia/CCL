package practice;

import java.sql.Date;
import java.util.Scanner;

import org.testng.annotations.Test;

import com.google.common.base.Splitter;

public class Sample {
	@Test
	public void test() {
		Scanner sc = new Scanner(System.in);
		String string = sc.nextLine();
		String [] array = string.split("[|]");
		for(String a:array) {
			System.out.println(a);
		}
		Iterable<String> results = Splitter.on("|").split(string);
		for (String string2 : results) {
			System.out.println(string2);
		}
	}

}
