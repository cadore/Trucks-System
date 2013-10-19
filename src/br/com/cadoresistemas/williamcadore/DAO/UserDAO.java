package br.com.cadoresistemas.williamcadore.DAO;

import br.com.cadoresistemas.williamcadore.ModelsForm.UserModel;
import br.com.cadoresistemas.williamcadore.Utils.Paths;
import br.com.cadoresistemas.williamcadore.Utils.Util;
import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import br.com.cadoresistemas.williamcadore.ConnectioFactory.ConnectionFactory;

public class UserDAO {
    private final java.sql.Connection Connection;
    private Component rootPane;
    public UserDAO(){
        this.Connection = ConnectionFactory.getConnection(1);
    }

    private Util date = new Util();
    private String limit_results = new Paths().getConfigLimitResults();

    public void adiciona(UserModel usuario){

        String sql = "INSERT INTO users(full_name,contact,email,birthdate,login,password,admin_user,inactive_user,created_at,updated,inactive,id_business,reports) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = Connection.prepareStatement(sql);
            stmt.setString(1, usuario.getFullName());
            stmt.setString(2, usuario.getContact());
            stmt.setString(3, usuario.getEmail());
            stmt.setDate(4, date.dateFormatInsertSql(usuario.getBirthdate()));
            stmt.setString(5, usuario.getLogin());
            stmt.setString(6, usuario.getPassword());
            stmt.setBoolean(7, usuario.getAdmin());
            stmt.setBoolean(8, usuario.getInactiveUser());
            stmt.setDate(9, date.dateFormatInsertSql(usuario.getCreated_at()));
            stmt.setDate(10, date.dateFormatInsertSql(usuario.getUpdated()));
            stmt.setBoolean(11, usuario.getInactive());
            stmt.setLong(12, usuario.getId_Business());
            stmt.setBoolean(13, usuario.getReports());

            stmt.executeUpdate();
            stmt.close();

        } catch (Exception u) {
            JOptionPane.showMessageDialog(rootPane, u.getMessage() + ": Contate o Administrador do Sistema!");
        }
    }

    public void atualiza(UserModel usuario){

        String sql = "UPDATE users SET full_name = ?,contact = ?,email = ?,birthdate = ?,admin_user = ?,"
                + "inactive_user = ?,updated = ?,inactive = ?,reports = ? WHERE id_business = ? AND id = ?";

        try {
            PreparedStatement stmt = Connection.prepareStatement(sql);
            stmt.setString(1, usuario.getFullName());
            stmt.setString(2, usuario.getContact());
            stmt.setString(3, usuario.getEmail());
            stmt.setDate(4, date.dateFormatInsertSql(usuario.getBirthdate()));
            stmt.setBoolean(5, usuario.getAdmin());
            stmt.setBoolean(6, usuario.getInactiveUser());
            stmt.setDate(7, date.dateFormatInsertSql(usuario.getUpdated()));
            stmt.setBoolean(8, usuario.getInactive());
            stmt.setBoolean(9, usuario.getReports());
            stmt.setLong(10, usuario.getId_Business());
            stmt.setLong(11, usuario.getId());

            stmt.executeUpdate();
            stmt.close();


        } catch (Exception u) {
            JOptionPane.showMessageDialog(rootPane, u.getMessage() + ": Contate o Administrador do Sistema!");
        }
    }

    public void setPwd(UserModel usuario){

        String sql = "UPDATE users SET password = ? WHERE id_business = ? AND id = ?";

        try {
            PreparedStatement stmt = Connection.prepareStatement(sql);
            stmt.setString(1, usuario.getPassword());
            stmt.setLong(2, usuario.getId_Business());
            stmt.setLong(3, usuario.getId());

            stmt.executeUpdate();
            stmt.close();


        } catch (Exception u) {
            JOptionPane.showMessageDialog(rootPane, u.getMessage() + ": Contate o Administrador do Sistema!");
        }
    }

    public void exclui(UserModel usuario){

        String sql = "UPDATE users SET inactive = ? WHERE id = ?";

        try {
            PreparedStatement stmt = Connection.prepareStatement(sql);
            stmt.setBoolean(1, usuario.getInactive());
            stmt.setLong(2, usuario.getId());

            stmt.executeUpdate();
            stmt.close();


        } catch (Exception u) {
            JOptionPane.showMessageDialog(rootPane, u.getMessage() + ":  Contate o Administrador do Sistema!");
        }
    }

    public final List<UserModel> getUsers(Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        List<UserModel> users = new ArrayList<>();
        try {
            String sql = "SELECT * FROM users WHERE id_business = ? AND inactive = FALSE ORDER BY admin_user = FALSE,login LIMIT "+limit_results;

            stmt = Connection.prepareStatement(sql);
            stmt.setLong(1, id_business);

            resultSet = stmt.executeQuery();

            while(resultSet.next()){
                UserModel user = new UserModel();
                user.setBirthdate(resultSet.getDate("birthdate"));
                user.setContact(resultSet.getString("contact"));
                user.setEmail(resultSet.getString("email"));
                user.setFullName(resultSet.getString("full_name"));
                user.setId(resultSet.getLong("id"));
                user.setInactiveUser(resultSet.getBoolean("inactive_user"));
                user.setAdmin(resultSet.getBoolean("admin_user"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setReports(resultSet.getBoolean("reports"));

                users.add(user);
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return users;
    }

    public final List<UserModel> getUsersByName(String name, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        List<UserModel> users = new ArrayList<>();
        try {
            String sql = "SELECT * FROM users WHERE full_name ILIKE ? AND id_business = ? AND inactive = FALSE ORDER BY admin_user = FALSE,login LIMIT "+limit_results;

            stmt = Connection.prepareStatement(sql);
            stmt.setString(1, "%" + name + "%");
            stmt.setLong(2, id_business);

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                UserModel user = new UserModel();
                user.setBirthdate(resultSet.getDate("birthdate"));
                user.setContact(resultSet.getString("contact"));
                user.setEmail(resultSet.getString("email"));
                user.setFullName(resultSet.getString("full_name"));
                user.setId(resultSet.getLong("id"));
                user.setInactiveUser(resultSet.getBoolean("inactive_user"));
                user.setAdmin(resultSet.getBoolean("admin_user"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setReports(resultSet.getBoolean("reports"));

                users.add(user);
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return users;
    }

    public final List<UserModel> getUsersByLogin(String login, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        List<UserModel> users = new ArrayList<>();
        try {
            String sql = "SELECT * FROM users WHERE login ILIKE ? AND id_business = ? AND inactive = FALSE ORDER BY admin_user = FALSE,login LIMIT "+limit_results;

            stmt = Connection.prepareStatement(sql);
            stmt.setString(1,"%" + login + "%");
            stmt.setLong(2, id_business);

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                UserModel user = new UserModel();
                user.setBirthdate(resultSet.getDate("birthdate"));
                user.setContact(resultSet.getString("contact"));
                user.setEmail(resultSet.getString("email"));
                user.setFullName(resultSet.getString("full_name"));
                user.setId(resultSet.getLong("id"));
                user.setInactiveUser(resultSet.getBoolean("inactive_user"));
                user.setAdmin(resultSet.getBoolean("admin_user"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setReports(resultSet.getBoolean("reports"));

                users.add(user);
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return users;
    }


    public final UserModel getUsersByLoginObj(String login, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        UserModel users = new UserModel();
        try {
            String sql = "SELECT * FROM users WHERE login=? AND id_business = ? AND inactive = FALSE";

            stmt = Connection.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setLong(2, id_business);

            resultSet = stmt.executeQuery();
            if(resultSet.next()){
                users.setBirthdate(resultSet.getDate("birthdate"));
                users.setContact(resultSet.getString("contact"));
                users.setEmail(resultSet.getString("email"));
                users.setFullName(resultSet.getString("full_name"));
                users.setId(resultSet.getLong("id"));
                users.setInactiveUser(resultSet.getBoolean("inactive_user"));
                users.setAdmin(resultSet.getBoolean("admin_user"));
                users.setLogin(resultSet.getString("login"));
                users.setPassword(resultSet.getString("password"));
                users.setReports(resultSet.getBoolean("reports"));
            }
            else {
                users = null;
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro aki",JOptionPane.WARNING_MESSAGE);
        }
        return users;
    }

    public final UserModel getUsersByIdObj(int id, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        UserModel users = new UserModel();
        try {
            String sql = "SELECT * FROM users WHERE id=? AND id_business = ? AND inactive = FALSE";
            stmt = Connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setLong(2, id_business);

            resultSet = stmt.executeQuery();
            if(resultSet.next()){
                users.setBirthdate(resultSet.getDate("birthdate"));
                users.setContact(resultSet.getString("contact"));
                users.setEmail(resultSet.getString("email"));
                users.setFullName(resultSet.getString("full_name"));
                users.setId(resultSet.getLong("id"));
                users.setInactiveUser(resultSet.getBoolean("inactive_user"));
                users.setAdmin(resultSet.getBoolean("admin_user"));
                users.setLogin(resultSet.getString("login"));
                users.setPassword(resultSet.getString("password"));
                users.setReports(resultSet.getBoolean("reports"));
            }
            else {
                users = null;
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return users;
    }

    public final int getIdBusinessByLoginUsers(String login){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        int users = 0;
        try {
            String sql = "SELECT id_business FROM users WHERE login=? AND inactive = FALSE";
            stmt = Connection.prepareStatement(sql);
            stmt.setString(1, login);

            resultSet = stmt.executeQuery();
            if(resultSet.next()){
                resultSet.getInt("id_business");
            }
            else {
                users = 0;
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return users;
    }

    public final String getLoginsUser(String login){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        String users = null;
        try {
            String sql = "SELECT login FROM users WHERE login=?";
            stmt = Connection.prepareStatement(sql);
            stmt.setString(1, login);

            resultSet = stmt.executeQuery();
            if(resultSet.next()){
                users = resultSet.getString("login");
            }
            else {
                users = "";
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return users;
    }

    public final String getEMailUser(String email){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        String users = null;
        try {
            String sql = "SELECT email FROM users WHERE email=?";
            stmt = Connection.prepareStatement(sql);
            stmt.setString(1, email);

            resultSet = stmt.executeQuery();
            if(resultSet.next()){
                users = resultSet.getString("email");
            }
            else {
                users = "";
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return users;
    }

    public final String getPhoneUser(String phone){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        String users = null;
        try {
            String sql = "SELECT phone FROM users WHERE phone=?";
            stmt = Connection.prepareStatement(sql);
            stmt.setString(1, phone);

            resultSet = stmt.executeQuery();
            if(resultSet.next()){
                users = resultSet.getString("phone");
            }
            else {
                users = "";
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return users;
    }
}

