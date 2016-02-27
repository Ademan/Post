package Transactions.payment;

import java.rmi.RemoteException;

public class Credit extends Payment {

    private final String number;

    public Credit(double amount, String number)throws RemoteException {
        super(amount);
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
