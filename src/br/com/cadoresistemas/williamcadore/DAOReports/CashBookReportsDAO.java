package br.com.cadoresistemas.williamcadore.DAOReports;

import br.com.cadoresistemas.williamcadore.ModelsForm.FreightsModel;
import br.com.cadoresistemas.williamcadore.ModelsForm.InputsModel;
import br.com.cadoresistemas.williamcadore.ModelsForm.OutputsModel;
import br.com.cadoresistemas.williamcadore.ModelsForm.PaymentModel;
import br.com.cadoresistemas.williamcadore.Utils.Util;
import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import br.com.cadoresistemas.williamcadore.ConnectioFactory.ConnectionFactory;

public class CashBookReportsDAO {
    private final java.sql.Connection Connection;
    private Component rootPane;
    public CashBookReportsDAO(){
        this.Connection = ConnectionFactory.getConnection(1);
    }

    Util date = new Util();

    public InputsModel getReportsInputsPeriod(Date first, Date last, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        InputsModel inputs = new InputsModel();
        try {
            String sql = "SELECT SUM(value3) AS value3"
                    + " FROM inputs WHERE id_business = ? AND id_freight = 0 AND inactive = FALSE AND date BETWEEN ? AND ?";
            stmt = Connection.prepareStatement(sql);
            stmt.setLong(1, id_business);
            stmt.setDate(2, date.dateFormatInsertSql(first));
            stmt.setDate(3, date.dateFormatInsertSql(last));

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                inputs.setValue3(resultSet.getDouble("value3"));
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return inputs;
    }

    public InputsModel getReportsInputsFull(Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        InputsModel inputs = new InputsModel();
        try {
            String sql = "SELECT SUM(value3) AS value3"
                    + " FROM inputs WHERE id_business = ? AND inactive = FALSE AND id_freight = 0";
            stmt = Connection.prepareStatement(sql);
            stmt.setLong(1, id_business);

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                inputs.setValue3(resultSet.getDouble("value3"));
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return inputs;
    }

    public OutputsModel getReportsOutputsPeriod(Date first, Date last, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        OutputsModel outputs = new OutputsModel();
        try {
            String sql = "SELECT SUM(value3) AS value3"
                    + " FROM outputs WHERE id_business = ? AND inactive = FALSE AND id_freight = 0 AND date BETWEEN ? AND ?";
            stmt = Connection.prepareStatement(sql);
            stmt.setLong(1, id_business);
            stmt.setDate(2, date.dateFormatInsertSql(first));
            stmt.setDate(3, date.dateFormatInsertSql(last));

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                outputs.setValue3(resultSet.getDouble("value3"));
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return outputs;
    }

    public OutputsModel getReportsOutputsFull(Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        OutputsModel outputs = new OutputsModel();
        try {
            String sql = "SELECT SUM(value3) AS value3"
                    + " FROM outputs WHERE id_business = ? AND id_freight = 0 AND inactive = FALSE";
            stmt = Connection.prepareStatement(sql);
            stmt.setLong(1, id_business);

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                outputs.setValue3(resultSet.getDouble("value3"));
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return outputs;
    }

    public PaymentModel getReportsPaymentsPeriod(Date first, Date last, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        PaymentModel payments = new PaymentModel();
        try {
            String sql = "SELECT SUM(valor) AS valor"
                    + " FROM payment WHERE id_business = ? AND inactive = FALSE AND paid = TRUE AND date_expiry BETWEEN ? AND ?";
            stmt = Connection.prepareStatement(sql);
            stmt.setLong(1, id_business);
            stmt.setDate(2, date.dateFormatInsertSql(first));
            stmt.setDate(3, date.dateFormatInsertSql(last));

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                payments.setValor(resultSet.getDouble("valor"));
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return payments;
    }

    public PaymentModel getReportsPaymentsFull(Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        PaymentModel payments = new PaymentModel();
        try {
            String sql = "SELECT SUM(valor) AS valor"
                    + " FROM payment WHERE id_business = ? AND paid = TRUE AND inactive = FALSE";
            stmt = Connection.prepareStatement(sql);
            stmt.setLong(1, id_business);

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                payments.setValor(resultSet.getDouble("valor"));
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return payments;
    }

    public FreightsModel getReportsFreightsPeriod(Date first, Date last, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        FreightsModel freights = new FreightsModel();
        try {
            String sql = "SELECT SUM(discount) AS discount, SUM(discount2) AS discount2, SUM(fueled) AS fueled, SUM(gross) AS gross, "
                    + "SUM(percent) AS percent, SUM(total1) AS total1, SUM(total2) AS total2, SUM(total3) AS total3, SUM(value_t) AS value_t, "
                    + "SUM(weight) AS weight FROM freights WHERE id_business = ?  AND inactive = FALSE AND data_exit BETWEEN ? AND ?";
            stmt = Connection.prepareStatement(sql);
            stmt.setLong(1, id_business);
            stmt.setDate(2, date.dateFormatInsertSql(first));
            stmt.setDate(3, date.dateFormatInsertSql(last));

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                freights.setDiscount(resultSet.getDouble("discount"));
                freights.setDiscount2(resultSet.getDouble("discount2"));
                freights.setFueled(resultSet.getDouble("fueled"));
                freights.setGross(resultSet.getDouble("gross"));
                freights.setPercent(resultSet.getDouble("percent"));
                freights.setTotal1(resultSet.getDouble("total1"));
                freights.setTotal2(resultSet.getDouble("total2"));
                freights.setTotal3(resultSet.getDouble("total3"));
                freights.setValue_t(resultSet.getDouble("value_t"));
                freights.setWeight(resultSet.getDouble("weight"));
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return freights;
    }

    public FreightsModel getReportsFreightsFull(Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        FreightsModel freights = new FreightsModel();
        try {
            String sql = "SELECT SUM(discount) AS discount, SUM(discount2) AS discount2, SUM(fueled) AS fueled, SUM(gross) AS gross, "
                    + "SUM(percent) AS percent, SUM(total1) AS total1, SUM(total2) AS total2, SUM(total3) AS total3, SUM(value_t) AS value_t, "
                    + "SUM(weight) AS weight FROM freights WHERE id_business = ? AND inactive = FALSE";
            stmt = Connection.prepareStatement(sql);
            stmt.setLong(1, id_business);

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                freights.setDiscount(resultSet.getDouble("discount"));
                freights.setDiscount2(resultSet.getDouble("discount2"));
                freights.setFueled(resultSet.getDouble("fueled"));
                freights.setGross(resultSet.getDouble("gross"));
                freights.setPercent(resultSet.getDouble("percent"));
                freights.setTotal1(resultSet.getDouble("total1"));
                freights.setTotal2(resultSet.getDouble("total2"));
                freights.setTotal3(resultSet.getDouble("total3"));
                freights.setValue_t(resultSet.getDouble("value_t"));
                freights.setWeight(resultSet.getDouble("weight"));
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return freights;
    }
}