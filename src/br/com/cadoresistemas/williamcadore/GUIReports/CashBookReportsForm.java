package br.com.cadoresistemas.williamcadore.GUIReports;

import br.com.cadoresistemas.williamcadore.DAOReports.CashBookReportsDAO;
import br.com.cadoresistemas.williamcadore.ModelsForm.FreightsModel;
import br.com.cadoresistemas.williamcadore.ModelsForm.InputsModel;
import br.com.cadoresistemas.williamcadore.ModelsForm.OutputsModel;
import br.com.cadoresistemas.williamcadore.ModelsForm.PaymentModel;
import br.com.cadoresistemas.williamcadore.Utils.reports.ReportModel;
import br.com.cadoresistemas.williamcadore.Utils.Util;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import br.com.cadoresistemas.williamcadore.ConnectioFactory.ConnectionFactory;

public class CashBookReportsForm extends javax.swing.JInternalFrame {

    public CashBookReportsForm() {
        initComponents();
        l_obs.setText("");
        l_period.setText("");
        setDate();
        ck_cashbook_full.setSelected(false);
        ck_payments.setSelected(true);
        j_date_first.setEnabled(true);
        j_date_last.setEnabled(true);
        this.setFrameIcon(new ImageIcon(this.getClass().getResource("/Images/iconTruckSystem.jpg")));
    }

    public String IdBusiness = null;
    public JDesktopPane deskPane = null;
    private CashBookReportsDAO cashbookReportsDAO = new CashBookReportsDAO();
    private PaymentModel payments = new PaymentModel();
    private FreightsModel freights = new FreightsModel();
    private OutputsModel outputs = new OutputsModel();
    private InputsModel inputs = new InputsModel();
    private Util date = new Util();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private DecimalFormat decimal = new DecimalFormat("0.00");
    private String status_ck = "period";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        j_date_first = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        j_date_last = new com.toedter.calendar.JDateChooser();
        b_search = new javax.swing.JButton();
        ck_cashbook_full = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        l_obs = new javax.swing.JLabel();
        l_period = new javax.swing.JLabel();
        b_print = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        f_outputs = new javax.swing.JTextField();
        f_inputs = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        f_payments = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        f_liq_freights = new javax.swing.JTextField();
        ck_payments = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        f_liq_cashbook = new javax.swing.JTextField();
        b_exit = new javax.swing.JButton();

        setTitle("Relatório de Caixa");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Relatório de Caixa");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Período de:");

        j_date_first.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Até:");

        j_date_last.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        b_search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Refresh.png"))); // NOI18N
        b_search.setText("Buscar");
        b_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_searchActionPerformed(evt);
            }
        });

        ck_cashbook_full.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ck_cashbook_full.setText("Caixa completo");
        ck_cashbook_full.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ck_cashbook_fullActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ck_cashbook_full)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(j_date_first, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(11, 11, 11)
                .addComponent(j_date_last, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(ck_cashbook_full))
                    .addComponent(j_date_first, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)
                        .addComponent(j_date_last, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(b_search)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        l_obs.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        l_obs.setForeground(new java.awt.Color(255, 0, 0));
        l_obs.setText("l_obs");

        l_period.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        l_period.setText("l_period");

        b_print.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Print.png"))); // NOI18N
        b_print.setText("Imprimir");
        b_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_printActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Despesas:");

        f_outputs.setEditable(false);
        f_outputs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_outputs.setText("0,00");

        f_inputs.setEditable(false);
        f_inputs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_inputs.setText("0,00");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Entradas:");

        f_payments.setEditable(false);
        f_payments.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_payments.setText("0,00");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Pagamentos:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Liq. Fretes:");

        f_liq_freights.setEditable(false);
        f_liq_freights.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_liq_freights.setText("0,00");

        ck_payments.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ck_payments.setText("Contabilizar pagamentos");
        ck_payments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ck_paymentsActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Total liquido do caixa:");

        f_liq_cashbook.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_liq_cashbook.setText("0,00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(l_obs, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l_period, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_print))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(f_liq_freights, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(f_outputs, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(ck_payments))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(f_inputs, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(f_payments, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(f_liq_cashbook, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l_period)
                    .addComponent(b_print, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(l_obs, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(f_payments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(f_liq_cashbook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ck_payments)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(f_outputs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(f_inputs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(f_liq_freights, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        b_exit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Exit.png"))); // NOI18N
        b_exit.setText("Sair");
        b_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(b_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

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

    private void calculatorCashBook(){
        double liq_cashbook = 0;
        if(ck_payments.isSelected() == true){
            liq_cashbook = freights.getTotal3() + inputs.getValue3() - outputs.getValue3() - payments.getValor();
        }else if(ck_payments.isSelected() == false){
            liq_cashbook = freights.getTotal3() + inputs.getValue3() - outputs.getValue3();
        }
        f_liq_cashbook.setText("R$: "+decimal.format(liq_cashbook).replace(".", ","));
        f_payments.setText("R$: "+decimal.format(payments.getValor()).replace(".", ","));
        f_outputs.setText("R$: "+decimal.format(outputs.getValue3()).replace(".", ","));
        f_inputs.setText("R$: "+decimal.format(inputs.getValue3()).replace(".", ","));
        f_liq_freights.setText("R$: "+decimal.format(freights.getTotal3()).replace(".", ","));
    }

    public void search(){
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
                    if("full".equals(status_ck)){
                        payments = cashbookReportsDAO.getReportsPaymentsFull(Long.valueOf(this.IdBusiness));
                        freights = cashbookReportsDAO.getReportsFreightsFull(Long.valueOf(this.IdBusiness));
                        outputs = cashbookReportsDAO.getReportsOutputsFull(Long.valueOf(this.IdBusiness));
                        inputs = cashbookReportsDAO.getReportsInputsFull(Long.valueOf(this.IdBusiness));
                        l_period.setText("Caixa Completo");
                        l_obs.setText("");
                        calculatorCashBook();
                    }else if("period".equals(status_ck)){
                        payments = cashbookReportsDAO.getReportsPaymentsPeriod(first, last, Long.valueOf(this.IdBusiness));
                        freights = cashbookReportsDAO.getReportsFreightsPeriod(first, last, Long.valueOf(this.IdBusiness));
                        outputs = cashbookReportsDAO.getReportsOutputsPeriod(first, last, Long.valueOf(this.IdBusiness));
                        inputs = cashbookReportsDAO.getReportsInputsPeriod(first, last, Long.valueOf(this.IdBusiness));
                        l_period.setText("Período de: "+sdf.format(j_date_first.getDate())+" até: "+sdf.format(j_date_last.getDate())+" Totalizando: "+days+" dia(s).");
                        l_obs.setText("OBS: Os valor abaixo são dados referentes aos períodos acima.");
                        calculatorCashBook();
                    }
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(CashBookReportsForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void b_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_searchActionPerformed
        search();
        b_print.setEnabled(true);
    }//GEN-LAST:event_b_searchActionPerformed

    private void b_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_exitActionPerformed
        this.dispose();
    }//GEN-LAST:event_b_exitActionPerformed

    private void b_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_printActionPerformed
        String observation = null;
        Double n_status_cashbook = Double.valueOf(f_liq_cashbook.getText().replace(" ", "").replace("R$:", "").replace(",", "."));
        String status_cashbook = null;
        if(ck_payments.isSelected() == true){
            observation = "Atenção: Pagamentos contabilizados junto ao caixa.";
        }else if(ck_payments.isSelected() == false){
            observation = "Atenção: Pagamentos NÃO contabilizados junto ao caixa.";
        }
        if(n_status_cashbook >= 0){
            status_cashbook = "";
        }else if(n_status_cashbook <= 0){
            status_cashbook = "Caixa negativo.";
        }
        InputStream inputStream = getClass().getResourceAsStream("/br/com/cadoresistemas/williamcadore/Reports/CashBook.jasper");
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("ID_BUSINESS", Long.valueOf(this.IdBusiness));
        parametros.put("PERIOD", l_period.getText());
        parametros.put("OUTPUTS", f_outputs.getText());
        parametros.put("INPUTS", f_inputs.getText());
        parametros.put("PAYMENTS", f_payments.getText());
        parametros.put("FREIGHTS", f_liq_freights.getText());
        parametros.put("VALUE_TOTAL", f_liq_cashbook.getText());
        parametros.put("OBSERVATION", observation);
        parametros.put("STATUS_CASHBOOK", status_cashbook);
        try {
            ReportModel.openReport("CadoreSistemas | Relatório de Caixa", inputStream, parametros,
                     ConnectionFactory.getConnection(1));
        } catch ( JRException exc ) {
            JOptionPane.showMessageDialog(null, "Atenção, houve um erro ao imprimir! Contate o Administrador do Sistema\n" + exc.getMessage(),
                "Cadore Sistemas", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_b_printActionPerformed

    private void ck_cashbook_fullActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ck_cashbook_fullActionPerformed
        this.setDate();
        if(ck_cashbook_full.isSelected() == true){
            j_date_first.setEnabled(false);
            j_date_last.setEnabled(false);
            status_ck = "full";
        }else if(ck_cashbook_full.isSelected() == false){
            j_date_first.setEnabled(true);
            j_date_last.setEnabled(true);
            status_ck = "period";
        }
    }//GEN-LAST:event_ck_cashbook_fullActionPerformed

    private void ck_paymentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ck_paymentsActionPerformed
        calculatorCashBook();
    }//GEN-LAST:event_ck_paymentsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_exit;
    private javax.swing.JButton b_print;
    private javax.swing.JButton b_search;
    private javax.swing.JCheckBox ck_cashbook_full;
    private javax.swing.JCheckBox ck_payments;
    private javax.swing.JTextField f_inputs;
    private javax.swing.JTextField f_liq_cashbook;
    private javax.swing.JTextField f_liq_freights;
    private javax.swing.JTextField f_outputs;
    private javax.swing.JTextField f_payments;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.toedter.calendar.JDateChooser j_date_first;
    private com.toedter.calendar.JDateChooser j_date_last;
    private javax.swing.JLabel l_obs;
    private javax.swing.JLabel l_period;
    // End of variables declaration//GEN-END:variables
}
