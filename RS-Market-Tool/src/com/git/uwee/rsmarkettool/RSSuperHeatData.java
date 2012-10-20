package com.git.uwee.rsmarkettool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RSSuperHeatData {
	
	//Variable Declaration
	static int coalCOST;
	static int natureCOST;
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
	
	public SuperHeatItem[][] superheatItemData = new SuperHeatItem[2][5];
	
    private int currentPrice;
    private String itemPriceString;
	
    public void GatherData() {
		
		//Try to download item data from website
        try {
            //Globals:
        	natureCOST = DownloadItemData(natureID);
    		coalCOST = DownloadItemData(coalID);
    		
    		//Format: Ore Price, Coal Needed to Super Heat, Bar Cost, Nature Cost, Coal Cost.
            SuperHeatItem superheatmith = new SuperHeatItem(
            		DownloadItemData(mithOREid), 
            		mithCOALneeded, 
            		DownloadItemData(mithBARid), 
            		natureCOST, 
            		coalCOST);
            
            SuperHeatItem superheatadam = new SuperHeatItem(
            		DownloadItemData(adamOREid), 
            		adamCOALneeded, 
            		DownloadItemData(adamBARid), 
            		natureCOST, 
            		coalCOST);

            SuperHeatItem superheatrune = new SuperHeatItem(
            		DownloadItemData(runeOREid), 
            		runeCOALneeded, 
            		DownloadItemData(runeBARid), 
            		natureCOST, 
            		coalCOST);
            
            //Set Table Data
            //Mithril
            for (int i = 1; i < superheatmith.superheatArray.length; i++) {
            	 GUI.superheatTableData[0][i] = superheatmith.superheatArray[i];
            }
            
            //Adamantite
            for (int i = 1; i < superheatadam.superheatArray.length; i++) {
            	GUI.superheatTableData[1][i] = superheatadam.superheatArray[i];
            }
            
            //Runite
            for (int i = 1; i < superheatrune.superheatArray.length; i++) {
            	GUI.superheatTableData[2][i] = superheatrune.superheatArray[i];
            }

        } catch (MalformedURLException ex) {
	            Logger.getLogger(RSMarketTool.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
	            Logger.getLogger(RSMarketTool.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
    
    //Download item data from Internet
    public int DownloadItemData(int itemID) throws MalformedURLException, IOException {
    	
        //Pass in itemID to be pulled from the site
        URL url = new URL("http://services.runescape.com/m=itemdb_rs/Rune_arrow/viewitem.ws?obj=" +  itemID);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line=in.readLine()) != null) {
        	sb.append(line);
        }
        in.close();
        
        return RSParsePrice(sb.toString());
    }
    
    //Format String parameter to be a normal INT
    public int RSParsePrice(String input) {
        
        //Remove HTML tags from String
        input = input.replaceAll("\\<.*?>" , ",");
        
        //Split String into an String array
        String[] tempArray = input.split(",");
        
        //Find the line number with price. Then skip two more lines to get the actual price
        for(int i = 0;i < tempArray.length; i++) {
            if (tempArray[i].matches("(?i)Current guide price:*")) {
            	currentPrice = i + 2;
            }
        }
        
        //If the value is between 1k-10k its price will show up on two lines
        //This combines the two lines. If it is outside this range nothing is changed
        itemPriceString = tempArray[currentPrice] + tempArray[currentPrice + 1];

        //Format Thousands. If number ends in k. Ex: 13.1k
        itemPriceString = RSFormatString(itemPriceString);
        
        return(Integer.parseInt(itemPriceString));
    }
        
    //Strips 'k'(thousand) and 'm'(million) from item prices
    public String RSFormatString(String toFormat) {
    	
    	//Format Thousands. If number ends in k. Ex: 13.1k
        if(toFormat.endsWith("k")){ 
        	toFormat = toFormat.substring(0, toFormat.length() - 1); //Remove k
        	toFormat = toFormat.concat("00"); //Replace k with 00
        	toFormat = toFormat.replace(".", "");//Remove period. Number should now be formated correctly
        }
        
        //Format Millions. If number ends in m. Ex: 13.1m
        if(toFormat.endsWith("m")){ 
        	toFormat = toFormat.substring(0, toFormat.length() - 1); //Remove m
        	toFormat = toFormat.concat("00000"); //Replace m with 00000
        	toFormat = toFormat.replace(".", "");//Remove period. Number should now be formated correctly
        }
        
        return toFormat;
    }
}
