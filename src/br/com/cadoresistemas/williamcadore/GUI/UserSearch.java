package br.com.cadoresistemas.williamcadore.GUI;

import br.com.cadoresistemas.williamcadore.DAO.UserDAO;
import br.com.cadoresistemas.williamcadore.ModelsForm.UserModel;
import br.com.cadoresistemas.williamcadore.TableModels.UserTableModel;
import com.towel.el.annotation.AnnotationResolver;
import com.towel.swing.table.ObjectTableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;

public class UserSearch extends javax.swing.JInternalFrame {

    AnnotationResolver resolver = new AnnotationResolver(UserTableModel.class);
    ObjectTableModel<UserTableModel> tableModel = new ObjectTableModel<>(resolver, "id,nome,login,Administrador,inativo,reports");

    List<UserTableModel> listUser = new ArrayList<>();

    public UserForm formUser = null;
    public String IdBusiness = null;

    public UserSearch() {
        initComponents();
        f_login.setText("");
        f_login.setEnabled(false);
        rb_login.setSelected(false);

        f_name.setText("");
        f_name.setEnabled(true);
        rb_name.setSelected(true);
        this.setFrameIcon(new ImageIcon(this.getClass().getResource("/Images/iconTruckSystem.jpg")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        t_users = new javax.swing.JTable();
        f_name = new javax.swing.JTextField();
        f_login = new javax.swing.JTextField();
        b_save = new javax.swing.JButton();
        b_select = new javax.swing.JButton();
        rb_login = new javax.swing.JRadioButton();
        rb_name = new javax.swing.JRadioButton();

        setTitle("Consulta De Usuário");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        t_users.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        t_users.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        t_users.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_usersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(t_users);

        f_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f_nameActionPerformed(evt);
            }
        });
        f_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                f_nameFocusGained(evt);
            }
        });
        f_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_nameKeyReleased(evt);
            }
        });

        f_login.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f_loginActionPerformed(evt);
            }
        });
        f_login.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                f_loginFocusGained(evt);
            }
        });
        f_login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_loginKeyReleased(evt);
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

        b_select.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_select.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png"))); // NOI18N
        b_select.setText("Selecionar");
        b_select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_selectActionPerformed(evt);
            }
        });

        rb_login.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb_login.setText("Login:");
        rb_login.setFocusable(false);
        rb_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_loginActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rb_login)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(f_login, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rb_name)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(f_name, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(b_select, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_save, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_name)
                    .addComponent(f_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(f_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rb_login))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_save)
                    .addComponent(b_select))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void f_loginKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_loginKeyReleased
        tableModel.clear();
        listUser.clear();
        List<UserModel> users = new UserDAO().getUsersByLogin(f_login.getText().toUpperCase(), Long.valueOf(this.IdBusiness));
        for(UserModel u : users) {
            listUser.add(new UserTableModel(u.getId(), u.getFullName(), u.getLogin(), u.getAdmin(), u.getInactiveUser(),u.getReports()));
        }
        tableModel.setData(listUser);
        t_users.setModel(tableModel);
        modulateTableDriver();
    }//GEN-LAST:event_f_loginKeyReleased

    private void f_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_nameKeyReleased
        f_name.setText(f_name.getText().toUpperCase());
        tableModel.clear();
        listUser.clear();
        List<UserModel> users = new UserDAO().getUsersByName(f_name.getText().toUpperCase(), Long.valueOf(this.IdBusiness));
        for(UserModel u : users) {
            listUser.add(new UserTableModel(u.getId(), u.getFullName(), u.getLogin(), u.getAdmin(), u.getInactiveUser(),u.getReports()));
        }
        tableModel.setData(listUser);
        t_users.setModel(tableModel);
        modulateTableDriver();
    }//GEN-LAST:event_f_nameKeyReleased

    private void f_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f_loginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_f_loginActionPerformed

    private void b_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_saveActionPerformed
        this.dispose();
    }//GEN-LAST:event_b_saveActionPerformed

    private void f_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_f_nameActionPerformed

    private void f_loginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_loginFocusGained
        f_name.setText("");
    }//GEN-LAST:event_f_loginFocusGained

    private void f_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_nameFocusGained
        f_login.setText("");
    }//GEN-LAST:event_f_nameFocusGained

    private void rb_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_nameActionPerformed
        f_login.setText("");
        f_login.setEnabled(false);
        f_name.setText("");
        f_name.setEnabled(true);
        rb_login.setSelected(false);
        f_name.grabFocus();
        tableModel.clear();
        listUser.clear();
        t_users.setModel(tableModel);
    }//GEN-LAST:event_rb_nameActionPerformed

    private void rb_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_loginActionPerformed
        f_name.setText("");
        f_name.setEnabled(false);
        f_login.setText("");
        f_login.setEnabled(true);
        rb_name.setSelected(false);
        f_login.grabFocus();
        tableModel.clear();
        listUser.clear();
        t_users.setModel(tableModel);
    }//GEN-LAST:event_rb_loginActionPerformed

    private void b_selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_selectActionPerformed
        if(t_users.getSelectedRowCount() > 0){
            Object obj = t_users.getValueAt(t_users.getSelectedRow(),0);
            UserModel user = new UserDAO().getUsersByIdObj(Integer.valueOf(obj.toString()), Long.valueOf(this.IdBusiness));
            formUser.user = user;
            formUser.SetUser();
            this.dispose();
        }
    }//GEN-LAST:event_b_selectActionPerformed

    private void t_usersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_usersMouseClicked
         if(evt.getClickCount() > 1){
            Object obj = t_users.getValueAt(t_users.getSelectedRow(),0);
            UserModel user = new UserDAO().getUsersByIdObj(Integer.valueOf(obj.toString()), Long.valueOf(this.IdBusiness));
            formUser.user = user;
            formUser.SetUser();
            this.dispose();
         }
    }//GEN-LAST:event_t_usersMouseClicked

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        tableModel.clear();
        listUser.clear();
        List<UserModel> users = new UserDAO().getUsers(Long.valueOf(this.IdBusiness));
        for(UserModel u : users) {
            listUser.add(new UserTableModel(u.getId(), u.getFullName(), u.getLogin(), u.getAdmin(), u.getInactiveUser(),u.getReports()));
        }
        tableModel.setData(listUser);
        t_users.setModel(tableModel);
        modulateTableDriver();
    }//GEN-LAST:event_formInternalFrameOpened

    private void modulateTableDriver() {
        t_users.getColumnModel().getColumn(0).setPreferredWidth(5);
        t_users.getColumnModel().getColumn(1).setPreferredWidth(200);
        t_users.getColumnModel().getColumn(2).setPreferredWidth(30);
        t_users.getColumnModel().getColumn(3).setPreferredWidth(30);
        t_users.getColumnModel().getColumn(4).setPreferredWidth(30);
        t_users.getColumnModel().getColumn(4).setPreferredWidth(30);
        t_users.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_save;
    private javax.swing.JButton b_select;
    private javax.swing.JTextField f_login;
    private javax.swing.JTextField f_name;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rb_login;
    private javax.swing.JRadioButton rb_name;
    private javax.swing.JTable t_users;
    // End of variables declaration//GEN-END:variables
}
