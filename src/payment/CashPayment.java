package payment;

/**
 *
 * @author Lowell Milliken
 */
public class CashPayment extends Payment {
    
    public CashPayment(float amountDue) {
        super(amountDue);
    }
    
    @Override
    public boolean makePayment(float amountPaid) {
        setAmountPaid(amountPaid);
        return true;
    }
    
    @Override
    public float cashReturn() {
        return getAmountPaid() - getAmountDue();
    }
}
