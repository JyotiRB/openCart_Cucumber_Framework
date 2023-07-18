package StepDefinations_opencart;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataReader;

public class steps 
{
     WebDriver driver;
     HomePage hp;
     LoginPage lp;
     MyAccountPage macc;

     List<HashMap<String, String>> datamap; //Data driven

     Logger logger; //for logging
     ResourceBundle rb; // for reading properties file
     String br; //to store browser name



    @Before
    public void setup()    //Junit hook - executes once before starting
    {
        //for logging
        logger= LogManager.getLogger(this.getClass());
        //Reading config.properties (for browser)
        rb=ResourceBundle.getBundle("config");
        br=rb.getString("browser");
     
    }

    @After
    public void tearDown(Scenario scenario) 
    {
        System.out.println("Scenario status ======>"+scenario.getStatus());
        if(scenario.isFailed()) 
        {
        	
        	TakesScreenshot ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());
        	            
        }
       driver.quit();
    }

    

   //*******   Data Driven test method using excel     **************
   
    @Then("check User navigates to home Page by passing Email and Password with excel row {string}")
    public void check_user_navigates_to_home_page_by_passing_email_and_password_with_excel_row(String rows) 
    {
    	
        datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\Opencart_LoginData.xlsx", "Sheet1");

        int index=Integer.parseInt(rows)-1;
        String email= datamap.get(index).get("username");
        String pwd= datamap.get(index).get("password");
        String exp_res= datamap.get(index).get("res");

        lp=new LoginPage(driver);
        lp.clickloginpage();
        lp.setEmail(email);
        lp.setPassword(pwd);
        lp.clickLoginbtn();

        
        try
        {
        	
        	
        	boolean targetpage = lp.Uservalidate();
    		
        	
           // boolean targetpage=macc.isMyAccountPageExists();

            if(exp_res.equals("Valid"))
            {
                if(targetpage==true)
                {
                    //MyAccountPage myaccpage=new MyAccountPage(driver);
                   // myaccpage.clickLogout();
                    Assert.assertTrue(true);
                    logger.info("Login success ");
                }
                else
                {
                	logger.info("Login Failed ");
                    Assert.assertTrue(false);
                }
            }

            if(exp_res.equals("Invalid"))
            {
                if(targetpage==true)
                {
                  //  macc.clickLogout();
                    Assert.assertTrue(false);
                }
                else
                {
                    Assert.assertTrue(true);
                }
            }


        }
        catch(Exception e)
        {

            Assert.assertTrue(false);
        }
        driver.close();
    }

    //*******   Account Registration Methods    **************

	
	@Given("User will Launch the browser")
	public void user_will_launch_the_browser() 
	{
		if(br.equals("chrome"))
        {
        	WebDriverManager.chromedriver().setup();
           driver=new ChromeDriver();
        }
        else if (br.equals("firefox"))
        {
        	WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if (br.equals("edge")) 
        {
        	
        	WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    
	}
	
	@Given("opens the URL {string}")
	public void opens_the_url(String url) 
	{
	  driver.get(url);
	  logger.info(" Open URL ");
	  driver.manage().window().maximize();
	
	}
	
	@Given("click to Login button")
	public void click_to_login_button() 
	{
		lp=new LoginPage(driver);
		lp.clickloginpage();
		logger.info(" User clicks on login button ");
	}
	
	@Given("User enters Email address as {string} and the Password as {string}")
	public void user_enters_email_address_as_and_the_password_as(String string, String string2)
	{
	    lp.setEmail(string);
	    lp.setPassword(string2);
	    logger.info("User enters Email address and the Password");
	}
	
	@Given("Click on the Login button")
	public void click_on_the_login_button() 
	{
	    lp.clickLoginbtn();
	    logger.info("User clicks on login button");
	}
	
	@Then("User navigates to home Page")
	public void user_navigates_to_home_page()
	{
	   
		boolean targetpage = lp.Uservalidate();
		
		if(targetpage)
		{
			
		    Assert.assertTrue(true);
			logger.info("Login success ");
	    }
		else
		{
			logger.info("Login Failed ");
			Assert.assertTrue(false);
			
		}
	
	}
		
		//Data driver using example 
	
	@Given("he will  enters Email address as {string}  and the Password as  {string}")
	public void he_will_enters_email_address_as_and_the_password_as(String email, String password)
	{
		lp.setEmail(email);
	    lp.setPassword(password);

    }
	
}

