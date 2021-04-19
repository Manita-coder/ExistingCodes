package trgrValidation.SA60Tests;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = { "src/test/resources/USTestCasesSA360" }, 	
			
			tags= {"@1_All_Bild_Levels_seq_m20_0_10_20"},
			glue = { "trgrValidation.APITests" }, 
			plugin = {
				"com.cucumber.listener.ExtentCucumberFormatter:results/advanced/report.html",
				"pretty:results/advanced/pretty.txt", "html:results/basics" }, 
			monochrome = true)



public class _1_All_Bild_Levels_seq_m20_0_10_20 extends AbstractTestNGCucumberTests {
	
}