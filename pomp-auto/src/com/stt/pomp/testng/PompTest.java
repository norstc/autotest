package com.stt.pomp.testng;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.stt.pomp.util.Util;

/**
 * the base class for POMP function test
 * 
 * @author zhangjh
 *
 */
public class PompTest {
	private WebDriver driver;

	private String baseUrl;
	private String userName;
	private String mobile;
	private String validCode;

	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private Logger log = Logger.getLogger(PompTest.class);

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		String logConf = "config/log4j.properties";
		PropertyConfigurator.configure(new File(logConf).getAbsolutePath());
		driver = new FirefoxDriver();

		baseUrl = Util.getUtil().getBaseUrl();
		userName = Util.getUtil().getUserName();
		mobile = Util.getUtil().getMobile();
		validCode = Util.getUtil().getValidCode();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// 登陆
		driver.get(baseUrl + "/user/login.do");
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("mobile")).clear();
		driver.findElement(By.id("mobile")).sendKeys(mobile);
		// imageValidCode2
		driver.findElement(By.id("imageValidCode2")).clear();
		driver.findElement(By.id("imageValidCode2")).sendKeys(validCode);
		// ssoLogin
		driver.findElement(By.id("ssoLogin")).click();
		// Thread.sleep(10000);
		// 处理弹窗
		checkAlert();
		// Thread.sleep(3000);
		// 短信验证码 txtMobileSn

		WebElement we = driver.findElement(By.id("txtMobileSn"));
		we.sendKeys("1");
		//Thread.sleep(10000); 傻方法，不确定是不是元素为加载完的情况下可以下用来尝试下，如果是加载时间的问题，就改为手动加延时的方式处理
		// we.sendKeys(Keys.ENTER);
		log.info("click btnValid");
		// btnVaild 这个找不到，待解决，先直接发一个enter过去, submit()函数没写。。。
		// we = driver.findElement(By.id("btnValid")); //用id找不到，改用xpath可以点到了
		
		//手动加延时wait
	    new WebDriverWait(driver, 15).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"btnVaild\"]")));
	    new WebDriverWait(driver,15).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"btnVaild\"]")));
		we = driver.findElement(By.xpath("//*[@id=\"btnVaild\"]"));
		we.click();

		log.info("处理弹窗");
		// 工单历史这个不是alert
		// checkAlert();
		// Thread.sleep(10000);
	}

	private void checkAlert() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 2);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getValidCode() {
		return validCode;
	}

	public void setValidCode(String validCode) {
		this.validCode = validCode;
	}

	public boolean isAcceptNextAlert() {
		return acceptNextAlert;
	}

	public void setAcceptNextAlert(boolean acceptNextAlert) {
		this.acceptNextAlert = acceptNextAlert;
	}

	public StringBuffer getVerificationErrors() {
		return verificationErrors;
	}

	public void setVerificationErrors(StringBuffer verificationErrors) {
		this.verificationErrors = verificationErrors;
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}
}
