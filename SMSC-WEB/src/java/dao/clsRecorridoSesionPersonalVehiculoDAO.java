/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;


import entidades.clsRecorridoSesionPersonalVehiculo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author virgil
 */
public class clsRecorridoSesionPersonalVehiculoDAO {
    
    public  static int insertar(clsRecorridoSesionPersonalVehiculo entidad) throws Exception
    {
        int rpta = 0;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
            
           String sql="insert into recorrido_sesion_personal_vehiculo (id_sesion_personal_vehiculo,"
                   + "latitud,longuitud,fecha_registro) values (?,?,?,now())";
           
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            stmt.setInt(1, entidad.getInt_id_sesion_personal_vehiculo());
            stmt.setDouble(2, entidad.getDou_latitud());
            stmt.setDouble(3, entidad.getDou_longitud());

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
            } catch (Exception e) {
            }
        }
        return rpta;
    }
    
}
