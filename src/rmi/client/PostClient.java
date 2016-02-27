
package rmi.client;

import PostInterfaces.TransactionI;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import postgui.GPost;
import rmi.server.InvoiceManager;

/**
 *
 * @author Lowell Milliken
 */
public class PostClient {
    
    // test main
    public static void main (String [] args) {
        try {
            Registry registry = LocateRegistry.getRegistry();
            InvoiceManager iManager = (InvoiceManager) registry.lookup("InvoiceManager");
            
            TransactionI trans =(TransactionI) iManager.newInvoice();
            
            trans.addItemLine("1234", 1);
            
            System.out.println(iManager.getTransCount());
                
        } catch (RemoteException e) {
            System.out.println("Remote Exception: " + e);
        } catch (NotBoundException e) {
            System.out.println("NotBoundException: " + e);
        }
    }
}
