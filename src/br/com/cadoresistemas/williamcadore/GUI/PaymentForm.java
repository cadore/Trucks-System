package br.com.cadoresistemas.williamcadore.GUI;

import br.com.cadoresistemas.williamcadore.DAO.PaymentDAO;
import br.com.cadoresistemas.williamcadore.DAO.TrucksDAO;
import br.com.cadoresistemas.williamcadore.ModelsForm.PaymentModel;
import br.com.cadoresistemas.williamcadore.Utils.FixedLengthDocument;
import br.com.cadoresistemas.williamcadore.Utils.Util;
import java.awt.Color;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class PaymentForm extends javax.swing.JInternalFrame {

    public PaymentForm() {
        initComponents();
        b_delete.setVisible(false);
        this.setFrameIcon(new ImageIcon(this.getClass().getResource("/Images/iconTruckSystem.jpg")));
        f_observation.setDocument(new FixedLengthDocument(350));
    }

    public PaymentModel payment = null;

    public String status = "save";
    public String IdBusiness = null;
    private TrucksDAO trucksDAO = new TrucksDAO();
    private Util ut = new Util();
    private DecimalFormat decimal = new DecimalFormat("0.00");
    public Dashboard dash = null;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        f_identify = new javax.swing.JTextField();
        f_value = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        f_date_expiry = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        f_payment = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        f_id = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cb_truck = new javax.swing.JComboBox();
        f_n_truck = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        f_observation = new javax.swing.JEditorPane();
        ck_paid = new javax.swing.JCheckBox();
        b_cancel = new javax.swing.JButton();
        b_save = new javax.swing.JButton();
        b_delete = new javax.swing.JButton();

        setTitle("Pagamentos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        f_identify.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        f_value.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_value.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                f_valueFocusLost(evt);
            }
            public void focusGained(java.awt.event.FocusEvent evt) {
                f_valueFocusGained(evt);
            }
        });
        f_value.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_valueKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("*Observação:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("*Valor R$:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Nº Identificação:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("*Data Vencimento:");

        try {
            f_date_expiry.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        f_date_expiry.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_date_expiry.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                f_date_expiryFocusLost(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("*Pagar à:");

        f_payment.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Nova Conta á Pagar");

        f_id.setEditable(false);
        f_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("ID:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Veiculo:");

        cb_truck.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_truck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_truckActionPerformed(evt);
            }
        });

        f_n_truck.setEditable(false);
        f_n_truck.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_n_truck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f_n_truckActionPerformed(evt);
            }
        });
        f_n_truck.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_n_truckKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Numero Veiculo:");

        jScrollPane1.setViewportView(f_observation);

        ck_paid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ck_paid.setText("Conta Paga?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(ck_paid))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(f_date_expiry, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(f_value, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(f_payment)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(cb_truck, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(f_n_truck)))
                            .addComponent(f_identify)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(f_id, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(f_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(f_payment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(29, 29, 29))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(f_n_truck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_truck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(f_date_expiry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(f_value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(f_identify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ck_paid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
        );

        b_cancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png"))); // NOI18N
        b_cancel.setText("Cancelar");
        b_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelActionPerformed(evt);
            }
        });

        b_save.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png"))); // NOI18N
        b_save.setText("Salvar");
        b_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_saveActionPerformed(evt);
            }
        });

        b_delete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Delete.png"))); // NOI18N
        b_delete.setText("Excluir");
        b_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(b_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(b_save, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(b_cancel))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_delete)
                    .addComponent(b_save)
                    .addComponent(b_cancel)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void loadTrucks() {
        cb_truck.addItem(" -");
        ArrayList trucks = trucksDAO.findAll(Long.valueOf(this.IdBusiness)); //'produtoDAO' é meu objeto que retorna os produtos do banco.
        Iterator i = trucks.iterator();

        while(i.hasNext()) {
           cb_truck.addItem(String.valueOf(i.next()));
        }
   }

    public void setPayment(){
        try {
            String a = String.valueOf(payment.getId_truck());
            f_id.setText(payment.getId().toString());
            f_payment.setText(payment.getPayment());
            f_observation.setText(payment.getObservation());
            f_date_expiry.setText(ut.dateFormatReturn(payment.getDate_expiry()));
            f_value.setText(decimal.format(payment.getValor()).replace(".", ","));
            f_identify.setText(payment.getIdentify());
            if("0".equals(a)){
                cb_truck.removeAllItems();
            }else{
                cb_truck.addItem(trucksDAO.getBoardTruckById(payment.getId_truck()));
            }
            if("0".equals(a)){
                f_n_truck.setText("");
            }else{
                f_n_truck.setText(String.valueOf(trucksDAO.getNumberTruck(String.valueOf(cb_truck.getSelectedItem()))));
            }
            ck_paid.setVisible(true);
            if(payment.getPaid() == true){
                ck_paid.setSelected(true);
            }else if(payment.getPaid() == false){
                ck_paid.setSelected(false);
            }
            status = "update";
            b_save.setText("Atualizar");
            b_delete.setVisible(true);
            loadTrucks();
        } catch (ParseException ex) {
            Logger.getLogger(PaymentForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void b_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelActionPerformed
            this.dispose();
    }//GEN-LAST:event_b_cancelActionPerformed

    private void b_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_saveActionPerformed
       Long id_truck = null;
       boolean paid = false;
        if(ck_paid.isSelected() == true){
            paid = true;
        }else if(ck_paid.isSelected() == false){
            paid = false;
        }
        if ("save".equals(status)){
           if ((f_payment.getText().isEmpty())
                || (f_date_expiry.getText().trim().length() == 4)
                || (f_value.getText().isEmpty())
                || (f_observation.getText().isEmpty())){
                JOptionPane.showMessageDialog(rootPane, "Campos com ' * ' São obrigatórios!", "Pagamentos", JOptionPane.WARNING_MESSAGE);
                }else{
                    try {
                        if(" -".equals(cb_truck.getSelectedItem())){
                            id_truck = Long.valueOf(0);
                        }else if(!" -".equals(cb_truck.getSelectedItem())){
                            id_truck = trucksDAO.getIDTruck(cb_truck.getSelectedItem().toString());
                        }
                         PaymentModel pagamentos = new PaymentModel();
                         pagamentos.setPayment(f_payment.getText().toUpperCase());
                         pagamentos.setObservation(f_observation.getText().toUpperCase());
                         pagamentos.setDate_expiry(ut.dateFormatInsert(f_date_expiry.getText()));
                         pagamentos.setValor(Double.valueOf(f_value.getText().replace(",", ".")));
                         pagamentos.setIdentify(f_identify.getText().toUpperCase());
                         pagamentos.setCreated_at(ut.dateFormatInsert(ut.getDateddMMyyyy()));
                         pagamentos.setUpdated(ut.dateFormatInsert(ut.getDateddMMyyyy()));
                         pagamentos.setId_business(Long.valueOf(this.IdBusiness));
                         pagamentos.setInactive(false);
                         pagamentos.setId_truck(id_truck);
                         pagamentos.setPaid(paid);

                         PaymentDAO dao = new PaymentDAO();
                         dao.adiciona(pagamentos);
                         dash.setPayments();
                         JOptionPane.showMessageDialog(null, "Nova conta á pagar cadastrada com sucesso", "Cadore Sistemas | Pagamentos", JOptionPane.INFORMATION_MESSAGE);
                         f_payment.setText("");
                         f_n_truck.setText("");
                         f_date_expiry.setText("");
                         f_value.setText("");
                         f_identify.setText("");
                         f_observation.setText("");
                         cb_truck.removeAllItems();
                         loadTrucks();
                         f_payment.grabFocus();
                    } catch (ParseException ex) {
                        Logger.getLogger(PaymentForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
             }
       }else if ("update".equals(status)){
           if ((f_payment.getText().isEmpty())
                || (f_date_expiry.getText().trim().length() == 4)
                || (f_value.getText().isEmpty())
                || (f_observation.getText().isEmpty())){
                JOptionPane.showMessageDialog(rootPane, "Campos com '*' São obrigatórios!", "Pagamentos", JOptionPane.WARNING_MESSAGE);

            }else {
               try {
                   if(" -".equals(cb_truck.getSelectedItem())){
                       id_truck = Long.valueOf(0);
                   }else if(!" -".equals(cb_truck.getSelectedItem())){
                       id_truck = trucksDAO.getIDTruck(String.valueOf(cb_truck.getSelectedItem()));
                   }
                    PaymentModel pagamentos = new PaymentModel();
                    pagamentos.setId(Long.valueOf(f_id.getText()));
                    pagamentos.setPayment(f_payment.getText().toUpperCase());
                    pagamentos.setObservation(f_observation.getText().toUpperCase());
                    pagamentos.setDate_expiry(ut.dateFormatInsert(f_date_expiry.getText()));
                    pagamentos.setValor(Double.valueOf(f_value.getText().replace(",", ".")));
                    pagamentos.setIdentify(f_identify.getText().toUpperCase());
                    pagamentos.setUpdated(ut.dateFormatInsert(ut.getDateddMMyyyy()));
                    pagamentos.setId_business(Long.valueOf(this.IdBusiness));
                    pagamentos.setInactive(false);
                    pagamentos.setId_truck(id_truck);
                    pagamentos.setPaid(paid);

                    PaymentDAO dao = new PaymentDAO();
                    dao.atualiza(pagamentos);
                    dash.setPayments();
                    JOptionPane.showMessageDialog(null, "Nova conta á pagar Atualizada com sucesso", "Cadore Sistemas | Pagamentos", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
               } catch (ParseException ex) {
                   Logger.getLogger(PaymentForm.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
        }
    }//GEN-LAST:event_b_saveActionPerformed

    private void b_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_deleteActionPerformed
        Object[] options = { " Sim "," Não "};
		int i = JOptionPane.showOptionDialog(null,"Você tem certeza que deseja excluir esse Pagamento?", "Pagamentos",
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		if (i == JOptionPane.YES_OPTION){
                    PaymentModel pagamentos = new PaymentModel();
                    pagamentos.setId(Long.valueOf(f_id.getText()));
                    pagamentos.setInactive(true);
                    PaymentDAO dao = new PaymentDAO();
                    dao.exclui(pagamentos);
                    JOptionPane.showMessageDialog(null, "Conta à pagar Excluida(Inativada) com sucesso");
                    f_payment.setEditable(true);
                    f_observation.setEditable(true);
                    f_date_expiry.setEditable(true);
                    f_value.setEditable(true);
                    f_identify.setEditable(true);
                    f_payment.grabFocus();
                    status = "save";
                    b_delete.setVisible(false);
                    b_save.setText("Salvar");
                    f_id.setText("");
                    f_payment.setText("");
                    f_observation.setText("");
                    f_date_expiry.setText("");
                    f_value.setText("");
                    f_identify.setText("");
                }
    }//GEN-LAST:event_b_deleteActionPerformed

    private void f_n_truckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f_n_truckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_f_n_truckActionPerformed

    private void f_n_truckKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_n_truckKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_f_n_truckKeyReleased

    private void cb_truckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_truckActionPerformed
        if(cb_truck.getSelectedItem() == null || " -".equals(cb_truck.getSelectedItem())){
            f_n_truck.setText("");
        }else{
             f_n_truck.setText(String.valueOf(trucksDAO.getNumberTruck(cb_truck.getSelectedItem().toString())));
        }
    }//GEN-LAST:event_cb_truckActionPerformed

    private void f_valueFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_valueFocusGained
        f_value.selectAll();
    }//GEN-LAST:event_f_valueFocusGained

    private void f_valueFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_valueFocusLost
        if(ut.isNumbers(f_value) == true){
            double a = Double.valueOf(f_value.getText().replace(",", "."));
            f_value.setText(decimal.format(a).replace(".", ","));
        }
    }//GEN-LAST:event_f_valueFocusLost

    private void f_date_expiryFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_date_expiryFocusLost

    }//GEN-LAST:event_f_date_expiryFocusLost

    private void f_valueKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_valueKeyReleased

    }//GEN-LAST:event_f_valueKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_cancel;
    private javax.swing.JButton b_delete;
    private javax.swing.JButton b_save;
    private javax.swing.JComboBox cb_truck;
    private javax.swing.JCheckBox ck_paid;
    private javax.swing.JFormattedTextField f_date_expiry;
    private javax.swing.JTextField f_id;
    private javax.swing.JTextField f_identify;
    private javax.swing.JTextField f_n_truck;
    private javax.swing.JEditorPane f_observation;
    private javax.swing.JTextField f_payment;
    private javax.swing.JTextField f_value;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
