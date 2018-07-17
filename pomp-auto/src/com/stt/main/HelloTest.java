package com.stt.main;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.TestNG;

public class HelloTest {
	public  static void main(String[] args) {
		TestNG testng = new TestNG();
		List<String> suitefiles = new ArrayList<String>();
		suitefiles.add("./config/testsuiteuser.xml");
		suitefiles.add("./config/testsuitecomponent.xml");
		testng.setTestSuites(suitefiles);
	
		testng.run();

	}
}
