package br.com.cadoresistemas.williamcadore.DAO;

import br.com.cadoresistemas.williamcadore.ConnectioFactory.ConnectionFactory;
import br.com.cadoresistemas.williamcadore.ModelsForm.BusinessModel;
import java.awt.Component;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class BusinessDAO {
    private final java.sql.Connection Connection;
    private Component rootPane;
    public BusinessDAO(){
        this.Connection = ConnectionFactory.getConnection(1);
    }

   public final BusinessModel getBusinessByIdObj(int id){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        BusinessModel business = new BusinessModel();
        try {
            String sql = "SELECT * FROM business WHERE id=?";
            stmt = Connection.prepareStatement(sql);
            stmt.setInt(1, id);

            resultSet = stmt.executeQuery();
            if(resultSet.next()){
                business.setCorporate_name(resultSet.getString("corporate_name"));
                business.setFantasy_name(resultSet.getString("fantasy_name"));
                business.setCnpj(resultSet.getString("cnpj"));
                business.setState_registration(resultSet.getString("state_registration"));
                business.setId(resultSet.getLong("id"));
                business.setType(resultSet.getLong("type_business"));
                business.setInactive_business(resultSet.getBoolean("inactive_business"));
                business.setPhone(resultSet.getString("phone"));
                business.setPhone2(resultSet.getString("phone2"));
                business.setPhone3(resultSet.getString("phone3"));
                business.setAdress(resultSet.getString("address"));
                business.setDistrict(resultSet.getString("districts"));
                business.setCity(resultSet.getString("city"));
                business.setUf(resultSet.getLong("uf"));
                business.setCep(resultSet.getString("cep"));
                business.setObservation(resultSet.getString("observation"));
                business.setNumber_of_trucks(resultSet.getLong("number_of_trucks"));
                business.setDate_expiry(resultSet.getDate("date_expiry"));
            }
            else {
                business = null;
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return business;
    }

   public final BusinessModel getBusinessByCnpjObj(String cnpj){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        BusinessModel business = new BusinessModel();
        try {
            String sql = "SELECT * FROM business WHERE cnpj = ?";
            stmt = Connection.prepareStatement(sql);
            stmt.setString(1, cnpj);

            resultSet = stmt.executeQuery();
            if(resultSet.next()){
                business.setCorporate_name(resultSet.getString("corporate_name"));
                business.setFantasy_name(resultSet.getString("fantasy_name"));
                business.setCnpj(resultSet.getString("cnpj"));
                business.setState_registration(resultSet.getString("state_registration"));
                business.setId(resultSet.getLong("id"));
                business.setType(resultSet.getLong("type_business"));
                business.setInactive_business(resultSet.getBoolean("inactive_business"));
                business.setPhone(resultSet.getString("phone"));
                business.setPhone2(resultSet.getString("phone2"));
                business.setPhone3(resultSet.getString("phone3"));
                business.setAdress(resultSet.getString("address"));
                business.setDistrict(resultSet.getString("districts"));
                business.setCity(resultSet.getString("city"));
                business.setUf(resultSet.getLong("uf"));
                business.setCep(resultSet.getString("cep"));
                business.setObservation(resultSet.getString("observation"));
                business.setNumber_of_trucks(resultSet.getLong("number_of_trucks"));
                business.setDate_expiry(resultSet.getDate("date_expiry"));
            }
            else {
                business = null;
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return business;
    }

   public String getCorporate_NameBusinessById(Long id){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        String corporate_name = null;
        try {
            stmt = Connection.prepareStatement("SELECT corporate_name FROM business WHERE id=?");
            stmt.setLong(1, id);
            resultSet = stmt.executeQuery();
            if (!(resultSet.next())) return null;
            corporate_name = resultSet.getString("corporate_name");
        } catch (SQLException ex) {
            Logger.getLogger(TractionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return corporate_name;
    }

   public int getNumberOfTrucksBusiness(Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        int number = 0;
        try {
            String sql = "SELECT number_of_trucks FROM business WHERE id=?";

            stmt = Connection.prepareStatement(sql);
            stmt.setLong(1, id_business);

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                 number = resultSet.getInt("number_of_trucks");
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return number;
    }

   public boolean getInactiveBusiness(Long id_business, Date date_expiry){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        Boolean number = true;
        try {
            String sql = "SELECT inactive_business FROM business WHERE id=? AND inactive = FALSE AND date_expiry > ?";

            stmt = Connection.prepareStatement(sql);
            stmt.setLong(1, id_business);
            stmt.setDate(2, date_expiry);

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                 number = resultSet.getBoolean("inactive_business");
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return number;
    }

   public java.util.Date getDateExpiry(Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        Date number = null;
        try {
            String sql = "SELECT date_expiry FROM business WHERE id=?";

            stmt = Connection.prepareStatement(sql);
            stmt.setLong(1, id_business);

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                 number = resultSet.getDate("date_expiry");
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return number;
    }

   public boolean getCountBusinessFirstAccess(String cnpj){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        boolean flag = false;
        int count = 0;
        try {
            String sql = "SELECT COUNT(corporate_name) AS c FROM business WHERE cnpj = ?";

            stmt = Connection.prepareStatement(sql);
            stmt.setString(1, cnpj);

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                count = resultSet.getInt("c");
                if(count == 0 || count > 1){
                    flag = false;
                }else if(count == 1){
                    flag = true;
                }
            }
            resultSet.close();
        } catch (SQLException ex) {
            flag = false;
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return flag;
    }

   public boolean getCountUsersBusinessById(Long id){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        boolean flag = false;
        int count = 0;
        try {
            String sql = "SELECT COUNT(login) AS c FROM users WHERE id_business = ?";

            stmt = Connection.prepareStatement(sql);
            stmt.setLong(1, id);

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                count = resultSet.getInt("c");
                if(count == 1 || count > 1){
                    flag = false;
                }else if(count == 0){
                    flag = true;
                }
            }
            resultSet.close();
        } catch (SQLException ex) {
            flag = false;
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return flag;
    }
}
