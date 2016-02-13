package storefile;

import transaction.LineItem;

import java.util.HashMap;
import java.util.Map;

/**
 * Catalog contains a map of (UPC, Item) pairs.
 * Catalog is different from Stock in that it does not contain quantity information.
 */
public class Catalog {
    private Map<String, Item> mCatalogItems;

    public Catalog(){
        //Defualt constructor.
        mCatalogItems = new HashMap<>();
    }

    /**
     * Constructs a Catalog from Stock by removing quantity information in LineItem
     * @param pStock
     */
    public Catalog(Stock pStock){
        mCatalogItems = new HashMap<>();
        Map<String, LineItem> lineItemMap = pStock.getStockItems();
        for (Map.Entry<String, LineItem> entry : lineItemMap.entrySet()) {
            mCatalogItems.put(entry.getKey(), entry.getValue().getItem());
        }
    }

    //***** Setters ******
    public void setItems(Map<String, Item> pItems){ mCatalogItems = pItems; }

    //****** Getters ******
    public Map<String, Item> getCatalogItems(){ return mCatalogItems; }

    public Item getItem(String pUPC){
        return mCatalogItems.get(pUPC);
    }
}
