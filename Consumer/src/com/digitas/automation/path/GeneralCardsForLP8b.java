package com.digitas.automation.path;

import jxl.CellView;
import jxl.Sheet;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class GeneralCardsForLP8b {
	private WritableCellFormat timesBoldUnderline;
    private WritableCellFormat times;
    private WritableCellFormat timescolor1;
    private WritableCellFormat timescolor0;
    private WritableCellFormat timescolor3;
    private WritableCellFormat timescolor4;
    private WritableCellFormat timescolor5;
    
	
    
	String DefaultCodeForLP7CashRewards="BAACOJ";
	String DefaultCodeForLP7Travel="BAACOJ";
	String DefaultCodeForLP7BBR= "BAACOJ";
	String DefaultCodeForLP7Visa="BAACOJ";
	String DefaultCodeForLP7Phone ="1.877.226.8944";
	String DefaultCodeForLP7eCLO="ECTPPS";
	String SmallBusiness="https://promo.bankofamerica.com/smallbusinesscards2/?mktg_track=P5D5&track=SJM0318P5D510669";
	


	final String format= "https://www.bankofamerica.com/credit-cards/terms-and-conditions/";
	
	final String eCLOFormat= "https://secure.bankofamerica.com/login/eclo/entry/findCustomizedOffer.go?subchannel=";
	
	LP8TestimonialLinkPath lp7linkpath = new LP8TestimonialLinkPath();

	
	public void testForCashCode(Sheet sheetReference, int rowReference, WritableSheet sheet,int row, int column) throws RowsExceededException, WriteException{
		createLabel(sheet);
		
		String Code = sheetReference.getCell(8,rowReference).getContents();
	//	if (Code.isEmpty()){
		//	Code = DefaultCodeForLP7CashRewards;
		//}
		System.out.println(Code);
		String expectedCampaignId = sheetReference.getCell(16,rowReference).getContents();
		String expectedPOCode = sheetReference.getCell(17,rowReference).getContents();
		String expectedAppLink = expectedPOCode;
//		String expectedAppLink = "https://secure.bankofamerica.com/applynow/initialize-workflow.go?requesttype=C&campaignid="+expectedCampaignId+"&productoffercode="+expectedPOCode;
//		String expectedAppLink = "https://secure.bankofamerica.com/applynow/initialize-workflow.go?requesttype=C&campaignid="+expectedCampaignId+"&productoffercode="+expectedPOCode;
//		String URL_BashRewards= expectedAppLink;
		

//		String URL_BashRewards= format+Code;
		String URL_TermsandConditionsCashRewards=expectedCampaignId;
//		System.out.println("Url for term and condition: "+URL_TermsandConditionsCashRewards+"expected url: "+expectedCampaignId);
//		String URL_TermsandConditionsCashRewards=format +"?campaignid="+expectedCampaignId+"&productoffercode="+expectedPOCode + "&locale=en_US";
		
//		String URL_BashRewards1= URL_TermsandConditionsCashRewards;
		   if (lp7linkpath.isAvaiblableCashButton_B()){
           	String ButtonSmall=lp7linkpath.gettingCashButtonText_B();
           	System.out.println(ButtonSmall);
           	
           		if (ButtonSmall.equals(expectedAppLink) ){
           			    addcolor(sheet,column+1,row-7,expectedAppLink);
		                addcolor(sheet,column+2,row-7,ButtonSmall);
		                System.out.println("OK");
		                }

           		
           		else{
           			System.out.println("Wrong");
				        addcolor0(sheet,column+1,row-7,expectedAppLink);
				        addcolor0(sheet,column+2,row-7,ButtonSmall);

				     
           		}
           	}
           else{
           	System.out.println("No Button");
           	addcolor(sheet,column+1,row-7,expectedAppLink);
	            addcolor6(sheet,column+2,row-7,"Not Find Buttom");
	            }
           
   /*  try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}      */
           if (lp7linkpath.isAvaiblableCashTC_B()){
           	String TermsSmall= lp7linkpath.gettingCashCTText_B();
           	System.out.println("term small to compare: "+TermsSmall+"url for term and condition: "+URL_TermsandConditionsCashRewards);
           
           		if (TermsSmall.equals(URL_TermsandConditionsCashRewards) ){
           			addcolor(sheet,column+3,row-7,URL_TermsandConditionsCashRewards);
           			addcolor(sheet,column+4,row-7,TermsSmall);
		                System.out.println("OK");
		                }

           		else{
           			System.out.println("Wrong");
			            addcolor0(sheet,column+3,row-7,expectedAppLink);
			            addcolor0(sheet,column+4,row-7,TermsSmall);
			         	
           		}
           	}
           else{
        	   System.out.println("linkpath"+lp7linkpath);
           	System.out.println("No Button");
	            addcolor(sheet,column+3,row-7,URL_TermsandConditionsCashRewards);
	            addcolor6(sheet,column+4,row-7,"Not Find Buttom");
	            }
           
           if (lp7linkpath.isAvaiblableCashTCAPR_B()){
              	String TermsSmall= lp7linkpath.gettingCashCTAPRText_B();
              	System.out.println(TermsSmall);
              		if (TermsSmall.equals(URL_TermsandConditionsCashRewards) ){
              			addcolor(sheet,column+5,row-7,URL_TermsandConditionsCashRewards);
              			addcolor(sheet,column+6,row-7,TermsSmall);
   		                System.out.println("OK");
   		                }

              		else{
              			System.out.println("Wrong");
   			            addcolor0(sheet,column+5,row-7,expectedAppLink);
   			            addcolor0(sheet,column+6,row-7,TermsSmall);
   			         	
              		}
              	}
              else{
              	System.out.println("No Button");
   	            addcolor(sheet,column+5,row-7,URL_TermsandConditionsCashRewards);
   	            addcolor6(sheet,column+6,row-7,"Not Find Buttom");
   	            }	
		
	}
	
	public void testForTravelCode(Sheet sheetReference, int rowReference, WritableSheet sheet,int row, int column) throws RowsExceededException, WriteException{
		createLabel(sheet);
		String Travel_Bode=sheetReference.getCell(10,rowReference).getContents();
		if (Travel_Bode.isEmpty()){
//			Travel_Bode = DefaultCodeForLP7Travel;
			Travel_Bode = DefaultCodeForLP7CashRewards;
		}
		System.out.println(Travel_Bode);
//		--------------Deepthy--------------------
		String expectedCampaignId = sheetReference.getCell(18,rowReference).getContents();
		String expectedPOCode = sheetReference.getCell(19,rowReference).getContents();
//		String expectedAppLink1 = "https://secure.bankofamerica.com/applynow/initialize-workflow.go?requesttype=C&campaignid="+expectedCampaignId+"&productoffercode="+expectedPOCode;
		String expectedAppLink1 = expectedPOCode;
		String URL_TravelRewards= expectedAppLink1;
//
//		String URL_TravelRewards=format+Travel_Bode;
//		String URL_TermsandConditionsTravelRewards=format +"?campaignid="+expectedCampaignId+"&productoffercode="+expectedPOCode + "&locale=en_US";
		String URL_TermsandConditionsTravelRewards=expectedCampaignId;
		
		 if (lp7linkpath.isAvaiblableTravelButton_B()){
         	String TravelRewards= lp7linkpath.gettingTravelButtonText_B();
         	System.out.println(TravelRewards);
         	System.out.println(URL_TravelRewards);
         		if (TravelRewards.equals(URL_TravelRewards) ){
         			addcolor(sheet,column+7,row-7,URL_TravelRewards);
		            addcolor(sheet,column+8,row-7,TravelRewards);

		                System.out.println("OK");
         		}

         		else{
         			System.out.println("Wrong");
			            addcolor0(sheet,column+7,row-7,URL_TravelRewards);
			            addcolor0(sheet,column+8,row-7,TravelRewards);

			          	
         		}
         	}
         
         else{
         	System.out.println("No Button");
         	addcolor(sheet,column+7,row-7,URL_TravelRewards);
         	addcolor6(sheet,column+8,row-7,"Not Find Buttom");
         	}
         
         
         if (lp7linkpath.isAvaiblableTravelTC_B()){
         	String TermsandConditionsTravelRewards= lp7linkpath.gettingTravelCTText_B();
         	System.out.println(TermsandConditionsTravelRewards);
         		if (TermsandConditionsTravelRewards.equals(URL_TermsandConditionsTravelRewards) ){
         			System.out.println("OK");
         			addcolor(sheet,column+9,row-7,URL_TermsandConditionsTravelRewards);
         			addcolor(sheet,column+10,row-7,TermsandConditionsTravelRewards);
         			}
         		else{
         			System.out.println("Wrong");
			            addcolor0(sheet,column+9,row-7,URL_TermsandConditionsTravelRewards);
			            addcolor0(sheet,column+10,row-7,TermsandConditionsTravelRewards);
			          	
         		}
         	}
         
         else{
         	System.out.println("No Button");
         	addcolor(sheet,column+9,row-7,URL_TermsandConditionsTravelRewards);
         	addcolor6(sheet,column+10,row-7,"Not Find Buttom");
         	}
         
//         
         if (lp7linkpath.isAvaiblableTravelTCAPR_B()){
          	String TermsandConditionsTravelRewards= lp7linkpath.gettingTravelCTAPRText_B();
          	System.out.println(TermsandConditionsTravelRewards);
          		if (TermsandConditionsTravelRewards.equals(URL_TermsandConditionsTravelRewards) ){
          			System.out.println("OK");
          			addcolor(sheet,column+11,row-7,URL_TermsandConditionsTravelRewards);
          			addcolor(sheet,column+12,row-7,TermsandConditionsTravelRewards);
          			}
          		else{
          			System.out.println("Wrong");
 			            addcolor0(sheet,column+11,row-7,URL_TermsandConditionsTravelRewards);
 			            addcolor0(sheet,column+12,row-7,TermsandConditionsTravelRewards);
 			          	
          		}
          	}
          
          else{
          	System.out.println("No Button");
          	addcolor(sheet,column+11,row-7,URL_TermsandConditionsTravelRewards);
          	addcolor6(sheet,column+12,row-7,"Not Find Buttom");
          	}	
//         
		
	}
	
	public void testForPremiumCode(Sheet sheetReference, int rowReference, WritableSheet sheet,int row, int column) throws RowsExceededException, WriteException{
		createLabel(sheet);
		String BBR_Bode=sheetReference.getCell(12,rowReference).getContents();
		if (BBR_Bode.isEmpty()){
			BBR_Bode = DefaultCodeForLP7BBR;
		}
		System.out.println(BBR_Bode);
//		--------------Deepthy--------------------
		String expectedCampaignId = sheetReference.getCell(20,rowReference).getContents();
		String expectedPOCode = sheetReference.getCell(21,rowReference).getContents();
//		String expectedAppLink2 = "https://secure.bankofamerica.com/applynow/initialize-workflow.go?requesttype=C&campaignid="+expectedCampaignId+"&productoffercode="+expectedPOCode;
		
		String URL_Privileges= expectedPOCode;

//		String URL_Privileges=format+BBR_Bode;
//		String URL_TermsandConditionsPrivileges=format +"?campaignid="+expectedCampaignId+"&productoffercode="+expectedPOCode + "&locale=en_US";
		String URL_TermsandConditionsPrivileges=expectedCampaignId;
		if (lp7linkpath.isAvaiblableBBRButton_B())
		{
        	String Privileges= lp7linkpath.gettingBBRButtonText_B();
        	System.out.println(Privileges);
        
        		if (Privileges.equals(URL_Privileges) ){
        			addcolor(sheet,column+13,row-7,URL_Privileges);
        			addcolor(sheet,column+14,row-7,Privileges);
	                System.out.println("OK");
	                }

        		else{
        			System.out.println("Wrong");
		            addcolor0(sheet,column+13,row-7,URL_Privileges);
		            addcolor0(sheet,column+14,row-7,Privileges);
		           	
        		}
        }
        
        else
        {
        	System.out.println("No Button");
        	addcolor(sheet,column+13,row-7,URL_Privileges);
        	addcolor6(sheet,column+14,row-7,"Not Find Buttom");
        }
        
        
        if (lp7linkpath.isAvaiblableBBRTC_B())
        {
        	String TermsandConditionsPrivileges= lp7linkpath.gettingBBRCTText_B();
        	System.out.println(TermsandConditionsPrivileges);
        		if (TermsandConditionsPrivileges.equals(URL_TermsandConditionsPrivileges) )
        		{
        			addcolor(sheet,column+15,row-7,URL_TermsandConditionsPrivileges);
        			addcolor(sheet,column+16,row-7,TermsandConditionsPrivileges);
        			System.out.println("OK");
        		}
        
        		
        		else
        		{
        			System.out.println("Wrong");
		            addcolor0(sheet,column+15,row-7,URL_TermsandConditionsPrivileges);
		            addcolor0(sheet,column+16,row-7,TermsandConditionsPrivileges);

		           
        		}
        }
        
        else
        {
        	System.out.println("No Button");
        	addcolor(sheet,column+15,row-7,URL_TermsandConditionsPrivileges);
            addcolor6(sheet,column+16,row-7,"Not Find Buttom");
        }
        
        
        if (lp7linkpath.isAvaiblableBBRTCAPR_B())
        {
        	String TermsandConditionsPrivileges= lp7linkpath.gettingBBRCTAPRText_B();
        	System.out.println(TermsandConditionsPrivileges);
        		if (TermsandConditionsPrivileges.equals(URL_TermsandConditionsPrivileges) )
        		{
        			addcolor(sheet,column+17,row-7,URL_TermsandConditionsPrivileges);
        			addcolor(sheet,column+18,row-7,TermsandConditionsPrivileges);
        			System.out.println("OK");
        		}
        
        		
        		else
        		{
        			System.out.println("Wrong");
		            addcolor0(sheet,column+17,row-7,URL_TermsandConditionsPrivileges);
		            addcolor0(sheet,column+18,row-7,TermsandConditionsPrivileges);

		           
        		}
        }
        
        else
        {
        	System.out.println("No Button");
        	addcolor(sheet,column+17,row-7,URL_TermsandConditionsPrivileges);
            addcolor6(sheet,column+18,row-7,"Not Find Buttom");
        }
	}
	
	public void testForNonReward(Sheet sheetReference, int rowReference, WritableSheet sheet,int row, int column) throws RowsExceededException, WriteException{
		createLabel(sheet);
		String Visa_Bode=sheetReference.getCell(14,rowReference).getContents(); 
		if (Visa_Bode.isEmpty()){
			Visa_Bode = DefaultCodeForLP7Visa;
		}
		System.out.println(Visa_Bode);
//		--------------Deepthy--------------------
		String expectedCampaignId = sheetReference.getCell(22,rowReference).getContents();
		String expectedPOCode = sheetReference.getCell(23,rowReference).getContents();
		String expectedAppLink3 = expectedPOCode;
//		String expectedAppLink = "https://secure.bankofamerica.com/applynow/initialize-workflow.go?requesttype=C&campaignid=\"+expectedCampaignId+\"&productoffercode=\"+expectedPOCode;
		String URL_Visa= expectedAppLink3;

//		String URL_Visa=format+Visa_Bode;
        String URL_TermsandConditionsVisa=expectedCampaignId;
//        String URL_TermsandConditionsVisa=format +"?campaignid="+expectedCampaignId+"&productoffercode="+expectedPOCode + "&locale=en_US";
        
        if (lp7linkpath.isAvaiblableVisaButton_B()){
        	String Visa= lp7linkpath.gettingVisaButtonText_B();
            System.out.println(Visa);
            System.out.println(URL_Visa);	
            	if (Visa.equals(URL_Visa) ){
            		addcolor(sheet,column+19,row-7,URL_Visa);
            		addcolor(sheet,column+20,row-7,Visa);
            		System.out.println("OK");
            		}
            
            	else{
            		System.out.println("Wrong");
            		addcolor0(sheet,column+19,row-7,URL_Visa);
            		addcolor0(sheet,column+20,row-7,Visa);
            	}   
            }
        
        else{
        	System.out.println("No Button");
            addcolor(sheet,column+19,row-7,URL_Visa);
            addcolor6(sheet,column+20,row-7,"Not find Button");
            }
        
        
        if (lp7linkpath.isAvaiblableVisaTC_B()){
        	String TermsandConditionsVisa=lp7linkpath.gettingVisaCTText_B();
        	System.out.println(TermsandConditionsVisa);
        	System.out.println(URL_TermsandConditionsVisa);
       
        		if (TermsandConditionsVisa.equals(URL_TermsandConditionsVisa) ){
        			System.out.println("OK");
	                addcolor(sheet,column+21,row-7,URL_TermsandConditionsVisa);
	                addcolor(sheet,column+22,row-7,TermsandConditionsVisa);

	                }

        		else{
        			System.out.println("Wrong");
		            addcolor0(sheet,column+21,row-7,URL_TermsandConditionsVisa);
		            addcolor0(sheet,column+22,row-7,TermsandConditionsVisa);
        		}   	
        		
        	}
        
        else{
        	System.out.println("No Button");
        	addcolor(sheet,column+21,row-7,URL_TermsandConditionsVisa);
        	addcolor6(sheet,column+22,row-7,"Not Find Button");
        	}	
        
        if (lp7linkpath.isAvaiblableVisaTCAPR_B()){
        	String TermsandConditionsVisa=lp7linkpath.gettingVisaCTAPRText_B();
        	System.out.println(TermsandConditionsVisa);
        	System.out.println(URL_TermsandConditionsVisa);
       
        		if (TermsandConditionsVisa.equals(URL_TermsandConditionsVisa) ){
        			System.out.println("OK");
	                addcolor(sheet,column+23,row-7,URL_TermsandConditionsVisa);
	                addcolor(sheet,column+24,row-7,TermsandConditionsVisa);

	                }

        		else{
        			System.out.println("Wrong");
		            addcolor0(sheet,column+23,row-7,URL_TermsandConditionsVisa);
		            addcolor0(sheet,column+24,row-7,TermsandConditionsVisa);
        		}   	
        		
        	}
        
        else{
        	System.out.println("No Button");
        	addcolor(sheet,column+23,row-7,URL_TermsandConditionsVisa);
        	addcolor6(sheet,column+24,row-7,"Not Find Button");
        	}	
		
	}
	
	public void testForPhoneNum(Sheet sheetReference, int rowReference, WritableSheet sheet,int row, int column) throws RowsExceededException, WriteException{
		createLabel(sheet);
		String URL_PhoneNumber=sheetReference.getCell(6,rowReference).getContents();
		if (URL_PhoneNumber.isEmpty()){
			URL_PhoneNumber = DefaultCodeForLP7Phone;
		}
		System.out.println(URL_PhoneNumber);
		if (lp7linkpath.isAvaiblablePhoneNum()){
        	String PhoneNumber= lp7linkpath.gettingPhoneNum();
        	System.out.println(PhoneNumber);
        		if (PhoneNumber.equals(URL_PhoneNumber) ){
        			System.out.println("OK");
	                addcolor(sheet,column+25,row-7,URL_PhoneNumber);
	                addcolor(sheet,column+26,row-7,PhoneNumber);
	                }
        	
        	else{
        	
        			System.out.println("Wrong");
		            addcolor0(sheet,column+25,row-7,URL_PhoneNumber);
		            addcolor0(sheet,column+26,row-7,PhoneNumber);
		            
        		}
        	}
        
        else{
        	System.out.println("No Button");
        	addcolor(sheet,column+25,row-7,URL_PhoneNumber);
        	addcolor6(sheet,column+26,row-7,"Not Found Button");
        	}	
       
        }
	
	public void testSmallBusiness(Sheet sheetReference, int rowReference, WritableSheet sheet,int row, int column) throws RowsExceededException, WriteException{
		createLabel(sheet);
		String URL_SmallBusiness=sheetReference.getCell(24,rowReference).getContents();
		if (URL_SmallBusiness.isEmpty()){
			URL_SmallBusiness = SmallBusiness;
		}
		System.out.println(URL_SmallBusiness);
		if (lp7linkpath.isAvailableSmallBusiness()){
        	String smallBusiness= lp7linkpath.gettingSmallBusinessText();
        	System.out.println(smallBusiness);
        		if (smallBusiness.equals(URL_SmallBusiness) ){
        			System.out.println("OK");
	                addcolor(sheet,column+27,row-7,URL_SmallBusiness);
	                addcolor(sheet,column+28,row-7,smallBusiness);
	                }
        	
        	else{
        	
        			System.out.println("Wrong");
		            addcolor0(sheet,column+27,row-7,URL_SmallBusiness);
		            addcolor0(sheet,column+28,row-7,smallBusiness);
		            
        		}
        	}
        
        else{
        	System.out.println("No Button");
        	addcolor(sheet,column+27,row-7,URL_SmallBusiness);
        	addcolor6(sheet,column+28,row-7,"Not Found Button");
        	}	
       
        }
	
	public void testForCallToApplyByhref(Sheet sheetReference, int rowReference, WritableSheet sheet,int row, int column) throws RowsExceededException, WriteException
	{
		createLabel(sheet);
		String URL_PhoneNumber=sheetReference.getCell(6,rowReference).getContents();
		if (URL_PhoneNumber.isEmpty()){
			URL_PhoneNumber = DefaultCodeForLP7Phone;
		}
		System.out.println(URL_PhoneNumber);
		if (lp7linkpath.isAvaiblableCallToApplyByhref())
		{
			String callToApplyHref1 = lp7linkpath.gettingCallToApplyByhref().substring(5);
		String callToApplyHref =	callToApplyHref1.substring(0,3) + "." + callToApplyHref1.substring(3,6) + "." + callToApplyHref1.substring(6);
        	System.out.println(callToApplyHref);
        		if (callToApplyHref.equals(URL_PhoneNumber) )
        		{
        			System.out.println("OK");
	                addcolor(sheet,column+29,row-7,URL_PhoneNumber);
	                addcolor(sheet,column+30,row-7,callToApplyHref);
	            }
        	
        	else{
        	
        			System.out.println("Wrong");
		            addcolor0(sheet,column+29,row-7,URL_PhoneNumber);
		            addcolor0(sheet,column+30,row-7,callToApplyHref);
		            
        		}
        }
        
        else
        {
        	System.out.println("No Button");
        	addcolor(sheet,column+29,row-7,URL_PhoneNumber);
        	addcolor6(sheet,column+30,row-7,"Not Found Button");
        }	
       
      }
	
	public void testForCallToApplyByPhoneNo(Sheet sheetReference, int rowReference, WritableSheet sheet,int row, int column) throws RowsExceededException, WriteException{
		createLabel(sheet);
		String URL_PhoneNumber=sheetReference.getCell(6,rowReference).getContents();
		if (URL_PhoneNumber.isEmpty()){
			URL_PhoneNumber = DefaultCodeForLP7Phone;
		}
		System.out.println(URL_PhoneNumber);
		if (lp7linkpath.isAvaiblablePhoneNum()){
        	String calltoApplyByPhoneNumber= lp7linkpath.gettingCallToApplyByPhoneNo();
        	System.out.println(calltoApplyByPhoneNumber);
        		if (calltoApplyByPhoneNumber.equals(URL_PhoneNumber) ){
        			System.out.println("OK");
	                addcolor(sheet,column+31,row-7,URL_PhoneNumber);
	                addcolor(sheet,column+32,row-7,calltoApplyByPhoneNumber);
	                }
        	
        	else{
        	
        			System.out.println("Wrong");
		            addcolor0(sheet,column+31,row-7,URL_PhoneNumber);
		            addcolor0(sheet,column+32,row-7,calltoApplyByPhoneNumber);
		            
        		}
        	}
        
        else{
        	System.out.println("No Button");
        	addcolor(sheet,column+31,row-7,URL_PhoneNumber);
        	addcolor6(sheet,column+32,row-7,"Not Found Button");
        	}	
       
        }
	
	
//	public void testForECLOCode(Sheet sheetReference, int rowReference, WritableSheet sheet,int row, int column) throws RowsExceededException, WriteException{
//		createLabel(sheet);
//		
//		String Code = sheetReference.getCell(15,rowReference).getContents();
//		if (Code.isEmpty()){
//			Code = DefaultCodeForLP7eCLO;
//		}
//		System.out.println(Code);
//		String URL_eCLO= eCLOFormat+Code;
//		
//		   if (lp7linkpath.isAvaiblableeCLOBtn()){
//           	String ButtonSmall=lp7linkpath.gettingeCLOButtonText();
//           	System.out.println(ButtonSmall);
//           	
//           		if (ButtonSmall.equals(URL_eCLO) ){
//           			    addcolor(sheet,column+33,row-7,URL_eCLO);
//		                addcolor(sheet,column+34,row-7,ButtonSmall);
//		                System.out.println("OK");
//		                }
//
//           		
//           		else{
//           			System.out.println("Wrong");
//				        addcolor0(sheet,column+33,row-7,URL_eCLO);
//				        addcolor0(sheet,column+34,row-7,ButtonSmall);
//
//				     
//           		}
//           	}
//           else{
//           	System.out.println("No Button");
//           	addcolor(sheet,column+33,row-7,URL_eCLO);
//	        addcolor6(sheet,column+34,row-7,"Not Find Buttom");
//	       }
//	}
//	
//			
		


	private void addcolor(WritableSheet sheet, int column, int row,
			String s) throws WriteException, RowsExceededException {
		Label label;
		label = new Label(column, row, s,times);
		sheet.addCell(label);
		
		}


	private void addcolor5(WritableSheet sheet, int column, int row,
			String s) throws WriteException, RowsExceededException {
		Label label;
		label = new Label(column, row, s,timescolor1);
		sheet.addCell(label);
		}


	private void addcolor0(WritableSheet sheet, int column, int row,
			String s) throws WriteException, RowsExceededException {
		Label label;
		label = new Label(column, row, s,timescolor0);
		sheet.addCell(label);
		}


	private void addcolor6(WritableSheet sheet, int column, int row,
		String s) throws WriteException, RowsExceededException {
		Label label;
		label = new Label(column, row, s,timescolor3);
		sheet.addCell(label);
		}
	
	private void addcolor1(WritableSheet sheet, int column, int row,
			String s) throws WriteException, RowsExceededException {
			Label label;
			label = new Label(column, row, s,timescolor5);
			sheet.addCell(label);
			}
		
		
	private void createLabel(WritableSheet sheet)
				throws WriteException {
			// Lets create a times font
			WritableFont times50pt = new WritableFont(WritableFont.TIMES, 
					12);
			// Define the cell format
			times = new WritableCellFormat(times50pt);
			sheet.getSettings().setDefaultColumnWidth(30); 
			times.setAlignment (jxl.format.Alignment.LEFT); 
			times.setBorder (jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);  
			times.setBackground (jxl.format.Colour.GREEN);

			// Lets automatically wrap the cells
			times.setWrap(true);


			WritableFont times10pt = new WritableFont(WritableFont.TIMES, 12);
			timescolor0 = new WritableCellFormat(times10pt);
			sheet.getSettings().setDefaultColumnWidth(30); 
			timescolor0.setAlignment (jxl.format.Alignment.LEFT); 
			timescolor0.setBorder (jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN); 
			timescolor0.setBackground (jxl.format.Colour.RED);
		



			// Lets automatically wrap the cells
			timescolor0.setWrap(true);

			WritableFont times30pt = new WritableFont(
					WritableFont.TIMES, 12, WritableFont.BOLD, false, jxl.format.UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
			timescolor1 = new WritableCellFormat(times30pt);
			sheet.getSettings().setDefaultColumnWidth(30); 
			//timescolor1.setColor(jxl.format.Colour.YELLOW);
			timescolor1.setAlignment (jxl.format.Alignment.CENTRE); 
			timescolor1.setBorder (jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN); 
			timescolor1.setBackground (jxl.format.Colour.GREEN);

			// Lets automatically wrap the cells
			//times.setWrap(true);

			WritableFont times40pt = new WritableFont(
					WritableFont.TIMES, 12, WritableFont.BOLD, false, jxl.format.UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
			timescolor3 = new WritableCellFormat(times40pt);
			sheet.getSettings().setDefaultColumnWidth(30); 
			//timescolor1.setColor(jxl.format.Colour.YELLOW);
			timescolor3.setAlignment (jxl.format.Alignment.CENTRE); 
			timescolor3.setBorder (jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN); 
			timescolor3.setBackground (jxl.format.Colour.RED);
			timescolor3.setWrap(true);

			WritableFont times20pt = new WritableFont(WritableFont.TIMES, 12);
			// Define the cell format
			timescolor4 = new WritableCellFormat(times20pt);
			sheet.getSettings().setDefaultColumnWidth(30); 
			timescolor4.setAlignment (jxl.format.Alignment.LEFT); 
			timescolor4.setBorder (jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);  
			timescolor4.setBackground (jxl.format.Colour.YELLOW);
			// Lets automatically wrap the cells
			timescolor4.setWrap(true);


			WritableFont times60pt = new WritableFont(WritableFont.TIMES, 12);
			// Define the cell format
			timescolor5 = new WritableCellFormat(times60pt);
			sheet.getSettings().setDefaultColumnWidth(30); 
			timescolor5.setAlignment (jxl.format.Alignment.LEFT); 
			timescolor5.setBorder (jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);  
			timescolor5.setBackground (jxl.format.Colour.GRAY_25);
			// Lets automatically wrap the cells
			timescolor5.setWrap(true);
			

			// Create create a bold font with unterlines
			WritableFont times50ptBoldUnderline = new WritableFont(
					WritableFont.ARIAL, 15, WritableFont.BOLD, false, jxl.format.UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLUE);
			timesBoldUnderline = new WritableCellFormat(times50ptBoldUnderline);
			timesBoldUnderline.setBackground (jxl.format.Colour.LIGHT_GREEN);
			timesBoldUnderline.setBorder (jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);  
			timesBoldUnderline.setAlignment (jxl.format.Alignment.CENTRE);  
			// Lets automatically wrap the cells
			//timesBoldUnderline.setWrap(true);

			CellView cv = new CellView();
			cv.setFormat(times);
			cv.setFormat(timesBoldUnderline);
			//cv.setAutosize(true);
	}

}
