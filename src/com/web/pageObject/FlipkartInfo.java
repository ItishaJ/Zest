package com.web.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.web.automation.BasePage;

public class FlipkartInfo extends BasePage {

	@FindBy(css = "div[class='_1USjzt _3X9Hx3']")
	WebElement price;

	@FindBy(id = "price-info-icon")
	WebElement info;

	public double priceFlip;

	public FlipkartInfo(WebDriver driver) {
		// TODO Auto-generated constructor stub {
		super(driver);
	}

	public void price() throws InterruptedException {

		click(info);
		Thread.sleep(1000);
        priceFlip = Double.parseDouble(price.getText().substring(2).replaceAll(",", ""));

	}

}