package pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	 WebDriver driver;
	    
	   public BasePage(WebDriver driver)
	     {
		     this.driver=driver;
		     PageFactory.initElements(driver,this);
	     }
	   	   
	   
	   
	 //Give random string and will return 
		public String randomeString() 
		{
			String generatedString = RandomStringUtils.randomAlphabetic(5);
			return (generatedString);
		}

		//Give random number and will return 
		public String randomeNumber() 
		{
			String generatedString2 = RandomStringUtils.randomNumeric(10);
			return (generatedString2);
		}
		
		//Give random number and string will return
		public String randomAlphaNumeric() 
		{
			String st = RandomStringUtils.randomAlphabetic(5);
			String num = RandomStringUtils.randomNumeric(4);
			
			return (st+"@"+num);
		}
		
		
	   
}





