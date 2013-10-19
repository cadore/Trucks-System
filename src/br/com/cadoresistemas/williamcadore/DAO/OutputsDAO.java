package br.com.cadoresistemas.williamcadore.DAO;

import br.com.cadoresistemas.williamcadore.ModelsForm.OutputsModel;
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

public class OutputsDAO {
 private final java.sql.Connection Connection;
 private Component rootPane;
    public OutputsDAO(){
        this.Connection = ConnectionFactory.getConnection(1);
    }

    Util date = new Util();
    private String limit_results = new Paths().getConfigLimitResults();

    public void adiciona(OutputsModel saidas){

        String sql = "INSERT INTO outputs (value1,value2,value3,date,paid,description,truck,created_at,updated,inactive,id_business,id_freight) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            try (PreparedStatement stmt = Connection.prepareStatement(sql)) {
                stmt.setDouble(1, saidas.getValue1());
                stmt.setDouble(2, saidas.getValue2());
                stmt.setDouble(3, saidas.getValue3());
                stmt.setDate(4, date.dateFormatInsertSql(saidas.getDate()));
                stmt.setString(5, saidas.getPaid());
                stmt.setString(6, saidas.getDescription());
                stmt.setLong(7, saidas.getId_truck());
                stmt.setDate(8, date.dateFormatInsertSql(saidas.getCreated_at()));
                stmt.setDate(9, date.dateFormatInsertSql(saidas.getUpdated()));
                stmt.setBoolean(10, saidas.getInactive());
                stmt.setLong(11, saidas.getId_business());
                stmt.setLong(12, saidas.getId_freight());

                stmt.executeUpdate();
                stmt.close();
            }
        } catch (Exception u) {
            JOptionPane.showMessageDialog(rootPane, u.getMessage() + ":  Contate o Administrador do Sistema!");
        }
    }

    public void atualiza(OutputsModel saidas){

        String sql = "UPDATE outputs SET value1 = ?,value2 = ?,value3 = ?,date = ?,paid = ?,description = ?,truck = ?,updated = ?,"
                + "inactive  = ? WHERE id_business = ? AND id = ?";

        try {
            PreparedStatement stmt = Connection.prepareStatement(sql);
                stmt.setDouble(1, saidas.getValue1());
                stmt.setDouble(2, saidas.getValue2());
                stmt.setDouble(3, saidas.getValue3());
                stmt.setDate(4, date.dateFormatInsertSql(saidas.getDate()));
                stmt.setString(5, saidas.getPaid());
                stmt.setString(6, saidas.getDescription());
                stmt.setLong(7, saidas.getId_truck());
                stmt.setDate(8, date.dateFormatInsertSql(saidas.getUpdated()));
                stmt.setBoolean(9, saidas.getInactive());
                stmt.setLong(10, saidas.getId_business());
                stmt.setLong(11, saidas.getId());

            stmt.executeUpdate();
            stmt.close();


        } catch (Exception u) {
            JOptionPane.showMessageDialog(rootPane, u.getMessage() + ":  Contate o Administrador do Sistema!");
        }
    }

    public void exclui(OutputsModel saidas){

        String sql = "UPDATE outputs SET inactive = ? WHERE id = ?";

        try {
            PreparedStatement stmt = Connection.prepareStatement(sql);
            stmt.setBoolean(1, saidas.getInactive());
            stmt.setLong(2, saidas.getId());

            stmt.executeUpdate();
            stmt.close();


        } catch (Exception u) {
            JOptionPane.showMessageDialog(rootPane, u.getMessage() + ":  Contate o Administrador do Sistema!");
        }
    }

    public final List<OutputsModel> getOutputsByPaid(String paid, Long id_business){
           PreparedStatement stmt;
           ResultSet resultSet = null;
           List<OutputsModel> outputs = new ArrayList<>();
           try {
               String sql = "SELECT * FROM outputs WHERE paid ILIKE ? AND id_business = ? AND inactive = FALSE AND id_freight = 0 ORDER BY date DESC LIMIT " + limit_results;

               stmt = Connection.prepareStatement(sql);
               stmt.setString(1, "%" + paid + "%");
               stmt.setLong(2, id_business);

               resultSet = stmt.executeQuery();
               while(resultSet.next()){
                   OutputsModel output = new OutputsModel();
                   output.setId(resultSet.getLong("id"));
                   output.setPaid(resultSet.getString("paid"));
                   output.setDescription(resultSet.getString("description"));
                   output.setId_truck(resultSet.getLong("truck"));
                   output.setDate(resultSet.getDate("date"));
                   output.setValue3(resultSet.getDouble("value3"));


                   outputs.add(output) ;
               }
               resultSet.close();
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
           }
           return outputs;
       }

      public final List<OutputsModel> getOutputsByTruck(Long board, Long id_business){
           PreparedStatement stmt;
           ResultSet resultSet = null;
           List<OutputsModel> outputs = new ArrayList<>();
           try {
               String sql = "SELECT * FROM outputs WHERE truck = ? AND id_business = ? AND inactive = FALSE AND id_freight = 0 ORDER BY date DESC LIMIT " + limit_results;

               stmt = Connection.prepareStatement(sql);
               stmt.setLong(1, board);
               stmt.setLong(2, id_business);

               resultSet = stmt.executeQuery();
               while(resultSet.next()){
                   OutputsModel output = new OutputsModel();
                   output.setId(resultSet.getLong("id"));
                   output.setPaid(resultSet.getString("paid"));
                   output.setDescription(resultSet.getString("description"));
                   output.setId_truck(resultSet.getLong("truck"));
                   output.setDate(resultSet.getDate("date"));
                   output.setValue3(resultSet.getDouble("value3"));


                   outputs.add(output) ;
               }
               resultSet.close();
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
           }
           return outputs;
       }

      public final List<OutputsModel> getOutputsByIdFreight(Long id_freight, Long id_business){
           PreparedStatement stmt;
           ResultSet resultSet = null;
           List<OutputsModel> outputs = new ArrayList<>();
           try {
               String sql = "SELECT * FROM outputs WHERE id_freight=? AND id_business = ? AND inactive = FALSE ORDER BY date DESC";

               stmt = Connection.prepareStatement(sql);
               stmt.setLong(1, id_freight);
               stmt.setLong(2, id_business);

               resultSet = stmt.executeQuery();
               while(resultSet.next()){
                   OutputsModel output = new OutputsModel();
                   output.setId(resultSet.getLong("id"));
                   output.setPaid(resultSet.getString("paid"));
                   output.setDescription(resultSet.getString("description"));
                   output.setId_truck(resultSet.getLong("truck"));
                   output.setDate(resultSet.getDate("date"));
                   output.setValue3(resultSet.getDouble("value3"));
                   output.setId_freight(resultSet.getLong("id_freight"));


                   outputs.add(output) ;
               }
               resultSet.close();
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
           }
           return outputs;
       }

      public final OutputsModel getOutputsByIdObj(int id, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        OutputsModel outputs = new OutputsModel();
        try {
            String sql = "SELECT * FROM outputs WHERE id=? AND id_business = ? AND inactive = FALSE";

            stmt = Connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setLong(2, id_business);

            resultSet = stmt.executeQuery();
            if(resultSet.next()){
                outputs.setId(resultSet.getLong("id"));
                outputs.setValue1(resultSet.getDouble("value1"));
                outputs.setValue2(resultSet.getDouble("value2"));
                outputs.setValue3(resultSet.getDouble("value3"));
                outputs.setDate(resultSet.getDate("date"));
                outputs.setPaid(resultSet.getString("paid"));
                outputs.setDescription(resultSet.getString("description"));
                outputs.setId_truck(resultSet.getLong("truck"));
                outputs.setCreated_at(resultSet.getDate("created_at"));
                outputs.setUpdated(resultSet.getDate("updated"));
            }
            else {
                outputs = null;
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return outputs;
    }
}