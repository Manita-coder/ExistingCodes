package com.digitas.automation.path;

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.digitas.automation.element.PageActions;

public class LP8TestimonialLinkPath extends PageActions{
	
	private final String BIG_BUTTON_HEAD_LINK="div.";
	private final String BIG_BUTTON_HEAD_LINK_CONTINUED=".bx-child>div>div.promo_content>ul>li.first_cont.border>div>a"; //For LP6 - visa Travel, and BBR, LP7Review- visa
//	private final String BIG_BUTTON_HEAD_LINK_CONTINUED_CASH=".bx-child>div>div.promo_content>div>div.first_cont.border>div.cta_cont>a";
	private final String BIG_BUTTON_HEAD_LINK_CONTINUED_CASH="#CR_ApplyNow_Masthead";
	//div[@class='slider__cards slider--cash']//h3[@class='slider__title'][contains(text(),'Cash Rewards')]
	
	//for LP6 cash rewards page, LP7Review_cash travel BBR; Lp7-Cash
//	private final String BIG_BUTTON_HEAD_LINK_CONTINUED=".bx-child>div>div.promo_content>ul>li.first_cont.border>div.cta_cont>a"; //LP7-Travel, BBR, Visa
	
	private final String BIG_TC_HEAD_LINK=".bx-child>div>div.promo_content>ul>li.second_cont>div.cta_tc>a";// For LP6 - BBR, LP7-Travel, BBR
	private final String BIG_TC_HEAD_LINK_CASH="#CR_TC_Masthead";  //For LP6 - Cash. LP7Review: cash, travel, BBR; LP7-Cash
	
	private final String BIG_TC_HEAD_LINK_VISA=".bx-child>div>div.promo_content>ul>li.promo_plus>ul>div.cta_tc>a";  // For LP7Review - Visa; LP7- visa

	
	private final String BIG_TC_HEAD_CASH_II_LINK="#CR_Pricing_TC";
//	private final String BIG_TC_HEAD_II_LINK=".bx-child>div>div.promo_content>ul>li.promo_plus>ul>li:nth-child(3)>div.cta_tc>a";//LP7-Travel
	
	private final String BIG_TC_HEAD_II_LINK=".bx-child>div>div.promo_content>div>div.promo_plus>ul>li:nth-child(3)>div.cta_tc>a";//LP7Review -Travel
	
	private final String BIG_TC_HEAD_BBR_II_LINK=".bx-child>div>div.promo_content>div>div.promo_plus>ul>div.cta_tc>a";//LP7Review -BBR
	
	
	/******
	 * For LP7 review
	 */
	private final String CASH_BUTTON_LINK="a[name='aReviews_CR_ANCC']";
	private final String CASH_TC_LINK="a[name='aReviews_CR_TR_CC']";
	private final String TRAVEL_BUTTON_LINK="a[name='aReviews_TR_ANCC']";
	private final String TRAVEL_TC_LINK="a[name='aReviews_TR_CC']";
	private final String BBR_BUTTON_LINK="a[name='aReviews_BBR_ANCC']";
	private final String BBR_TC_LINK="a[name='aReviews_BBR_CC']";
	private final String VISA_BUTTON_LINK="a[name='aReviews_Visa_ANCC']";
	private final String VISA_TC_LINK="a[name='aReviews_Visa_CC']";
	private final String SmallBusiness_Link="#CompareBusinessCards";
//	private final String SmallBusiness_Link="#Small_Buisness";
	private final String PHONE_LINK="#CalltoApply";
//	private final String PHONE_LINK="#Call_To_Apply";
	private final String eCLO_Link ="a.button.eclo";
	
	
	private final String B_CASH_BUTTON_LINK="#StickyNav_ApplyNow_CR";
//	private final String B_CASH_BUTTON_LINK="#CR_ApplyNow_StickyNav";
	private final String B_CASH_TC_LINK="#StickyNav_T&C_CR"; 
//	private final String B_CASH_TC_LINK="#CR_TC_StickyNav"; 
	private final String B_TRAVEL_BUTTON_LINK="#TR_ApplyNow_Masthead";
//	private final String B_TRAVEL_BUTTON_LINK="#TR_ApplyNow_StickyNav";
	private final String B_TRAVEL_TC_LINK="#TR_TC_Masthead";
//	private final String B_TRAVEL_TC_LINK="#TR_TC_StickyNav";                   
	private final String B_BBR_BUTTON_LINK="#PR_ApplyNow_Masthead";
	private final String B_Premium_BUTTON_LINK="#PR_ApplyNow_StickyNav";
	private final String B_BBR_TC_LINK="#PR_TC_Masthead";
	private final String B_Premium_TC_LINK="#PR_TC_StickyNav";
	private final String B_VISA_BUTTON_LINK="#StickyNav_ApplyNow_NR";
//	private final String B_VISA_BUTTON_LINK="#NR_ApplyNow_StickyNav";
	private final String B_VISA_TC_LINK="#StickyNav_T&C_NR";
//	private final String B_VISA_TC_LINK="#NR_TC_StickyNav";

	
	
	private final String C_CASH_BUTTON_LINK="a[name='cReviews_CR_ANCC']";
	private final String C_CASH_TC_LINK="a[name='cReviews_CR_TR_CC']"; 
	private final String C_TRAVEL_BUTTON_LINK="a[name='cReviews_TR_ANCC']";
	private final String C_TRAVEL_TC_LINK="a[name='cReviews_TR_CC']";
	private final String C_BBR_BUTTON_LINK="a[name='cReviews_BBR_ANCC']";
	private final String C_BBR_TC_LINK="a[name='cReviews_BBR_CC']";
	private final String C_VISA_BUTTON_LINK="a[name='cReviews_Visa_ANCC']";
	private final String C_VISA_TC_LINK="a[name='cReviews_Visa_CC']";
	

	
	/*
	 * For LP7
	 */
//	private final String CASH_BUTTON_LINK="a[name='CR_Apply']";
//	private final String CASH_TC_LINK="a[name='CR_TC']"; //ccsearchlp7breviews -bReviews_CR_TR_CC
//	private final String TRAVEL_BUTTON_LINK="a[name='Travel_Apply']";
//	private final String TRAVEL_TC_LINK="a[name='Travel_TC']";
//	private final String BBR_BUTTON_LINK="a[name='BBR_Apply']";
//	private final String BBR_TC_LINK="a[name='BBR_TC']";
//	private final String VISA_BUTTON_LINK="a[name='BACSecured_Apply']";
//	private final String VISA_TC_LINK="a[name='BACSecured_TC']";
//	private final String PHONE_LINK="strong#phoneNum";
	
	/*
	 * LP7
	 */
//	private final String CASH_TC_APR_LINK="tr.aprRow>td:nth-child(2)>a[name='CR_TC']";
//	private final String TRAVEL_TC_APR_LINK="tr.aprRow>td:nth-child(3)>a[name='Travel_TC']";
//	private final String BBR_TC_APR_LINK="tr.aprRow>td:nth-child(4)>a[name='BBR_TC']";
//	private final String VISA_TC_APR_LINK="tr.aprRow>td:nth-child(5)>a[name='BACSecured_TC']";
	
	
	/*
	 * LP7Reviews
	 */
	private final String CASH_TC_APR_LINK="tr.aprRow>td:nth-child(2)>a[name='aReviews_CR_SD']";
	private final String TRAVEL_TC_APR_LINK="tr.aprRow>td:nth-child(3)>a[name='aReviews_TR_SD']";
	private final String BBR_TC_APR_LINK="tr.aprRow>td:nth-child(4)>a[name='aReviews_BBR_SD']";
	private final String VISA_TC_APR_LINK="tr.aprRow>td:nth-child(5)>a[name='aReviews_Visa_SD']";
	
	
//	private final String B_CASH_TC_APR_LINK="#NoAnnualFee_T&C_CR";
	private final String B_CASH_TC_APR_LINK="#CR_Pricing_TC";
	private final String B_TRAVEL_TC_APR_LINK="#TR_Pricing_TC";
	private final String B_BBR_TC_APR_LINK="#PR_Pricing_TC";
//	private final String B_VISA_TC_APR_LINK="#NoAnnualFee_T&C_NR";
	private final String B_VISA_TC_APR_LINK="#NR_Pricing_TC";
	
	private final String C_CASH_TC_APR_LINK="tr.aprRow>td:nth-child(2)>a[name='cReviews_CR_SD']";
	private final String C_TRAVEL_TC_APR_LINK="tr.aprRow>td:nth-child(3)>a[name='cReviews_TR_SD']";
	private final String C_BBR_TC_APR_LINK="tr.aprRow>td:nth-child(4)>a[name='cReviews_BBR_SD']";
	private final String C_VISA_TC_APR_LINK="tr.aprRow>td:nth-child(5)>a[name='cReviews_Visa_SD']";
	
	
	private final String ATTRI_TEXT="href";


	public boolean isAvaiblableBigButtonCash(String text) throws RowsExceededException, WriteException{
//		System.out.println(BIG_BUTTON_HEAD_LINK+text+BIG_BUTTON_HEAD_LINK_CONTINUED_CASH);
//    	return isAvailable(BIG_BUTTON_HEAD_LINK+text+BIG_BUTTON_HEAD_LINK_CONTINUED_CASH);
		System.out.println(BIG_BUTTON_HEAD_LINK+text+BIG_BUTTON_HEAD_LINK_CONTINUED_CASH);
    	return isAvailable(BIG_BUTTON_HEAD_LINK_CONTINUED_CASH);
	}
	
	public boolean isAvaiblableBigButton(String text) throws RowsExceededException, WriteException{
		System.out.println(BIG_BUTTON_HEAD_LINK+text+BIG_BUTTON_HEAD_LINK_CONTINUED);
    	return isAvailable(BIG_BUTTON_HEAD_LINK+text+BIG_BUTTON_HEAD_LINK_CONTINUED);
	}
	
	public boolean isAvaiblableHeadTC(String text) throws RowsExceededException, WriteException{
    	return isAvailable(BIG_BUTTON_HEAD_LINK+text+BIG_TC_HEAD_LINK);
	}
	
	public boolean isAvaiblableHeadTCCash(String text) throws RowsExceededException, WriteException{
    	return isAvailable(BIG_TC_HEAD_LINK_CASH);
	}
	
	public boolean isAvaiblableHeadTCVisa(String text) throws RowsExceededException, WriteException{
    	return isAvailable(BIG_BUTTON_HEAD_LINK+text+BIG_TC_HEAD_LINK_VISA);
	}
	
	public boolean isAvaiblableCashButton() throws RowsExceededException, WriteException{
    	return isAvailable(CASH_BUTTON_LINK);
	}
	
	public boolean isAvaiblableCashTC() throws RowsExceededException, WriteException{
    	return isAvailable(CASH_TC_LINK);
	}
	
	public boolean isAvaiblableTravelButton() throws RowsExceededException, WriteException{
    	return isAvailable(TRAVEL_BUTTON_LINK);
	}
	
	public boolean isAvaiblableTravelTC() throws RowsExceededException, WriteException{
    	return isAvailable(TRAVEL_TC_LINK);
	}
	
	public boolean isAvaiblableBBRButton() throws RowsExceededException, WriteException{
    	return isAvailable(BBR_BUTTON_LINK);
	}
	
	public boolean isAvaiblableBBRTC() throws RowsExceededException, WriteException{
    	return isAvailable(BBR_TC_LINK);
	}
	
	public boolean isAvaiblableVisaButton() throws RowsExceededException, WriteException{
    	return isAvailable(VISA_BUTTON_LINK);
	}
	
	public boolean isAvaiblableVisaTC() throws RowsExceededException, WriteException{
    	return isAvailable(VISA_TC_LINK);
	}
	
	public boolean isAvaiblableCashButton_B() throws RowsExceededException, WriteException{
    	return isAvailable(B_CASH_BUTTON_LINK);
	}
	
	public boolean isAvaiblableCashTC_B() throws RowsExceededException, WriteException{
    	return isAvailable(B_CASH_TC_LINK);
	}
	
	public boolean isAvaiblableTravelButton_B() throws RowsExceededException, WriteException{
    	return isAvailable(B_TRAVEL_BUTTON_LINK);
	}
	
	public boolean isAvaiblableTravelTC_B() throws RowsExceededException, WriteException{
    	return isAvailable(B_TRAVEL_TC_LINK);
	}
	
	public boolean isAvaiblableBBRButton_B() throws RowsExceededException, WriteException{
    	return isAvailable(B_Premium_BUTTON_LINK);
	}
	
	public boolean isAvaiblableBBRTC_B() throws RowsExceededException, WriteException{
    	return isAvailable(B_Premium_TC_LINK);
	}
	
	public boolean isAvaiblableVisaButton_B() throws RowsExceededException, WriteException{
    	return isAvailable(B_VISA_BUTTON_LINK);
	}
	
	public boolean isAvaiblableVisaTC_B() throws RowsExceededException, WriteException{
    	return isAvailable(B_VISA_TC_LINK);
	}
	
	
	public boolean isAvaiblableCashButton_C() throws RowsExceededException, WriteException{
    	return isAvailable(C_CASH_BUTTON_LINK);
	}
	
	public boolean isAvaiblableCashTC_C() throws RowsExceededException, WriteException{
    	return isAvailable(C_CASH_TC_LINK);
	}
	
	public boolean isAvaiblableTravelButton_C() throws RowsExceededException, WriteException{
    	return isAvailable(C_TRAVEL_BUTTON_LINK);
	}
	
	public boolean isAvaiblableTravelTC_C() throws RowsExceededException, WriteException{
    	return isAvailable(C_TRAVEL_TC_LINK);
	}
	
	public boolean isAvaiblableBBRButton_C() throws RowsExceededException, WriteException{
    	return isAvailable(C_BBR_BUTTON_LINK);
	}
	
	public boolean isAvaiblableBBRTC_C() throws RowsExceededException, WriteException{
    	return isAvailable(C_BBR_TC_LINK);
	}
	
	public boolean isAvaiblableVisaButton_C() throws RowsExceededException, WriteException{
    	return isAvailable(C_VISA_BUTTON_LINK);
	}
	
	public boolean isAvaiblableVisaTC_C() throws RowsExceededException, WriteException{
    	return isAvailable(C_VISA_TC_LINK);
	}
	
	public String gettingBigButtonText(String text){
		return gettingElementAttri(BIG_BUTTON_HEAD_LINK+text+BIG_BUTTON_HEAD_LINK_CONTINUED,ATTRI_TEXT);
	}
	
	public String gettingBigButtonTextCash(String text){
		return gettingElementAttri(BIG_BUTTON_HEAD_LINK_CONTINUED_CASH,ATTRI_TEXT);
	}
	
	public String gettingBigCTText(String text){
		return gettingElementAttri(BIG_BUTTON_HEAD_LINK+text+BIG_TC_HEAD_LINK,ATTRI_TEXT);
	}
	
	public String gettingBigCTTextCash(String text){
		return gettingElementAttri(BIG_TC_HEAD_LINK_CASH,ATTRI_TEXT);
	}
	
	public String gettingBigCTTextVisa(String text){
		return gettingElementAttri(BIG_BUTTON_HEAD_LINK+text+BIG_TC_HEAD_LINK_VISA,ATTRI_TEXT);
	}
	
	public String gettingCashButtonText(){
		return gettingElementAttri(CASH_BUTTON_LINK,ATTRI_TEXT);
	}
	
	public String gettingCashCTText(){
		return gettingElementAttri(CASH_TC_LINK,ATTRI_TEXT);
	}
	
	public String gettingTravelButtonText(){
		return gettingElementAttri(TRAVEL_BUTTON_LINK,ATTRI_TEXT);
	}
	
	public String gettingTravelCTText(){
		return gettingElementAttri(TRAVEL_TC_LINK,ATTRI_TEXT);
	}
	
	public String gettingBBRButtonText(){
		return gettingElementAttri(BBR_BUTTON_LINK,ATTRI_TEXT);
	}
	
	public String gettingBBRCTText(){
		return gettingElementAttri(BBR_TC_LINK,ATTRI_TEXT);
	}
	
	public String gettingVisaButtonText(){
		return gettingElementAttri(VISA_BUTTON_LINK,ATTRI_TEXT);
	}
	
	public String gettingVisaCTText(){
		return gettingElementAttri(VISA_TC_LINK,ATTRI_TEXT);
	}
	
	public String gettingSmallBusinessText(){
		return gettingElementAttri(SmallBusiness_Link,ATTRI_TEXT);
	}
	
	public boolean isAvailableSmallBusiness(){
		return isAvailable(SmallBusiness_Link);
	}
	
	public boolean isAvaiblablePhoneNum() throws RowsExceededException, WriteException{
    	return isAvailable(PHONE_LINK);
	}
	
	public String gettingPhoneNum(){
		return gettingElementText(PHONE_LINK);
	}
	
	public boolean isAvaiblableCallToApplyByhref() throws RowsExceededException, WriteException{
		return isAvailable(PHONE_LINK);
	}
	
		
	public String gettingCallToApplyByhref(){
		WebElement github = driver.findElement(By.xpath("//div[@class='apply']/div/h2/span/a"));  
		String HrefValue = github.getAttribute("href");    
		System.out.println("The Href value: "+HrefValue);
   return HrefValue;
	}
	
	public String gettingCallToApplyByPhoneNo(){
		WebElement github = driver.findElement(By.xpath("//div[@class='apply']/div/h2/span/a"));   
		String CallToApplyText = github.getText();   
		System.out.println("The Call to Apply text: "+CallToApplyText);
 return CallToApplyText;

	}
	
	public boolean isAvaiblableCashTCAPR() throws RowsExceededException, WriteException{
    	return isAvailable(CASH_TC_APR_LINK);
	}
	
	public boolean isAvaiblableCashTCAPR_B() throws RowsExceededException, WriteException{
    	return isAvailable(B_CASH_TC_APR_LINK);
	}
	
	public boolean isAvaiblableCashTCAPR_C() throws RowsExceededException, WriteException{
    	return isAvailable(C_CASH_TC_APR_LINK);
	}
	
	
	
	
	public boolean isAvaiblableeCLOBtn() throws RowsExceededException, WriteException{
    	return isAvailable(eCLO_Link);
	}
	public String gettingeCLOButtonText(){
		return gettingElementAttri(eCLO_Link,ATTRI_TEXT);
	}
	
	
	public boolean isAvaiblableTravelTCAPR() throws RowsExceededException, WriteException{
    	return isAvailable(TRAVEL_TC_APR_LINK);
	}
	
	public boolean isAvaiblableTravelTCAPR_B() throws RowsExceededException, WriteException{
    	return isAvailable(B_TRAVEL_TC_APR_LINK);
	}
	
	public boolean isAvaiblableTravelTCAPR_C() throws RowsExceededException, WriteException{
    	return isAvailable(C_TRAVEL_TC_APR_LINK);
	}
	
	public boolean isAvaiblableBBRTCAPR() throws RowsExceededException, WriteException{
    	return isAvailable(BBR_TC_APR_LINK);
	}
	
	public boolean isAvaiblableBBRTCAPR_B() throws RowsExceededException, WriteException{
    	return isAvailable(B_BBR_TC_APR_LINK);
	}
	public boolean isAvaiblableBBRTCAPR_C() throws RowsExceededException, WriteException{
    	return isAvailable(C_BBR_TC_APR_LINK);
	}
	
	public boolean isAvaiblableVisaTCAPR() throws RowsExceededException, WriteException{
    	return isAvailable(VISA_TC_APR_LINK);
	}
	
	public boolean isAvaiblableVisaTCAPR_B() throws RowsExceededException, WriteException{
    	return isAvailable(B_VISA_TC_APR_LINK);
	}
	
	public boolean isAvaiblableVisaTCAPR_C() throws RowsExceededException, WriteException{
    	return isAvailable(C_VISA_TC_APR_LINK);
	}
	
	public String gettingCashCTAPRText(){
		return gettingElementAttri(CASH_TC_APR_LINK,ATTRI_TEXT);
	}
	
	public String gettingTravelCTAPRText(){
		return gettingElementAttri(TRAVEL_TC_APR_LINK,ATTRI_TEXT);
	}
	
	public String gettingBBRCTAPRText(){
		return gettingElementAttri(BBR_TC_APR_LINK,ATTRI_TEXT);
	}
	
	public String gettingVisaCTAPRText(){
		return gettingElementAttri(VISA_TC_APR_LINK,ATTRI_TEXT);
	}
	
	
	public String gettingCashCTAPRText_B(){
		return gettingElementAttri(B_CASH_TC_APR_LINK,ATTRI_TEXT);
	}
	
	public String gettingTravelCTAPRText_B(){
		return gettingElementAttri(B_TRAVEL_TC_APR_LINK,ATTRI_TEXT);
	}
	
	public String gettingBBRCTAPRText_B(){
		return gettingElementAttri(B_BBR_TC_APR_LINK,ATTRI_TEXT);
	}
	
	public String gettingVisaCTAPRText_B(){
		return gettingElementAttri(B_VISA_TC_APR_LINK,ATTRI_TEXT);
	}
	
	public String gettingCashCTAPRText_C(){
		return gettingElementAttri(C_CASH_TC_APR_LINK,ATTRI_TEXT);
	}
	
	public String gettingTravelCTAPRText_C(){
		return gettingElementAttri(C_TRAVEL_TC_APR_LINK,ATTRI_TEXT);
	}
	
	public String gettingBBRCTAPRText_C(){
		return gettingElementAttri(C_BBR_TC_APR_LINK,ATTRI_TEXT);
	}
	
	public String gettingVisaCTAPRText_C(){
		return gettingElementAttri(C_VISA_TC_APR_LINK,ATTRI_TEXT);
	}
	
	public boolean isAvaiblableHeadTCCashII(String text) throws RowsExceededException, WriteException{
    	return isAvailable(BIG_TC_HEAD_CASH_II_LINK);
	}
	
	public boolean isAvaiblableHeadIITC(String text) throws RowsExceededException, WriteException{
    	return isAvailable(BIG_BUTTON_HEAD_LINK+text+BIG_TC_HEAD_II_LINK);
	}
	
	public String gettingBigCTIIText(String text){
		return gettingElementAttri(BIG_BUTTON_HEAD_LINK+text+BIG_TC_HEAD_II_LINK,ATTRI_TEXT);
	}
	
	public String gettingBigCTTextCashII(String text){
		return gettingElementAttri(BIG_TC_HEAD_CASH_II_LINK,ATTRI_TEXT);
	}
	
	public boolean isAvaiblableHeadBBRIITC(String text) throws RowsExceededException, WriteException{
    	return isAvailable(BIG_BUTTON_HEAD_LINK+text+BIG_TC_HEAD_BBR_II_LINK);
	}
	
	public String gettingBigCTBBRIIText(String text){
		return gettingElementAttri(BIG_BUTTON_HEAD_LINK+text+BIG_TC_HEAD_BBR_II_LINK,ATTRI_TEXT);
	}
	
	
	public String gettingCashButtonText_B(){
		return gettingElementAttri(B_CASH_BUTTON_LINK,ATTRI_TEXT);
	}
	
	public String gettingCashCTText_B(){
		return gettingElementAttri(B_CASH_TC_LINK,ATTRI_TEXT);
	}
	
	public String gettingTravelButtonText_B(){
		return gettingElementAttri(B_TRAVEL_BUTTON_LINK,ATTRI_TEXT);
	}
	
	public String gettingTravelCTText_B(){
		return gettingElementAttri(B_TRAVEL_TC_LINK,ATTRI_TEXT);
	}
	
	public String gettingBBRButtonText_B(){
		return gettingElementAttri(B_Premium_BUTTON_LINK,ATTRI_TEXT);
	}
	
	public String gettingBBRCTText_B(){
		return gettingElementAttri(B_Premium_TC_LINK,ATTRI_TEXT);
	}
	
	public String gettingVisaButtonText_B(){
		return gettingElementAttri(B_VISA_BUTTON_LINK,ATTRI_TEXT);
	}
	
	public String gettingVisaCTText_B(){
		return gettingElementAttri(B_VISA_TC_LINK,ATTRI_TEXT);
	}
	
	
	public String gettingCashButtonText_C(){
		return gettingElementAttri(C_CASH_BUTTON_LINK,ATTRI_TEXT);
	}
	
	public String gettingCashCTText_C(){
		return gettingElementAttri(C_CASH_TC_LINK,ATTRI_TEXT);
	}
	
	public String gettingTravelButtonText_C(){
		return gettingElementAttri(C_TRAVEL_BUTTON_LINK,ATTRI_TEXT);
	}
	
	public String gettingTravelCTText_C(){
		return gettingElementAttri(C_TRAVEL_TC_LINK,ATTRI_TEXT);
	}
	
	public String gettingBBRButtonText_C(){
		return gettingElementAttri(C_BBR_BUTTON_LINK,ATTRI_TEXT);
	}
	
	public String gettingBBRCTText_C(){
		return gettingElementAttri(C_BBR_TC_LINK,ATTRI_TEXT);
	}
	
	public String gettingVisaButtonText_C(){
		return gettingElementAttri(C_VISA_BUTTON_LINK,ATTRI_TEXT);
	}
	
	public String gettingVisaCTText_C(){
		return gettingElementAttri(C_VISA_TC_LINK,ATTRI_TEXT);
	}
	

}
