package practice;

import java.io.IOException;

public class Propagation {
	public static void main(String[] args) {
		try {
			m1();
		} catch (Exception e) {
			System.out.println("Exceptiion Handled in Main Method");
			e.printStackTrace();
			//System.out.println(e.toString());
			//System.out.println(e.getMessage());
		}
	}
	public static void m1() throws IOException {
//		try {
			m2();
//		}
//		 catch (Exception e) {
//			System.out.println("Exception Handled in Caller Method");
//		}
	}
	public static void m2() throws IOException {
		//System.out.println(10/0);
		//throw new ArithmeticException();
		throw new IOException();
	}

}
