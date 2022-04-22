package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GlobalValueDrive {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("/Users/yanjun/eclipse-workspace/TestNG/src/test/data.properties");
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		
		String urlName = prop.getProperty("url");
		System.out.println(urlName);
		
		prop.setProperty("browser", "firefox");
		System.out.println(browserName);
		FileOutputStream fos = new FileOutputStream("/Users/yanjun/eclipse-workspace/TestNG/src/test/data.properties");
		prop.store(fos, null);
		

	}//main

}//class
