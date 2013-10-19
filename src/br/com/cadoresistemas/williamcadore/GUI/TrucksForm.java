package br.com.cadoresistemas.williamcadore.GUI;

import br.com.cadoresistemas.williamcadore.DAO.BusinessDAO;
import br.com.cadoresistemas.williamcadore.DAO.DriversDAO;
import br.com.cadoresistemas.williamcadore.DAO.TractionDAO;
import br.com.cadoresistemas.williamcadore.DAO.TrucksDAO;
import br.com.cadoresistemas.williamcadore.ModelsForm.TrucksModel;
import br.com.cadoresistemas.williamcadore.Utils.Centraliza;
import br.com.cadoresistemas.williamcadore.Utils.Util;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

public class TrucksForm extends javax.swing.JInternalFrame {

    public TrucksForm() {
        initComponents();
        loadTractions();
        b_delete.setVisible(false);
        this.setFrameIcon(new ImageIcon(this.getClass().getResource("/Images/iconTruckSystem.jpg")));
    }

    private String status = "save";
    public JDesktopPane deskPane = null;
    private Util date = new Util();
    public String IdBusiness = null;
    public TrucksModel trucks = new TrucksModel();
    private TrucksDAO trucksDAO = new TrucksDAO();
    private TractionDAO tractionDAO = new TractionDAO();
    private DriversDAO driversDAO = new DriversDAO();
    private BusinessDAO businessDAO = new BusinessDAO();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        f_mark = new javax.swing.JTextField();
        f_model = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        f_color = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        f_n_chassi = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        f_n_renavam = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        f_year_model = new javax.swing.JFormattedTextField();
        f_year_fabrication = new javax.swing.JFormattedTextField();
        f_board = new javax.swing.JFormattedTextField();
        cb_traction = new javax.swing.JComboBox();
        cb_driver = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        f_n_truck = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        f_board1 = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        f_year_model1 = new javax.swing.JFormattedTextField();
        f_year_model2 = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        f_board2 = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        f_board3 = new javax.swing.JFormattedTextField();
        jLabel18 = new javax.swing.JLabel();
        f_year_model3 = new javax.swing.JFormattedTextField();
        b_cancel = new javax.swing.JButton();
        b_save = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        f_id = new javax.swing.JTextField();
        b_search = new javax.swing.JButton();
        b_delete = new javax.swing.JButton();

        setTitle("Veiculos");
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Cadastro de Veiculos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("*Marca:");

        f_mark.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        f_model.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("*Modelo:");

        f_color.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("*Cor:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("*Ano/Mod:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("*Ano/Fab:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("*Placa:");

        f_n_chassi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("*Nº Chassi:");

        f_n_renavam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("*Nº Renavam:");

        try {
            f_year_model.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        f_year_model.setText("");
        f_year_model.setToolTipText("");
        f_year_model.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        try {
            f_year_fabrication.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        f_year_fabrication.setText("");
        f_year_fabrication.setToolTipText("");
        f_year_fabrication.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        try {
            f_board.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("???-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        f_board.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_board.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_boardKeyReleased(evt);
            }
        });

        cb_traction.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_traction.setToolTipText("");

        cb_driver.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_driver.setToolTipText("");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("*Motorista:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Numero:");

        f_n_truck.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("*Tração:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(f_board))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(f_n_chassi)
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(f_mark)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(f_n_renavam)
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(f_n_truck)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cb_traction, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cb_driver, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(f_model))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(f_color, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(f_year_model, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(f_year_fabrication, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(f_n_truck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(f_board, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(f_n_chassi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(f_mark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(f_n_renavam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(f_model, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(f_year_model, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(f_color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(f_year_fabrication, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel4))
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cb_traction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_driver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel13.setText("Reboques");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Placa:");

        try {
            f_board1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("???-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        f_board1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_board1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_board1KeyReleased(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Ano/Mod:");

        try {
            f_year_model1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        f_year_model1.setToolTipText("");
        f_year_model1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        try {
            f_year_model2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        f_year_model2.setToolTipText("");
        f_year_model2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Ano/Mod:");

        try {
            f_board2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("???-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        f_board2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_board2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_board2KeyReleased(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Placa:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Placa:");

        try {
            f_board3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("???-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        f_board3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_board3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_board3KeyReleased(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Ano/Mod:");

        try {
            f_year_model3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        f_year_model3.setToolTipText("");
        f_year_model3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(f_board1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(f_year_model1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(f_board2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(f_year_model2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(f_board3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(f_year_model3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(f_board2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(f_year_model2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel16)
                            .addGap(29, 29, 29))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(f_board1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addGap(29, 29, 29)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(f_year_model1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel18)
                            .addGap(29, 29, 29))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel19)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(f_board3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(f_year_model3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))))
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

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("ID:");

        f_id.setEditable(false);
        f_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        b_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Search.png"))); // NOI18N
        b_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_searchActionPerformed(evt);
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(190, 190, 190)
                            .addComponent(jLabel22)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(f_id, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(b_search, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(b_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_save, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_cancel)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(f_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_search))))
                .addGap(8, 8, 8)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_cancel)
                    .addComponent(b_save)
                    .addComponent(b_delete))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean IsvalidNumberOfTrucks(){
        int number_trucks = trucksDAO.getNumberOfTrucks(Long.valueOf(this.IdBusiness));
        int number_trucks_business = businessDAO.getNumberOfTrucksBusiness(Long.valueOf(this.IdBusiness));
        if(number_trucks == number_trucks_business || number_trucks > number_trucks_business){
            return false;
        }else if(number_trucks < number_trucks_business){
            return true;
        }else{
            return false;
        }
    }

    public void setTruck(){
        cb_driver.removeAllItems();
        cb_traction.removeAllItems();
        f_id.setText(trucks.getId().toString());
        f_n_truck.setText(trucks.getN_truck().toString());
        f_board.setText(trucks.getBoard());
        f_n_chassi.setText(trucks.getN_chassi());
        f_mark.setText(trucks.getMark());
        f_n_renavam.setText(trucks.getN_renavam());
        f_model.setText(trucks.getModel());
        f_color.setText(trucks.getColor());
        f_year_model.setText(trucks.getYear_model());
        f_year_fabrication.setText(trucks.getYear_fabrication());
        cb_traction.setSelectedItem(tractionDAO.getTractionById(trucks.getTraction()));
        cb_driver.setSelectedItem(driversDAO.getDriverByID(trucks.getDriver(), Long.valueOf(this.IdBusiness)));
        f_board1.setText(trucks.getBoard1());
        f_board2.setText(trucks.getBoard2());
        f_board3.setText(trucks.getBoard3());
        f_year_model1.setText(trucks.getYear_fabrication1());
        f_year_model2.setText(trucks.getYear_fabrication2());
        f_year_model3.setText(trucks.getYear_fabrication3());
        status = "update";
        b_save.setText("Atualizar");
        b_delete.setVisible(true);
        loadTractions();
        loadDrivers();
    }

    private void loadTractions() {
        cb_traction.addItem(" -Selecione");
        ArrayList tractions = tractionDAO.findAll(); //'produtoDAO' é meu objeto que retorna os produtos do banco.
        Iterator i = tractions.iterator();

        while(i.hasNext()) {
           cb_traction.addItem(String.valueOf(i.next()));
        }
 }

    public void loadDrivers() {
        cb_driver.addItem(" -Selecione");
        ArrayList tractions = driversDAO.findAllDriversisActive(Long.valueOf(this.IdBusiness)); //'produtoDAO' é meu objeto que retorna os produtos do banco.
        Iterator i = tractions.iterator();

        while(i.hasNext()) {
           cb_driver.addItem(String.valueOf(i.next()));
        }
 }
    private void b_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_saveActionPerformed
        if("save".equals(status)){
            if ((f_board.getText().isEmpty())
                   || (f_color.getText().isEmpty())
                   || (f_mark.getText().isEmpty())
                   || (f_model.getText().isEmpty())
                   || (f_n_chassi.getText().isEmpty())
                   || (f_n_renavam.getText().isEmpty())
                   || (f_year_fabrication.getText().trim().length() == 0)
                   || (f_year_model.getText().trim().length() == 0)
                   || (f_board.getText().trim().length() == 1)
                   || (" -Selecione".equals(cb_traction.getSelectedItem())
                   || (" -Selecione".equals(cb_driver.getSelectedItem())))) {
               JOptionPane.showMessageDialog(rootPane, "Campos com ' * ' São obrigatórios!", "Caminhões", JOptionPane.WARNING_MESSAGE);
           }else{
                if(IsvalidNumberOfTrucks() == true){
               if(date.isValidBoardTruckDB(f_board.getText()) == true){
                    if(date.isValidN_truckDB(Long.valueOf(f_n_truck.getText()), Long.valueOf(this.IdBusiness)) == true){
                        if(date.isValidN_renavamTruckDB(f_n_renavam.getText()) == true){
                            if(date.isValidN_chassiTruckDB(f_n_chassi.getText()) == true){
                                    try {
                                        trucks.setBoard(f_board.getText().toUpperCase());
                                        trucks.setBoard1(f_board1.getText().toUpperCase());
                                        trucks.setBoard2(f_board2.getText().toUpperCase());
                                        trucks.setBoard3(f_board3.getText().toUpperCase());
                                        trucks.setColor(f_color.getText().toUpperCase());
                                        trucks.setMark(f_mark.getText().toUpperCase());
                                        trucks.setModel(f_model.getText().toUpperCase());
                                        trucks.setN_chassi(f_n_chassi.getText().toUpperCase());
                                        trucks.setN_renavam(f_n_renavam.getText().toUpperCase());
                                        trucks.setYear_fabrication(f_year_fabrication.getText());
                                        trucks.setYear_fabrication1(f_year_model1.getText());
                                        trucks.setYear_fabrication2(f_year_model2.getText());
                                        trucks.setYear_fabrication3(f_year_model3.getText());
                                        trucks.setYear_model(f_year_model.getText());
                                        trucks.setN_truck(Long.valueOf(f_n_truck.getText()));
                                        trucks.setCreated_at(date.dateFormatInsert(date.getDateddMMyyyy()));
                                        trucks.setUpdated(date.dateFormatInsert(date.getDateddMMyyyy()));
                                        trucks.setId_business(Long.valueOf(this.IdBusiness));
                                        trucks.setInactive(false);
                                        trucks.setTraction(tractionDAO.getIdTraction(String.valueOf(cb_traction.getSelectedItem())));
                                        trucks.setDriver(driversDAO.getIdDriver(String.valueOf(cb_driver.getSelectedItem()), Long.valueOf(this.IdBusiness)));
                                        trucksDAO.adiciona(trucks);
                                        JOptionPane.showMessageDialog(null, "Veiculo: " + f_model.getText() +  " Placa: " + f_board.getText()
                                        + " foi cadastrado com Sucesso!");
                                        this.dispose();
                                    } catch (ParseException ex) {
                                        Logger.getLogger(TrucksForm.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }else if(date.isValidN_chassiTruckDB(f_n_chassi.getText()) == false){
                                JOptionPane.showMessageDialog(rootPane, "O numero do chassi do veículo ja existe.\nPor favor verifique e tente novamente!", "Veículos | CadoreSistemas", JOptionPane.INFORMATION_MESSAGE);
                                f_n_chassi.setText("");
                                f_n_chassi.grabFocus();
                            }
                        }else if(date.isValidN_renavamTruckDB(f_n_renavam.getText()) == false){
                            JOptionPane.showMessageDialog(rootPane, "O numero do renavam do veículo ja existe.\nPor favor verifique e tente novamente!", "Veículos | CadoreSistemas", JOptionPane.INFORMATION_MESSAGE);
                            f_n_renavam.setText("");
                            f_n_renavam.grabFocus();
                            }
                    }else if(date.isValidN_truckDB(Long.valueOf(f_n_truck.getText()), Long.valueOf(this.IdBusiness)) == false){
                            JOptionPane.showMessageDialog(rootPane, "O numero do veículo ja existe, por favor escolha outro.", "Veículos | CadoreSistemas", JOptionPane.INFORMATION_MESSAGE);
                            f_n_truck.setText("");
                            f_n_truck.grabFocus();
                        }
               }else if(date.isValidBoardTruckDB(f_board.getText()) == false){
                        JOptionPane.showMessageDialog(rootPane, "A placa: " + f_board.getText() + " já esta cadstrada.\nVerifique e tente novamente", "Veículos | CadoreSistemas", JOptionPane.INFORMATION_MESSAGE);
                        f_board.setText("");
                        f_board.grabFocus();
                    }
               }else if(IsvalidNumberOfTrucks() == false){
            JOptionPane.showMessageDialog(rootPane, "Voce atingiu seu numero máximo de Veículos,\n para aumentar sua capacidade entre em contato com o Administrador",
                    "Cadore Sistemas", JOptionPane.INFORMATION_MESSAGE);
               }
            }}else if("update".equals(status)){
             System.out.print("...");
                if ((f_board.getText().isEmpty())
                        || (f_color.getText().isEmpty())
                        || (f_mark.getText().isEmpty())
                        || (f_model.getText().isEmpty())
                        || (f_n_chassi.getText().isEmpty())
                        || (f_n_renavam.getText().isEmpty())
                        || (f_year_fabrication.getText().trim().length() == 0)
                        || (f_year_model.getText().trim().length() == 0)
                        || (f_board.getText().trim().length() == 1)
                        || (" -Selecione".equals(cb_traction.getSelectedItem())
                        || (" -Selecione".equals(cb_driver.getSelectedItem())))) {
                    JOptionPane.showMessageDialog(rootPane, "Campos com ' * ' São obrigatórios!", "Caminhões", JOptionPane.WARNING_MESSAGE);
                }
                else{
                    if(date.isValidBoardTruckDB(f_board.getText()) == false && trucks.getBoard().equals(f_board.getText()) || date.isValidBoardTruckDB(f_board.getText()) == true){
                        if(date.isValidN_truckDB(Long.valueOf(f_n_truck.getText()), Long.valueOf(this.IdBusiness)) == false && trucks.getN_truck().equals(Long.valueOf(f_n_truck.getText())) || date.isValidN_truckDB(
                                Long.valueOf(f_n_truck.getText()), Long.valueOf(this.IdBusiness)) == true){
                            if(date.isValidN_renavamTruckDB(f_n_renavam.getText()) == false && trucks.getN_renavam().equals(f_n_renavam.getText()) || date.isValidN_renavamTruckDB(f_n_renavam.getText()) == true){
                                if(date.isValidN_chassiTruckDB(f_n_chassi.getText()) == false && trucks.getN_chassi().equals(f_n_chassi.getText()) || date.isValidN_chassiTruckDB(f_n_chassi.getText()) == true){
                                    try {
                                        trucks.setBoard(f_board.getText().toUpperCase());
                                        trucks.setBoard1(f_board1.getText().toUpperCase());
                                        trucks.setBoard2(f_board2.getText().toUpperCase());
                                        trucks.setBoard3(f_board3.getText().toUpperCase());
                                        trucks.setColor(f_color.getText().toUpperCase());
                                        trucks.setMark(f_mark.getText().toUpperCase());
                                        trucks.setModel(f_model.getText().toUpperCase());
                                        trucks.setN_chassi(f_n_chassi.getText().toUpperCase());
                                        trucks.setN_renavam(f_n_renavam.getText().toUpperCase());
                                        trucks.setYear_fabrication(f_year_fabrication.getText());
                                        trucks.setYear_fabrication1(f_year_model1.getText());
                                        trucks.setYear_fabrication2(f_year_model2.getText());
                                        trucks.setYear_fabrication3(f_year_model3.getText());
                                        trucks.setYear_model(f_year_model.getText());
                                        trucks.setN_truck(Long.valueOf(f_n_truck.getText()));
                                        trucks.setUpdated(date.dateFormatInsert(date.getDateddMMyyyy()));
                                        trucks.setId_business(Long.valueOf(this.IdBusiness));
                                        trucks.setInactive(false);
                                        trucks.setTraction(tractionDAO.getIdTraction(String.valueOf(cb_traction.getSelectedItem())));
                                        trucks.setDriver(driversDAO.getIdDriver(String.valueOf(cb_driver.getSelectedItem()), Long.valueOf(this.IdBusiness)));
                                        trucks.setId(Long.valueOf(f_id.getText()));
                                        trucksDAO.atualiza(trucks);
                                        JOptionPane.showMessageDialog(null, "Veiculo: " + f_model.getText() +  " Placa: " + f_board.getText()
                                        + " foi atualizado com Sucesso!");
                                        this.dispose();
                                    } catch (ParseException ex) {
                                        Logger.getLogger(TrucksForm.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }else if(date.isValidN_chassiTruckDB(f_n_chassi.getText()) == false && !trucks.getN_chassi().equals(f_n_chassi.getText())){
                                JOptionPane.showMessageDialog(rootPane, "O numero do chassi do veículo ja existe.\nPor favor verifique e tente novamente!", "Veículos | CadoreSistemas", JOptionPane.INFORMATION_MESSAGE);
                                f_n_chassi.setText("");
                                f_n_chassi.grabFocus();
                                }
                            }else if(date.isValidN_renavamTruckDB(f_n_renavam.getText()) == false && !trucks.getN_renavam().equals(f_n_renavam.getText())){
                            JOptionPane.showMessageDialog(rootPane, "O numero do renavam do veículo ja existe.\nPor favor verifique e tente novamente!", "Veículos | CadoreSistemas", JOptionPane.INFORMATION_MESSAGE);
                            f_n_renavam.setText("");
                            f_n_renavam.grabFocus();
                            }
                        }else if(date.isValidN_truckDB(Long.valueOf(f_n_truck.getText()), Long.valueOf(this.IdBusiness)) == false && !trucks.getN_truck().equals(Long.valueOf(f_n_truck.getText()))){
                         JOptionPane.showMessageDialog(rootPane, "O numero do veículo ja existe, por favor escolha outro.", "Veículos | CadoreSistemas", JOptionPane.INFORMATION_MESSAGE);
                         f_n_truck.setText("");
                         f_n_truck.grabFocus();
                    }
                    }else if(date.isValidBoardTruckDB(f_board.getText()) == false && !trucks.getBoard().equals(f_board.getText())){
                        JOptionPane.showMessageDialog(rootPane, "A placa: " + f_board.getText() + " já esta cadstrada.\nVerifique e tente novamente", "Veículos | CadoreSistemas", JOptionPane.INFORMATION_MESSAGE);
                        f_board.setText("");
                        f_board.grabFocus();
                    }
                }
            }
    }//GEN-LAST:event_b_saveActionPerformed

    private void b_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_b_cancelActionPerformed

    private void b_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_searchActionPerformed
        TrucksSearch TrucksS = new TrucksSearch();
        deskPane.add(TrucksS);
        Centraliza.setCentro(TrucksS, deskPane, WIDTH, HEIGHT);
        TrucksS.IdBusiness = this.IdBusiness;
        TrucksS.setVisible(true);
        TrucksS.trucksForm = this;
    }//GEN-LAST:event_b_searchActionPerformed

    private void f_boardKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_boardKeyReleased
        String board = f_board.getText();
        String board_ = board.toUpperCase();
        f_board.setText(board_);
    }//GEN-LAST:event_f_boardKeyReleased

    private void f_board1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_board1KeyReleased
        String board = f_board1.getText();
        String board_ = board.toUpperCase();
        f_board1.setText(board_);
    }//GEN-LAST:event_f_board1KeyReleased

    private void f_board2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_board2KeyReleased
        String board = f_board2.getText();
        String board_ = board.toUpperCase();
        f_board2.setText(board_);
    }//GEN-LAST:event_f_board2KeyReleased

    private void f_board3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_board3KeyReleased
        String board = f_board3.getText();
        String board_ = board.toUpperCase();
        f_board3.setText(board_);
    }//GEN-LAST:event_f_board3KeyReleased

    private void b_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_deleteActionPerformed
        Object[] options = {" Sim ", " Não "};
            int i = JOptionPane.showOptionDialog(null, "Você tem certeza que deseja excluir(inativar) este veiculo?", "Truck System",
                    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                if (i == JOptionPane.YES_OPTION) {
                    trucks.setInactive(true);
                    trucks.setId(Long.valueOf(f_id.getText()));
                    trucksDAO.exclui(trucks);
                    JOptionPane.showMessageDialog(rootPane, "O Veiculo de placa "+f_board.getText()+" foi excluido(inativado) com sucesso.", "Cadore Sistemas", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                }
    }//GEN-LAST:event_b_deleteActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        f_n_truck.setText(String.valueOf(trucksDAO.getLastNTruck(Long.valueOf(this.IdBusiness)) + 01));
    }//GEN-LAST:event_formInternalFrameOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_cancel;
    private javax.swing.JButton b_delete;
    private javax.swing.JButton b_save;
    private javax.swing.JButton b_search;
    private javax.swing.JComboBox cb_driver;
    private javax.swing.JComboBox cb_traction;
    private javax.swing.JFormattedTextField f_board;
    private javax.swing.JFormattedTextField f_board1;
    private javax.swing.JFormattedTextField f_board2;
    private javax.swing.JFormattedTextField f_board3;
    private javax.swing.JTextField f_color;
    private javax.swing.JTextField f_id;
    private javax.swing.JTextField f_mark;
    private javax.swing.JTextField f_model;
    private javax.swing.JTextField f_n_chassi;
    private javax.swing.JTextField f_n_renavam;
    private javax.swing.JTextField f_n_truck;
    private javax.swing.JFormattedTextField f_year_fabrication;
    private javax.swing.JFormattedTextField f_year_model;
    private javax.swing.JFormattedTextField f_year_model1;
    private javax.swing.JFormattedTextField f_year_model2;
    private javax.swing.JFormattedTextField f_year_model3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
