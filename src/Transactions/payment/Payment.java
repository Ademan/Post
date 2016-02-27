package Transactions.payment;

import PostInterfaces.PaymentI;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Payment extends UnicastRemoteObject implements PaymentI {

    private final double amount;
    
    public Payment() throws RemoteException{
        this.amount = 0;
    }

    public Payment(double amount) throws RemoteException{
        this.amount = amount;
    }
    
    public double getAmount() {
        return amount;
    }
}
