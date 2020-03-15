package com.web.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.web.pageObject.*;
import com.web.Util.*;
import com.web.automation.BasePage;

public class compareTest extends BasePage {
	AmazonHome homeA;
	AmazonInfo Ainfo;
	FlipkartHome homeF;
	FlipkartInfo Finfo;
	
	@BeforeClass(alwaysRun = true)

	public void setUp() throws Exception {
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers//chromedriver");	
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		homeA = new AmazonHome(driver);
		homeF = new FlipkartHome(driver);
		Ainfo = new AmazonInfo(driver);
		Finfo = new FlipkartInfo(driver);
	}

	@Test(priority = 1)
	public void search() throws InterruptedException {
		homeA.search();
		homeA.clickmobile();
		getWindowHandle();
		Ainfo.price();
	}
	@Test(priority=2)
	public void search2() throws InterruptedException {
		homeF.search();
		homeF.clickmobile();
		getWindowHandle();
		Finfo.price();
	}
	@Test(priority=3,dependsOnMethods = {"search2","search"})
	public void compare() {
		compare(Ainfo.priceAmazon,Finfo.priceFlip);
	}
	@AfterClass(alwaysRun = true)
	public void close() throws Exception {
		driver.quit();
	}
}
