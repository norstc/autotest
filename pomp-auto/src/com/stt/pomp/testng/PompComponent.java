package com.stt.pomp.testng;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PompComponent {
	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  private Logger log = Logger.getLogger(PompComponent.class);

	  @BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
		String logConf = "config/log4j.properties";
		PropertyConfigurator.configure(new File(logConf).getAbsolutePath());
	    driver = new FirefoxDriver();
	    
	    
	    baseUrl = "http://192.168.1.208/pomp";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	    //登陆
	    driver.get(baseUrl+"/user/login.do");
	    driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys("test_jt_1@sh.com");
	    driver.findElement(By.id("mobile")).clear();
	    driver.findElement(By.id("mobile")).sendKeys("13312345678");
	    // imageValidCode2
	    driver.findElement(By.id("imageValidCode2")).clear();
	    driver.findElement(By.id("imageValidCode2")).sendKeys("1234");
	    //ssoLogin
	    driver.findElement(By.id("ssoLogin")).click();
	   // Thread.sleep(10000);
	    //处理弹窗
	    checkAlert();
	   //Thread.sleep(10000);
	   //短信验证码 txtMobileSn
	   WebElement we = driver.findElement(By.id("txtMobileSn"));
	   we.sendKeys("1");
	   Thread.sleep(10000);
	   //we.sendKeys(Keys.ENTER);
	   log.info("click btnValid");
	   //btnVaild 这个找不到，待解决，先直接发一个enter过去, submit()函数没写。。。
	   //we = driver.findElement(By.id("btnValid")); //用id找不到，改用xpath可以点到了
	   we = driver.findElement(By.xpath("//*[@id=\"btnVaild\"]"));
	   we.click();
	   
	   log.info("处理弹窗");
	   //工单历史这个不是alert
	   //checkAlert();
	   //Thread.sleep(10000);
	  }
	 
	  private void checkAlert() {
		try {
			WebDriverWait wait = new WebDriverWait(driver,2);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	  public void testDemo1() throws Exception {
	    driver.get(baseUrl + "/user/login.do");
	   log.info("testDemo1"+ "22");
	    
	  }

	  
	  @Test
	  public void testDemo3() throws Exception {
	    driver.get(baseUrl + "/user/login.do");
	    
	  }
	  
	  
	  @Test
	  public void testDemo2() throws Exception {
	    driver.get(baseUrl + "/user/login.do");
	    assertEquals(driver.getTitle(), "中国移动集团门户网站运营管理平台");
	    
	  }
	  
	  @Test
	  public void testCreateNewComponent() throws Exception {
	    driver.get(baseUrl + "/user/login.do");
	    assertEquals(driver.getTitle(), "中国移动集团门户网站运营管理平台");
	    
	  }
	  
	  @Test
	  public void testDeleteComponent() throws Exception {
	    driver.get(baseUrl + "/user/login.do");
	    assertEquals(driver.getTitle(), "中国移动集团门户网站运营管理平台");
	    
	  }
	  
	  @Test
	  public void testQueryComponent() throws Exception {
	    driver.get(baseUrl + "/user/login.do");
	    assertEquals(driver.getTitle(), "中国移动集团门户网站运营管理平台");
	    
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
