package com.qstore.utility;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qstore.base.Base;

public class ExtentManager {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;	//add test cases to report
	public static ExtentTest test;
	
	
	
	public static void setExtent() {
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"ArtemReporting_"+Base.getCurrTime()+".html");
		
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");	
//		htmlReporter.config().setDocumentTitle("Automation Test Report");
//		htmlReporter.config().setReportName("Qstore Test Automation Report");
////		htmlReporter.config().setTheme(Theme.STANDARD);
//		htmlReporter.config().setTheme(Theme.DARK);
		
		extent= new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("HostName", "MyHost");
		extent.setSystemInfo("ProjectName", "qStore");
		extent.setSystemInfo("Tester", "Artem");
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Browser", "Chrome");
	}
	
	
	public static void endReport() {
		extent.flush();
	}
}
