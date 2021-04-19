package com.digitas.automation.path;

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.digitas.automation.element.PageActions;

public class LP87LinkPath extends PageActions {

	private final String BIG_BUTTON_HEAD_LINK = "div.";
	// private final String
	// BIG_BUTTON_HEAD_LINK_CONTINUED=".bx-child>div>div.promo_content>ul>li.first_cont.border>div>a";
	// // LP7Review- visa
	private final String BIG_BUTTON_HEAD_LINK_CONTINUED_CASH = ".bx-child>div>div.promo_content>div>div.first_cont.border>div.cta_cont>a"; // LP7Review_cash
																																			// travel
																																			// BBR;
																																			// Lp7-Cash
	private final String BIG_BUTTON_HEAD_LINK_CONTINUED = ".bx-child>div>div.promo_content>ul>li.first_cont.border>div.cta_cont>a"; // LP7-Travel,
																																	// BBR,
																																	// Visa

	private final String BIG_TC_HEAD_LINK = ".bx-child>div>div.promo_content>ul>li.second_cont>div.cta_tc>a";// LP7-Travel,
																												// BBR
	private final String BIG_TC_HEAD_LINK_CASH = ".bx-child>div>div.promo_content>div>div.second_cont>div>a"; // LP7Review:
																												// cash,
																												// travel,
																												// BBR;
																												// LP7-Cash

	private final String BIG_TC_HEAD_LINK_VISA = ".bx-child>div>div.promo_content>ul>li.promo_plus>ul>div.cta_tc>a"; // For
																														// LP7Review
																														// -
																														// Visa;
																														// LP7-
																														// visa

	private final String BIG_TC_HEAD_CASH_II_LINK = "div#custBonus>ul>li:nth-child(3)>div>a";
	private final String BIG_TC_HEAD_II_LINK = ".bx-child>div>div.promo_content>ul>li.promo_plus>ul>li:nth-child(3)>div.cta_tc>a";// LP7-Travel

	// private final String
	// BIG_TC_HEAD_II_LINK=".bx-child>div>div.promo_content>div>div.promo_plus>ul>li:nth-child(3)>div.cta_tc>a";//LP7Review
	// -Travel

	// private final String
	// BIG_TC_HEAD_II_LINK=".bx-child>div>div.promo_content>div>div.promo_plus>ul>div.cta_tc>a";//LP7Review
	// -BBR

	private final String BIG_TC_HEAD_II_BBR_LINK = ".bx-child>div>div.promo_content>ul>li.promo_plus>ul>div.cta_tc>a";// LP7-BBR

	private final String PHONE_LINK = "strong#phoneNum";
	private final String eCLO_Link = "a.button.eclo";

	/*
	 * For LP7
	 */
	private final String CASH_BUTTON_LINK = "a[id='CR_Apply']";
	private final String CASH_TC_LINK = "a[id='CR_TC']"; // ccsearchlp7breviews
															// -bReviews_CR_TR_CC
	private final String TRAVEL_BUTTON_LINK = "a[id='Travel_Apply']";
	private final String TRAVEL_TC_LINK = "a[id='Travel_TC']";
	private final String BBR_BUTTON_LINK = "a[id='BBR_Apply']";
	private final String BBR_TC_LINK = "a[id='BBR_TC']";
	private final String VISA_BUTTON_LINK = "a[id='BACSecured_Apply']";
	private final String VISA_TC_LINK = "a[id='BACSecured_TC']";

	/*
	 * LP7
	 */
	private final String CASH_TC_APR_LINK = "tr.aprRow>td:nth-child(2)>a[id='CR_TC']";
	private final String TRAVEL_TC_APR_LINK = "tr.aprRow>td:nth-child(3)>a[id='Travel_TC']";
	private final String BBR_TC_APR_LINK = "tr.aprRow>td:nth-child(4)>a[id='BBR_TC']";
	private final String VISA_TC_APR_LINK = "tr.aprRow>td:nth-child(5)>a[id='BACSecured_TC']";

	private final String ATTRI_TEXT = "href";

	public boolean isAvaiblableBigButtonCash(String text) throws RowsExceededException, WriteException {
		System.out.println(BIG_BUTTON_HEAD_LINK + text + BIG_BUTTON_HEAD_LINK_CONTINUED_CASH);
		return isAvailable(BIG_BUTTON_HEAD_LINK + text + BIG_BUTTON_HEAD_LINK_CONTINUED_CASH);
	}

	public boolean isAvaiblableBigButton(String text) throws RowsExceededException, WriteException {
		System.out.println(BIG_BUTTON_HEAD_LINK + text + BIG_BUTTON_HEAD_LINK_CONTINUED);
		return isAvailable(BIG_BUTTON_HEAD_LINK + text + BIG_BUTTON_HEAD_LINK_CONTINUED);
	}

	public boolean isAvaiblableHeadTC(String text) throws RowsExceededException, WriteException {
		return isAvailable(BIG_BUTTON_HEAD_LINK + text + BIG_TC_HEAD_LINK);
	}

	public boolean isAvaiblableHeadTCCash(String text) throws RowsExceededException, WriteException {
		return isAvailable(BIG_BUTTON_HEAD_LINK + text + BIG_TC_HEAD_LINK_CASH);
	}

	public boolean isAvaiblableHeadTCVisa(String text) throws RowsExceededException, WriteException {
		return isAvailable(BIG_BUTTON_HEAD_LINK + text + BIG_TC_HEAD_LINK_VISA);
	}

	public boolean isAvaiblableCashButton() throws RowsExceededException, WriteException {
		return isAvailable(CASH_BUTTON_LINK);
	}

	public boolean isAvaiblableCashTC() throws RowsExceededException, WriteException {
		return isAvailable(CASH_TC_LINK);
	}

	public boolean isAvaiblableTravelButton() throws RowsExceededException, WriteException {
		return isAvailable(TRAVEL_BUTTON_LINK);
	}

	public boolean isAvaiblableTravelTC() throws RowsExceededException, WriteException {
		return isAvailable(TRAVEL_TC_LINK);
	}

	public boolean isAvaiblableBBRButton() throws RowsExceededException, WriteException {
		return isAvailable(BBR_BUTTON_LINK);
	}

	public boolean isAvaiblableBBRTC() throws RowsExceededException, WriteException {
		return isAvailable(BBR_TC_LINK);
	}

	public boolean isAvaiblableVisaButton() throws RowsExceededException, WriteException {
		return isAvailable(VISA_BUTTON_LINK);
	}

	public boolean isAvaiblableVisaTC() throws RowsExceededException, WriteException {
		return isAvailable(VISA_TC_LINK);
	}

	public String gettingBigButtonText(String text) {
		System.out.println(BIG_BUTTON_HEAD_LINK + text + BIG_BUTTON_HEAD_LINK_CONTINUED);
		return gettingElementAttri(BIG_BUTTON_HEAD_LINK + text + BIG_BUTTON_HEAD_LINK_CONTINUED, ATTRI_TEXT);
	}

	public String gettingBigButtonTextCash(String text) {
		return gettingElementAttri(BIG_BUTTON_HEAD_LINK + text + BIG_BUTTON_HEAD_LINK_CONTINUED_CASH, ATTRI_TEXT);
	}

	public String gettingBigCTText(String text) {
		return gettingElementAttri(BIG_BUTTON_HEAD_LINK + text + BIG_TC_HEAD_LINK, ATTRI_TEXT);
	}

	public String gettingBigCTTextCash(String text) {
		return gettingElementAttri(BIG_BUTTON_HEAD_LINK + text + BIG_TC_HEAD_LINK_CASH, ATTRI_TEXT);
	}

	public String gettingBigCTTextVisa(String text) {
		return gettingElementAttri(BIG_BUTTON_HEAD_LINK + text + BIG_TC_HEAD_LINK_VISA, ATTRI_TEXT);
	}

	public String gettingCashButtonText() {
		return gettingElementAttri(CASH_BUTTON_LINK, ATTRI_TEXT);
	}

	public String gettingCashCTText() {
		return gettingElementAttri(CASH_TC_LINK, ATTRI_TEXT);
	}

	public String gettingTravelButtonText() {
		return gettingElementAttri(TRAVEL_BUTTON_LINK, ATTRI_TEXT);
	}

	public String gettingTravelCTText() {
		return gettingElementAttri(TRAVEL_TC_LINK, ATTRI_TEXT);
	}

	public String gettingBBRButtonText() {
		return gettingElementAttri(BBR_BUTTON_LINK, ATTRI_TEXT);
	}

	public String gettingBBRCTText() {
		return gettingElementAttri(BBR_TC_LINK, ATTRI_TEXT);
	}

	public String gettingVisaButtonText() {
		return gettingElementAttri(VISA_BUTTON_LINK, ATTRI_TEXT);
	}

	public String gettingVisaCTText() {
		return gettingElementAttri(VISA_TC_LINK, ATTRI_TEXT);
	}

	public boolean isAvaiblablePhoneNum() throws RowsExceededException, WriteException {
		return isAvailable(PHONE_LINK);
	}

	public String gettingPhoneNum() {
		return gettingElementText(PHONE_LINK);
	}

	public boolean isAvaiblableCashTCAPR() throws RowsExceededException, WriteException {
		return isAvailable(CASH_TC_APR_LINK);
	}

	public boolean isAvaiblableeCLOBtn() throws RowsExceededException, WriteException {
		return isAvailable(eCLO_Link);
	}

	public String gettingeCLOButtonText() {
		return gettingElementAttri(eCLO_Link, ATTRI_TEXT);
	}

	public boolean isAvaiblableTravelTCAPR() throws RowsExceededException, WriteException {
		return isAvailable(TRAVEL_TC_APR_LINK);
	}

	public boolean isAvaiblableBBRTCAPR() throws RowsExceededException, WriteException {
		return isAvailable(BBR_TC_APR_LINK);
	}

	public boolean isAvaiblableVisaTCAPR() throws RowsExceededException, WriteException {
		return isAvailable(VISA_TC_APR_LINK);
	}

	public String gettingCashCTAPRText() {
		return gettingElementAttri(CASH_TC_APR_LINK, ATTRI_TEXT);
	}

	public String gettingTravelCTAPRText() {
		return gettingElementAttri(TRAVEL_TC_APR_LINK, ATTRI_TEXT);
	}

	public String gettingBBRCTAPRText() {
		return gettingElementAttri(BBR_TC_APR_LINK, ATTRI_TEXT);
	}

	public String gettingVisaCTAPRText() {
		return gettingElementAttri(VISA_TC_APR_LINK, ATTRI_TEXT);
	}

	public boolean isAvaiblableHeadTCCashII(String text) throws RowsExceededException, WriteException {
		return isAvailable(BIG_TC_HEAD_CASH_II_LINK);
	}

	public boolean isAvaiblableHeadIITC(String text) throws RowsExceededException, WriteException {
		return isAvailable(BIG_BUTTON_HEAD_LINK + text + BIG_TC_HEAD_II_LINK);
	}

	public String gettingBigCTIIText(String text) {
		return gettingElementAttri(BIG_BUTTON_HEAD_LINK + text + BIG_TC_HEAD_II_LINK, ATTRI_TEXT);
	}

	public boolean isAvaiblableHeadBBRIITC(String text) throws RowsExceededException, WriteException {
		return isAvailable(BIG_BUTTON_HEAD_LINK + text + BIG_TC_HEAD_II_BBR_LINK);
	}

	public String gettingBigCTBBRIIText(String text) {
		return gettingElementAttri(BIG_BUTTON_HEAD_LINK + text + BIG_TC_HEAD_II_BBR_LINK, ATTRI_TEXT);
	}

	public String gettingBigCTTextCashII(String text) {
		return gettingElementAttri(BIG_TC_HEAD_CASH_II_LINK, ATTRI_TEXT);
	}

}
