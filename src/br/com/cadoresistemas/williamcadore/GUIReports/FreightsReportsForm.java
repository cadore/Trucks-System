package br.com.cadoresistemas.williamcadore.GUIReports;

import br.com.cadoresistemas.williamcadore.ConnectioFactory.ConnectionFactory;
import br.com.cadoresistemas.williamcadore.DAO.BusinessDAO;
import br.com.cadoresistemas.williamcadore.DAO.TrucksDAO;
import br.com.cadoresistemas.williamcadore.DAOReports.FreightsReportsDAO;
import br.com.cadoresistemas.williamcadore.GUI.Dashboard;
import br.com.cadoresistemas.williamcadore.ModelsForm.FreightsModel;
import br.com.cadoresistemas.williamcadore.ModelsForm.FueledModel;
import br.com.cadoresistemas.williamcadore.Utils.Util;
import br.com.cadoresistemas.williamcadore.Utils.reports.ReportModel;
import java.io.InputStream;
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

public class FreightsReportsForm extends javax.swing.JInternalFrame {

    public FreightsReportsForm() {
        initComponents();
        l_obs.setText("");
        l_period.setText("");
        setDate();
        this.setFrameIcon(new ImageIcon(this.getClass().getResource("/Images/iconTruckSystem.jpg")));
    }

    public Dashboard dash = null;
    public String IdBusiness = null;
    public JDesktopPane  deskPane = null;
    private TrucksDAO trucksDAO = new TrucksDAO();
    private FreightsReportsDAO freightsReportsDAO = new FreightsReportsDAO();
    private BusinessDAO businessDAO = new BusinessDAO();
    private FreightsModel freights = new FreightsModel();
    private FueledModel fueled = new FueledModel();
    private Util ut = new Util();
    private SimpleDateFormat sdfBR = new SimpleDateFormat("dd/MM/yyyy");
    private SimpleDateFormat sdfUS = new SimpleDateFormat("yyyy-MM-dd");
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
        f_weight = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        f_medium_weight = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        f_value_t = new javax.swing.JTextField();
        f_medium_value_t = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        f_discount2 = new javax.swing.JTextField();
        f_medium_discount2 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        f_fueled = new javax.swing.JTextField();
        f_medium_fueled = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        f_total3 = new javax.swing.JTextField();
        f_medium_total3 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        f_total2 = new javax.swing.JTextField();
        f_medium_total2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        f_gross = new javax.swing.JTextField();
        f_medium_gross = new javax.swing.JTextField();
        l_obs = new javax.swing.JLabel();
        l_period = new javax.swing.JLabel();
        b_print = new javax.swing.JButton();
        b_send_mail = new javax.swing.JButton();
        b_exit = new javax.swing.JButton();

        setTitle("Relatório de Fretes");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Relatório de Fretes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 17, -1, -1));

        l_status.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        l_status.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(l_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(692, 17, -1, 22));

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
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 52, 700, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        f_qnt.setEditable(false);
        f_qnt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_qnt.setText("0");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Quantidade de Fretes:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Peso total:");

        f_weight.setEditable(false);
        f_weight.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_weight.setText("0,00");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Média dos valores");

        f_medium_weight.setEditable(false);
        f_medium_weight.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_medium_weight.setText("0,00");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Valores Totais");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Valor por Tonelada:");

        f_value_t.setEditable(false);
        f_value_t.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_value_t.setText("0,00");

        f_medium_value_t.setEditable(false);
        f_medium_value_t.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_medium_value_t.setText("0,00");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Despesas:");

        f_discount2.setEditable(false);
        f_discount2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_discount2.setText("0,00");

        f_medium_discount2.setEditable(false);
        f_medium_discount2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_medium_discount2.setText("0,00");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Abastecidas:");

        f_fueled.setEditable(false);
        f_fueled.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_fueled.setText("0,00");

        f_medium_fueled.setEditable(false);
        f_medium_fueled.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_medium_fueled.setText("0,00");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Total Liquido Frete:");

        f_total3.setEditable(false);
        f_total3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_total3.setText("0,00");

        f_medium_total3.setEditable(false);
        f_medium_total3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_medium_total3.setText("0,00");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Total Liq. Comição:");

        f_total2.setEditable(false);
        f_total2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_total2.setText("0,00");

        f_medium_total2.setEditable(false);
        f_medium_total2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_medium_total2.setText("0,00");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Total Bruto Frete:");

        f_gross.setEditable(false);
        f_gross.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_gross.setText("0,00");

        f_medium_gross.setEditable(false);
        f_medium_gross.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_medium_gross.setText("0,00");

        l_obs.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        l_obs.setForeground(new java.awt.Color(255, 0, 0));
        l_obs.setText("l_obs");

        l_period.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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

        b_send_mail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_send_mail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Mail.png"))); // NOI18N
        b_send_mail.setText("Enviar por email");
        b_send_mail.setEnabled(false);
        b_send_mail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_send_mailActionPerformed(evt);
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
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(l_period, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                                .addComponent(l_obs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel23))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(f_gross, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(f_medium_gross, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(f_qnt)
                                            .addComponent(f_weight)
                                            .addComponent(f_value_t)
                                            .addComponent(f_total3)
                                            .addComponent(f_discount2)
                                            .addComponent(f_fueled)
                                            .addComponent(f_total2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(f_medium_weight, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(f_medium_value_t)
                                            .addComponent(f_medium_total3)
                                            .addComponent(f_medium_discount2)
                                            .addComponent(f_medium_fueled)
                                            .addComponent(f_medium_total2))))))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b_send_mail, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(b_print, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(b_print, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_send_mail))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(l_period)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(l_obs, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(35, 35, 35)
                                .addComponent(f_medium_weight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel24)
                                    .addComponent(f_qnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(f_weight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(f_value_t, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(f_medium_value_t, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(f_gross, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(f_medium_gross, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(f_medium_discount2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(f_medium_fueled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(f_medium_total2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(f_discount2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(f_fueled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(f_total2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(f_total3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(f_medium_total3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 115, 700, -1));

        b_exit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Exit.png"))); // NOI18N
        b_exit.setText("Sair");
        b_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_exitActionPerformed(evt);
            }
        });
        getContentPane().add(b_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(613, 441, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generatorReport(int i){
        InputStream inputStream = getClass().getResourceAsStream("/br/com/cadoresistemas/williamcadore/Reports/FreightsFull.jasper");
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("ID_BUSINESS", Long.valueOf(this.IdBusiness));
        parametros.put("TRUCK", cb_truck.getSelectedItem());
        parametros.put("CORPORATE_NAME", businessDAO.getCorporate_NameBusinessById(Long.valueOf(this.IdBusiness)));
        parametros.put("DATE_FIRST", ut.dateFormatInsertSql(j_date_first.getDate()));
        parametros.put("DATE_LAST", ut.dateFormatInsertSql(j_date_last.getDate()));
        parametros.put("QNT", String.valueOf(f_qnt.getText()));
        parametros.put("WEIGHT", String.valueOf(f_weight.getText()));
        parametros.put("VALUE_T", String.valueOf(f_value_t.getText()));
        parametros.put("DISCOUNT_2", String.valueOf(f_discount2.getText()));
        parametros.put("FUELED", String.valueOf(f_fueled.getText()));
        parametros.put("TOTAL_2", String.valueOf(f_total2.getText()));
        parametros.put("GROSS", String.valueOf(f_gross.getText()));
        parametros.put("TOTAL_3", String.valueOf(f_total3.getText()));
        parametros.put("ID_TRUCK", Long.valueOf(trucksDAO.getIDTruck(String.valueOf(cb_truck.getSelectedItem()))));
        parametros.put("T_LITERS", String.valueOf(decimal.format(fueled.getLiters())));
        try {
            if(i == 0){
            ReportModel.openReport("CadoreSistemas | Relatório de Fretes", inputStream, parametros,
                         ConnectionFactory.getConnection(1));
            }else if(i == 1){
                new ReportModel().sendReportToMail(inputStream, parametros, "Fretes por Veiculo", dash);
            }
        } catch(JRException exc) {
            JOptionPane.showMessageDialog(null, "Atenção, houve um erro ao imprimir! Contate o Administrador do Sistema\n" + exc.getMessage(),
                "Cadore Sistemas", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setDate(){
        String month = ut.getDateMM();
        try {
            if(month.equals("01")){
                    j_date_first.setDate(ut.dateFormatInsert("01/01/" + ut.getDateyyyy()));
                    j_date_last.setDate(ut.dateFormatInsert("31/01/" + ut.getDateyyyy()));
            }else if(month.equals("02")){
                    j_date_first.setDate(ut.dateFormatInsert("01/02/" + ut.getDateyyyy()));
                    if(ut.isYearBissextile(Integer.valueOf(ut.getDateyyyy())) == true){
                        j_date_last.setDate(ut.dateFormatInsert("29/02/" + ut.getDateyyyy()));
                    }else if(ut.isYearBissextile(Integer.valueOf(ut.getDateyyyy())) == false){
                        j_date_last.setDate(ut.dateFormatInsert("28/02/" + ut.getDateyyyy()));
                    }
            }else if(month.equals("03")){
                    j_date_first.setDate(ut.dateFormatInsert("01/03/" + ut.getDateyyyy()));
                    j_date_last.setDate(ut.dateFormatInsert("30/03/" + ut.getDateyyyy()));
            }else if(month.equals("04")){
                    j_date_first.setDate(ut.dateFormatInsert("01/04/" + ut.getDateyyyy()));
                    j_date_last.setDate(ut.dateFormatInsert("31/04/" + ut.getDateyyyy()));
            }else if(month.equals("05")){
                    j_date_first.setDate(ut.dateFormatInsert("01/05/" + ut.getDateyyyy()));
                    j_date_last.setDate(ut.dateFormatInsert("31/05/" + ut.getDateyyyy()));
            }else if(month.equals("06")){
                    j_date_first.setDate(ut.dateFormatInsert("01/06/" + ut.getDateyyyy()));
                    j_date_last.setDate(ut.dateFormatInsert("30/06/" + ut.getDateyyyy()));
            }else if(month.equals("07")){
                    j_date_first.setDate(ut.dateFormatInsert("01/07/" + ut.getDateyyyy()));
                    j_date_last.setDate(ut.dateFormatInsert("31/07/" + ut.getDateyyyy()));
            }else if(month.equals("08")){
                    j_date_first.setDate(ut.dateFormatInsert("01/08/" + ut.getDateyyyy()));
                    j_date_last.setDate(ut.dateFormatInsert("31/08/" + ut.getDateyyyy()));
            }else if(month.equals("09")){
                    j_date_first.setDate(ut.dateFormatInsert("01/09/" + ut.getDateyyyy()));
                    j_date_last.setDate(ut.dateFormatInsert("30/09/" + ut.getDateyyyy()));
            }else if(month.equals("10")){
                    j_date_first.setDate(ut.dateFormatInsert("01/10/" + ut.getDateyyyy()));
                    j_date_last.setDate(ut.dateFormatInsert("31/10/" + ut.getDateyyyy()));
            }else if(month.equals("11")){
                    j_date_first.setDate(ut.dateFormatInsert("01/11/" + ut.getDateyyyy()));
                    j_date_last.setDate(ut.dateFormatInsert("30/11/" + ut.getDateyyyy()));
            }else if(month.equals("12")){
                    j_date_first.setDate(ut.dateFormatInsert("01/12/" + ut.getDateyyyy()));
                    j_date_last.setDate(ut.dateFormatInsert("31/12/" + ut.getDateyyyy()));
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
                Date first = sdfBR.parse(sdfBR.format(j_date_first.getDate()));
                Date last = sdfBR.parse(sdfBR.format(j_date_last.getDate()));
                long d = first.getTime() - last.getTime();
                String days = String.valueOf(d/1000/60/60/24).replace("-", "");
                if(first.getTime() > last.getTime()){
                    JOptionPane.showMessageDialog(rootPane, "A data inicial é maior que a data final.", "Relatórios | Cadore Sistemas", JOptionPane.WARNING_MESSAGE);
                }else{
                    Long truck = null;
                    if(!" -".equals(cb_truck.getSelectedItem())){
                       truck = Long.valueOf(trucksDAO.getIDTruck(String.valueOf(cb_truck.getSelectedItem())));
                    }else{
                        truck = Long.valueOf(0);
                    }
                    try {
                        freights = freightsReportsDAO.getReportsFreights((ut.dateFormatInsert(sdfBR.format(j_date_first.getDate()))),
                                (ut.dateFormatInsert(sdfBR.format(j_date_last.getDate()))),truck, Long.valueOf(this.IdBusiness));
                        fueled = freightsReportsDAO.getLitersFueledFreights((ut.dateFormatInsert(sdfBR.format(j_date_first.getDate()))),
                                (ut.dateFormatInsert(sdfBR.format(j_date_last.getDate()))),truck, Long.valueOf(this.IdBusiness));
                    } catch (ParseException ex) {
                        Logger.getLogger(FreightsReportsForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    int qnt = freights.getQnt();
                    f_qnt.setText(String.valueOf(freights.getQnt()));
                    f_weight.setText(String.valueOf(freights.getWeight()).replace(".", ","));
                    f_medium_weight.setText(decimal.format(freights.getWeight() / qnt).replace(".", ","));
                    f_value_t.setText(String.valueOf(freights.getValue_t()).replace(".", ","));
                    f_medium_value_t.setText(decimal.format(freights.getValue_t() / qnt).replace(".", ","));
                    f_discount2.setText(String.valueOf(freights.getDiscount2()).replace(".", ","));
                    f_medium_discount2.setText(decimal.format(freights.getDiscount2() / qnt).replace(".", ","));
                    f_fueled.setText(String.valueOf(freights.getFueled()).replace(".", ","));
                    f_medium_fueled.setText(decimal.format(freights.getFueled() / qnt).replace(".", ","));
                    f_total2.setText(String.valueOf(freights.getTotal2()).replace(".", ","));
                    f_medium_total2.setText(decimal.format(freights.getTotal2() / qnt).replace(".", ","));
                    f_gross.setText(String.valueOf(freights.getGross()).replace(".", ","));
                    f_medium_gross.setText(decimal.format(freights.getGross() / qnt).replace(".", ","));
                    f_total3.setText(String.valueOf(freights.getTotal3()).replace(".", ","));
                    f_medium_total3.setText(decimal.format(freights.getTotal3() / qnt).replace(".", ","));
                    l_obs.setText("OBS: Os valor abaixo são dados referentes aos períodos acima.");
                    l_period.setText("Período de: "+sdfBR.format(j_date_first.getDate())+" Até: "+sdfBR.format(j_date_last.getDate())+" Totalizando: "+days+" dias,"+"  Veiculo: "+cb_truck.getSelectedItem());
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(FreightsReportsForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(!"0".equals(f_qnt.getText())){
            b_print.setEnabled(true);
            b_send_mail.setEnabled(true);
        }           
    }//GEN-LAST:event_b_searchActionPerformed

    private void b_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_exitActionPerformed
        this.dispose();
    }//GEN-LAST:event_b_exitActionPerformed

    private void b_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_printActionPerformed
        b_print.setEnabled(false);
        b_send_mail.setEnabled(false);
        generatorReport(0);
    }//GEN-LAST:event_b_printActionPerformed

    private void b_send_mailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_send_mailActionPerformed
        b_print.setEnabled(false);
        b_send_mail.setEnabled(false);
        generatorReport(1);
    }//GEN-LAST:event_b_send_mailActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_exit;
    private javax.swing.JButton b_print;
    private javax.swing.JButton b_search;
    private javax.swing.JButton b_send_mail;
    private javax.swing.JComboBox cb_truck;
    private javax.swing.JTextField f_discount2;
    public javax.swing.JTextField f_fueled;
    private javax.swing.JTextField f_gross;
    private javax.swing.JTextField f_medium_discount2;
    public javax.swing.JTextField f_medium_fueled;
    private javax.swing.JTextField f_medium_gross;
    private javax.swing.JTextField f_medium_total2;
    private javax.swing.JTextField f_medium_total3;
    private javax.swing.JTextField f_medium_value_t;
    private javax.swing.JTextField f_medium_weight;
    private javax.swing.JTextField f_qnt;
    private javax.swing.JTextField f_total2;
    private javax.swing.JTextField f_total3;
    private javax.swing.JTextField f_value_t;
    private javax.swing.JTextField f_weight;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
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
