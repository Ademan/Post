
package Transactions;

import Transactions.payment.Payment;

/**
 *
 * @author Lowell Milliken
 */
interface TransactionInterface {
    public Customer getCustomer();
    
    /**Returns the array of LineItems
     * 
     * @return ItemLine array 
     */
    public ItemLine[] getItemList();
    /**Returns the payment for this transaction
     * 
     * @return payment type
     */
    public Payment getPayment();
    
    /**Returns the number of different items purchased in this transaction
     * 
     * @return number of lines 
     */
    public int getCartSize();
    
    /**takes a string, makes a new customer, and makes that customer the 
     * new customer for this transaction
     * @param newName 
     */
    public void setCustomer(String newName);
    /**takes a Customer object and makes it the customer for this transaction
     * 
     * @param newCustomer 
     */
    public void setCustomer(Customer newCustomer);
    
    /**Takes an ItemLine object and adds it to the Item List
     * 
     * @param newLn 
     */
    public void addItemLine(ItemLine newLn);
    
    public void addItemLine(String upc, int quantity);
    
    /**Takes a Payment object to set Payment
     * 
     * @param newPayment 
     */
    public void setPayment(Payment newPayment);
}
