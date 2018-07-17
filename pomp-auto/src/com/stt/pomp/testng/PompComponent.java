package com.stt.pomp.testng;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
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
import org.openqa.selenium.support.ui.Select;
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
		  log.info("create new component start");
		  String componentTitle = buildComponentTile();
		  log.info("component title is : " + componentTitle);
		WebDriver driver = this.getDriver();
	    driver.get(this.getBaseUrl() + "/user/login.do");
	    driver.findElement(By.linkText("组件管理")).click();
	    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=1 | ]]
	    // 手动更改frame
	    driver.switchTo().frame("mainFrame");
	    //需要等到可以点击的时候才能click
	    new WebDriverWait(driver,15).until(ExpectedConditions.elementToBeClickable(By.id("btnAdd")));
	    
	    driver.findElement(By.id("btnAdd")).click();
	    
	    //手动加延时wait
	    new WebDriverWait(driver, 15).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"title\"]")));
	    new WebDriverWait(driver,15).until(ExpectedConditions.elementToBeClickable(By.id("title")));
	    // //*[@id="title"]
	    driver.findElement(By.id("title")).click();
	    driver.findElement(By.id("title")).clear();
	    driver.findElement(By.id("title")).sendKeys(componentTitle);
	    driver.findElement(By.xpath("//div[@id='_com']/form/div[2]/label/div/a/i")).click();
	    driver.findElement(By.name("attrName")).click();
	    driver.findElement(By.name("attrName")).clear();
	    driver.findElement(By.name("attrName")).sendKeys("a1");
	    driver.findElement(By.name("showName")).click();
	    driver.findElement(By.name("showName")).clear();
	    driver.findElement(By.name("showName")).sendKeys("a1");
	    driver.findElement(By.name("typeName")).click();
	    new Select(driver.findElement(By.name("typeName"))).selectByVisibleText("文本组件");
	    driver.findElement(By.xpath("//option[@value='TTextDef']")).click();
	    driver.findElement(By.id("btnSave_1")).click();
	    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
	    
	    try {
	        assertEquals(driver.findElement(By.xpath("//div[@id='content']/div/div/div/div/div[2]/form/div[2]/table/tbody/tr/td[2]")).getText(), componentTitle);
	      } catch (Error e) {
	        this.getVerificationErrors().append(e.toString());
	      }
	  }
	  
	  private String buildComponentTile() {
		  //component title : auto + date(12) + randnumber(3)
		  LocalDateTime now = LocalDateTime.now();
		  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("-yyyyMMdd-HHmmss-");
			String formatDate = now.format(formatter);
			Random r = new Random();
			r.nextInt(900);
			int randomIndex = r.nextInt(900)+100;
		String ret = "auto"+formatDate+randomIndex;
		return ret;
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
