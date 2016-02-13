
package transaction;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lowell Milliken
 */
public class TextReceipt {
    private final Transaction transaction;
    private static final int COLUMN_WIDTH_L = -20;
    private static final int COLUMN_WIDTH_C = 25;
    private static final int COLUMN_WIDTH_R = 12;
    
    public TextReceipt(Transaction t) {
        transaction = t;
    }
    public void writeTransaction(Writer w) {
        BufferedWriter bWriter = new BufferedWriter(w);
        
        try {
            bWriter.write(createInvoiceHeader() + '\n');
            
            for(LineItem litem : transaction.getItems()) {
                bWriter.write(createLineItemString(litem) + '\n');
            }
            
            bWriter.write(createPaymentString() +'\n');
            
            bWriter.flush();
        } catch (IOException ex) {
            Logger.getLogger(TextReceipt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Creates a Header string for the invoice
    public String createInvoiceHeader()
    {
        StringBuilder builder = new StringBuilder();
        
        builder.append(String.format("%1$" + COLUMN_WIDTH_L + "s","Description"));
        builder.append(String.format("%1$" + COLUMN_WIDTH_C + "s","Quantity @ Unit Price"));
        builder.append(String.format("%1$" + COLUMN_WIDTH_R + "s","Price"));
        
        return builder.toString();
    }
    
    // Creates a String for a single line item
    public String createLineItemString(LineItem litem) {  
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("%1$" + COLUMN_WIDTH_L + "s",
                       litem.getItem().getDescription()));
        builder.append(String.format("%1$" + COLUMN_WIDTH_C + "s",
                       String.format("%d @ %.2f", litem.getQuantity(),
                                     litem.getItem().getPrice())));
        builder.append(String.format("%1$" + COLUMN_WIDTH_R + "s",
                       String.format("%.2f", litem.calcSubtotal())));
        
        return builder.toString();
    }
    
    // Create a String for payment information
    public String createPaymentString() {
        StringBuilder builder = new StringBuilder();
        
        builder.append(String.format("%1$" + COLUMN_WIDTH_L + "s",
                       "Payment Type: " + transaction.getPayment().getTypeName()));        
        builder.append(String.format("%1$" + COLUMN_WIDTH_L + "s\n",
                       "Amount Due: " + transaction.getPayment().getAmountDue()));
        builder.append(String.format("%1$" + COLUMN_WIDTH_L + "s\n",
                       "Amount Paid: " + transaction.getPayment().getAmountPaid()));    
        builder.append(String.format("%1$" + COLUMN_WIDTH_L + "s\n",
                       "Amount Returned: " + transaction.getPayment().cashReturn()));
          
        return builder.toString();
    }
}
