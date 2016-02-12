package payment;

/**
 *
 * @author Lowell Milliken
 */
public abstract class Payment {
    private float amountDue;
    private float amountPaid;
    
    public Payment() {
        amountDue = 0.0f;
    }

    public Payment(float pAmountDue) {
        amountDue = pAmountDue;
    }
    
    // getter
    public float getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(float amountDue) {
        this.amountDue = amountDue;
    }

    public float getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(float amountPaid) {
        this.amountPaid = amountPaid;
    }
    
    
    public abstract boolean makePayment(float amountPaid);
    public abstract float cashReturn();
}
