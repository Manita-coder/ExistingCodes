package trgrValidation.SA60Tests;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = { "src/test/resources/USTestCasesSA360" }, 	
			
			tags= {"@20_percent"},
			glue = { "trgrValidation.APITests" }, 
			plugin = {
				"com.cucumber.listener.ExtentCucumberFormatter:results/advanced/report.html",
				"pretty:results/advanced/pretty.txt", "html:results/basics" }, 
			monochrome = true)



public class _20_percent extends AbstractTestNGCucumberTests {
	
}