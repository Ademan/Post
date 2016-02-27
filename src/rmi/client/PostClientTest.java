
package rmi.client;

import PostInterfaces.TransactionI;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import postgui.GPost;
import PostInterfaces.InvoiceManager;
import PostInterfaces.RemoteArrayAccessor;

/**
 *
 * @author Lowell Milliken
 */
public class PostClientTest {
    
    // test main
    public static void main (String [] args) {
        try {
            Registry registry = LocateRegistry.getRegistry();
            InvoiceManager iManager = (InvoiceManager) registry.lookup("InvoiceManager");
            
            TransactionI trans = iManager.newInvoice();
            
            trans.addItemLine("1234", 1);
            
            System.out.println(iManager.getTransCount());
            
            RemoteArrayAccessor<String> UPCList =
                    (RemoteArrayAccessor<String>)registry.lookup("UPCList");
            
            for(int i = 0; i < UPCList.getLength(); i++)
            {
                System.out.println(UPCList.get(i));
            }
            
                
        } catch (RemoteException e) {
            System.out.println("Remote Exception: " + e);
        } catch (NotBoundException e) {
            System.out.println("NotBoundException: " + e);
        }
    }
}
