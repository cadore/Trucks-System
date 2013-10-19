package br.com.cadoresistemas.williamcadore.DAO;

import br.com.cadoresistemas.williamcadore.GUI.Dashboard;
import br.com.cadoresistemas.williamcadore.ModelsForm.DriversModel;
import br.com.cadoresistemas.williamcadore.Utils.Paths;
import br.com.cadoresistemas.williamcadore.Utils.Util;
import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import br.com.cadoresistemas.williamcadore.ConnectioFactory.ConnectionFactory;

public class DriversDAO {
    private final java.sql.Connection Connection;
    private Component rootPane;
    public DriversDAO(){
        this.Connection = ConnectionFactory.getConnection(1);
    }

    Util date = new Util();
    private String limit_results = new Paths().getConfigLimitResults();

    public void adiciona(DriversModel motoristas){

        String sql = "INSERT INTO drivers (full_name,cpf,phone,phone2,phone3,addres,n_cnh,"
                + "n_register,n_rg,category,n,district,city,uf,cep,sex,created_at,updated,active,inactive,birthday,id_business)"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            try (PreparedStatement stmt = Connection.prepareStatement(sql)) {
                stmt.setString(1, motoristas.getFull_name());
                stmt.setString(2, motoristas.getCpf());
                stmt.setString(3, motoristas.getPhone());
                stmt.setString(4, motoristas.getPhone2());
                stmt.setString(5, motoristas.getPhone3());
                stmt.setString(6, motoristas.getAddres());
                stmt.setString(7, motoristas.getN_cnh());
                stmt.setString(8, motoristas.getN_register());
                stmt.setString(9, motoristas.getN_rg());
                stmt.setString(10, motoristas.getCategory());
                stmt.setString(11, motoristas.getN());
                stmt.setString(12, motoristas.getDistrict());
                stmt.setString(13, motoristas.getCity());
                stmt.setLong(14, motoristas.getUf());
                stmt.setString(15, motoristas.getCep());
                stmt.setString(16, motoristas.getSex());
                stmt.setDate(17, date.dateFormatInsertSql(motoristas.getCreated_at()));
                stmt.setDate(18, date.dateFormatInsertSql(motoristas.getUpdated()));
                stmt.setBoolean(19, motoristas.getActive());
                stmt.setBoolean(20, motoristas.getInactive());
                stmt.setDate(21, date.dateFormatInsertSql(motoristas.getBirthday()));
                stmt.setLong(22, motoristas.getId_business());

                stmt.executeUpdate();
                stmt.close();
            }


        } catch (Exception u) {
            JOptionPane.showMessageDialog(rootPane, u.getMessage() + ": Contate o Administrador do Sistema!");
        }
    }

    public void atualiza(DriversModel motoristas){

        String sql = "UPDATE drivers SET full_name = ?,cpf = ?,phone = ?,phone2 = ?,phone3 = ?,addres = ?,n_cnh = ?,n_register = ?,"
                + "n_rg = ?,category = ?,n = ?,district = ?,city = ?,uf = ?,cep = ?,sex = ?,updated = ?,active = ?,"
                + "inactive = ?,birthday = ? WHERE id_business = ? AND id = ?";

        try {
            PreparedStatement stmt = Connection.prepareStatement(sql);
            stmt.setString(1, motoristas.getFull_name());
                stmt.setString(2, motoristas.getCpf());
                stmt.setString(3, motoristas.getPhone());
                stmt.setString(4, motoristas.getPhone2());
                stmt.setString(5, motoristas.getPhone3());
                stmt.setString(6, motoristas.getAddres());
                stmt.setString(7, motoristas.getN_cnh());
                stmt.setString(8, motoristas.getN_register());
                stmt.setString(9, motoristas.getN_rg());
                stmt.setString(10, motoristas.getCategory());
                stmt.setString(11, motoristas.getN());
                stmt.setString(12, motoristas.getDistrict());
                stmt.setString(13, motoristas.getCity());
                stmt.setLong(14, motoristas.getUf());
                stmt.setString(15, motoristas.getCep());
                stmt.setString(16, motoristas.getSex());
                stmt.setDate(17, date.dateFormatInsertSql(motoristas.getUpdated()));
                stmt.setBoolean(18, motoristas.getActive());
                stmt.setBoolean(19, motoristas.getInactive());
                stmt.setDate(20, date.dateFormatInsertSql(motoristas.getBirthday()));
                stmt.setLong(21, motoristas.getId_business());
                stmt.setLong(22, motoristas.getId());

            stmt.executeUpdate();
            stmt.close();


        } catch (Exception u) {
            JOptionPane.showMessageDialog(rootPane, u.getMessage() + ":  Contate o Administrador do Sistema!");
        }
    }

    public void exclui(DriversModel motoristas){

        String sql = "UPDATE drivers SET inactive = ?,active = ? WHERE id = ?";

        try {
            PreparedStatement stmt = Connection.prepareStatement(sql);
            stmt.setBoolean(1, motoristas.getInactive());
            stmt.setBoolean(2, motoristas.getActive());
            stmt.setLong(3, motoristas.getId());

            stmt.executeUpdate();
            stmt.close();


        } catch (Exception u) {
            JOptionPane.showMessageDialog(rootPane, u.getMessage() + ":  Contate o Administrador do Sistema!");
        }
    }

      public ArrayList findAllDriversisActive(Long id_business){
        Statement stmt;
        ResultSet resultSet = null;
        ArrayList list = new ArrayList();
        try {
            stmt = Connection.createStatement();
            resultSet = stmt.executeQuery("SELECT full_name FROM drivers WHERE active = TRUE AND inactive = FALSE AND id_business="+id_business);
            while(resultSet.next()) {
                list.add(resultSet.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DriversDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

      public ArrayList findAllDrivers(Long id_business){
        Statement stmt;
        ResultSet resultSet = null;
        ArrayList list = new ArrayList();
        try {
            stmt = Connection.createStatement();
            resultSet = stmt.executeQuery("SELECT full_name FROM drivers WHERE inactive = FALSE AND id_business="+id_business);
            while(resultSet.next()) {
                list.add(resultSet.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DriversDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Long getIdDriver(String drivers, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        Long id = null;
        try {
            stmt = Connection.prepareStatement("SELECT id FROM drivers WHERE full_name=? AND id_business=? AND inactive = FALSE");
            stmt.setString(1, drivers);
            stmt.setLong(2, id_business);
            resultSet = stmt.executeQuery();
            if (!(resultSet.next())) return null;
            id = resultSet.getLong("id");
        } catch (SQLException ex) {
            Logger.getLogger(DriversDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }


    public final List<DriversModel> getDriversByFull_Name(String full_name, Long id_business){
           PreparedStatement stmt;
           ResultSet resultSet = null;
           List<DriversModel> driver = new ArrayList<>();
           try {
               String sql = "SELECT * FROM drivers WHERE full_name ILIKE ? AND id_business=? AND inactive = FALSE ORDER BY full_name LIMIT " + limit_results;

               stmt = Connection.prepareStatement(sql);
               stmt.setString(1, "%" + full_name + "%");
               stmt.setLong(2, id_business);

               resultSet = stmt.executeQuery();
               while(resultSet.next()){
                   DriversModel drivers = new DriversModel();
                   drivers.setId(resultSet.getLong("id"));
                   drivers.setFull_name(resultSet.getString("full_name"));
                   drivers.setCpf(resultSet.getString("cpf"));
                   drivers.setPhone(resultSet.getString("phone"));
                   drivers.setSex(resultSet.getString("sex"));
                   drivers.setBirthday(resultSet.getDate("birthday"));
                   drivers.setActive(resultSet.getBoolean("active"));


                   driver.add(drivers) ;
               }
               resultSet.close();
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
           }
           return driver;
       }

       public final List<DriversModel> getDriversByCpf(String cpf, Long id_business){
           PreparedStatement stmt;
           ResultSet resultSet = null;
           List<DriversModel> driver = new ArrayList<>();
           try {
               String sql = "SELECT * FROM drivers WHERE cpf ILIKE ? AND id_business=? AND inactive = FALSE ORDER BY cpf LIMIT " + limit_results;

               stmt = Connection.prepareStatement(sql);
               stmt.setString(1, "%" + cpf + "%");
               stmt.setLong(2, id_business);

               resultSet = stmt.executeQuery();
               while(resultSet.next()){
                  DriversModel drivers = new DriversModel();
                   drivers.setId(resultSet.getLong("id"));
                   drivers.setFull_name(resultSet.getString("full_name"));
                   drivers.setCpf(resultSet.getString("cpf"));
                   drivers.setPhone(resultSet.getString("phone"));
                   drivers.setSex(resultSet.getString("sex"));
                   drivers.setBirthday(resultSet.getDate("birthday"));
                   drivers.setActive(resultSet.getBoolean("active"));

                   driver.add (drivers) ;
               }
               resultSet.close();
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
           }
           return driver;
       }

       public final DriversModel getDriversByIdObj(int id, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        DriversModel drivers = new DriversModel();
        try {
            String sql = "SELECT * FROM drivers WHERE id=? AND id_business=? AND inactive = FALSE";

            stmt = Connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setLong(2, id_business);

            resultSet = stmt.executeQuery();
            if(resultSet.next()){
                drivers.setId(resultSet.getLong("id"));
                drivers.setFull_name(resultSet.getString("full_name"));
                drivers.setCpf(resultSet.getString("cpf"));
                drivers.setPhone(resultSet.getString("phone"));
                drivers.setPhone2(resultSet.getString("phone2"));
                drivers.setPhone3(resultSet.getString("phone3"));
                drivers.setAddres(resultSet.getString("addres"));
                drivers.setN_cnh(resultSet.getString("n_cnh"));
                drivers.setN_register(resultSet.getString("n_register"));
                drivers.setN_rg(resultSet.getString("n_rg"));
                drivers.setCategory(resultSet.getString("category"));
                drivers.setN(resultSet.getString("n"));
                drivers.setDistrict(resultSet.getString("district"));
                drivers.setCity(resultSet.getString("city"));
                drivers.setUf(resultSet.getLong("uf"));
                drivers.setCep(resultSet.getString("cep"));
                drivers.setSex(resultSet.getString("sex"));
                drivers.setActive(resultSet.getBoolean("active"));
                drivers.setCreated_at(resultSet.getDate("created_at"));
                drivers.setUpdated(resultSet.getDate("updated"));
                drivers.setBirthday(resultSet.getDate("birthday"));
            }
            else {
                drivers = null;
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return drivers;
    }

       public Long getIdDriverByTruck(String board_truck, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        Long drivers = null;
        try {
            stmt = Connection.prepareStatement("SELECT driver FROM trucks WHERE board=? AND inactive = FALSE AND id_business=?");
            stmt.setString(1, board_truck);
            stmt.setLong(2, id_business);
            resultSet = stmt.executeQuery();
            if (!(resultSet.next())) return null;
            drivers = resultSet.getLong("driver");
        } catch (SQLException ex) {
            Logger.getLogger(FreightsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return drivers;
    }

    public String getDriverByID(Long driver, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        String drivers = null;
        try {
            stmt = Connection.prepareStatement("SELECT full_name FROM drivers WHERE id=? AND inactive = FALSE AND id_business=?");
            stmt.setLong(1, driver);
            stmt.setLong(2, id_business);
            resultSet = stmt.executeQuery();
            if (!(resultSet.next())) return null;
            drivers = resultSet.getString("full_name");
        } catch (SQLException ex) {
            Logger.getLogger(DriversDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return drivers;
    }

    public String getCpfDrivers(String cpf){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        String cpf_ = null;
        try {
            stmt = Connection.prepareStatement("SELECT cpf FROM drivers WHERE cpf=?");
            stmt.setString(1, cpf);
            resultSet = stmt.executeQuery();
            if (!(resultSet.next())) return null;
            cpf_ = resultSet.getString("cpf");
        } catch (SQLException ex) {
            Logger.getLogger(DriversDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cpf_;
    }
}