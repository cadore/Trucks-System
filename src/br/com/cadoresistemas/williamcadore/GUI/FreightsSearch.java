package br.com.cadoresistemas.williamcadore.GUI;

import br.com.cadoresistemas.williamcadore.DAO.DriversDAO;
import br.com.cadoresistemas.williamcadore.DAO.FreightsDAO;
import br.com.cadoresistemas.williamcadore.DAO.TrucksDAO;
import br.com.cadoresistemas.williamcadore.ModelsForm.FreightsModel;
import br.com.cadoresistemas.williamcadore.TableModels.FreightsTableModel;
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

public class FreightsSearch extends javax.swing.JInternalFrame {

    AnnotationResolver resolver = new AnnotationResolver(FreightsTableModel.class);
    ObjectTableModel<FreightsTableModel> tableModel = new ObjectTableModel<>(resolver, "id,date_exit,truck,driver,note,product,weight,total3");
    List<FreightsTableModel> listFreights = new ArrayList<>();

    public FreightsSearch() {
        initComponents();
        f_note.setText("");
        f_note.setEnabled(false);
        rb_note.setSelected(false);
        f_product.setText("");
        f_product.setEnabled(false);
        rb_product.setSelected(false);
        this.setFrameIcon(new ImageIcon(this.getClass().getResource("/Images/iconTruckSystem.jpg")));
    }

    public JDesktopPane deskPane = null;
    private DecimalFormat decimal = new DecimalFormat("0.00");
    public String IdBusiness = null;
    public FreightsForm freightsForm = new FreightsForm();
    private FreightsDAO freightsDAO = new FreightsDAO();
    private TrucksDAO trucksDAO = new TrucksDAO();
    private DriversDAO driversDAO = new DriversDAO();
    private Util date = new Util();

      @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        b_select = new javax.swing.JButton();
        b_save = new javax.swing.JButton();
        rb_note = new javax.swing.JRadioButton();
        f_note = new javax.swing.JTextField();
        f_product = new javax.swing.JTextField();
        rb_product = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_freights = new javax.swing.JTable();
        cb_truck = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        rb_all_freights = new javax.swing.JRadioButton();

        setTitle("Consulta de Fretes");

        b_select.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_select.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png"))); // NOI18N
        b_select.setText("Selecionar");
        b_select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_selectActionPerformed(evt);
            }
        });

        b_save.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png"))); // NOI18N
        b_save.setText("Cancelar");
        b_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_saveActionPerformed(evt);
            }
        });

        rb_note.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb_note.setText("Nº Nota:");
        rb_note.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_noteActionPerformed(evt);
            }
        });

        f_note.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_note.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_noteKeyReleased(evt);
            }
        });

        f_product.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_product.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_productKeyReleased(evt);
            }
        });

        rb_product.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb_product.setText("Produto:");
        rb_product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_productActionPerformed(evt);
            }
        });

        t_freights.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        t_freights.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        t_freights.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_freightsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(t_freights);

        cb_truck.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_truck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_truckActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Veículo:");

        rb_all_freights.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb_all_freights.setText("Todos os Fretes");
        rb_all_freights.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_all_freightsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 987, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_truck, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rb_note)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(f_note, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rb_product)
                        .addGap(1, 1, 1)
                        .addComponent(f_product, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rb_all_freights, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(b_select, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_save, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cb_truck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rb_note)
                        .addComponent(f_note, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(f_product, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rb_all_freights)))
                        .addComponent(rb_product)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_save)
                    .addComponent(b_select))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

      public void loadTrucks() {
        TrucksDAO dao = new TrucksDAO();
        cb_truck.removeAllItems(); //remove os itens atuais do comboBox.
        cb_truck.addItem(" -");
        ArrayList tractions = dao.findAll(Long.valueOf(this.IdBusiness)); //'produtoDAO' é meu objeto que retorna os produtos do banco.
        Iterator i = tractions.iterator();

        while(i.hasNext()) {
           cb_truck.addItem(String.valueOf(i.next()));
        }
   }
    private void b_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_saveActionPerformed
        this.dispose();
    }//GEN-LAST:event_b_saveActionPerformed

    private void rb_noteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_noteActionPerformed
        f_note.setText("");
        f_product.setText("");
        f_note.setEnabled(true);
        f_product.setEnabled(false);
        rb_product.setSelected(false);
        rb_all_freights.setSelected(false);
        f_note.grabFocus();
    }//GEN-LAST:event_rb_noteActionPerformed

    private void f_noteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_noteKeyReleased
        f_note.setText(f_note.getText().toUpperCase());
        tableModel.clear();
        listFreights.clear();
        Long id_truck = trucksDAO.getTruckByBoard(String.valueOf(cb_truck.getSelectedItem()), Long.valueOf(this.IdBusiness));
        List<FreightsModel> t = freightsDAO.getFreightsByNote(String.valueOf(f_note.getText().toUpperCase()), Long.valueOf(this.IdBusiness), id_truck);
        for(FreightsModel u : t) {
            try {
                String truck = trucksDAO.getBoardTruckById(u.getTruck());
                String driver = driversDAO.getDriverByID(u.getDriver(), Long.valueOf(this.IdBusiness));
                String weight = String.valueOf(decimal.format(u.getWeight())).replace(".", ",");
                String date_exit = date.dateFormatReturn(u.getData_exit());
                String total3 = "R$:"+(decimal.format(u.getTotal3()).replace(".", ","));
                listFreights.add(new FreightsTableModel(u.getId(),date_exit,truck, driver,u.getNote(),u.getProduct(), weight,total3));
            } catch (ParseException ex) {
                Logger.getLogger(FreightsSearch.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        tableModel.setData(listFreights);
        t_freights.setModel(tableModel);
        modulateTableFreights();
    }//GEN-LAST:event_f_noteKeyReleased

    private void f_productKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_productKeyReleased
        f_product.setText(f_product.getText().toUpperCase());
        tableModel.clear();
        listFreights.clear();
        Long id_truck = trucksDAO.getTruckByBoard(String.valueOf(cb_truck.getSelectedItem()), Long.valueOf(this.IdBusiness));
        List<FreightsModel> t = freightsDAO.getFreightsByProduct(String.valueOf(f_product.getText().toUpperCase()), Long.valueOf(this.IdBusiness), id_truck);
        for(FreightsModel u : t) {
            try {
                String truck = trucksDAO.getBoardTruckById(u.getTruck());
                String driver = driversDAO.getDriverByID(u.getDriver(), Long.valueOf(this.IdBusiness));
                String weight = String.valueOf(decimal.format(u.getWeight())).replace(".", ",");
                String date_exit = date.dateFormatReturn(u.getData_exit());
                String total3 = "R$:"+(decimal.format(u.getTotal3()).replace(".", ","));
                listFreights.add(new FreightsTableModel(u.getId(),date_exit,truck, driver,u.getNote(),u.getProduct(), weight,total3));
            } catch (ParseException ex) {
                Logger.getLogger(FreightsSearch.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        tableModel.setData(listFreights);
        t_freights.setModel(tableModel);
        modulateTableFreights();
    }//GEN-LAST:event_f_productKeyReleased

    private void rb_productActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_productActionPerformed
        f_note.setText("");
        f_product.setText("");
        f_note.setEnabled(false);
        f_product.setEnabled(true);
        rb_note.setSelected(false);
        rb_all_freights.setSelected(false);
        f_product.grabFocus();
    }//GEN-LAST:event_rb_productActionPerformed

    private void cb_truckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_truckActionPerformed
        rb_all_freights.setSelected(false);
        if(!" -".equals(cb_truck.getSelectedItem())){
            tableModel.clear();
        listFreights.clear();
        Long id_truck = trucksDAO.getTruckByBoard(String.valueOf(cb_truck.getSelectedItem()), Long.valueOf(this.IdBusiness));
        List<FreightsModel> t = freightsDAO.getFreightsByTruck(id_truck, Long.valueOf(this.IdBusiness));
        for(FreightsModel u : t) {
                try {
                    String truck = trucksDAO.getBoardTruckById(u.getTruck());
                    String driver = driversDAO.getDriverByID(u.getDriver(), Long.valueOf(this.IdBusiness));
                    String weight = String.valueOf(decimal.format(u.getWeight())).replace(".", ",");
                    String date_exit = date.dateFormatReturn(u.getData_exit());
                    String total3 = "R$:"+(decimal.format(u.getTotal3()).replace(".", ","));
                    listFreights.add(new FreightsTableModel(u.getId(),date_exit,truck, driver,u.getNote(),u.getProduct(), weight,total3));
                } catch (ParseException ex) {
                    Logger.getLogger(FreightsSearch.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        tableModel.setData(listFreights);
        t_freights.setModel(tableModel);
        modulateTableFreights();
        }
    }//GEN-LAST:event_cb_truckActionPerformed

    private void b_selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_selectActionPerformed
        if(t_freights.getSelectedRowCount() > 0){
            Object obj = t_freights.getValueAt(t_freights.getSelectedRow(), 0);
            FreightsModel objFreights = freightsDAO.getFreightsByIdObj(Long.valueOf(obj.toString()), Long.valueOf(this.IdBusiness));
            deskPane.add(freightsForm);
            Centraliza.setCentro(freightsForm, deskPane, WIDTH, HEIGHT);
            freightsForm.deskPane = deskPane;
            freightsForm.freights = objFreights;
            freightsForm.IdBusiness = this.IdBusiness;
            freightsForm.setVisible(true);
            freightsForm.setFreights();

            this.dispose();
        }else{
            JOptionPane.showMessageDialog(rootPane, "Selecione um frete para continuar.", "Fretes", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_b_selectActionPerformed

    private void t_freightsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_freightsMouseClicked
        if(evt.getClickCount() > 1){
            java.awt.event.ActionEvent evtt = null;
            b_selectActionPerformed(evtt);
        }
    }//GEN-LAST:event_t_freightsMouseClicked

    private void rb_all_freightsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_all_freightsActionPerformed
        cb_truck.setSelectedIndex(0);
        rb_note.setSelected(false);
        rb_product.setSelected(false);
        f_note.setEnabled(false);
        f_product.setEnabled(false);
        f_note.setText("");
        f_product.setText("");

            tableModel.clear();
        listFreights.clear();
        Long id_truck = trucksDAO.getTruckByBoard(String.valueOf(cb_truck.getSelectedItem()), Long.valueOf(this.IdBusiness));
        List<FreightsModel> t = freightsDAO.getAllFreights(Long.valueOf(this.IdBusiness));
        for(FreightsModel u : t) {
                try {
                    String truck = trucksDAO.getBoardTruckById(u.getTruck());
                    String driver = driversDAO.getDriverByID(u.getDriver(), Long.valueOf(this.IdBusiness));
                    String weight = String.valueOf(decimal.format(u.getWeight())).replace(".", ",");
                    String date_exit = date.dateFormatReturn(u.getData_exit());
                    String total3 = "R$:"+(decimal.format(u.getTotal3()).replace(".", ","));
                    listFreights.add(new FreightsTableModel(u.getId(),date_exit,truck, driver,u.getNote(),u.getProduct(), weight,total3));
                } catch (ParseException ex) {
                    Logger.getLogger(FreightsSearch.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        tableModel.setData(listFreights);
        t_freights.setModel(tableModel);
        modulateTableFreights();
    }//GEN-LAST:event_rb_all_freightsActionPerformed

    private void modulateTableFreights() {
        t_freights.getColumnModel().getColumn(0).setPreferredWidth(3);
        t_freights.getColumnModel().getColumn(1).setPreferredWidth(55);
        t_freights.getColumnModel().getColumn(2).setPreferredWidth(40);
        t_freights.getColumnModel().getColumn(3).setPreferredWidth(200);
        t_freights.getColumnModel().getColumn(4).setPreferredWidth(85);
        t_freights.getColumnModel().getColumn(5).setPreferredWidth(190);
        t_freights.getColumnModel().getColumn(6).setPreferredWidth(35);
        t_freights.getColumnModel().getColumn(7).setPreferredWidth(55);
        t_freights.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_save;
    private javax.swing.JButton b_select;
    private javax.swing.JComboBox cb_truck;
    private javax.swing.JTextField f_note;
    private javax.swing.JTextField f_product;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rb_all_freights;
    private javax.swing.JRadioButton rb_note;
    private javax.swing.JRadioButton rb_product;
    private javax.swing.JTable t_freights;
    // End of variables declaration//GEN-END:variables
}
