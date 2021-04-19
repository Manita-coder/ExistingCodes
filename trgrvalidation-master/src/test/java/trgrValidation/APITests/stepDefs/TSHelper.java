package trgrValidation.APITests.stepDefs;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.digitas.gsk.trgr.TrgrValidation.LoggerHelper;
import com.digitas.gsk.trgr.TrgrValidation.SeleniumUtilities;
import com.digitas.gsk.trgr.TrgrValidation.myAssertionException;
import com.digitas.gsk.trgr.TrgrValidation.projectUtilities;
import com.digitas.gsk.trgr.TrgrValidation.db.DataBaseUtilities;
import com.digitas.gsk.trgr.TrgrValidation.pages.CampaignPage_addFeatures;

public class TSHelper {

	static HashMap<String, ArrayList<String>> hm_DisplayVideo_ListOfGeoCodesWithStatus = null;
	static HashMap<String, ArrayList<String>> hm_Bid_Location = null;
	static Logger log = LoggerHelper.getLogger(TSHelper.class);

	static boolean StartTime = false;
	static String startTime = "";

	public static HashMap<String, ArrayList<String>> getHasmMapWithLevelandStatusForGeoCode(String selectParam,
			String filterStatus, String geoCode) {
		
		
		CampaignPage_addFeatures cp = new CampaignPage_addFeatures();
		hm_DisplayVideo_ListOfGeoCodesWithStatus = cp.getAlltheLineItemInCSV(selectParam, filterStatus, geoCode,
				VariableHolder.getlastDownloadPath());

		String campaign = VariableHolder.getFileDownloadedForUKorUS();
		String ignoreLineItems[] = null;

		try {
			if (campaign.equalsIgnoreCase("UK")) 
			{
				ignoreLineItems = TSHelper.getPropertyValue("Ignore_LineItems_UK").split(",");

				for (String s : ignoreLineItems) 
				{
					hm_DisplayVideo_ListOfGeoCodesWithStatus.remove(s);
				}
			} else if (campaign.equalsIgnoreCase("US")) {
				ignoreLineItems = TSHelper.getPropertyValue("Ignore_LineItems_US").split(",");

				for (String s : ignoreLineItems) {
					hm_DisplayVideo_ListOfGeoCodesWithStatus.remove(s);
				}
			}
		} catch (Exception e) {
			log.error("Invalid ignore line item value passed  " + e.getMessage());
			log.error("IgnoreLine Item Value = " + Arrays.toString(ignoreLineItems));
		}
		return hm_DisplayVideo_ListOfGeoCodesWithStatus;
	}

	public static HashMap<String, ArrayList<String>> getHasmMapWithBidData(String selectParam, String filterStatus) {

		hm_Bid_Location = getAlltheLineItemInCSV_SA_360(selectParam, filterStatus,
				VariableHolder.getlastDownloadPath());
		System.out.println(hm_Bid_Location);
		return hm_Bid_Location;
	}

	public static HashMap<String, ArrayList<String>> getHasmMapWithBidData(String selectParam, String filterStatus,
			String filePath) {

		hm_Bid_Location = getAlltheLineItemInCSV_SA_360(selectParam, filterStatus, filePath);
		return hm_Bid_Location;
	}

	public static void assertCondtion(String expected, String actual) throws myAssertionException {
		try {
			if (expected.length() != 0) {
				assertEquals(expected, actual);
			} else {
				expected = "\n\n THERE IS NO SUCH DATA IN DV360 \n THE SELECT QUERY RETURNED EMPTY DATA \n THIS TEST IS FAILED AND SHOULD BE CONSIDERED INVALID";
				assertEquals(expected, actual);
			}

		} catch (AssertionError ae) {
			throw new myAssertionException("\n\nExpected : " + expected + "\nActual : " + actual);
		}
	}

	public static ArrayList<String> TestStatus(HashMap<String, ArrayList<String>> hm, String expectedStatus,
			String levelBeingVerified) {

		HashMap<String, ArrayList<String>> resultMap = new HashMap<>();

		Set<String> keySet = hm.keySet();

		for (String key : keySet) {
			ArrayList<String> al = hm.get(key);

			for (int i = 0; i < al.size(); i = i + 2) {

				String actualStatusParam = al.get(i + 1);

				ArrayList<String> lineResult = new ArrayList<String>();

				lineResult.add(" Expected --->\"" + expectedStatus + "\"");
				lineResult.add(" Actual --->\"" + actualStatusParam + "\"");

				if (expectedStatus.contains(actualStatusParam) || expectedStatus.equalsIgnoreCase(actualStatusParam)) {
					lineResult.add(" Result -\"" + "Pass" + "\"");
				} else {
					lineResult.add(" Result -\"" + "Fail" + "\"");
				}
				resultMap.put("\n" + key, lineResult);

			}
		}

		return getConsolidatedResut(resultMap);
	}

	public static ArrayList<String> TestStatus_sa360(HashMap<String, ArrayList<String>> hm, String expectedStatus,
			String actalStatus) {

		HashMap<String, ArrayList<String>> resultMap = new HashMap<>();

		Set<String> keySet = hm.keySet();

		for (String key : keySet) {
			ArrayList<String> al = hm.get(key);

			for (int i = 0; i < al.size(); i = i + 2) {

				String actualStatusParam = al.get(i + 1);

				ArrayList<String> lineResult = new ArrayList<String>();

				lineResult.add(" Expected --->\"" + expectedStatus + "\"");
				lineResult.add(" Actual --->\"" + actualStatusParam + "\"");

				if (expectedStatus.contains(actualStatusParam) || expectedStatus.equalsIgnoreCase(actualStatusParam)) {
					lineResult.add(" Result -\"" + "Pass" + "\"");
				} else {
					lineResult.add(" Result -\"" + "Fail" + "\"");
				}
				resultMap.put("\n" + key, lineResult);

			}
		}

		return getConsolidatedResut(resultMap);
	}

	public static ArrayList<String> getConsolidatedResut(HashMap<String, ArrayList<String>> result) {

		Set<String> keySet = result.keySet();
		String finalResult = "\n";

		for (String key : keySet) {
			finalResult = finalResult + key + " : ";
			ArrayList<String> al = result.get(key);
			finalResult = finalResult + al.toString() + "\n";
		}

		String actual = finalResult;
		String expected = actual.replace("Fail", " Expected to match");

		ArrayList<String> al = new ArrayList<String>();
		al.add(actual);
		al.add(expected);

		return al;
	}

	public static String getPropertyValue(String key) 
	{

		Properties prop = new Properties();
		InputStream input = null;
		String property = "";

		try {

			File f = new File(
					Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "testConfig.properties")
							.toString());
			input = new FileInputStream(f);

			prop.load(input);
			property = prop.getProperty(key);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return property.trim();
	}

	public static String getPropertyValueDMA(String key) 
	{

		Properties prop = new Properties();
		InputStream input = null;
		String property = "";

		try {

			File f = new File(
					Paths.get(System.getProperty("user.dir"), "resources", "DMA_Mapping.properties").toString());
			input = new FileInputStream(f);

			prop.load(input);
			property = prop.getProperty(key);

		} 
		catch (IOException ex) {
			ex.printStackTrace();
		} 
		finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return property.trim();
	}

	public static HashMap<String, ArrayList<String>> getAlltheLineItemInCSV(String selectParam, String filterStatus,
			String countryCode, String downloadPath) {

		DataBaseUtilities du = projectUtilities.getDatabaseUtilities();
		log.info("Creating database in memory for given path " + downloadPath);
		String tableName = du.createTableInMemory(downloadPath);

		HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
		hm = du.getRowsInHashmap(tableName, selectParam, filterStatus, countryCode);

		du.dropTable(tableName);
		log.info("\n\n*************************************\n");
		log.info("All line item in csv " + hm);
		log.info("\n\n*************************************\n");
		return hm;
	}

	public static HashMap<String, ArrayList<String>> getAlltheLineItemInCSV_SA_360(String selectParam,
			String filterStatus, String downloadPath) {

		DataBaseUtilities du = projectUtilities.getDatabaseUtilities();
		log.info("Creating database in memory for given path " + downloadPath);

		String tableName = du.createTableInMemory(downloadPath);

		HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
		hm = du.getRowsInHashmap_sa_360(tableName, selectParam, filterStatus);

		du.dropTable(tableName);
		log.info("\n\n*************************************\n");
		log.info("All line item in csv " + hm);
		log.info("\n\n*************************************\n");
		return hm;
	}

	public static void setFirstStart() {
		if (StartTime == false) {
			String DATEFORMAT = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT);
			sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
			startTime = sdf.format(new Date());
			StartTime = true;
		}

	}

	public static String getCurrentTime() {
		String DATEFORMAT = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT);
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		String endTime = sdf.format(new Date());
		StartTime = false;
		return endTime;
	}

	

}
