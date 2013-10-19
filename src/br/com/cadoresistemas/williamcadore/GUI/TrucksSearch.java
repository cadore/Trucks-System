package br.com.cadoresistemas.williamcadore.GUI;

import br.com.cadoresistemas.williamcadore.DAO.DriversDAO;
import br.com.cadoresistemas.williamcadore.DAO.TractionDAO;
import br.com.cadoresistemas.williamcadore.DAO.TrucksDAO;
import br.com.cadoresistemas.williamcadore.ModelsForm.TrucksModel;
import br.com.cadoresistemas.williamcadore.TableModels.TrucksTableModel;
import com.towel.el.annotation.AnnotationResolver;
import com.towel.swing.table.ObjectTableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class TrucksSearch extends javax.swing.JInternalFrame {

    AnnotationResolver resolver = new AnnotationResolver(TrucksTableModel.class);
    ObjectTableModel<TrucksTableModel> tableModel = new ObjectTableModel<>(resolver, "id,board,mark,model"
            + ",color,traction,driver");

    List<TrucksTableModel> listTruck = new ArrayList<>();

    public TrucksSearch() {
        initComponents();
        rb_board.setSelected(true);
        f_board.setText("");
        f_board.setEnabled(true);
        f_board.grabFocus();
        this.setFrameIcon(new ImageIcon(this.getClass().getResource("/Images/iconTruckSystem.jpg")));
    }

    public String IdBusiness = null;
    private TrucksDAO trucksDAO = new TrucksDAO();
    private DriversDAO driversDAO = new DriversDAO();
    private TractionDAO tractionDAO = new TractionDAO();
    public TrucksForm trucksForm = null;
    private String status_f = "0";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        b_cancel = new javax.swing.JButton();
        b_select = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_trucks = new javax.swing.JTable();
        f_board = new javax.swing.JTextField();
        f_model = new javax.swing.JTextField();
        rb_board = new javax.swing.JRadioButton();
        rb_model = new javax.swing.JRadioButton();

        setTitle("Consulta De Veiculos");

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

        t_trucks.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        t_trucks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        t_trucks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_trucksMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(t_trucks);

        f_board.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_board.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_boardKeyReleased(evt);
            }
        });

        f_model.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_model.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_modelKeyReleased(evt);
            }
        });

        rb_board.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb_board.setText("Placa:");
        rb_board.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_boardActionPerformed(evt);
            }
        });

        rb_model.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb_model.setText("Modelo:");
        rb_model.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_modelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 916, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rb_board)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(f_board, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rb_model)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(f_model, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(b_select, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(f_board, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f_model, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rb_board)
                    .addComponent(rb_model))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_cancel)
                    .addComponent(b_select))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_b_cancelActionPerformed

    private void b_selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_selectActionPerformed
         if(this.IdBusiness == null){}else if(this.IdBusiness != null){
            if(t_trucks.getRowCount() > 0){
                Object obj = t_trucks.getValueAt(t_trucks.getSelectedRow(), 0);
                TrucksModel objTruck = trucksDAO.getTrucksByIdObj(Integer.valueOf(obj.toString()), Long.valueOf(this.IdBusiness));
                trucksForm.trucks = objTruck;
                trucksForm.IdBusiness = this.IdBusiness;
                trucksForm.setTruck();
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(rootPane, "Selecione um Veiculo para continuar.", "Cadore Sistemas", JOptionPane.INFORMATION_MESSAGE);
            }
         }
    }//GEN-LAST:event_b_selectActionPerformed

    private void t_trucksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_trucksMouseClicked
        if(evt.getClickCount() > 1){
            java.awt.event.ActionEvent evtt = null;
            b_selectActionPerformed(evtt);
        }
    }//GEN-LAST:event_t_trucksMouseClicked

    private void f_boardKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_boardKeyReleased
        if(f_board.getText().trim().length() == 3 && "0".equals(status_f)){
            String b = f_board.getText();
            f_board.setText(b + "-");
            status_f = "4";
        }
        if(f_board.getText().trim().length() == 3){
            status_f = "0";
        }
        String board = f_board.getText();
        String board_ = board.toUpperCase();
        f_board.setText(board_);
        tableModel.clear();
        listTruck.clear();
        List<TrucksModel> truck = trucksDAO.getTrucksByBoard(f_board.getText().toUpperCase(), Long.valueOf(this.IdBusiness));
        for(TrucksModel u : truck) {
            String traction = tractionDAO.getTractionById(u.getTraction());
            String driver = driversDAO.getDriverByID(u.getDriver(), Long.valueOf(this.IdBusiness));
            listTruck.add(new TrucksTableModel(u.getId(),u.getBoard(),u.getMark(), u.getModel(), u.getColor(), traction, driver));
        }
        tableModel.setData(listTruck);
        t_trucks.setModel(tableModel);
        modulateTableTrucks();
    }//GEN-LAST:event_f_boardKeyReleased

    private void f_modelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_modelKeyReleased
        f_model.setText(f_model.getText().toUpperCase());
        tableModel.clear();
        listTruck.clear();
        List<TrucksModel> truck = trucksDAO.getTrucksByModel(f_model.getText().toUpperCase(), Long.valueOf(this.IdBusiness));
        for(TrucksModel u : truck) {
            String traction = tractionDAO.getTractionById(u.getTraction());
            String driver = driversDAO.getDriverByID(u.getDriver(), Long.valueOf(this.IdBusiness));
            listTruck.add(new TrucksTableModel(u.getId(),u.getBoard(),u.getMark(), u.getModel(), u.getColor(), traction, driver));
        }
        tableModel.setData(listTruck);
        t_trucks.setModel(tableModel);
        modulateTableTrucks();
    }//GEN-LAST:event_f_modelKeyReleased

    private void rb_boardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_boardActionPerformed
        rb_board.setSelected(true);
        rb_model.setSelected(false);
        f_board.setText("");
        f_model.setText("");
        f_board.grabFocus();
    }//GEN-LAST:event_rb_boardActionPerformed

    private void rb_modelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_modelActionPerformed
        rb_board.setSelected(false);
        rb_model.setSelected(true);
        f_board.setText("");
        f_model.setText("");
        f_model.grabFocus();
    }//GEN-LAST:event_rb_modelActionPerformed

    private void modulateTableTrucks() {
        t_trucks.getColumnModel().getColumn(0).setPreferredWidth(2);
        t_trucks.getColumnModel().getColumn(1).setPreferredWidth(40);
        t_trucks.getColumnModel().getColumn(2).setPreferredWidth(35);
        t_trucks.getColumnModel().getColumn(3).setPreferredWidth(80);
        t_trucks.getColumnModel().getColumn(4).setPreferredWidth(30);
        t_trucks.getColumnModel().getColumn(5).setPreferredWidth(30);
        t_trucks.getColumnModel().getColumn(6).setPreferredWidth(230);
        t_trucks.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_cancel;
    private javax.swing.JButton b_select;
    private javax.swing.JTextField f_board;
    private javax.swing.JTextField f_model;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rb_board;
    private javax.swing.JRadioButton rb_model;
    private javax.swing.JTable t_trucks;
    // End of variables declaration//GEN-END:variables
}
