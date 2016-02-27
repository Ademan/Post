package rmi.server;

import PostInterfaces.InvoiceManager;
import StoreProducts.Catalog;
import StoreProducts.Store;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

/**
 *
 * @author Lowell Milliken
 */
public class PostServer {
    
    Store store;
    
    void init() {
        store = new Store();
        Catalog catalog = store.createCatalogFromFile();
        
        
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            
            InvoiceManager im = new InvoiceManagerImpl();
            
            registry.rebind("InvoiceManager", im);
            System.out.println("registry rebound");
            
            for(String itemUPC : catalog.getUPCList()) {
                registry.rebind(itemUPC, catalog.getItem(itemUPC));
            }
            
            registry.rebind("UPCList",
                    new RemoteArrayAccessorImpl<String>(catalog.getUPCList()));
            
        } catch(Exception e) {
            System.out.println("Server not connected: " + e);
        }
        
    }
    
    
    public static void main(String [] args) {
        
        PostServer pserver = new PostServer();
        pserver.init();
    }
    
}
