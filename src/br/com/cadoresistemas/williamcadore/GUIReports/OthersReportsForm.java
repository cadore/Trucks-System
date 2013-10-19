package br.com.cadoresistemas.williamcadore.GUIReports;

import br.com.cadoresistemas.williamcadore.ConnectioFactory.ConnectionFactory;
import br.com.cadoresistemas.williamcadore.DAOReports.OthersReportsDAO;
import br.com.cadoresistemas.williamcadore.ModelsForm.OthersModel;
import br.com.cadoresistemas.williamcadore.Utils.reports.ReportModel;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;

public class OthersReportsForm extends javax.swing.JInternalFrame {

    public OthersReportsForm() {
        initComponents();
        this.setFrameIcon(new ImageIcon(this.getClass().getResource("/Images/iconTruckSystem.jpg")));
        b_print1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Print.png")));
        b_print2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Print.png")));
        b_print3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Print.png")));
    }

    public String IdBusiness = null;
    public JDesktopPane deskPane = null;
    private OthersReportsDAO paymentsReportsDAO = new OthersReportsDAO();
    private OthersModel others = new OthersModel();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        l_status = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        f_qnt_users = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        b_print2 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        f_qnt_drivers = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        f_qnt_trucks = new javax.swing.JTextField();
        b_print3 = new javax.swing.JButton();
        b_print1 = new javax.swing.JButton();
        b_exit = new javax.swing.JButton();

        setTitle("Relatório de Outros");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Relatório de Outros");

        l_status.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        l_status.setForeground(new java.awt.Color(255, 0, 0));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        f_qnt_users.setEditable(false);
        f_qnt_users.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_qnt_users.setText("0");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Usuários:");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Valores Totais");

        b_print2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_print2.setText("Imprimir");
        b_print2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_print2ActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setText("Motoristas:");

        f_qnt_drivers.setEditable(false);
        f_qnt_drivers.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_qnt_drivers.setText("0");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("Veículos:");

        f_qnt_trucks.setEditable(false);
        f_qnt_trucks.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_qnt_trucks.setText("0");

        b_print3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_print3.setText("Imprimir");
        b_print3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_print3ActionPerformed(evt);
            }
        });

        b_print1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_print1.setText("Imprimir");
        b_print1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_print1ActionPerformed(evt);
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
                            .addComponent(jLabel24)
                            .addComponent(jLabel30))
                        .addGap(83, 83, 83)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(f_qnt_drivers, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b_print2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(f_qnt_users, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b_print1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(f_qnt_trucks, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b_print3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jLabel31))
                .addGap(0, 40, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(f_qnt_users, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(b_print1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(f_qnt_drivers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(b_print2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(f_qnt_trucks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(b_print3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        b_exit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(l_status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l_status, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(b_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setOthers(){
        others = paymentsReportsDAO.getReportsOthersUsers(Long.valueOf(this.IdBusiness));
        f_qnt_users.setText(String.valueOf(others.getA()));
        others = paymentsReportsDAO.getReportsOthersTrucks(Long.valueOf(this.IdBusiness));
        f_qnt_trucks.setText(String.valueOf(others.getB()));
        others = paymentsReportsDAO.getReportsOthersDrivers(Long.valueOf(this.IdBusiness));
        f_qnt_drivers.setText(String.valueOf(others.getC()));

        if("0".equals(f_qnt_users.getText())){
            b_print1.setEnabled(false);
        }
        if("0".equals(f_qnt_drivers.getText())){
            b_print2.setEnabled(false);
        }
        if("0".equals(f_qnt_trucks.getText())){
            b_print3.setEnabled(false);
        }
    }

    private void b_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_exitActionPerformed
        this.dispose();
    }//GEN-LAST:event_b_exitActionPerformed

    private void b_print2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_print2ActionPerformed
        InputStream inputStream = getClass().getResourceAsStream("/br/com/cadoresistemas/williamcadore/Reports/Drivers.jasper");
                Map<String, Object> parametros = new HashMap<>();
                parametros.put("ID_BUSINESS", Long.valueOf(IdBusiness));
                try {
                        ReportModel.openReport("CadoreSistemas | Relatório de Motoristas", inputStream, parametros,
                                     ConnectionFactory.getConnection(1));
                } catch ( JRException exc ) {
                    JOptionPane.showMessageDialog(null, "Atenção, houve um erro ao imprimir! Contate o Administrador do Sistema\n" + exc.getMessage(),
                        "Cadore Sistemas", JOptionPane.ERROR_MESSAGE);
                }
    }//GEN-LAST:event_b_print2ActionPerformed

    private void b_print3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_print3ActionPerformed
                InputStream inputStream = getClass().getResourceAsStream("/br/com/cadoresistemas/williamcadore/Reports/Trucks.jasper");
                Map<String, Object> parametros = new HashMap<>();
                parametros.put("ID_BUSINESS", Long.valueOf(IdBusiness));
                try {
                        ReportModel.openReport("CadoreSistemas | Relatório de Veículos", inputStream, parametros,
                                    ConnectionFactory.getConnection(1));
                } catch ( JRException exc ) {
                    JOptionPane.showMessageDialog(null, "Atenção, houve um erro ao imprimir! Contate o Administrador do Sistema\n" + exc.getMessage(),
                        "Cadore Sistemas", JOptionPane.ERROR_MESSAGE);
                }
    }//GEN-LAST:event_b_print3ActionPerformed

    private void b_print1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_print1ActionPerformed
                try {
                    InputStream inputStream = getClass().getResourceAsStream("/br/com/cadoresistemas/williamcadore/Reports/Users.jasper");
                    Map<String, Object> parametros = new HashMap<>();
                    parametros.put("ID_BUSINESS", Long.valueOf(IdBusiness));
                    ReportModel.openReport("CadoreSistemas | Relatório de Veículos", inputStream, parametros,
                             ConnectionFactory.getConnection(1));
          } catch ( JRException exc ) {
                        JOptionPane.showMessageDialog(null, "Atenção, houve um erro ao imprimir! Contate o Administrador do Sistema\n" + exc.getMessage(),
                            "Cadore Sistemas", JOptionPane.ERROR_MESSAGE);
                    }
    }//GEN-LAST:event_b_print1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_exit;
    private javax.swing.JButton b_print1;
    private javax.swing.JButton b_print2;
    private javax.swing.JButton b_print3;
    private javax.swing.JTextField f_qnt_drivers;
    private javax.swing.JTextField f_qnt_trucks;
    private javax.swing.JTextField f_qnt_users;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel l_status;
    // End of variables declaration//GEN-END:variables
}
