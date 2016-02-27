package Transactions.payment;

import java.rmi.RemoteException;

public class Check extends Payment {

    public Check(double amount) throws RemoteException {
        super(amount);
    }
}
