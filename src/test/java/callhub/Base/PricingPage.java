package callhub.Base;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import callhub.PageObjects.PricingPageObject;

public class PricingPage extends BaseClass {
	
	public WebDriver driver;
	
	@BeforeTest
	public void openBrowser() throws IOException
	{
		driver= init();
		  
	}
  @Test(dataProvider="getData")
  public void pricingPage(String timeTravel,String name,String rate ) throws IOException {
	  PricingPageObject mp=new PricingPageObject(driver);
	  List<WebElement> tt=mp.getTimeTravel();
	 // System.out.println(tt.size());
	 for(int i=0;i<tt.size();i++)
	  {
		  if(mp.getTimeTravel().get(i).getText().equals(timeTravel))
		  {
			  System.out.println(mp.getTimeTravel().get(i).getText());
			  mp.getTimeTravel().get(i).click();
			 // System.out.println(pname.size());
			  List<WebElement> rates=mp.getMonthlyRates();
			  List<WebElement> pname=mp.getPricingName();
			  for(int k=0;k<pname.size();k++)
			  {
				 // System.out.println(mp.getMonthlyRates().get(k).getText());
				 // System.out.println(mp.getPricingName().get(k).getText());
				
				 if(mp.getPricingName().get(k).getText().contains(name))
				  {
					  String rate_value=mp.getMonthlyRates().get(k).getText();
					  String[] words=rate_value.split("\\s");
					  System.out.println("words "+words[0]);
					  Assert.assertEquals(words[0], rate);
					 
				  }
			  }
		  }
		 }
	  }
  
  @AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
  
  @DataProvider
  public Object[][] getData()
  {
	  Object[][] data=new Object[12][3];
	  
	  data[0][0]="Monthly";
	  data[0][1]="Pay as you go";
	  data[0][2]="$0";
	  
	  data[1][0]="Monthly";
	  data[1][1]="Business";
	  data[1][2]="$199.98/mo";
	  
	  data[2][0]="Monthly";
	  data[2][1]="Premium";
	  data[2][2]="$499.95/mo";
	  
	  data[3][0]="Quarterly";
	  data[3][1]="Pay as you go";
	  data[3][2]="$0";
	  
	  data[4][0]="Quarterly";
	  data[4][1]="Business";
	  data[4][2]="$189.98/mo";
	  
	  data[5][0]="Quarterly";
	  data[5][1]="Premium";
	  data[5][2]="$474.95/mo";
	  
	  data[6][0]="Half-yearly";
	  data[6][1]="Pay as you go";
	  data[6][2]="$0";
	  
	  data[7][0]="Half-yearly";
	  data[7][1]="Business";
	  data[7][2]="$185.98/mo";
	  
	  data[8][0]="Half-yearly";
	  data[8][1]="Premium";
	  data[8][2]="$464.95/mo";
	  
	  data[9][0]="Yearly";
	  data[9][1]="Pay as you go";
	  data[9][2]="$0";
	  
	  data[10][0]="Yearly";
	  data[10][1]="Business";
	  data[10][2]="$179.98/mo";
	  
	  data[11][0]="Yearly";
	  data[11][1]="Premium";
	  data[11][2]="$449.96/mo";
	  
	  
	  return data;
  }
 
}
	  
