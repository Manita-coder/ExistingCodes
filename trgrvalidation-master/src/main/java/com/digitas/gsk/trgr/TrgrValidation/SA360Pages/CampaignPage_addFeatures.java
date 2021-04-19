package com.digitas.gsk.trgr.TrgrValidation.SA360Pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.digitas.gsk.trgr.TrgrValidation.LoggerHelper;
import com.digitas.gsk.trgr.TrgrValidation.SeleniumUtilities;
import com.digitas.gsk.trgr.TrgrValidation.projectUtilities;
import com.digitas.gsk.trgr.TrgrValidation.db.DataBaseUtilities;

public class CampaignPage_addFeatures {

	
	// WebDriver driver = su.getActiveDriverInstance();
	Logger log = LoggerHelper.getLogger(CampaignPage_addFeatures.class);
	HashMap<String, ArrayList<String>> final_hm = new HashMap<>();

	boolean encounteredLastRecord = false;

	public HashMap<String, ArrayList<String>> getAlltheLineItemforSelectedStatus(List<WebElement> allTableRows,
			WebElement nextPageOfLineItem_true) {
		
		SeleniumUtilities su = projectUtilities.getSeleniumUtilities();

		ArrayList<String> local_al = new ArrayList<>();
		String temp_data = "";
		String temp[];
		String groupingName = "";

		ArrayList<String> al_ofTextForEachTableRow = su.getJSTextForEachElement(allTableRows);

		for (String wb : al_ofTextForEachTableRow) {

			temp = wb.split("\n");
			for (String s : temp) {
				if ((s.trim().length() > 0) && !s.equals("-")) {
					temp_data = temp_data + s.trim() + "<-->";
				}
			}

			if (temp_data.contains("Line item<-->Delivery")) {
				temp_data = "";
				continue;
			}

			if (temp_data.contains("Video<-->ID")) {
				groupingName = "Video";
				temp_data = "";
				continue;
			}

			if (temp_data.contains("Display<-->ID")) {
				groupingName = "Display";
				temp_data = "";
				continue;
			}

			if (temp_data.contains("Total<-->")) {
				if (su.isPresent(nextPageOfLineItem_true)) {
					su.click(nextPageOfLineItem_true);
					encounteredLastRecord = false;
				} else {
					encounteredLastRecord = true;
				}
				break;
			}

			local_al.add(temp_data);
			addDataToMap(groupingName, local_al);
			local_al.clear();
			temp_data = "";
		}
		if (encounteredLastRecord) {
			log.info("The Final hash map data for each row on the web page " + final_hm);
			return final_hm;
		} else {
			log.info("Recurcive call to same method and moving to next page");
			getAlltheLineItemforSelectedStatus(allTableRows, nextPageOfLineItem_true);
			log.info(
					"Returning Hash map with data on current page in recuursive manner, this data will be collated as one");
			return final_hm;
		}
	}

	public void addDataToMap(String groupingName, ArrayList<String> lineItem_al) {

		if (final_hm.containsKey(groupingName)) {
			ArrayList<String> al = new ArrayList<>();
			al.addAll(lineItem_al);
			al.addAll(final_hm.get(groupingName));
			final_hm.put(groupingName, al);

		} else {
			ArrayList<String> al = new ArrayList<>();
			al.addAll(lineItem_al);
			final_hm.put(groupingName, al);
		}
	}

	public HashMap<String, ArrayList<String>> getAlltheLineItemInCSV(String selectParam, String filterStatus,
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

}