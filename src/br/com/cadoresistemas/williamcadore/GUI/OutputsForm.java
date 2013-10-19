package br.com.cadoresistemas.williamcadore.GUI;

import br.com.cadoresistemas.williamcadore.ModelsForm.OutputsModel;
import br.com.cadoresistemas.williamcadore.Utils.FixedLengthDocument;
import br.com.cadoresistemas.williamcadore.Utils.Util;
import br.com.cadoresistemas.williamcadore.DAO.OutputsDAO;
import br.com.cadoresistemas.williamcadore.DAO.TrucksDAO;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class OutputsForm extends javax.swing.JInternalFrame {

    public OutputsForm() {
        initComponents();
        b_delete.setVisible(false);
        this.setFrameIcon(new ImageIcon(this.getClass().getResource("/Images/iconTruckSystem.jpg")));
        f_description.setDocument(new FixedLengthDocument(350));
    }

    public OutputsModel outputs = new OutputsModel();
    public OutputsSearch outputsS = new OutputsSearch();
    private String status = "save";
    private TrucksDAO trucksDAO = new TrucksDAO();
    private OutputsDAO outputsDAO = new OutputsDAO();
    public String IdBusiness = null;
    public Long IdFreight = Long.valueOf(0);
    public Long IdTruck = Long.valueOf(0);
    private Util u = new Util();
    private DecimalFormat decimal = new DecimalFormat("0.00");
    public String statusFreight = "other";

     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        l = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cb_truck = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        f_paid = new javax.swing.JTextField();
        f_date = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        f_id = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        f_value1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        f_value3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        f_value2 = new javax.swing.JTextField();
        b_save = new javax.swing.JButton();
        b_cancel = new javax.swing.JButton();
        b_delete = new javax.swing.JButton();
        f_n_truck = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        f_description = new javax.swing.JEditorPane();

        setTitle("Saidas");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        l.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        l.setText("Saidas");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("*Caminhão:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("ID:");

        cb_truck.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_truck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_truckActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Descrição:");

        f_paid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_paid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f_paidActionPerformed(evt);
            }
        });

        try {
            f_date.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        f_date.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("*Data:");

        f_id.setEditable(false);
        f_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("*Pago à:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("*Valor R$:");

        f_value1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_value1.setText("0,00");
        f_value1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                f_value1FocusLost(evt);
            }
            public void focusGained(java.awt.event.FocusEvent evt) {
                f_value1FocusGained(evt);
            }
        });
        f_value1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_value1KeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Desconto R$:");

        f_value3.setEditable(false);
        f_value3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Valor Total:");

        f_value2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_value2.setText("0,00");
        f_value2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                f_value2FocusLost(evt);
            }
            public void focusGained(java.awt.event.FocusEvent evt) {
                f_value2FocusGained(evt);
            }
        });
        f_value2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_value2KeyReleased(evt);
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

        b_cancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png"))); // NOI18N
        b_cancel.setText("Cancelar");
        b_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelActionPerformed(evt);
            }
        });

        b_delete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Delete.png"))); // NOI18N
        b_delete.setText("Excluir");
        b_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_deleteActionPerformed(evt);
            }
        });

        f_n_truck.setEditable(false);
        f_n_truck.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Numero:");

        jScrollPane1.setViewportView(f_description);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(f_id, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(l, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(f_value2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(f_value3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(f_value1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(f_paid, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(cb_truck, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(f_n_truck, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(f_date, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(b_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_save, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(f_value1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(f_value2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(f_value3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(f_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(l, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(f_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_truck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(f_n_truck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(f_paid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_cancel)
                    .addComponent(b_save)
                    .addComponent(b_delete))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     public void setOutputs(){
        try {
            String a = String.valueOf(outputs.getId_truck());
            f_id.setText(outputs.getId().toString());
            f_value1.setText(decimal.format(outputs.getValue1()).replace(".", ","));
            f_value2.setText(decimal.format(outputs.getValue2()).replace(".", ","));
            f_value3.setText(decimal.format(outputs.getValue3()).replace(".", ","));
            f_date.setText(u.dateFormatReturn(outputs.getDate()));
            f_paid.setText(outputs.getPaid());
            f_description.setText(outputs.getDescription());
            if("0".equals(a)){
               cb_truck.removeAllItems();
            }else{
                cb_truck.addItem(trucksDAO.getBoardTruckById(outputs.getId_truck()));
            }
            status = "update";
            b_save.setText("Atualizar");
            b_delete.setVisible(true);
            loadTrucks();
        } catch (ParseException ex) {
            Logger.getLogger(OutputsForm.class.getName()).log(Level.SEVERE, null, ex);
        }
     }

    public void loadTrucks() {
        cb_truck.addItem(" -");
        ArrayList trucks = trucksDAO.findAll(Long.valueOf(this.IdBusiness)); //'produtoDAO' é meu objeto que retorna os produtos do banco.
        Iterator i = trucks.iterator();

        while(i.hasNext()) {
           cb_truck.addItem(String.valueOf(i.next()));
        }
   }

    private void b_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_b_cancelActionPerformed

    private void b_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_saveActionPerformed
        Long id_truck = Long.valueOf(0);
        if("save".equals(status)){
            if ((f_value1.getText().isEmpty())
                || (f_value2.getText().isEmpty())
                || (f_date.getText().trim().length() == 4)
                || (f_paid.getText().isEmpty())) {
            JOptionPane.showMessageDialog(rootPane, "Campos com ' * ' São obrigatórios!", "Saidas", JOptionPane.WARNING_MESSAGE);
        }
        else {
                try {
                    if(" -".equals(cb_truck.getSelectedItem())){
                            id_truck = Long.valueOf(0);
                        }else if(!" -".equals(cb_truck.getSelectedItem())){
                            id_truck = trucksDAO.getIDTruck(cb_truck.getSelectedItem().toString());
                        }
                        outputs.setValue1(Double.valueOf(f_value1.getText().replace(",", ".")));
                        outputs.setValue2(Double.valueOf(f_value2.getText().replace(",", ".")));
                        outputs.setValue3(Double.valueOf(f_value3.getText().replace(",", ".")));
                        outputs.setDate(u.dateFormatInsert(f_date.getText()));
                        outputs.setPaid(f_paid.getText().toUpperCase());
                        outputs.setDescription(f_description.getText().toUpperCase());
                        outputs.setCreated_at(u.dateFormatInsert(u.getDateddMMyyyy()));
                        outputs.setUpdated(u.dateFormatInsert(u.getDateddMMyyyy()));
                        outputs.setId_truck(id_truck);
                        outputs.setId_business(Long.valueOf(this.IdBusiness));
                        outputs.setId_freight(IdFreight);
                        outputs.setInactive(false);
                        outputsDAO.adiciona(outputs);
                        JOptionPane.showMessageDialog(null, "Nova Saida Cadastrada Com Sucesso!");
                        this.dispose();
                        if("freight".equals(statusFreight)){
                            outputsS.IdBusiness = IdBusiness;
                            outputsS.IdFreight = IdFreight;
                            outputsS.getOutputsByFreight();
                        }
                } catch (ParseException ex) {
                    Logger.getLogger(OutputsForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else if("update".equals(status)){
            if ((f_value1.getText().isEmpty())
                  || (f_value2.getText().isEmpty())
                  || (f_date.getText().trim().length() == 4)
                  || (f_paid.getText().isEmpty())) {
              JOptionPane.showMessageDialog(rootPane, "Campos com ' * ' São obrigatórios!", "Saidas", JOptionPane.WARNING_MESSAGE);
          }
          else {
                try {
                    if(" -".equals(cb_truck.getSelectedItem())){
                            id_truck = Long.valueOf(0);
                        }else if(!" -".equals(cb_truck.getSelectedItem())){
                            id_truck = trucksDAO.getIDTruck(cb_truck.getSelectedItem().toString());
                        }
                        outputs.setValue1(Double.valueOf(f_value1.getText().replace(",", ".")));
                        outputs.setValue2(Double.valueOf(f_value2.getText().replace(",", ".")));
                        outputs.setValue3(Double.valueOf(f_value3.getText().replace(",", ".")));
                        outputs.setDate(u.dateFormatInsert(f_date.getText()));
                        outputs.setPaid(f_paid.getText().toUpperCase());
                        outputs.setDescription(f_description.getText().toUpperCase());
                        outputs.setUpdated(u.dateFormatInsert(u.getDateddMMyyyy()));
                        outputs.setId_truck(id_truck);
                        outputs.setId_business(Long.valueOf(this.IdBusiness));
                        outputs.setId(Long.valueOf(f_id.getText()));
                        outputs.setInactive(false);

                        outputsDAO.atualiza(outputs);
                        JOptionPane.showMessageDialog(null, "Saida Atualizada Com Sucesso!");
                        this.dispose();
                } catch (ParseException ex) {
                    Logger.getLogger(OutputsForm.class.getName()).log(Level.SEVERE, null, ex);
                }
              }
          }
    }//GEN-LAST:event_b_saveActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

    }//GEN-LAST:event_formInternalFrameOpened

    private void f_value1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_value1KeyReleased
        if(!"".equals(f_value1.getText()) && u.isNumbers(f_value1)){
            java.awt.event.KeyEvent evtt = null;
            f_value2KeyReleased(evtt);
        }else{
            f_value3.setText("");
        }
    }//GEN-LAST:event_f_value1KeyReleased

    private void f_value2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_value2KeyReleased
       if(!"".equals(f_value2.getText()) && u.isNumbers(f_value2)){
            String a = f_value2.getText().replace(",", ".");
            String b = f_value1.getText().replace(",", ".");
            f_value3.setText("");
            Double value1 = Double.valueOf(a);
            Double value2 = Double.valueOf(b);
            Double value3 = value2 - value1;
            f_value3.setText(decimal.format(value3).replace(".", ","));
       }else{
            f_value3.setText("");
        }
    }//GEN-LAST:event_f_value2KeyReleased

    private void cb_truckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_truckActionPerformed
       if(cb_truck.getSelectedItem() == null || " -".equals(cb_truck.getSelectedItem())){f_n_truck.setText("");
       }else{
             f_n_truck.setText(String.valueOf(trucksDAO.getNumberTruck(cb_truck.getSelectedItem().toString())));
        }
    }//GEN-LAST:event_cb_truckActionPerformed

    private void b_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_deleteActionPerformed
        Object[] options = {" Sim "," Não "};
		int i = JOptionPane.showOptionDialog(null,"Você tem certeza que deseja Excluir(inativar) esta Saida?", "Cadore Sistemas",
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		if (i == JOptionPane.YES_OPTION) {
			outputs.setInactive(true);
                        outputs.setId(Long.valueOf(f_id.getText()));
                        outputsDAO.exclui(outputs);
                        JOptionPane.showMessageDialog(rootPane, "Saida Excluida(Inativada) com sucesso!", "Cadore Sistemas", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
        }
    }//GEN-LAST:event_b_deleteActionPerformed

    private void f_value1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_value1FocusGained
        f_value1.selectAll();
    }//GEN-LAST:event_f_value1FocusGained

    private void f_value2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_value2FocusGained
        f_value2.selectAll();
    }//GEN-LAST:event_f_value2FocusGained

    private void f_value1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_value1FocusLost
        if(u.isNumbers(f_value1) == true){
            double a = Double.valueOf(f_value1.getText().replace(",", "."));
            f_value1.setText(decimal.format(a).replace(".", ","));
        }
    }//GEN-LAST:event_f_value1FocusLost

    private void f_value2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_value2FocusLost
        if(u.isNumbers(f_value2) == true){
            double a = Double.valueOf(f_value2.getText().replace(",", "."));
            f_value2.setText(decimal.format(a).replace(".", ","));
        }
    }//GEN-LAST:event_f_value2FocusLost

    private void f_paidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f_paidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_f_paidActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_cancel;
    private javax.swing.JButton b_delete;
    private javax.swing.JButton b_save;
    public javax.swing.JComboBox cb_truck;
    private javax.swing.JFormattedTextField f_date;
    private javax.swing.JEditorPane f_description;
    private javax.swing.JTextField f_id;
    private javax.swing.JTextField f_n_truck;
    private javax.swing.JTextField f_paid;
    private javax.swing.JTextField f_value1;
    private javax.swing.JTextField f_value2;
    private javax.swing.JTextField f_value3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel l;
    // End of variables declaration//GEN-END:variables
}