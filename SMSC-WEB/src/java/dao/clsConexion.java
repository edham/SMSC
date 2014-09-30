package dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class clsConexion {
    public static String driver = "com.mysql.jdbc.Driver";
    public static String url = "jdbc:mysql://192.168.1.5:3306/smsc_bd";
    public static String usuario = "root";
    public static String clave = "123456";
    //public static String url = "jdbc:mysql://192.168.1.191:3306/crud";
    //public static String usuario = "seguridad815";
    //public static String clave = "cajamarc@";
    
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
