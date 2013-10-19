package br.com.cadoresistemas.williamcadore.DAO;

import br.com.cadoresistemas.williamcadore.ModelsForm.FueledModel;
import br.com.cadoresistemas.williamcadore.Utils.Util;
import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import br.com.cadoresistemas.williamcadore.ConnectioFactory.ConnectionFactory;

public class FueledDAO {
  private final java.sql.Connection Connection;
    public FueledDAO(){
        this.Connection = ConnectionFactory.getConnection(1);
    }

    private Util u = new Util();
    private JTextField jtf = new JTextField();

    public void adiciona(FueledModel abastecimento){

        String sql = "INSERT INTO fueled (id_freight,date,station,city,uf,km,liters,rs_liters,total,created_at,updated,id_business,"
                + "inactive,id_truck,discount,sub_total) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            try (PreparedStatement stmt = Connection.prepareStatement(sql)) {
                stmt.setLong(1, abastecimento.getIdFreight());
                stmt.setDate(2, u.dateFormatInsertSql(abastecimento.getDate()));
                stmt.setString(3, abastecimento.getStation());
                stmt.setString(4, abastecimento.getCity());
                stmt.setLong(5, abastecimento.getUf());
                stmt.setDouble(6, abastecimento.getKm());
                stmt.setDouble(7, abastecimento.getLiters());
                stmt.setDouble(8, abastecimento.getRs_liter());
                stmt.setDouble(9, abastecimento.getTotal());
                stmt.setDate(10, u.dateFormatInsertSql(abastecimento.getCreated_at()));
                stmt.setDate(11, u.dateFormatInsertSql(abastecimento.getUpdated()));
                stmt.setLong(12, abastecimento.getId_business());
                stmt.setBoolean(13, abastecimento.getInactive());
                stmt.setLong(14, abastecimento.getIdTruck());
                stmt.setDouble(15, abastecimento.getDiscount());
                stmt.setDouble(16, abastecimento.getSub_total());

                stmt.executeUpdate();
                stmt.close();
            }


        } catch (Exception u) {
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane, u.getMessage() + ":  Contate o Administrador do Sistema!");
        }
    }

    public void excluiById(FueledModel abastecidas){

        String sql = "DELETE FROM fueled WHERE id =? AND id_business=?";

        try {
            PreparedStatement stmt = Connection.prepareStatement(sql);
            stmt.setLong(1, abastecidas.getId());
            stmt.setLong(2, abastecidas.getId_business());
            stmt.executeUpdate();
            stmt.close();

        } catch (Exception u) {
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane, u.getMessage() + ": Contate o Administrador do Sistema!");
        }
    }

    public final List<FueledModel> getFueled(Long id_freight, Long id_business, Long id_truck){
           PreparedStatement stmt;
           ResultSet resultSet = null;
           List<FueledModel> fueleds = new ArrayList<>();
           try {
               String sql = "SELECT * FROM fueled WHERE id_freight=? AND id_business=? AND id_truck = ? AND inactive = FALSE ORDER BY date DESC";

               stmt = Connection.prepareStatement(sql);
               stmt.setLong(1, id_freight);
               stmt.setLong(2, id_business);
               stmt.setLong(3, id_truck);

               resultSet = stmt.executeQuery();
               while(resultSet.next()){
                   FueledModel fueled = new FueledModel();
                   fueled.setId(resultSet.getLong("id"));
                   fueled.setDate(resultSet.getDate("date"));
                   fueled.setStation(resultSet.getString("station"));
                   fueled.setLiters(resultSet.getDouble("liters"));
                   fueled.setRs_liter(resultSet.getDouble("rs_liters"));
                   fueled.setTotal(resultSet.getDouble("total"));
                   fueled.setKm(resultSet.getDouble("km"));
                   fueled.setDiscount(resultSet.getDouble("discount"));
                   fueled.setSub_total(resultSet.getDouble("sub_total"));

                   fueleds.add (fueled) ;
               }
               resultSet.close();
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
           }
           return fueleds;
       }

    public Double getMAXKMFreight(Long id_freight, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        Double max = null;
        try {
            String sql = "SELECT MAX(km) AS max FROM fueled WHERE id_freight = ? AND id_business = ?";

            stmt = Connection.prepareStatement(sql);
            stmt.setLong(1, id_freight);
            stmt.setLong(2, id_business);

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                max = resultSet.getDouble("max");
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Erro",JOptionPane.WARNING_MESSAGE);
        }
        return max;
    }

    public Double getMINKMFreight(Long id_freight, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        Double max = null;
        try {
            String sql = "SELECT MIN(km) AS min FROM fueled WHERE id_freight = ? AND id_business = ?";

            stmt = Connection.prepareStatement(sql);
            stmt.setLong(1, id_freight);
            stmt.setLong(2, id_business);

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                max = resultSet.getDouble("min");
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Erro",JOptionPane.WARNING_MESSAGE);
        }
        return max;
    }
}