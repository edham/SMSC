/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;


import entidades.clsPersonalVehiculo;
import entidades.clsSesionPersonalVehiculo;
import entidades.clsUsuario;
import entidades.clsVehiculo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author virgil
 */
public class clsSesionPersonalVehiculoDAO {
    public static clsSesionPersonalVehiculo login(String dni,String clave) throws Exception 
    {
        clsSesionPersonalVehiculo objSesionPersonalVehiculo = null;
        
        Connection conn =null;
        CallableStatement stmt = null;        
        ResultSet dr = null;
        try {
             String sql="select spv.id_sesion_personal_vehiculo,spv.fecha_entrada,spv.fecha_salida,spv.estado,pv.id_personal_vehiculo,\n" +
                        "pv.fecha_registro,pv.estado,pv.id_vehiculo,v.placa,v.numero,v.modelo,v.marca,v.fecha_registro,v.fecha_actualizacion,\n" +
                        "v.estado from sesion_personal_vehiculo spv  right join personal_vehiculo pv on spv.id_personal_vehiculo=pv.id_personal_vehiculo\n" +
                        "inner join vehiculo v on pv.id_vehiculo=v.id_vehiculo inner join detalle_personal_vehiculo dpv on\n" +
                        "pv.id_personal_vehiculo=dpv.id_personal_vehiculo inner join personal p on p.id_personal=dpv.id_personal\n" +
                        "where p.dni='"+dni+"' and p.clave='"+clave+"' order by spv.id_sesion_personal_vehiculo desc limit 1";

            conn = clsConexion.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            if(dr.next())
            {   boolean registro=true;
                objSesionPersonalVehiculo = new clsSesionPersonalVehiculo();
                
                clsVehiculo objVehiculo = new clsVehiculo();                
                objVehiculo.setInt_id_vehiculo(dr.getInt(8));
                objVehiculo.setStr_placa(dr.getString(9));
                objVehiculo.setStr_numero(dr.getString(10));
                objVehiculo.setStr_modelo(dr.getString(11));
                objVehiculo.setStr_marca(dr.getString(12));
                objVehiculo.setDat_fecha_registro(dr.getTimestamp(13)); 
                objVehiculo.setDat_fecha_actualizacion(dr.getTimestamp(14)); 
                objVehiculo.setInt_estado(dr.getInt(15));
                
                clsPersonalVehiculo objPersonalVehiculo = new clsPersonalVehiculo();
                objPersonalVehiculo.setInt_id_personal_vehiculo(dr.getInt(5));
                objPersonalVehiculo.setDat_fecha_registro(dr.getTimestamp(6)); 
                objPersonalVehiculo.setInt_estado(dr.getInt(7));  
                objPersonalVehiculo.setObjVehiculo(objVehiculo);
                
                if(dr.getInt(1)!=0)
                {
                    
                    objSesionPersonalVehiculo.setInt_sesion_personal_vehiculo(dr.getInt(1));
                    objSesionPersonalVehiculo.setDat_fecha_entrada(dr.getTimestamp(2)); 
                    objSesionPersonalVehiculo.setDat_fecha_salida(dr.getTimestamp(3)); 
                    objSesionPersonalVehiculo.setInt_estado(dr.getInt(4));
                    if(objSesionPersonalVehiculo.getInt_estado()!=0)
                    {
                        registro=false;
                    }
                       
                }
                else
                {
                    registro=false;
                }
                
                if(!registro)
                {
                    objSesionPersonalVehiculo.setDat_fecha_entrada(new Date()); 
                    objSesionPersonalVehiculo.setDat_fecha_salida(new Date()); 
                    objSesionPersonalVehiculo.setInt_estado(0);
                    
                    sql="INSERT INTO sesion_personal_vehiculo(id_personal_vehiculo,fecha_entrada,fecha_salida,estado)"
                        + " VALUES(?,now(),now(),0);";
                    PreparedStatement psInsertaSession = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    psInsertaSession.setInt(1, objPersonalVehiculo.getInt_id_personal_vehiculo());
                    psInsertaSession.executeUpdate();
           
                    ResultSet rsInsertaSession = psInsertaSession.getGeneratedKeys();
                    if (rsInsertaSession.next()){                        
                        objSesionPersonalVehiculo.setInt_sesion_personal_vehiculo(rsInsertaSession.getInt(1));                    }
                    rsInsertaSession.close();
                    psInsertaSession.close();
                }
                
                
                
                
                
                
                objSesionPersonalVehiculo.setObjPersonalVehiculo(objPersonalVehiculo);  
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
        return objSesionPersonalVehiculo;
    }
    
    public  static int insertar(clsUsuario entidad) throws Exception
    {
        int rpta = 0;
        Connection conn =null;
        PreparedStatement stmt = null;
        try {
            
           String sql="INSERT INTO usuario (nombre,apellido,email,celular,dni,sexo,clave,"
                   + "fecha_nacimiento,fecha_registro,cantidad_falso,estado)"
                   + "VALUES(?,?,?,?,?,?,?,?,now(),0,0);";
           
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, entidad.getStr_nombre());
            stmt.setString(2, entidad.getStr_apellido());
            stmt.setString(3, entidad.getStr_email());
            stmt.setString(4, entidad.getStr_celular());
            stmt.setString(5, entidad.getStr_dni());
            stmt.setBoolean(6, entidad.isBool_sexo());
            stmt.setString(7, entidad.getStr_clave());
            stmt.setDate(8, new java.sql.Date(entidad.getDat_fecha_nacimiento().getTime()));
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
}
