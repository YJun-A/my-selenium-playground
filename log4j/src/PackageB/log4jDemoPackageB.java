package PackageB;

import org.apache.logging.log4j.*;

public class log4jDemoPackageB {
	
	private static Logger log = LogManager.getLogger(log4jDemoPackageB.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//Default configuration will only log errors to console
		//All the following logs will be logged in console after setting up XML file for log4j and change Root level = trace in the XML file
		log.debug("I am debugging");
		log.error("Error has occurred");
		log.info("I am giving info");
		log.fatal("I am fatal message");

	}//main

}//class
