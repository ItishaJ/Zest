package main.java.com.Zest.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import main.java.com.Zest.project.Util.Constant;
import main.java.com.Zest.project.base.BasePage;

public class FlipkartHome extends BasePage {

	@FindBy(xpath = "//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input")
	WebElement search;

	@FindBy(css = "button[class='vh79eN']")
	WebElement button;

	@FindBy(partialLinkText = "Apple iPhone XR")
	WebElement mobile;

	@FindBy(css = "button[class='_2AkmmA _29YdH8']")
	WebElement cancel;

	public FlipkartHome(WebDriver driver) {
		// TODO Auto-generated constructor stub {
		super(driver);
	}

	public void search() throws InterruptedException {

		OpenUrl(Constant.URLflip);
		click(cancel);
		explicitWaitTillElementIsEnabled(search, 50);
		type(search, "iPhone XR (64GB) - Yellow");
		click(button);
	}

	public void clickmobile() {
		click(mobile);
	}
}