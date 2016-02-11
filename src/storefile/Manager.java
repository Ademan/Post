package storefile;

/**
 * Created by Allen Space on 2/10/2016.
 */
public class Manager {
    private static Store mStore;

    public Manager(){
        //defualt constructor.
    }

    public void init(String pCatalogFiles){
        mStore = new Store();
    }
}
