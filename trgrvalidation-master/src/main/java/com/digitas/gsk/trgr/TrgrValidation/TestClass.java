package com.digitas.gsk.trgr.TrgrValidation;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.TimeZone;

public class TestClass {

	public static void main(String[] args) throws InterruptedException, IOException {
	
		String S = File.separator;
		
		System.out.println(S);
		//String var = "8772268944";
		//System.out.println(var.substring(0, 3) + "." + var.substring(3,6) + "." + var.substring(6));
		//GetUTCdatetimeAsString();
		//System.out.println(GetUTCdatetimeAsString());
	}

	public static String GetUTCdatetimeAsString() {
		String DATEFORMAT = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT);
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		String now = sdf.format(new Date());
		
		System.out.println(now);
		return null;
	}
}
