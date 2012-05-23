package com.git.uwee.rsmarkettool;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SuperHeatRefresh implements Runnable{
	static int coalCOST;
	static int natureCOST;
	
	//Item ID List
	//SuperHeatItem:
	static int coalID = 453;
	static int natureID = 561;
	static int mithOREid = 447;
	static int mithBARid = 2359;
	static int mithCOALneeded = 4;
	static int adamOREid = 449;
	static int adamCOALneeded = 6;
	static int adamBARid = 2361;
	static int runeOREid = 451;
	static int runeCOALneeded = 8;
	static int runeBARid = 2363;
	
	public Object[][] superheatItemData = new Object[2][5];
	
    public void run() {
    	//Download Item Data
		Fetch fetch = new Fetch();
		
        try {
            //Globals:
        	natureCOST = fetch.getItemData(natureID);
    		coalCOST = fetch.getItemData(coalID);
    		
    		//Format: Ore Price, Coal Needed to Super Heat, Bar Cost, Nature Cost, Coal Cost.
            SuperHeatItem superheatmith = new SuperHeatItem(
            		fetch.getItemData(mithOREid), 
            		mithCOALneeded, 
            		fetch.getItemData(mithBARid), 
            		natureCOST, 
            		coalCOST);
            
            SuperHeatItem superheatadam = new SuperHeatItem(
            		fetch.getItemData(adamOREid), 
            		adamCOALneeded, 
            		fetch.getItemData(adamBARid), 
            		natureCOST, 
            		coalCOST);

            SuperHeatItem superheatrune = new SuperHeatItem(
            		fetch.getItemData(runeOREid), 
            		runeCOALneeded, 
            		fetch.getItemData(runeBARid), 
            		natureCOST, 
            		coalCOST);
            
	            
            //Set Table Data
            //mith
            for (int i = 1; i < superheatmith.superheatArray.length; i++) {
            	 GUI.superheatTableData[0][i] = superheatmith.superheatArray[i];
            }
            
          //adam
            for (int i = 1; i < superheatadam.superheatArray.length; i++) {
           	 GUI.superheatTableData[1][i] = superheatadam.superheatArray[i];
           }
            
          //rune
            for (int i = 1; i < superheatrune.superheatArray.length; i++) {
           	 GUI.superheatTableData[2][i] = superheatrune.superheatArray[i];
           }

            
        } catch (MalformedURLException ex) {
	            Logger.getLogger(RSMarketTool.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
	            Logger.getLogger(RSMarketTool.class.getName()).log(Level.SEVERE, null, ex);
        }
        
	}

}
