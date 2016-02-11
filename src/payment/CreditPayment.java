package payment;

/**
 *
 * @author Lowell Milliken
 */
public class CreditPayment extends Payment {
    private final double threshold = 0.1;
    private final String creditCardNumber;
    
    public CreditPayment(float amountDue, String cardNumber) {
        super(amountDue);
        creditCardNumber  = cardNumber;
    }
    
    public boolean makePayment() {
        return makePayment(getAmountDue());
    }
    
    @Override
    public boolean makePayment(float amountPaid) {
        setAmountPaid(amountPaid);
        return cardAccepted();
    }
    
    public float cashReturn() {
        return 0;
    }
    
    private boolean cardAccepted() {
        return Math.random() > threshold;
    }
}
