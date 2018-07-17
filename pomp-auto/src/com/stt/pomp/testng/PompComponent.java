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

import com.stt.pomp.util.Util;

public class PompComponent  extends PompTest{

	  private Logger log = Logger.getLogger(PompComponent.class);

	 

	@Test
	  public void testDemo1() throws Exception {
	    this.getDriver().get(this.getBaseUrl() + "/user/login.do");
	   log.info("testDemo1"+ "22");
	    
	  }

	  
	  @Test
	  public void testDemo3() throws Exception {
	    this.getDriver().get(this.getBaseUrl() + "/user/login.do");
	    
	  }
	  
	  
	  @Test
	  public void testDemo2() throws Exception {
	    this.getDriver().get(this.getBaseUrl() + "/user/login.do");
	    assertEquals(this.getDriver().getTitle(), "中国移动集团门户网站运营管理平台");
	    
	  }
	  
	  @Test
	  public void testCreateNewComponent() throws Exception {
	    this.getDriver().get(this.getBaseUrl() + "/user/login.do");
	    assertEquals(this.getDriver().getTitle(), "中国移动集团门户网站运营管理平台");
	    
	  }
	  
	  @Test
	  public void testDeleteComponent() throws Exception {
	    this.getDriver().get(this.getBaseUrl() + "/user/login.do");
	    assertEquals(this.getDriver().getTitle(), "中国移动集团门户网站运营管理平台");
	    
	  }
	  
	  @Test
	  public void testQueryComponent() throws Exception {
	    this.getDriver().get(this.getBaseUrl() + "/user/login.do");
	    assertEquals(this.getDriver().getTitle(), "中国移动集团门户网站运营管理平台");
	    
	  }
	  

}
