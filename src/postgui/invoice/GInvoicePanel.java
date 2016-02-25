package postgui.invoice;

/**
 *
 * @author Tony
 */
public class GInvoicePanel extends javax.swing.JPanel implements InvoicePanel {

    /**
     * Creates new form GInvoicePanel
     */
    public GInvoicePanel() {
        initComponents();
        setHeader();
        this.lblRunningTotal.setText(this.runningTotal + "");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTotal = new javax.swing.JLabel();
        lblDollarSign = new javax.swing.JLabel();
        lblRunningTotal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        invoiceList = new javax.swing.JTextArea();
        lblInvoiceHeader = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Invoice"));

        lblTotal.setText("TOTAL ");

        lblDollarSign.setText("$");

        lblRunningTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRunningTotal.setText("1234.24");

        invoiceList.setEditable(false);
        invoiceList.setColumns(20);
        invoiceList.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        invoiceList.setRows(5);
        invoiceList.setAutoscrolls(false);
        invoiceList.setDragEnabled(true);
        jScrollPane1.setViewportView(invoiceList);

        lblInvoiceHeader.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 341, Short.MAX_VALUE)
                        .addComponent(lblTotal)
                        .addGap(18, 18, 18)
                        .addComponent(lblDollarSign)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRunningTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(lblInvoiceHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblInvoiceHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotal)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDollarSign)
                        .addComponent(lblRunningTotal)))
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea invoiceList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDollarSign;
    private javax.swing.JLabel lblInvoiceHeader;
    private javax.swing.JLabel lblRunningTotal;
    private javax.swing.JLabel lblTotal;
    // End of variables declaration//GEN-END:variables
    private float runningTotal = 0;

    public javax.swing.JTextArea getInvoicePanel() {
        return this.invoiceList;
    }

    public javax.swing.JPanel getPanel() {
        return this;
    }

    private void setHeader() {
        this.lblInvoiceHeader.setText(String.format("%-25s %-10s %13s %17s",
                "ITEM", "QTY", "UNIT_PRICE", "EXTENDED_PRICE"));
    }

    @Override
    public void addItemToInvoice(String row) {
        this.invoiceList.append(row);
    }

    @Override
    public void updateTotalLabel(float addedPrice) {
        float curTotal = Float.parseFloat(this.lblRunningTotal.getText());
        curTotal += addedPrice;
        this.lblRunningTotal.setText(curTotal + "");
    }
}
