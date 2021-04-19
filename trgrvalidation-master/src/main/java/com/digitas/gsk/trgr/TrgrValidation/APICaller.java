package com.digitas.gsk.trgr.TrgrValidation;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.log4j.Logger;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APICaller {

	static String S = File.separator;
	
	public int callAPI(String location, int sickscoreValue, int ruleSetId) throws myAssertionException, InterruptedException {

		Logger log = LoggerHelper.getLogger(APICaller.class);
		String endPoint = projectUtilities.getPropertyValue("SA360_EndPoint");
		LinkedHashMap<String, String> hm = new LinkedHashMap<String, String>();
		Response response = null;
		
		String geoName_tag = "geo_name";
		String sickscoreValue_tag = "sickscore_allergy";
		String ruleSetId_tag = "rule_set_id";

		//location = projectUtilities.getPropertyValueSA360(location);
		hm.put(geoName_tag, location);
		hm.put(sickscoreValue_tag, sickscoreValue + "");
		hm.put(ruleSetId_tag, ruleSetId + "");
		
		log.info("Data prepared to be sent in the api call " + hm);	

		RequestSpecification request = RestAssured.given();
		request.header("Connection", "keep-alive");
		request.header("Cache-Control", "max-age=0");
		request.header("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36");
		request.header("Accept",
				"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
		request.header("Origin", endPoint);
		request.header("Upgrade-Insecure-Requests", "1");
		request.header("Referer", endPoint + "/");
		request.header("Accept-Encoding", "gzip, deflate");
		request.header("Accept-Language", "en-US,en;q=0.9");
		
		
		request.formParam("message", hm);

		log.info(hm);
		try {
			log.info("Request sent to the end point " + request.toString());
			response = request.post(endPoint + "/process-message");
		} catch (Exception e) {

			log.error("\n*\n*\n*\n*\n*  The End Point Has Issues \n*\n*\n*\n*\n*");
			throw new myAssertionException(
					"\n\n\nTHE END POINT IS DOWN OR\nTHE VPN IS DISCONNECTED\nALL STEPS BELOW SHOULD NOT BE CONSIDERED VALID");
		}

		log.info("Response StatusCode " + response.getStatusCode());
		
		//Thread.sleep(12000);

		return response.getStatusCode();

	}

	public int callAPIUK(String location, int sickscoreValue, int ruleSetId) throws myAssertionException {

		Logger log = LoggerHelper.getLogger(APICaller.class);

		String geoName_tag = "geo_name";
		String sickscoreValue_tag = "sickscore_allergy";
		String ruleSetId_tag = "rule_set_id";

		HashMap<String, String> hm = new HashMap<String, String>();

		hm.put(geoName_tag, location);
		hm.put(sickscoreValue_tag, sickscoreValue + "");

		if (ruleSetId > 0) {
			hm.put(ruleSetId_tag, ruleSetId + "");
		}

		log.info("Data prepared to be sent in the api call " + hm);

		String endPoint = projectUtilities.getPropertyValue("EndPoint");
		RequestSpecification request = RestAssured.given();
		request.header("Connection", "keep-alive");
		request.header("Cache-Control", "max-age=0");
		request.header("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36");
		request.header("Accept",
				"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
		request.header("Origin", endPoint);
		request.header("Upgrade-Insecure-Requests", "1");
		request.header("Referer", endPoint + "/");
		request.header("Accept-Encoding", "gzip, deflate");
		request.header("Accept-Language", "en-US,en;q=0.9");
		request.formParam("message", hm);
		Response response = null;

		try {
			log.info("Request sent to the end point " + request.toString());
			response = request.post(endPoint + "/process-message");
		} catch (Exception e) {

			log.error("\n*\n*\n*\n*\n*  The End Point Has Issues \n*\n*\n*\n*\n*");
			throw new myAssertionException(
					"\n\n\nTHE END POINT IS DOWN OR\nTHE VPN IS DISCONNECTED\nALL STEPS BELOW SHOULD NOT BE CONSIDERED VALID");
		}

		log.info("Response Received from the API end point " + response);
		log.info("Response StatusCode " + response.getStatusCode());

		return response.getStatusCode();

	}
}
