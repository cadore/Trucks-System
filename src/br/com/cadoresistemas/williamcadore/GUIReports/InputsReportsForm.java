package br.com.cadoresistemas.williamcadore.GUIReports;

import br.com.cadoresistemas.williamcadore.DAOReports.InputsReportsDAO;
import br.com.cadoresistemas.williamcadore.DAO.TrucksDAO;
import br.com.cadoresistemas.williamcadore.ModelsForm.InputsModel;
import br.com.cadoresistemas.williamcadore.Utils.reports.ReportModel;
import br.com.cadoresistemas.williamcadore.Utils.Util;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import br.com.cadoresistemas.williamcadore.ConnectioFactory.ConnectionFactory;

public class InputsReportsForm extends javax.swing.JInternalFrame {

    public InputsReportsForm() {
        initComponents();
        l_obs.setText("");
        l_period.setText("");
        setDate();
        this.setFrameIcon(new ImageIcon(this.getClass().getResource("/Images/iconTruckSystem.jpg")));
    }

    public String IdBusiness = null;
    public JDesktopPane deskPane = null;
    private TrucksDAO trucksDAO = new TrucksDAO();
    private InputsReportsDAO inputsReportsDAO = new InputsReportsDAO();
    private InputsModel inputs = new InputsModel();
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
        f_value1 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        f_medium_value1 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        f_value2 = new javax.swing.JTextField();
        f_medium_value2 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        f_value3 = new javax.swing.JTextField();
        f_medium_value3 = new javax.swing.JTextField();
        l_obs = new javax.swing.JLabel();
        l_period = new javax.swing.JLabel();
        b_print = new javax.swing.JButton();
        b_exit = new javax.swing.JButton();

        setTitle("Relatório de Entradas");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Relatório de Entradas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        l_status.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        l_status.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(l_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(632, 48, -1, 22));

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(j_date_first, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)
                        .addComponent(j_date_last, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(b_search)
                        .addComponent(jLabel4)
                        .addComponent(cb_truck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 48, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        f_qnt.setEditable(false);
        f_qnt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_qnt.setText("0");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Quantidade de Entradas:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Valores em Dinheiro:");

        f_value1.setEditable(false);
        f_value1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_value1.setText("0,00");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Média dos valores");

        f_medium_value1.setEditable(false);
        f_medium_value1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_medium_value1.setText("0,00");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Valores Totais");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Valor em Discontos:");

        f_value2.setEditable(false);
        f_value2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_value2.setText("0,00");

        f_medium_value2.setEditable(false);
        f_medium_value2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_medium_value2.setText("0,00");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Valor Total:");

        f_value3.setEditable(false);
        f_value3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_value3.setText("0,00");

        f_medium_value3.setEditable(false);
        f_medium_value3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_medium_value3.setText("0,00");

        l_obs.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        l_obs.setForeground(new java.awt.Color(255, 0, 0));
        l_obs.setText("l_obs");

        l_period.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        l_period.setText("l_period");

        b_print.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Print.png"))); // NOI18N
        b_print.setText("Imprimir");
        b_print.setEnabled(false);
        b_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_printActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_obs, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(l_period, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b_print)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel14)
                            .addComponent(jLabel23)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                            .addComponent(f_qnt)
                            .addComponent(f_value1)
                            .addComponent(f_value2)
                            .addComponent(f_value3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(f_medium_value1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(f_medium_value2)
                            .addComponent(f_medium_value3))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_period)
                    .addComponent(b_print, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(l_obs, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(35, 35, 35)
                        .addComponent(f_medium_value1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(f_qnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(f_value1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(f_value2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f_medium_value2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(f_value3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f_medium_value3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 106, -1, -1));

        b_exit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Exit.png"))); // NOI18N
        b_exit.setText("Sair");
        b_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_exitActionPerformed(evt);
            }
        });
        getContentPane().add(b_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(509, 324, 109, -1));

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
                    Long truck = Long.valueOf(0);
                    if(!" -".equals(cb_truck.getSelectedItem())){
                       truck = Long.valueOf(trucksDAO.getIDTruck(String.valueOf(cb_truck.getSelectedItem())));
                    }else{
                        truck = Long.valueOf(0);
                    }
                        inputs = inputsReportsDAO.getReportsInputs((date.dateFormatInsert(sdf.format(j_date_first.getDate()))),
                                (date.dateFormatInsert(sdf.format(j_date_last.getDate()))),truck, Long.valueOf(this.IdBusiness));

                    int qnt = inputs.getQnt();
                    f_qnt.setText(String.valueOf(qnt));
                    f_value1.setText(String.valueOf(inputs.getValue1()).replace(".", ","));
                    f_medium_value1.setText(decimal.format(inputs.getValue1() / qnt).replace(".", ","));
                    f_value2.setText(String.valueOf(inputs.getValue2()).replace(".", ","));
                    f_medium_value2.setText(decimal.format(inputs.getValue2() / qnt).replace(".", ","));
                    f_value3.setText(String.valueOf(inputs.getValue3()).replace(".", ","));
                    f_medium_value3.setText(decimal.format(inputs.getValue3() / qnt).replace(".", ","));

                    l_obs.setText("OBS: Os valor abaixo são dados referentes aos períodos acima.");
                    l_period.setText("Período de: "+sdf.format(j_date_first.getDate())+" Até: "+sdf.format(j_date_last.getDate())+" Totalizando: "+days+" dias,"+"  Veiculo: "+cb_truck.getSelectedItem());
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(InputsReportsForm.class.getName()).log(Level.SEVERE, null, ex);
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
        InputStream inputStream = getClass().getResourceAsStream("/br/com/cadoresistemas/williamcadore/Reports/InputsFull.jasper");
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("ID_BUSINESS", Long.valueOf(this.IdBusiness));
        parametros.put("TRUCK", cb_truck.getSelectedItem());
        parametros.put("DATE_FIRST", date.dateFormatInsertSql(j_date_first.getDate()));
        parametros.put("DATE_LAST", date.dateFormatInsertSql(j_date_last.getDate()));
        parametros.put("ID_TRUCK", Long.valueOf(trucksDAO.getIDTruck(String.valueOf(cb_truck.getSelectedItem()))));
        parametros.put("VALOR_TOTAL", String.valueOf(f_value3.getText()));
        try {
                ReportModel.openReport("CadoreSistemas | Relatório de Entradas Avulsas", inputStream, parametros,
                           ConnectionFactory.getConnection(1));
                } catch ( JRException exc ) {
                    JOptionPane.showMessageDialog(null, "Atenção, houve um erro ao imprimir! Contate o Administrador do Sistema\n" + exc.getMessage(),
                        "Cadore Sistemas", JOptionPane.ERROR_MESSAGE);
                }
    }//GEN-LAST:event_b_printActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_exit;
    private javax.swing.JButton b_print;
    private javax.swing.JButton b_search;
    private javax.swing.JComboBox cb_truck;
    private javax.swing.JTextField f_medium_value1;
    private javax.swing.JTextField f_medium_value2;
    private javax.swing.JTextField f_medium_value3;
    private javax.swing.JTextField f_qnt;
    private javax.swing.JTextField f_value1;
    private javax.swing.JTextField f_value2;
    private javax.swing.JTextField f_value3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
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
