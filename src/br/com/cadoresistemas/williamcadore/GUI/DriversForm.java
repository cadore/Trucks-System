package br.com.cadoresistemas.williamcadore.GUI;

import br.com.cadoresistemas.williamcadore.DAO.DriversDAO;
import br.com.cadoresistemas.williamcadore.DAO.UfDAO;
import br.com.cadoresistemas.williamcadore.ModelsForm.DriversModel;
import br.com.cadoresistemas.williamcadore.Utils.Centraliza;
import br.com.cadoresistemas.williamcadore.Utils.Util;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

public class DriversForm extends javax.swing.JInternalFrame {
        public DriversForm() {
        initComponents();
        loadUf();
        this.setFrameIcon(new ImageIcon(this.getClass().getResource("/Images/iconTruckSystem.jpg")));
    }
        private String status = "save";
        public DriversModel drivers = new DriversModel();
        private DriversDAO driversDAO = new DriversDAO();
        public JDesktopPane deskPane = null;
        private Util ut = new Util();
        public String IdBusiness = null;
        private UfDAO ufDAO = new UfDAO();
        public java.util.Date date_db = null;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        f_id = new javax.swing.JTextField();
        b_search = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        f_full_name = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        f_cpf = new javax.swing.JFormattedTextField();
        f_phone = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        f_address = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        f_n = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        f_district = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        f_city = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        f_cep = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        rb_male = new javax.swing.JRadioButton();
        rb_female = new javax.swing.JRadioButton();
        cb_uf = new javax.swing.JComboBox();
        f_phone2 = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        f_n_rg = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        f_phone3 = new javax.swing.JFormattedTextField();
        jLabel20 = new javax.swing.JLabel();
        f_n_cnh = new javax.swing.JTextField();
        f_n_register = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        f_category = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        ck_active = new javax.swing.JCheckBox();
        f_birthday = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        b_cancel = new javax.swing.JButton();
        b_save = new javax.swing.JButton();

        setTitle("Motoristas");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Cadastro de Motoristas");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("ID:");

        f_id.setEditable(false);
        f_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        b_search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Search.png"))); // NOI18N
        b_search.setText("Procurar");
        b_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_searchActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("*Nome Completo:");

        f_full_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_full_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f_full_nameActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("*CPF:");

        try {
            f_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        f_cpf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        try {
            f_phone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        f_phone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("*Telefone 1:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("*Endereço:");

        f_address.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("*Nº:");

        f_n.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("*Bairro:");

        f_district.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("*Cidade:");

        f_city.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("*Cep:");

        try {
            f_cep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        f_cep.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        rb_male.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb_male.setText("Masculino");
        rb_male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_maleActionPerformed(evt);
            }
        });

        rb_female.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb_female.setText("Feminino");
        rb_female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_femaleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(rb_male)
                        .addGap(81, 81, 81))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(rb_female)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(rb_male)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rb_female))
        );

        cb_uf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_uf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ufActionPerformed(evt);
            }
        });

        try {
            f_phone2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        f_phone2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Telefone 2:");

        f_n_rg.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("*RG:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Telefone 3:");

        try {
            f_phone3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        f_phone3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("*Nº CNH:");

        f_n_cnh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        f_n_register.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("*Nº Registro:");

        f_category.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("*Categoria:");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("*UF:");

        ck_active.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ck_active.setText("Ativo Na Empresa?");

        try {
            f_birthday.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        f_birthday.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("*Nascimento:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cb_uf, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel23))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel17)
                                            .addComponent(f_cep, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(ck_active))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(f_city, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(f_n, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(204, 204, 204))
                                    .addComponent(f_district)))
                            .addComponent(f_address, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(f_full_name, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(f_n_rg, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(f_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(f_birthday, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(f_n_cnh, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(f_n_register))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(f_category)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(f_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(f_phone2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel16))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel19)
                                            .addComponent(f_phone3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(16, 16, 16))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(f_full_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(f_n_rg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(f_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(f_birthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(11, 11, 11)
                            .addComponent(jLabel20)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(f_n_cnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel22)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(f_category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(f_n_register, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(f_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(f_phone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(f_phone3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(f_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(f_n, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f_district, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(f_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(f_cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb_uf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ck_active))))
        );

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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(f_id, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(b_search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 3, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(b_save, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(f_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(b_search, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_cancel)
                    .addComponent(b_save))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setDriver(){
        try {
            cb_uf.removeAllItems();
            f_id.setText(drivers.getId().toString());
            f_full_name.setText(drivers.getFull_name());
            f_n_rg.setText(drivers.getN_rg());
            f_cpf.setText(drivers.getCpf());
            f_birthday.setText(ut.dateFormatReturn(drivers.getBirthday()));
            f_n_cnh.setText(drivers.getN_cnh());
            f_n_register.setText(drivers.getN_register());
            f_category.setText(drivers.getCategory());
            f_phone.setText(drivers.getPhone());
            f_phone2.setText(drivers.getPhone2());
            f_phone3.setText(drivers.getPhone3());
            f_address.setText(drivers.getAddres());
            f_n.setText(drivers.getN());
            f_district.setText(drivers.getDistrict());
            f_city.setText(drivers.getCity());
            cb_uf.addItem(ufDAO.getUfById(drivers.getUf()));
            f_cep.setText(drivers.getCep());
            if("M".equals(drivers.getSex())){
               rb_male.setSelected(true);
               rb_female.setSelected(false);
            }else if("F".equals(drivers.getSex())){
               rb_male.setSelected(false);
               rb_female.setSelected(true);
            }
            if(drivers.getActive() == true){
                ck_active.setSelected(true);
            }else if(drivers.getActive() == false){
                ck_active.setSelected(false);
            }
            loadUf();
            status = "update";
            b_save.setText("Atualizar");
        } catch (ParseException ex) {
            Logger.getLogger(DriversForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   private void loadUf() {
        ArrayList uf = ufDAO.findAll(); //'produtoDAO' é meu objeto que retorna os produtos do banco.
        Iterator i = uf.iterator();

        while(i.hasNext()) {
           cb_uf.addItem(String.valueOf(i.next()));
        }
   }

    private void b_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_saveActionPerformed
        java.util.Date date = null;
        if(f_birthday.getText().trim().length() == 10){
           try {
            date = ut.dateFormatInsert(f_birthday.getText());
        } catch (ParseException ex) {
            Logger.getLogger(DriversForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        if("save".equals(status)){
                if ((f_full_name.getText().isEmpty())
                     || (f_cpf.getText().trim().length() == 9)
                     || (f_phone.getText().trim().length() == 9)
                     || (f_birthday.getText().trim().length() == 4)
                     || (f_n_rg.getText().isEmpty())
                     || (f_n_cnh.getText().isEmpty())
                     || (f_n_register.getText().isEmpty())
                     || (f_category.getText().isEmpty())
                     || (f_address.getText().isEmpty())
                     || (f_n.getText().isEmpty())
                     || (f_district.getText().isEmpty())
                     || (f_city.getText().isEmpty())
                     || " -".equals(cb_uf.getSelectedItem())) {
                 JOptionPane.showMessageDialog(rootPane, "Campos com ' * ' São obrigatórios!", "Cadastro de Caminhões", JOptionPane.WARNING_MESSAGE);
             } else {
                 if((rb_male.isSelected() == false && rb_female.isSelected() == false)) {
                     JOptionPane.showMessageDialog(rootPane, "Selecione uma opção de sexo para o motorista.", "Cadastro de Caminhões", JOptionPane.WARNING_MESSAGE);
                 } else if(ut.isValidCpf(f_cpf.getText()) == false) {
                    JOptionPane.showMessageDialog(rootPane, "O Cpf: " + f_cpf.getText() + " não é valido, Verifique e tente novamente!", "Cadastro de Caminhões", JOptionPane.WARNING_MESSAGE);
                 }else if(ut.isValidCpfDB(f_cpf.getText()) == false){
                     JOptionPane.showMessageDialog(rootPane, "O Cpf: " + f_cpf.getText() + " já está cadastrado, Verifique e tente novamente!", "Motoristas | CadoreSistemas",JOptionPane.INFORMATION_MESSAGE);
                 }else if(ut.isBiggerAge(date,date_db) == false || ut.isBiggerAge(date,date_db) != true){
                       JOptionPane.showMessageDialog(rootPane, "O motorista não possui 18 anos! Não sera possivel cadastrar o mesmo.", "Motoristas | CadoreSistemas",JOptionPane.INFORMATION_MESSAGE);
                       f_birthday.grabFocus();
                       f_birthday.selectAll();
                 }else{
                     try {
                         String sexo = rb_male.isSelected() ? "M" : "F";
                         boolean active = ck_active.isSelected() == true ? true : false;
                         drivers.setFull_name(f_full_name.getText().toUpperCase());
                         drivers.setCpf(f_cpf.getText());
                         drivers.setPhone(f_phone.getText());
                         drivers.setPhone2(f_phone2.getText());
                         drivers.setPhone3(f_phone3.getText());
                         drivers.setAddres(f_address.getText().toUpperCase());
                         drivers.setN_rg(f_n_rg.getText().toUpperCase());
                         drivers.setN_cnh(f_n_cnh.getText().toUpperCase());
                         drivers.setBirthday(ut.dateFormatInsert(f_birthday.getText()));
                         drivers.setN_register(f_n_register.getText().toUpperCase());
                         drivers.setCategory(f_category.getText().toUpperCase());
                         drivers.setN(f_n.getText().toUpperCase());
                         drivers.setDistrict(f_district.getText().toUpperCase());
                         drivers.setCity(f_city.getText().toUpperCase());
                         drivers.setCep(f_cep.getText());
                         drivers.setActive(active);
                         drivers.setCreated_at(ut.dateFormatInsert(ut.getDateddMMyyyy()));
                         drivers.setUpdated(ut.dateFormatInsert(ut.getDateddMMyyyy()));
                         drivers.setInactive(false);
                         drivers.setId_business(Long.valueOf(this.IdBusiness));
                         drivers.setSex(sexo);
                         drivers.setUf(ufDAO.getIDUf(String.valueOf(cb_uf.getSelectedItem())));
                         driversDAO.adiciona(drivers);

                         JOptionPane.showMessageDialog(null, "Motorista: " + f_full_name.getText() + " foi cadastrado com sucesso! ");
                         this.dispose();
                     } catch (ParseException ex) {
                         Logger.getLogger(DriversForm.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
             }
       }else if("update".equals(status)){
            if ((f_full_name.getText().isEmpty())
                     || (f_cpf.getText().trim().length() == 9)
                     || (f_phone.getText().trim().length() == 9)
                     || (f_birthday.getText().trim().length() == 4)
                     || (f_n_rg.getText().isEmpty())
                     || (f_n_cnh.getText().isEmpty())
                     || (f_n_register.getText().isEmpty())
                     || (f_category.getText().isEmpty())
                     || (f_address.getText().isEmpty())
                     || (f_n.getText().isEmpty())
                     || (f_district.getText().isEmpty())
                     || (f_city.getText().isEmpty())
                     || " -".equals(cb_uf.getSelectedItem())) {
                 JOptionPane.showMessageDialog(rootPane, "Campos com ' * ' São obrigatórios!", "Cadastro de Caminhões", JOptionPane.WARNING_MESSAGE);
             } else {
                 if((rb_male.isSelected() == false && rb_female.isSelected() == false)) {
                     JOptionPane.showMessageDialog(rootPane, "Selecione uma opção de sexo para o motorista.", "Cadastro de Caminhões", JOptionPane.WARNING_MESSAGE);
                 } else if(ut.isValidCpf(f_cpf.getText()) == false) {
                    JOptionPane.showMessageDialog(rootPane, "O Cpf: " + f_cpf.getText() + " não é valido, Verifique e tente novamente!", "Cadastro de Caminhões", JOptionPane.WARNING_MESSAGE);
                 }else if(ut.isValidCpfDB(f_cpf.getText()) == false && drivers.getCpf().equals(f_cpf.getText()) || ut.isValidCpfDB(f_cpf.getText()) == true){
                    if(ut.isBiggerAge(date,date_db) == false || ut.isBiggerAge(date,date_db) != true){
                       JOptionPane.showMessageDialog(rootPane, "O motorista não possui 18 anos! Não sera possivel atualizar o mesmo.", "Motoristas | CadoreSistemas",JOptionPane.INFORMATION_MESSAGE);
                       f_birthday.grabFocus();
                       f_birthday.selectAll();
                 }else{
                        try {
                            String sexo = rb_male.isSelected() ? "M" : "F";
                            boolean active = ck_active.isSelected() == true ? true : false;
                            drivers.setFull_name(f_full_name.getText().toUpperCase());
                            drivers.setCpf(f_cpf.getText());
                            drivers.setPhone(f_phone.getText());
                            drivers.setPhone2(f_phone2.getText());
                            drivers.setPhone3(f_phone3.getText());
                            drivers.setAddres(f_address.getText().toUpperCase());
                            drivers.setN_rg(f_n_rg.getText().toUpperCase());
                            drivers.setN_cnh(f_n_cnh.getText().toUpperCase());
                            drivers.setBirthday(ut.dateFormatInsert(f_birthday.getText()));
                            drivers.setN_register(f_n_register.getText().toUpperCase());
                            drivers.setCategory(f_category.getText().toUpperCase());
                            drivers.setN(f_n.getText().toUpperCase());
                            drivers.setDistrict(f_district.getText().toUpperCase());
                            drivers.setCity(f_city.getText().toUpperCase());
                            drivers.setCep(f_cep.getText());
                            drivers.setActive(active);
                            drivers.setUpdated(ut.dateFormatInsert(ut.getDateddMMyyyy()));
                            drivers.setInactive(false);
                            drivers.setId_business(Long.valueOf(this.IdBusiness));
                            drivers.setSex(sexo);
                            drivers.setUf(ufDAO.getIDUf(String.valueOf(cb_uf.getSelectedItem())));
                            drivers.setId(Long.valueOf(f_id.getText()));
                            driversDAO.atualiza(drivers);

                            JOptionPane.showMessageDialog(null, "Motorista: " + f_full_name.getText() + " foi atualizado com sucesso! ");
                            this.dispose();
                        } catch (ParseException ex) {
                            Logger.getLogger(DriversForm.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    }else if(ut.isValidCpfDB(f_cpf.getText()) == false && !drivers.getCpf().equals(f_cpf.getText())){
                      JOptionPane.showMessageDialog(rootPane, "O Cpf: " + f_cpf.getText() + " já está cadastrado, Verifique e tente novamente!", "Motoristas | CadoreSistemas",JOptionPane.INFORMATION_MESSAGE);

                 }
             }
       }
    }//GEN-LAST:event_b_saveActionPerformed

    private void b_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_b_cancelActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

    }//GEN-LAST:event_formInternalFrameOpened

    private void rb_maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_maleActionPerformed
        rb_female.setSelected(false);
    }//GEN-LAST:event_rb_maleActionPerformed

    private void rb_femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_femaleActionPerformed
        rb_male.setSelected(false);
    }//GEN-LAST:event_rb_femaleActionPerformed

    private void b_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_searchActionPerformed
        DriversSearch DriverS = new DriversSearch();
        deskPane.add(DriverS);
        Centraliza.setCentro(DriverS, deskPane, WIDTH, HEIGHT);
        DriverS.IdBusiness = this.IdBusiness;
        DriverS.driversForm = this;
        DriverS.setVisible(true);

    }//GEN-LAST:event_b_searchActionPerformed

    private void cb_ufActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ufActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_ufActionPerformed

    private void f_full_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f_full_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_f_full_nameActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_cancel;
    private javax.swing.JButton b_save;
    private javax.swing.JButton b_search;
    private javax.swing.JComboBox cb_uf;
    private javax.swing.JCheckBox ck_active;
    private javax.swing.JTextField f_address;
    private javax.swing.JFormattedTextField f_birthday;
    private javax.swing.JTextField f_category;
    private javax.swing.JFormattedTextField f_cep;
    private javax.swing.JTextField f_city;
    private javax.swing.JFormattedTextField f_cpf;
    private javax.swing.JTextField f_district;
    private javax.swing.JTextField f_full_name;
    private javax.swing.JTextField f_id;
    private javax.swing.JTextField f_n;
    private javax.swing.JTextField f_n_cnh;
    private javax.swing.JTextField f_n_register;
    private javax.swing.JTextField f_n_rg;
    private javax.swing.JFormattedTextField f_phone;
    private javax.swing.JFormattedTextField f_phone2;
    private javax.swing.JFormattedTextField f_phone3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton rb_female;
    private javax.swing.JRadioButton rb_male;
    // End of variables declaration//GEN-END:variables
}
