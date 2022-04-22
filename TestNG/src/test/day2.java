package test;

import org.testng.annotations.Test;

public class day2 {
	
	@Test
	public void hello(){
		
		System.out.println("Hello");
		
	}
	
	@Test(groups= {"Group 1"})
	public void ok(){
		
		System.out.println("OK");
		
	}
	
	@Test(dependsOnMethods= {"ok"})
	public void bye(){
		
		System.out.println("Bye");
		
	}
	
	@Test
	public void thanks(){
		
		System.out.println("Thanks");
		
	}
	
	@Test(enabled=false)
	public void no(){
		
		System.out.println("No");
		
	}
	
	@Test(timeOut=4000)
	public void timeout(){
		
		System.out.println("Timeout");
		
	}
	
	

}//class
