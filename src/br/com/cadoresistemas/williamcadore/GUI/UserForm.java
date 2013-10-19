package br.com.cadoresistemas.williamcadore.GUI;

import br.com.cadoresistemas.williamcadore.DAO.UserDAO;
import br.com.cadoresistemas.williamcadore.ModelsForm.UserModel;
import br.com.cadoresistemas.williamcadore.Utils.Centraliza;
import br.com.cadoresistemas.williamcadore.Utils.Util;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class UserForm extends javax.swing.JInternalFrame {
    public UserForm() {
        initComponents();
        f_login.grabFocus();
        b_update_pwd.setVisible(false);
        this.setFrameIcon(new ImageIcon(this.getClass().getResource("/Images/iconTruckSystem.jpg")));
    }

    public JDesktopPane deskPane = null;
    public String IdBusiness = null;
    public UserModel user = new UserModel();
    private UserDAO userDAO = new UserDAO();
    public String status = "save";
    private Util ut = new Util();
    private boolean isPass = false;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ck_admin = new javax.swing.JCheckBox();
        ck_inactive = new javax.swing.JCheckBox();
        ck_reports = new javax.swing.JCheckBox();
        f_email = new javax.swing.JTextField();
        f_name = new javax.swing.JTextField();
        f_phone = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        f_birthday = new javax.swing.JFormattedTextField();
        b_search = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        f_login = new javax.swing.JTextField();
        b_update_pwd = new javax.swing.JButton();
        f_id = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        b_save = new javax.swing.JButton();
        b_cancel = new javax.swing.JButton();

        setTitle("Usuarios                                 ");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Cadastro de Usuários");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("*Nome:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("*E-Mail:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("*Telefone:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        ck_admin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ck_admin.setText("Administrador");
        ck_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ck_adminActionPerformed(evt);
            }
        });

        ck_inactive.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ck_inactive.setText("Inativo");
        ck_inactive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ck_inactiveActionPerformed(evt);
            }
        });

        ck_reports.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ck_reports.setText("Acessa Relatórios?");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(ck_admin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ck_reports)
                .addGap(18, 18, 18)
                .addComponent(ck_inactive)
                .addContainerGap(114, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ck_admin)
                    .addComponent(ck_inactive)
                    .addComponent(ck_reports))
                .addGap(23, 23, 23))
        );

        f_email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                f_emailFocusGained(evt);
            }
        });

        f_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                f_nameFocusGained(evt);
            }
        });

        try {
            f_phone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        f_phone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_phone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                f_phoneFocusGained(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("*Data de Nascimento:");

        try {
            f_birthday.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        f_birthday.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_birthday.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                f_birthdayFocusLost(evt);
            }
            public void focusGained(java.awt.event.FocusEvent evt) {
                f_birthdayFocusGained(evt);
            }
        });

        b_search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Search.png"))); // NOI18N
        b_search.setText("Procurar");
        b_search.setFocusable(false);
        b_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_searchActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("*Login:");

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
            public void keyPressed(java.awt.event.KeyEvent evt) {
                f_loginKeyPressed(evt);
            }
        });

        b_update_pwd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_update_pwd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Refresh.png"))); // NOI18N
        b_update_pwd.setText("Alterar senha do usuário");
        b_update_pwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_update_pwdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(f_login)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(b_search, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(f_birthday, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(94, 94, 94)
                        .addComponent(f_name))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(f_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b_update_pwd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(f_email))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(f_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(b_search)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(f_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(f_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(f_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(f_birthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(b_update_pwd, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        f_id.setEditable(false);
        f_id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        f_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f_idActionPerformed(evt);
            }
        });
        f_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                f_idKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("ID:");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(10, 10, 10)
                        .addComponent(f_id, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(b_save, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8)
                    .addComponent(f_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_cancel)
                    .addComponent(b_save))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static String md5(String pwd){
		String password = "";
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		BigInteger hash = new BigInteger(1, md.digest(pwd.getBytes()));
		password = hash.toString(16);
		return password;
	}

    public void SetUser(){
        try {
            f_id.setText(user.getId().toString());
            f_name.setText(user.getFullName());
            f_email.setText(user.getEmail());
            f_phone.setText(user.getContact());
            f_birthday.setText(ut.dateFormatReturn(user.getBirthdate()));
            f_login.setText(user.getLogin());

            if(user.getAdmin() == true){
              ck_admin.setSelected(true);
            }else{
                ck_admin.setSelected(false);
            }

            if(user.getInactiveUser() == true){
                ck_inactive.setSelected(true);
            }else{
                ck_inactive.setSelected(false);
            }

            if(user.getReports() == true){
                ck_reports.setSelected(true);
            }else{
                ck_reports.setSelected(false);
            }

            status = "unlock";
            b_save.setText("Editar");
            f_name.setEditable(false);
            f_email.setEditable(false);
            f_phone.setEditable(false);
            f_birthday.setEditable(false);
            f_login.setEditable(false);
            ck_admin.setEnabled(false);
            ck_inactive.setEnabled(false);
            ck_reports.setEnabled(false);
            b_update_pwd.setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void f_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f_loginActionPerformed

    }//GEN-LAST:event_f_loginActionPerformed

    private void f_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f_idActionPerformed

    }//GEN-LAST:event_f_idActionPerformed

    private void jPanel1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel1AncestorAdded

    }//GEN-LAST:event_jPanel1AncestorAdded

    private void b_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_saveActionPerformed
        user = new UserModel();
        JLabel label1 = new JLabel("Digite uma senha para o usuário:");
        JPasswordField jpf = new JPasswordField();
         if("save".equals(status)) {
            if  ((f_name.getText().isEmpty())
                    || (f_phone.getText().trim().length() == 9)
                    || (f_birthday.getText().trim().length() == 4)
                    || (f_login.getText().isEmpty())
                    || (f_email.getText().isEmpty())
                    || isPass == false) {
                JOptionPane.showMessageDialog(rootPane, "Campos com ' * ' São obrigatórios!", "Cadastro de Usuarios", JOptionPane.WARNING_MESSAGE);
            } else if(f_email.getText().indexOf("@") <= 1 || f_email.getText().indexOf("@") == 0 && f_email.getText().indexOf(".") <= 0){
                    JOptionPane.showMessageDialog(rootPane, "O E-Mail: " + f_email.getText() + " Não é valido!", "Usuários", JOptionPane.WARNING_MESSAGE);
                }else if(ut.isValidLoginDB(f_login.getText().toUpperCase()) == false){
                    JOptionPane.showMessageDialog(rootPane, "O Login: "+f_login.getText()+" já esta sendo usado.\nPor favor escolha outro.", "Usuários | Cadore Sistemas", JOptionPane.INFORMATION_MESSAGE);
                    f_login.setText("");
                    f_login.grabFocus();
                }else{
                    try {
                            boolean admin = ck_admin.isSelected() == true ? true : false;
                            boolean reports = ck_reports.isSelected() == true ? true : false;
                            boolean inactive_user = ck_inactive.isSelected() == true ? true : false;
                            user.setFullName(f_name.getText().toUpperCase());
                            user.setEmail(f_email.getText().toLowerCase());
                            user.setContact(f_phone.getText().toUpperCase());
                            user.setBirthdate(ut.dateFormatInsert(f_birthday.getText().toUpperCase()));
                            user.setLogin(f_login.getText().toUpperCase());

                            user.setAdmin(admin);
                            user.setInactiveUser(inactive_user);
                            user.setCreated_at(ut.dateFormatInsert(ut.getDateddMMyyyy().toUpperCase()));
                            user.setUpdated(ut.dateFormatInsert(ut.getDateddMMyyyy().toUpperCase()));
                            user.setId_Business(Long.valueOf(IdBusiness));
                            user.setReports(reports);
                            user.setInactive(false);
                            int i = JOptionPane.showConfirmDialog(null, new Object[]{label1, jpf}, "Usuários", JOptionPane.OK_CANCEL_OPTION);
                            if(i == JOptionPane.OK_OPTION){
                                String pwdSave = String.valueOf(jpf.getPassword());
                                if(!"".equals(pwdSave)){
                                    String pwd = md5(pwdSave.toUpperCase());
                                    user.setPassword(pwd);
                                    userDAO.adiciona(user);
                                    JOptionPane.showMessageDialog(null, "Usuário: " + f_name.getText() + " foi Cadastrado com Sucesso! ");
                                    this.dispose();
                                }
                            }
                        } catch (ParseException ex) {
                            Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
                        }

         }
             }else if ("update".equals(status)) {
                if((f_name.getText().isEmpty())
                          || (f_phone.getText().trim().length() == 9)
                          || (f_birthday.getText().trim().length() == 4)
                          || isPass == false) {
                      JOptionPane.showMessageDialog(rootPane, "Campos com ' * ' São obrigatórios!", "Cadastro de Usuarios", JOptionPane.WARNING_MESSAGE);
                  }else {
                    if(f_email.getText().indexOf("@") <= 1 || f_email.getText().indexOf("@") == 0 && f_email.getText().indexOf(".") <= 0){
                          JOptionPane.showMessageDialog(rootPane, "O E-Mail: " + f_email.getText() + " Não é valido!", "Usuários", JOptionPane.WARNING_MESSAGE);
                        }else{
                              try {
                                  boolean admin = ck_admin.isSelected() == true ? true : false;
                                  boolean reports = ck_reports.isSelected() == true ? true : false;
                                  boolean inactive_user = ck_inactive.isSelected() == true ? true : false;
                                  user.setFullName(f_name.getText().toUpperCase());
                                  user.setEmail(f_email.getText().toLowerCase());
                                  user.setContact(f_phone.getText().toUpperCase());
                                  user.setBirthdate(ut.dateFormatInsert(f_birthday.getText().toUpperCase()));
                                  user.setId(Long.valueOf(f_id.getText().toUpperCase()));
                                  user.setAdmin(admin);
                                  user.setInactiveUser(inactive_user);
                                  user.setUpdated(ut.dateFormatInsert(ut.getDateddMMyyyy().toUpperCase()));
                                  user.setId_Business(Long.valueOf(IdBusiness));
                                  user.setInactive(false);
                                  user.setReports(reports);
                                  userDAO.atualiza(user);
                                  JOptionPane.showMessageDialog(null, "Usuário: " + f_name.getText() + " foi Atualizado com Sucesso! ");
                                  status = "save";
                                  this.dispose();
                              } catch (ParseException ex) {
                                  Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
                              }
                    }
                }
              }else if("unlock".equals(status)){
                  b_save.setText("Atualizar");
                  f_name.setEditable(true);
                  f_email.setEditable(true);
                  f_phone.setEditable(true);
                  f_birthday.setEditable(true);
                  ck_admin.setEnabled(true);
                  ck_inactive.setEnabled(true);
                  ck_reports.setEnabled(true);
                  f_name.grabFocus();
                  status = "update";
              }
    }//GEN-LAST:event_b_saveActionPerformed

    private void b_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelActionPerformed
      if("unlock".equals(status)){
                f_id.setText("");
                f_name.setText("");
                f_email.setText("");
                f_phone.setText("");
                f_birthday.setText("");
                f_login.setText("");
                ck_admin.setSelected(false);
                ck_inactive.setSelected(false);
                ck_reports.setSelected(false);
                user = null;
                status = "save";
                b_save.setText("Salvar");
                f_name.setEditable(true);
                f_email.setEditable(true);
                f_phone.setEditable(true);
                f_birthday.setEditable(true);
                f_login.setEditable(true);
                ck_admin.setEnabled(true);
                ck_inactive.setEnabled(true);
                ck_reports.setEnabled(true);
                b_update_pwd.setVisible(false);
                f_login.grabFocus();

        }else if("update".equals(status)){
                status = "unlock";
                b_save.setText("Editar");
                b_update_pwd.setVisible(true);
                f_name.setEditable(false);
                f_email.setEditable(false);
                f_phone.setEditable(false);
                f_birthday.setEditable(false);
                f_login.setEditable(false);
                ck_admin.setEnabled(false);
                ck_inactive.setEnabled(false);
                ck_reports.setEnabled(false);

                user = new UserDAO().getUsersByIdObj(Integer.valueOf(f_id.getText()), Long.valueOf(this.IdBusiness));
                SetUser();

        }else if("save".equals(status)){
           // JOptionPane.showMessageDialog(null, f_phone.getText().trim().length() + " " + f_birthday.getText().trim().length());
            if (!"".equals(f_id.getText()) || !"".equals(f_name.getText()) || !"".equals(f_email.getText()) || f_phone.getText().trim().length() == 14
                  || f_birthday.getText().trim().length() == 10 || !"".equals(f_login.getText()) || ck_admin.isSelected() == true
                  || ck_inactive.isSelected() == true || ck_reports.isSelected() == true){
                  f_id.setText("");
                  f_name.setText("");
                  f_email.setText("");
                  f_phone.setText("");
                  f_birthday.setText("");
                  f_login.setText("");
                  ck_admin.setSelected(false);
                  ck_inactive.setSelected(false);
                  ck_reports.setSelected(false);
                  f_login.grabFocus();
              }else{
                  this.dispose();
            }
        }
    }//GEN-LAST:event_b_cancelActionPerformed

    private void ck_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ck_adminActionPerformed
        if(ck_admin.isSelected() == true){
            ck_reports.setSelected(true);
            ck_reports.setEnabled(false);
        } else if(ck_admin.isSelected() == false){
            ck_reports.setSelected(false);
            ck_reports.setEnabled(true);
        }
    }//GEN-LAST:event_ck_adminActionPerformed

    private void ck_inactiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ck_inactiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ck_inactiveActionPerformed

    private void b_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_searchActionPerformed
      if(!"".equals(f_login.getText())){
            user = new UserDAO().getUsersByLoginObj(f_login.getText().toUpperCase(), Long.valueOf(this.IdBusiness));
            if (user == null) {
                JOptionPane.showMessageDialog(null, "Usuário: " + f_login.getText() + " Não Encontradao Verifique e Tente Novamente! ");
                f_login.grabFocus();
                f_login.selectAll();
                return;
            }
            SetUser();
            }else{
                UserSearch UserS = new UserSearch();
                deskPane.add(UserS);
                Centraliza.setCentro(UserS, deskPane, WIDTH, HEIGHT);
                UserS.formUser = this;
                UserS.IdBusiness = IdBusiness;
                UserS.setVisible(true);
            }
    }//GEN-LAST:event_b_searchActionPerformed

    private void f_idKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_idKeyPressed

    }//GEN-LAST:event_f_idKeyPressed

    private void f_loginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_loginKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_ENTER){
           java.awt.event.ActionEvent evtu = null;
           b_searchActionPerformed(evtu);
        }
    }//GEN-LAST:event_f_loginKeyPressed

    private void f_loginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_loginFocusGained
        f_login.selectAll();
    }//GEN-LAST:event_f_loginFocusGained

    private void f_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_nameFocusGained
        f_name.selectAll();
    }//GEN-LAST:event_f_nameFocusGained

    private void f_emailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_emailFocusGained
        f_email.selectAll();
    }//GEN-LAST:event_f_emailFocusGained

    private void f_phoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_phoneFocusGained
        f_phone.selectAll();
    }//GEN-LAST:event_f_phoneFocusGained

    private void f_birthdayFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_birthdayFocusGained
        f_birthday.selectAll();
    }//GEN-LAST:event_f_birthdayFocusGained

    private void b_update_pwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_update_pwdActionPerformed
        JLabel label1 = new JLabel("Digite a senha atual do usuário:");
        JLabel label2 = new JLabel("Digite a nova senha do usuário:");
        JPasswordField jpf = new JPasswordField();
        int i1 = JOptionPane.showConfirmDialog(null, new Object[]{label1, jpf}, "Usuários", JOptionPane.OK_CANCEL_OPTION);
        if(i1 == JOptionPane.OK_OPTION){
            String pwdSave1 = String.valueOf(jpf.getText());
            String pwd1 = md5(pwdSave1.toUpperCase());
            if(!pwd1.equals(user.getPassword())){
                JOptionPane.showMessageDialog(rootPane, "Senha atual incorreta. Tente novamente.","Usuários",JOptionPane.INFORMATION_MESSAGE);
            }else if(pwd1.equals(user.getPassword())){
                jpf.setText("");
                int i2 = JOptionPane.showConfirmDialog(null, new Object[]{label2, jpf}, "Usuários", JOptionPane.OK_CANCEL_OPTION);
                if(i2 == JOptionPane.OK_OPTION){
                    String pwdSave2 = String.valueOf(jpf.getPassword());
                    if(pwdSave2.trim().length() < 5){
                        JOptionPane.showMessageDialog(rootPane, "Senha deve ser maior que 5(cinco) caracteres.","Usuários",JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        String pwd2 = md5(pwdSave2.toUpperCase());
                        user.setPassword(pwd2);
                        user.setId(Long.valueOf(f_id.getText()));
                        user.setId_Business(Long.valueOf(this.IdBusiness));
                        userDAO.setPwd(user);
                        JOptionPane.showMessageDialog(rootPane, "Senha alterada com sucesso.","Usuários",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        }
    }//GEN-LAST:event_b_update_pwdActionPerformed

    private void f_birthdayFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_birthdayFocusLost
        if(ut.isValidDate(f_birthday.getText()) == false){
            f_birthday.setForeground(Color.RED);
            isPass = false;
        }else{
            f_birthday.setForeground(Color.BLACK);
            isPass = true;
        }
    }//GEN-LAST:event_f_birthdayFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_cancel;
    private javax.swing.JButton b_save;
    private javax.swing.JButton b_search;
    private javax.swing.JButton b_update_pwd;
    private javax.swing.JCheckBox ck_admin;
    private javax.swing.JCheckBox ck_inactive;
    private javax.swing.JCheckBox ck_reports;
    private javax.swing.JFormattedTextField f_birthday;
    private javax.swing.JTextField f_email;
    private javax.swing.JTextField f_id;
    private javax.swing.JTextField f_login;
    private javax.swing.JTextField f_name;
    private javax.swing.JFormattedTextField f_phone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}