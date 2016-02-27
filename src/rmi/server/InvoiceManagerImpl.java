
package rmi.server;

import PostInterfaces.InvoiceManager;
import Transactions.Transaction;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import PostInterfaces.TransactionI;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Lowell Milliken
 */
public class InvoiceManagerImpl extends UnicastRemoteObject implements InvoiceManager {

    final private Map<Integer,TransactionI> trans;
    private int transCount = 0;
    
    public InvoiceManagerImpl() throws RemoteException {
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
    
}
