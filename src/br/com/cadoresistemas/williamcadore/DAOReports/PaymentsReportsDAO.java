package br.com.cadoresistemas.williamcadore.DAOReports;

import br.com.cadoresistemas.williamcadore.ModelsForm.PaymentModel;
import br.com.cadoresistemas.williamcadore.Utils.Util;
import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import br.com.cadoresistemas.williamcadore.ConnectioFactory.ConnectionFactory;

public class PaymentsReportsDAO {
    private final java.sql.Connection Connection;
    private Component rootPane;
    public PaymentsReportsDAO(){
        this.Connection = ConnectionFactory.getConnection(1);
    }

    Util date = new Util();

    public PaymentModel getReportsPayments(Date first, Date last,Long id_truck, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        PaymentModel payments = new PaymentModel();
        try {
            String sql = "SELECT count(valor) AS qnt, SUM(valor) AS valor"
                    + " FROM payment WHERE id_truck = ? AND id_business = ? AND inactive = FALSE AND date_expiry BETWEEN ? AND ?";
            stmt = Connection.prepareStatement(sql);
            stmt.setLong(1, id_truck);
            stmt.setLong(2, id_business);
            stmt.setDate(3, date.dateFormatInsertSql(first));
            stmt.setDate(4, date.dateFormatInsertSql(last));

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                payments.setQnt(resultSet.getInt("qnt"));
                payments.setValor(resultSet.getDouble("valor"));
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return payments;
    }

    public PaymentModel getReportsPayments2(Date first, Date last,Long id_truck, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        PaymentModel payments = new PaymentModel();
        try {
            String sql = "SELECT SUM(valor) AS valor_no_paid, count(paid = FALSE) AS qnt_no_paid"
                    + " FROM payment WHERE id_truck = ? AND id_business = ? AND inactive = FALSE AND paid = FALSE AND date_expiry BETWEEN ? AND ?";
            stmt = Connection.prepareStatement(sql);
            stmt.setLong(1, id_truck);
            stmt.setLong(2, id_business);
            //stmt.setDate(3, date.dateFormatInsertSql(date.dateFormatInsert(date.getDateddMMyyyy())));
            stmt.setDate(3, date.dateFormatInsertSql(first));
            stmt.setDate(4, date.dateFormatInsertSql(last));

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                payments.setValor_no_paid(resultSet.getDouble("valor_no_paid"));
                payments.setQnt_no_paid(resultSet.getInt("qnt_no_paid"));
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return payments;
    }

    public PaymentModel getReportsPayments3(Date first, Date last,Long id_truck, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        PaymentModel payments = new PaymentModel();
        try {
            String sql = "SELECT SUM(valor) AS valor_paid, count(paid = TRUE) AS qnt_paid"
                    + " FROM payment WHERE id_truck = ? AND id_business = ? AND inactive = FALSE AND paid = TRUE AND date_expiry BETWEEN ? AND ?";
            stmt = Connection.prepareStatement(sql);
            stmt.setLong(1, id_truck);
            stmt.setLong(2, id_business);
            stmt.setDate(3, date.dateFormatInsertSql(first));
            stmt.setDate(4, date.dateFormatInsertSql(last));

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                payments.setQnt_paid(resultSet.getInt("qnt_paid"));
                payments.setValor_paid(resultSet.getDouble("valor_paid"));
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return payments;
    }

    public PaymentModel getReportsPayments4(Date first, Date last,Long id_truck, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        PaymentModel payments = new PaymentModel();
        try {
            String sql = "SELECT SUM(valor) AS valor_expiry, COUNT(paid = FALSE) AS qnt_expiry"
                    + " FROM payment WHERE id_truck = ? AND id_business = ? AND paid = FALSE AND inactive = FALSE AND date_expiry < ? AND date_expiry BETWEEN ? AND ?";
            stmt = Connection.prepareStatement(sql);
            stmt.setLong(1, id_truck);
            stmt.setLong(2, id_business);
            stmt.setDate(3, date.dateFormatInsertSql(date.dateFormatInsert(date.getDateddMMyyyy())));
            stmt.setDate(4, date.dateFormatInsertSql(first));
            stmt.setDate(5, date.dateFormatInsertSql(last));

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                payments.setQnt_expiry(resultSet.getInt("qnt_expiry"));
                payments.setValor_expiry(resultSet.getDouble("valor_expiry"));
            }
            resultSet.close();
        } catch (ParseException ex) {
            Logger.getLogger(PaymentsReportsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return payments;
    }
}