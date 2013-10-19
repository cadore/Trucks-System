package br.com.cadoresistemas.williamcadore.DAO;

import br.com.cadoresistemas.williamcadore.ModelsForm.UserModel;
import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import br.com.cadoresistemas.williamcadore.ConnectioFactory.ConnectionFactory;

public class LoginDAO {
    private final java.sql.Connection Connection;
    private Component rootPane;
    public LoginDAO(){
        this.Connection = ConnectionFactory.getConnection(1);
    }

    public boolean authenticationUser (String login, String passwd, boolean inactive){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        Boolean flag = null;
        try {
            stmt = Connection.prepareStatement("SELECT COUNT(*) AS c FROM users WHERE login=? AND password=? AND inactive_user=? AND inactive = FALSE");
            stmt.setString(1, login);
            stmt.setString(2, passwd);
            stmt.setBoolean(3, inactive);
            resultSet = stmt.executeQuery();
            int count = 0;
            while(resultSet.next()){
                count = resultSet.getInt("c");
            }
            resultSet.close();
            if (count == 0 || count > 1){
                flag = false;
            } else if (count == 1){
                flag = true;
            }
        } catch (SQLException ex) {
            flag = false;
            JOptionPane.showMessageDialog(rootPane, ex.getMessage() + "erro login","erro",JOptionPane.WARNING_MESSAGE);
        }
        return flag;
    }

    public boolean authenticationAdmin (String passwd, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        Boolean flag = null;

        try {
            stmt = Connection.prepareStatement("SELECT COUNT(*) AS c FROM users WHERE password=? AND admin_user = TRUE AND inactive_user = FALSE "
                    + "AND id_business=? AND inactive = FALSE");
            stmt.setString(1, passwd);
            stmt.setLong(2, id_business);
            resultSet = stmt.executeQuery();
            int count = 0;
            while(resultSet.next()){
                count = resultSet.getInt("c");
            }
            resultSet.close();
            if (count == 0 || count > 1){
                flag = false;
            } else if (count == 1){
                flag = true;
            }
        } catch (SQLException ex) {
            flag = false;
            JOptionPane.showMessageDialog(rootPane, ex.getMessage() + "erro autenticação admin","erro",JOptionPane.WARNING_MESSAGE);
        }
        return flag;
    }

    public boolean authenticationTecnic (String login, String passwd){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        Boolean flag = null;
        try {
            stmt = Connection.prepareStatement("SELECT COUNT(*) AS c FROM users WHERE login=? AND password=?");
            stmt.setString(1, login);
            stmt.setString(2, passwd);
            resultSet = stmt.executeQuery();
            int count = 0;
            while(resultSet.next()){
                count = resultSet.getInt("c");
            }
            resultSet.close();
            if (count == 0 || count > 1){
                flag = false;
            } else if (count == 1){
                flag = true;
            }
        } catch (SQLException ex) {
            flag = false;
            JOptionPane.showMessageDialog(rootPane, ex.getMessage() + "erro login","erro",JOptionPane.WARNING_MESSAGE);
        }
        return flag;
    }

    /*public boolean authenticaçtionUser (int id, String passwd){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        Boolean flag = null;

        try {
            stmt = ConnectionFactory.prepareStatement("SELECT COUNT(*) AS c FROM users WHERE id=? AND password=? AND inactive = FALSE");
            stmt.setInt(1, id);
            stmt.setString(2, passwd);
            resultSet = stmt.executeQuery();
            int count = 0;
            while(resultSet.next()){
                count = resultSet.getInt("c");
            }
            resultSet.close();
            if (count == 0 || count > 1){
                flag = false;
            } else if (count == 1){
                flag = true;
            }
        } catch (SQLException ex) {
            flag = false;
            JOptionPane.showMessageDialog(rootPane, ex.getMessage() + "erro autenticação admin","erro",JOptionPane.WARNING_MESSAGE);
        }
        return flag;
    }*/

    public UserModel getUser (String passwd, String login, boolean inactive){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        UserModel user = new UserModel();

        try {
            stmt = Connection.prepareStatement("SELECT * FROM users WHERE password=? AND login=? AND inactive_user=? AND inactive = FALSE");
            stmt.setString(1, passwd);
            stmt.setString(2, login);
            stmt.setBoolean(3, inactive);
            resultSet = stmt.executeQuery();

            while(resultSet.next()){
                user.setBirthdate(resultSet.getDate("birthdate"));
                user.setContact(resultSet.getString("contact"));
                user.setEmail(resultSet.getString("email"));
                user.setFullName(resultSet.getString("full_name"));
                user.setId(resultSet.getLong("id"));
                user.setId_Business(resultSet.getLong("id_business"));
                user.setInactive(resultSet.getBoolean("inactive_user"));
                user.setAdmin(resultSet.getBoolean("admin_user"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setReports(resultSet.getBoolean("reports"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage() + "admin","erro",JOptionPane.WARNING_MESSAGE);
        }
        return user;
    }

    public ArrayList findAll(Long id_business){
        Statement stmt;
        ResultSet resultSet = null;
        ArrayList list = new ArrayList();
        try {
            stmt = Connection.createStatement();
            resultSet = stmt.executeQuery("SELECT login FROM users WHERE inactive = FALSE AND id_business="+id_business);
            while(resultSet.next()) {
                list.add(resultSet.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TractionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
