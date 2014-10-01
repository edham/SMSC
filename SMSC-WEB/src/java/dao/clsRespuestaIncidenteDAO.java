/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;


import entidades.clsIncidente;
import entidades.clsRespuestaIncidente;
import entidades.clsTipoIncidente;
import entidades.clsUsuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author virgil
 */
public class clsRespuestaIncidenteDAO {

     public static clsRespuestaIncidente pendiente(int IdSesion) throws Exception 
    {
       
        clsRespuestaIncidente entidad=null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
             String sql="SELECT i.id_incidente,i.latitud,i.longuitud,i.detalle,i.fecha_registro,i.estado,\n" +
                        "i.foto,ti.id_tipo_incidente,ti.nombre,u.id_usuario,u.apellido,u.nombre,u.celular,\n" +
                        "u.dni,u.email,u.fecha_nacimiento,u.sexo,ri.id_respuesta_incidente FROM respuesta_incidente \n" +
                        "ri inner join incidente i on ri.id_incidente=i.id_incidente inner join tipo_incidente \n" +
                        "ti on i.id_tipo_incidente=ti.id_tipo_incidente inner join usuario u on\n" +
                        "u.id_usuario=i.id_usuario where ri.estado=1 and ri.id_sesion_personal_vehiculo="+IdSesion;

            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            if(dr.next())
            {   
                
                
                clsUsuario objUsuario = new clsUsuario();
                objUsuario.setInt_id_usuario(dr.getInt(10));
                objUsuario.setStr_apellido(dr.getString(11));
                objUsuario.setStr_nombre(dr.getString(12));
                objUsuario.setStr_celular(dr.getString(13));
                objUsuario.setStr_dni(dr.getString(14));
                objUsuario.setStr_email(dr.getString(15));
                objUsuario.setDat_fecha_nacimiento(dr.getTimestamp(16));      
                objUsuario.setBool_sexo(dr.getBoolean(17));
                
                clsTipoIncidente objTipoIncidente = new clsTipoIncidente();
                objTipoIncidente.setInt_id_tipo_incidente(dr.getInt(8));
                objTipoIncidente.setStr_nombre(dr.getString(9));
                
                clsIncidente objclsIncidente = new clsIncidente();
                objclsIncidente.setInt_id_incidente(dr.getInt(1));
                objclsIncidente.setDou_latitud(dr.getDouble(2));
                objclsIncidente.setDou_longitud(dr.getDouble(3));
                objclsIncidente.setStr_detalle(dr.getString(4));
                objclsIncidente.setDat_fecha_registro(dr.getTimestamp(5));      
                objclsIncidente.setInt_estado(dr.getInt(6)); 
                objclsIncidente.setByte_foto(dr.getBytes(7));
                objclsIncidente.setObjTipoIncidente(objTipoIncidente);
                objclsIncidente.setObjUsuario(objUsuario);
                
                entidad = new clsRespuestaIncidente();
                entidad.setObjIncidente(objclsIncidente);
                entidad.setInt_id_respuesta_incidente(dr.getInt(18));
                
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
     public  static int insertar(clsRespuestaIncidente entidad) throws Exception
    {
        int rpta = 0;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
            
           String sql="insert into respuesta_incidente (id_incidente,id_sesion_personal_vehiculo,fecha_creacion,"
                   + "fecha_finalizacion,estado) values (?,?,now(),now(),1)";
           
            conn = clsConexion.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareCall(sql);
            stmt.setInt(1, entidad.getObjIncidente().getInt_id_incidente());
            stmt.setInt(2, entidad.getObjSesionPersonalVehiculo().getInt_sesion_personal_vehiculo());
            stmt.executeUpdate();
           
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()){
                rpta=rs.getInt(1);
                 sql="update incidente set estado=1 where id_incidente=?;";
                    PreparedStatement psEstadoIncidente = conn.prepareCall(sql);          
                    psEstadoIncidente.setInt(1, entidad.getObjIncidente().getInt_id_incidente());
                    psEstadoIncidente.execute();
                    psEstadoIncidente.close();
            }
            rs.close();
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
        return rpta;
    }
     
        public static boolean actualizar(clsRespuestaIncidente entidad) throws Exception
    {
        boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
             String sql="UPDATE respuesta_incidente SET fecha_finalizacion = now(), descripcion = ?,"
                     + "foto =?,estado = ? WHERE id_respuesta_incidente = ?";
            conn = clsConexion.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareCall(sql);
            stmt.setString(1, entidad.getStr_descripccion());
            stmt.setBytes(2, entidad.getByte_foto());
            stmt.setInt(3, entidad.getInt_estado());     
            stmt.setInt(4, entidad.getInt_id_respuesta_incidente());     

           rpta = stmt.executeUpdate() == 1;
           if(rpta)
           {
               sql="update incidente set estado=? where id_incidente=?;";
                    PreparedStatement psEstadoIncidente = conn.prepareCall(sql);
                    psEstadoIncidente.setInt(1, entidad.getInt_estado());
                    psEstadoIncidente.setInt(2, entidad.getObjIncidente().getInt_id_incidente());
                    psEstadoIncidente.execute();
                    psEstadoIncidente.close();
               
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
        return rpta;
    }
}
