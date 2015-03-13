/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;


import entidades.clsVehiculo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author virgil
 */
public class clsVehiculoDAO {
  
    public static List<clsVehiculo> listar(boolean estado) throws Exception 
    {
        List<clsVehiculo> listar = null;
        
        Connection conn =null;
        CallableStatement stmt = null;        
        ResultSet dr = null;
        try {
               String sql="select id_vehiculo,marca,modelo,placa,numero,fecha_registro,fecha_actualizacion,estado from vehiculo";
                 if(estado)
                    sql+=" where estado=0";

            conn = clsConexion.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {   
                if(listar==null)
                    listar = new ArrayList<clsVehiculo>();
                
                clsVehiculo objPersonal = new clsVehiculo();
                objPersonal.setInt_id_vehiculo(dr.getInt(1));
                objPersonal.setStr_marca(dr.getString(2));
                objPersonal.setStr_modelo(dr.getString(3));
                objPersonal.setStr_placa(dr.getString(4));
                objPersonal.setStr_numero(dr.getString(5));               
                objPersonal.setDat_fecha_registro(dr.getTimestamp(6)); 
                objPersonal.setDat_fecha_actualizacion(dr.getTimestamp(7)); 
                objPersonal.setInt_estado(dr.getInt(8));
                
                listar.add(objPersonal);
            }

          conn.commit();
        } catch (Exception e) {
             if (conn != null) {
                    conn.rollback();
                }
            throw new Exception("Insertar"+e.getMessage(), e);
        }
        finally{
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
            }
        }
        return listar;
    }
     
    public  static int insertar(clsVehiculo entidad) throws Exception
    {
        int rpta = 0;
        Connection conn =null;
        PreparedStatement stmt = null;
        try {
            
           String sql="INSERT INTO vehiculo(marca,modelo,placa,numero,fecha_registro,fecha_actualizacion,estado)"
                   + "VALUES(?,?,?,?,now(),now(),0);";
           
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, entidad.getStr_marca());
            stmt.setString(2, entidad.getStr_modelo());
            stmt.setString(3, entidad.getStr_placa());
            stmt.setString(4, entidad.getStr_numero());
           
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()){
                rpta=rs.getInt(1);
            }
            rs.close();
        } catch (Exception e) {
            throw new Exception("Insertar"+e.getMessage(), e);
        }
        finally{
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
            }
        }
        return rpta;
    } 
      
    public static boolean actualizar(clsVehiculo entidad) throws Exception
    {
        boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
               String sql="UPDATE vehiculo set marca=?,modelo=?,placa=?,numero=?,"
                       + "fecha_actualizacion=now(),estado=? where id_vehiculo=?";
               
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);             
            stmt.setString(1, entidad.getStr_marca());
            stmt.setString(2, entidad.getStr_modelo());
            stmt.setString(3, entidad.getStr_placa());
            stmt.setString(4, entidad.getStr_numero());;
            stmt.setInt(5, entidad.getInt_estado());
            stmt.setInt(6, entidad.getInt_id_vehiculo());
            
           rpta = stmt.executeUpdate() == 1;
        } catch (Exception e) {
            throw new Exception("Error Actualizar "+e.getMessage(), e);
        }
        finally{
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
            }
        }
        return rpta;
    }
}
