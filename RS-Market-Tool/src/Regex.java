/*Check for different string formats and standardize
 * Examples:
 * 135 = 135
 * 1,556 = 1553
 * 13.1k = 13100
 * 145.1k = 145100
 * 2.1m = 2100000
 * 15.1m = 15100000
 */
public class Regex {
    private int currentPRICE;
    private String itemPriceSTRING;
    
    private boolean debug = false;
    
    
    public int format(String input) {
        
        //remove most HTML from the stream
        input = input.replaceAll("\\<.*?>" , ",");
        //convert large string into array
        String[] tempArray = input.split(",");
        
        
        //This requires additional regex to find the line number
        for(int i = 0;i < tempArray.length; i++){
            boolean test = tempArray[i].matches("(?i)Current guide price:*");
            if (test == true) {
                currentPRICE = i + 2; //The price is two lines past the text above
            }
        }
        
        //If the value is between 1k-10k its price will show up on two lines
        //This combines the two lines. If it is outside this range nothing is changed
        itemPriceSTRING = tempArray[currentPRICE] + tempArray[currentPRICE + 1];
        
        if(debug == true){
            for(int i = 0;i < tempArray.length; i++){
                //Print all lines
                System.out.println(tempArray[i]);
            }
        }
        
        //Format Thousands. If number ends in k. Ex: 13.1k
        if(itemPriceSTRING.endsWith("k")){ 
            itemPriceSTRING = itemPriceSTRING.substring(0, itemPriceSTRING.length() - 1); //Remove k
            itemPriceSTRING = itemPriceSTRING.concat("00"); //Replace k with 00
            itemPriceSTRING = itemPriceSTRING.replace(".", "");//Remove period. Number should now be formated correctly
        }
        
        //Format Millions. If number ends in m. Ex: 13.1m
        if(itemPriceSTRING.endsWith("m")){ 
            itemPriceSTRING = itemPriceSTRING.substring(0, itemPriceSTRING.length() - 1); //Remove m
            itemPriceSTRING = itemPriceSTRING.concat("00000"); //Replace m with 00000
            itemPriceSTRING = itemPriceSTRING.replace(".", "");//Remove period. Number should now be formated correctly
        }
        
        return(Integer.parseInt(itemPriceSTRING));
    }
}
