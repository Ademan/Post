
package PostInterfaces;

import java.rmi.RemoteException;
import PostInterfaces.TransactionI;

/**
 *
 * @author Lowell Milliken
 */
public interface StoreManager extends java.rmi.Remote {
    public TransactionI newInvoice() throws RemoteException;
    public int getTransCount() throws RemoteException;
    public ItemI getItem(String upc) throws RemoteException;
}
