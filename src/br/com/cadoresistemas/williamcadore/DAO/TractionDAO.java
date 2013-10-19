
package br.com.cadoresistemas.williamcadore.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.cadoresistemas.williamcadore.ConnectioFactory.ConnectionFactory;

public class TractionDAO {
    private final java.sql.Connection Connection;
        public TractionDAO(){
        this.Connection = ConnectionFactory.getConnection(1);
    }

    public ArrayList findAll(){
        Statement stmt;
        ResultSet resultSet = null;
        ArrayList list = new ArrayList();
        try {
            stmt = Connection.createStatement();
            resultSet = stmt.executeQuery("SELECT traction FROM tractions");
            while(resultSet.next()) {
                list.add(resultSet.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TractionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Long getIdTraction(String traction){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        Long id = null;
        try {
            stmt = Connection.prepareStatement("SELECT id FROM tractions WHERE traction=?");
            stmt.setString(1, traction);
            resultSet = stmt.executeQuery();
            if (!(resultSet.next())) {
                return null;
            }
            id = resultSet.getLong("id");
        } catch (SQLException ex) {
            Logger.getLogger(TractionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public String getTractionById(Long id_traction){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        String id = null;
        try {
            stmt = Connection.prepareStatement("SELECT traction FROM tractions WHERE id=?");
            stmt.setLong(1, id_traction);
            resultSet = stmt.executeQuery();
            if (!(resultSet.next())) {
                return null;
            }
            id = resultSet.getString("traction");
        } catch (SQLException ex) {
            Logger.getLogger(TractionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
}
