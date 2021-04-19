package trgrValidation.APITests.stepDefs;

import java.util.ArrayList;

public class VariableHolder {

	private static String lastDownloadPath = "";
	private static ArrayList<String> lastDownloadPathList = null;
	private static String FileDownloadedForUKorUS;
	
	private static boolean DestoryBrowser = true;

	public static void setlastDownloadPath(String lastDownloadPath) {
		VariableHolder.lastDownloadPath = lastDownloadPath;
	}

	public static void setlastDownloadPaths(ArrayList<String> lastDownloadPath) {
		lastDownloadPathList= lastDownloadPath;
	}

	public static String getlastDownloadPath() {
		return lastDownloadPath;
	}
	
	public static ArrayList<String> getAllfilePath() {
		return lastDownloadPathList;
				
	}

	public static void setFileDownloadedForUKorUS(String campaign) {
		FileDownloadedForUKorUS = campaign; 
	}

	public static String getFileDownloadedForUKorUS() {
		return FileDownloadedForUKorUS;
	}
	
	public static boolean getBrowserDestroyCondition() {
		return DestoryBrowser;
	}
	
	public static void setBrowserDestroyCondition() {
		DestoryBrowser = true;;
	}
}
