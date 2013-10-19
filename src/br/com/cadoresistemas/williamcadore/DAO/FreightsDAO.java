package br.com.cadoresistemas.williamcadore.DAO;

import br.com.cadoresistemas.williamcadore.ModelsForm.FreightsModel;
import br.com.cadoresistemas.williamcadore.Utils.Paths;
import br.com.cadoresistemas.williamcadore.Utils.Util;
import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import br.com.cadoresistemas.williamcadore.ConnectioFactory.ConnectionFactory;

public class FreightsDAO {
 private final java.sql.Connection Connection;
 private Component rootPane;
 public String Driver = "";

    public FreightsDAO(){
        this.Connection = ConnectionFactory.getConnection(1);
    }

    Util date = new Util();
    private String limit_results = new Paths().getConfigLimitResults();

    public void adiciona(FreightsModel fretes){

        String sql = "INSERT INTO freights (city_destination,city_source,company_destination,company_source,"
                + "data_arrived,data_exit,discount,discount2,driver,fueled,gross,note,percent,product,total1,total2,total3,"
                + "uf_destination,uf_source,value_t,weight,truck,created_at,updated,inactive,id_business,random,observation,medium_fueled)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            try (PreparedStatement stmt = Connection.prepareStatement(sql)) {
                stmt.setString(1, fretes.getCity_destination());
                stmt.setString(2, fretes.getCity_source());
                stmt.setString(3, fretes.getCompany_destination());
                stmt.setString(4, fretes.getCompany_source());
                stmt.setDate(5, date.dateFormatInsertSql(fretes.getData_arrived()));
                stmt.setDate(6, date.dateFormatInsertSql(fretes.getData_exit()));
                stmt.setDouble(7, fretes.getDiscount());
                stmt.setDouble(8, fretes.getDiscount2());
                stmt.setLong(9, fretes.getDriver());
                stmt.setDouble(10, fretes.getFueled());
                stmt.setDouble(11, fretes.getGross());
                stmt.setString(12, fretes.getNote());
                stmt.setDouble(13, fretes.getPercent());
                stmt.setString(14, fretes.getProduct());
                stmt.setDouble(15, fretes.getTotal1());
                stmt.setDouble(16, fretes.getTotal2());
                stmt.setDouble(17, fretes.getTotal3());
                stmt.setLong(18, fretes.getUf_destination());
                stmt.setLong(19, fretes.getUf_source());
                stmt.setDouble(20, fretes.getValue_t());
                stmt.setDouble(21, fretes.getWeight());
                stmt.setLong(22, fretes.getTruck());
                stmt.setDate(23, date.dateFormatInsertSql(fretes.getCreated_at()));
                stmt.setDate(24, date.dateFormatInsertSql(fretes.getUpdated()));
                stmt.setBoolean(25, fretes.getInactive());
                stmt.setLong(26, fretes.getId_business());
                stmt.setInt(27, fretes.getRandom());
                stmt.setString(28, fretes.getObservation());
                stmt.setDouble(29, fretes.getMedium_fueled());

                stmt.executeUpdate();
                stmt.close();
            }


        } catch (Exception u) {
           JOptionPane.showMessageDialog(rootPane, u.getMessage() + ": Contate o Administrador do Sistema!");
        }
    }

    public void atualiza(FreightsModel fretes){

        String sql = "UPDATE freights SET city_destination = ?,city_source = ?,company_destination = ?,company_source = ?,"
                + "data_arrived = ?,data_exit = ?,discount = ?,discount2 = ?,driver = ?,fueled=?,gross = ?,note = ?,percent = ?,"
                + "product = ?,total1 = ?,total2 = ?,total3 = ?,uf_destination = ?,uf_source = ?,value_t = ?,weight = ?,truck = ?,updated = ?,inactive  = ?,"
                + "observation = ?,medium_fueled = ? WHERE id_business = ? AND id = ?";

        try {
            PreparedStatement stmt = Connection.prepareStatement(sql);
                stmt.setString(1, fretes.getCity_destination());
                stmt.setString(2, fretes.getCity_source());
                stmt.setString(3, fretes.getCompany_destination());
                stmt.setString(4, fretes.getCompany_source());
                stmt.setDate(5, date.dateFormatInsertSql(fretes.getData_arrived()));
                stmt.setDate(6, date.dateFormatInsertSql(fretes.getData_exit()));
                stmt.setDouble(7, fretes.getDiscount());
                stmt.setDouble(8, fretes.getDiscount2());
                stmt.setLong(9, fretes.getDriver());
                stmt.setDouble(10, fretes.getFueled());
                stmt.setDouble(11, fretes.getGross());
                stmt.setString(12, fretes.getNote());
                stmt.setDouble(13, fretes.getPercent());
                stmt.setString(14, fretes.getProduct());
                stmt.setDouble(15, fretes.getTotal1());
                stmt.setDouble(16, fretes.getTotal2());
                stmt.setDouble(17, fretes.getTotal3());
                stmt.setLong(18, fretes.getUf_destination());
                stmt.setLong(19, fretes.getUf_source());
                stmt.setDouble(20, fretes.getValue_t());
                stmt.setDouble(21, fretes.getWeight());
                stmt.setLong(22, fretes.getTruck());
                stmt.setDate(23, date.dateFormatInsertSql(fretes.getUpdated()));
                stmt.setBoolean(24, fretes.getInactive());
                stmt.setString(25, fretes.getObservation());
                stmt.setDouble(26, fretes.getMedium_fueled());
                stmt.setLong(27, fretes.getId_business());
                stmt.setLong(28, fretes.getId());

            stmt.executeUpdate();
            stmt.close();


        } catch (Exception u) {
            Logger.getLogger(FreightsDAO.class.getName()).log(Level.SEVERE, null, u);
            JOptionPane.showMessageDialog(rootPane, u.getMessage() + ":\n Contate o Administrador do Sistema!");
        }
    }

    public void exclui(FreightsModel fretes){

        String sql = "UPDATE freights SET inactive = ? WHERE id = ? AND id_business = ?";

        try {
            PreparedStatement stmt = Connection.prepareStatement(sql);
            stmt.setBoolean(1, fretes.getInactive());
            stmt.setLong(2, fretes.getId());
            stmt.setLong(3, fretes.getId_business());

            stmt.executeUpdate();
            stmt.close();


        } catch (Exception u) {
            JOptionPane.showMessageDialog(rootPane, u.getMessage() + ":  Contate o Administrador do Sistema!");
        }
    }

    public final List<FreightsModel> getAllFreights(Long id_business){
           PreparedStatement stmt;
           ResultSet resultSet = null;
           List<FreightsModel> freight = new ArrayList<>();
           try {
               String sql = "SELECT * FROM freights WHERE inactive = FALSE AND id_business=? ORDER BY data_exit DESC LIMIT " + limit_results;

               stmt = Connection.prepareStatement(sql);
               stmt.setLong(1, id_business);

               resultSet = stmt.executeQuery();
               while(resultSet.next()){
                  FreightsModel freights = new FreightsModel();
                   freights.setId(resultSet.getLong("id"));
                   freights.setTruck(resultSet.getLong("truck"));
                   freights.setData_exit(resultSet.getDate("data_exit"));
                   freights.setDriver(resultSet.getLong("driver"));
                   freights.setNote(resultSet.getString("note"));
                   freights.setProduct(resultSet.getString("product"));
                   freights.setTotal3(resultSet.getDouble("total3"));
                   freights.setWeight(resultSet.getDouble("weight"));

                   freight.add (freights) ;
               }
               resultSet.close();
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
           }
           return freight;
       }

    public final List<FreightsModel> getFreightsByNote(String note, Long id_business, Long truck){
           PreparedStatement stmt;
           ResultSet resultSet = null;
           List<FreightsModel> freight = new ArrayList<>();
           try {
               String sql = "SELECT * FROM freights WHERE note ILIKE ? AND id_business = ? AND truck=? AND inactive = FALSE  ORDER BY data_exit DESC LIMIT " + limit_results;

               stmt = Connection.prepareStatement(sql);
               stmt.setString(1, "%" + note + "%");
               stmt.setLong(2, id_business);
               stmt.setLong(3, truck);

               resultSet = stmt.executeQuery();
               while(resultSet.next()){
                  FreightsModel freights = new FreightsModel();
                   freights.setId(resultSet.getLong("id"));
                   freights.setTruck(resultSet.getLong("truck"));
                   freights.setData_exit(resultSet.getDate("data_exit"));
                   freights.setDriver(resultSet.getLong("driver"));
                   freights.setNote(resultSet.getString("note"));
                   freights.setProduct(resultSet.getString("product"));
                   freights.setTotal3(resultSet.getDouble("total3"));
                   freights.setWeight(resultSet.getDouble("weight"));

                   freight.add (freights) ;
               }
               resultSet.close();
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
           }
           return freight;
       }
    public final List<FreightsModel> getFreightsByProduct(String product, Long id_business, Long truck){
           PreparedStatement stmt;
           ResultSet resultSet = null;
           List<FreightsModel> freight = new ArrayList<>();
           try {
               String sql = "SELECT * FROM freights WHERE product ILIKE ? AND id_business = ? AND truck=? AND inactive = FALSE  ORDER BY data_exit DESC LIMIT " + limit_results;

               stmt = Connection.prepareStatement(sql);
               stmt.setString(1, "%" + product + "%");
               stmt.setLong(2, id_business);
               stmt.setLong(3, truck);

               resultSet = stmt.executeQuery();
               while(resultSet.next()){
                  FreightsModel freights = new FreightsModel();
                   freights.setId(resultSet.getLong("id"));
                   freights.setTruck(resultSet.getLong("truck"));
                   freights.setData_exit(resultSet.getDate("data_exit"));
                   freights.setDriver(resultSet.getLong("driver"));
                   freights.setNote(resultSet.getString("note"));
                   freights.setProduct(resultSet.getString("product"));
                   freights.setTotal3(resultSet.getDouble("total3"));
                   freights.setWeight(resultSet.getDouble("weight"));

                   freight.add (freights) ;
               }
               resultSet.close();
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
           }
           return freight;
       }

    public final List<FreightsModel> getFreightsByTruck(Long truck, Long id_business){
           PreparedStatement stmt;
           ResultSet resultSet = null;
           List<FreightsModel> freight = new ArrayList<>();
           try {
               String sql = "SELECT * FROM freights WHERE truck=? AND inactive = FALSE AND id_business=? ORDER BY data_exit DESC LIMIT " + limit_results;

               stmt = Connection.prepareStatement(sql);
               stmt.setLong(1, truck);
               stmt.setLong(2, id_business);

               resultSet = stmt.executeQuery();
               while(resultSet.next()){
                  FreightsModel freights = new FreightsModel();
                   freights.setId(resultSet.getLong("id"));
                   freights.setTruck(resultSet.getLong("truck"));
                   freights.setData_exit(resultSet.getDate("data_exit"));
                   freights.setDriver(resultSet.getLong("driver"));
                   freights.setNote(resultSet.getString("note"));
                   freights.setProduct(resultSet.getString("product"));
                   freights.setTotal3(resultSet.getDouble("total3"));
                   freights.setWeight(resultSet.getDouble("weight"));

                   freight.add (freights) ;
               }
               resultSet.close();
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
           }
           return freight;
       }

    public final FreightsModel getFreightsByIdObj(Long id, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        FreightsModel freights = new FreightsModel();
        try {
            String sql = "SELECT * FROM freights WHERE id=? AND id_business=? AND inactive = FALSE";

            stmt = Connection.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.setLong(2, id_business);

            resultSet = stmt.executeQuery();
            if(resultSet.next()){
                   freights.setId(resultSet.getLong("id"));
                   freights.setTruck(resultSet.getLong("truck"));
                   freights.setCity_destination(resultSet.getString("city_destination"));
                   freights.setCity_source(resultSet.getString("city_source"));
                   freights.setCompany_destination(resultSet.getString("company_destination"));
                   freights.setCompany_source(resultSet.getString("company_source"));
                   freights.setData_arrived(resultSet.getDate("data_arrived"));
                   freights.setData_exit(resultSet.getDate("data_exit"));
                   freights.setDiscount(resultSet.getDouble("discount"));
                   freights.setDiscount2(resultSet.getDouble("discount2"));
                   freights.setDriver(resultSet.getLong("driver"));
                   freights.setFueled(resultSet.getDouble("fueled"));
                   freights.setGross(resultSet.getDouble("gross"));
                   freights.setNote(resultSet.getString("note"));
                   freights.setPercent(resultSet.getDouble("percent"));
                   freights.setProduct(resultSet.getString("product"));
                   freights.setTotal1(resultSet.getDouble("total1"));
                   freights.setTotal2(resultSet.getDouble("total2"));
                   freights.setTotal3(resultSet.getDouble("total3"));
                   freights.setUf_destination(resultSet.getLong("uf_destination"));
                   freights.setUf_source(resultSet.getLong("uf_source"));
                   freights.setValue_t(resultSet.getDouble("value_t"));
                   freights.setWeight(resultSet.getDouble("weight"));
                   freights.setObservation(resultSet.getString("observation"));
                   freights.setMedium_fueled(resultSet.getDouble("medium_fueled"));
            }
            else {
                freights = null;
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return freights;
    }

    public int getLastIdFreight(int random, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        int id = 0;
        try {
            stmt = Connection.prepareStatement("SELECT id FROM freights WHERE random=? AND id_business=?");
            stmt.setLong(1, random);
            stmt.setLong(2, id_business);
            resultSet = stmt.executeQuery();
            if (!(resultSet.next())) return 0;
            id = resultSet.getInt("id");
        } catch (SQLException ex) {
            Logger.getLogger(TractionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
}