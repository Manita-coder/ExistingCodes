package com.digitas.automation.path;

import jxl.CellView;
import jxl.Sheet;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class LP8DefaultCode {
	
	private WritableCellFormat timesBoldUnderline;
    private WritableCellFormat times;
    private WritableCellFormat timescolor1;
    private WritableCellFormat timescolor0;
    private WritableCellFormat timescolor3;
    private WritableCellFormat timescolor4;
    private WritableCellFormat timescolor5;
	
	
	String DefaultCodeForLP7CashRewards="BAACOJ";
	String DefaultCodeForLP7Travel="VACJC2";
	String DefaultCodeForLP7BBR= "VACKSN";
	String DefaultCodeForLP7Visa="VACJE4";
	String DefaultCodeForLP7Phone ="877.226.8944";
	
	final String format= "https://qa-promo-boa.groupeconnect.io/ccsearchlp8/card-finder/?code=";
	final String Page7= "https://qa-promo-boa.groupeconnect.io/ccsearchlp8/card-finder/";;
	
	LP87LinkPath lp7linkpath = new LP87LinkPath();
	
	public void testForCashCode(Sheet sheetReference, int rowReference, WritableSheet sheet,int row, int column) throws RowsExceededException, WriteException{
		createLabel(sheet);
		String URL_CashRewards= format+DefaultCodeForLP7CashRewards;
		String URL_TermsandConditionsCashRewards=format+DefaultCodeForLP7CashRewards+"&pid=dppf";
		
		   if (lp7linkpath.isAvaiblableCashButton()){
           	String ButtonSmall=lp7linkpath.gettingCashButtonText();
           	System.out.println(ButtonSmall);
           	
           		if (ButtonSmall.equals(URL_CashRewards) ){
           			addcolor(sheet,column+5,row-7,URL_CashRewards);
		            addcolor(sheet,column+6,row-7,ButtonSmall);

		                System.out.println("OK");
		                }

           		
           		else{
           			System.out.println("Wrong");
				        addcolor0(sheet,column+5,row-7,URL_CashRewards);
				        addcolor0(sheet,column+6,row-7,ButtonSmall);			     
           		}
           	}
           else{
           	System.out.println("No Button");
           	addcolor(sheet,column+5,row-7,URL_CashRewards);
	         addcolor6(sheet,column+6,row-7,"Not Find Buttom");
	            }
           
           
           if (lp7linkpath.isAvaiblableCashTC()){
           	String TermsSmall= lp7linkpath.gettingCashCTText();
           	System.out.println(TermsSmall);
           		if (TermsSmall.equals(URL_TermsandConditionsCashRewards) ){
           			addcolor(sheet,column+7,row-7,URL_TermsandConditionsCashRewards);
           			addcolor(sheet,column+8,row-7,TermsSmall);
		                System.out.println("OK");
		                }

           		else{
           			System.out.println("Wrong");
			            addcolor0(sheet,column+7,row-7,URL_CashRewards);
			            addcolor0(sheet,column+8,row-7,TermsSmall);		         	
           		}
           	}
           else{
           	System.out.println("No Button");
	            addcolor(sheet,column+7,row-7,URL_TermsandConditionsCashRewards);
	            addcolor6(sheet,column+8,row-7,"Not Find Buttom");
	            }	
		
	}
	
	public void testForTravelCode(Sheet sheetReference, int rowReference, WritableSheet sheet,int row, int column) throws RowsExceededException, WriteException{
		createLabel(sheet);

		String URL_TravelRewards=format+ DefaultCodeForLP7Travel;
		String URL_TermsandConditionsTravelRewards=format+ DefaultCodeForLP7Travel+"&pid=dppf";
		
		 if (lp7linkpath.isAvaiblableTravelButton()){
         	String TravelRewards= lp7linkpath.gettingTravelButtonText();
         	System.out.println(TravelRewards);
         	System.out.println(URL_TravelRewards);
         		if (TravelRewards.equals(URL_TravelRewards) ){
         			addcolor(sheet,column+9,row-7,URL_TravelRewards);
		                addcolor(sheet,column+10,row-7,TravelRewards);	
		                System.out.println("OK");
         		}

         		else{
         			System.out.println("Wrong");
			            addcolor0(sheet,column+9,row-7,URL_TravelRewards);
			            addcolor0(sheet,column+10,row-7,TravelRewards);				          	
         		}
         	}
         
         else{
         	System.out.println("No Button");
         	addcolor(sheet,column+9,row-7,URL_TravelRewards);
         	addcolor6(sheet,column+10,row-7,"Not Find Buttom");
         	}
         
         
         if (lp7linkpath.isAvaiblableTravelTC()){
         	String TermsandConditionsTravelRewards= lp7linkpath.gettingTravelCTText();
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
         
		
	}
	
	public void testForBBRCode(Sheet sheetReference, int rowReference, WritableSheet sheet,int row, int column) throws RowsExceededException, WriteException{
		createLabel(sheet);
		String URL_Privileges=format+DefaultCodeForLP7BBR;
		String URL_TermsandConditionsPrivileges=format+DefaultCodeForLP7BBR+"&pid=dppf";
		if (lp7linkpath.isAvaiblableBBRButton()){
        	String Privileges= lp7linkpath.gettingBBRButtonText();
        	System.out.println(Privileges);
        
        		if (Privileges.equals(URL_Privileges) ){
        			addcolor(sheet,column+13,row-7,URL_Privileges);
        			addcolor(sheet,column+14,row-7,Privileges);
	                }

        		else{
        			System.out.println("Wrong");
		            addcolor0(sheet,column+13,row-7,URL_Privileges);
		            addcolor0(sheet,column+14,row-7,Privileges);
		           	
        		}
        	}
        
        else{
        	System.out.println("No Button");
        	addcolor(sheet,column+13,row-7,URL_Privileges);
        	addcolor6(sheet,column+14,row-7,"Not Find Buttom");
        	}
        
        
        if (lp7linkpath.isAvaiblableBBRTC()){
        	String TermsandConditionsPrivileges= lp7linkpath.gettingBBRCTText();
        	System.out.println(TermsandConditionsPrivileges);
        		if (TermsandConditionsPrivileges.equals(URL_TermsandConditionsPrivileges) ){
        			addcolor(sheet,column+15,row-7,URL_TermsandConditionsPrivileges);
        			addcolor(sheet,column+16,row-7,TermsandConditionsPrivileges);
        	
        			System.out.println("OK");
        			}
        
        		
        		else{
        			System.out.println("Wrong");
		            addcolor0(sheet,column+15,row-7,URL_TermsandConditionsPrivileges);
		            addcolor0(sheet,column+16,row-7,TermsandConditionsPrivileges);		           
        		}
        	}
        
        else{
        	System.out.println("No Button");
        	addcolor(sheet,column+15,row-7,URL_TermsandConditionsPrivileges);
            addcolor6(sheet,column+16,row-7,"Not Find Buttom");
            }
	}
	
	public void testForPremiumCode(Sheet sheetReference, int rowReference, WritableSheet sheet,int row, int column) throws RowsExceededException, WriteException{
		createLabel(sheet);
		String URL_Visa=format+DefaultCodeForLP7Visa;
        String URL_TermsandConditionsVisa=format+DefaultCodeForLP7Visa+"&pid=dppf";
        
        if (lp7linkpath.isAvaiblableVisaButton()){
        	String Visa= lp7linkpath.gettingVisaButtonText();
            System.out.println(Visa);
            System.out.println(URL_Visa);	
            	if (Visa.equals(URL_Visa) ){
            		addcolor(sheet,column+17,row-7,URL_Visa);
            		addcolor(sheet,column+18,row-7,Visa);
         
            		System.out.println("OK");
            		}
            
            	else{
            		System.out.println("Wrong");
            		addcolor0(sheet,column+17,row-7,URL_Visa);
            		addcolor0(sheet,column+18,row-7,Visa);
	
            	}   
            }
        
        else{
        	System.out.println("No Button");
            addcolor(sheet,column+17,row-7,URL_Visa);
            addcolor6(sheet,column+18,row-7,"Not find Button");
            }
        
        
        if (lp7linkpath.isAvaiblableVisaTC()){
        	String TermsandConditionsVisa=lp7linkpath.gettingVisaCTText();
        	System.out.println(TermsandConditionsVisa);
        	System.out.println(URL_TermsandConditionsVisa);
       
        		if (TermsandConditionsVisa.equals(URL_TermsandConditionsVisa) ){
        			System.out.println("OK");
	                addcolor(sheet,column+19,row-7,URL_TermsandConditionsVisa);
	                addcolor(sheet,column+20,row-7,TermsandConditionsVisa);
	            
	                }

        		else{
        			System.out.println("Wrong");
		            addcolor0(sheet,column+19,row-7,URL_TermsandConditionsVisa);
		            addcolor0(sheet,column+20,row-7,TermsandConditionsVisa);	       
        		}   	
        		
        	}
        
        else{
        	System.out.println("No Button");
        	addcolor(sheet,column+19,row-7,URL_TermsandConditionsVisa);
        	addcolor6(sheet,column+20,row-7,"Not Find Button");
        	}	
		
	}
	
	public void testForPhoneNum(Sheet sheetReference, int rowReference, WritableSheet sheet,int row, int column) throws RowsExceededException, WriteException{
		createLabel(sheet);
		if (lp7linkpath.isAvaiblablePhoneNum()){
        	String PhoneNumber= lp7linkpath.gettingPhoneNum();
        	System.out.println(PhoneNumber);
        		if (PhoneNumber.equals(DefaultCodeForLP7Phone) ){
        			System.out.println("OK");
	                addcolor(sheet,column+21,row-7,DefaultCodeForLP7Phone);
	                addcolor(sheet,column+22,row-7,PhoneNumber);

	                }
        	
        	else{
        	
        			System.out.println("Wrong");
		            addcolor0(sheet,column+21,row-7,DefaultCodeForLP7Phone);
		            addcolor0(sheet,column+22,row-7,PhoneNumber);
		
		            
        		}
        	}
        
        else{
        	System.out.println("No Button");
        	addcolor(sheet,column+21,row-7,DefaultCodeForLP7Phone);
        	addcolor6(sheet,column+22,row-7,"Not Frownd Button");
        	}	
       
        }
	
	
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
