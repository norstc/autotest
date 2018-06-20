package com.stt.pomp.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.log4testng.Logger;



public class Util {
	private String baseUrl;
	private String userName;
	private String mobile;
	private String validCode;
	
	private static Util util = null;
	private Logger log = Logger.getLogger(Util.class);
	private Util() {
		String filepath = "config/testenv.properties";
		Properties p = new Properties();
		try
		{
			InputStream inp = new FileInputStream(filepath);
			p.load(inp);
			inp.close();
		}
		catch (FileNotFoundException fe)
		{
			log.error("File Not Found");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		baseUrl = p.getProperty("baseUrl");
		userName = p.getProperty("userName", "test_jt_2@sh.com");
		mobile=p.getProperty("mobile");
		validCode=p.getProperty("validCode");
		
	};
	
	public static Util getUtil() {
		if (util == null) {
			return new Util();
		}else {
			return util;
		}
		
	}
	
	public String getBaseUrl() {
		 
		return baseUrl;
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
	
}
