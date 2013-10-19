package br.com.cadoresistemas.williamcadore.GUI;

import br.com.cadoresistemas.williamcadore.DAO.BusinessDAO;
import br.com.cadoresistemas.williamcadore.Utils.SendMail;
import br.com.cadoresistemas.williamcadore.Utils.Util;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class SendMailForm extends javax.swing.JInternalFrame {

    public SendMailForm() {
        initComponents();
        this.setFrameIcon(new ImageIcon(this.getClass().getResource("/Images/iconTruckSystem.jpg")));
    }

    public String IdBusiness = null;
    public String UserSession = null;
    private Util date = new Util();
    private File arquivo;
    public Dashboard dash = null;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        b_send = new javax.swing.JButton();
        b_exit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        l_business = new javax.swing.JLabel();
        l_user = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        f_subject = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        f_message = new javax.swing.JEditorPane();

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 2, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Enviar email para contato");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 387, 32));

        b_send.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_send.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Mail.png"))); // NOI18N
        b_send.setText("Enviar");
        b_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_sendActionPerformed(evt);
            }
        });
        getContentPane().add(b_send, new org.netbeans.lib.awtextra.AbsoluteConstraints(822, 491, 109, -1));

        b_exit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Exit.png"))); // NOI18N
        b_exit.setText("Sair");
        b_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_exitActionPerformed(evt);
            }
        });
        getContentPane().add(b_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(937, 491, 109, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel2.setText("Cliente:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 11, -1, -1));

        l_business.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        l_business.setText("l_business");
        getContentPane().add(l_business, new org.netbeans.lib.awtextra.AbsoluteConstraints(459, 11, 587, -1));

        l_user.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        l_user.setText("l_user");
        getContentPane().add(l_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(459, 34, 587, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel5.setText("Usuário:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 34, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("*Motivo do E-Mail:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 62, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("*Mensagem:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 114, -1, -1));

        f_subject.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(f_subject, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 85, 1036, -1));

        jScrollPane1.setViewportView(f_message);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 137, 1036, 348));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void sendSMS(String messege){
        try {
            String urlParameters = "user=cadore" +
                                        "&password=a1s2d3f4cadore()" +
                                        "&destinatario=6599534755" +
                                        "&msg=" + URLEncoder.encode(messege, "UTF-8");;

                        URL url = new URL("http://www.facilitamovel.com/api/simpleSend.ft?");

                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        connection.setDoOutput(true);
                        connection.setDoInput(true);
                        connection.setInstanceFollowRedirects(false);
                        connection.setRequestMethod("POST");
                        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                        connection.setRequestProperty("charset", "utf-8");
                        connection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));
                        connection.setUseCaches (false);

                        OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
                        wr.write(urlParameters);
                        wr.flush();

                        BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        StringBuffer strRet = new StringBuffer();
                        String line;
                        while ((line = rd.readLine()) != null) {
                                strRet.append(line);
                        }
                        wr.close();
                        rd.close();

                        System.out.println("Retorno da Chamada HTTP: "+ strRet);

                        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void b_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_sendActionPerformed
        String subject = f_subject.getText().replace(" ", "");
        String message = f_message.getText().replace(" ", "");
        if(f_subject.getText().isEmpty() || f_message.getText().isEmpty()){
                       JOptionPane.showMessageDialog(rootPane, "Preencha todos os campos para continuar", "E-Mail | CadoreSistemas", JOptionPane.INFORMATION_MESSAGE);
                    }else if(subject.trim().length() < 5){
                        JOptionPane.showMessageDialog(rootPane, "Motivo do E-Mail deve conter no minimo uma palavra (cinco letras).", "E-Mail | CadoreSistemas", JOptionPane.INFORMATION_MESSAGE);
                        f_subject.grabFocus();
                        f_subject.selectAll();
                    }else if(message.trim().length() < 15){
                        JOptionPane.showMessageDialog(rootPane, "Mensagem deve conter no minimo 15 letras.", "E-Mail | CadoreSistemas", JOptionPane.INFORMATION_MESSAGE);
                        f_message.grabFocus();
                        f_message.selectAll();
                    }else{
                        Object[] options = {" Sim "," Não "};
                            int i = JOptionPane.showOptionDialog(null,"Confirma o envio de e-mail?", "E-Mail | Cadore Sistemas",
                                        JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                            if (i == JOptionPane.YES_OPTION) {
                                String msg = "Cliente: "+"0"+IdBusiness.toString() + " - "+l_business.getText()+" - "+l_user.getText()
                                              + "\nData: "+date.getddMMyyyyHHmmss()
                                              + "\nAssunto: "+f_subject.getText()
                                              + "\n\nMensagem:\n"+f_message.getText();
                                SendMail sm = new SendMail();
                                sm.sendMail("suporte@cadoresistemas.com.br", f_subject.getText(), msg, 0, null, null, null);
                                JOptionPane.showMessageDialog(rootPane, "E-Mail enviado ao suporte com sucesso.", "E-Mail | CadoreSistemas", JOptionPane.INFORMATION_MESSAGE);
                                f_subject.setText("");
                                f_message.setText("");
                                f_subject.grabFocus();
                            }
		}
    }//GEN-LAST:event_b_sendActionPerformed

    private void b_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_exitActionPerformed
        this.dispose();
    }//GEN-LAST:event_b_exitActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        l_business.setText(new BusinessDAO().getCorporate_NameBusinessById(Long.valueOf(this.IdBusiness)));
        l_user.setText(this.UserSession);
    }//GEN-LAST:event_formInternalFrameOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_exit;
    private javax.swing.JButton b_send;
    private javax.swing.JEditorPane f_message;
    private javax.swing.JTextField f_subject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel l_business;
    private javax.swing.JLabel l_user;
    // End of variables declaration//GEN-END:variables
}
