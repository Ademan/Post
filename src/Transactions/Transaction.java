package Transactions;

import Transactions.payment.Payment;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**Transaction class Takes a Customer, Array of LineItems and Payment type 
 * to create a whole Transaction.
 * @author Jrubin
 * @author Lowell Milliken
 */
// Lowell: Modified to be remote object with RMI

public class Transaction extends UnicastRemoteObject implements TransactionInterface {
    private static final int MAX_LINES = 100;
    
    private Customer customer;
    private ItemLine lineItems[];
    private Payment payment;
    private int numOfLines;
    
    /** Constructs a Transaction object with a null Customer, empty ItemLine
     * array and empty Payment info.
     */
    public Transaction() throws RemoteException {
        this.customer = new Customer(null);
        this.lineItems = new ItemLine[MAX_LINES];
        this.numOfLines = 0;
        this.payment = new Payment();
        
    }
    /** Prints all the information of the Transaction
     * 
     */
    void printTransaction(){
        System.out.println("Customer: " + customer.getName());
        for(int i=0;i<numOfLines;i++){
            lineItems[i].printItem();  
        }
        
    }
    
    /** Returns the Customer object
     * 
     * @return Customer
     */
    public Customer getCustomer(){
        return this.customer;
    }
    
    /**Returns the array of LineItems
     * 
     * @return ItemLine array 
     */
    public ItemLine[] getItemList(){
        return this.lineItems;
    }
    /**Returns the payment for this transaction
     * 
     * @return payment type
     */
    public Payment getPayment(){
        return this.payment;
    }
    
    /**Returns the number of different items purchased in this transaction
     * 
     * @return number of lines 
     */
    public int getCartSize(){
        return this.numOfLines;
    }
    
    /**takes a string, makes a new customer, and makes that customer the 
     * new customer for this transaction
     * @param newName 
     */
    public void setCustomer(String newName){
        this.customer = new Customer(newName);
    }
    /**takes a Customer object and makes it the customer for this transaction
     * 
     * @param newCustomer 
     */
    public void setCustomer(Customer newCustomer){
        this.customer = newCustomer;
    }
    
    /**Takes an ItemLine object and adds it to the Item List
     * 
     * @param newLn 
     */
    public void addItemLine(ItemLine newLn){
        this.lineItems[numOfLines] = newLn;
        this.numOfLines++;
    }

    /**takes a string and integer, makes a ItemLine, and adds it to the Item List
     * @param upc
     * @param quantity
     */
    public void addItemLine(String upc, int quantity) {
        this.lineItems[numOfLines] = new ItemLine(upc, quantity);
    }
    
    /**Takes a Payment object to set Payment
     * 
     * @param newPayment 
     */
    public void setPayment(Payment newPayment){
        this.payment = newPayment;
    }
}
