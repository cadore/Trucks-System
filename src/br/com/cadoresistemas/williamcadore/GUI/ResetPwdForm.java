package br.com.cadoresistemas.williamcadore.GUI;

import br.com.cadoresistemas.williamcadore.DAO.UserDAO;
import br.com.cadoresistemas.williamcadore.ModelsForm.UserModel;
import javax.swing.JOptionPane;

public class ResetPwdForm extends javax.swing.JFrame {

    public ResetPwdForm() {
        initComponents();
        JOptionPane.showMessageDialog(rootPane, "Para sua segurança informe o Login, E-Mail ou Celular de cadastro para recuperar sua senha!",
                "CadoreSistemas | Recupera Senha", JOptionPane.INFORMATION_MESSAGE);
    }

    UserDAO userDAO = new UserDAO();
    UserModel user = new UserModel();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        f_text = new javax.swing.JTextField();
        rb_phone = new javax.swing.JRadioButton();
        rb_email = new javax.swing.JRadioButton();
        rb_login = new javax.swing.JRadioButton();
        b_submit = new javax.swing.JButton();
        rb_sms = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        rb_email1 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CadoreSistemas | Recuperar Senha");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        f_text.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        rb_phone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb_phone.setText("Celular:");
        rb_phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_phoneActionPerformed(evt);
            }
        });

        rb_email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb_email.setText("E-Mail:");
        rb_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_emailActionPerformed(evt);
            }
        });

        rb_login.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb_login.setText("Login:");
        rb_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_loginActionPerformed(evt);
            }
        });

        b_submit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_submit.setText("Enviar");
        b_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_submitActionPerformed(evt);
            }
        });

        rb_sms.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb_sms.setText("SMS");
        rb_sms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_smsActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Receber senha por:");

        rb_email1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb_email1.setText("E-Mail:");
        rb_email1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_email1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(f_text, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(rb_login)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(rb_email)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(rb_phone))
                        .addComponent(b_submit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rb_email1)
                        .addGap(6, 6, 6)
                        .addComponent(rb_sms)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_login)
                    .addComponent(rb_email)
                    .addComponent(rb_phone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(f_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rb_sms)
                    .addComponent(rb_email1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_submit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-343)/2, (screenSize.height-173)/2, 343, 173);
    }// </editor-fold>//GEN-END:initComponents

    private void sendEmail(String destinatario, String login){

    }

    private void sendSMS(String destinatario, String login){

    }

    private void rb_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_loginActionPerformed
        rb_login.setSelected(true);
        rb_email.setSelected(false);
        rb_phone.setSelected(false);
        f_text.grabFocus();
        f_text.selectAll();
    }//GEN-LAST:event_rb_loginActionPerformed

    private void rb_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_emailActionPerformed
        rb_login.setSelected(false);
        rb_email.setSelected(true);
        rb_phone.setSelected(false);
        f_text.grabFocus();
        f_text.selectAll();
    }//GEN-LAST:event_rb_emailActionPerformed

    private void rb_phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_phoneActionPerformed
        rb_login.setSelected(false);
        rb_email.setSelected(false);
        rb_phone.setSelected(true);
        f_text.grabFocus();
        f_text.selectAll();
    }//GEN-LAST:event_rb_phoneActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        rb_login.setSelected(true);
        f_text.grabFocus();
        f_text.selectAll();
    }//GEN-LAST:event_formWindowOpened

    private void rb_smsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_smsActionPerformed
        rb_email1.setSelected(false);
        rb_sms.setSelected(true);
        b_submit.grabFocus();
    }//GEN-LAST:event_rb_smsActionPerformed

    private void rb_email1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_email1ActionPerformed
        rb_email1.setSelected(true);
        rb_sms.setSelected(false);
        b_submit.grabFocus();
    }//GEN-LAST:event_rb_email1ActionPerformed

    private void b_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_submitActionPerformed
        if("".equals(f_text.getText())){
            if(rb_login.isSelected() == true){
                JOptionPane.showMessageDialog(rootPane, "Digite seu login para Continuar.", "CadoreSistemas | Recupera Senha", JOptionPane.INFORMATION_MESSAGE);
                f_text.grabFocus();
                f_text.selectAll();
            }else if(rb_email.isSelected() == true){
                JOptionPane.showMessageDialog(rootPane, "Digite seu e-mail para Continuar.", "CadoreSistemas | Recupera Senha", JOptionPane.INFORMATION_MESSAGE);
                f_text.grabFocus();
                f_text.selectAll();
            }else if(rb_phone.isSelected() == true){
                JOptionPane.showMessageDialog(rootPane, "Digite seu celular para Continuar.", "CadoreSistemas | Recupera Senha", JOptionPane.INFORMATION_MESSAGE);
                f_text.grabFocus();
                f_text.selectAll();
            }
        }else if(!"".equals(f_text.getText())){
            if(rb_email1.isSelected() == false && rb_sms.isSelected() == false){
                JOptionPane.showMessageDialog(rootPane, "Escolha uma forma de envio, SMS ou E-Mail.", "CadoreSistemas | Recupera Senha", JOptionPane.INFORMATION_MESSAGE);
            }else if(rb_email1.isSelected() == true || rb_sms.isSelected() == true){
                if(rb_login.isSelected() == true){
                    if(userDAO.getLoginsUser(f_text.getText().toUpperCase()).equals(f_text.getText().toUpperCase())){
                        if(rb_login.isSelected() == true){

                        }
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "Usuário invalido.", "CadoreSistemas", JOptionPane.INFORMATION_MESSAGE);
                        f_text.grabFocus();
                        f_text.selectAll();
                    }
            }else if(rb_email.isSelected() == true){
                //email
            }else if(rb_phone.isSelected() == true){
                //phone
            }
            }
        }
    }//GEN-LAST:event_b_submitActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ResetPwdForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResetPwdForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResetPwdForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResetPwdForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResetPwdForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_submit;
    private javax.swing.JTextField f_text;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton rb_email;
    private javax.swing.JRadioButton rb_email1;
    private javax.swing.JRadioButton rb_login;
    private javax.swing.JRadioButton rb_phone;
    private javax.swing.JRadioButton rb_sms;
    // End of variables declaration//GEN-END:variables
}
