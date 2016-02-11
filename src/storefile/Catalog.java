package storefile;

import java.util.Map;

/**
 * Created by Allen Space on 2/10/2016.
 */
public class Catalog {
    private Map<String, Item> mItems;
    private Stock mStock;

    public Catalog(){
        //Defualt constructor.
    }

    public Catalog(Stock pStock){

    }

    public Map<String, Item> getCatalogItems(){
        return mItems;
    }

    public Item getItem(String pUPC){
        return null;
    }
}
