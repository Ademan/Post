package storefile;

import java.util.Map;


public class Catalog {
    private Map<String, Item> mItems;
    private Stock mStock;

    public Catalog(){
        //Defualt constructor.
    }

    public Catalog(Stock pStock){

    }

    //***** Setters ******
    public void setItems(Map<String, Item> pItems){ mItems = pItems; }

    //****** Getters ******
    public Map<String, Item> getCatalogItems(){ return mItems; }

    public Item getItem(String pUPC){
        return mItems.get(pUPC);
    }
}
