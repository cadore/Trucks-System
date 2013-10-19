package br.com.cadoresistemas.williamcadore.DAOReports;

import br.com.cadoresistemas.williamcadore.ModelsForm.OthersModel;
import br.com.cadoresistemas.williamcadore.Utils.Util;
import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import br.com.cadoresistemas.williamcadore.ConnectioFactory.ConnectionFactory;

public class OthersReportsDAO {
    private final java.sql.Connection Connection;
    private Component rootPane;
    public OthersReportsDAO(){
        this.Connection = ConnectionFactory.getConnection(1);
    }

    Util date = new Util();

    public OthersModel getReportsOthersUsers(Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        OthersModel others = new OthersModel();
        try {
            String sql = "SELECT COUNT(inactive) AS qnt_users FROM users WHERE inactive = FALSE AND id_business = ?  AND inactive = FALSE";

            stmt = Connection.prepareStatement(sql);
            stmt.setLong(1, id_business);

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                 others.setA(resultSet.getInt("qnt_users"));
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return others;
    }

    public OthersModel getReportsOthersTrucks(Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        OthersModel others = new OthersModel();
        try {
            String sql = "SELECT COUNT(inactive) AS qnt_trucks FROM trucks WHERE inactive = FALSE AND id_business = ?";

            stmt = Connection.prepareStatement(sql);
            stmt.setLong(1, id_business);

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                 others.setB(resultSet.getInt("qnt_trucks"));
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return others;
    }

    public OthersModel getReportsOthersDrivers(Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        OthersModel others = new OthersModel();
        try {
            String sql = "SELECT COUNT(inactive) AS qnt_drivers FROM drivers WHERE inactive = FALSE AND id_business = ?";

            stmt = Connection.prepareStatement(sql);
            stmt.setLong(1, id_business);

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                 others.setC(resultSet.getInt("qnt_drivers"));
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return others;
    }
}