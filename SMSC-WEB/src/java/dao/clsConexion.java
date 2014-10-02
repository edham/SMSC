package dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class clsConexion {
    public static String driver = "com.mysql.jdbc.Driver";
    public static String url = "jdbc:mysql://204.93.216.11:3306/servitec1_smsc";
    public static String usuario = "servitec1_admin";
    public static String clave = "@123Soltrux123";
    
    public clsConexion() {
    }
    public static Connection getConnection() throws Exception{
        Connection cnn = null;
        try {
             Class.forName(driver);
            cnn=DriverManager.getConnection(url,usuario,clave);
            System.out.println("conexion establecida");
        } catch (Exception e) {
             System.out.println("no se pùdo establecer la conexion");
            System.exit(0);
        }
             return cnn;
    }

}
