package com.web.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.web.automation.BasePage;
import com.web.Util.Constant;

public class AmazonHome extends BasePage {

	@FindBy(id = "twotabsearchtextbox")
	WebElement search;

	@FindBy(xpath = "//*[@id=\"nav-search\"]/form/div[2]/div/input")
	WebElement button;

	@FindBy(partialLinkText = "Apple iPhone XR")
	WebElement mobile;

	public AmazonHome(WebDriver driver) {
		// TODO Auto-generated constructor stub {
		super(driver);
	}

	public void search() throws InterruptedException {

		OpenUrl(Constant.URLamazon);
		explicitWaitTillElementIsEnabled(search, 50);
		type(search, "iPhone XR (64GB) - Yellow");
		click(button);
	}

	public void clickmobile() {
		click(mobile);
	}
}