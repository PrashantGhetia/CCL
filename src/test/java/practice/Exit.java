package practice;

import org.testng.annotations.Test;

public class Exit {
	@Test
	public void test() {
		try {
			int i=1;
			int j=0;
			int k;
			System.out.println("Before Exit");
			System.exit(2);
			
			k=i/j;
			
			System.out.println("Try Block");
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Catch Block");
		}
		finally {
			System.out.println("Finally Block");
		}
		System.out.println("The End");
		
	}

}
