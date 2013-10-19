package br.com.cadoresistemas.williamcadore.GUI;

import br.com.cadoresistemas.williamcadore.DAO.InputsDAO;
import br.com.cadoresistemas.williamcadore.DAO.TrucksDAO;
import br.com.cadoresistemas.williamcadore.ModelsForm.InputsModel;
import br.com.cadoresistemas.williamcadore.TableModels.InputsTableModel;
import br.com.cadoresistemas.williamcadore.Utils.Centraliza;
import br.com.cadoresistemas.williamcadore.Utils.Util;
import com.towel.el.annotation.AnnotationResolver;
import com.towel.swing.table.ObjectTableModel;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class InputsSearch extends javax.swing.JInternalFrame {

    AnnotationResolver resolver = new AnnotationResolver(InputsTableModel.class);
    ObjectTableModel<InputsTableModel> tableModel = new ObjectTableModel<>(resolver, "id,received,description,board,date,value3");

    List<InputsTableModel> listInputs = new ArrayList<>();

    public InputsSearch() {
        initComponents();
        f_received.setText("");
        f_received.setEnabled(true);
        rb_received.setSelected(true);
        cb_truck.setEnabled(false);
        rb_truck.setSelected(false);
        this.setFrameIcon(new ImageIcon(this.getClass().getResource("/Images/iconTruckSystem.jpg")));
    }

    public JDesktopPane deskPane = null;
    private Util date = new Util();
    public String IdBusiness = null;
    private InputsDAO inputsDAO = new InputsDAO();
    private TrucksDAO trucksDAO = new TrucksDAO();
    private DecimalFormat decimal = new DecimalFormat("0.00");

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rb_received = new javax.swing.JRadioButton();
        rb_truck = new javax.swing.JRadioButton();
        f_received = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_inputs = new javax.swing.JTable();
        b_cancel = new javax.swing.JButton();
        b_select = new javax.swing.JButton();
        cb_truck = new javax.swing.JComboBox();

        setTitle("Consulta de Entradas");

        rb_received.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb_received.setText("Recebido De:");
        rb_received.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_receivedActionPerformed(evt);
            }
        });

        rb_truck.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb_truck.setText("Caminhão:");
        rb_truck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_truckActionPerformed(evt);
            }
        });

        f_received.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_received.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_receivedKeyReleased(evt);
            }
        });

        t_inputs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        t_inputs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        t_inputs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_inputsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(t_inputs);

        b_cancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png"))); // NOI18N
        b_cancel.setText("Cancelar");
        b_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelActionPerformed(evt);
            }
        });

        b_select.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_select.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png"))); // NOI18N
        b_select.setText("Selecionar");
        b_select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_selectActionPerformed(evt);
            }
        });

        cb_truck.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_truck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_truckActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 813, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rb_received)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(f_received, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rb_truck)
                                .addGap(18, 18, 18)
                                .addComponent(cb_truck, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(b_select, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_received)
                    .addComponent(f_received, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_truck)
                    .addComponent(cb_truck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_cancel)
                    .addComponent(b_select))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void loadTrucks() {
        cb_truck.removeAllItems(); //remove os itens atuais do comboBox.
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

    private void b_selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_selectActionPerformed
        if(t_inputs.getSelectedRowCount() > 0){
            Object obj = t_inputs.getValueAt(t_inputs.getSelectedRow(), 0);
            InputsModel inputs = inputsDAO.getInputsByIdObj(Integer.valueOf(obj.toString()), Long.valueOf(this.IdBusiness));
            InputsForm InputsF = new InputsForm();
            InputsF.inputs = inputs;
            deskPane.add(InputsF);
            Centraliza.setCentro(InputsF, deskPane, WIDTH, HEIGHT);
            InputsF.IdBusiness = this.IdBusiness;
            InputsF.setVisible(true);
            InputsF.setInputs();
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(rootPane, "Selecione uma Entrada para continuar.", "Cadore Sistemas", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_b_selectActionPerformed

    private void f_receivedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_receivedKeyReleased
        f_received.setText(f_received.getText().toUpperCase());
        tableModel.clear();
        listInputs.clear();
        List<InputsModel> input =inputsDAO.getInputsByReceived(String.valueOf(f_received.getText().toUpperCase()), Long.valueOf(this.IdBusiness));
        for(InputsModel u : input) {
            try {
                String truck = trucksDAO.getBoardTruckById(u.getTrucks());
                String date_ = date.dateFormatReturn(u.getDate());
                String value3 = decimal.format(u.getValue3()).replace(".", ",");
                  listInputs.add(new InputsTableModel(u.getId(),u.getReceived(), u.getDescription(),truck, date_, value3));
            } catch (ParseException ex) {
                Logger.getLogger(InputsSearch.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        tableModel.setData(listInputs);
        t_inputs.setModel(tableModel);
        modulateTableDriver();
    }//GEN-LAST:event_f_receivedKeyReleased

    private void rb_receivedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_receivedActionPerformed
        cb_truck.setEnabled(false);
        f_received.setText("");
        f_received.setEnabled(true);
        rb_truck.setSelected(false);
        f_received.grabFocus();
        tableModel.clear();
        listInputs.clear();
        t_inputs.setModel(tableModel);
    }//GEN-LAST:event_rb_receivedActionPerformed

    private void rb_truckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_truckActionPerformed
        f_received.setText("");
        f_received.setEnabled(false);
        cb_truck.setEnabled(true);
        rb_received.setSelected(false);
        tableModel.clear();
        listInputs.clear();
        t_inputs.setModel(tableModel);
    }//GEN-LAST:event_rb_truckActionPerformed

    private void cb_truckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_truckActionPerformed
        if(this.IdBusiness == null){}else if(this.IdBusiness != null){
        tableModel.clear();
        listInputs.clear();
        Long id = new TrucksDAO().getTruckByBoard(String.valueOf(cb_truck.getSelectedItem()), Long.valueOf(this.IdBusiness));
        List<InputsModel> input = new InputsDAO().getInputsByTruck(id, Long.valueOf(this.IdBusiness));
        for(InputsModel u : input) {
            try {
                String truck = trucksDAO.getBoardTruckById(u.getTrucks());
                String date_ = date.dateFormatReturn(u.getDate());
                String value3 = decimal.format(u.getValue3()).replace(".", ",");
                  listInputs.add(new InputsTableModel(u.getId(),u.getReceived(), u.getDescription(),truck, date_, value3));
            } catch (ParseException ex) {
                Logger.getLogger(InputsSearch.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        tableModel.setData(listInputs);
        t_inputs.setModel(tableModel);
        modulateTableDriver();
        }
    }//GEN-LAST:event_cb_truckActionPerformed

    private void t_inputsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_inputsMouseClicked
        if(evt.getClickCount() > 1){
            java.awt.event.ActionEvent evtt = null;
            b_selectActionPerformed(evtt);
        }
    }//GEN-LAST:event_t_inputsMouseClicked

    private void modulateTableDriver() {
        t_inputs.getColumnModel().getColumn(0).setPreferredWidth(5);
        t_inputs.getColumnModel().getColumn(1).setPreferredWidth(170);
        t_inputs.getColumnModel().getColumn(2).setPreferredWidth(250);
        t_inputs.getColumnModel().getColumn(3).setPreferredWidth(30);
        t_inputs.getColumnModel().getColumn(4).setPreferredWidth(50);
        t_inputs.getColumnModel().getColumn(5).setPreferredWidth(50);
        t_inputs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_cancel;
    private javax.swing.JButton b_select;
    private javax.swing.JComboBox cb_truck;
    private javax.swing.JTextField f_received;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rb_received;
    private javax.swing.JRadioButton rb_truck;
    private javax.swing.JTable t_inputs;
    // End of variables declaration//GEN-END:variables
}
