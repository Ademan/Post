package storefile;

import transaction.LineItem;

import java.util.Map;

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
