package br.com.cadoresistemas.williamcadore.DAO;

import br.com.cadoresistemas.williamcadore.ModelsForm.PaymentModel;
import br.com.cadoresistemas.williamcadore.Utils.Paths;
import br.com.cadoresistemas.williamcadore.Utils.Util;
import java.awt.Component;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import br.com.cadoresistemas.williamcadore.ConnectioFactory.ConnectionFactory;

public class PaymentDAO {
   private final java.sql.Connection Connection;
    private Component rootPane;
    public PaymentDAO(){
        this.Connection = ConnectionFactory.getConnection(1);
    }

    Util date = new Util();
    private String limit_results = new Paths().getConfigLimitResults();

    public void adiciona(PaymentModel pagamentos){

        String sql = "INSERT INTO payment (payment,observation,date_expiry,valor,identify,created_at,updated,inactive,id_business,id_truck,paid) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        try {
            try (PreparedStatement stmt = Connection.prepareStatement(sql)) {
                stmt.setString(1, pagamentos.getPayment());
                stmt.setString(2, pagamentos.getObservation());
                stmt.setDate(3, date.dateFormatInsertSql(pagamentos.getDate_expiry()));
                stmt.setDouble(4, pagamentos.getValor());
                stmt.setString(5, pagamentos.getIdentify());
                stmt.setDate(6, date.dateFormatInsertSql(pagamentos.getCreated_at()));
                stmt.setDate(7, date.dateFormatInsertSql(pagamentos.getUpdated()));
                stmt.setBoolean(8, pagamentos.getInactive());
                stmt.setLong(9, pagamentos.getId_business());
                stmt.setLong(10, pagamentos.getId_truck());
                stmt.setBoolean(11, pagamentos.getPaid());

                stmt.executeUpdate();
                stmt.close();
            }


        } catch (Exception u) {
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane, u.getMessage() + ":  Contate o Administrador do Sistema!");
        }
    }

    public void atualiza(PaymentModel pagamentos){

        String sql = "UPDATE payment SET payment = ?,observation = ?,date_expiry = ?,valor = ?,identify = ?,updated = ?,"
                + "inactive  = ?,id_business = ?,id_truck = ?,paid = ? WHERE id_business = ? AND id = ?";

        try {
            PreparedStatement stmt = Connection.prepareStatement(sql);
                stmt.setString(1, pagamentos.getPayment());
                stmt.setString(2, pagamentos.getObservation());
                stmt.setDate(3, date.dateFormatInsertSql(pagamentos.getDate_expiry()));
                stmt.setDouble(4, pagamentos.getValor());
                stmt.setString(5, pagamentos.getIdentify());
                stmt.setDate(6, date.dateFormatInsertSql(pagamentos.getUpdated()));
                stmt.setBoolean(7, pagamentos.getInactive());
                stmt.setLong(8, pagamentos.getId_business());
                stmt.setLong(9, pagamentos.getId_truck());
                stmt.setBoolean(10, pagamentos.getPaid());
                stmt.setLong(11, pagamentos.getId_business());
                stmt.setLong(12, pagamentos.getId());

            stmt.executeUpdate();
            stmt.close();


        } catch (Exception u) {
            JOptionPane.showMessageDialog(rootPane, u.getMessage() + ": Contate o Administrador do Sistema!");
        }
    }

    public void exclui(PaymentModel pagamentos){

        String sql = "UPDATE payment SET inactive = ? WHERE id = ?";

        try {
            PreparedStatement stmt = Connection.prepareStatement(sql);
            stmt.setBoolean(1, pagamentos.getInactive());
            stmt.setLong(2, pagamentos.getId());

            stmt.executeUpdate();
            stmt.close();

        } catch (Exception u) {
            JOptionPane.showMessageDialog(rootPane, u.getMessage() + ": Contate o Administrador do Sistema!");
        }
    }

    public void setPaidPayment(PaymentModel pagamentos){

        String sql = "UPDATE payment SET paid = TRUE WHERE id = ? AND id_business = ?";

        try {
            PreparedStatement stmt = Connection.prepareStatement(sql);
            stmt.setLong(1, pagamentos.getId());
            stmt.setLong(2, pagamentos.getId_business());

            stmt.executeUpdate();
            stmt.close();

        } catch (Exception u) {
            JOptionPane.showMessageDialog(rootPane, u.getMessage() + ": Contate o Administrador do Sistema!");
        }
    }

  public final List<PaymentModel> getPaymentByPagoA(String pagoa, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        List<PaymentModel> payments = new ArrayList<>();
        try {
            String sql = "SELECT * FROM payment WHERE payment ILIKE ? AND id_business = ? AND inactive = FALSE ORDER BY date_expiry LIMIT " + limit_results;

            stmt = Connection.prepareStatement(sql);
            stmt.setString(1, "%" + pagoa + "%");
            stmt.setLong(2, id_business);

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                PaymentModel payment = new PaymentModel();
                payment.setId(resultSet.getLong("id"));
                payment.setPayment(resultSet.getString("payment"));
                payment.setObservation(resultSet.getString("observation"));
                payment.setDate_expiry(resultSet.getDate("date_expiry"));
                payment.setValor(resultSet.getDouble("valor"));
                payment.setIdentify(resultSet.getString("identify"));
                payment.setId_business(resultSet.getLong("id_business"));
                payment.setId_truck(resultSet.getLong("id_truck"));
                payment.setPaid(resultSet.getBoolean("paid"));

                payments.add (payment) ;
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return payments;
    }

    public final List<PaymentModel> getPaymentByDateExpiry(Date date_first, Date date_last, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        List<PaymentModel> payments = new ArrayList<>();
        try {
            String sql = "SELECT * FROM payment WHERE id_business = ? AND inactive = FALSE AND date_expiry BETWEEN ? AND ? ORDER BY date_expiry DESC LIMIT " + limit_results;

            stmt = Connection.prepareStatement(sql);
            stmt.setLong(1, id_business);
            stmt.setDate(2, date_first);
            stmt.setDate(3, date_last);

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                PaymentModel payment = new PaymentModel();
                payment.setId(resultSet.getLong("id"));
                payment.setPayment(resultSet.getString("payment"));
                payment.setObservation(resultSet.getString("observation"));
                payment.setDate_expiry(resultSet.getDate("date_expiry"));
                payment.setValor(resultSet.getDouble("valor"));
                payment.setIdentify(resultSet.getString("identify"));
                payment.setId_business(resultSet.getLong("id_business"));
                payment.setId_truck(resultSet.getLong("id_truck"));
                payment.setPaid(resultSet.getBoolean("paid"));

                payments.add(payment);
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return payments;
    }

    public final PaymentModel getPaymentByIdObj(int id, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        PaymentModel payments = new PaymentModel();
        try {
            String sql = "SELECT * FROM payment WHERE id=? AND id_business = ? AND inactive = FALSE";

            stmt = Connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setLong(2, id_business);

            resultSet = stmt.executeQuery();
            if(resultSet.next()){
                payments.setId(resultSet.getLong("id"));
                payments.setPayment(resultSet.getString("payment"));
                payments.setObservation(resultSet.getString("observation"));
                payments.setDate_expiry(resultSet.getDate("date_expiry"));
                payments.setValor(resultSet.getDouble("valor"));
                payments.setIdentify(resultSet.getString("identify"));
                payments.setCreated_at(resultSet.getDate("created_at"));
                payments.setUpdated(resultSet.getDate("updated"));
                payments.setId_business(resultSet.getLong("id_business"));
                payments.setId_truck(resultSet.getLong("id_truck"));
                payments.setPaid(resultSet.getBoolean("paid"));
            }
            else {
                payments = null;
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return payments;
    }

    public final List<PaymentModel> getPaymentDay(Date date, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        List<PaymentModel> payment = new ArrayList<>();
        try {
            String sql = "SELECT * FROM payment WHERE id_business = ? AND date_expiry = ? AND inactive = FALSE AND paid = FALSE ORDER BY id DESC";

            stmt = Connection.prepareStatement(sql);
            stmt.setLong(1, id_business);
            stmt.setDate(2, date);

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                PaymentModel payments = new PaymentModel();
                payments.setId(resultSet.getLong("id"));
                payments.setPayment(resultSet.getString("payment"));
                payments.setObservation(resultSet.getString("observation"));
                payments.setDate_expiry(resultSet.getDate("date_expiry"));
                payments.setValor(resultSet.getDouble("valor"));
                payments.setIdentify(resultSet.getString("identify"));
                payments.setCreated_at(resultSet.getDate("created_at"));
                payments.setUpdated(resultSet.getDate("updated"));
                payments.setId_business(resultSet.getLong("id_business"));
                payments.setId_truck(resultSet.getLong("id_truck"));

                payment.add(payments);
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return payment;
    }

    public final List<PaymentModel> getPaymentToDay(Date date, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        List<PaymentModel> payment = new ArrayList<>();
        try {
            String sql = "SELECT * FROM payment WHERE id_business = ? AND date_expiry = ? AND inactive = FALSE AND paid = FALSE ORDER BY id DESC";

            stmt = Connection.prepareStatement(sql);
            stmt.setLong(1, id_business);
            stmt.setDate(2, date);

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                PaymentModel payments = new PaymentModel();
                payments.setId(resultSet.getLong("id"));
                payments.setPayment(resultSet.getString("payment"));
                payments.setObservation(resultSet.getString("observation"));
                payments.setDate_expiry(resultSet.getDate("date_expiry"));
                payments.setValor(resultSet.getDouble("valor"));
                payments.setIdentify(resultSet.getString("identify"));
                payments.setCreated_at(resultSet.getDate("created_at"));
                payments.setUpdated(resultSet.getDate("updated"));
                payments.setId_business(resultSet.getLong("id_business"));
                payments.setId_truck(resultSet.getLong("id_truck"));

                payment.add(payments);
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return payment;
    }

    public final List<PaymentModel> getPaymentsExpiry(Date date, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        List<PaymentModel> payment = new ArrayList<>();
        try {
            String sql = "SELECT * FROM payment WHERE id_business = ? AND date_expiry <= ? AND inactive = FALSE AND paid = FALSE ORDER BY date_expiry";

            stmt = Connection.prepareStatement(sql);
            stmt.setLong(1, id_business);
            stmt.setDate(2, date);

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                PaymentModel payments = new PaymentModel();
                payments.setId(resultSet.getLong("id"));
                payments.setPayment(resultSet.getString("payment"));
                payments.setObservation(resultSet.getString("observation"));
                payments.setDate_expiry(resultSet.getDate("date_expiry"));
                payments.setValor(resultSet.getDouble("valor"));
                payments.setIdentify(resultSet.getString("identify"));
                payments.setCreated_at(resultSet.getDate("created_at"));
                payments.setUpdated(resultSet.getDate("updated"));
                payments.setId_business(resultSet.getLong("id_business"));
                payments.setId_truck(resultSet.getLong("id_truck"));

                payment.add(payments);
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return payment;
    }
}