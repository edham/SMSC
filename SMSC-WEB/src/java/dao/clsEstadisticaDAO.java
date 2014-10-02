/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;


import entidades.clsEstadistica;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author virgil
 */
public class clsEstadisticaDAO {
 
     public static clsEstadistica get() throws Exception 
    {
        clsEstadistica entidad = new clsEstadistica();
        
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
             String sql="select (select count(*) from incidente where estado=0),\n" +
                        "(select count(*) from incidente where estado=1),\n" +
                        "(select count(*) from incidente where estado=2),\n" +
                        "(select count(*) from incidente where estado=3),\n" +
                        "(select count(*) from sesion_personal_vehiculo where estado=0)";

            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            if(dr.next())
            {   
                entidad.setInt_incidente_enviado(dr.getInt(1));
                entidad.setInt_incidente_progeso(dr.getInt(2));
                entidad.setInt_incidente_valido(dr.getInt(3));
                entidad.setInt_incidente_invalido(dr.getInt(4));
                entidad.setInt_total_sesiones(dr.getInt(5));
            }

       } catch (Exception e) {
    
                throw new Exception("Listar Cargos "+e.getMessage(), e);
        
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return entidad;
    }
    
}
