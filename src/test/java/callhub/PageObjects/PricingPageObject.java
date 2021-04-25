package callhub.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PricingPageObject {
	public WebDriver driver;
	By monthlyRadioButton=By.xpath("//h6[text()='Monthly']");
	//By timeTravel=By.xpath("//ul[@class='plan-pricing-timeline']//li//h6");
	By timeTravel=By.xpath("//h6[@class='m-0']");
	By rates=By.xpath("//h3[contains(text(),'$')]");
	By pricingName=By.xpath("//h5[@class='fs18']");
	public PricingPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public List<WebElement> getTimeTravel()
	{
		return driver.findElements(timeTravel);
	}
	public WebElement getMonthlyRadioButton()
	{
		return driver.findElement(monthlyRadioButton);
	}
	public List<WebElement> getMonthlyRates()
	{
		return driver.findElements(rates);
	}
	public List<WebElement> getPricingName()
	{
		return driver.findElements(pricingName);
	}

}
