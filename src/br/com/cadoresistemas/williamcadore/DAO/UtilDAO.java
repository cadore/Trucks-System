package br.com.cadoresistemas.williamcadore.DAO;

import br.com.cadoresistemas.williamcadore.ConnectioFactory.ConnectionFactory;
import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UtilDAO {
    private final java.sql.Connection Connection;
    private Component rootPane;
    public UtilDAO(){
        this.Connection = ConnectionFactory.getConnection(1);
    }

    public int getRowsTable(String from){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        int count = 0;
        try {
            String sql = "SELECT count(*) AS qnt FROM "+from;
            stmt = Connection.prepareStatement(sql);

            resultSet = stmt.executeQuery();
            if(resultSet.next()){
                count = resultSet.getInt("qnt");
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return count;
    }

    public String getIpDB(){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        String ip_db = null;
        try {
            String sql = "SELECT inet_server_addr() AS ip_DB";
            stmt = Connection.prepareStatement(sql);

            resultSet = stmt.executeQuery();
            if(resultSet.next()){
                ip_db = resultSet.getString("ip_DB");
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return ip_db;
    }

    public String getSizeDB(){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        String ip_db = null;
        try {
            String sql = "SELECT pg_size_pretty(pg_database_size('cadoresistemas.com.br_truck_system')) AS size_db";
            stmt = Connection.prepareStatement(sql);

            resultSet = stmt.executeQuery();
            if(resultSet.next()){
                ip_db = resultSet.getString("size_db");
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return ip_db;
    }

    public java.sql.Date getDateDB(){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        java.sql.Date dateHor_db = null;
        try {
            String sql = "SELECT CURRENT_DATE AS date_db";
            stmt = Connection.prepareStatement(sql);

            resultSet = stmt.executeQuery();
            if(resultSet.next()){
                dateHor_db = resultSet.getDate("date_db");
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return dateHor_db;
    }

    public String getVersion(){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        String version = null;
        try {
            String sql = "SELECT version FROM version";
            stmt = Connection.prepareStatement(sql);

            resultSet = stmt.executeQuery();
            if(resultSet.next()){
               version = resultSet.getString("version");
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return version;
    }
}
