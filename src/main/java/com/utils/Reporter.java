package com.utils;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import cucumber.api.testng.AbstractTestNGCucumberTests;

public abstract class Reporter extends AbstractTestNGCucumberTests{
	
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test, node;
	
	public String testcaseName, testcaseDec, author, category;
	public String excelFileName;
	public String sheetName;
	
	@BeforeSuite
	public void startReport() {
		//new ExtentHtmlReporter(new File("./reports/result.html"));
		File file = new File("./reports/result.html");
		if(file.exists()) {
			file.delete();
		}
		reporter = new ExtentHtmlReporter(new File("./reports/result.html"));
		reporter.setAppendExisting(true); 
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	
    @BeforeClass
	public void report() throws IOException {
		test = extent.createTest(testcaseName);
		test.assignAuthor(author);
		test.assignCategory(category);  
	}
    
    public abstract long takeSnap();
    public void reportStep(String dec, String status,boolean bSnap ) {
    	MediaEntityModelProvider img = null;
		if(bSnap && !status.equalsIgnoreCase("INFO")){

			long snapNumber = 100000L;
			snapNumber = takeSnap();
			try {
				img = MediaEntityBuilder.createScreenCaptureFromPath
						("./../reports/images/"+snapNumber+".jpg").build();
			} catch (IOException e) {
				
			}
		}
    	if(status.equalsIgnoreCase("pass")) {
    		node.pass(dec, img);
    	} else if(status.equalsIgnoreCase("fail")) {
    		node.fail(dec, img); 
    	}
    }
    
    public void reportStep(String desc, String status) {
		reportStep(desc, status, true);
	}

    
    @AfterSuite
    public void stopReport() {
    	extent.flush();
    }
}
