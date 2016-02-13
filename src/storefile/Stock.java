package storefile;

import transaction.LineItem;

import java.util.Map;

/**
 * Stock contains a map of (UPC, LineItem) pairs
 */
public class Stock {

    private Map<String, LineItem> mStockItems;

    public Stock(String pFilename){
        mStockItems = new TextReader(pFilename).read();
    }

    public Map<String, LineItem> getStockItems(){
        return mStockItems;
    }
}
