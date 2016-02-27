package rmi.server;

import StoreProducts.Catalog;
import StoreProducts.Store;
import java.rmi.registry.*;
import PostInterfaces.StoreManager;

/**
 *
 * @author Lowell Milliken
 */
public class PostServer {
    
    private Store store;
    
    void init() {
        store = new Store();
        Catalog catalog = store.createCatalogFromFile();
        
        
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            
            StoreManagerImpl sm = new StoreManagerImpl();
            sm.setCatalog(catalog);
            
            registry.rebind("InvoiceManager", (StoreManager) sm);
            
            for(String itemUPC : catalog.getUPCList()) {
                registry.rebind(itemUPC, catalog.getItem(itemUPC));
            }
            
            registry.rebind("UPCList",
                    new RemoteArrayAccessorImpl<String>(catalog.getUPCList()));
            
            System.out.println("registry rebound");
            System.out.println("Server running...");
            
        } catch(Exception e) {
            System.out.println("Server not connected: " + e);
        }
        
    }
    
    
    public static void main(String [] args) {
        
        PostServer pserver = new PostServer();
        pserver.init();
    }
    
}
