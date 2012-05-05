import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ItemList {
	Fetch fetch = new Fetch();
		//Variable Declaration
		int coalID = 453;
		int natureID = 561;
		int coalORE;
        int natureRUNE;
	    
		int mithOREid = 447;
		int mithOREcost;
		int mithCOALneeded = 4;
		int mithSUPERHEATcost;
		int mithBARid = 2359;
		int mithBARcost;
		int mithPROFIT;
		
		int adamOREid = 449;
		int adamOREcost;
		int adamCOALneeded = 6;
		int adamSUPERHEATcost;
		int adamBARid = 2361;
		int adamBARcost;
		int adamPROFIT;
		
		int runeOREid = 451;
		int runeOREcost;
		int runeCOALneeded = 8;
        int runeSUPERHEATcost;
		int runeBARid = 2363;
        int runeBARcost;
        int runePROFIT;
	    
	    public void RefreshButton() {
			Fetch fetch = new Fetch();
	        try {
	            //Globals:
	            coalORE = fetch.DownloadURL(coalID);
	            natureRUNE = fetch.DownloadURL(natureID);
	            
	            //Superheat Item List:
	            //Mithril:
	            mithOREcost = fetch.DownloadURL(mithOREid); //Set the text for the ore cost
	            mithSUPERHEATcost = natureRUNE + mithOREcost + (mithCOALneeded * coalORE); //Cost to superheat the bars
	            mithBARcost = fetch.DownloadURL(mithBARid); //Display the result
	            mithPROFIT = mithBARcost - mithSUPERHEATcost; //Possible profit margin on superheat
	            
	            //Adamantite:
	            adamOREcost = fetch.DownloadURL(adamOREid);
	            adamSUPERHEATcost = natureRUNE + adamOREcost + (adamCOALneeded * coalORE); //Cost to superheat the bars
	            adamBARcost = fetch.DownloadURL(adamBARid); //Convert the bar value
	            adamPROFIT = adamBARcost - adamSUPERHEATcost; //Possible profit margin on superheat
	            
	            //Runite: 
	            runeOREcost = fetch.DownloadURL(runeOREid);
	            runeSUPERHEATcost = natureRUNE + runeOREcost + (runeCOALneeded * coalORE); //Cost to superheat the bars
	            runeBARcost = fetch.DownloadURL(runeBARid); //Display the result
	            runePROFIT = runeBARcost - runeSUPERHEATcost; //Possible profit margin on superheat
	            
	        } catch (MalformedURLException ex) {
	            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (IOException ex) {
	            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
	        }
		}

}
