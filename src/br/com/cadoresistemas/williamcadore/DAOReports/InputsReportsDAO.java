package br.com.cadoresistemas.williamcadore.DAOReports;

import br.com.cadoresistemas.williamcadore.ModelsForm.InputsModel;
import br.com.cadoresistemas.williamcadore.Utils.Util;
import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import br.com.cadoresistemas.williamcadore.ConnectioFactory.ConnectionFactory;

public class InputsReportsDAO {
    private final java.sql.Connection Connection;
    private Component rootPane;
    public InputsReportsDAO(){
        this.Connection = ConnectionFactory.getConnection(1);
    }

    Util date = new Util();

    public InputsModel getReportsInputs(Date first, Date last,Long id_truck, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        InputsModel inputs = new InputsModel();
        try {
            String sql = "SELECT count(*) AS qnt, SUM(value1) AS value1, SUM(value2) AS value2, SUM(value3) AS value3"
                    + " FROM inputs WHERE truck = ? AND id_business = ? AND inactive = FALSE AND date BETWEEN ? AND ?";
            stmt = Connection.prepareStatement(sql);
            stmt.setLong(1, id_truck);
            stmt.setLong(2, id_business);
            stmt.setDate(3, date.dateFormatInsertSql(first));
            stmt.setDate(4, date.dateFormatInsertSql(last));

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                inputs.setQnt(resultSet.getInt("qnt"));
                inputs.setValue1(resultSet.getDouble("value1"));
                inputs.setValue2(resultSet.getDouble("value2"));
                inputs.setValue3(resultSet.getDouble("value3"));
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return inputs;
    }
}