package br.com.cadoresistemas.williamcadore.GUI;

import br.com.cadoresistemas.williamcadore.DAO.PaymentDAO;
import br.com.cadoresistemas.williamcadore.DAO.TrucksDAO;
import br.com.cadoresistemas.williamcadore.ModelsForm.PaymentModel;
import br.com.cadoresistemas.williamcadore.TableModels.PaymentTableModel;
import br.com.cadoresistemas.williamcadore.Utils.Centraliza;
import br.com.cadoresistemas.williamcadore.Utils.Util;
import com.towel.el.annotation.AnnotationResolver;
import com.towel.swing.table.ObjectTableModel;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class PaymentSearch extends javax.swing.JInternalFrame {

    AnnotationResolver resolver = new AnnotationResolver(PaymentTableModel.class);
    ObjectTableModel<PaymentTableModel> tableModel = new ObjectTableModel<>(resolver, "id,id_truck,pago_a,observação,data_vencimento,valor,identificacao,paid");

    List<PaymentTableModel> listPayment = new ArrayList<>();

    public JDesktopPane deskPane = null;
    public String IdBusiness = null;
    private TrucksDAO trucksDAO = new TrucksDAO();
    private Util ut = new Util();
    public Dashboard dash = null;
    private DecimalFormat decimal = new DecimalFormat("0.00");
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public PaymentSearch() {
        initComponents();
        d_date_first.setEnabled(false);
        d_date_last.setEnabled(false);
        rb_date_expiry.setSelected(false);
        f_payment.setText("");
        f_payment.setEnabled(true);
        rb_payment.setSelected(true);
        this.setFrameIcon(new ImageIcon(this.getClass().getResource("/Images/iconTruckSystem.jpg")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        f_payment = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_payment = new javax.swing.JTable();
        b_save = new javax.swing.JButton();
        b_select = new javax.swing.JButton();
        rb_date_expiry = new javax.swing.JRadioButton();
        rb_payment = new javax.swing.JRadioButton();
        rb_expiry = new javax.swing.JRadioButton();
        b_search = new javax.swing.JButton();
        d_date_first = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        d_date_last = new com.toedter.calendar.JDateChooser();

        setTitle("Consulta De Pagamentos");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        f_payment.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_payment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_paymentKeyReleased(evt);
            }
        });

        t_payment.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        t_payment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        t_payment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_paymentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(t_payment);

        b_save.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png"))); // NOI18N
        b_save.setText("Cancelar");
        b_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_saveActionPerformed(evt);
            }
        });

        b_select.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_select.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png"))); // NOI18N
        b_select.setText("Selecionar");
        b_select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_selectActionPerformed(evt);
            }
        });

        rb_date_expiry.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb_date_expiry.setText("Data de Vencimento de:");
        rb_date_expiry.setFocusable(false);
        rb_date_expiry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_date_expiryActionPerformed(evt);
            }
        });

        rb_payment.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb_payment.setText("Pagar á:");
        rb_payment.setFocusable(false);
        rb_payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_paymentActionPerformed(evt);
            }
        });

        rb_expiry.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb_expiry.setText("Totas as Vencidas:");
        rb_expiry.setFocusable(false);
        rb_expiry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_expiryActionPerformed(evt);
            }
        });

        b_search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Calendar.png"))); // NOI18N
        b_search.setText("Buscar por Data");
        b_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_searchActionPerformed(evt);
            }
        });

        d_date_first.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Até:");

        d_date_last.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 990, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rb_payment)
                            .addComponent(rb_date_expiry))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(d_date_first, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addGap(11, 11, 11)
                                .addComponent(d_date_last, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(b_search))
                            .addComponent(f_payment))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rb_expiry)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(b_select, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_save, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(d_date_first, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(d_date_last, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rb_payment)
                            .addComponent(f_payment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rb_expiry))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rb_date_expiry))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(b_search)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_save)
                    .addComponent(b_select))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setDate(){
        String month = ut.getDateMM();
        try {
            if(month.equals("01")){
                    d_date_first.setDate(ut.dateFormatInsert("01/01/" + ut.getDateyyyy()));
                    d_date_last.setDate(ut.dateFormatInsert("31/01/" + ut.getDateyyyy()));
            }else if(month.equals("02")){
                    d_date_first.setDate(ut.dateFormatInsert("01/02/" + ut.getDateyyyy()));
                    if(ut.isYearBissextile(Integer.valueOf(ut.getDateyyyy())) == true){
                        d_date_last.setDate(ut.dateFormatInsert("29/02/" + ut.getDateyyyy()));
                    }else if(ut.isYearBissextile(Integer.valueOf(ut.getDateyyyy())) == false){
                        d_date_last.setDate(ut.dateFormatInsert("28/02/" + ut.getDateyyyy()));
                    }
            }else if(month.equals("03")){
                    d_date_first.setDate(ut.dateFormatInsert("01/03/" + ut.getDateyyyy()));
                    d_date_last.setDate(ut.dateFormatInsert("30/03/" + ut.getDateyyyy()));
            }else if(month.equals("04")){
                    d_date_first.setDate(ut.dateFormatInsert("01/04/" + ut.getDateyyyy()));
                    d_date_last.setDate(ut.dateFormatInsert("31/04/" + ut.getDateyyyy()));
            }else if(month.equals("05")){
                    d_date_first.setDate(ut.dateFormatInsert("01/05/" + ut.getDateyyyy()));
                    d_date_last.setDate(ut.dateFormatInsert("31/05/" + ut.getDateyyyy()));
            }else if(month.equals("06")){
                    d_date_first.setDate(ut.dateFormatInsert("01/06/" + ut.getDateyyyy()));
                    d_date_last.setDate(ut.dateFormatInsert("30/06/" + ut.getDateyyyy()));
            }else if(month.equals("07")){
                    d_date_first.setDate(ut.dateFormatInsert("01/07/" + ut.getDateyyyy()));
                    d_date_last.setDate(ut.dateFormatInsert("31/07/" + ut.getDateyyyy()));
            }else if(month.equals("08")){
                    d_date_first.setDate(ut.dateFormatInsert("01/08/" + ut.getDateyyyy()));
                    d_date_last.setDate(ut.dateFormatInsert("31/08/" + ut.getDateyyyy()));
            }else if(month.equals("09")){
                    d_date_first.setDate(ut.dateFormatInsert("01/09/" + ut.getDateyyyy()));
                    d_date_last.setDate(ut.dateFormatInsert("30/09/" + ut.getDateyyyy()));
            }else if(month.equals("10")){
                    d_date_first.setDate(ut.dateFormatInsert("01/10/" + ut.getDateyyyy()));
                    d_date_last.setDate(ut.dateFormatInsert("31/10/" + ut.getDateyyyy()));
            }else if(month.equals("11")){
                    d_date_first.setDate(ut.dateFormatInsert("01/11/" + ut.getDateyyyy()));
                    d_date_last.setDate(ut.dateFormatInsert("30/11/" + ut.getDateyyyy()));
            }else if(month.equals("12")){
                    d_date_first.setDate(ut.dateFormatInsert("01/12/" + ut.getDateyyyy()));
                    d_date_last.setDate(ut.dateFormatInsert("31/12/" + ut.getDateyyyy()));
            }
        } catch (ParseException ex) {
                Logger.getLogger(PaymentSearch.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    private void f_paymentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_paymentKeyReleased
        f_payment.setText(f_payment.getText().toUpperCase());
        tableModel.clear();
        listPayment.clear();
        List<PaymentModel> payment = new PaymentDAO().getPaymentByPagoA(String.valueOf(f_payment.getText().toUpperCase()), Long.valueOf(this.IdBusiness));
        for(PaymentModel u : payment) {
            try {
                String date_expiry = ut.dateFormatReturn(u.getDate_expiry());
                String id_truck = trucksDAO.getBoardTruckById(u.getId_truck());
                String valor = decimal.format(u.getValor()).replace(".", ",");
                listPayment.add(new PaymentTableModel(u.getId(), id_truck, u.getPayment(), u.getObservation(), date_expiry, valor, u.getIdentify(), u.getPaid()));
            } catch (ParseException ex) {
                Logger.getLogger(PaymentSearch.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        tableModel.setData(listPayment);
        t_payment.setModel(tableModel);
        modulateTablePayment();
    }//GEN-LAST:event_f_paymentKeyReleased

    private void b_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_saveActionPerformed
        this.dispose();
    }//GEN-LAST:event_b_saveActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

    }//GEN-LAST:event_formInternalFrameOpened

    private void rb_date_expiryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_date_expiryActionPerformed
        f_payment.setText("");
        f_payment.setEnabled(false);
        d_date_first.setDate(null);
        d_date_first.setEnabled(true);
        d_date_last.setDate(null);
        d_date_last.setEnabled(true);
        rb_payment.setSelected(false);
        rb_expiry.setSelected(false);
        d_date_first.grabFocus();
        tableModel.clear();
        listPayment.clear();
        t_payment.setModel(tableModel);
        setDate();
    }//GEN-LAST:event_rb_date_expiryActionPerformed

    private void rb_paymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_paymentActionPerformed
        d_date_first.setDate(null);
        d_date_first.setEnabled(false);
        d_date_last.setDate(null);
        d_date_last.setEnabled(false);
        f_payment.setText("");
        f_payment.setEnabled(true);
        rb_date_expiry.setSelected(false);
        rb_expiry.setSelected(false);
        f_payment.grabFocus();
        tableModel.clear();
        listPayment.clear();
        t_payment.setModel(tableModel);
    }//GEN-LAST:event_rb_paymentActionPerformed

    private void b_selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_selectActionPerformed
        if(t_payment.getSelectedRowCount() > 0){
            Object obj = t_payment.getValueAt(t_payment.getSelectedRow(),0);
            PaymentModel payment = new PaymentDAO().getPaymentByIdObj(Integer.valueOf(obj.toString()), Long.valueOf(this.IdBusiness));
            PaymentForm PaymentF = new PaymentForm();
            deskPane.add(PaymentF);
            PaymentF.payment = payment;
            PaymentF.IdBusiness = IdBusiness;
            PaymentF.dash = this.dash;
            PaymentF.setPayment();
            Centraliza.setCentro(PaymentF, deskPane, WIDTH, HEIGHT);
            PaymentF.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_b_selectActionPerformed

    private void t_paymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_paymentMouseClicked
        if(evt.getClickCount() > 1){
             java.awt.event.ActionEvent evtt = null;
             b_selectActionPerformed(evtt);
        }
    }//GEN-LAST:event_t_paymentMouseClicked

    private void rb_expiryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_expiryActionPerformed
        try {
            rb_expiry.setSelected(true);
            f_payment.setText("");
            f_payment.setEnabled(false);
            d_date_first.setDate(null);
            d_date_last.setDate(null);
            rb_date_expiry.setSelected(false);
            d_date_first.setEnabled(false);
            d_date_last.setEnabled(false);
            rb_payment.setSelected(false);

            tableModel.clear();
            listPayment.clear();
            Calendar c = GregorianCalendar.getInstance();
                        c.add(Calendar.DAY_OF_MONTH, -1);
            List<PaymentModel> payment = new PaymentDAO().getPaymentsExpiry(ut.dateFormatInsertSql(ut.dateFormatInsert(sdf.format(c.getTime()))),
                    Long.valueOf(this.IdBusiness));
            for(PaymentModel u : payment) {
                try {
                    String date_expiry = ut.dateFormatReturn(u.getDate_expiry());
                    String id_truck = trucksDAO.getBoardTruckById(u.getId_truck());
                    String valor = decimal.format(u.getValor()).replace(".", ",");
                    listPayment.add(new PaymentTableModel(u.getId(), id_truck, u.getPayment(), u.getObservation(), date_expiry, valor, u.getIdentify(), u.getPaid()));
                } catch (ParseException ex) {
                    Logger.getLogger(PaymentSearch.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            tableModel.setData(listPayment);
            t_payment.setModel(tableModel);
            modulateTablePayment();
        } catch (ParseException ex) {
            Logger.getLogger(PaymentSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rb_expiryActionPerformed

    private void b_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_searchActionPerformed
        f_payment.setText("");
        f_payment.setEnabled(false);
        d_date_first.setEnabled(true);
        d_date_last.setEnabled(true);
        rb_payment.setSelected(false);
        rb_expiry.setSelected(false);
        d_date_first.grabFocus();
        tableModel.clear();
        listPayment.clear();
        t_payment.setModel(tableModel);
        rb_date_expiry.setSelected(true);
        if(d_date_first.getDate() != null && d_date_first.getDate() != null){
            try {
                tableModel.clear();
                listPayment.clear();
                List<PaymentModel> payment = new PaymentDAO().getPaymentByDateExpiry(ut.dateFormatInsertSql(sdf.parse(sdf.format(d_date_first.getDate()))),
                        ut.dateFormatInsertSql(sdf.parse(sdf.format(d_date_last.getDate()))), Long.valueOf(this.IdBusiness));
                for(PaymentModel u : payment) {
                    try {
                        String date_expiry = ut.dateFormatReturn(u.getDate_expiry());
                        String id_truck = trucksDAO.getBoardTruckById(u.getId_truck());
                        String valor = decimal.format(u.getValor()).replace(".", ",");
                        listPayment.add(new PaymentTableModel(u.getId(), id_truck, u.getPayment(), u.getObservation(), date_expiry, valor, u.getIdentify(), u.getPaid()));
                    } catch (ParseException ex) {
                        Logger.getLogger(PaymentSearch.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                tableModel.setData(listPayment);
                t_payment.setModel(tableModel);
                modulateTablePayment();
            } catch (ParseException ex) {
                Logger.getLogger(PaymentSearch.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(d_date_first.getDate() == null || d_date_first.getDate() == null){
            JOptionPane.showMessageDialog(null, "Escolha uma data para continuar.", "CadoreSistemas", JOptionPane.INFORMATION_MESSAGE);
            setDate();
        }
    }//GEN-LAST:event_b_searchActionPerformed

    private void modulateTablePayment() {
        t_payment.getColumnModel().getColumn(0).setPreferredWidth(2);
        t_payment.getColumnModel().getColumn(1).setPreferredWidth(35);
        t_payment.getColumnModel().getColumn(2).setPreferredWidth(190);
        t_payment.getColumnModel().getColumn(3).setPreferredWidth(220);
        t_payment.getColumnModel().getColumn(4).setPreferredWidth(45);
        t_payment.getColumnModel().getColumn(5).setPreferredWidth(45);
        t_payment.getColumnModel().getColumn(6).setPreferredWidth(150);
        t_payment.getColumnModel().getColumn(7).setPreferredWidth(5);
        t_payment.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_save;
    private javax.swing.JButton b_search;
    private javax.swing.JButton b_select;
    private com.toedter.calendar.JDateChooser d_date_first;
    private com.toedter.calendar.JDateChooser d_date_last;
    private javax.swing.JTextField f_payment;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rb_date_expiry;
    private javax.swing.JRadioButton rb_expiry;
    private javax.swing.JRadioButton rb_payment;
    private javax.swing.JTable t_payment;
    // End of variables declaration//GEN-END:variables
}
