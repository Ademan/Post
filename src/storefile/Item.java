package storefile;


public class Item {
    private String mUPC;
    private String mDescription;
    private float mPrice;

    public Item(){
        //Default Constructor.
    }

    public Item(String pUPC, String pDescription, float pPrice){

    }

    //*******Setters**************
    public void setUPC(String pUPC){ mUPC = pUPC; }

    public void setDescription(String pDescription){ mDescription = pDescription; }

    public void setPrice(float pPrice){ mPrice = pPrice; }

    //*********Getter**********8
    public String getUPC(){ return mUPC; }

    public String getDescription(){ return mDescription; }

    public float getPrice(){ return mPrice; }
}
