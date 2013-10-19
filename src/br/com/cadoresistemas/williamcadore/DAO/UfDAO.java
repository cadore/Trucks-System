package br.com.cadoresistemas.williamcadore.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.cadoresistemas.williamcadore.ConnectioFactory.ConnectionFactory;

public class UfDAO {
    private final java.sql.Connection Connection;
        public UfDAO(){
        this.Connection = ConnectionFactory.getConnection(1);
    }
    public ArrayList findAll(){
        Statement stmt;
        ResultSet resultSet = null;
        ArrayList list = new ArrayList();
        try {
            stmt = Connection.createStatement();
            resultSet = stmt.executeQuery("SELECT district FROM districts ORDER BY id");
            while(resultSet.next()) {
                list.add(resultSet.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UfDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Long getIDUf(String traction){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        Long id = null;
        try {
            stmt = Connection.prepareStatement("SELECT id FROM districts WHERE district=?");
            stmt.setString(1, traction);
            resultSet = stmt.executeQuery();
            if (!(resultSet.next())) return null;
            id = resultSet.getLong("id");
        } catch (SQLException ex) {
            Logger.getLogger(UfDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public String getUfById(Long uf){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        String id = null;
        try {
            stmt = Connection.prepareStatement("SELECT district FROM districts WHERE id=?");
            stmt.setLong(1, uf);
            resultSet = stmt.executeQuery();
            if (!(resultSet.next())) return null;
            id = resultSet.getString("district");
        } catch (SQLException ex) {
            Logger.getLogger(UfDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
}
