package trgrValidation.APITests.stepDefs;

import org.apache.log4j.Logger;

import com.digitas.gsk.trgr.TrgrValidation.APICaller;
import com.digitas.gsk.trgr.TrgrValidation.LoggerHelper;
import com.digitas.gsk.trgr.TrgrValidation.pages.CampaignPage;
import com.digitas.gsk.trgr.TrgrValidation.pages.GoogleAccountManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepsCommon {

	APICaller ap = null;
	GoogleAccountManager gac = null;
	CampaignPage cp = null;
	

	Logger log = LoggerHelper.getLogger(StepsCommon.class);

	@Given("^Project resource are ready and Loaded$")
	public void project_resource_are_ready_and_Loaded() throws Throwable {

		//projectUtilities.setupProject();
		//ap = new APICaller();
		//VariableHolder.setApiCaller(ap);
	}

	@Then("^I wait for (\\d+) seconds$")
	public void i_wait_for_about_seconds(int waitSeconds) throws Throwable {

		try {
			log.info("Sleeping for " + waitSeconds + " seconds after posting API request");
			Thread.sleep(waitSeconds * 1000);
			log.info("Wait Complete for " + waitSeconds + " seconds");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Then("^close All Resources after the run$")
	public void close_All_Resources_after_the_run() throws Throwable {
//		projectUtilities.tearDown();
//		ap = null;
//		gac = null;
//		cp = null;
//		log.info("The Execution has Completed");
	}
}
