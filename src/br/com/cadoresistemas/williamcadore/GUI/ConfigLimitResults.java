package br.com.cadoresistemas.williamcadore.GUI;

import br.com.cadoresistemas.williamcadore.Utils.Paths;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ConfigLimitResults extends javax.swing.JInternalFrame {

    public ConfigLimitResults() {
        initComponents();
        this.setFrameIcon(new ImageIcon(this.getClass().getResource("/Images/iconTruckSystem.jpg")));
        setActualLimit();
    }

    public String IdBusiness = null;
    private Paths configClass = new Paths();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        l_actual_limit = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cd_limit_results = new javax.swing.JSlider();
        l_alterer_limit = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        b_cancel = new javax.swing.JButton();
        b_save = new javax.swing.JButton();

        setTitle("Configuração limite de resultados por Página");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Atual:");

        l_actual_limit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        l_actual_limit.setText("l_actual_limit");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Use o controle deslizante abaixo para configurar - [1-250]");

        cd_limit_results.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cd_limit_results.setMaximum(250);
        cd_limit_results.setMinimum(1);
        cd_limit_results.setValue(1);
        cd_limit_results.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cd_limit_resultsStateChanged(evt);
            }
        });

        l_alterer_limit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        l_alterer_limit.setText("l_alterer_limit");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Alterar para:");

        b_cancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png"))); // NOI18N
        b_cancel.setText("Cancelar");
        b_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelActionPerformed(evt);
            }
        });

        b_save.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png"))); // NOI18N
        b_save.setText("Salvar");
        b_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(b_save, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_cancel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(46, 46, 46)
                        .addComponent(l_actual_limit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(l_alterer_limit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(cd_limit_results, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cd_limit_results, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(l_actual_limit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(l_alterer_limit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_cancel)
                    .addComponent(b_save))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setActualLimit(){
        String actual_limit = configClass.getConfigLimitResults();
        cd_limit_results.setValue(Integer.valueOf(actual_limit));
        l_actual_limit.setText(actual_limit);
    }

    private void b_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_saveActionPerformed
        try {
            String new_limit = String.valueOf(cd_limit_results.getValue());
            configClass.setConfigLimitResults(new_limit);
        } catch (IOException ex) {
            Logger.getLogger(ConfigLimitResults.class.getName()).log(Level.SEVERE, null, ex);
        }
        setActualLimit();
        JOptionPane.showMessageDialog(rootPane, "Limite configurado com sucesso!", "CadoreSistemas", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }//GEN-LAST:event_b_saveActionPerformed

    private void b_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_b_cancelActionPerformed

    private void cd_limit_resultsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cd_limit_resultsStateChanged
        l_alterer_limit.setText(String.valueOf(cd_limit_results.getValue()));
    }//GEN-LAST:event_cd_limit_resultsStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_cancel;
    private javax.swing.JButton b_save;
    private javax.swing.JSlider cd_limit_results;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel l_actual_limit;
    private javax.swing.JLabel l_alterer_limit;
    // End of variables declaration//GEN-END:variables
}
