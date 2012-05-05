import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ItemList {
		//Globals:
		int coalID = 453;
		int natureID = 561;
		int coalORE;
        int natureRUNE;
	    
	    //Super Heat Item ID List:
		int mithOREid = 447;
		int mithBARid = 2359;
		int adamOREid = 449;
		int adamBARid = 2361;
		int runeOREid = 451;
		int runeBARid = 2363;
		
		int mithORE;
		int mithSuperHeatCost;
		int mithBAR;
		int mithPROFIT;
		
		int adamORE;
		int adamSuperHeatCost;
		int adamBAR;
		int adamPROFIT;
		
		int runeORE;
        int runeSuperHeatCost;
        int runeBAR;
        int runePROFIT;
		
		//Fishing Item ID List:
		int lobstercooked = 379;
	    int lobsterraw = 377;
	    int rocktailcooked = 15272;
	    int rocktailraw = 15270;
	    int sharkcooked = 85;
	    int sharkraw = 383;
	    int swordfishcooked = 373;
	    int swordfishraw = 371;
	    
	    //Misc Items ID List:
	    int rawrabbit = 3226;
	    int deathrune =  560;
	    
	    public void RefreshButton() {
			Fetch fetch = new Fetch();
	        try {
	            //Globals:
	            coalORE = Integer.parseInt(fetch.DownloadURL(coalID));
	            natureRUNE = Integer.parseInt(fetch.DownloadURL(natureID));
	            
	            //Superheat Item List:
	            //Mithril:
	            mithORE = Integer.parseInt(fetch.DownloadURL(mithOREid)); //Set the text for the ore cost
	            mithSuperHeatCost = natureRUNE + mithORE + (4 * coalORE); //Cost to superheat the bars
	            mithBAR = Integer.parseInt(fetch.DownloadURL(mithBARid)); //Display the result
	            mithPROFIT = mithBAR - mithSuperHeatCost; //Possible profit margin on superheat
	            
	            //Adamantite:
	            adamORE = Integer.parseInt(fetch.DownloadURL(adamOREid));
	            adamSuperHeatCost = natureRUNE + adamORE + (6 * coalORE); //Cost to superheat the bars
	            adamBAR = Integer.parseInt(fetch.DownloadURL(adamBARid)); //Convert the bar value
	            adamPROFIT = adamBAR - adamSuperHeatCost; //Possible profit margin on superheat
	            
	            //Runite: 
	            runeORE = Integer.parseInt(fetch.DownloadURL(runeOREid));
	            runeSuperHeatCost = natureRUNE + runeORE + (8 * coalORE); //Cost to superheat the bars
	            runeBAR = Integer.parseInt(fetch.DownloadURL(runeBARid)); //Display the result
	            runePROFIT = runeBAR - runeSuperHeatCost; //Possible profit margin on superheat
	            
	        } catch (MalformedURLException ex) {
	            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (IOException ex) {
	            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
	        }
		}
}
