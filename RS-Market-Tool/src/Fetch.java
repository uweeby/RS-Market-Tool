import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Fetch {
    //Class used to download item data from Internet.
	//Only save parts of page that are needed.
	//Send the results to Store class for processing.
	
    public String DownloadURL(int itemID) throws MalformedURLException, IOException{
        //Pass an itemID to be pulled from the site
        URL url = null;
        url = new URL("http://services.runescape.com/m=itemdb_rs/Rune_arrow/viewitem.ws?obj=" +  itemID);

        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuilder sb = new StringBuilder();
        String line;

        while ( (line=in.readLine()) != null) {
                sb.append(line);
        }
        in.close();

        Regex regex = new Regex();
        //Return the item value as a string
        return (regex.format(sb.toString()));
    } 
}
