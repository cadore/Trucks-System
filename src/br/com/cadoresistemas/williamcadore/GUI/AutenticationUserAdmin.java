package br.com.cadoresistemas.williamcadore.GUI;

import br.com.cadoresistemas.williamcadore.DAO.LoginDAO;
import br.com.cadoresistemas.williamcadore.Utils.Centraliza;
import java.awt.Color;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

public class AutenticationUserAdmin extends javax.swing.JInternalFrame {

    public AutenticationUserAdmin() {
        initComponents();
        f_password.setForeground(Color.red);
        this.setFrameIcon(new ImageIcon(this.getClass().getResource("/Images/iconTruckSystem.jpg")));
    }
    public JDesktopPane deskPane = null;
    public String IdBusiness = null;

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        f_password = new javax.swing.JPasswordField();
        b_cancel = new javax.swing.JButton();
        b_autentication = new javax.swing.JButton();

        setTitle("Autenticação de Usuário");
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Senha de Administrador:");

        f_password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                f_passwordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                f_passwordMouseExited(evt);
            }
        });
        f_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f_passwordActionPerformed(evt);
            }
        });
        f_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_passwordKeyReleased(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                f_passwordKeyPressed(evt);
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

        b_autentication.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_autentication.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png"))); // NOI18N
        b_autentication.setText("Autenticar");
        b_autentication.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_autenticationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 137, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(b_autentication, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(5, 5, 5)
                        .addComponent(b_cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(f_password))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(f_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_autentication)
                    .addComponent(b_cancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_b_cancelActionPerformed

    private void b_autenticationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_autenticationActionPerformed
        if ( "".equals(String.valueOf(f_password.getPassword()))) {
            JOptionPane.showMessageDialog(rootPane, "Digite Sua Senha de ADMINISTRADOR Para Continuar!", "Autenticação de Usuário", JOptionPane.WARNING_MESSAGE);
            f_password.grabFocus();
        } else {
            try{
                String pwd = f_password.getText().toUpperCase();
                String password = md5(pwd);
                LoginDAO dao = new LoginDAO();
                b_autentication.setEnabled(false);
                if(dao.authenticationAdmin(password,Long.valueOf(this.IdBusiness)) == true){
                    UserForm userF = new UserForm();
                    deskPane.add(userF);
                    Centraliza.setCentro(userF, deskPane, WIDTH, HEIGHT);
                    userF.deskPane = deskPane;
                    userF.IdBusiness = IdBusiness;
                    userF.setVisible(true);
                    this.dispose();

                } else {
                    b_autentication.setEnabled(true);
                    JOptionPane.showMessageDialog(rootPane, "Senha de ADMINISTRADOR Incorreta, Verifique e Tente Novamente!","Autenticação de Usuário",JOptionPane.WARNING_MESSAGE);
                    f_password.setText("");
                    f_password.grabFocus();
                }
        }catch (Exception ex){
            JOptionPane.showMessageDialog(rootPane, "erro" + ex.getMessage());
        }
     }

    }//GEN-LAST:event_b_autenticationActionPerformed

    private void f_passwordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f_passwordMouseEntered

    }//GEN-LAST:event_f_passwordMouseEntered

    private void f_passwordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f_passwordMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_f_passwordMouseExited

    private void f_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_f_passwordActionPerformed

    private void f_passwordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_passwordKeyReleased

    }//GEN-LAST:event_f_passwordKeyReleased

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

    }//GEN-LAST:event_formKeyPressed

    private void f_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_passwordKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            java.awt.event.ActionEvent evit = null;
            b_autenticationActionPerformed(evit);
        }

        if (evt.getKeyCode() == evt.VK_ESCAPE) {
            this.dispose();
        }
    }//GEN-LAST:event_f_passwordKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_autentication;
    private javax.swing.JButton b_cancel;
    private javax.swing.JPasswordField f_password;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
