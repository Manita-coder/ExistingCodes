package trgrValidation.APITests.stepDefs;

import org.apache.log4j.Logger;

import com.digitas.gsk.trgr.TrgrValidation.APICaller;
import com.digitas.gsk.trgr.TrgrValidation.LoggerHelper;
import com.digitas.gsk.trgr.TrgrValidation.projectUtilities;
import com.digitas.gsk.trgr.TrgrValidation.pages.CampaignPage;
import com.digitas.gsk.trgr.TrgrValidation.pages.GoogleAccountManager;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BDDHooks {
	static Logger log = LoggerHelper.getLogger(BDDHooks.class);

	APICaller ap = null;
	GoogleAccountManager gac = null;
	CampaignPage cp = null;

	@Before
	public void beforeEachScenario(Scenario s) {
		log.info("\n");
		log.info("***************************************************************");
		log.info("LOG in @Before  and the Feature name is : " + s.getId());
		log.info("LOG in @Before  and the Scenario name is : " + s.getName());

		// testNgHooks.featuresAndScenariosExecuted.append("\n");
		// testNgHooks.featuresAndScenariosExecuted.append("\n" + "Feature name : " +
		// s.getId().split(";")[0] + "\n");
		// testNgHooks.featuresAndScenariosExecuted.append("\n" + "Test name : " +
		// s.getName() + "\n");
		// testNgHooks.featuresAndScenariosExecuted.append("\n");

		log.info("***************************************************************");
		log.info("\n");

		projectUtilities.setupProject();

	}

	@After
	public void afterEachScenario(Scenario s) {
		log.info("\n");
		log.info("***************************************************************");
		log.info("LOG in @Before  and the Feature name is : " + s.getId());
		log.info("LOG in @After  and the Scenario name is : " + s.getName());

		if (s.isFailed()) {
			// testNgHooks.featuresAndScenariosExecuted.append("\n");
			// testNgHooks.featuresAndScenariosExecuted.append("\n" + "Failure : " +
			// s.getName() + "\n");
			// testNgHooks.featuresAndScenariosExecuted.append("\n");

		} else {
			// testNgHooks.featuresAndScenariosExecuted.append("\n" +
			// "------------------------------------------\n");
			// testNgHooks.featuresAndScenariosExecuted
			// .append(testNgHooks.featuresAndScenariosExecuted + "Passed : " + s.getName()
			// + "\n");
			// testNgHooks.featuresAndScenariosExecuted.append("\n");

		}
		log.info("***************************************************************");
		log.info("\n");

		//VariableHolder.
		projectUtilities.tearDown();
		ap = null;
		gac = null;
		cp = null;
		log.info("The Execution has Completed");
	}

}
