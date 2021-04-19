package com.digitas.gsk.trgr.TrgrValidation.db;
//
//import java.io.File;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Set;
//import java.util.StringJoiner;
//
public class Runner {

//	static String S = File.separator;
//	
//	public static void main(String[] args) throws SQLException {
//
//		DataBaseUtilities db = new DataBaseUtilities();
//		String filePath = "C:\\Users\\Boney\\Documents\\trgrvalidation\\downloads\\SDF-LineItems.csv";
//
//		System.out.println("hi");
//		String tableName = db.createTableInMemory(filePath);
//
//		// DriverManager.getConnection("jdbc:derby:;shutdown=true");
//
//		String selectParam = "Select Type, Name, Status from ";
//		// String filterStatus = " Where Status = 'Active' and name like
//
//		String filterStatus = " Where name like '%us-ma-boston%'";
//
//		int SickScore = 70;
//
//		HashMap<String, ArrayList<String>> hm = db.getRowsInHashmap(tableName, selectParam, filterStatus, "countryCode");
//
//		System.out.println("\n\n\n\n\n\n");
//
//		if (SickScore >= 26 && SickScore <= 51) {
//			
//			System.out.println("When the SickScore reveived is :- " + SickScore);
//			String expectedStatusForLow = "Active";
//			String expectedStatusForMed = "Paused";
//			String expectedStatusForHigh = "Paused";
//			TestStatus(hm, expectedStatusForLow, expectedStatusForMed, expectedStatusForHigh);
//		}
//
//		else if (SickScore >= 51 && SickScore <= 76) {
//			
//			System.out.println("When the SickScore reveived is :- " + SickScore);
//			String expectedStatusForLow = "Paused";
//			String expectedStatusForMed = "Active";
//			String expectedStatusForHigh = "Paused";
//
//			TestStatus(hm, expectedStatusForLow, expectedStatusForMed, expectedStatusForHigh);
//		} else if (SickScore >= 76) {
//			
//			System.out.println("When the SickScore reveived is :- " + SickScore);
//			String expectedStatusForLow = "Paused";
//			String expectedStatusForMed = "Paused";
//			String expectedStatusForHigh = "Active";
//
//			TestStatus(hm, expectedStatusForLow, expectedStatusForMed, expectedStatusForHigh);
//
//		}
//	}
//
//	public static void TestStatus(HashMap<String, ArrayList<String>> hm, String expectedStatusForLow,		
//			String expectedStatusForMed, String expectedStatusForHigh) {
//		
//		Set<String> keySet = hm.keySet();
//		for (String key : keySet) {
//			ArrayList<String> al = hm.get(key);
//
//			for (int i = 0; i < al.size(); i = i + 2) {
//
//				String actualStatusParam = al.get(i + 1);
//
//				String groupName = key;
//				String[] allParameters = al.get(i).split("-");
//				String levelParam = allParameters[1];
//				String[] countryCode = Arrays.copyOfRange(allParameters, 2, allParameters.length);
//				String CountryName = "";
//				StringJoiner sj = new StringJoiner("-");
//
//				for (String val : countryCode) {
//					sj.add(val);
//				}
//				CountryName = sj.toString();
//				// System.out.println(CountryName);
//
//				if (levelParam.equalsIgnoreCase("high")) {
//					if (expectedStatusForHigh.equalsIgnoreCase(actualStatusParam)) {
//						System.out
//								.println("PASSED expected group -" + groupName + " for " + CountryName + " to have a staus : "
//										+ expectedStatusForHigh + " Actual Status : " + actualStatusParam);
//					} else {
//						System.out
//								.println("FAILED expected group -" + groupName + " for " + CountryName + " to have a staus : "
//										+ expectedStatusForHigh + " Actual Status : " + actualStatusParam);
//					}
//				} else if (levelParam.equalsIgnoreCase("medium")) {
//					if (expectedStatusForMed.equalsIgnoreCase(actualStatusParam)) {
//						System.out
//								.println("PASSED expected group -" + groupName + " for " + CountryName + " to have a staus : "
//										+ expectedStatusForMed + " Actual Status : " + actualStatusParam);
//					} else {
//						System.out
//								.println("FAILED expected group -" + groupName + " for " + CountryName + " to have a staus : "
//										+ expectedStatusForMed + " Actual Status : " + actualStatusParam);
//					}
//				} else if (levelParam.equalsIgnoreCase("low")) {
//					if (expectedStatusForLow.equalsIgnoreCase(actualStatusParam)) {
//						System.out
//								.println("PASSED expected group -" + groupName + " for " + CountryName + " to have a staus : "
//										+ expectedStatusForLow + " Actual Status : " + actualStatusParam);
//					} else {
//						System.out
//								.println("FAILED expected group -" + groupName + " for " + CountryName + " to have a staus : "
//										+ expectedStatusForLow + " Actual Status : " + actualStatusParam);
//					}
//				}
//			}
//			System.out.println();
//		}
//	}

}
