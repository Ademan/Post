package rmi.server;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

/**
 *
 * @author Lowell Milliken
 */
public class PostServer {
    
    public static void main(String [] args) {
        
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            
            InvoiceManager im = new InvoiceManagerImpl();
            
            registry.rebind("InvoiceManager", im);
            System.out.println("registry rebound");
        } catch(Exception e) {
            System.out.println("Server not connected: " + e);
        }
    }
    
}
