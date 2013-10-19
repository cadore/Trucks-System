package br.com.cadoresistemas.williamcadore.DAOReports;

import br.com.cadoresistemas.williamcadore.ConnectioFactory.ConnectionFactory;
import br.com.cadoresistemas.williamcadore.ModelsForm.FreightsModel;
import br.com.cadoresistemas.williamcadore.ModelsForm.FueledModel;
import br.com.cadoresistemas.williamcadore.Utils.Util;
import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

public class FreightsReportsDAO {
    private final java.sql.Connection Connection;
    private Component rootPane;
    public FreightsReportsDAO(){
        this.Connection = ConnectionFactory.getConnection(1);
    }

    Util date = new Util();

    public FreightsModel getReportsFreights(Date first, Date last,Long id_truck, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        FreightsModel freights = new FreightsModel();
        try {
            String sql = "SELECT count(*) AS qnt, SUM(gross) AS gross, SUM(fueled) AS fueled, SUM(discount2) AS discount2, SUM(percent) AS percent,"
                    + " SUM(total2) AS total2, SUM(total3) AS total3, SUM(value_t) AS value_t, SUM(weight) AS weight"
                    + " FROM freights WHERE truck = ? AND id_business = ? AND inactive = FALSE AND data_exit BETWEEN ? AND ?";
            stmt = Connection.prepareStatement(sql);
            stmt.setLong(1, id_truck);
            stmt.setLong(2, id_business);
            stmt.setDate(3, date.dateFormatInsertSql(first));
            stmt.setDate(4, date.dateFormatInsertSql(last));

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                freights.setQnt(resultSet.getInt("qnt"));
                freights.setGross(resultSet.getDouble("gross"));
                freights.setFueled(resultSet.getDouble("fueled"));
                freights.setDiscount2(resultSet.getDouble("discount2"));
                freights.setPercent(resultSet.getDouble("percent"));
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

    public FueledModel getLitersFueledFreights(Date first, Date last,Long id_truck, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        FueledModel fueled = new FueledModel();
        try {
            String sql = "SELECT SUM(liters) AS t_liters FROM fueled WHERE id_truck = ? AND id_business = ? AND date BETWEEN ? AND ?";
            stmt = Connection.prepareStatement(sql);
            stmt.setLong(1, id_truck);
            stmt.setLong(2, id_business);
            stmt.setDate(3, date.dateFormatInsertSql(first));
            stmt.setDate(4, date.dateFormatInsertSql(last));

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                fueled.setLiters(resultSet.getDouble("t_liters"));
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return fueled;
    }
}