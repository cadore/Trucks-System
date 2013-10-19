package br.com.cadoresistemas.williamcadore.GUIReports;

import br.com.cadoresistemas.williamcadore.DAOReports.PaymentsReportsDAO;
import br.com.cadoresistemas.williamcadore.DAO.TrucksDAO;
import br.com.cadoresistemas.williamcadore.ModelsForm.PaymentModel;
import br.com.cadoresistemas.williamcadore.Utils.Util;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

public class PaymentsReportsForm extends javax.swing.JInternalFrame {

    public PaymentsReportsForm() {
        initComponents();
        l_obs.setText("");
        l_period.setText("");
        setDate();
        this.setFrameIcon(new ImageIcon(this.getClass().getResource("/Images/iconTruckSystem.jpg")));
        b_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Refresh.png")));
        b_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Print.png")));
        b_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Exit.png")));
    }

    public String IdBusiness = null;
    public JDesktopPane deskPane = null;
    private TrucksDAO trucksDAO = new TrucksDAO();
    private PaymentsReportsDAO paymentsReportsDAO = new PaymentsReportsDAO();
    private PaymentModel payments = new PaymentModel();
    private Util date = new Util();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private DecimalFormat decimal = new DecimalFormat("0.00");

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        l_status = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        j_date_first = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        j_date_last = new com.toedter.calendar.JDateChooser();
        b_search = new javax.swing.JButton();
        cb_truck = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        f_qnt = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        f_medium_value = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        f_value_paid = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        f_value_expiry = new javax.swing.JTextField();
        f_medium_value_paid = new javax.swing.JTextField();
        l_obs = new javax.swing.JLabel();
        l_period = new javax.swing.JLabel();
        b_print = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        f_qnt_paid = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        f_qnt_no_paid = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        f_qnt_expiry = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        f_value = new javax.swing.JTextField();
        f_medium_value_expiry = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        f_value_no_paid = new javax.swing.JTextField();
        f_medium_value_no_paid = new javax.swing.JTextField();
        b_exit = new javax.swing.JButton();

        setTitle("Relatório de Contas à Pagar");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Relatório de Contas à Pagar");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        l_status.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        l_status.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(l_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(619, 48, 9, 22));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Período de:");

        j_date_first.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Até:");

        j_date_last.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        b_search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_search.setText("Buscar");
        b_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_searchActionPerformed(evt);
            }
        });

        cb_truck.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Veículo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(j_date_first, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(11, 11, 11)
                .addComponent(j_date_last, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_truck, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_search)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(j_date_first, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)
                        .addComponent(j_date_last, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(b_search)
                        .addComponent(jLabel4)
                        .addComponent(cb_truck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 48, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        f_qnt.setEditable(false);
        f_qnt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_qnt.setText("0");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Quantidade Total:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 255));
        jLabel15.setText("Valor Contas Pagas:");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Média dos valores");

        f_medium_value.setEditable(false);
        f_medium_value.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_medium_value.setText("0,00");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Valores Totais");

        f_value_paid.setEditable(false);
        f_value_paid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_value_paid.setForeground(new java.awt.Color(0, 0, 255));
        f_value_paid.setText("0,00");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 0, 0));
        jLabel23.setText("Valor Contas Vencidas:");

        f_value_expiry.setEditable(false);
        f_value_expiry.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_value_expiry.setForeground(new java.awt.Color(255, 0, 0));
        f_value_expiry.setText("0,00");

        f_medium_value_paid.setEditable(false);
        f_medium_value_paid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_medium_value_paid.setForeground(new java.awt.Color(0, 0, 255));
        f_medium_value_paid.setText("0,00");

        l_obs.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        l_obs.setForeground(new java.awt.Color(255, 0, 0));
        l_obs.setText("l_obs");

        l_period.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        l_period.setText("l_period");

        b_print.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_print.setText("Imprimir");
        b_print.setEnabled(false);
        b_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_printActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setForeground(java.awt.Color.blue);
        jLabel25.setText("Quantidade de Contas Pagas:");

        f_qnt_paid.setEditable(false);
        f_qnt_paid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_qnt_paid.setForeground(java.awt.Color.blue);
        f_qnt_paid.setText("0");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 153, 0));
        jLabel28.setText("Quantidade de Contas Não Pagas:");

        f_qnt_no_paid.setEditable(false);
        f_qnt_no_paid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_qnt_no_paid.setForeground(new java.awt.Color(0, 153, 0));
        f_qnt_no_paid.setText("0");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 0, 0));
        jLabel29.setText("Quantidade de Contas Vencidas:");

        f_qnt_expiry.setEditable(false);
        f_qnt_expiry.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_qnt_expiry.setForeground(new java.awt.Color(255, 0, 0));
        f_qnt_expiry.setText("0");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Valor Total:");

        f_value.setEditable(false);
        f_value.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_value.setText("0,00");

        f_medium_value_expiry.setEditable(false);
        f_medium_value_expiry.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_medium_value_expiry.setForeground(new java.awt.Color(255, 0, 0));
        f_medium_value_expiry.setText("0,00");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 0));
        jLabel14.setText("Valor Contas Não Pagas:");

        f_value_no_paid.setEditable(false);
        f_value_no_paid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_value_no_paid.setForeground(new java.awt.Color(0, 153, 0));
        f_value_no_paid.setText("0,00");

        f_medium_value_no_paid.setEditable(false);
        f_medium_value_no_paid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_medium_value_no_paid.setForeground(new java.awt.Color(0, 153, 0));
        f_medium_value_no_paid.setText("0,00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(l_obs, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(l_period, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_print, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel14)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel29)
                            .addComponent(jLabel28)
                            .addComponent(jLabel25)
                            .addComponent(jLabel23))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(f_value_paid, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(f_qnt, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(f_qnt_paid, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(f_qnt_no_paid, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(f_qnt_expiry, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(f_value_expiry, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(f_value, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(2, 2, 2)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(2, 2, 2)
                                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(f_value_no_paid, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(f_medium_value_expiry, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(f_medium_value, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(f_medium_value_no_paid, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(f_medium_value_paid, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(jLabel26)))))))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_period)
                    .addComponent(b_print, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(l_obs, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(f_qnt_paid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(f_qnt_no_paid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(f_qnt_expiry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel24))
                    .addComponent(f_qnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(f_value_paid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f_medium_value_paid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(f_value_no_paid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f_medium_value_no_paid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(f_value_expiry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(f_value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(f_medium_value_expiry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(f_medium_value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 599, -1));

        b_exit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_exit.setText("Sair");
        b_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_exitActionPerformed(evt);
            }
        });
        getContentPane().add(b_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 434, 98, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setDate(){
        String month = date.getDateMM();
        try {
            if(month.equals("01")){
                    j_date_first.setDate(date.dateFormatInsert("01/01/" + date.getDateyyyy()));
                    j_date_last.setDate(date.dateFormatInsert("31/01/" + date.getDateyyyy()));
            }else if(month.equals("02")){
                    j_date_first.setDate(date.dateFormatInsert("01/02/" + date.getDateyyyy()));
                    if(date.isYearBissextile(Integer.valueOf(date.getDateyyyy())) == true){
                        j_date_last.setDate(date.dateFormatInsert("29/02/" + date.getDateyyyy()));
                    }else if(date.isYearBissextile(Integer.valueOf(date.getDateyyyy())) == false){
                        j_date_last.setDate(date.dateFormatInsert("28/02/" + date.getDateyyyy()));
                    }
            }else if(month.equals("03")){
                    j_date_first.setDate(date.dateFormatInsert("01/03/" + date.getDateyyyy()));
                    j_date_last.setDate(date.dateFormatInsert("30/03/" + date.getDateyyyy()));
            }else if(month.equals("04")){
                    j_date_first.setDate(date.dateFormatInsert("01/04/" + date.getDateyyyy()));
                    j_date_last.setDate(date.dateFormatInsert("31/04/" + date.getDateyyyy()));
            }else if(month.equals("05")){
                    j_date_first.setDate(date.dateFormatInsert("01/05/" + date.getDateyyyy()));
                    j_date_last.setDate(date.dateFormatInsert("31/05/" + date.getDateyyyy()));
            }else if(month.equals("06")){
                    j_date_first.setDate(date.dateFormatInsert("01/06/" + date.getDateyyyy()));
                    j_date_last.setDate(date.dateFormatInsert("30/06/" + date.getDateyyyy()));
            }else if(month.equals("07")){
                    j_date_first.setDate(date.dateFormatInsert("01/07/" + date.getDateyyyy()));
                    j_date_last.setDate(date.dateFormatInsert("31/07/" + date.getDateyyyy()));
            }else if(month.equals("08")){
                    j_date_first.setDate(date.dateFormatInsert("01/08/" + date.getDateyyyy()));
                    j_date_last.setDate(date.dateFormatInsert("31/08/" + date.getDateyyyy()));
            }else if(month.equals("09")){
                    j_date_first.setDate(date.dateFormatInsert("01/09/" + date.getDateyyyy()));
                    j_date_last.setDate(date.dateFormatInsert("30/09/" + date.getDateyyyy()));
            }else if(month.equals("10")){
                    j_date_first.setDate(date.dateFormatInsert("01/10/" + date.getDateyyyy()));
                    j_date_last.setDate(date.dateFormatInsert("31/10/" + date.getDateyyyy()));
            }else if(month.equals("11")){
                    j_date_first.setDate(date.dateFormatInsert("01/11/" + date.getDateyyyy()));
                    j_date_last.setDate(date.dateFormatInsert("30/11/" + date.getDateyyyy()));
            }else if(month.equals("12")){
                    j_date_first.setDate(date.dateFormatInsert("01/12/" + date.getDateyyyy()));
                    j_date_last.setDate(date.dateFormatInsert("31/12/" + date.getDateyyyy()));
            }
        } catch (ParseException ex) {
                Logger.getLogger(FreightsReportsForm.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public void loadTrucks(){
        cb_truck.removeAllItems(); //remove os itens atuais do comboBox.
        cb_truck.addItem(" -");
        ArrayList tractions = trucksDAO.findAll(Long.valueOf(this.IdBusiness)); //'produtoDAO' é meu objeto que retorna os produtos do banco.
        Iterator i = tractions.iterator();

        while(i.hasNext()) {
           cb_truck.addItem(i.next());
        }
    }
    private void b_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_searchActionPerformed
        try {
            if(j_date_first.getDate() == null || j_date_last.getDate() == null){
                JOptionPane.showMessageDialog(rootPane, "Preencha as duas Datas para continuar.", "Relatórios | Cadore Sistemas", JOptionPane.WARNING_MESSAGE);
            }else{
                Date first = sdf.parse(sdf.format(j_date_first.getDate()));
                Date last = sdf.parse(sdf.format(j_date_last.getDate()));
                long d = first.getTime() - last.getTime();
                String days = String.valueOf(d/1000/60/60/24).replace("-", "");
                if(first.getTime() > last.getTime()){
                    JOptionPane.showMessageDialog(rootPane, "A data inicial é maior que a data final.", "Relatórios | Cadore Sistemas", JOptionPane.WARNING_MESSAGE);
                }else{
                    Long id_truck = Long.valueOf(0);
                    if(!" -".equals(cb_truck.getSelectedItem())){
                       id_truck = Long.valueOf(trucksDAO.getIDTruck(String.valueOf(cb_truck.getSelectedItem())));
                    }else{
                        id_truck = Long.valueOf(0);
                    }
                    payments = paymentsReportsDAO.getReportsPayments3(first, last, id_truck, Long.valueOf(this.IdBusiness));
                    int qnt_paid = payments.getQnt_paid();
                    f_qnt_paid.setText(String.valueOf(qnt_paid));
                    f_value_paid.setText(String.valueOf(payments.getValor_paid()).replace(".", ","));
                    f_medium_value_paid.setText(decimal.format(payments.getValor_paid() / qnt_paid).replace(".", ","));

                    payments = paymentsReportsDAO.getReportsPayments2(first, last, id_truck, Long.valueOf(this.IdBusiness));
                    int qnt_no_paid = payments.getQnt_no_paid();
                    f_qnt_no_paid.setText(String.valueOf(qnt_no_paid));
                    f_value_no_paid.setText(String.valueOf(payments.getValor_no_paid()).replace(".", ","));
                    f_medium_value_no_paid.setText(decimal.format(payments.getValor_no_paid() / qnt_no_paid).replace(".", ","));

                    payments = paymentsReportsDAO.getReportsPayments4(first, last, id_truck, Long.valueOf(this.IdBusiness));
                    int qnt_expiry = payments.getQnt_expiry();
                    f_qnt_expiry.setText(String.valueOf(qnt_expiry));
                    f_value_expiry.setText(String.valueOf(payments.getValor_expiry()).replace(".", ","));
                    f_medium_value_expiry.setText(decimal.format(payments.getValor_expiry() / qnt_expiry).replace(".", ","));

                    payments = paymentsReportsDAO.getReportsPayments(first, last, id_truck, Long.valueOf(this.IdBusiness));
                    int qnt = payments.getQnt();
                    f_qnt.setText(String.valueOf(qnt));
                    f_value.setText(String.valueOf(payments.getValor()).replace(".", ","));
                    f_medium_value.setText(decimal.format(payments.getValor() / qnt).replace(".", ","));

                    l_obs.setText("OBS: Os valor abaixo são dados referentes aos períodos acima.");
                    l_period.setText("Período de: "+sdf.format(j_date_first.getDate())+" Até: "+sdf.format(j_date_last.getDate())+" Totalizando: "+days+" dias,"+"  Veiculo: "+cb_truck.getSelectedItem());
                 }
            }
        } catch (ParseException ex) {
            Logger.getLogger(PaymentsReportsForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(!"0".equals(f_qnt.getText())){
            b_print.setEnabled(true);
        }
    }//GEN-LAST:event_b_searchActionPerformed

    private void b_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_exitActionPerformed
        this.dispose();
    }//GEN-LAST:event_b_exitActionPerformed

    private void b_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_printActionPerformed
        b_print.setEnabled(false);
        JOptionPane.showMessageDialog(rootPane, "Propriedades de impressão ainda não configuradas.", "Relatórios | Cadore Sistemas", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_b_printActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_exit;
    private javax.swing.JButton b_print;
    private javax.swing.JButton b_search;
    private javax.swing.JComboBox cb_truck;
    private javax.swing.JTextField f_medium_value;
    private javax.swing.JTextField f_medium_value_expiry;
    private javax.swing.JTextField f_medium_value_no_paid;
    private javax.swing.JTextField f_medium_value_paid;
    private javax.swing.JTextField f_qnt;
    private javax.swing.JTextField f_qnt_expiry;
    private javax.swing.JTextField f_qnt_no_paid;
    private javax.swing.JTextField f_qnt_paid;
    private javax.swing.JTextField f_value;
    private javax.swing.JTextField f_value_expiry;
    private javax.swing.JTextField f_value_no_paid;
    private javax.swing.JTextField f_value_paid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.toedter.calendar.JDateChooser j_date_first;
    private com.toedter.calendar.JDateChooser j_date_last;
    private javax.swing.JLabel l_obs;
    private javax.swing.JLabel l_period;
    private javax.swing.JLabel l_status;
    // End of variables declaration//GEN-END:variables
}
