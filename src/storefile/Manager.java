package storefile;


public class Manager {
    private static Store mStore;

    public Manager(){
        //defualt constructor.
    }

    public void init(String pCatalogFiles){
        mStore = new Store();
    }
}
