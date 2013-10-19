
package br.com.cadoresistemas.williamcadore.GUI;

import br.com.cadoresistemas.williamcadore.DAO.DriversDAO;
import br.com.cadoresistemas.williamcadore.ModelsForm.DriversModel;
import br.com.cadoresistemas.williamcadore.TableModels.DriversTableModel;
import br.com.cadoresistemas.williamcadore.Utils.Util;
import com.towel.el.annotation.AnnotationResolver;
import com.towel.swing.table.ObjectTableModel;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class DriversSearch extends javax.swing.JInternalFrame {

    AnnotationResolver resolver = new AnnotationResolver(DriversTableModel.class);
    ObjectTableModel<DriversTableModel> tableModel = new ObjectTableModel<>(resolver, "id,full_name,cpf,birthday,phone,sex,active");

    List<DriversTableModel> listDrivers = new ArrayList<>();

    public DriversSearch() {
        initComponents();

        tableModel.clear();
        listDrivers.clear();
        t_drivers.setModel(tableModel);

        f_name.setText("");
        f_name.setEnabled(true);
        rb_name.setSelected(true);

        f_cpf.setText("");
        f_cpf.setEnabled(false);
        rb_cpf.setSelected(false);
        this.setFrameIcon(new ImageIcon(this.getClass().getResource("/Images/iconTruckSystem.jpg")));
    }

    Util date = new Util();
    public String IdBusiness = null;
    private DriversDAO driversDAO = new DriversDAO();
    public DriversForm driversForm = null;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rb_name = new javax.swing.JRadioButton();
        rb_cpf = new javax.swing.JRadioButton();
        f_name = new javax.swing.JTextField();
        f_cpf = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_drivers = new javax.swing.JTable();
        b_select = new javax.swing.JButton();
        b_save = new javax.swing.JButton();

        setTitle("Consulta De Motoristas");
        setToolTipText("");
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        rb_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb_name.setText("Nome:");
        rb_name.setFocusable(false);
        rb_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_nameActionPerformed(evt);
            }
        });

        rb_cpf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb_cpf.setText("CPF:");
        rb_cpf.setFocusable(false);
        rb_cpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_cpfActionPerformed(evt);
            }
        });

        f_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_nameKeyReleased(evt);
            }
        });

        try {
            f_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        f_cpf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_cpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_cpfKeyReleased(evt);
            }
        });

        t_drivers.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        t_drivers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        t_drivers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_driversMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(t_drivers);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rb_name)
                            .addComponent(rb_cpf))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(f_name, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(f_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_name)
                    .addComponent(f_name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_cpf)
                    .addComponent(f_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_save)
                    .addComponent(b_select))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_saveActionPerformed
        this.dispose();
    }//GEN-LAST:event_b_saveActionPerformed

    private void b_selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_selectActionPerformed
        if(t_drivers.getSelectedRowCount() > 0){
            Object obj = t_drivers.getValueAt(t_drivers.getSelectedRow(),0);
            DriversModel driver = driversDAO.getDriversByIdObj(Integer.valueOf(obj.toString()), Long.valueOf(this.IdBusiness));
            driversForm.drivers = driver;
            driversForm.setDriver();
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(rootPane, "Selecione um Motorista para continuar.", "Cadore Sistemas", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_b_selectActionPerformed

    private void rb_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_nameActionPerformed
        f_cpf.setText("");
        f_cpf.setEnabled(false);
        f_name.setText("");
        f_name.setEnabled(true);
        rb_cpf.setSelected(false);
        f_name.grabFocus();
        tableModel.clear();
        listDrivers.clear();
        t_drivers.setModel(tableModel);
    }//GEN-LAST:event_rb_nameActionPerformed

    private void rb_cpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_cpfActionPerformed
        f_name.setText("");
        f_name.setEnabled(false);
        f_cpf.setText("");
        f_cpf.setEnabled(true);
        rb_name.setSelected(false);
        f_cpf.grabFocus();
        tableModel.clear();
        listDrivers.clear();
        t_drivers.setModel(tableModel);
    }//GEN-LAST:event_rb_cpfActionPerformed

    private void f_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_nameKeyReleased
        f_name.setText(f_name.getText().toUpperCase());
        tableModel.clear();
        listDrivers.clear();
        List<DriversModel> driver = driversDAO.getDriversByFull_Name(String.valueOf(f_name.getText().toUpperCase()), Long.valueOf(this.IdBusiness));
        for(DriversModel u : driver) {
            try {
                String birthday = date.dateFormatReturn(u.getBirthday());
                String sex;
                if("M".equals(u.getSex())) {
                    sex = "Masculino";
                }
                else {
                    sex = "Feminino";
                }
                listDrivers.add(new DriversTableModel(u.getId(),u.getFull_name(), u.getCpf(), birthday,u.getPhone(), sex,u.getActive()));
            } catch (ParseException ex) {
                Logger.getLogger(DriversSearch.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        tableModel.setData(listDrivers);
        t_drivers.setModel(tableModel);
        modulateTableDriver();
    }//GEN-LAST:event_f_nameKeyReleased

    private void f_cpfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_cpfKeyReleased
        tableModel.clear();
        listDrivers.clear();
        List<DriversModel> driver = driversDAO.getDriversByCpf(String.valueOf(f_cpf.getText()), Long.valueOf(this.IdBusiness));
        for(DriversModel u : driver) {
            try {
                String birthday = date.dateFormatReturn(u.getBirthday());
                String sex;
                if("M".equals(u.getSex())) {
                    sex = "Masculino";
                }
                else {
                    sex = "Feminino";
                }
                listDrivers.add(new DriversTableModel(u.getId(),u.getFull_name(), u.getCpf(),birthday,u.getPhone(), sex,u.getActive()));
            } catch (ParseException ex) {
                Logger.getLogger(DriversSearch.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        tableModel.setData(listDrivers);
        t_drivers.setModel(tableModel);
        modulateTableDriver();
    }//GEN-LAST:event_f_cpfKeyReleased

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        f_name.grabFocus();
    }//GEN-LAST:event_formFocusGained

    private void t_driversMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_driversMouseClicked
        if(evt.getClickCount() > 1){
            java.awt.event.ActionEvent evtt = null;
            b_selectActionPerformed(evtt);
        }
    }//GEN-LAST:event_t_driversMouseClicked

    private void modulateTableDriver() {
        t_drivers.getColumnModel().getColumn(0).setPreferredWidth(10);
        t_drivers.getColumnModel().getColumn(1).setPreferredWidth(350);
        t_drivers.getColumnModel().getColumn(2).setPreferredWidth(65);
        t_drivers.getColumnModel().getColumn(3).setPreferredWidth(50);
        t_drivers.getColumnModel().getColumn(4).setPreferredWidth(60);
        t_drivers.getColumnModel().getColumn(5).setPreferredWidth(25);
        t_drivers.getColumnModel().getColumn(6).setPreferredWidth(25);
        t_drivers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_save;
    private javax.swing.JButton b_select;
    private javax.swing.JFormattedTextField f_cpf;
    private javax.swing.JTextField f_name;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rb_cpf;
    private javax.swing.JRadioButton rb_name;
    private javax.swing.JTable t_drivers;
    // End of variables declaration//GEN-END:variables
}
