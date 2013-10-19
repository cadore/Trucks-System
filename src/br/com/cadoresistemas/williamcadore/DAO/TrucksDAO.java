package br.com.cadoresistemas.williamcadore.DAO;

import br.com.cadoresistemas.williamcadore.ModelsForm.TrucksModel;
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

public class TrucksDAO {
 private final java.sql.Connection Connection;
  private Component rootPane;
    public TrucksDAO(){
        this.Connection = ConnectionFactory.getConnection(1);
    }

    Util date = new Util();
    private String limit_results = new Paths().getConfigLimitResults();

    public void adiciona(TrucksModel caminhoes){

        String sql = "INSERT INTO trucks (n_truck,board,board1,board2,board3,color,mark,model,n_chassi,n_renavam,"
                + "year_fabrication,year_fabrication1,year_fabrication2,year_fabrication3,year_model,traction_id,driver,created_at,"
                + "updated,id_business,inactive)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            try (PreparedStatement stmt = Connection.prepareStatement(sql)) {
                stmt.setLong(1, caminhoes.getN_truck());
                stmt.setString(2, caminhoes.getBoard());
                stmt.setString(3, caminhoes.getBoard1());
                stmt.setString(4, caminhoes.getBoard2());
                stmt.setString(5, caminhoes.getBoard3());
                stmt.setString(6, caminhoes.getColor());
                stmt.setString(7, caminhoes.getMark());
                stmt.setString(8, caminhoes.getModel());
                stmt.setString(9, caminhoes.getN_chassi());
                stmt.setString(10, caminhoes.getN_renavam());
                stmt.setString(11, caminhoes.getYear_fabrication());
                stmt.setString(12, caminhoes.getYear_fabrication1());
                stmt.setString(13, caminhoes.getYear_fabrication2());
                stmt.setString(14, caminhoes.getYear_fabrication3());
                stmt.setString(15, caminhoes.getYear_model());
                stmt.setLong(16, caminhoes.getTraction());
                stmt.setLong(17, caminhoes.getDriver());
                stmt.setDate(18, date.dateFormatInsertSql(caminhoes.getCreated_at()));
                stmt.setDate(19, date.dateFormatInsertSql(caminhoes.getUpdated()));
                stmt.setLong(20, caminhoes.getId_business());
                stmt.setBoolean(21, caminhoes.getInactive());

                stmt.executeUpdate();
                stmt.close();
            }


        } catch (Exception u) {
             JOptionPane.showMessageDialog(rootPane, u.getMessage() + ":  Contate o Administrador do Sistema!");
        }
    }

    public void atualiza(TrucksModel caminhoes){

        String sql = "UPDATE trucks SET n_truck=?,board = ?,board1 = ?,board2 = ?,board3 = ?,color = ?,mark = ?,model = ?,"
                + "n_chassi = ?,n_renavam = ?,year_fabrication = ?,year_fabrication1 = ?,year_fabrication2 = ?,"
                + "year_fabrication3 = ?,year_model = ?,traction_id = ?,driver = ?,updated = ?,inactive = ? WHERE id_business = ? AND id = ?";

        try {
            PreparedStatement stmt = Connection.prepareStatement(sql);
                stmt.setLong(1, caminhoes.getN_truck());
                stmt.setString(2, caminhoes.getBoard());
                stmt.setString(3, caminhoes.getBoard1());
                stmt.setString(4, caminhoes.getBoard2());
                stmt.setString(5, caminhoes.getBoard3());
                stmt.setString(6, caminhoes.getColor());
                stmt.setString(7, caminhoes.getMark());
                stmt.setString(8, caminhoes.getModel());
                stmt.setString(9, caminhoes.getN_chassi());
                stmt.setString(10, caminhoes.getN_renavam());
                stmt.setString(11, caminhoes.getYear_fabrication());
                stmt.setString(12, caminhoes.getYear_fabrication1());
                stmt.setString(13, caminhoes.getYear_fabrication2());
                stmt.setString(14, caminhoes.getYear_fabrication3());
                stmt.setString(15, caminhoes.getYear_model());
                stmt.setLong(16, caminhoes.getTraction());
                stmt.setLong(17, caminhoes.getDriver());
                stmt.setDate(18, date.dateFormatInsertSql(caminhoes.getUpdated()));
                stmt.setBoolean(19, caminhoes.getInactive());
                stmt.setLong(20, caminhoes.getId_business());
                stmt.setLong(21, caminhoes.getId());

            stmt.executeUpdate();
            stmt.close();


        } catch (Exception u) {
            JOptionPane.showMessageDialog(rootPane, u.getMessage() + ":  Contate o Administrador do Sistema!");
        }
    }

    public void exclui(TrucksModel caminhoes){

        String sql = "UPDATE trucks SET inactive = ? WHERE id = ?";

        try {
            PreparedStatement stmt = Connection.prepareStatement(sql);
            stmt.setBoolean(1, caminhoes.getInactive());
            stmt.setLong(2, caminhoes.getId());

            stmt.executeUpdate();
            stmt.close();


        } catch (Exception u) {
            JOptionPane.showMessageDialog(rootPane, u.getMessage() + ":  Contate o Administrador do Sistema!");
        }
    }

    public final List<TrucksModel> getTrucksByBoard(String board, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        List<TrucksModel> trucks = new ArrayList<>();
        try {
            String sql = "SELECT * FROM trucks WHERE board ILIKE ? AND id_business = ? AND inactive = FALSE ORDER BY board LIMIT " + limit_results;

            stmt = Connection.prepareStatement(sql);
            stmt.setString(1, "%" + board + "%");
            stmt.setLong(2, id_business);

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                TrucksModel truck = new TrucksModel();
                truck.setId(resultSet.getLong("id"));
                truck.setN_truck(resultSet.getLong("n_truck"));
                truck.setBoard(resultSet.getString("board"));
                truck.setBoard1(resultSet.getString("board1"));
                truck.setBoard2(resultSet.getString("board2"));
                truck.setBoard3(resultSet.getString("board3"));
                truck.setMark(resultSet.getString("mark"));
                truck.setModel(resultSet.getString("model"));
                truck.setColor(resultSet.getString("color"));
                truck.setTraction(resultSet.getLong("traction_id"));
                truck.setDriver(resultSet.getLong("driver"));
                truck.setN_chassi(resultSet.getString("n_chassi"));
                truck.setN_renavam(resultSet.getString("n_renavam"));
                truck.setYear_fabrication(resultSet.getString("year_fabrication"));
                truck.setYear_fabrication1(resultSet.getString("year_fabrication1"));
                truck.setYear_fabrication2(resultSet.getString("year_fabrication2"));
                truck.setYear_fabrication3(resultSet.getString("year_fabrication3"));
                truck.setYear_model(resultSet.getString("year_model"));

                trucks.add (truck) ;
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return trucks;
    }

    public final List<TrucksModel> getTrucksByProprietary(String proprietary, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        List<TrucksModel> trucks = new ArrayList<>();
        try {
            String sql = "SELECT * FROM trucks WHERE proprietary ILIKE ? AND inactive = FALSE AND id_business=? ORDER BY board LIMIT " + limit_results;

            stmt = Connection.prepareStatement(sql);
            stmt.setString(1,  "%" + proprietary + "%");
            stmt.setLong(2, id_business);

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                TrucksModel truck = new TrucksModel();
                truck.setId(resultSet.getLong("id"));
                truck.setN_truck(resultSet.getLong("n_truck"));
                truck.setBoard(resultSet.getString("board"));
                truck.setBoard1(resultSet.getString("board1"));
                truck.setBoard2(resultSet.getString("board2"));
                truck.setBoard3(resultSet.getString("board3"));
                truck.setMark(resultSet.getString("mark"));
                truck.setModel(resultSet.getString("model"));
                truck.setColor(resultSet.getString("color"));
                truck.setTraction(resultSet.getLong("traction_id"));
                truck.setDriver(resultSet.getLong("driver"));
                truck.setN_chassi(resultSet.getString("n_chassi"));
                truck.setN_renavam(resultSet.getString("n_renavam"));
                truck.setYear_fabrication(resultSet.getString("year_fabrication"));
                truck.setYear_fabrication1(resultSet.getString("year_fabrication1"));
                truck.setYear_fabrication2(resultSet.getString("year_fabrication2"));
                truck.setYear_fabrication3(resultSet.getString("year_fabrication3"));
                truck.setYear_model(resultSet.getString("year_model"));

                trucks.add (truck) ;
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return trucks;
    }

    public final List<TrucksModel> getTrucksByModel(String model, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        List<TrucksModel> trucks = new ArrayList<>();
        try {
            String sql = "SELECT * FROM trucks WHERE model ILIKE ? AND inactive = FALSE AND id_business=? ORDER BY board LIMIT " + limit_results;

            stmt = Connection.prepareStatement(sql);
            stmt.setString(1, "%" + model + "%");
            stmt.setLong(2, id_business);

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
              TrucksModel truck = new TrucksModel();
                truck.setId(resultSet.getLong("id"));
                truck.setN_truck(resultSet.getLong("n_truck"));
                truck.setBoard(resultSet.getString("board"));
                truck.setBoard1(resultSet.getString("board1"));
                truck.setBoard2(resultSet.getString("board2"));
                truck.setBoard3(resultSet.getString("board3"));
                truck.setMark(resultSet.getString("mark"));
                truck.setModel(resultSet.getString("model"));
                truck.setColor(resultSet.getString("color"));
                truck.setTraction(resultSet.getLong("traction_id"));
                truck.setDriver(resultSet.getLong("driver"));
                truck.setN_chassi(resultSet.getString("n_chassi"));
                truck.setN_renavam(resultSet.getString("n_renavam"));
                truck.setYear_fabrication(resultSet.getString("year_fabrication"));
                truck.setYear_fabrication1(resultSet.getString("year_fabrication1"));
                truck.setYear_fabrication2(resultSet.getString("year_fabrication2"));
                truck.setYear_fabrication3(resultSet.getString("year_fabrication3"));
                truck.setYear_model(resultSet.getString("year_model"));

                trucks.add (truck) ;
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return trucks;
    }

    public final List<TrucksModel> getTrucksByMark(String mark, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        List<TrucksModel> trucks = new ArrayList<>();
        try {
            String sql = "SELECT * FROM trucks WHERE mark ILIKE ? AND inactive = FALSE AND id_business=? ORDER BY board LIMIT " + limit_results;

            stmt = Connection.prepareStatement(sql);
            stmt.setString(1,  "%" + mark + "%");
            stmt.setLong(2, id_business);

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
               TrucksModel truck = new TrucksModel();
                truck.setId(resultSet.getLong("id"));
                truck.setN_truck(resultSet.getLong("n_truck"));
                truck.setBoard(resultSet.getString("board"));
                truck.setBoard1(resultSet.getString("board1"));
                truck.setBoard2(resultSet.getString("board2"));
                truck.setBoard3(resultSet.getString("board3"));
                truck.setMark(resultSet.getString("mark"));
                truck.setModel(resultSet.getString("model"));
                truck.setColor(resultSet.getString("color"));
                truck.setTraction(resultSet.getLong("traction_id"));
                truck.setDriver(resultSet.getLong("driver"));
                truck.setN_chassi(resultSet.getString("n_chassi"));
                truck.setN_renavam(resultSet.getString("n_renavam"));
                truck.setYear_fabrication(resultSet.getString("year_fabrication"));
                truck.setYear_fabrication1(resultSet.getString("year_fabrication1"));
                truck.setYear_fabrication2(resultSet.getString("year_fabrication2"));
                truck.setYear_fabrication3(resultSet.getString("year_fabrication3"));
                truck.setYear_model(resultSet.getString("year_model"));

                trucks.add (truck) ;
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return trucks;
    }

    public Long getTruckByBoard(String board, Long id_business) {
        PreparedStatement stmt;
        ResultSet resultSet = null;
        long id = 0;
        try {
            String sql = "SELECT id FROM trucks WHERE board=? AND id_business = ? AND inactive = FALSE ORDER BY board LIMIT " + limit_results;

            stmt = Connection.prepareStatement(sql);
            stmt.setString(1, board);
            stmt.setLong(2, id_business);

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                id = resultSet.getLong("id");
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return id;
    }

    public final TrucksModel getTrucksByIdObj(int id, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        TrucksModel trucks = new TrucksModel();
        try {
            String sql = "SELECT * FROM trucks WHERE id=? AND id_business = ? AND inactive = FALSE";

            stmt = Connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setLong(2, id_business);

            resultSet = stmt.executeQuery();
            if(resultSet.next()){
                trucks.setId(resultSet.getLong("id"));
                trucks.setN_truck(resultSet.getLong("n_truck"));
                trucks.setBoard(resultSet.getString("board"));
                trucks.setBoard1(resultSet.getString("board1"));
                trucks.setBoard2(resultSet.getString("board2"));
                trucks.setBoard3(resultSet.getString("board3"));
                trucks.setMark(resultSet.getString("mark"));
                trucks.setModel(resultSet.getString("model"));
                trucks.setColor(resultSet.getString("color"));
                trucks.setTraction(resultSet.getLong("traction_id"));
                trucks.setDriver(resultSet.getLong("driver"));
                trucks.setN_chassi(resultSet.getString("n_chassi"));
                trucks.setN_renavam(resultSet.getString("n_renavam"));
                trucks.setYear_fabrication(resultSet.getString("year_fabrication"));
                trucks.setYear_fabrication1(resultSet.getString("year_fabrication1"));
                trucks.setYear_fabrication2(resultSet.getString("year_fabrication2"));
                trucks.setYear_fabrication3(resultSet.getString("year_fabrication3"));
                trucks.setYear_model(resultSet.getString("year_model"));
                trucks.setCreated_at(resultSet.getDate("created_at"));
                trucks.setUpdated(resultSet.getDate("updated"));
            }
            else {
                trucks = null;
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return trucks;
    }

    public ArrayList findAll(Long id_business){
        Statement stmt;
        ResultSet resultSet = null;
        ArrayList list = new ArrayList();
        try {
            stmt = Connection.createStatement();
            resultSet = stmt.executeQuery("SELECT board FROM trucks WHERE  inactive = FALSE AND id_business = "+id_business);
            while(resultSet.next()) {
                list.add(resultSet.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TractionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Long getIDTruck(String board){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        Long id = null;
        try {
            stmt = Connection.prepareStatement("SELECT id FROM trucks WHERE board=? AND inactive = FALSE");
            stmt.setString(1, board);
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

    public Long getNumberTruck(String board){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        Long n_truck = null;
        try {
            stmt = Connection.prepareStatement("SELECT n_truck FROM trucks WHERE board=? AND inactive = FALSE");
            stmt.setString(1, board);
            resultSet = stmt.executeQuery();
            if (!(resultSet.next())) return null;
            n_truck = resultSet.getLong("n_truck");
        } catch (SQLException ex) {
            Logger.getLogger(TractionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n_truck;
    }

    public String getBoardTruckById(Long id){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        String truck = null;
        try {
            stmt = Connection.prepareStatement("SELECT board FROM trucks WHERE id=? AND inactive = FALSE");
            stmt.setLong(1, id);
            resultSet = stmt.executeQuery();
            if (!(resultSet.next())) return null;
            truck = resultSet.getString("board");
        } catch (SQLException ex) {
            Logger.getLogger(TractionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return truck;
    }

    public Long getLastNTruck(Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        Long n_truck = Long.valueOf(0);
        try {
            stmt = Connection.prepareStatement("SELECT n_truck FROM trucks WHERE id_business = ? ORDER BY n_truck DESC");
            stmt.setLong(1, id_business);

            resultSet = stmt.executeQuery();
            if (!(resultSet.next())) {
                return Long.valueOf(0);
            }
            n_truck = resultSet.getLong("n_truck");
        } catch (SQLException ex) {
            Logger.getLogger(TractionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n_truck;
    }

    public int getNumberOfTrucks(Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        int number = 0;
        try {
            String sql = "SELECT COUNT(*) AS qnt_trucks FROM trucks WHERE inactive = FALSE AND id_business=?";

            stmt = Connection.prepareStatement(sql);
            stmt.setLong(1, id_business);

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                 number = resultSet.getInt("qnt_trucks");
            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return number;
    }

    public final Long getN_truckisValidDB(Long n_truck, Long id_business){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        Long trucks = null;
        try {
            String sql = "SELECT n_truck FROM trucks WHERE n_truck=? AND id_business=?";

            stmt = Connection.prepareStatement(sql);
            stmt.setLong(1, n_truck);
            stmt.setLong(2, id_business);

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                trucks = resultSet.getLong("n_truck");

            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return trucks;
    }

    public final String getBoardTruckisValidDB(String board){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        String trucks = null;
        try {
            String sql = "SELECT board FROM trucks WHERE board=?";

            stmt = Connection.prepareStatement(sql);
            stmt.setString(1, board);

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                trucks = resultSet.getString("board");

            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return trucks;
    }

    public final String getN_renavamTruckisValidDB(String n_renavan){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        String trucks = null;
        try {
            String sql = "SELECT n_renavam FROM trucks WHERE n_renavam=?";

            stmt = Connection.prepareStatement(sql);
            stmt.setString(1, n_renavan);

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                trucks = resultSet.getString("n_renavam");

            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return trucks;
    }

    public final String getN_chassiTruckisValidDB(String n_chassi){
        PreparedStatement stmt;
        ResultSet resultSet = null;
        String trucks = null;
        try {
            String sql = "SELECT n_chassi FROM trucks WHERE n_chassi=?";

            stmt = Connection.prepareStatement(sql);
            stmt.setString(1, n_chassi);

            resultSet = stmt.executeQuery();
            while(resultSet.next()){
                trucks = resultSet.getString("n_chassi");

            }
            resultSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"erro",JOptionPane.WARNING_MESSAGE);
        }
        return trucks;
    }
}