package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class day1 {

	@Test(groups= {"Group 1"})
	public void webLogin(){
		
		System.out.println("weblogin");
		
	}
	
	@Test(groups= {"Group 2"})
	public void mobileLogin(){
		
		System.out.println("mobilelogin");
		
	}
	
	@Test(groups= {"Group 3"})
	public void apiLogin(){
		
		System.out.println("apilogin");
		
	}
	
	@BeforeMethod
	public void prestep() {
		
		System.out.println("I run before every method in the class");
		
	}
	
	@AfterMethod
	public void poststep() {
		
		System.out.println("I run after every method in the class");
		
	}
	
	@BeforeClass
	public void preparation() {
		
		System.out.println("I run before all methods executed in the class");
		
	}
	
	@AfterClass
	public void posttest() {
		
		System.out.println("I run after all methods executed in the class");
		
	}
	
	
	@BeforeTest
	public void prerequiste() {
		
		System.out.println("I run before all test cases in the Test / Folder / Module");
		
	}
	
	@AfterTest
	public void cleanUp() {
		
		System.out.println("I run after all test cases in the Test / Folder / Module");
		
	}
	
	@BeforeSuite
	public void firstRun() {
		
		System.out.println("I run before all test cases in the Test Suite");
		
	}
	
	@AfterSuite
	public void lastRun() {
		
		System.out.println("I run after all test cases in the Test Suite");
		
	}
	
}//class
