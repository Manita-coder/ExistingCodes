package trgrValidation.APITests.stepDefs;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.digitas.gsk.trgr.TrgrValidation.EmailUtility;
import com.digitas.gsk.trgr.TrgrValidation.LoggerHelper;

public class testNgHooks implements ITestListener {

	static Logger log = LoggerHelper.getLogger(testNgHooks.class);

	static String recepients = TSHelper.getPropertyValue("Mailer_Address");

	static Date date = new Date();
	static long time = date.getTime();
	static Timestamp ts = new Timestamp(time);
	final static String id = ts.toString();

	static String mailText = "";

	@Override
	public void onStart(ITestContext context) {

		EmailUtility eu = new EmailUtility();
		eu.sendHeaderMail(recepients, id, "");
		log.info("\n\n\n\n\n");
		log.info("***************************************************************");
		log.info("LOG in @onStart");
		log.info("***************************************************************");
		log.info("\n\n\n\n\n");

		VariableHolder.setFileDownloadedForUKorUS("");
		VariableHolder.setlastDownloadPath("");
	}

	@Override
	public void onTestStart(ITestResult result) {
		log.info("***************************************************************");
		log.info("LOG in @onStart");
		log.info("***************************************************************");		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log.info("***************************************************************");
		log.info("LOG in @onTestSuccess");
		log.info("***************************************************************");
		mailText += ("Test Executed Successfully " + "\n");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		log.info("***************************************************************");
		log.info("LOG in @onTestFailure");
		log.info("***************************************************************");
		mailText += ("Test name Failed Execution " + "\n");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		log.info("***************************************************************");
		log.info("LOG in @onTestSkipped");
		log.info("***************************************************************");
		mailText += ("Test Skipped Execution " + "\n");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		log.info("***************************************************************");
		log.info("LOG in @onTestFailedButWithinSuccessPercentage");
		log.info("***************************************************************");
	}

	@Override
	public void onFinish(ITestContext context) {
		log.info("***************************************************************");
		log.info("LOG in @onFinish");
		log.info("***************************************************************");

		String filepath1 = Paths.get(System.getProperty("user.dir"), "results", "advanced", "report.html").toString();
		replaceSelected(filepath1);

		String filepath2 = Paths.get(System.getProperty("user.dir"), "results", "advanced", "pretty.txt").toString();
		String filepath3 = Paths.get(System.getProperty("user.dir"), "results", "logsForCurrentRunonly.txt").toString();

		String[] filePaths = { filepath1, filepath2, filepath3 };

		String ignoredLineItems = "";
		
		ignoredLineItems = ignoredLineItems + "\nUK Ignored Line Items = \"" + TSHelper.getPropertyValue("Ignore_LineItems_UK") + "\"\n";
		ignoredLineItems = ignoredLineItems + "\nUS Ignored Line Items = \"" + TSHelper.getPropertyValue("Ignore_LineItems_US") + "\"\n";
		
		EmailUtility eu = new EmailUtility();
		eu.sendMail(recepients, filePaths, id, mailText , ignoredLineItems);

		log.info("***************************************************************");
		log.info("LOG in @onFinish");
		log.info("***************************************************************");

	}

	public static void replaceSelected(String filePath) {
		try {
			// input the file content to the StringBuffer "input"
			BufferedReader file = new BufferedReader(new FileReader(filePath));
			String line;
			StringBuffer inputBuffer = new StringBuffer();

			while ((line = file.readLine()) != null) {
				inputBuffer.append(line);
				inputBuffer.append('\n');
			}
			String inputStr = inputBuffer.toString();

			file.close();
			String oldS = "<body class='extent standard default hide-overflow bdd-report'>";
			String newS = "<body class='extent standard default hide-overflow bdd-report dark'>";

			inputStr = inputStr.replace(oldS, newS);

			oldS = "title='Click to toggle theme. To enable by default, use theme configuration.'>";
			newS = "title='Click to toggle theme. To enable by default, use theme configuration.' class=\"white-text\">";

			inputStr = inputStr.replace(oldS, newS);

			oldS = "<div class=\"node-step\">passed</div>";
			newS = "";
			inputStr = inputStr.replace(oldS, newS);

			// write the new String with the replaced line OVER the same file
			FileOutputStream fileOut = new FileOutputStream(filePath);
			fileOut.write(inputStr.getBytes());
			fileOut.close();

		} catch (Exception e) {
			System.out.println("Problem reading file.");
		}
	}

}
