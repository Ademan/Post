
package rmi.server;

import PostInterfaces.ItemI;
import Transactions.Transaction;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import PostInterfaces.TransactionI;
import java.util.HashMap;
import java.util.Map;
import PostInterfaces.StoreManager;
import StoreProducts.Catalog;

/**
 *
 * @author Lowell Milliken
 */
public class StoreManagerImpl extends UnicastRemoteObject implements StoreManager {

    Catalog catalog;
    
    final private Map<Integer,TransactionI> trans;
    private int transCount = 0;
    
    public StoreManagerImpl() throws RemoteException {
        trans = new HashMap();
    }
    
    @Override
    public TransactionI newInvoice() throws RemoteException {
        trans.put(transCount, new Transaction());
        transCount++;
        return trans.get(transCount - 1);
    }
    
    public int getTransCount() throws RemoteException {
        return transCount;
    }

    @Override
    public ItemI getItem(String upc) throws RemoteException {
        return catalog.getItem(upc);
    }
    
    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
    
}
