package trgrValidation.SA60Tests;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = { "src/test/resources/USTestCasesSA360" }, 	
			
			tags= {"@2_All_Bild_Levels_seq_0_10_20_m20"},
			glue = { "trgrValidation.APITests" }, 
			plugin = {
				"com.cucumber.listener.ExtentCucumberFormatter:results/advanced/report.html",
				"pretty:results/advanced/pretty.txt", "html:results/basics" }, 
			monochrome = true)



public class _2_All_Bild_Levels_seq_0_10_20_m20 extends AbstractTestNGCucumberTests {
	
}