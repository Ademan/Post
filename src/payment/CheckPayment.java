package payment;

/**
 *
 * @author Lowell Milliken
 */
public class CheckPayment extends Payment {
    private final double threshold = 0.1;
    
    public CheckPayment(float amountDue) {
        super(amountDue);
    }
    
    @Override
    public boolean makePayment(float checkAmount) {
        setAmountPaid(checkAmount);
        return checkAccepted();
    }
    
    @Override
    public float cashReturn() {
        return getAmountPaid() - getAmountDue();
    }
    
    private boolean checkAccepted() {
        return Math.random() > threshold;
    }
}
