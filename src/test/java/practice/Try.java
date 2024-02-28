package practice;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Try {
	@Test
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Integer");
		int a = sc.nextInt();
		System.out.println(a);
		sc.nextLine();
		System.out.println("Enter Float");
		float b = sc.nextFloat();
		System.out.println(b);
		sc.nextLine();
		System.out.println("Enter Long");
		long c = sc.nextLong();
		System.out.println(c);
		sc.nextLine();
		System.out.println("Enter Double");
		double d = sc.nextDouble();
		System.out.println(d);
		sc.nextLine();
		System.out.println("Enter String");
		String e = sc.nextLine();
		System.out.println(e);
	}

}
