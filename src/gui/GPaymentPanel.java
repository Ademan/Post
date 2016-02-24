/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postgui;

import java.awt.event.ItemEvent;

/**
 *
 * @author Tony
 */
public class GPaymentPanel extends javax.swing.JPanel {

    /**
     * Creates new form GPaymentPanel
     */
    public GPaymentPanel() {
        initComponents();
        this.hidePaymentOptions();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PaymentPanel = new javax.swing.JPanel();
        cboPaymentType = new javax.swing.JComboBox();
        lblPaymentType = new javax.swing.JLabel();
        lblPaymentTxtBoxLabel = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        btnPay = new javax.swing.JButton();

        PaymentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Payment"));
        PaymentPanel.setName("Payment"); // NOI18N

        cboPaymentType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Payment", "Cash", "Credit Card", "Check" }));
        cboPaymentType.setToolTipText("Payment Type");
        cboPaymentType.setName("cboPaymentType"); // NOI18N
        cboPaymentType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboPaymentTypeItemStateChanged(evt);
            }
        });

        lblPaymentType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPaymentType.setText("Payment Type");
        lblPaymentType.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblPaymentTxtBoxLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPaymentTxtBoxLabel.setText("Amount");
        lblPaymentTxtBoxLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtAmount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAmount.setToolTipText("Enter Amount");
        txtAmount.setName("txtAmount"); // NOI18N

        btnPay.setText("Pay");
        btnPay.setBorderPainted(false);
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PaymentPanelLayout = new javax.swing.GroupLayout(PaymentPanel);
        PaymentPanel.setLayout(PaymentPanelLayout);
        PaymentPanelLayout.setHorizontalGroup(
            PaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaymentPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(PaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPaymentType, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(lblPaymentTxtBoxLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboPaymentType, 0, 110, Short.MAX_VALUE)
                    .addComponent(txtAmount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        PaymentPanelLayout.setVerticalGroup(
            PaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaymentPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(PaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPaymentType, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboPaymentType, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPaymentTxtBoxLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PaymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPay)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PaymentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PaymentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPayActionPerformed

    private void cboPaymentTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboPaymentTypeItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            int indexSelected = this.cboPaymentType.getSelectedIndex();
            System.out.println(indexSelected);
            switch(indexSelected){
                case 0:
                    this.hidePaymentOptions();
                    break;
                case 1:
                    this.showCashPayment();
                    break;
                case 2:
                    break;
                default:
                    System.err.println("Error invalid idex returned");
                    
            }
        }
    }//GEN-LAST:event_cboPaymentTypeItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PaymentPanel;
    private javax.swing.JButton btnPay;
    private javax.swing.JComboBox cboPaymentType;
    private javax.swing.JLabel lblPaymentTxtBoxLabel;
    private javax.swing.JLabel lblPaymentType;
    private javax.swing.JTextField txtAmount;
    // End of variables declaration//GEN-END:variables
    
    private void hidePaymentOptions(){
        this.txtAmount.setVisible(false);
        this.lblPaymentTxtBoxLabel.setVisible(false);
        this.btnPay.setVisible(false);
    }
    
    private void showCashPayment(){
        this.txtAmount.setVisible(true);
        this.lblPaymentTxtBoxLabel.setText("Cash");
        this.lblPaymentTxtBoxLabel.setVisible(true);
        this.btnPay.setVisible(true);
    }

}
