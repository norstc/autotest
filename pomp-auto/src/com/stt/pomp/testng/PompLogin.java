package com.stt.pomp.testng;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import static org.testng.Assert.*;

public class PompLogin extends PompTest{
	private Logger log = Logger.getLogger(PompLogin.class);
	
	 
	  @Test
	  public void testUserName() throws Exception {
	    this.getDriver().get(this.getBaseUrl() + "/user/login.do");
	   //test_jt_2
	    ////*[@id="realname"]
	    
	    assertEquals(this.getDriver().findElement(By.xpath("//*[@id=\"realname\"]")).getText(),"test_jt_2");
	  }

	  
	  @Test
	  public void testAppName() throws Exception {
	    this.getDriver().get(this.getBaseUrl() + "/user/login.do");
	    // /html/body/div[1]/a/span[2]
	    WebElement we = this.getDriver().findElement(By.xpath("/html/body/div[1]/a/span[2]"));
	    String a = we.getText();
	    String e = "统一门户两级运营内容管理平台";
	    assertEquals(a, e);
	  }
	  
	  
	  @Test
	  public void testHtmlTitle() throws Exception {
	    this.getDriver().get(this.getBaseUrl() + "/user/login.do");
	    assertEquals(this.getDriver().getTitle(), "中国移动集团门户网站运营管理平台");
	    
	  }
	  
	  
}
