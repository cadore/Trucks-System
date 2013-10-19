package br.com.cadoresistemas.williamcadore.GUI;

import br.com.cadoresistemas.williamcadore.DAO.FueledDAO;
import br.com.cadoresistemas.williamcadore.DAO.UfDAO;
import br.com.cadoresistemas.williamcadore.ModelsForm.FueledModel;
import br.com.cadoresistemas.williamcadore.TableModels.FueledTableModel;
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
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class FueledForm extends javax.swing.JInternalFrame {

    AnnotationResolver resolver = new AnnotationResolver(FueledTableModel.class);
    ObjectTableModel<FueledTableModel> tableModel = new ObjectTableModel<>(resolver, "id,date,station,km,liters,rs_liters,total");

    List<FueledTableModel> listFueled = new ArrayList<>();

    public FueledForm() {
        initComponents();
        loadUf();
        this.setFrameIcon(new ImageIcon(this.getClass().getResource("/Images/iconTruckSystem.jpg")));
    }

    public FueledModel fueled = new FueledModel();
    private FueledDAO fueledDAO = new FueledDAO();
    private UfDAO ufDAO = new UfDAO();
    private Util date = new Util();
    private DecimalFormat decimal = new DecimalFormat("0.00");
    private Util ut = new Util();
    public String IdBusiness = null;
    public Long id_truck = null;
    public FreightsForm freightsForm = null;
    private boolean status_launch = false;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        f_date = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        f_station = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        f_city = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        f_km = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        f_liters = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        f_rs_liters = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        f_total = new javax.swing.JTextField();
        b_exit = new javax.swing.JButton();
        b_launch = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        f_id_freight = new javax.swing.JTextField();
        cb_uf = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_fueled = new javax.swing.JTable();
        f_total_items = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        b_exit1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        f_total_fueled = new javax.swing.JTextField();
        l_status = new javax.swing.JLabel();
        f_discount = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        f_sub_total = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        f_medium_fueled = new javax.swing.JTextField();

        setTitle("Lançar Novo Abastecimento");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Novo Abastecimento");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("*Data:");

        try {
            f_date.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        f_date.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_date.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_dateKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("*Posto:");

        f_station.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("*Cidade:");

        f_city.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("*UF:");

        f_km.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_km.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                f_kmFocusGained(evt);
            }
        });
        f_km.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_kmKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("*KM:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("*Litros:");

        f_liters.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_liters.setText("0,00");
        f_liters.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                f_litersFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                f_litersFocusLost(evt);
            }
        });
        f_liters.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_litersKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("*R$ P/ Litro:");

        f_rs_liters.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_rs_liters.setText("0,00");
        f_rs_liters.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                f_rs_litersFocusLost(evt);
            }
            public void focusGained(java.awt.event.FocusEvent evt) {
                f_rs_litersFocusGained(evt);
            }
        });
        f_rs_liters.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_rs_litersKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Total:");

        f_total.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_total.setText("0,00");
        f_total.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                f_totalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                f_totalFocusLost(evt);
            }
        });
        f_total.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_totalKeyReleased(evt);
            }
        });

        b_exit.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        b_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Yes.png"))); // NOI18N
        b_exit.setText("Concluir");
        b_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_exitActionPerformed(evt);
            }
        });

        b_launch.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        b_launch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Load.png"))); // NOI18N
        b_launch.setText("Lançar Abastecimento");
        b_launch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_launchActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Id Frete:");

        f_id_freight.setEditable(false);
        f_id_freight.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        cb_uf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_uf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ufActionPerformed(evt);
            }
        });

        t_fueled.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        t_fueled.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(t_fueled);

        f_total_items.setEditable(false);
        f_total_items.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_total_items.setText("0");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Total de Itens:");

        b_exit1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        b_exit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Delete.png"))); // NOI18N
        b_exit1.setText("Excluir Item");
        b_exit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_exit1ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Total de Abastecimento R$:");

        f_total_fueled.setEditable(false);
        f_total_fueled.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_total_fueled.setText("0,00");

        l_status.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        l_status.setForeground(new java.awt.Color(255, 0, 0));

        f_discount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_discount.setText("0,00");
        f_discount.setNextFocusableComponent(f_station);
        f_discount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                f_discountFocusLost(evt);
            }
            public void focusGained(java.awt.event.FocusEvent evt) {
                f_discountFocusGained(evt);
            }
        });
        f_discount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f_discountKeyReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Desconto:");

        f_sub_total.setEditable(false);
        f_sub_total.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_sub_total.setText("0,00");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Subtotal:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Média de consumo:");

        f_medium_fueled.setEditable(false);
        f_medium_fueled.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_medium_fueled.setText("0,00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(f_id_freight, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(f_date, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(f_km, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(l_status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(f_liters, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(f_rs_liters, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(f_total, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(f_discount, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(f_sub_total)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel3))
                            .addComponent(f_station, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(259, 259, 259))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(f_city, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cb_uf, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(b_launch))))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(f_total_items, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(f_medium_fueled))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(f_total_fueled, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b_exit1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(f_id_freight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(l_status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(f_km, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(f_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(f_sub_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(f_discount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(6, 6, 6)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(f_station, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(f_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_uf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(b_launch, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(f_liters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(f_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(f_rs_liters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(b_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(b_exit1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(f_total_items, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(f_medium_fueled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(f_total_fueled)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void soma(){
        double soma_total = 0;
        int contador = t_fueled.getRowCount();

           for(int u=0; u<contador; u++){
                 soma_total += Double.valueOf(t_fueled.getValueAt(u,6).toString().replace(",", "."));
           }

           double soma_liters = 0;
           for(int u=0; u<contador; u++){
                 soma_liters += Double.valueOf(t_fueled.getValueAt(u,4).toString().replace(",", "."));
           }
           f_total_fueled.setText(String.valueOf(decimal.format(soma_total)));
           String a = f_total_fueled.getText().replace(".", ",");
           f_total_fueled.setText(a);
           f_total_items.setText(String.valueOf(contador));

           Double km_max = fueledDAO.getMAXKMFreight(Long.valueOf(f_id_freight.getText()), Long.valueOf(this.IdBusiness));
           Double km_min = fueledDAO.getMINKMFreight(Long.valueOf(f_id_freight.getText()), Long.valueOf(this.IdBusiness));
           Double total_km = 0.0;
           if(contador == 1){
               total_km = km_max;
           }else{
               total_km = km_max - km_min;
           }
           Double medium_fueled = total_km / soma_liters;
           if(medium_fueled > 0){
               f_medium_fueled.setText(decimal.format(medium_fueled).replace(".", ","));
           }
    }

    public void setFueled(){
        tableModel.clear();
        listFueled.clear();
        List<FueledModel> f = fueledDAO.getFueled(Long.valueOf(f_id_freight.getText()), Long.valueOf(this.IdBusiness), this.id_truck);
        for(FueledModel u : f) {
            try {
                String data_ = ut.dateFormatReturn(u.getDate());
                String liters = String.valueOf(decimal.format(u.getLiters())).replace(".", ",");
                String rs_liters = String.valueOf(decimal.format(u.getRs_liter())).replace(".", ",");
                String sub_total = String.valueOf(decimal.format(u.getSub_total())).replace(".", ",");
                String km = String.valueOf(decimal.format(u.getKm())).replace(".", ",");
                listFueled.add(new FueledTableModel(u.getId(),data_, u.getStation(),km,liters,rs_liters, sub_total));
            } catch (ParseException ex) {
                Logger.getLogger(FueledForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        tableModel.setData(listFueled);
        t_fueled.setModel(tableModel);

        t_fueled.getColumnModel().getColumn(0).setPreferredWidth(3);
        t_fueled.getColumnModel().getColumn(1).setPreferredWidth(30);
        t_fueled.getColumnModel().getColumn(2).setPreferredWidth(200);
        t_fueled.getColumnModel().getColumn(3).setPreferredWidth(50);
        t_fueled.getColumnModel().getColumn(4).setPreferredWidth(55);
        t_fueled.getColumnModel().getColumn(5).setPreferredWidth(100);
        t_fueled.getColumnModel().getColumn(6).setPreferredWidth(35);
        t_fueled.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        soma();
    }

    private void loadUf() {
        UfDAO dao = new UfDAO();
        cb_uf.removeAllItems(); //remove os itens atuais do comboBox.
        ArrayList uf = dao.findAll(); //'produtoDAO' é meu objeto que retorna os produtos do banco.
        Iterator i = uf.iterator();

        while(i.hasNext()) {
           cb_uf.addItem(String.valueOf(i.next()));
        }
   }

    private void b_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_exitActionPerformed
        freightsForm.f_fueled.setText(f_total_fueled.getText());
        freightsForm.f_mediun_fueled.setText(f_medium_fueled.getText());
        this.dispose();
    }//GEN-LAST:event_b_exitActionPerformed

    private void b_launchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_launchActionPerformed
        if (" -".equals(cb_uf.getSelectedItem())
                || (f_date.getText().trim().length() == 4)
                || (f_station.getText().isEmpty())
                || (f_km.getText().isEmpty())
                || (f_city.getText().isEmpty())
                || (f_liters.getText().isEmpty())
                || (f_rs_liters.getText().isEmpty())
                || f_total.getText().isEmpty()
                || status_launch == false){
               JOptionPane.showMessageDialog(rootPane, "Campos com ' * ' São obrigatórios!", "Fretes", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                fueled.setIdFreight(Long.valueOf(f_id_freight.getText()));
                fueled.setDate(date.dateFormatInsert(f_date.getText()));
                fueled.setStation(f_station.getText().toUpperCase());
                fueled.setCity(f_city.getText().toUpperCase());
                fueled.setKm(Double.valueOf(f_km.getText().replace(",", ".")));
                fueled.setLiters(Double.valueOf(f_liters.getText().replace(".", "").replace(",", ".")));
                fueled.setRs_liter(Double.valueOf(f_rs_liters.getText().replace(".", "").replace(",", ".")));
                fueled.setTotal(Double.valueOf(f_total.getText().replace(".", "").replace(",", ".")));
                fueled.setCreated_at(date.dateFormatInsert(date.getDateddMMyyyy()));
                fueled.setUpdated(date.dateFormatInsert(date.getDateddMMyyyy()));
                fueled.setUf(ufDAO.getIDUf(String.valueOf(cb_uf.getSelectedItem())));
                fueled.setDiscount(Double.valueOf(f_discount.getText().replace(",", ".")));
                fueled.setSub_total(Double.valueOf(f_sub_total.getText().replace(",", ".")));
                fueled.setId_business(Long.valueOf(this.IdBusiness));
                fueled.setIdTruck(id_truck);
                fueled.setInacctive(false);

                fueledDAO.adiciona(fueled);
                f_date.setText("");
                f_station.setText("");
                f_city.setText("");
                f_km.setText("");
                f_liters.setText("0,00");
                f_rs_liters.setText("0,00");
                f_total.setText("0,00");
                f_discount.setText("0,00");
                f_sub_total.setText("0,00");
                loadUf();
                f_date.grabFocus();
                setFueled();
            } catch (ParseException ex) {
                Logger.getLogger(FueledForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_b_launchActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

    }//GEN-LAST:event_formInternalFrameOpened

    private void b_exit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_exit1ActionPerformed
        if(t_fueled.getSelectedRowCount() > 0){
            Object obj = t_fueled.getValueAt(t_fueled.getSelectedRow(), 0);
            fueled.setId(Long.valueOf(obj.toString()));
            fueled.setId_business(Long.valueOf(this.IdBusiness));
            fueledDAO.excluiById(fueled);
            setFueled();
            soma();
        }else{
            JOptionPane.showMessageDialog(rootPane, "Selecione um item para Excluir", "Cadore Sistemas", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_b_exit1ActionPerformed

    private void f_litersKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_litersKeyReleased
        if(ut.isNumbers(f_liters) == true && ut.isNumbers(f_rs_liters) == true && ut.isNumbers(f_discount) == true){
            double a = Double.valueOf(f_liters.getText().replace(",", "."));
            double b = Double.valueOf(f_rs_liters.getText().replace(",", "."));
            double c = Double.valueOf(f_discount.getText().replace(",", "."));
            double total = Double.valueOf(a*b);
            f_total.setText(String.valueOf(decimal.format(total)).replace(".", ","));
            f_sub_total.setText(String.valueOf(decimal.format(total - c)).replace(".", ","));
        }
    }//GEN-LAST:event_f_litersKeyReleased

    private void f_litersFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_litersFocusGained
        f_liters.selectAll();
    }//GEN-LAST:event_f_litersFocusGained

    private void f_litersFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_litersFocusLost
        if(ut.isNumbers(f_liters) == true){
            double a = Double.valueOf(f_liters.getText().replace(",", "."));
            f_liters.setText(String.valueOf(decimal.format(a).replace(".", ",")));
            status_launch = true;
        }else{
            status_launch = false;
        }
    }//GEN-LAST:event_f_litersFocusLost

    private void f_rs_litersKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_rs_litersKeyReleased
        java.awt.event.KeyEvent evtt = null;
        f_litersKeyReleased(evtt);
    }//GEN-LAST:event_f_rs_litersKeyReleased

    private void f_rs_litersFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_rs_litersFocusGained
        f_rs_liters.selectAll();
    }//GEN-LAST:event_f_rs_litersFocusGained

    private void f_rs_litersFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_rs_litersFocusLost
        if(ut.isNumbers(f_rs_liters) == true){
            double a = Double.valueOf(f_rs_liters.getText().replace(",", "."));
            f_rs_liters.setText(String.valueOf(decimal.format(a).replace(".", ",")));
            status_launch = true;
        }else{
            status_launch = false;
        }
    }//GEN-LAST:event_f_rs_litersFocusLost

    private void f_totalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_totalKeyReleased
        if(ut.isNumbers(f_liters) == true && ut.isNumbers(f_total) == true && ut.isNumbers(f_discount) == true && ut.isNumbers(f_discount)){
            double a = Double.valueOf(f_total.getText().replace(",", "."));
            double b = Double.valueOf(f_liters.getText().replace(",", "."));
            double c = Double.valueOf(f_discount.getText().replace(",", "."));
            String rs_liters = String.valueOf(decimal.format(a / b));
            f_rs_liters.setText(rs_liters.replace(".", ","));
            f_sub_total.setText(String.valueOf(decimal.format(a - c)).replace(".", ","));
        }
    }//GEN-LAST:event_f_totalKeyReleased

    private void f_totalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_totalFocusGained
        f_total.selectAll();
    }//GEN-LAST:event_f_totalFocusGained

    private void f_totalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_totalFocusLost
        if(ut.isNumbers(f_total) == true){
            double a = Double.valueOf(f_total.getText().replace(",", "."));
            f_total.setText(String.valueOf(decimal.format(a).replace(".", ",")));
            status_launch = true;
        }else{
            status_launch = false;
        }
    }//GEN-LAST:event_f_totalFocusLost

    private void f_dateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_dateKeyReleased
        if(f_date.getText().trim().length() == 10){
           f_km.grabFocus();
        }
    }//GEN-LAST:event_f_dateKeyReleased

    private void cb_ufActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ufActionPerformed
        
    }//GEN-LAST:event_cb_ufActionPerformed

    private void f_kmKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_kmKeyReleased
        if(ut.isNumbers(f_km) == false){
            l_status.setText("Km invalido!");
            status_launch = false;
        }else if(ut.isNumbers(f_km) == true){
            l_status.setText("");
            status_launch = true;
        }
    }//GEN-LAST:event_f_kmKeyReleased

    private void f_kmFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_kmFocusGained
        f_km.selectAll();
    }//GEN-LAST:event_f_kmFocusGained

    private void f_discountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_discountFocusGained
        f_discount.selectAll();
    }//GEN-LAST:event_f_discountFocusGained

    private void f_discountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_f_discountFocusLost
        if(ut.isNumbers(f_discount) == true){
            double a = Double.valueOf(f_discount.getText().replace(",", "."));
            f_discount.setText(String.valueOf(decimal.format(a).replace(".", ",")));
            status_launch = true;
        }else{
            status_launch = false;
        }
    }//GEN-LAST:event_f_discountFocusLost

    private void f_discountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_discountKeyReleased
        java.awt.event.KeyEvent evtt = null;
        f_totalKeyReleased(evtt);
    }//GEN-LAST:event_f_discountKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_exit;
    private javax.swing.JButton b_exit1;
    private javax.swing.JButton b_launch;
    private javax.swing.JComboBox cb_uf;
    private javax.swing.JTextField f_city;
    private javax.swing.JFormattedTextField f_date;
    private javax.swing.JTextField f_discount;
    public javax.swing.JTextField f_id_freight;
    private javax.swing.JTextField f_km;
    private javax.swing.JTextField f_liters;
    private javax.swing.JTextField f_medium_fueled;
    private javax.swing.JTextField f_rs_liters;
    private javax.swing.JTextField f_station;
    private javax.swing.JTextField f_sub_total;
    private javax.swing.JTextField f_total;
    private javax.swing.JTextField f_total_fueled;
    private javax.swing.JTextField f_total_items;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel l_status;
    private javax.swing.JTable t_fueled;
    // End of variables declaration//GEN-END:variables
}
