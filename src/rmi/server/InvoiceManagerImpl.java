
package rmi.server;

import Transactions.Transaction;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import PostInterfaces.TransactionI;

/**
 *
 * @author Lowell Milliken
 */
public class InvoiceManagerImpl extends UnicastRemoteObject implements InvoiceManager {

    private final int MAXTRANS = 100;
    private TransactionI [] trans;
    private int transCount = 0;
    
    public InvoiceManagerImpl() throws RemoteException {
        trans = new Transaction[MAXTRANS];
    }
    
    @Override
    public TransactionI newInvoice() throws RemoteException {
        trans[transCount] =  new Transaction();
        transCount++;
        return trans[transCount - 1];
    }
    
    public int getTransCount() throws RemoteException {
        return transCount;
    }
    
}
