package br.com.cadoresistemas.williamcadore.DAO;
import br.com.cadoresistemas.williamcadore.ModelsForm.InputsModel;
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

public class InputsDAO {
  private final java.sql.Connection Connection;
  private Component rootPane;
    public InputsDAO(){

        this.Connection = ConnectionFactory.getConnection(1);
    }

    Util date = new Util();
    private String limit_results = new Paths().getConfigLimitResults();

    public void adiciona(InputsModel entradas){

        String sql = "INSERT INTO inputs (value1,value2,value3,date,received,description,truck,created_at,updated,inactive,id_business)"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        try {
            try (PreparedStatement stmt = Connection.prepareStatement(sql)) {
                stmt.setDouble(1, entradas.getValue1());
                stmt.setDouble(2, entradas.getValue2());
                stmt.setDouble(3, entradas.getValue3());
                stmt.setDate(4, date.dateFormatInsertSql(entradas.getDate()));
                stmt.setString(5, entradas.getReceived());
                stmt.setString(6, entradas.getDescription());
                stmt.setLong(7, entradas.getTrucks());
                stmt.setDate(8, date.dateFormatInsertSql(entradas.getCreated_at()));
                stmt.setDate(9, date.dateFormatInsertSql(entradas.getUpdated()));
                stmt.setBoolean(10, entradas.getInactive());
                stmt.setLong(11, entradas.getId_business());

                stmt.executeUpdate();
                stmt.close();
            }


        } catch (Exception u) {
         JOptionPane.showMessageDialog(rootPane, u.getMessage()  + ":1Contate o Administrador do Sistema!");
        }
    }

    public void atualiza(InputsModel entradas){

        String sql = "UPDATE inputs SET value1 = ?,value2 = ?,value3 = ?,date = ?,received = ?,description = ?,truck = ?,updated = ?,"
                + "inactive  = ? WHERE id_business = ? AND id = ?";

        try {
            PreparedStatement stmt = Connection.prepareStatement(sql);
                stmt.setDouble(1, entradas.getValue1());
                stmt.setDouble(2, entradas.getValue2());
                stmt.setDouble(3, entradas.getValue3());
                stmt.setDate(4, date.dateFormatInsertSql(entradas.getDate()));
                stmt.setString(5, entradas.getReceived());
                stmt.setString(6, entradas.getDescription());
                stmt.setLong(7, entradas.getTrucks());
                stmt.setDate(8, date.dateFormatInsertSql(entradas.getUpdated()));
                stmt.setBoolean(9, entradas.getInactive());
                stmt.setLong(10, entradas.getId_business());
                stmt.setLong(11, entradas.getId());

            stmt.executeUpdate();
            stmt.close();


        } catch (Exception u) {
            JOptionPane.showMessageDialog(rootPane, u.getMessage() + ":  Contate o Administrador do Sistema!");
        }
    }

    public void exclui(InputsModel entradas){

        String sql = "UPDATE inputs SET inactive = ? WHERE id = ?";

        try {
            PreparedStatement stmt = Connection.prepareStatement(sql);
            stmt.setBoolean(1, entradas.getInactive());
            stmt.setLong(2, entradas.getId());

            stmt.executeUpdate();
            stmt.close();


        } catch (Exception u) {
            JOptionPane.showMessageDialog(rootPane, u.getMessage() + ":  Contate o Administrador do Sistema!");
        }
    }

    public final List<InputsModel> getInputsByReceived(String received, Long id_business){
           PreparedStatement stmt;
           ResultSet resultSet = null;
           List<InputsModel> input = new ArrayList<>();
           try {
               String sql = "SELECT * FROM inputs WHERE received ILIKE ? AND id_business = ? AND inactive = FALSE ORDER BY date DESC LIMIT " + limit_results;

               stmt = Connection.prepareStatement(sql);
               stmt.setString(1, "%" + received + "%");
               stmt.setLong(2, id_business);

               resultSet = stmt.executeQuery();
               while(resultSet.next()){
                   InputsModel inputs = new InputsModel();
                   inputs.setId(resultSet.getLong("id"));
                   inputs.setReceived(resultSet.getString("received"));
                   inputs.setDescription(resultSet.getString("description"));
                   inputs.setTrucks(resultSet.getLong("truck"));
                   inputs.setDate(resultSet.getDate("date"));
                   inputs.setValue3(resultSet.getDouble("value3"));


                   input.add(inputs) ;
               }
               resultSet.close();
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
           }
           return input;
       }

       public final List<InputsModel> getInputsByTruck(Long truck, Long id_business){
           PreparedStatement stmt;
           ResultSet resultSet = null;
           List<InputsModel> input = new ArrayList<>();
           try {
               String sql = "SELECT * FROM inputs WHERE truck =? AND id_business = ? AND inactive = FALSE ORDER BY date DESC LIMIT " + limit_results;

               stmt = Connection.prepareStatement(sql);
               stmt.setLong(1, truck);
               stmt.setLong(2, id_business);

               resultSet = stmt.executeQuery();
               while(resultSet.next()){
                  InputsModel inputs = new InputsModel();
                   inputs.setId(resultSet.getLong("id"));
                   inputs.setReceived(resultSet.getString("received"));
                   inputs.setDescription(resultSet.getString("description"));
                   inputs.setTrucks(resultSet.getLong("truck"));
                   inputs.setDate(resultSet.getDate("date"));
                   inputs.setValue3(resultSet.getDouble("value3"));


                   input.add (inputs) ;
               }
               resultSet.close();
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
           }
           return input;
       }

       public final InputsModel getInputsByIdObj(int id, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        InputsModel inputs = new InputsModel();
        try {
            String sql = "SELECT * FROM inputs WHERE id=? AND id_business = ? AND inactive = FALSE";

            stmt = Connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setLong(2, id_business);

            resultSet = stmt.executeQuery();
            if(resultSet.next()){
                inputs.setId(resultSet.getLong("id"));
                inputs.setValue1(resultSet.getDouble("value1"));
                inputs.setValue2(resultSet.getDouble("value2"));
                inputs.setValue3(resultSet.getDouble("value3"));
                inputs.setDate(resultSet.getDate("date"));
                inputs.setReceived(resultSet.getString("received"));
                inputs.setDescription(resultSet.getString("description"));
                inputs.setTrucks(resultSet.getLong("truck"));
                inputs.setCreated_at(resultSet.getDate("created_at"));
                inputs.setUpdated(resultSet.getDate("updated"));
            }
            else {
                inputs = null;
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return inputs;
    }
}