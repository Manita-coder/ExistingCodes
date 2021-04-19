package com.digitas.gsk.trgr.TrgrValidation.db;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.digitas.gsk.trgr.TrgrValidation.LoggerHelper;

public class DataBaseUtilities 
{

	static String S = File.separator;
	Logger log = LoggerHelper.getLogger(DataBaseUtilities.class);
	Database database = null;
	Connection connection = null;
	HashMap<String, ArrayList<String>> final_hm = null;

	public DataBaseUtilities() {

		log.info("Database object initailized");
		database = new Database();
		log.info("Global connection is set");
		connection = database.getConnection();
	}

	public String createTableInMemory(String csvFilePath) 
	{
		Database database = new Database();
		Path csvFileToBeRead = Paths.get(csvFilePath);
		database.read(csvFileToBeRead);
		String tableName = database.getTableName(csvFileToBeRead);

		log.info("\n Table name returned upon creation : " + tableName);
		return tableName;
	}

	public HashMap<String, ArrayList<String>> getRowsInHashmap(String tableName, String selectParam,
			String filterStatus, String countryCode) 
	{

		final_hm = new HashMap<>();
		try {
			Statement statement = connection.createStatement();
			String selectQuery = selectParam + tableName + filterStatus;

			System.out.println(selectQuery);
			ResultSet rs = statement.executeQuery(selectQuery);

			log.info("\n\n\n***************************************");
			log.info("\n The Select Query Fired on the created DB \n");
			log.info("---- > " + selectQuery + " < ------");
			log.info("***************************************\n\n\n");

			if (getOrderedData(rs)) {
				System.out.println("data retrival is successfull");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("\n\n The Data after we filtered the results from select query :\n");
		log.info("---- > \n" + final_hm + " \n< ------");
		return final_hm;
	}
	
	public HashMap<String, ArrayList<String>> getRowsInHashmap_sa_360(String tableName, String selectParam,
			String filterStatus) {

		final_hm = new HashMap<>();
		try {
			Statement statement = connection.createStatement();
			String selectQuery = selectParam + tableName + filterStatus;

			System.out.println(selectQuery);
			ResultSet rs = statement.executeQuery(selectQuery);

			log.info("\n\n\n***************************************");
			log.info("\n The Select Query Fired on the created DB \n");
			log.info("---- > " + selectQuery + " < ------");
			log.info("***************************************\n\n\n");

			if (getOrderedData_SA_360(rs)) {
				System.out.println("data retrival is successfull");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("\n\n The Data after we filtered the results from select query :\n");
		log.info("---- > \n" + final_hm + " \n< ------");
		return final_hm;
	}

	public boolean getOrderedData(ResultSet rs) 
	{

		boolean executionStatus = true;
		try 
		{

			while (rs.next()) 
			{
				String groupingName = rs.getString(1);
				System.out.println("Group name"+groupingName);
				ArrayList<String> al = new ArrayList<>();
				al.add(rs.getString(2));
				al.add(rs.getString(3));
				addDataToMap(groupingName, al);
				System.out.println("added other input:"+al);
			}
		}

		catch (Exception e) 
		{
			e.printStackTrace();
			executionStatus = false;
		}

		return executionStatus;
	}
	
	public boolean getOrderedData_SA_360(ResultSet rs) {

		boolean executionStatus = true;
		try {

			while (rs.next()) {
				String groupingName = rs.getString(1);
				ArrayList<String> al = new ArrayList<>();
				al.add(rs.getString(2));	
				al.add(rs.getString(3));
				addDataToMap(groupingName, al);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			executionStatus = false;
		}

		return executionStatus;
	}

	public void addDataToMap(String groupingName, ArrayList<String> lineItem_al) {

		if (final_hm.containsKey(groupingName)) {

			ArrayList<String> al = new ArrayList<>();
			al.addAll(lineItem_al);

			al.addAll(final_hm.get(groupingName));
			final_hm.put(groupingName, al);
			// System.out.println(final_hm);
		} else {
			ArrayList<String> al = new ArrayList<>();
			al.addAll(lineItem_al);

			final_hm.put(groupingName, al);
			// System.out.println(final_hm);
		}
	}

	public void dropDatabase() {
		database.closeConnectionandDestroyData();

	}

	public void dropTable(String tableName) {
		try {
			
			Statement statement = connection.createStatement();
			String selectQuery = "Drop Table " + tableName;
			System.out.println(selectQuery);
			statement.executeQuery(selectQuery);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}