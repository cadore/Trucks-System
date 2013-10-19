package br.com.cadoresistemas.williamcadore.GUI;

import br.com.cadoresistemas.williamcadore.ConnectioFactory.ConnectionFactory;
import br.com.cadoresistemas.williamcadore.DAO.BusinessDAO;
import br.com.cadoresistemas.williamcadore.DAO.PaymentDAO;
import br.com.cadoresistemas.williamcadore.DAO.TrucksDAO;
import br.com.cadoresistemas.williamcadore.GUIReports.CashBookReportsForm;
import br.com.cadoresistemas.williamcadore.GUIReports.FreightsReportsForm;
import br.com.cadoresistemas.williamcadore.GUIReports.InputsReportsForm;
import br.com.cadoresistemas.williamcadore.GUIReports.OthersReportsForm;
import br.com.cadoresistemas.williamcadore.GUIReports.OutputsReportsForm;
import br.com.cadoresistemas.williamcadore.GUIReports.PaymentsReportsForm;
import br.com.cadoresistemas.williamcadore.ModelsForm.PaymentModel;
import br.com.cadoresistemas.williamcadore.ModelsForm.UserModel;
import br.com.cadoresistemas.williamcadore.TableModels.DashboardPaymentDayTableModel;
import br.com.cadoresistemas.williamcadore.TableModels.DashboardPaymentToDayTableModel;
import br.com.cadoresistemas.williamcadore.TableModels.DashboardPaymentsExpiryTableModel;
import br.com.cadoresistemas.williamcadore.Utils.Centraliza;
import br.com.cadoresistemas.williamcadore.Utils.Paths;
import br.com.cadoresistemas.williamcadore.Utils.TrucksSystemDefault;
import br.com.cadoresistemas.williamcadore.Utils.Util;
import com.towel.el.annotation.AnnotationResolver;
import com.towel.swing.table.ObjectTableModel;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public final class Dashboard extends javax.swing.JFrame {

    AnnotationResolver resolverTableDay = new AnnotationResolver(DashboardPaymentDayTableModel.class);
    ObjectTableModel<DashboardPaymentDayTableModel> tableModelDay = new ObjectTableModel<>(resolverTableDay, "id,id_truck,pago_a,data_vencimento,valor,identificacao");
    List<DashboardPaymentDayTableModel> listPaymentDay = new ArrayList<>();

    AnnotationResolver resolverTableToDay = new AnnotationResolver(DashboardPaymentToDayTableModel.class);
    ObjectTableModel<DashboardPaymentToDayTableModel> tableModelToDay = new ObjectTableModel<>(resolverTableToDay, "id,id_truck,pago_a,data_vencimento,valor,identificacao");
    List<DashboardPaymentToDayTableModel> listPaymentToDay = new ArrayList<>();

    AnnotationResolver resolverTablePaymentsExpiry = new AnnotationResolver(DashboardPaymentsExpiryTableModel.class);
    ObjectTableModel<DashboardPaymentsExpiryTableModel> tableModelPaymentsExpiry = new ObjectTableModel<>(resolverTablePaymentsExpiry, "id,id_truck,pago_a,data_vencimento,valor,identificacao");
    List<DashboardPaymentsExpiryTableModel> listPaymentsExpiry = new ArrayList<>();

    public Dashboard() {
        initComponents();
 }

    public JDesktopPane deskPane = null;
    public UserModel user = new UserModel();
    public String IdBusiness = null;
    public java.util.Date date_db = null;
    private TrucksDAO trucksDAO = new TrucksDAO();
    private Util ut = new Util();
    private DecimalFormat decimal = new DecimalFormat("0.00");
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private boolean status_num_lock = false;
    private boolean status_caps_lock = false;
    private Toolkit tk = Toolkit.getDefaultToolkit();
    private PaymentDAO paymentDAO = new PaymentDAO();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        l_date_system = new javax.swing.JLabel();
        l_user_session = new javax.swing.JLabel();
        l_id_business = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        tp_accountants = new javax.swing.JTabbedPane();
        p_to_day = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_payments_day = new javax.swing.JTable();
        p_payments_expiry = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        t_payments_to_day = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        t_payments_expiry = new javax.swing.JTable();
        p_status_numEcaps_lock = new javax.swing.JPanel();
        l_caps_lock = new javax.swing.JLabel();
        l_num_lock = new javax.swing.JLabel();
        b_num_lock = new javax.swing.JButton();
        b_caps_lock = new javax.swing.JButton();
        p_button_apdate_lists = new javax.swing.JPanel();
        b_update_list = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        Menu_imputs = new javax.swing.JMenu();
        Menu_freight = new javax.swing.JMenu();
        freight_new = new javax.swing.JMenuItem();
        freight_cunsult = new javax.swing.JMenuItem();
        menu_outputs = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menu_inputs = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        menu_accounts = new javax.swing.JMenu();
        accounts_new = new javax.swing.JMenuItem();
        accounts_consult = new javax.swing.JMenuItem();
        m_reports = new javax.swing.JMenu();
        m_reports_freights = new javax.swing.JMenuItem();
        m_reports_outputs = new javax.swing.JMenuItem();
        m_reports_inputs = new javax.swing.JMenuItem();
        m_reports_payments = new javax.swing.JMenuItem();
        m_reports_others = new javax.swing.JMenuItem();
        m_reports_cashbook = new javax.swing.JMenuItem();
        m_admin = new javax.swing.JMenu();
        admin_users = new javax.swing.JMenuItem();
        admin_drivers = new javax.swing.JMenuItem();
        admin_trucks = new javax.swing.JMenuItem();
        admin_business = new javax.swing.JMenuItem();
        m_options = new javax.swing.JMenu();
        m_update_user = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        m_directory = new javax.swing.JMenuItem();
        m_directory1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        m_visible1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        m_visible = new javax.swing.JMenuItem();
        m_no_visible = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        m_visible2 = new javax.swing.JMenuItem();
        m_visible3 = new javax.swing.JMenuItem();
        m_options1 = new javax.swing.JMenu();
        m_calc = new javax.swing.JMenuItem();
        m_info = new javax.swing.JMenuItem();
        m_exit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        desktopPane.setToolTipText("");
        desktopPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        desktopPane.setName(""); // NOI18N
        desktopPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                desktopPaneMouseClicked(evt);
            }
        });

        l_date_system.setBackground(new java.awt.Color(255, 255, 255));
        l_date_system.setFont(new java.awt.Font("Segoe Print", 0, 26)); // NOI18N
        l_date_system.setForeground(new java.awt.Color(255, 255, 255));
        l_date_system.setText("date_system");
        l_date_system.setBounds(10, 10, 340, 40);
        desktopPane.add(l_date_system, javax.swing.JLayeredPane.DEFAULT_LAYER);

        l_user_session.setBackground(new java.awt.Color(255, 255, 255));
        l_user_session.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        l_user_session.setForeground(new java.awt.Color(255, 255, 255));
        l_user_session.setText("user_session");
        l_user_session.setBounds(510, 20, 390, 30);
        desktopPane.add(l_user_session, javax.swing.JLayeredPane.DEFAULT_LAYER);

        l_id_business.setBackground(new java.awt.Color(255, 255, 255));
        l_id_business.setFont(new java.awt.Font("Segoe Print", 0, 16)); // NOI18N
        l_id_business.setForeground(new java.awt.Color(255, 255, 255));
        l_id_business.setText("l_id_business");
        l_id_business.setBounds(460, 20, 70, 30);
        desktopPane.add(l_id_business, javax.swing.JLayeredPane.DEFAULT_LAYER);

        label.setBackground(new java.awt.Color(255, 255, 255));
        label.setFont(new java.awt.Font("Segoe Print", 0, 16)); // NOI18N
        label.setForeground(new java.awt.Color(255, 255, 255));
        label.setText("Id Cliente: ");
        label.setBounds(370, 20, 89, 30);
        desktopPane.add(label, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tp_accountants.setToolTipText("Tabela de Pagamentos");
        tp_accountants.setFont(new java.awt.Font("Segoe Print", 2, 14)); // NOI18N

        t_payments_day.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        t_payments_day.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        t_payments_day.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_payments_dayMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(t_payments_day);

        javax.swing.GroupLayout p_to_dayLayout = new javax.swing.GroupLayout(p_to_day);
        p_to_day.setLayout(p_to_dayLayout);
        p_to_dayLayout.setHorizontalGroup(
            p_to_dayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
        );
        p_to_dayLayout.setVerticalGroup(
            p_to_dayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_to_dayLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tp_accountants.addTab("Pagamentos para Hoje:", p_to_day);

        t_payments_to_day.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        t_payments_to_day.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        t_payments_to_day.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_payments_to_dayMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(t_payments_to_day);

        javax.swing.GroupLayout p_payments_expiryLayout = new javax.swing.GroupLayout(p_payments_expiry);
        p_payments_expiry.setLayout(p_payments_expiryLayout);
        p_payments_expiryLayout.setHorizontalGroup(
            p_payments_expiryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
        );
        p_payments_expiryLayout.setVerticalGroup(
            p_payments_expiryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );

        tp_accountants.addTab("Pagamentos para amanhã:", p_payments_expiry);

        t_payments_expiry.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        t_payments_expiry.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        t_payments_expiry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_payments_expiryMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(t_payments_expiry);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tp_accountants.addTab("Pagamentos Vencidos:", jPanel1);

        tp_accountants.setBounds(10, 60, 760, 220);
        desktopPane.add(tp_accountants, javax.swing.JLayeredPane.DEFAULT_LAYER);
        tp_accountants.getAccessibleContext().setAccessibleName("Pagamentos");

        p_status_numEcaps_lock.setBackground(new java.awt.Color(0, 0, 0));
        p_status_numEcaps_lock.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        l_caps_lock.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        l_caps_lock.setForeground(new java.awt.Color(255, 255, 255));
        l_caps_lock.setText("Caps Lock: Ativado");

        l_num_lock.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        l_num_lock.setForeground(new java.awt.Color(255, 255, 255));
        l_num_lock.setText("Num Lock: Desativado");

        b_num_lock.setBackground(new java.awt.Color(102, 102, 102));
        b_num_lock.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        b_num_lock.setText("Ativar");
        b_num_lock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_num_lockActionPerformed(evt);
            }
        });

        b_caps_lock.setBackground(new java.awt.Color(102, 102, 102));
        b_caps_lock.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        b_caps_lock.setText("Desativar");
        b_caps_lock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_caps_lockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p_status_numEcaps_lockLayout = new javax.swing.GroupLayout(p_status_numEcaps_lock);
        p_status_numEcaps_lock.setLayout(p_status_numEcaps_lockLayout);
        p_status_numEcaps_lockLayout.setHorizontalGroup(
            p_status_numEcaps_lockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_status_numEcaps_lockLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(l_num_lock, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(b_num_lock, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(l_caps_lock, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(b_caps_lock, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        p_status_numEcaps_lockLayout.setVerticalGroup(
            p_status_numEcaps_lockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_status_numEcaps_lockLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_status_numEcaps_lockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l_caps_lock, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_caps_lock, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_num_lock, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_num_lock, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        p_status_numEcaps_lock.setBounds(10, 290, 550, 50);
        desktopPane.add(p_status_numEcaps_lock, javax.swing.JLayeredPane.DEFAULT_LAYER);

        p_button_apdate_lists.setBackground(new java.awt.Color(0, 0, 0));
        p_button_apdate_lists.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        b_update_list.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        b_update_list.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Refresh.png"))); // NOI18N
        b_update_list.setText("Atualizar Listas");
        b_update_list.setToolTipText("Clique para atualizar as listas!");
        b_update_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_update_listActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p_button_apdate_listsLayout = new javax.swing.GroupLayout(p_button_apdate_lists);
        p_button_apdate_lists.setLayout(p_button_apdate_listsLayout);
        p_button_apdate_listsLayout.setHorizontalGroup(
            p_button_apdate_listsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_button_apdate_listsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(b_update_list, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addContainerGap())
        );
        p_button_apdate_listsLayout.setVerticalGroup(
            p_button_apdate_listsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_button_apdate_listsLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(b_update_list, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        p_button_apdate_lists.setBounds(560, 290, 210, 50);
        desktopPane.add(p_button_apdate_lists, javax.swing.JLayeredPane.DEFAULT_LAYER);

        menuBar.setBackground(new java.awt.Color(255, 255, 255));
        menuBar.setToolTipText("Barra de Ferramentas (Menus)");
        menuBar.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        menuBar.setName(""); // NOI18N

        Menu_imputs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Notes.png"))); // NOI18N
        Menu_imputs.setMnemonic('e');
        Menu_imputs.setText("Movimentações");
        Menu_imputs.setToolTipText("Menu | Movimentações");
        Menu_imputs.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N

        Menu_freight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Globe.png"))); // NOI18N
        Menu_freight.setMnemonic('h');
        Menu_freight.setText("Fretes");
        Menu_freight.setToolTipText("Fretes");
        Menu_freight.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N

        freight_new.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        freight_new.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/New document.png"))); // NOI18N
        freight_new.setMnemonic('c');
        freight_new.setText("Novo");
        freight_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                freight_newActionPerformed(evt);
            }
        });
        Menu_freight.add(freight_new);

        freight_cunsult.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        freight_cunsult.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Search.png"))); // NOI18N
        freight_cunsult.setMnemonic('a');
        freight_cunsult.setText("Consultar");
        freight_cunsult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                freight_cunsultActionPerformed(evt);
            }
        });
        Menu_freight.add(freight_cunsult);

        Menu_imputs.add(Menu_freight);

        menu_outputs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Fall2.png"))); // NOI18N
        menu_outputs.setText("Saidas");
        menu_outputs.setToolTipText("Saidas");
        menu_outputs.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/New document.png"))); // NOI18N
        jMenuItem1.setText("Nova");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menu_outputs.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Search.png"))); // NOI18N
        jMenuItem2.setText("Consultar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menu_outputs.add(jMenuItem2);

        Menu_imputs.add(menu_outputs);

        menu_inputs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Down.png"))); // NOI18N
        menu_inputs.setText("Entradas");
        menu_inputs.setToolTipText("Entradas");
        menu_inputs.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N

        jMenuItem3.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/New document.png"))); // NOI18N
        jMenuItem3.setText("Nova");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menu_inputs.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Search.png"))); // NOI18N
        jMenuItem4.setText("Consultar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menu_inputs.add(jMenuItem4);

        Menu_imputs.add(menu_inputs);

        menu_accounts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dollar.png"))); // NOI18N
        menu_accounts.setText("Contas à Pagar");
        menu_accounts.setToolTipText("Contas a Pagar");
        menu_accounts.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N

        accounts_new.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        accounts_new.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/New document.png"))); // NOI18N
        accounts_new.setText("Nova");
        accounts_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accounts_newActionPerformed(evt);
            }
        });
        menu_accounts.add(accounts_new);

        accounts_consult.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        accounts_consult.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Search.png"))); // NOI18N
        accounts_consult.setText("Consultar");
        accounts_consult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accounts_consultActionPerformed(evt);
            }
        });
        menu_accounts.add(accounts_consult);

        Menu_imputs.add(menu_accounts);

        menuBar.add(Menu_imputs);

        m_reports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Text.png"))); // NOI18N
        m_reports.setText("Relatórios");
        m_reports.setToolTipText("Menu | Relatórios");
        m_reports.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N

        m_reports_freights.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        m_reports_freights.setText("Fretes por Veículo");
        m_reports_freights.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_reports_freightsActionPerformed(evt);
            }
        });
        m_reports.add(m_reports_freights);

        m_reports_outputs.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        m_reports_outputs.setText("Saidas");
        m_reports_outputs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_reports_outputsActionPerformed(evt);
            }
        });
        m_reports.add(m_reports_outputs);

        m_reports_inputs.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        m_reports_inputs.setText("Entradas");
        m_reports_inputs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_reports_inputsActionPerformed(evt);
            }
        });
        m_reports.add(m_reports_inputs);

        m_reports_payments.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        m_reports_payments.setText("Contas a Pagar");
        m_reports_payments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_reports_paymentsActionPerformed(evt);
            }
        });
        m_reports.add(m_reports_payments);

        m_reports_others.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        m_reports_others.setText("Outros");
        m_reports_others.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_reports_othersActionPerformed(evt);
            }
        });
        m_reports.add(m_reports_others);

        m_reports_cashbook.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        m_reports_cashbook.setText("Caixa");
        m_reports_cashbook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_reports_cashbookActionPerformed(evt);
            }
        });
        m_reports.add(m_reports_cashbook);

        menuBar.add(m_reports);

        m_admin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Boss.png"))); // NOI18N
        m_admin.setText("Administrador");
        m_admin.setToolTipText("Menu | Administrador");
        m_admin.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N

        admin_users.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        admin_users.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/User group.png"))); // NOI18N
        admin_users.setText("Usuários");
        admin_users.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_usersActionPerformed(evt);
            }
        });
        m_admin.add(admin_users);

        admin_drivers.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        admin_drivers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/drivers.png"))); // NOI18N
        admin_drivers.setText("Motoristas");
        admin_drivers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_driversActionPerformed(evt);
            }
        });
        m_admin.add(admin_drivers);

        admin_trucks.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        admin_trucks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/truck 16x16.png"))); // NOI18N
        admin_trucks.setText("Veiculos");
        admin_trucks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_trucksActionPerformed(evt);
            }
        });
        m_admin.add(admin_trucks);

        admin_business.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        admin_business.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Company.png"))); // NOI18N
        admin_business.setText("Meus Dados");
        admin_business.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_businessActionPerformed(evt);
            }
        });
        m_admin.add(admin_business);

        menuBar.add(m_admin);

        m_options.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Modify.png"))); // NOI18N
        m_options.setText("Opções");
        m_options.setToolTipText("Menu | Opções");
        m_options.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N

        m_update_user.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        m_update_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Refresh.png"))); // NOI18N
        m_update_user.setText("Trocar de Usuário");
        m_update_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_update_userActionPerformed(evt);
            }
        });
        m_options.add(m_update_user);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Linux.png"))); // NOI18N
        jMenu4.setText("Windows");
        jMenu4.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N

        m_directory.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        m_directory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/3d bar chart.png"))); // NOI18N
        m_directory.setText("Status da seção do usuário");
        m_directory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_directoryActionPerformed(evt);
            }
        });
        jMenu4.add(m_directory);

        m_directory1.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        m_directory1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Print.png"))); // NOI18N
        m_directory1.setText("Dispositivos e Impressoras");
        m_directory1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_directory1ActionPerformed(evt);
            }
        });
        jMenu4.add(m_directory1);

        m_options.add(jMenu4);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/People.png"))); // NOI18N
        jMenu3.setText("Suporte");
        jMenu3.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N

        m_visible1.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        m_visible1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/E-mail.png"))); // NOI18N
        m_visible1.setText("Enviar E-Mail");
        m_visible1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_visible1ActionPerformed(evt);
            }
        });
        jMenu3.add(m_visible1);

        m_options.add(jMenu3);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Computer 16x16.png"))); // NOI18N
        jMenu1.setText("Desktop");
        jMenu1.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/List.png"))); // NOI18N
        jMenu2.setText("Paineis");
        jMenu2.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N

        m_visible.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        m_visible.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/View.png"))); // NOI18N
        m_visible.setText("Mostrar");
        m_visible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_visibleActionPerformed(evt);
            }
        });
        jMenu2.add(m_visible);

        m_no_visible.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        m_no_visible.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/No.png"))); // NOI18N
        m_no_visible.setText("Ocultar");
        m_no_visible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_no_visibleActionPerformed(evt);
            }
        });
        jMenu2.add(m_no_visible);

        jMenu1.add(jMenu2);

        m_options.add(jMenu1);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Database.png"))); // NOI18N
        jMenu5.setText("Conexão e Banco de Dados");
        jMenu5.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N

        m_visible2.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        m_visible2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Lock.png"))); // NOI18N
        m_visible2.setText("Limite de resultados por Página");
        m_visible2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_visible2ActionPerformed(evt);
            }
        });
        jMenu5.add(m_visible2);

        m_visible3.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        m_visible3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Refresh.png"))); // NOI18N
        m_visible3.setText("Reiniciar conexão");
        m_visible3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_visible3ActionPerformed(evt);
            }
        });
        jMenu5.add(m_visible3);

        m_options.add(jMenu5);

        menuBar.add(m_options);

        m_options1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Help symbol.png"))); // NOI18N
        m_options1.setText("Ajuda");
        m_options1.setToolTipText("Menu | Ajuda");
        m_options1.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N

        m_calc.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        m_calc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Calculator.png"))); // NOI18N
        m_calc.setText("Calculadora");
        m_calc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_calcActionPerformed(evt);
            }
        });
        m_options1.add(m_calc);

        m_info.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        m_info.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Info.png"))); // NOI18N
        m_info.setText("Sobre o Sistema");
        m_info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_infoActionPerformed(evt);
            }
        });
        m_options1.add(m_info);

        menuBar.add(m_options1);

        m_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Exit.png"))); // NOI18N
        m_exit.setText("Sair");
        m_exit.setToolTipText("Menu | Sair");
        m_exit.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        m_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                m_exitMouseClicked(evt);
            }
        });
        menuBar.add(m_exit);

        setJMenuBar(menuBar);
        menuBar.getAccessibleContext().setAccessibleName("WC Truck-System");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1094, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-1110)/2, (screenSize.height-691)/2, 1110, 691);
    }// </editor-fold>//GEN-END:initComponents

    /*public void LoadDataProgress(int x){
        if(x == 1){
            jd.setVisible(true);            
        }else if(x == 0){
            jd.hide();
        }else{
            JOptionPane.showMessageDialog(rootPane,"Ocorreu um erro fatal e o sistema precisa ser encerrado! \nContate o Administrador do Sistema",
                    "Cadoresistemas", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }*/
    
    private static String md5(String pwd){
            String password = "";
            MessageDigest md = null;
            try {
                    md = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
            }
            BigInteger hash = new BigInteger(1, md.digest(pwd.getBytes()));
            password = hash.toString(16);
            return password;
	}

    public void startDashboard(){
        desktopPane.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        getHorThread();
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setSize(1110, 636);
        m_visible.setEnabled(false);
        if (user.getAdmin() == true) {
            m_admin.setVisible(true);
        } else {
            m_admin.setVisible(false);
        }
        if (user.getReports() == true) {
            m_reports.setVisible(true);
        } else {
            m_reports.setVisible(false);
        }
        l_user_session.setText("Usuário: " + user.getLogin());
        l_id_business.setText("");
        l_id_business.setText(String.valueOf(user.getId_Business()));
        this.IdBusiness = l_id_business.getText();
        setPayments();
        String title = "CadoreSistemas | "+ new BusinessDAO().getCorporate_NameBusinessById(Long.valueOf(this.IdBusiness));
        this.setTitle( title + " ["+TrucksSystemDefault.actual_version+"]");
        desktopPane.setToolTipText(title);
        desktopPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    }

    private void StatusCapsNum_Lock(){
        if(Toolkit.getDefaultToolkit().getLockingKeyState(
            java.awt.event.KeyEvent.VK_CAPS_LOCK)){
            l_caps_lock.setText("Caps Lock: Ativado");
            l_caps_lock.setToolTipText(l_caps_lock.getText());
            b_caps_lock.setText("Desativar");
            b_caps_lock.setToolTipText("Clique para desativar o Caps Lock!");
            status_caps_lock = true;
        }else{
            l_caps_lock.setText("Caps Lock: Desativado");
            l_caps_lock.setToolTipText(l_caps_lock.getText());
            b_caps_lock.setText("Ativar");
            b_caps_lock.setToolTipText("Clique para ativar o Caps Lock!");
            status_caps_lock = false;
        }
        if(Toolkit.getDefaultToolkit().getLockingKeyState(
            java.awt.event.KeyEvent.VK_NUM_LOCK)){
            l_num_lock.setText("Num Lock: Ativado");
            l_num_lock.setToolTipText(l_num_lock.getText());
            b_num_lock.setText("Desativar");
            b_num_lock.setToolTipText("Clique para ativar o Num Lock!");
            status_num_lock = true;
        }else{
            l_num_lock.setText("Num Lock: Desativado");
            l_num_lock.setToolTipText(l_num_lock.getText());
            b_num_lock.setText("Ativar");
            b_num_lock.setToolTipText("Clique para desativar o Num Lock!");
            status_num_lock = false;
        }
    }

    public void getHorThread() {
            new Thread() {//instancia nova thread já implementando o método run()
                @Override
                public void run() {//sobrescreve o método run()
                    while (0 == 0) {//while para fazer o loop infinito
                        l_date_system.setText(ut.getDateddMMyyyy() + " " + ut.getHorHHmmss());
                        l_date_system.setToolTipText(ut.getDateddMMyyyy() + " " + ut.getHorHHmmss());
                        StatusCapsNum_Lock();
                        try {
                            sleep(1000);//faz a thread entrar em estado de espera por 1000 milissegundos ou 1 segundo
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(rootPane, e.getMessage() + "\nErro Não Foi Possivel Consultar Hora/Data Atual do Sistema! Contate o Administrador do Sistema");
                        }
                    }
                }
            }.start();//inicia a thread.
    }

        public int countRowsDay = 0;
        public int countRowsToDay = 0;
        public int countRowsExpiry = 0;
        public String count = null;

    public void setPayments(){      
        desktopPane.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        try {
            try {
                tableModelDay.clear();
                listPaymentDay.clear();
                List<PaymentModel> input = new PaymentDAO().getPaymentDay(ut.dateFormatInsertSql(ut.dateFormatInsert(ut.getDateddMMyyyy())), Long.valueOf(this.IdBusiness));
                for (PaymentModel u : input) {
                    try {
                        String date_expiry = ut.dateFormatReturn(u.getDate_expiry());
                        String id_truck = trucksDAO.getBoardTruckById(u.getId_truck());
                        String valor = decimal.format(u.getValor()).replace(".", ",");
                        listPaymentDay.add(new DashboardPaymentDayTableModel(u.getId(), id_truck, u.getPayment(), date_expiry, valor, u.getIdentify()));
                    } catch (ParseException ex) {
                        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                tableModelDay.setData(listPaymentDay);
                t_payments_day.setModel(tableModelDay);
            } catch (ParseException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                tableModelToDay.clear();
                    listPaymentToDay.clear();
                    Calendar c = GregorianCalendar.getInstance();
                    c.add(Calendar.DAY_OF_MONTH, 1);
                    List<PaymentModel> input = new PaymentDAO().getPaymentToDay(ut.dateFormatInsertSql(ut.dateFormatInsert(sdf.format(c.getTime()))), Long.valueOf(this.IdBusiness));
                    for (PaymentModel u : input) {
                        try {
                            String date_expiry = ut.dateFormatReturn(u.getDate_expiry());
                            String id_truck = trucksDAO.getBoardTruckById(u.getId_truck());
                            String valor = decimal.format(u.getValor()).replace(".", ",");
                            listPaymentToDay.add(new DashboardPaymentToDayTableModel(u.getId(), id_truck, u.getPayment(), date_expiry, valor, u.getIdentify()));
                        } catch (ParseException ex) {
                            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    tableModelToDay.setData(listPaymentToDay);
                    t_payments_to_day.setModel(tableModelToDay);
            } catch (ParseException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
                    tableModelPaymentsExpiry.clear();
                    listPaymentsExpiry.clear();
                    Calendar c = GregorianCalendar.getInstance();
                    c.add(Calendar.DAY_OF_MONTH, -1);
                    List<PaymentModel> input = new PaymentDAO().getPaymentsExpiry(ut.dateFormatInsertSql(ut.dateFormatInsert(sdf.format(c.getTime()))), Long.valueOf(this.IdBusiness));
                    for (PaymentModel u : input) {
                        try {
                            String date_expiry = ut.dateFormatReturn(u.getDate_expiry());
                            String id_truck = trucksDAO.getBoardTruckById(u.getId_truck());
                            String valor = decimal.format(u.getValor()).replace(".", ",");
                            listPaymentsExpiry.add(new DashboardPaymentsExpiryTableModel(u.getId(), id_truck, u.getPayment(), date_expiry, valor, u.getIdentify()));
                        } catch (ParseException ex) {
                            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    tableModelPaymentsExpiry.setData(listPaymentsExpiry);
                    t_payments_expiry.setModel(tableModelPaymentsExpiry);
            } catch (ParseException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
            modulateTablePayments();
            this.toFront();

            this.countRowsDay = t_payments_day.getRowCount();
            this.countRowsToDay = t_payments_to_day.getRowCount();
            this.countRowsExpiry = t_payments_expiry.getRowCount();
            this.count = "Você possui: \n"+countRowsDay+" pagamento(s) para hoje!\n"
                    + countRowsToDay+" pagamento(s) para amanhã!\n"
                    + "e "+countRowsExpiry+" pagamento(s) vencidos!";
        desktopPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    }

    private void modulateTablePayments() {
            t_payments_day.getColumnModel().getColumn(0).setPreferredWidth(2);
            t_payments_day.getColumnModel().getColumn(1).setPreferredWidth(35);
            t_payments_day.getColumnModel().getColumn(2).setPreferredWidth(200);
            t_payments_day.getColumnModel().getColumn(3).setPreferredWidth(60);
            t_payments_day.getColumnModel().getColumn(4).setPreferredWidth(50);
            t_payments_day.getColumnModel().getColumn(5).setPreferredWidth(165);
            t_payments_day.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            t_payments_to_day.getColumnModel().getColumn(0).setPreferredWidth(2);
            t_payments_to_day.getColumnModel().getColumn(1).setPreferredWidth(35);
            t_payments_to_day.getColumnModel().getColumn(2).setPreferredWidth(200);
            t_payments_to_day.getColumnModel().getColumn(3).setPreferredWidth(60);
            t_payments_to_day.getColumnModel().getColumn(4).setPreferredWidth(50);
            t_payments_to_day.getColumnModel().getColumn(5).setPreferredWidth(165);
            t_payments_to_day.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            t_payments_expiry.getColumnModel().getColumn(0).setPreferredWidth(2);
            t_payments_expiry.getColumnModel().getColumn(1).setPreferredWidth(35);
            t_payments_expiry.getColumnModel().getColumn(2).setPreferredWidth(200);
            t_payments_expiry.getColumnModel().getColumn(3).setPreferredWidth(60);
            t_payments_expiry.getColumnModel().getColumn(4).setPreferredWidth(50);
            t_payments_expiry.getColumnModel().getColumn(5).setPreferredWidth(165);
            t_payments_expiry.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void admin_usersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_usersActionPerformed
        AutenticationUserAdmin AutenticationL = new AutenticationUserAdmin();
        desktopPane.add(AutenticationL);
        Centraliza.setCentro(AutenticationL, desktopPane, WIDTH, HEIGHT);
        AutenticationL.deskPane = desktopPane;
        AutenticationL.IdBusiness = IdBusiness;
        //AutenticationL.userF = new UserForm();
        AutenticationL.setVisible(true);
    }//GEN-LAST:event_admin_usersActionPerformed

    private void freight_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_freight_newActionPerformed
        FreightsForm FreightsF = new FreightsForm();
        FreightsF.deskPane = desktopPane;
        desktopPane.add(FreightsF);
        Centraliza.setCentro(FreightsF, desktopPane, WIDTH, HEIGHT);
        FreightsF.IdBusiness = this.IdBusiness;
        FreightsF.setVisible(true);
        FreightsF.loadTrucks();
        FreightsF.loadDrivers_();
    }//GEN-LAST:event_freight_newActionPerformed

    private void admin_driversActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_driversActionPerformed
        DriversForm DriverF = new DriversForm();
        desktopPane.add(DriverF);
        Centraliza.setCentro(DriverF, desktopPane, WIDTH, HEIGHT);
        DriverF.deskPane = desktopPane;
        DriverF.IdBusiness = this.IdBusiness;
        DriverF.date_db = this.date_db;
        DriverF.setVisible(true);
    }//GEN-LAST:event_admin_driversActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        InputsForm InputsF = new InputsForm();
        desktopPane.add(InputsF);
        Centraliza.setCentro(InputsF, desktopPane, WIDTH, HEIGHT);
        InputsF.IdBusiness = this.IdBusiness;
        InputsF.setVisible(true);
        InputsF.loadTrucks();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        OutputsForm OutputsF = new OutputsForm();
        desktopPane.add(OutputsF);
        Centraliza.setCentro(OutputsF, desktopPane, WIDTH, HEIGHT);
        OutputsF.IdBusiness = this.IdBusiness;
        OutputsF.setVisible(true);
        OutputsF.loadTrucks();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void accounts_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accounts_newActionPerformed
        PaymentForm PaymentF = new PaymentForm();
        desktopPane.add(PaymentF);
        Centraliza.setCentro(PaymentF, desktopPane, WIDTH, HEIGHT);
        PaymentF.IdBusiness = IdBusiness;
        PaymentF.dash = this;
        PaymentF.setVisible(true);
        PaymentF.loadTrucks();
    }//GEN-LAST:event_accounts_newActionPerformed

    private void accounts_consultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accounts_consultActionPerformed
        PaymentSearch PaymentS = new PaymentSearch();
        desktopPane.add(PaymentS);
        Centraliza.setCentro(PaymentS, desktopPane, WIDTH, HEIGHT);
        PaymentS.deskPane = desktopPane;
        PaymentS.IdBusiness = IdBusiness;
        PaymentS.dash = this;
        PaymentS.setVisible(true);
    }//GEN-LAST:event_accounts_consultActionPerformed

    private void admin_trucksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_trucksActionPerformed
        TrucksForm TrucksF = new TrucksForm();
        desktopPane.add(TrucksF);
        Centraliza.setCentro(TrucksF, desktopPane, WIDTH, HEIGHT);
        TrucksF.deskPane = desktopPane;
        TrucksF.IdBusiness = this.IdBusiness;
        TrucksF.setVisible(true);
        TrucksF.loadDrivers();
    }//GEN-LAST:event_admin_trucksActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        InputsSearch InputsS = new InputsSearch();
        desktopPane.add(InputsS);
        Centraliza.setCentro(InputsS, desktopPane, WIDTH, HEIGHT);
        InputsS.deskPane = desktopPane;
        InputsS.IdBusiness = this.IdBusiness;
        InputsS.setVisible(true);
        InputsS.loadTrucks();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        OutputsSearch OutputsS = new OutputsSearch();
        desktopPane.add(OutputsS);
        Centraliza.setCentro(OutputsS, desktopPane, WIDTH, HEIGHT);
        OutputsS.deskPane = desktopPane;
        OutputsS.IdBusiness = this.IdBusiness;
        OutputsS.setVisible(true);
        OutputsS.loadTrucks();
        OutputsS.b_delete.setVisible(false);
        OutputsS.b_new.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void freight_cunsultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_freight_cunsultActionPerformed
        FreightsSearch FreightsS = new FreightsSearch();
        desktopPane.add(FreightsS);
        Centraliza.setCentro(FreightsS, desktopPane, WIDTH, HEIGHT);
        FreightsS.IdBusiness = this.IdBusiness;
        FreightsS.deskPane = desktopPane;
        FreightsS.setVisible(true);
        FreightsS.loadTrucks();
    }//GEN-LAST:event_freight_cunsultActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
         System.exit(0);
         Object[] options = {" Sim ", " Não "};
         int i = JOptionPane.showOptionDialog(null,"Você tem certeza que deseja sair do sistema?", "Truck System",
         JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
         if (i == JOptionPane.YES_OPTION) {
         System.exit(0);
         }
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
     if(countRowsDay == 0 && countRowsToDay == 0 && countRowsExpiry == 0){}else{
            JOptionPane.showMessageDialog(rootPane, count, "Desktop | Cadore Sistemas", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_formWindowOpened

    private void m_exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_m_exitMouseClicked
        Object[] options = {" Sim ", " Não "};
        int i = JOptionPane.showOptionDialog(null, "Você tem certeza que deseja sair do sistema?", "Truck System",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if (i == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_m_exitMouseClicked

    private void admin_businessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_businessActionPerformed
        BusinessForm BusinessF = new BusinessForm();
        desktopPane.add(BusinessF);
        Centraliza.setCentro(BusinessF, desktopPane, WIDTH, HEIGHT);
        BusinessF.deskPane = desktopPane;
        BusinessF.setBusiness(this.IdBusiness);
        BusinessF.setVisible(true);
    }//GEN-LAST:event_admin_businessActionPerformed

    private void m_directoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_directoryActionPerformed
        Paths configClass = new Paths();
        String login_user_md5 = md5(user.getLogin());
        boolean status_session_user = configClass.getStatusUser(login_user_md5);

        if(status_session_user == true){
            Object[] options = {" Esquecer PC ", " Cancelar "};
        int i = JOptionPane.showOptionDialog(null, "Seção salva, deseja esquecer este PC?", "CadoreSistemas",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            if (i == JOptionPane.YES_OPTION) {
                configClass.deleteStatusUser(login_user_md5);
               JOptionPane.showMessageDialog(rootPane, "PC excluido com sucesso.", "CadoreSistemas", JOptionPane.INFORMATION_MESSAGE);
            }
        }else if(status_session_user == false){
           Object[] options = {" Lembrar PC ", " Cancelar "};
        int i = JOptionPane.showOptionDialog(null, "Seção NÃO salva, deseja lembrar este PC?", "CadoreSistemas",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            if (i == JOptionPane.YES_OPTION) {
               configClass.setStatusUser(login_user_md5);
               JOptionPane.showMessageDialog(rootPane, "PC salvo com sucesso.", "CadoreSistemas", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_m_directoryActionPerformed

    private void m_update_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_update_userActionPerformed
        Object[] options = {" Sim ", " Não "};
            int i = JOptionPane.showOptionDialog(null, "Você tem certeza que deseja trocar de usuário?", "Truck System",
                    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                if (i == JOptionPane.YES_OPTION) {
                try {
                    String d = System.getProperty("user.dir");
                    Process pro = null;
                    pro = Runtime.getRuntime().exec("cmd.exe /c "+ d + "/start_truckssystem.exe");
                    System.exit(0);
    } catch (IOException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_m_update_userActionPerformed

    private void b_update_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_update_listActionPerformed
        this.setPayments();
    }//GEN-LAST:event_b_update_listActionPerformed

    private void m_reports_freightsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_reports_freightsActionPerformed
        FreightsReportsForm FreightsRF = new FreightsReportsForm();
        desktopPane.add(FreightsRF);
        Centraliza.setCentro(FreightsRF, desktopPane, WIDTH, HEIGHT);
        FreightsRF.deskPane = desktopPane;
        FreightsRF.IdBusiness = this.IdBusiness;
        FreightsRF.dash = this;
        FreightsRF.setVisible(true);
        FreightsRF.loadTrucks();
    }//GEN-LAST:event_m_reports_freightsActionPerformed

    private void m_reports_outputsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_reports_outputsActionPerformed
        OutputsReportsForm OutputsRF = new OutputsReportsForm();
        desktopPane.add(OutputsRF);
        Centraliza.setCentro(OutputsRF, desktopPane, WIDTH, HEIGHT);
        OutputsRF.deskPane = desktopPane;
        OutputsRF.IdBusiness = this.IdBusiness;
        OutputsRF.setVisible(true);
        OutputsRF.loadTrucks();
    }//GEN-LAST:event_m_reports_outputsActionPerformed

    private void m_reports_inputsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_reports_inputsActionPerformed
        InputsReportsForm InputsFR = new InputsReportsForm();
        desktopPane.add(InputsFR);
        Centraliza.setCentro(InputsFR, desktopPane, WIDTH, HEIGHT);
        InputsFR.deskPane = desktopPane;
        InputsFR.IdBusiness = this.IdBusiness;
        InputsFR.setVisible(true);
        InputsFR.loadTrucks();
    }//GEN-LAST:event_m_reports_inputsActionPerformed

    private void m_reports_paymentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_reports_paymentsActionPerformed
        PaymentsReportsForm PaymentFR = new PaymentsReportsForm();
        desktopPane.add(PaymentFR);
        Centraliza.setCentro(PaymentFR, desktopPane, WIDTH, HEIGHT);
        PaymentFR.deskPane = desktopPane;
        PaymentFR.IdBusiness = this.IdBusiness;
        PaymentFR.setVisible(true);
        PaymentFR.loadTrucks();
    }//GEN-LAST:event_m_reports_paymentsActionPerformed

    private void m_reports_othersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_reports_othersActionPerformed
        OthersReportsForm PaymentsFR = new OthersReportsForm();
        desktopPane.add(PaymentsFR);
        Centraliza.setCentro(PaymentsFR, desktopPane, WIDTH, HEIGHT);
        PaymentsFR.deskPane = desktopPane;
        PaymentsFR.IdBusiness = this.IdBusiness;
        PaymentsFR.setVisible(true);
        PaymentsFR.setOthers();
    }//GEN-LAST:event_m_reports_othersActionPerformed

    private void m_reports_cashbookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_reports_cashbookActionPerformed
        CashBookReportsForm CashBookRF = new CashBookReportsForm();
        desktopPane.add(CashBookRF);
        Centraliza.setCentro(CashBookRF, desktopPane, WIDTH, HEIGHT);
        CashBookRF.deskPane = desktopPane;
        CashBookRF.IdBusiness = this.IdBusiness;
        CashBookRF.setVisible(true);
        CashBookRF.search();
    }//GEN-LAST:event_m_reports_cashbookActionPerformed

    private void m_no_visibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_no_visibleActionPerformed
        tp_accountants.setVisible(false);
        p_button_apdate_lists.setVisible(false);
        m_visible.setEnabled(true);
        m_no_visible.setEnabled(false);
        p_status_numEcaps_lock.setVisible(false);
    }//GEN-LAST:event_m_no_visibleActionPerformed

    private void m_visibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_visibleActionPerformed
        tp_accountants.setVisible(true);
        p_button_apdate_lists.setVisible(true);
        m_visible.setEnabled(false);
        m_no_visible.setEnabled(true);
        p_status_numEcaps_lock.setVisible(true);
        StatusCapsNum_Lock();
        java.awt.event.ActionEvent evtt = null;
        b_update_listActionPerformed(evtt);
    }//GEN-LAST:event_m_visibleActionPerformed

    private void m_visible1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_visible1ActionPerformed
        SendMailForm smf = new SendMailForm();
        desktopPane.add(smf);
        Centraliza.setCentro(smf, desktopPane, WIDTH, HEIGHT);
        smf.IdBusiness = this.IdBusiness;
        smf.UserSession = user.getLogin();
        smf.dash = this;
        smf.setVisible(true);
    }//GEN-LAST:event_m_visible1ActionPerformed

    private void b_num_lockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_num_lockActionPerformed
        if(this.status_num_lock == false){
            tk.setLockingKeyState(KeyEvent.VK_NUM_LOCK, true);
            StatusCapsNum_Lock();
        }else if(this.status_num_lock == true){
            tk.setLockingKeyState(KeyEvent.VK_NUM_LOCK, false);
            StatusCapsNum_Lock();
        }
    }//GEN-LAST:event_b_num_lockActionPerformed

    private void b_caps_lockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_caps_lockActionPerformed
        if(this.status_caps_lock == false){
            tk.setLockingKeyState(KeyEvent.VK_CAPS_LOCK, true);
            StatusCapsNum_Lock();
        }else if(this.status_caps_lock == true){
            tk.setLockingKeyState(KeyEvent.VK_CAPS_LOCK, false);
            StatusCapsNum_Lock();
        }
    }//GEN-LAST:event_b_caps_lockActionPerformed

    private void desktopPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_desktopPaneMouseClicked

    }//GEN-LAST:event_desktopPaneMouseClicked

    private void m_directory1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_directory1ActionPerformed
        try {
            Process pro = null;
            pro = Runtime.getRuntime().exec("cmd.exe /c control printers");
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_m_directory1ActionPerformed

    private void m_calcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_calcActionPerformed
        try {
            Process pro = null;
            pro = Runtime.getRuntime().exec("cmd.exe /c calc.exe");
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_m_calcActionPerformed

    private void t_payments_dayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_payments_dayMouseClicked
        if(evt.getClickCount() == 2){
            Object[] options = {" Abrir ", " Atualizar como paga "};
        int i = JOptionPane.showOptionDialog(null, "Escolha uma Opção para este pagameto", "CadoreSistemas | Truck System",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            if (i == JOptionPane.YES_OPTION) {
                Object obj = t_payments_day.getValueAt(t_payments_day.getSelectedRow(),0);
                PaymentModel payment_ = paymentDAO.getPaymentByIdObj(Integer.valueOf(obj.toString()), Long.valueOf(this.IdBusiness));
                PaymentForm PaymentF = new PaymentForm();
                desktopPane.add(PaymentF);
                PaymentF.payment = payment_;
                PaymentF.IdBusiness = IdBusiness;
                PaymentF.dash = this;
                PaymentF.setPayment();
                Centraliza.setCentro(PaymentF, desktopPane, WIDTH, HEIGHT);
                PaymentF.setVisible(true);
            }else if(i == JOptionPane.NO_OPTION){
                PaymentModel payment = new PaymentModel();
                Object obj = t_payments_day.getValueAt(t_payments_day.getSelectedRow(),0);
                payment.setId(Long.valueOf(obj.toString()));
                payment.setId_business(Long.valueOf(this.IdBusiness));
                paymentDAO.setPaidPayment(payment);
                this.setPayments();
                JOptionPane.showMessageDialog(null, "Nova conta á pagar Atualizada com sucesso", "Cadore Sistemas | Pagamentos", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_t_payments_dayMouseClicked

    private void m_visible2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_visible2ActionPerformed
        ConfigLimitResults clr = new ConfigLimitResults();
        desktopPane.add(clr);
        Centraliza.setCentro(clr, desktopPane, WIDTH, HEIGHT);
        clr.IdBusiness = this.IdBusiness;
        clr.setVisible(true);
    }//GEN-LAST:event_m_visible2ActionPerformed

    private void t_payments_to_dayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_payments_to_dayMouseClicked
        if(evt.getClickCount() == 2){
            Object[] options = {" Abrir ", " Atualizar como paga "};
        int i = JOptionPane.showOptionDialog(null, "Escolha uma Opção para este pagameto", "CadoreSistemas | Truck System",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            if (i == JOptionPane.YES_OPTION) {
                Object obj = t_payments_to_day.getValueAt(t_payments_to_day.getSelectedRow(),0);
                PaymentModel payment_ = paymentDAO.getPaymentByIdObj(Integer.valueOf(obj.toString()), Long.valueOf(this.IdBusiness));
                PaymentForm PaymentF = new PaymentForm();
                desktopPane.add(PaymentF);
                PaymentF.payment = payment_;
                PaymentF.IdBusiness = IdBusiness;
                PaymentF.dash = this;
                PaymentF.setPayment();
                Centraliza.setCentro(PaymentF, desktopPane, WIDTH, HEIGHT);
                PaymentF.setVisible(true);
            }else if(i == JOptionPane.NO_OPTION){
                PaymentModel payment = new PaymentModel();
                Object obj = t_payments_to_day.getValueAt(t_payments_to_day.getSelectedRow(),0);
                payment.setId(Long.valueOf(obj.toString()));
                payment.setId_business(Long.valueOf(this.IdBusiness));
                paymentDAO.setPaidPayment(payment);
                this.setPayments();
                JOptionPane.showMessageDialog(null, "Nova conta á pagar Atualizada com sucesso", "Cadore Sistemas | Pagamentos", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_t_payments_to_dayMouseClicked

    private void t_payments_expiryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_payments_expiryMouseClicked
        if(evt.getClickCount() == 2){
            Object[] options = {" Abrir ", " Atualizar como paga "};
        int i = JOptionPane.showOptionDialog(null, "Escolha uma Opção para este pagameto", "CadoreSistemas | Truck System",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            if (i == JOptionPane.YES_OPTION) {
                Object obj = t_payments_expiry.getValueAt(t_payments_expiry.getSelectedRow(),0);
                PaymentModel payment_ = paymentDAO.getPaymentByIdObj(Integer.valueOf(obj.toString()), Long.valueOf(this.IdBusiness));
                PaymentForm PaymentF = new PaymentForm();
                desktopPane.add(PaymentF);
                PaymentF.payment = payment_;
                PaymentF.IdBusiness = IdBusiness;
                PaymentF.dash = this;
                PaymentF.setPayment();
                Centraliza.setCentro(PaymentF, desktopPane, WIDTH, HEIGHT);
                PaymentF.setVisible(true);
            }else if(i == JOptionPane.NO_OPTION){
                PaymentModel payment = new PaymentModel();
                Object obj = t_payments_expiry.getValueAt(t_payments_expiry.getSelectedRow(),0);
                payment.setId(Long.valueOf(obj.toString()));
                payment.setId_business(Long.valueOf(this.IdBusiness));
                paymentDAO.setPaidPayment(payment);
                this.setPayments();
                JOptionPane.showMessageDialog(null, "Nova conta á pagar Atualizada com sucesso", "Cadore Sistemas | Pagamentos", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_t_payments_expiryMouseClicked

    private void m_visible3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_visible3ActionPerformed
        Object[] options = {" Reiniciar ", " Cancelar "};
        int i = JOptionPane.showOptionDialog(null, "Deseja reiniciar a conexão com o servidor?", "CadoreSistemas | Truck System",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            if (i == JOptionPane.YES_OPTION) {
                new ConnectionFactory().resetConnection();
            }
    }//GEN-LAST:event_m_visible3ActionPerformed

    private void m_infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_infoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_m_infoActionPerformed

    private void jdWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jdWindowOpened
        
    }//GEN-LAST:event_jdWindowOpened

    private void jdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jdKeyPressed
        
    }//GEN-LAST:event_jdKeyPressed

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Menu_freight;
    private javax.swing.JMenu Menu_imputs;
    private javax.swing.JMenuItem accounts_consult;
    private javax.swing.JMenuItem accounts_new;
    private javax.swing.JMenuItem admin_business;
    private javax.swing.JMenuItem admin_drivers;
    private javax.swing.JMenuItem admin_trucks;
    private javax.swing.JMenuItem admin_users;
    private javax.swing.JButton b_caps_lock;
    private javax.swing.JButton b_num_lock;
    private javax.swing.JButton b_update_list;
    public javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem freight_cunsult;
    private javax.swing.JMenuItem freight_new;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel l_caps_lock;
    private javax.swing.JLabel l_date_system;
    public javax.swing.JLabel l_id_business;
    private javax.swing.JLabel l_num_lock;
    public javax.swing.JLabel l_user_session;
    private javax.swing.JLabel label;
    public javax.swing.JMenu m_admin;
    private javax.swing.JMenuItem m_calc;
    private javax.swing.JMenuItem m_directory;
    private javax.swing.JMenuItem m_directory1;
    private javax.swing.JMenu m_exit;
    private javax.swing.JMenuItem m_info;
    private javax.swing.JMenuItem m_no_visible;
    private javax.swing.JMenu m_options;
    private javax.swing.JMenu m_options1;
    public javax.swing.JMenu m_reports;
    private javax.swing.JMenuItem m_reports_cashbook;
    private javax.swing.JMenuItem m_reports_freights;
    private javax.swing.JMenuItem m_reports_inputs;
    private javax.swing.JMenuItem m_reports_others;
    private javax.swing.JMenuItem m_reports_outputs;
    private javax.swing.JMenuItem m_reports_payments;
    private javax.swing.JMenuItem m_update_user;
    public javax.swing.JMenuItem m_visible;
    private javax.swing.JMenuItem m_visible1;
    private javax.swing.JMenuItem m_visible2;
    private javax.swing.JMenuItem m_visible3;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menu_accounts;
    private javax.swing.JMenu menu_inputs;
    private javax.swing.JMenu menu_outputs;
    private javax.swing.JPanel p_button_apdate_lists;
    private javax.swing.JPanel p_payments_expiry;
    private javax.swing.JPanel p_status_numEcaps_lock;
    private javax.swing.JPanel p_to_day;
    private javax.swing.JTable t_payments_day;
    private javax.swing.JTable t_payments_expiry;
    private javax.swing.JTable t_payments_to_day;
    private javax.swing.JTabbedPane tp_accountants;
    // End of variables declaration//GEN-END:variables
}