package main.java.com.Zest.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import main.java.com.Zest.project.base.BasePage;

public class AmazonInfo extends BasePage {

	@FindBy(xpath = "//*[@id=\"priceblock_ourprice\"]")
	WebElement price;
	public double priceAmazon;

	public AmazonInfo(WebDriver driver) {
		// TODO Auto-generated constructor stub {
		super(driver);
	}

	public void price() throws InterruptedException {

		explicitWaitTillElementIsEnabled(price, 50);
		
		priceAmazon = Double.parseDouble(price.getText().substring(2).replaceAll(",",""));
	    
	}


}