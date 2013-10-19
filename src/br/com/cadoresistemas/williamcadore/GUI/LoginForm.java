package br.com.cadoresistemas.williamcadore.GUI;

import br.com.cadoresistemas.williamcadore.DAO.BusinessDAO;
import br.com.cadoresistemas.williamcadore.DAO.LoginDAO;
import br.com.cadoresistemas.williamcadore.DAO.UtilDAO;
import br.com.cadoresistemas.williamcadore.ModelsForm.BusinessModel;
import br.com.cadoresistemas.williamcadore.ModelsForm.UserModel;
import br.com.cadoresistemas.williamcadore.Utils.Paths;
import br.com.cadoresistemas.williamcadore.Utils.TrucksSystemDefault;
import br.com.cadoresistemas.williamcadore.Utils.UserSingleton;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LoginForm extends javax.swing.JFrame {
    public LoginForm() {
        initComponents();
        this.setSize(370, 350);
        l_resetPwd.setVisible(false);
        f_login.setText("william");
        f_password.setText("william");
        ImageIcon logo = new ImageIcon(this.getClass().getResource("/Images/logotipoTruckSystem_Login.jpg"));
        l_label.setIcon(logo);
        this.setTitle("Login | Cadore Sistemas ["+TrucksSystemDefault.actual_version+"]");
        l_first_access.setVisible(false);
    }

    private BusinessDAO businessDAO = new BusinessDAO();
    private BusinessModel business = new BusinessModel();
    private Date current_date_db = new UtilDAO().getDateDB();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        l_label = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        f_password = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        b_login = new javax.swing.JButton();
        b_cancel = new javax.swing.JButton();
        f_login = new javax.swing.JTextField();
        l_resetPwd = new javax.swing.JLabel();
        l_date = new javax.swing.JLabel();
        l_first_access = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusable(false);
        setMinimumSize(new java.awt.Dimension(253, 284));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        l_label.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        l_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_label.setToolTipText("");
        l_label.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        l_label.setFocusable(false);
        l_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l_labelMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Login:");
        jLabel3.setFocusable(false);

        f_password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f_passwordActionPerformed(evt);
            }
        });
        f_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                f_passwordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_passwordKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Senha:");
        jLabel4.setFocusable(false);

        b_login.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png"))); // NOI18N
        b_login.setText("Login");
        b_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_loginActionPerformed(evt);
            }
        });
        b_login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                b_loginKeyPressed(evt);
            }
        });

        b_cancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png"))); // NOI18N
        b_cancel.setText("Cancelar");
        b_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelActionPerformed(evt);
            }
        });

        f_login.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                f_loginKeyPressed(evt);
            }
        });

        l_resetPwd.setText("Esqueceu sua Senha?");
        l_resetPwd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                l_resetPwdMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                l_resetPwdMouseEntered(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l_resetPwdMouseClicked(evt);
            }
        });

        l_date.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        l_date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_date.setText("date");
        l_date.setFocusable(false);

        l_first_access.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        l_first_access.setText("Primeiro acesso");
        l_first_access.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                l_first_accessMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                l_first_accessMouseEntered(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l_first_accessMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(l_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(f_login)
                    .addComponent(f_password)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(l_resetPwd))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(l_first_access))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(b_login, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(l_date, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(l_label, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(l_first_access))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(f_login, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_resetPwd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(f_password, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_cancel, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(b_login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(l_date)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-371)/2, (screenSize.height-350)/2, 371, 350);
    }// </editor-fold>//GEN-END:initComponents

    public static String md5(String pwd){
            String password = "";
            MessageDigest md = null;
            try {
                    md = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
            }
            BigInteger hash = new BigInteger(1, md.digest(pwd.getBytes()));
            password = hash.toString(16);
            return password;
	}
    private void f_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f_passwordActionPerformed

    }//GEN-LAST:event_f_passwordActionPerformed

    private void b_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelActionPerformed
        System.exit(0);
    }//GEN-LAST:event_b_cancelActionPerformed

    private void b_loginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_b_loginKeyPressed

    }//GEN-LAST:event_b_loginKeyPressed

    private void b_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_loginActionPerformed
         if ("".equals(f_login.getText()) || "".equals(String.valueOf(f_password.getPassword()))) {
                JOptionPane.showMessageDialog(rootPane, "Digite seu login e senha para Continuar!", "CadoreSistemas | Login de Usuário", JOptionPane.WARNING_MESSAGE);
                f_login.grabFocus();
            } else {
                    try{
                        this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
                        b_login.setEnabled(false);
                        f_login.setEnabled(false);
                        f_password.setEnabled(false);
                        String login = (String) f_login.getText().toUpperCase();
                        String password = md5(f_password.getText().toUpperCase());
                        boolean inactive = (false);
                        LoginDAO dao = new LoginDAO();
                        if(dao.authenticationUser(login, password, inactive) == true){
                          UserModel userPass = dao.getUser(password, login, inactive);
                          if(businessDAO.getInactiveBusiness(userPass.getId_Business(), current_date_db) == false){
                            UserSingleton us = new UserSingleton();
                            if(us.ValidUserSession(login, userPass.getContact(), String.valueOf(userPass.getId())) == true){
                                if(us.readme == true){
                                    new Paths().setStatusUser(md5(login));
                                }
                                Dashboard dash = new Dashboard();
                                dash.user = userPass;
                                this.dispose();
                                URL url = dash.getClass().getResource("/Images/iconTruckSystem.jpg");
                                Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
                                dash.setIconImage(iconeTitulo);
                                dash.date_db = current_date_db;
                                dash.startDashboard();
                                dash.setVisible(true);
                                dash.setFocusableWindowState(true);
                             }else{
                                JOptionPane.showMessageDialog(rootPane, "Código incorreto!", "Cadore Sistemas", JOptionPane.INFORMATION_MESSAGE);
                                System.exit(0);
                            }

                          }else if(businessDAO.getInactiveBusiness(userPass.getId_Business(), current_date_db) == true){
                              JOptionPane.showMessageDialog(rootPane, "Cliente inativo, para maiores informações contato o administrador.", "Cadore Sistemas", JOptionPane.INFORMATION_MESSAGE);
                              System.exit(0);
                          }
                        } else {
                            b_login.setEnabled(true);
                            f_login.setEnabled(true);
                            f_password.setEnabled(true);
                            JOptionPane.showMessageDialog(rootPane, "Login ou Senha Incorretos ou Usuário Inativo, Verifique e Tente Novamente","Login de Usuário",JOptionPane.WARNING_MESSAGE);
                            f_password.setText("");
                            f_password.grabFocus();
                            this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                            //l_resetPwd.setVisible(true);
                        }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(rootPane, ex.getMessage() + " \nErro Não Foi Possivel Iniciar o Sistema! Contate o Administrador do Sistema");
                    System.exit(0);
                }
            }
    }//GEN-LAST:event_b_loginActionPerformed

    private void f_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_passwordKeyPressed
      	if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            java.awt.event.ActionEvent evit = null;
            b_loginActionPerformed(evit);
        }

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }//GEN-LAST:event_f_passwordKeyPressed

    private void f_passwordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_passwordKeyReleased

    }//GEN-LAST:event_f_passwordKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        f_login.grabFocus();
        String date_local = sdf.format(new java.util.Date());
        String date_db = String.valueOf(sdf.format(current_date_db));
        if(!date_local.equals(date_db)){
            l_date.setText("Data servidor: "+date_db+" - Data Terminal: "+date_local);
            l_date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            l_date.setForeground(Color.RED);
        }else if(date_local.equals(date_db)){
            l_date.setText("Data servidor: "+date_db);
            l_date.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        }
    }//GEN-LAST:event_formWindowOpened

    private void f_loginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_loginKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            f_password.grabFocus();
            f_password.selectAll();
        }

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }//GEN-LAST:event_f_loginKeyPressed

    private void l_resetPwdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_resetPwdMouseEntered
        l_resetPwd.setForeground(Color.BLUE);
    }//GEN-LAST:event_l_resetPwdMouseEntered

    private void l_resetPwdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_resetPwdMouseExited
        l_resetPwd.setForeground(Color.BLACK);
    }//GEN-LAST:event_l_resetPwdMouseExited

    private void l_resetPwdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_resetPwdMouseClicked
        ResetPwdForm pwdf = new ResetPwdForm();
        pwdf.setVisible(true);
    }//GEN-LAST:event_l_resetPwdMouseClicked

    private void l_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_labelMouseClicked
        Desktop desktop = Desktop.getDesktop();
        URI url = null;
        try {
                   url = new URI("http://cadoresistemas.com.br/");
                   desktop.browse(url);
        }
        catch(IOException ioe) {
                   ioe.printStackTrace();
        }
        catch(URISyntaxException use) {
                   use.printStackTrace();
        }
    }//GEN-LAST:event_l_labelMouseClicked

    private void l_first_accessMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_first_accessMouseEntered
        l_first_access.setForeground(Color.BLUE);
    }//GEN-LAST:event_l_first_accessMouseEntered

    private void l_first_accessMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_first_accessMouseExited
        l_first_access.setForeground(Color.BLACK);
    }//GEN-LAST:event_l_first_accessMouseExited

    private void l_first_accessMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_first_accessMouseClicked
        JLabel l2 = new JLabel("Cnpj/Cpf(Informar numero com pontos!):"); JTextField j2 = new JTextField();
        int i = JOptionPane.showConfirmDialog(null, new Object[]{l2, j2}, "Primeiro acesso | Cadore SIstemas", JOptionPane.OK_CANCEL_OPTION);
        String cnpj = j2.getText();

        if(i == JOptionPane.OK_OPTION){
            if(businessDAO.getCountBusinessFirstAccess(cnpj) == true){
                business = businessDAO.getBusinessByCnpjObj(cnpj);
                if(businessDAO.getCountUsersBusinessById(business.getId()) == true){
                    // code
                }else{
                    JOptionPane.showMessageDialog(rootPane, "O Cnpj/Cpf informado ja possui usuarios cadastrados,"
                            + "\npara mais informações entre em contato com o administrador do sistema.",
                            "Primeiro acesso | CadoreSistemas",JOptionPane.WARNING_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Não foi possivel encontrar o Cnpj/Cpf informado, Verifique e Tente Novamente",
                        "Primeiro acesso | CadoreSistemas",JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_l_first_accessMouseClicked

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_cancel;
    private javax.swing.JButton b_login;
    private javax.swing.JTextField f_login;
    private javax.swing.JPasswordField f_password;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel l_date;
    private javax.swing.JLabel l_first_access;
    private javax.swing.JLabel l_label;
    private javax.swing.JLabel l_resetPwd;
    // End of variables declaration//GEN-END:variables
}
