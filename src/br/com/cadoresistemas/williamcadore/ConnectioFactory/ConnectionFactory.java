package br.com.cadoresistemas.williamcadore.ConnectioFactory;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public final class ConnectionFactory {

    public static java.sql.Connection ConnectionPass;
    private static final String  driver_java = ParametersConnection.getDriver_java();
    private static final String  driver_db = ParametersConnection.getDriver_db();
    private static final String  ip_server = ParametersConnection.getIp_server();
    private static final String db = ParametersConnection.getDb();
    private static final String user_db = ParametersConnection.getUser_db();
    private static final String pwd_db = ParametersConnection.getPwd_db();

    public static java.sql.Connection getConnection(int i){
       if(ConnectionPass == null){
            try {
                Class.forName("org.postgresql.Driver");
                ConnectionPass = DriverManager.getConnection(driver_java+":"+driver_db+"://"+ip_server+"/"+db,user_db,pwd_db);
            } catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(null, ex+"\nNão foi possivel conectar ao banco de dados, por favor tente novamente."
                        + " \nSistema em Manutenção. Pedimos desculpas pelo transtorno.",
                            "CadoreSistemas", JOptionPane.INFORMATION_MESSAGE);
                if(i == -1){
                   System.exit(0);
                }
            }
       }
          return ConnectionPass;
    }

    public void resetConnection(){
        ConnectionFactory.ConnectionPass = null;
        ConnectionFactory.getConnection(1);
        JOptionPane.showMessageDialog(null, "Conexão reiniciada com sucesso!",
                            "CadoreSistemas", JOptionPane.INFORMATION_MESSAGE);
    }
}