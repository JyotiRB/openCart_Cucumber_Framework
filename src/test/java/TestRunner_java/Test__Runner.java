package TestRunner_java;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

		//features= {".//Features/LoginDDT.feature"},
        //features= {".//Features/LoginDDTExcel.feature"},
        //features= {".//Features/Login.feature",".//Features/AccountRegistration.feature"},//run specific features 
       // features="@target/rerun.txt",   // Runs only failures
        features= {".//Features/LoginDDtExcel.feature"},
        glue="StepDefinations_opencart",
        plugin= {
        		"pretty", "html:reports/myreport.html", 
        		"json:reports/myreport.json"
        		},    //Mandatory to capture failures
        dryRun=false,
        monochrome=true
        //tags = "@sanity"	//Scenarios tagged with @sanity,
      )
public class Test__Runner 
{

}

