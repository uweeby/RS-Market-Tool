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
            SuperHeatItem superheatmith = new SuperHeatItem(fetch.getItemData(mithOREid), 
            		mithCOALneeded, fetch.getItemData(mithBARid), natureCOST, coalCOST);
            
            SuperHeatItem superheatadam = new SuperHeatItem(fetch.getItemData(adamOREid), 
            		adamCOALneeded, fetch.getItemData(adamBARid), natureCOST, coalCOST);

            SuperHeatItem superheatrune = new SuperHeatItem(fetch.getItemData(runeOREid), 
            		runeCOALneeded, fetch.getItemData(runeBARid), natureCOST, coalCOST);
	            
            //Set Table Data
            //mith
            GUI.superheatTableData[0][1] = superheatmith.OREcost;
            GUI.superheatTableData[0][2] = superheatmith.COALneeded;
            GUI.superheatTableData[0][3] = superheatmith.SUPERHEATcost;
            GUI.superheatTableData[0][4] = superheatmith.BARcost;
            GUI.superheatTableData[0][5] = superheatmith.PROFIT;
            
          //adam
            GUI.superheatTableData[1][1] = superheatadam.OREcost;
            GUI.superheatTableData[1][2] = superheatadam.COALneeded;
            GUI.superheatTableData[1][3] = superheatadam.SUPERHEATcost;
            GUI.superheatTableData[1][4] = superheatadam.BARcost;
            GUI.superheatTableData[1][5] = superheatadam.PROFIT;
            
          //rune
            GUI.superheatTableData[2][1] = superheatrune.OREcost;
            GUI.superheatTableData[2][2] = superheatrune.COALneeded;
            GUI.superheatTableData[2][3] = superheatrune.SUPERHEATcost;
            GUI.superheatTableData[2][4] = superheatrune.BARcost;
            GUI.superheatTableData[2][5] = superheatrune.PROFIT;

            
        } catch (MalformedURLException ex) {
	            Logger.getLogger(RSMarketTool.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
	            Logger.getLogger(RSMarketTool.class.getName()).log(Level.SEVERE, null, ex);
        }
        
	}

}
