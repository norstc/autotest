package com.stt.pomp.testng;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PompComponent {
	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://192.168.1.208/pomp";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	 
	  @Test
	  public void testDemo1() throws Exception {
	    driver.get(baseUrl + "/user/login.do");
	   
	    assertEquals(driver.findElement(By.cssSelector("label.col-xs-3.control-label")).getText(), "");
	  }

	  
	  @Test
	  public void testDemo3() throws Exception {
	    driver.get(baseUrl + "/user/login.do");
	    WebElement we = driver.findElement(By.xpath("/html/body/div[2]/div/form/div[2]/div[1]/label"));
	    String a = we.getText();
	    String e = "用户名";
	    assertEquals(a, e);
	  }
	  
	  
	  @Test
	  public void testDemo2() throws Exception {
	    driver.get(baseUrl + "/user/login.do");
	    assertEquals(driver.getTitle(), "管理员登录");
	    
	  }
	  
	  @AfterClass(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }
}
