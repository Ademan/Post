package storefile;

import transactionfile.LineItem;

import java.util.Map;


/**
 * Created by Allen Space on 2/10/2016.
 */
public class Stock {

    private Map<String, LineItem> mItems;

    public Stock() {
        //Default Constructor.
    }

    public Stock(String pFilename){

    }

    public Map<String, LineItem> getStockItems(){
        return mItems;
    }
}
