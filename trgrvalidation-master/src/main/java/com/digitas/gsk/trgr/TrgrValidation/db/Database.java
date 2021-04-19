package com.digitas.gsk.trgr.TrgrValidation.db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.digitas.gsk.trgr.TrgrValidation.LoggerHelper;

public class Database {

	static String S = File.separator;
	
	private static final String ISO_8859_1 = "ISO-8859-1";

	private List<Path> paths = new ArrayList<>();
	private Map<String, List<String>> columnNames = new HashMap<>();

	Connection connection = null;
	Logger log = LoggerHelper.getLogger(Database.class);

	public String getTableName(Path path) {

		log.info("Get Table name from given path " + path.getFileName());
		String tableName = path.getFileName().toString().replace(".csv", "");
		tableName = tableName.replace("-", "_");
		tableName = tableName.replace(" ", "");
		tableName = tableName.replace("(", "_");
		tableName = tableName.replace(")", "_");
		log.info("Table name After cleaning " + tableName);
		return tableName;
	}

	public void read(Path path) {
		log.info("Read data from file name into a table " + path.getFileName());
		read(path, ISO_8859_1);

		log.info("Reading data from file name into a table completed" + path.getFileName());
	}

	public void read(Path path, String charsetName) {

		charsetName = "UTF-16"; // da360
		log.info("Read data from file name into a table.  File Path Name = " + path.getFileName());

		this.paths.add(path);
		Charset charset = Charset.forName(charsetName);
		String tableName = getTableName(path);

		try {
			List<String> lines = Files.readAllLines(path, charset);

			String header = lines.get(0);
			header = header.replace("-", "_");
			header = header.replace("&", "and");
			header = header.replace("%", "");
			createTable(tableName, header);

			for (int i = 1; i < lines.size(); i++) {

				System.out.println(i);
				String column = lines.get(i);
				if (column.endsWith(",")) {
					column = column + "end";
				}
				insertRow(tableName, column);
			}

		} catch (IOException e) {
			log.error("Reading data from CSV caused exception  " + e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			log.error("Reading data from CSV caused exception  " + e.getMessage());
			e.printStackTrace();
		}
	}

	private void insertRow(String tableName, String line) throws SQLException {
		String[] values = line.split(",");

		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO ").append(tableName);
		query.append(" VALUES (");
		String prefix = "";

		String startOfCommaValue = "";
		String endOfCommaValue = "";
		String middleOfCommaValue = "";

		boolean commedValueEnded = true;

		for (String value : values) {

			int invertedCount = getCountOfDoubleInverted(value, '"');

			if (invertedCount == 1 || commedValueEnded == false) {

				if (startOfCommaValue.equals("")) {
					startOfCommaValue = value;
					commedValueEnded = false;
					continue;
				}

				if (!value.contains("\"")) {
					middleOfCommaValue = middleOfCommaValue + "," + value;
					continue;
				}

				if (startOfCommaValue.length() > 0) {
					endOfCommaValue = value;
					value = startOfCommaValue + middleOfCommaValue + "," + endOfCommaValue;
					value = value.replace("\"", "");
					startOfCommaValue = "";
					endOfCommaValue = "";
					middleOfCommaValue = "";

					commedValueEnded = true;
				}

			}
			query.append(prefix);
			query.append("'").append(value).append("'");
			prefix = ",";

		}
		query.append(")");

		Connection connection = getConnection();
		Statement statement = connection.createStatement();
		log.info("Row Inserted in to table " + query);
		statement.executeUpdate(query.toString());
		statement.close();
	}

	private int getCountOfDoubleInverted(String value, char lookup_value) {
		int count = 0;
		char[] charArr = value.toCharArray();

		for (char s : charArr) {			
			if (s == lookup_value) {
				count++;
			}
		}
		
		return count;
	}

	private void createTable(String tableName, String line) throws SQLException 
	{
		String[] columnNames = line.split(",");
		this.columnNames.put(tableName, new ArrayList<>());
		Connection connection = getConnection();

		try {
			String dropOldData = "drop table " + tableName;
			Statement statement_drop = connection.createStatement();
			statement_drop.executeQuery(dropOldData);
			statement_drop.close();
		} catch (Exception e) {
			System.out.println("Table already existed, dropped table to ingore old data");
		}

		StringBuilder query = new StringBuilder();
		query.append("CREATE TABLE ").append(tableName);
		query.append(" (");
		String prefix = "";
		for (String columnName : columnNames) 
		{
			String trimmedColumnName = columnName.trim().replaceAll("\\s", "_");
			query.append(prefix);
			query.append(trimmedColumnName).append(" ").append("varchar(255)");
			prefix = ",";
			this.columnNames.get(tableName).add(trimmedColumnName);
		}
		query.append(")");

		Statement statement = connection.createStatement();
		log.info("QUERY TO CREATE TABLE " + query.toString());
		statement.executeUpdate(query.toString());
		statement.close();
	}

	public List<String> getColumnNames(Path path) {
		return columnNames.get(getTableName(path));
	}

	public Connection getConnection() {
		// Connection connection = null;

		if (connection == null) {
			try {
				log.info("In Memory Databse create " + "jdbc:hsqldb:mem:" + getDbName());
				Class.forName("org.hsqldb.jdbc.JDBCDriver");
				connection = DriverManager.getConnection("jdbc:hsqldb:mem:" + getDbName(), "SA", "");
			} catch (Exception ex) {
				log.error("In Memory Databse create caused error" + "jdbc:hsqldb:mem:" + getDbName() + " "
						+ ex.getMessage());
				ex.printStackTrace();
			}
		}

		return connection;
	}

	private String getDbName() {
		return "trgr";
	}

	public List<Path> getPaths() {
		return paths;
	}

	public void closeConnectionandDestroyData() {
		try {
			DriverManager.getConnection("jdbc:hsqldb:mem:" + getDbName() + ";shutdown=true", "SA", "");

		} catch (SQLException e) {
			log.error("In Memory Databse drop caused error jdbc:hsqldb:mem:" + getDbName() + " " + e.getMessage());
			e.printStackTrace();
		}

	}
}