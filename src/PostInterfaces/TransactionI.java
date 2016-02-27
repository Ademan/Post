package PostInterfaces;

import Transactions.Customer;
import Transactions.ItemLine;
import Transactions.payment.Payment;
import java.rmi.RemoteException;

/**
 *
 * @author Lowell Milliken
 */
public interface TransactionI  extends java.rmi.Remote {
    public Customer getCustomer()throws RemoteException;
    
    /**Returns the array of LineItems
     * 
     * @return ItemLine array 
     */
    public ItemLine[] getItemList()throws RemoteException;
    /**Returns the payment for this transaction
     * 
     * @return payment type
     */
    public Payment getPayment()throws RemoteException;
    
    /**Returns the number of different items purchased in this transaction
     * 
     * @return number of lines 
     */
    public int getCartSize()throws RemoteException;
    
    /**takes a string, makes a new customer, and makes that customer the 
     * new customer for this transaction
     * @param newName 
     */
    public void setCustomer(String newName)throws RemoteException;
    /**takes a Customer object and makes it the customer for this transaction
     * 
     * @param newCustomer 
     */
    public void setCustomer(Customer newCustomer) throws RemoteException;
    
    /**Takes an ItemLine object and adds it to the Item List
     * 
     * @param newLn 
     */
    public void addItemLine(ItemLine newLn)throws RemoteException;
    
    public void addItemLine(String upc, int quantity)throws RemoteException;
    
    /**Takes a Payment object to set Payment
     * 
     * @param newPayment 
     */
    public void setPayment(Payment newPayment)throws RemoteException;
}
