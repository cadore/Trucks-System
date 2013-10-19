package br.com.cadoresistemas.williamcadore.ConnectioFactory;

public final class ParametersConnection {

    public static String getDriver_java(){
        return "jdbc";
    }
    public static String getDriver_db(){
            return "postgresql";
    }
   /* public static String  getIp_server(){
        return "pgsql01.redehost.com.br";
    }*/
    public static String getIp_server(){
        return "localhost";
    }
    public static String getDb(){
        return "cadoresistemas.com.br_truck_system";
    }
    public static String getUser_db(){
        return "truck_system";
    }
    public static String getPwd_db(){
        return "a1s2d3f4g5cadore()";
    }
}
