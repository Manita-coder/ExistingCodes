package com.automation.LP8Testimonial.test;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import jxl.CellView;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import com.digitas.automation.element.PageActions;
import com.digitas.automation.path.GeneralCardsForLP8b;
import com.digitas.automation.path.LP8DefaultCode;
import com.digitas.automation.path.LP8TestimonialLinkPath;
import com.digitas.automation.utils.FirefoxDriverConfig;

public class LP8ForPremiumTest {
	protected static WebDriver driver = FirefoxDriverConfig.getInstance().getFirefoxDriver();

	private WritableCellFormat timesBoldUnderline;
	private WritableCellFormat times;
	private WritableCellFormat timescolor1;
	private WritableCellFormat timescolor0;
	private WritableCellFormat timescolor3;
	private WritableCellFormat timescolor4;
	private WritableCellFormat timescolor5;

	String DefaultCodeForLP7Visa = "BAACOJ";

	/*
	 * When running lp7areviews, Cash cards does not need to go to lp7linkpath to
	 * modify Path Need to modify a,b, creviews, which is in lp7linkpath (line 34-43
	 * and 72-75)
	 */

	final String page8 = "https://promo.bankofamerica.com/ccsearchlp8/card-finder/";
	final String format = "https://consumer.bankofamerica.com/USCCapp/Ctl/entry?sc=";

	LP8TestimonialLinkPath lp7linkpath = new LP8TestimonialLinkPath();
	LP8DefaultCode defaultcode = new LP8DefaultCode();
	GeneralCardsForLP8b generalcards = new GeneralCardsForLP8b();

	@BeforeClass
	public static void runBeforeAllTests() throws IOException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
//		Config for mobile
//		driver.manage().window().setSize(new Dimension(400, 900));
//		Config for Tablet
		driver.manage().window().setSize(new Dimension(768, 1024));
		PageActions.setDriver(driver);

	}

	@AfterClass
	public static void runAfterAllTests() throws IOException {
		driver.quit();
	}

	@Test
	public void contentTesting() throws IOException, WriteException, BiffException, InterruptedException {

		String inputFile = "target/LP8_Premium_Tab_Result.xls";
		File file = new File(inputFile);
		WorkbookSettings wbSettings = new WorkbookSettings();

		wbSettings.setLocale(new Locale("en", "EN"));

		WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
		workbook.createSheet("Content Report", 0);

		WritableSheet excelSheet = workbook.getSheet(0);

		Workbook workbook1 = Workbook.getWorkbook((new File("CustomerSheet.xls")));
		Sheet sheet1 = workbook1.getSheet(2);

		createLabel(excelSheet);
		int column = 0;
		for (int row = 8; row <sheet1.getRows(); row++) {
			String expectedCode = sheet1.getCell(8, row).getContents();
			if (!expectedCode.trim().equalsIgnoreCase("")) {
			addcolor(excelSheet, 0, row - 7, expectedCode);

			testForHead(sheet1, 8, row, "visa", excelSheet, row, column);// cashRewards, travelRewards, bbr,visa
			generalcards.testForCashCode(sheet1, row, excelSheet, row, column);
			generalcards.testForTravelCode(sheet1, row, excelSheet, row, column);
			generalcards.testForPremiumCode(sheet1, row, excelSheet, row, column);
			generalcards.testForNonReward(sheet1, row, excelSheet, row, column);
			generalcards.testForPhoneNum(sheet1, row, excelSheet, row, column);
			generalcards.testSmallBusiness(sheet1, row, excelSheet, row, column);
			generalcards.testForCallToApplyByhref(sheet1, row, excelSheet, row, column);
			generalcards.testForCallToApplyByPhoneNo(sheet1, row, excelSheet, row, column);
//  	  		   generalcards.testForECLOCode(sheet1, row, excelSheet,row,column);
			}
		}

		driver.close();
		workbook.write();
		workbook.close();
	}

	@SuppressWarnings("unused")
	private void testForHead(Sheet sheetReference, int rowReference, int columnReference, String text,
			WritableSheet sheet, int row, int column)
			throws RowsExceededException, WriteException, InterruptedException {
		System.out.println(rowReference);
		System.out.println(columnReference);
		String Code = sheetReference.getCell(rowReference, columnReference).getContents();
		System.out.println(Code);
		if (Code.isEmpty()) {
			Code = DefaultCodeForLP7Visa;
		}
		System.out.println(Code);
		String expectedCampaignId = sheetReference.getCell(16, rowReference).getContents();
		String expectedPOCode = sheetReference.getCell(17, rowReference).getContents();
		String expectedAppLink = "https://secure.bankofamerica.com/applynow/initialize-workflow.go?requesttype=C&campaignid="
				+ expectedCampaignId + "&productoffercode=" + expectedPOCode;
		String expectedTermsAndConditions = sheetReference.getCell(16, rowReference).getContents();
		String expectedApplyNow = sheetReference.getCell(17, rowReference).getContents();
		String URL = page8 + "?code=" + Code;
		driver.get(URL);
		Thread.sleep(3000);

	}

/*	@SuppressWarnings("unused")
	private void testForHeadDefaultCode(Sheet sheetReference, int rowReference, int columnReference, String text,
			WritableSheet sheet, int row, int column)
			throws RowsExceededException, WriteException, InterruptedException {

		String URL_CashRewards = format + DefaultCodeForLP7Visa;
		String URL_TermsandConditionsCashRewards = format + DefaultCodeForLP7Visa + "&pid=dppf";
		String URL = page8 + "?code=" + DefaultCodeForLP7Visa;
		driver.get(URL);
		Thread.sleep(3000);
		if (lp7linkpath.isAvaiblableBigButtonCash(text)) {
			String ButtonBig = lp7linkpath.gettingBigButtonTextCash(text);
			System.out.println(ButtonBig);

			if (ButtonBig.equals(URL_CashRewards)) {
				addcolor(sheet, column + 1, row - 7, URL_CashRewards);
				addcolor(sheet, column + 2, row - 7, ButtonBig);
				System.out.println("OK");
			} else {
				System.out.println("Wrong");
				addcolor0(sheet, column + 1, row - 7, URL_CashRewards);
				addcolor0(sheet, column + 2, row - 7, ButtonBig);

			}

		} else {
			System.out.println("No Button");
			addcolor(sheet, column + 1, row - 7, URL_CashRewards);
			addcolor6(sheet, column + 2, row - 7, "Not Find Buttom");
		}

		if (lp7linkpath.isAvaiblableHeadTCCash(text)) {
			String TermsBig = lp7linkpath.gettingBigCTTextCash(text);
			System.out.println(TermsBig);

			if (TermsBig.equals(URL_TermsandConditionsCashRewards)) {
				System.out.println("OK");
				addcolor(sheet, column + 3, row - 7, URL_TermsandConditionsCashRewards);
				addcolor(sheet, column + 4, row - 7, TermsBig);

			}

			else {
				System.out.println("Wrong");
				addcolor0(sheet, column + 3, row - 7, URL_TermsandConditionsCashRewards);
				addcolor0(sheet, column + 4, row - 7, TermsBig);

			}
		}

		else {
			System.out.println("No Button");
			addcolor(sheet, column + 3, row - 7, URL_TermsandConditionsCashRewards);
			addcolor6(sheet, column + 4, row - 7, "Not Find Buttom");
		}

	}*/

	private void addcolor(WritableSheet sheet, int column, int row, String s)
			throws WriteException, RowsExceededException {
		Label label;
		label = new Label(column, row, s, times);
		sheet.addCell(label);

	}

	private void addcolor0(WritableSheet sheet, int column, int row, String s)
			throws WriteException, RowsExceededException {
		Label label;
		label = new Label(column, row, s, timescolor0);
		sheet.addCell(label);
	}

	private void addcolor6(WritableSheet sheet, int column, int row, String s)
			throws WriteException, RowsExceededException {
		Label label;
		label = new Label(column, row, s, timescolor3);
		sheet.addCell(label);
	}

	private void createLabel(WritableSheet sheet) throws WriteException {
		// Lets create a times font
		WritableFont times50pt = new WritableFont(WritableFont.TIMES, 12);
		// Define the cell format
		times = new WritableCellFormat(times50pt);
		sheet.getSettings().setDefaultColumnWidth(30);
		times.setAlignment(jxl.format.Alignment.LEFT);
		times.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
		times.setBackground(jxl.format.Colour.GREEN);

		// Lets automatically wrap the cells
		times.setWrap(true);

		WritableFont times10pt = new WritableFont(WritableFont.TIMES, 12);
		timescolor0 = new WritableCellFormat(times10pt);
		sheet.getSettings().setDefaultColumnWidth(30);
		timescolor0.setAlignment(jxl.format.Alignment.LEFT);
		timescolor0.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
		timescolor0.setBackground(jxl.format.Colour.RED);

		// Lets automatically wrap the cells
		timescolor0.setWrap(true);

		WritableFont times30pt = new WritableFont(WritableFont.TIMES, 12, WritableFont.BOLD, false,
				jxl.format.UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
		timescolor1 = new WritableCellFormat(times30pt);
		sheet.getSettings().setDefaultColumnWidth(30);
		// timescolor1.setColor(jxl.format.Colour.YELLOW);
		timescolor1.setAlignment(jxl.format.Alignment.CENTRE);
		timescolor1.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
		timescolor1.setBackground(jxl.format.Colour.GREEN);

		// Lets automatically wrap the cells
		// times.setWrap(true);

		WritableFont times40pt = new WritableFont(WritableFont.TIMES, 12, WritableFont.BOLD, false,
				jxl.format.UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
		timescolor3 = new WritableCellFormat(times40pt);
		sheet.getSettings().setDefaultColumnWidth(30);
		// timescolor1.setColor(jxl.format.Colour.YELLOW);
		timescolor3.setAlignment(jxl.format.Alignment.CENTRE);
		timescolor3.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
		timescolor3.setBackground(jxl.format.Colour.RED);
		timescolor3.setWrap(true);

		WritableFont times20pt = new WritableFont(WritableFont.TIMES, 12);
		// Define the cell format
		timescolor4 = new WritableCellFormat(times20pt);
		sheet.getSettings().setDefaultColumnWidth(30);
		timescolor4.setAlignment(jxl.format.Alignment.LEFT);
		timescolor4.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
		timescolor4.setBackground(jxl.format.Colour.YELLOW);
		// Lets automatically wrap the cells
		timescolor4.setWrap(true);

		WritableFont times60pt = new WritableFont(WritableFont.TIMES, 12);
		// Define the cell format
		timescolor5 = new WritableCellFormat(times60pt);
		sheet.getSettings().setDefaultColumnWidth(30);
		timescolor5.setAlignment(jxl.format.Alignment.LEFT);
		timescolor5.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
		timescolor5.setBackground(jxl.format.Colour.GRAY_25);
		// Lets automatically wrap the cells
		timescolor5.setWrap(true);

		// Create create a bold font with unterlines
		WritableFont times50ptBoldUnderline = new WritableFont(WritableFont.ARIAL, 15, WritableFont.BOLD, false,
				jxl.format.UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLUE);
		timesBoldUnderline = new WritableCellFormat(times50ptBoldUnderline);
		timesBoldUnderline.setBackground(jxl.format.Colour.LIGHT_GREEN);
		timesBoldUnderline.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
		timesBoldUnderline.setAlignment(jxl.format.Alignment.CENTRE);
		// Lets automatically wrap the cells
		// timesBoldUnderline.setWrap(true);

		CellView cv = new CellView();
		cv.setFormat(times);
		cv.setFormat(timesBoldUnderline);
		// cv.setAutosize(true);

		// Write a few headers
		addCaption(sheet, 0, 0, "Source Code");

		addCaption(sheet, 1, 0, "Expected Cash Rewards_ApplyNow");
		addCaption(sheet, 2, 0, "Actual Cash Rewards_ApplyNow");

		addCaption(sheet, 3, 0, "Expected TermsandConditionsCashRewards_Big Button");
		addCaption(sheet, 4, 0, "Actual TermsandConditionsCashRewards_Big Button");

		addCaption(sheet, 5, 0, "Expected T&C_Cash Rewards_Small Button");
		addCaption(sheet, 6, 0, "Actual T&C_Cash Rewards_Small Button");

		addCaption(sheet, 7, 0, "Expected Travel ApplyNowButton");
		addCaption(sheet, 8, 0, "Actual TTravel ApplyNowButton");

		addCaption(sheet, 9, 0, "Expected TravelT&CBigButton");
		addCaption(sheet, 10, 0, "Actual TravelT&CBigButton");

		addCaption(sheet, 11, 0, "Expected TravelT&CSmallButton");
		addCaption(sheet, 12, 0, "Actual TravelT&CSmallButton");

		addCaption(sheet, 13, 0, "Expected PremiumApplyNow");
		addCaption(sheet, 14, 0, "Actual PremiumApplyNow");

		addCaption(sheet, 15, 0, "Expected PremiumT&CBigButton");
		addCaption(sheet, 16, 0, "Actual PremiumT&CBigButton");

		addCaption(sheet, 17, 0, "Expected PremiumT&CSmallButton");
		addCaption(sheet, 18, 0, "Actual PremiumT&CSmallButton");

		addCaption(sheet, 19, 0, "Expected NonRewardApplyNow");
		addCaption(sheet, 20, 0, "Actual NonRewardApplyNow");

		addCaption(sheet, 21, 0, "Expected NonRewardT&CBigButton");
		addCaption(sheet, 22, 0, "Actual NonRewardT&CBigButton");

		addCaption(sheet, 23, 0, "Expected NonRewardT&CSmallButton");
		addCaption(sheet, 24, 0, "Actual NonRewardT&CSmallButton");

		addCaption(sheet, 25, 0, "Expected Phone Num");
		addCaption(sheet, 26, 0, "Actual Phone Num");

		addCaption(sheet, 27, 0, "Expected Small Business");
		addCaption(sheet, 28, 0, "Actual Small Business");
		
		addCaption(sheet, 29, 0, "Expected CallToApplyHrefPhoneNo");
		addCaption(sheet, 30, 0, "Actual CallToApplyHrefPhoneNo");
		
		addCaption(sheet, 31, 0, "Expected CallToApplyPhoneNo");
		addCaption(sheet, 32, 0, "Actual CallToApplyPhoneNo");

	}

	private void addCaption(WritableSheet sheet, int column, int row, String s)
			throws RowsExceededException, WriteException {
		Label label;
		label = new Label(column, row, s, timesBoldUnderline);
		sheet.addCell(label);
	}

}
