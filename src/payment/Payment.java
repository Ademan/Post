package payment;

/**
 *
 * @author Lowell Milliken
 */
public abstract class Payment {
    private final float amountDue;
    private float amountPaid;
    private String typeName;
    
    public Payment(float pAmountDue, String typeName) {
        amountDue = pAmountDue;
        this.typeName = typeName;
    }
    
    // getter
    public float getAmountDue() {
        return amountDue;
    }

    public float getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(float amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getTypeName() {
        return typeName;
    }
    
    public abstract boolean makePayment(float amountPaid);
    public abstract float cashReturn();
}
