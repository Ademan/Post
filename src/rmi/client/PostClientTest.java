
package rmi.client;

import PostInterfaces.TransactionI;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import PostInterfaces.RemoteArrayAccessor;
import PostInterfaces.StoreManager;

/**
 *
 * @author Lowell Milliken
 */
public class PostClientTest {
    
    // test main
    public static void main (String [] args) {
        try {
            Registry registry = LocateRegistry.getRegistry();
            StoreManager sManager = (StoreManager) registry.lookup("InvoiceManager");
            
            TransactionI trans = sManager.newInvoice();
            
            trans.addItemLine("1234", 1);
            
            System.out.println(sManager.getTransCount());
            
            RemoteArrayAccessor<String> UPCList =
                    (RemoteArrayAccessor<String>)registry.lookup("UPCList");
            
            for(int i = 0; i < UPCList.getLength(); i++)
            {
                String upc = UPCList.get(i);
                System.out.print(upc);
                System.out.println("\t"+ sManager.getItem(upc).getItemDescription());
            }
            
                
        } catch (RemoteException e) {
            System.out.println("Remote Exception: " + e);
        } catch (NotBoundException e) {
            System.out.println("NotBoundException: " + e);
        }
    }
}
