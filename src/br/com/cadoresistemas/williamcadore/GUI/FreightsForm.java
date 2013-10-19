package br.com.cadoresistemas.williamcadore.GUI;

import br.com.cadoresistemas.williamcadore.DAO.DriversDAO;
import br.com.cadoresistemas.williamcadore.DAO.FreightsDAO;
import br.com.cadoresistemas.williamcadore.DAO.TrucksDAO;
import br.com.cadoresistemas.williamcadore.DAO.UfDAO;
import br.com.cadoresistemas.williamcadore.ModelsForm.FreightsModel;
import br.com.cadoresistemas.williamcadore.Utils.Centraliza;
import br.com.cadoresistemas.williamcadore.Utils.FixedLengthDocument;
import br.com.cadoresistemas.williamcadore.Utils.Util;
import java.awt.Color;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

public final class FreightsForm extends javax.swing.JInternalFrame {

    public FreightsForm() {
        initComponents();
        loadUf();
        b_delete.setVisible(false);
        b_fueled.setEnabled(false);
        b_outputs.setEnabled(false);
        this.Calculator();
        this.setFrameIcon(new ImageIcon(this.getClass().getResource("/Images/iconTruckSystem.jpg")));
        f_observation.setDocument(new FixedLengthDocument(350));
    }

    private String status = "save";
    private DecimalFormat decimal = new DecimalFormat("0.00");
    public FreightsModel freights = new FreightsModel();
    private FreightsDAO freightsDAO = new FreightsDAO();
    private DriversDAO driversDAO = new DriversDAO();
    public JDesktopPane deskPane = null;
    private Util u = new Util();
    public String IdBusiness = null;
    private TrucksDAO trucksDAO = new TrucksDAO();
    private UfDAO ufDAO = new UfDAO();
    private Random r = new Random();
    private int random = 0;
    public boolean thread = false;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        b_cancel = new javax.swing.JButton();
        b_save = new javax.swing.JButton();
        b_delete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cb_truck = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        f_city_source = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        f_company_source = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        f_company_destination = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        f_city_destination = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        f_product = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        f_date_exit = new javax.swing.JFormattedTextField();
        f_date_arrived = new javax.swing.JFormattedTextField();
        cb_uf_destination = new javax.swing.JComboBox();
        cb_uf_source = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        f_value_t = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        f_weight = new javax.swing.JTextField();
        f_discount_freight = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        f_fueled = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        f_gross = new javax.swing.JTextField();
        f_liq_freight = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        l_calculator_valuet = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        f_mediun_fueled = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        f_percent = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        f_total_comission = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        f_discount_comission = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        f_liq_comission = new javax.swing.JTextField();
        ck_comission = new javax.swing.JCheckBox();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        f_observation = new javax.swing.JEditorPane();
        l_length = new javax.swing.JLabel();
        b_fueled = new javax.swing.JButton();
        b_outputs = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        f_note = new javax.swing.JTextField();
        f_id = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        cb_driver = new javax.swing.JComboBox();

        setTitle("Fretes");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        b_cancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png"))); // NOI18N
        b_cancel.setText("Sair");
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

        b_delete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Delete.png"))); // NOI18N
        b_delete.setText("Excluir");
        b_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_deleteActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("*Veículo:");

        cb_truck.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_truck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_truckActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Motorista:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("ORIGEM");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("*Cidade:");

        f_city_source.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_city_source.setNextFocusableComponent(cb_uf_source);
        f_city_source.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_city_sourceKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("*Empresa:");

        f_company_source.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_company_source.setNextFocusableComponent(f_city_source);
        f_company_source.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_company_sourceKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("*UF:");

        f_company_destination.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_company_destination.setNextFocusableComponent(f_city_destination);
        f_company_destination.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_company_destinationKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("*Empresa:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("*Cidade:");

        f_city_destination.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_city_destination.setNextFocusableComponent(cb_uf_destination);
        f_city_destination.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_city_destinationKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("*UF:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("DESTINO");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("*Produto:");

        f_product.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_product.setNextFocusableComponent(f_date_exit);
        f_product.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_productKeyReleased(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("*Data Saida:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("*Data Chegada:");

        try {
            f_date_exit.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        f_date_exit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_date_exit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_date_exitKeyReleased(evt);
            }
        });

        try {
            f_date_arrived.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        f_date_arrived.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_date_arrived.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_date_arrivedKeyReleased(evt);
            }
        });

        cb_uf_destination.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_uf_destination.setNextFocusableComponent(f_product);

        cb_uf_source.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_uf_source.setNextFocusableComponent(f_company_destination);
        cb_uf_source.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_uf_sourceActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("*Valor P/ Ton.:");

        f_value_t.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_value_t.setText("0,00");
        f_value_t.setNextFocusableComponent(f_gross);
        f_value_t.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                f_value_tFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                f_value_tFocusLost(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("*Peso:");

        f_weight.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_weight.setText("0,00");
        f_weight.setNextFocusableComponent(f_value_t);
        f_weight.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                f_weightFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                f_weightFocusLost(evt);
            }
        });

        f_discount_freight.setEditable(false);
        f_discount_freight.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_discount_freight.setText("0,00");
        f_discount_freight.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                f_discount_freightFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                f_discount_freightFocusLost(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Valor Bruto:");

        f_fueled.setEditable(false);
        f_fueled.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_fueled.setText("0,00");
        f_fueled.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                f_fueledFocusGained(evt);
            }
        });
        f_fueled.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_fueledKeyReleased(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Total Liq. Frete:");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Abastecidas:");

        f_gross.setEditable(false);
        f_gross.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_gross.setText("0,00");
        f_gross.setNextFocusableComponent(ck_comission);

        f_liq_freight.setEditable(false);
        f_liq_freight.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_liq_freight.setText("0,00");
        f_liq_freight.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                f_liq_freightFocusGained(evt);
            }
        });
        f_liq_freight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_liq_freightKeyReleased(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Despesas:");

        l_calculator_valuet.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        l_calculator_valuet.setText("Calcular Valor p/ Tonelada");
        l_calculator_valuet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                l_calculator_valuetMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                l_calculator_valuetMouseEntered(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l_calculator_valuetMouseClicked(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("Média de Consumo:");

        f_mediun_fueled.setEditable(false);
        f_mediun_fueled.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_mediun_fueled.setText("0,00");
        f_mediun_fueled.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                f_mediun_fueledFocusGained(evt);
            }
        });
        f_mediun_fueled.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_mediun_fueledKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(f_weight, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_calculator_valuet)
                            .addComponent(jLabel14)
                            .addComponent(f_value_t, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(f_gross, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(f_discount_freight, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(f_fueled, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel17)
                            .addComponent(f_liq_freight, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(f_mediun_fueled, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(f_weight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f_value_t, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(l_calculator_valuet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(f_discount_freight, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(f_gross, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(f_fueled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f_liq_freight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(f_mediun_fueled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("*Porcentagem:");

        f_percent.setEditable(false);
        f_percent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_percent.setText("0,00");
        f_percent.setNextFocusableComponent(f_discount_comission);
        f_percent.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                f_percentFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                f_percentFocusLost(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Total:");

        f_total_comission.setEditable(false);
        f_total_comission.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_total_comission.setText("0,00");
        f_total_comission.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                f_total_comissionFocusGained(evt);
            }
        });
        f_total_comission.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_total_comissionKeyReleased(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("*Descontos:");

        f_discount_comission.setEditable(false);
        f_discount_comission.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_discount_comission.setText("0,00");
        f_discount_comission.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                f_discount_comissionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                f_discount_comissionFocusLost(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Total Liq. Comição:");

        f_liq_comission.setEditable(false);
        f_liq_comission.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_liq_comission.setText("0,00");
        f_liq_comission.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                f_liq_comissionFocusGained(evt);
            }
        });
        f_liq_comission.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_liq_comissionKeyReleased(evt);
            }
        });

        ck_comission.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ck_comission.setText("Comição para Motorista?");
        ck_comission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ck_comissionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(ck_comission, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(f_discount_comission, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(f_liq_comission)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(f_percent, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(82, 82, 82))
                                    .addComponent(f_total_comission))))
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ck_comission)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(f_percent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f_total_comission, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(f_discount_comission, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(f_liq_comission, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Observações:");

        f_observation.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        f_observation.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_observationKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(f_observation);

        b_fueled.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_fueled.setText("Abastecimento");
        b_fueled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_fueledActionPerformed(evt);
            }
        });

        b_outputs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_outputs.setText("Despesas");
        b_outputs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_outputsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(f_company_source, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(f_city_source, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(cb_uf_source, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(f_city_destination, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(jLabel10))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cb_uf_destination, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(19, 19, 19))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(f_company_destination, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(f_date_exit)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
                                .addGap(90, 90, 90)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(f_date_arrived)))
                            .addComponent(jLabel12)
                            .addComponent(f_product, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(b_outputs, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(326, 326, 326))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(l_length, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(b_fueled, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(43, 43, 43))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_uf_source, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(f_city_source, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(f_city_destination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_uf_destination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(f_company_destination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(f_company_source, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(f_product, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(29, 29, 29))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel24)
                                            .addComponent(jLabel25))
                                        .addGap(8, 8, 8)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(f_date_exit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(f_date_arrived, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_fueled, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_length, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_outputs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("*Nº Nota:");

        f_note.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_note.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f_noteActionPerformed(evt);
            }
        });
        f_note.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_noteKeyReleased(evt);
            }
        });

        f_id.setEditable(false);
        f_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Id:");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setText("Fretes");

        cb_driver.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(f_id, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(f_note, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cb_truck, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_driver, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 952, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(f_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(f_note, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_truck, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_driver, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(b_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_save, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_cancel)
                    .addComponent(b_save)
                    .addComponent(b_delete))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private double weight = 0;
    private double valuet = 0;
    private double gross = 0;
    private double discount_freight = 0;
    private double fueled = 0;
    private double percent = 0;
    private double total_comission = 0;
    private double discount_comission = 0;
    private double liq_comission = 0;

    public void Calculator() {
        new Thread() {
             @Override
             public void run() {
                 while (!thread) {
                     try {
                     if(!f_weight.getText().isEmpty() && u.isNumbers(f_weight)){ weight = Double.valueOf(f_weight.getText().replace(",", ".")); }else{ weight = 0; }
                     if(!f_value_t.getText().isEmpty() && u.isNumbers(f_value_t)){ valuet = Double.valueOf(f_value_t.getText().replace(",", ".")); }else{ valuet = 0; }
                     if(!f_gross.getText().isEmpty() && u.isNumbers(f_gross)){ gross = Double.valueOf(f_gross.getText().replace(",", ".")); }else{ gross = 0; }
                     if(!f_discount_freight.getText().isEmpty() && u.isNumbers(f_discount_freight)){ discount_freight = Double.valueOf(f_discount_freight.getText().replace(",", ".")); }else{ discount_freight = 0; }
                     if(!f_fueled.getText().isEmpty() && u.isNumbers(f_fueled)){ fueled = Double.valueOf(f_fueled.getText().replace(",", ".")); }else{ fueled = 0; }
                     if(!f_percent.getText().isEmpty() && u.isNumbers(f_percent)){ percent = Double.valueOf(f_percent.getText().replace(",", ".")); }else{ percent = 0; }
                     if(!f_total_comission.getText().isEmpty() && u.isNumbers(f_total_comission)){ total_comission = Double.valueOf(f_total_comission.getText().replace(",", ".")); }else{ total_comission = 0; }
                     if(!f_discount_comission.getText().isEmpty() && u.isNumbers(f_discount_comission)){ discount_comission = Double.valueOf(f_discount_comission.getText().replace(",", ".")); }else{ discount_comission = 0; }
                     if(!f_liq_comission.getText().isEmpty() && u.isNumbers(f_liq_comission)){ liq_comission = Double.valueOf(f_liq_comission.getText().replace(",", ".")); }else{ liq_comission = 0; }

                     f_gross.setText(String.valueOf(decimal.format(weight * valuet)).replace(".", ","));
                     f_total_comission.setText(String.valueOf(decimal.format(gross * percent / 100)).replace(".", ","));
                     f_liq_comission.setText(String.valueOf(decimal.format(total_comission - discount_comission)).replace(".", ","));
                     f_liq_freight.setText(String.valueOf(decimal.format(gross - discount_freight - fueled - liq_comission)).replace(".", ","));
                         sleep(450);//faz a thread entrar em estado de espera por 900 milissegundos ou 1 segundo
                     } catch (NumberFormatException | InterruptedException e) {
                         JOptionPane.showMessageDialog(rootPane, e.getMessage() + "\nErro Não Foi Possivel calcular os valores. Tente novamente!");
                         dispose();
                     }
                 }
             }
         }.start();
    }

    public void setFreights(){
        try {
            String full_name_driver = driversDAO.getDriverByID(freights.getDriver(), Long.valueOf(this.IdBusiness));
            loadTrucks();
            loadUf();
            loadAllDrivers();
            f_id.setText(freights.getId().toString());
            cb_truck.setSelectedItem(trucksDAO.getBoardTruckById(freights.getTruck()));
            cb_driver.setSelectedItem(full_name_driver);
            cb_uf_destination.setSelectedItem(ufDAO.getUfById(freights.getUf_destination()));
            cb_uf_source.setSelectedItem(ufDAO.getUfById(freights.getUf_source()));
            f_note.setText(freights.getNote());
            f_company_source.setText(freights.getCompany_source());
            f_company_destination.setText(freights.getCompany_destination());
            f_city_source.setText(freights.getCity_source());
            f_city_destination.setText(freights.getCity_destination());
            f_product.setText(freights.getProduct());
            f_date_exit.setText(u.dateFormatReturn(freights.getData_exit()));
            f_date_arrived.setText(u.dateFormatReturn(freights.getData_arrived()));
            f_weight.setText(decimal.format(freights.getWeight()).replace(".", ","));
            f_value_t.setText(decimal.format(freights.getValue_t()).replace(".", ","));
            f_gross.setText(decimal.format(freights.getGross()).replace(".", ","));
            f_discount_freight.setText(decimal.format(freights.getDiscount2()).replace(".", ","));
            f_fueled.setText(decimal.format(freights.getFueled()).replace(".", ","));
            f_liq_freight.setText(decimal.format(freights.getTotal3()).replace(".", ","));
            f_percent.setText(decimal.format(freights.getPercent()).replace(".", ","));
            f_total_comission.setText(decimal.format(freights.getTotal1()).replace(".", ","));
            f_discount_comission.setText(decimal.format(freights.getDiscount()).replace(".", ","));
            f_liq_comission.setText(decimal.format(freights.getTotal2()).replace(".", ","));
            f_mediun_fueled.setText(decimal.format(freights.getMedium_fueled()).replace(".", ","));
            f_observation.setText(freights.getObservation());
            status = "update";
            b_save.setText("Atualizar");
            b_fueled.setEnabled(true);
            b_outputs.setEnabled(true);
            b_delete.setVisible(true);
            if(freights.getPercent() > 0){
                ck_comission.setSelected(true);
            }else{
                ck_comission.setSelected(false);
            }
        } catch (ParseException ex) {
            Logger.getLogger(FreightsForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setIdFreight(){
        f_id.setText(String.valueOf(freightsDAO.getLastIdFreight(random, Long.valueOf(this.IdBusiness))));
        b_fueled.setEnabled(true);
        b_outputs.setEnabled(true);
        b_save.setText("Atualizar");
        b_cancel.setText("Sair");
        status = "update";
        b_delete.setVisible(true);
    }

    public void loadTrucks(){
        cb_truck.addItem(" -");
        ArrayList tractions = trucksDAO.findAll(Long.valueOf(this.IdBusiness)); //'produtoDAO' é meu objeto que retorna os produtos do banco.
        Iterator i = tractions.iterator();

        while(i.hasNext()) {
           cb_truck.addItem(String.valueOf(i.next()));
        }
    }

    public void loadDrivers_() {
        cb_driver.addItem(" -");
        ArrayList tractions = driversDAO.findAllDriversisActive(Long.valueOf(this.IdBusiness)); //'produtoDAO' é meu objeto que retorna os produtos do banco.
        Iterator i = tractions.iterator();

        while(i.hasNext()) {
           cb_driver.addItem(String.valueOf(i.next()));
        }
    }

    public void loadAllDrivers(){
        cb_driver.addItem(" -");
        ArrayList tractions = driversDAO.findAllDrivers(Long.valueOf(this.IdBusiness)); //'produtoDAO' é meu objeto que retorna os produtos do banco.
        Iterator i = tractions.iterator();

        while(i.hasNext()) {
           cb_driver.addItem(String.valueOf(i.next()));
        }
    }

    private void loadUf() {
        ArrayList uf = ufDAO.findAll(); //'produtoDAO' é meu objeto que retorna os produtos do banco.
        Iterator i1 = uf.iterator();
        Iterator i2 = uf.iterator();

        while(i1.hasNext()) {
           cb_uf_source.addItem(String.valueOf(i1.next()));

        while(i2.hasNext()) {
           cb_uf_destination.addItem(String.valueOf(i2.next()));
        }
        }
   }
    private void b_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelActionPerformed
        this.thread = true;
        this.dispose();
    }//GEN-LAST:event_b_cancelActionPerformed

    private void b_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_saveActionPerformed
        String observation = " ";
        if("".equals(f_observation.getText())){
            observation = " ";
        }else{
            observation = f_observation.getText().toUpperCase();
        }
        if("save".equals(status)){
                if ((f_city_destination.getText().isEmpty())
                   || (f_city_source.getText().isEmpty())
                   || (f_company_destination.getText().isEmpty())
                   || (f_company_source.getText().isEmpty())
                   || (f_date_arrived.getText().isEmpty())
                   || (f_date_exit.getText().isEmpty())
                   || (f_discount_comission.getText().isEmpty())
                   || (f_discount_freight.getText().isEmpty())
                   || (f_note.getText().isEmpty())
                   || (f_percent.getText().isEmpty())
                   || (f_product.getText().isEmpty())
                   || (f_value_t.getText().isEmpty())
                   || (f_weight.getText().isEmpty())
                   || (f_date_exit.getText().trim().length() == 4)
                   || (f_date_arrived.getText().trim().length() == 4)
                   || " -".equals(cb_uf_source.getSelectedItem())
                   || " -".equals(cb_uf_destination.getSelectedItem())){
               JOptionPane.showMessageDialog(rootPane, "Campos com ' * ' São obrigatórios!", "Fretes", JOptionPane.WARNING_MESSAGE);

                }else{
                    if (" -".equals(cb_truck.getSelectedItem())){
                     JOptionPane.showMessageDialog(rootPane, "Selecione um Caminhão para continuar!", "Fretes", JOptionPane.WARNING_MESSAGE);
               } else {
                    int random_ = Integer.valueOf(this.IdBusiness + r.nextInt(9999));
                    try {
                        freights.setCity_destination(f_city_destination.getText().toUpperCase());
                        freights.setCity_source(f_city_source.getText().toUpperCase());
                        freights.setCompany_destination(f_company_destination.getText().toUpperCase());
                        freights.setCompany_source(f_company_source.getText().toUpperCase());
                        freights.setData_arrived(u.dateFormatInsert(f_date_arrived.getText()));
                        freights.setData_exit(u.dateFormatInsert(f_date_exit.getText()));
                        freights.setDiscount(Double.valueOf(f_discount_comission.getText().replace(".", "").replace(",", ".")));
                        freights.setDiscount2(Double.valueOf(f_discount_freight.getText().replace(".", "").replace(",", ".")));
                        freights.setFueled(Double.valueOf(f_fueled.getText().replace(".", "").replace(",", ".")));
                        freights.setGross(Double.valueOf(f_gross.getText().replace(".", "").replace(",", ".")));
                        freights.setNote(f_note.getText().toUpperCase());
                        freights.setPercent(Double.valueOf(f_percent.getText().replace(".", "").replace(",", ".")));
                        freights.setProduct(f_product.getText().toUpperCase());
                        freights.setTotal1(Double.valueOf(f_total_comission.getText().replace(".", "").replace(",", ".")));
                        freights.setTotal2(Double.valueOf(f_liq_comission.getText().replace(".", "").replace(",", ".")));
                        freights.setTotal3(Double.valueOf(f_liq_freight.getText().replace(".", "").replace(",", ".")));
                        freights.setValue_t(Double.valueOf(f_value_t.getText().replace(".", "").replace(",", ".")));
                        freights.setWeight(Double.valueOf(f_weight.getText().replace(".", "").replace(",", ".")));
                        freights.setMedium_fueled(Double.valueOf(f_mediun_fueled.getText().replace(",", ".")));
                        freights.setCreated_at(u.dateFormatInsert(u.getDateddMMyyyy()));
                        freights.setUpdated(u.dateFormatInsert(u.getDateddMMyyyy()));
                        freights.setInactive(false);
                        freights.setObservation(observation);
                        freights.setDriver(driversDAO.getIdDriver(String.valueOf(cb_driver.getSelectedItem()), Long.valueOf(this.IdBusiness)));
                        freights.setTruck(trucksDAO.getIDTruck(String.valueOf(cb_truck.getSelectedItem())));
                        freights.setUf_source(ufDAO.getIDUf(String.valueOf(cb_uf_source.getSelectedItem())));
                        freights.setUf_destination(ufDAO.getIDUf(String.valueOf(cb_uf_destination.getSelectedItem())));
                        freights.setId_business(Long.valueOf(this.IdBusiness));
                        freights.setRandom(random_);
                        random = random_;
                        freightsDAO.adiciona(freights);
                        setIdFreight();
                        JOptionPane.showMessageDialog(rootPane, "Frete cadastrado com sucesso, adicione as abastecidas e despesas!", "Fretes",
                                JOptionPane.INFORMATION_MESSAGE);
                    } catch (ParseException ex) {
                        Logger.getLogger(FreightsForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
           }
        }else if("update".equals(status)){
            //calculator();
            if ((f_city_destination.getText().isEmpty())
                   || (f_city_source.getText().isEmpty())
                   || (f_company_destination.getText().isEmpty())
                   || (f_company_source.getText().isEmpty())
                   || (f_date_arrived.getText().isEmpty())
                   || (f_date_exit.getText().isEmpty())
                   || (f_discount_comission.getText().isEmpty())
                   || (f_discount_freight.getText().isEmpty())
                   || (f_note.getText().isEmpty())
                   || (f_percent.getText().isEmpty())
                   || (f_product.getText().isEmpty())
                   || (f_value_t.getText().isEmpty())
                   || (f_weight.getText().isEmpty())
                   || (f_date_exit.getText().trim().length() == 4)
                   || (f_date_arrived.getText().trim().length() == 4)
                   || " -".equals(cb_uf_source.getSelectedItem())
                   || " -".equals(cb_uf_destination.getSelectedItem())){
               JOptionPane.showMessageDialog(rootPane, "Campos com ' * ' São obrigatórios!", "Fretes", JOptionPane.WARNING_MESSAGE);

                }else{
                    if (" -".equals(cb_truck.getSelectedItem())){
                     JOptionPane.showMessageDialog(rootPane, "Selecione um Caminhão para continuar!", "Fretes", JOptionPane.WARNING_MESSAGE);
               } else {
                    try {
                        freights.setCity_destination(f_city_destination.getText().toUpperCase());
                        freights.setCity_source(f_city_source.getText().toUpperCase());
                        freights.setCompany_destination(f_company_destination.getText().toUpperCase());
                        freights.setCompany_source(f_company_source.getText().toUpperCase());
                        freights.setData_arrived(u.dateFormatInsert(f_date_arrived.getText()));
                        freights.setData_exit(u.dateFormatInsert(f_date_exit.getText()));
                        freights.setDiscount(Double.valueOf(f_discount_comission.getText().replace(".", "").replace(",", ".")));
                        freights.setDiscount2(Double.valueOf(f_discount_freight.getText().replace(".", "").replace(",", ".")));
                        freights.setFueled(Double.valueOf(f_fueled.getText().replace(",", ".")));
                        freights.setGross(Double.valueOf(f_gross.getText().replace(".", "").replace(",", ".")));
                        freights.setNote(f_note.getText().toUpperCase());
                        freights.setPercent(Double.valueOf(f_percent.getText().replace(".", "").replace(",", ".")));
                        freights.setProduct(f_product.getText().toUpperCase());
                        freights.setTotal1(Double.valueOf(f_total_comission.getText().replace(".", "").replace(",", ".")));
                        freights.setTotal2(Double.valueOf(f_liq_comission.getText().replace(".", "").replace(",", ".")));
                        freights.setTotal3(Double.valueOf(f_liq_freight.getText().replace(".", "").replace(",", ".")));
                        freights.setValue_t(Double.valueOf(f_value_t.getText().replace(".", "").replace(",", ".")));
                        freights.setWeight(Double.valueOf(f_weight.getText().replace(".", "").replace(",", ".")));
                        freights.setMedium_fueled(Double.valueOf(f_mediun_fueled.getText().replace(",", ".")));
                        freights.setCreated_at(u.dateFormatInsert(u.getDateddMMyyyy()));
                        freights.setUpdated(u.dateFormatInsert(u.getDateddMMyyyy()));
                        freights.setInactive(false);
                        freights.setObservation(observation);
                        freights.setDriver(driversDAO.getIdDriver(String.valueOf(cb_driver.getSelectedItem()), Long.valueOf(this.IdBusiness)));
                        freights.setTruck(trucksDAO.getIDTruck(String.valueOf(cb_truck.getSelectedItem())));
                        freights.setUf_source(ufDAO.getIDUf(String.valueOf(cb_uf_source.getSelectedItem())));
                        freights.setUf_destination(ufDAO.getIDUf(String.valueOf(cb_uf_destination.getSelectedItem())));
                        freights.setId_business(Long.valueOf(this.IdBusiness));
                        freights.setId(Long.valueOf(f_id.getText()));
                        freightsDAO.atualiza(freights);
                        setIdFreight();
                        JOptionPane.showMessageDialog(rootPane, "Frete atualizado com sucesso", "Fretes", JOptionPane.INFORMATION_MESSAGE);
                        FreightsForm FreightsF = new FreightsForm();
                        FreightsF.deskPane = deskPane;
                        deskPane.add(FreightsF);
                        Centraliza.setCentro(FreightsF, deskPane, WIDTH, HEIGHT);
                        FreightsF.IdBusiness = this.IdBusiness;
                        FreightsF.setVisible(true);
                        FreightsF.loadTrucks();
                        FreightsF.loadDrivers_();
                        this.dispose();
                    } catch (ParseException ex) {
                        Logger.getLogger(FreightsForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
           }
        }
    }//GEN-LAST:event_b_saveActionPerformed

    private void b_fueledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_fueledActionPerformed
        FueledForm FueledF = new FueledForm();
        deskPane.add(FueledF);
        Centraliza.setCentro(FueledF, deskPane, WIDTH, HEIGHT);
        FueledF.freightsForm = this;
        FueledF.f_id_freight.setText(f_id.getText());
        FueledF.IdBusiness = this.IdBusiness;
        FueledF.id_truck = trucksDAO.getIDTruck(String.valueOf(cb_truck.getSelectedItem()));
        FueledF.setVisible(true);
        FueledF.setFueled();
    }//GEN-LAST:event_b_fueledActionPerformed

    private void b_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_deleteActionPerformed
        Object[] options = {" Sim ", " Não "};
         int i = JOptionPane.showOptionDialog(null,"Você tem certeza que deseja Excluir(inativar) este frete?", "Fretes | Cadore Sistemas",
         JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
         if (i == JOptionPane.YES_OPTION) {
            freights.setInactive(true);
            freights.setId(Long.valueOf(f_id.getText()));
            freights.setId_business(Long.valueOf(this.IdBusiness));
            freightsDAO.exclui(freights);
            JOptionPane.showMessageDialog(rootPane, "Frete Excluido(inativado) com sucesso", "Fretes | Cadore Sistemas", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
         }
    }//GEN-LAST:event_b_deleteActionPerformed

    private void f_noteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f_noteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_f_noteActionPerformed

    private void f_noteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_noteKeyReleased
        f_note.setText(f_note.getText().toUpperCase());
    }//GEN-LAST:event_f_noteKeyReleased

    private void f_value_tFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_value_tFocusGained
        f_value_t.selectAll();
    }//GEN-LAST:event_f_value_tFocusGained

    private void f_weightFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_weightFocusGained
        f_weight.selectAll();
    }//GEN-LAST:event_f_weightFocusGained

    private void f_discount_freightFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_discount_freightFocusGained
        f_discount_freight.selectAll();
    }//GEN-LAST:event_f_discount_freightFocusGained

    private void f_fueledFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_fueledFocusGained
        f_fueled.selectAll();
    }//GEN-LAST:event_f_fueledFocusGained

    private void f_fueledKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_fueledKeyReleased

    }//GEN-LAST:event_f_fueledKeyReleased

    private void f_liq_freightFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_liq_freightFocusGained
        f_liq_freight.selectAll();
    }//GEN-LAST:event_f_liq_freightFocusGained

    private void f_liq_freightKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_liq_freightKeyReleased

    }//GEN-LAST:event_f_liq_freightKeyReleased

    private void f_percentFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_percentFocusGained
        f_percent.selectAll();
    }//GEN-LAST:event_f_percentFocusGained

    private void f_total_comissionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_total_comissionFocusGained
        f_total_comission.selectAll();
    }//GEN-LAST:event_f_total_comissionFocusGained

    private void f_total_comissionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_total_comissionKeyReleased

    }//GEN-LAST:event_f_total_comissionKeyReleased

    private void f_discount_comissionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_discount_comissionFocusGained
        f_discount_comission.selectAll();
    }//GEN-LAST:event_f_discount_comissionFocusGained

    private void f_liq_comissionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_liq_comissionFocusGained
        f_liq_comission.selectAll();
    }//GEN-LAST:event_f_liq_comissionFocusGained

    private void f_liq_comissionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_liq_comissionKeyReleased

    }//GEN-LAST:event_f_liq_comissionKeyReleased

    private void ck_comissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ck_comissionActionPerformed
        if(ck_comission.isSelected() == true){
            if("update".equals(status)){
                f_percent.setText(decimal.format(freights.getPercent()).replace(".", ","));
                f_total_comission.setText(decimal.format(freights.getTotal1()).replace(".", ","));
                f_discount_comission.setText(decimal.format(freights.getDiscount()).replace(".", ","));
                f_liq_comission.setText(decimal.format(freights.getTotal2()).replace(".", ","));
            }else{
                f_percent.setText("0,00");
                f_total_comission.setText("0,00");
                f_discount_comission.setText("0,00");
                f_liq_comission.setText("0,00");
            }
            f_percent.setEditable(true);
            f_discount_comission.setEditable(true);
            f_percent.grabFocus();
        }else if(ck_comission.isSelected() == false){
            f_percent.setText("0,00");
            f_total_comission.setText("0,00");
            f_discount_comission.setText("0,00");
            f_liq_comission.setText("0,00");
            f_percent.setEditable(false);
            f_discount_comission.setEditable(false);
        }
    }//GEN-LAST:event_ck_comissionActionPerformed

    private void f_discount_comissionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_discount_comissionFocusLost
        if(u.isNumbers(f_discount_comission)){
            double a = Double.valueOf(f_discount_comission.getText().replace(",", "."));
            f_discount_comission.setText(String.valueOf(decimal.format(a)).replace(".", ","));
        }
    }//GEN-LAST:event_f_discount_comissionFocusLost

    private void f_percentFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_percentFocusLost
        if(u.isNumbers(f_percent)){
            double a = Double.valueOf(f_percent.getText().replace(",", "."));
            f_percent.setText(String.valueOf(decimal.format(a)).replace(".", ","));
        }
    }//GEN-LAST:event_f_percentFocusLost

    private void f_discount_freightFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_discount_freightFocusLost

    }//GEN-LAST:event_f_discount_freightFocusLost

    private void f_value_tFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_value_tFocusLost
        if(u.isNumbers(f_value_t)){
            double a = Double.valueOf(f_value_t.getText().replace(",", "."));
            f_value_t.setText(String.valueOf(decimal.format(a)).replace(".", ","));
        }
    }//GEN-LAST:event_f_value_tFocusLost

    private void f_weightFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_weightFocusLost
        if(u.isNumbers(f_weight)){
            double a = Double.valueOf(f_weight.getText().replace(",", "."));
            f_weight.setText(String.valueOf(decimal.format(a)).replace(".", ","));
        }
    }//GEN-LAST:event_f_weightFocusLost

    private void cb_truckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_truckActionPerformed
       if(" -".equals(cb_truck.getSelectedItem())){
           cb_driver.setEnabled(false);
       }else if(!" -".equals(cb_truck.getSelectedItem())){
           cb_driver.setEnabled(true);
       }
        if(" -".equals(cb_truck.getSelectedItem())){
            cb_driver.setSelectedItem(" -");
        }else if(!" -".equals(cb_truck.getSelectedItem())){
            cb_driver.setSelectedItem(driversDAO.getDriverByID(driversDAO.getIdDriverByTruck(String.valueOf(cb_truck.getSelectedItem()),
                    Long.valueOf(this.IdBusiness)), Long.valueOf(this.IdBusiness)));
        }
    }//GEN-LAST:event_cb_truckActionPerformed

    private void b_outputsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_outputsActionPerformed
        OutputsSearch OutputsS = new OutputsSearch();
        deskPane.add(OutputsS);
        OutputsS.deskPane = deskPane;
        Centraliza.setCentro(OutputsS, deskPane, WIDTH, HEIGHT);
        OutputsS.IdFreight = Long.valueOf(f_id.getText());
        OutputsS.IdBusiness = this.IdBusiness;
        OutputsS.setVisible(true);
        OutputsS.statusFreight = "freight";
        OutputsS.setTitle("Consulta de Despesas");
        OutputsS.b_cancel.setText("Concluir");
        OutputsS.b_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Yes.png")));
        OutputsS.IdTruck = trucksDAO.getIDTruck(String.valueOf(cb_truck.getSelectedItem()));
        OutputsS.getOutputsByFreight();
        OutputsS.b_delete.setVisible(true);
        OutputsS.b_select.setVisible(false);
        OutputsS.freightsF = this;
    }//GEN-LAST:event_b_outputsActionPerformed

    private void f_company_sourceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_company_sourceKeyReleased
        f_company_source.setText(f_company_source.getText().toUpperCase());
    }//GEN-LAST:event_f_company_sourceKeyReleased

    private void f_city_sourceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_city_sourceKeyReleased
        f_city_source.setText(f_city_source.getText().toUpperCase());
    }//GEN-LAST:event_f_city_sourceKeyReleased

    private void f_company_destinationKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_company_destinationKeyReleased
        f_company_destination.setText(f_company_destination.getText().toUpperCase());
    }//GEN-LAST:event_f_company_destinationKeyReleased

    private void f_city_destinationKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_city_destinationKeyReleased
        f_city_destination.setText(f_city_destination.getText().toUpperCase());
    }//GEN-LAST:event_f_city_destinationKeyReleased

    private void f_productKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_productKeyReleased
        f_product.setText(f_product.getText().toUpperCase());
    }//GEN-LAST:event_f_productKeyReleased

    private void l_calculator_valuetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_calculator_valuetMouseEntered
        l_calculator_valuet.setForeground(Color.RED);
    }//GEN-LAST:event_l_calculator_valuetMouseEntered

    private void l_calculator_valuetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_calculator_valuetMouseExited
        l_calculator_valuet.setForeground(Color.BLACK);
    }//GEN-LAST:event_l_calculator_valuetMouseExited

    private void l_calculator_valuetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_calculator_valuetMouseClicked
        double gross_ = Double.valueOf(JOptionPane.showInputDialog(rootPane, "Informe o valor total!\nEx: 4096,26 ou 4026", title, JOptionPane.INFORMATION_MESSAGE)
        .replace("R","").replace("r","").replace("s","").replace("S","").replace("$","").replace(",","."));
        double weight_ = Double.valueOf(f_weight.getText().replace(",", "."));
        f_value_t.setText(String.valueOf(decimal.format(gross_/weight_)).replace(".", ","));
        ck_comission.grabFocus();
    }//GEN-LAST:event_l_calculator_valuetMouseClicked

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        this.thread = true;
    }//GEN-LAST:event_formInternalFrameClosed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        this.thread = true;
    }//GEN-LAST:event_formInternalFrameClosing

    private void f_date_exitKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_date_exitKeyReleased
        if(f_date_exit.getText().trim().length() == 10){
           f_date_arrived.grabFocus();
        }
    }//GEN-LAST:event_f_date_exitKeyReleased

    private void f_date_arrivedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_date_arrivedKeyReleased
        if(f_date_arrived.getText().trim().length() == 10){
           f_weight.grabFocus();
        }
    }//GEN-LAST:event_f_date_arrivedKeyReleased

    private void f_observationKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_observationKeyReleased
        int length = f_observation.getText().trim().length();
        l_length.setText(String.valueOf(length)+" caracteres, máximo 350 caracteres.");

    }//GEN-LAST:event_f_observationKeyReleased

    private void f_mediun_fueledFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_mediun_fueledFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_f_mediun_fueledFocusGained

    private void f_mediun_fueledKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_mediun_fueledKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_f_mediun_fueledKeyReleased

    private void cb_uf_sourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_uf_sourceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_uf_sourceActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton b_cancel;
    private javax.swing.JButton b_delete;
    private javax.swing.JButton b_fueled;
    private javax.swing.JButton b_outputs;
    private javax.swing.JButton b_save;
    public javax.swing.JComboBox cb_driver;
    public javax.swing.JComboBox cb_truck;
    private javax.swing.JComboBox cb_uf_destination;
    private javax.swing.JComboBox cb_uf_source;
    private javax.swing.JCheckBox ck_comission;
    private javax.swing.JTextField f_city_destination;
    private javax.swing.JTextField f_city_source;
    private javax.swing.JTextField f_company_destination;
    private javax.swing.JTextField f_company_source;
    private javax.swing.JFormattedTextField f_date_arrived;
    private javax.swing.JFormattedTextField f_date_exit;
    private javax.swing.JTextField f_discount_comission;
    public javax.swing.JTextField f_discount_freight;
    public javax.swing.JTextField f_fueled;
    private javax.swing.JTextField f_gross;
    private javax.swing.JTextField f_id;
    private javax.swing.JTextField f_liq_comission;
    private javax.swing.JTextField f_liq_freight;
    public javax.swing.JTextField f_mediun_fueled;
    private javax.swing.JTextField f_note;
    private javax.swing.JEditorPane f_observation;
    private javax.swing.JTextField f_percent;
    private javax.swing.JTextField f_product;
    private javax.swing.JTextField f_total_comission;
    private javax.swing.JTextField f_value_t;
    private javax.swing.JTextField f_weight;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel l_calculator_valuet;
    private javax.swing.JLabel l_length;
    // End of variables declaration//GEN-END:variables
}
