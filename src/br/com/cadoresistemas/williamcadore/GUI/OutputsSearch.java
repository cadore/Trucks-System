package br.com.cadoresistemas.williamcadore.GUI;

import br.com.cadoresistemas.williamcadore.DAO.OutputsDAO;
import br.com.cadoresistemas.williamcadore.DAO.TrucksDAO;
import br.com.cadoresistemas.williamcadore.ModelsForm.OutputsModel;
import br.com.cadoresistemas.williamcadore.TableModels.OutputsTableModel;
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

public class OutputsSearch extends javax.swing.JInternalFrame {

    AnnotationResolver resolver = new AnnotationResolver(OutputsTableModel.class);
    ObjectTableModel<OutputsTableModel> tableModel = new ObjectTableModel<>(resolver, "id,paid,description,board,date,value3");

    List<OutputsTableModel> listOutputs = new ArrayList<>();

    public OutputsSearch() {
        initComponents();
        f_paid.setText("");
        f_paid.setEnabled(true);
        rb_paid.setSelected(true);
        cb_truck.setEnabled(false);
        rb_truck.setSelected(false);
        this.setFrameIcon(new ImageIcon(this.getClass().getResource("/Images/iconTruckSystem.jpg")));
    }

     public JDesktopPane deskPane = null;
     public String statusFreight = "other";
     public String IdBusiness = null;
     public Long IdFreight = Long.valueOf(0);
     public Long IdTruck = Long.valueOf(0);
     TrucksDAO trucksDAO = new TrucksDAO();
     private Util date = new Util();
     private DecimalFormat decimal = new DecimalFormat("0.00");
     private OutputsModel outputs = new OutputsModel();
     private OutputsDAO outputsDAO = new OutputsDAO();
     public FreightsForm freightsF = new FreightsForm();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        t_outputs = new javax.swing.JTable();
        b_cancel = new javax.swing.JButton();
        b_select = new javax.swing.JButton();
        rb_truck = new javax.swing.JRadioButton();
        rb_paid = new javax.swing.JRadioButton();
        f_paid = new javax.swing.JTextField();
        cb_truck = new javax.swing.JComboBox();
        b_new = new javax.swing.JButton();
        b_delete = new javax.swing.JButton();

        setTitle("Consulta De Saidas");

        t_outputs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        t_outputs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        t_outputs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_outputsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(t_outputs);

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

        rb_truck.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb_truck.setText("Caminhão:");
        rb_truck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_truckActionPerformed(evt);
            }
        });

        rb_paid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb_paid.setText("Pago à:");
        rb_paid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_paidActionPerformed(evt);
            }
        });

        f_paid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_paid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_paidKeyReleased(evt);
            }
        });

        cb_truck.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_truck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_truckActionPerformed(evt);
            }
        });

        b_new.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_new.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/New document.png"))); // NOI18N
        b_new.setText("Nova");
        b_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_newActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 886, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rb_paid)
                                .addGap(21, 21, 21)
                                .addComponent(f_paid, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rb_truck)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb_truck, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(b_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_select, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_new, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_paid)
                    .addComponent(f_paid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_truck)
                    .addComponent(cb_truck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_cancel)
                    .addComponent(b_new)
                    .addComponent(b_delete)
                    .addComponent(b_select))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void getOutputsByFreight(){
        f_paid.setEnabled(false);
        cb_truck.setEnabled(false);
        rb_paid.setEnabled(false);
        rb_truck.setEnabled(false);

        tableModel.clear();
        listOutputs.clear();
        List<OutputsModel> output = new OutputsDAO().getOutputsByIdFreight(IdFreight, Long.valueOf(IdBusiness));
        for(OutputsModel u : output) {
            try {
                String date_ = date.dateFormatReturn(u.getDate());
                String truck = trucksDAO.getBoardTruckById(u.getId_truck());
                String valor3 = decimal.format(u.getValue3());
                listOutputs.add(new OutputsTableModel(u.getId(),u.getPaid(), u.getDescription(), truck, date_, valor3));
            } catch (ParseException ex) {
                Logger.getLogger(OutputsSearch.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        tableModel.setData(listOutputs);
        t_outputs.setModel(tableModel);
        modulateTableOutputs();
    }

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
        if("other".equals(this.statusFreight)){
            this.dispose();
        }else if("freight".equals(this.statusFreight)){
            double soma = 0;
            int contador = t_outputs.getRowCount();
               for(int u=0; u<contador; u++){
                     soma += Double.valueOf(t_outputs.getValueAt(u,5).toString().replace(",", "."));
               }
               String a;
               a = String.valueOf(decimal.format(soma));
               String b = a.replace(".", ",");
            freightsF.f_discount_freight.setText(b);
            this.dispose();
        }
    }//GEN-LAST:event_b_cancelActionPerformed

    private void b_selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_selectActionPerformed
        if("other".equals(statusFreight)){
            if(t_outputs.getSelectedRowCount() > 0){
                Object obj = t_outputs.getValueAt(t_outputs.getSelectedRow(), 0);
                OutputsModel outputs = new OutputsDAO().getOutputsByIdObj(Integer.valueOf(obj.toString()), Long.valueOf(this.IdBusiness));
                OutputsForm OutputsF = new OutputsForm();
                OutputsF.outputs = outputs;
                deskPane.add(OutputsF);
                Centraliza.setCentro(OutputsF, deskPane, WIDTH, HEIGHT);
                OutputsF.IdBusiness = this.IdBusiness;
                OutputsF.setVisible(true);
                OutputsF.setOutputs();
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(rootPane, "Selecione uma saida para continuar.", "Cadore Sistemas", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_b_selectActionPerformed

    private void rb_truckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_truckActionPerformed
        f_paid.setText("");
        f_paid.setEnabled(false);
        rb_truck.setEnabled(true);
        rb_paid.setSelected(false);
        cb_truck.setEnabled(true);
        tableModel.clear();
        listOutputs.clear();
        t_outputs.setModel(tableModel);
    }//GEN-LAST:event_rb_truckActionPerformed

    private void rb_paidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_paidActionPerformed
        cb_truck.setEnabled(false);
        f_paid.setText("");
        f_paid.setEnabled(true);
        rb_truck.setSelected(false);
        f_paid.grabFocus();
        tableModel.clear();
        listOutputs.clear();
        t_outputs.setModel(tableModel);
    }//GEN-LAST:event_rb_paidActionPerformed

    private void f_paidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_paidKeyReleased
        f_paid.setText(f_paid.getText().toUpperCase());
        tableModel.clear();
        listOutputs.clear();
        List<OutputsModel> output = new OutputsDAO().getOutputsByPaid(String.valueOf(f_paid.getText().toUpperCase()), Long.valueOf(this.IdBusiness));
        for(OutputsModel u : output) {
            try {
                String date_ = date.dateFormatReturn(u.getDate());
                String truck = trucksDAO.getBoardTruckById(u.getId_truck());
                String valor3 = decimal.format(u.getValue3());
                listOutputs.add(new OutputsTableModel(u.getId(),u.getPaid(), u.getDescription(), truck, date_, valor3));
            } catch (ParseException ex) {
                Logger.getLogger(OutputsSearch.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        tableModel.setData(listOutputs);
        t_outputs.setModel(tableModel);
        modulateTableOutputs();
    }//GEN-LAST:event_f_paidKeyReleased

    private void cb_truckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_truckActionPerformed
        if(this.IdBusiness == null){}else if(this.IdBusiness != null){
        tableModel.clear();
        listOutputs.clear();
        Long id = null;
        if(" -".equals(cb_truck.getSelectedItem())){
            id = Long.valueOf(0);
        }else if(!" -".equals(cb_truck.getSelectedItem())){
            id = trucksDAO.getTruckByBoard(String.valueOf(cb_truck.getSelectedItem()), Long.valueOf(this.IdBusiness));
        }
        List<OutputsModel> output = new OutputsDAO().getOutputsByTruck(id, Long.valueOf(this.IdBusiness));
        for(OutputsModel u : output) {
                try {
                    String date_ = date.dateFormatReturn(u.getDate());
                    String truck = trucksDAO.getBoardTruckById(u.getId_truck());
                    String valor3 = decimal.format(u.getValue3());
                    listOutputs.add(new OutputsTableModel(u.getId(),u.getPaid(), u.getDescription(), truck, date_, valor3));
                } catch (ParseException ex) {
                    Logger.getLogger(OutputsSearch.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        tableModel.setData(listOutputs);
        t_outputs.setModel(tableModel);
        modulateTableOutputs();
        }
    }//GEN-LAST:event_cb_truckActionPerformed

    private void t_outputsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_outputsMouseClicked
        if(evt.getClickCount() > 1){
            java.awt.event.ActionEvent evtt = null;
            b_selectActionPerformed(evtt);
        }
    }//GEN-LAST:event_t_outputsMouseClicked

    private void b_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_newActionPerformed
            OutputsForm OutputsF = new OutputsForm();
            OutputsF.IdFreight = this.IdFreight;
            deskPane.add(OutputsF);
            Centraliza.setCentro(OutputsF, deskPane, WIDTH, HEIGHT);
            OutputsF.IdBusiness = this.IdBusiness;
            OutputsF.setVisible(true);
            OutputsF.setTitle("Despesas");
            OutputsF.l.setText("Despesas");
            OutputsF.IdTruck = this.IdTruck;
            OutputsF.cb_truck.addItem(" -");
            OutputsF.cb_truck.setEnabled(false);
            OutputsF.statusFreight = this.statusFreight;
            OutputsF.outputsS = this;
    }//GEN-LAST:event_b_newActionPerformed

    private void b_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_deleteActionPerformed
          if(t_outputs.getSelectedRowCount() > 0){
                Object[] options = {" Sim "," Não "};
                int i = JOptionPane.showOptionDialog(null,"Você tem certeza que deseja Excluir(inativar) esta Despesa?", "Cadore Sistemas",
                    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                if (i == JOptionPane.YES_OPTION) {
                    Object obj = t_outputs.getValueAt(t_outputs.getSelectedRow(), 0);
                    outputs.setInactive(true);
                    outputs.setId(Long.valueOf(obj.toString()));
                    outputsDAO.exclui(outputs);
                    JOptionPane.showMessageDialog(rootPane, "Despesa Excluida(Inativada) com sucesso!", "Cadore Sistemas", JOptionPane.INFORMATION_MESSAGE);
                    this.getOutputsByFreight();
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Escolha uma despesa para Excluir(inativar)", "CadoreSistemas", JOptionPane.INFORMATION_MESSAGE);
            }
    }//GEN-LAST:event_b_deleteActionPerformed

    private void modulateTableOutputs() {
        t_outputs.getColumnModel().getColumn(0).setPreferredWidth(5);
        t_outputs.getColumnModel().getColumn(1).setPreferredWidth(170);
        t_outputs.getColumnModel().getColumn(2).setPreferredWidth(250);
        t_outputs.getColumnModel().getColumn(3).setPreferredWidth(30);
        t_outputs.getColumnModel().getColumn(4).setPreferredWidth(50);
        t_outputs.getColumnModel().getColumn(5).setPreferredWidth(50);
        t_outputs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton b_cancel;
    public javax.swing.JButton b_delete;
    public javax.swing.JButton b_new;
    public javax.swing.JButton b_select;
    private javax.swing.JComboBox cb_truck;
    private javax.swing.JTextField f_paid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rb_paid;
    private javax.swing.JRadioButton rb_truck;
    private javax.swing.JTable t_outputs;
    // End of variables declaration//GEN-END:variables
}
