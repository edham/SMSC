/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;


import entidades.clsIncidente;
import entidades.clsTipoIncidente;
import entidades.clsUsuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author virgil
 */
public class clsIncidenteDAO {
    
    public static List<clsIncidente> listarXUsuario(int IdUsuario) throws Exception 
    {
        List<clsIncidente> lista = null;
        
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
             String sql="SELECT i.id_incidente,i.latitud,i.longuitud,i.detalle,i.fecha_registro,i.estado,"
                     + "i.foto,ti.id_tipo_incidente,ti.nombre,i.rapides,i.conformidad FROM incidente i inner join tipo_incidente ti "
                     + "on i.id_tipo_incidente=ti.id_tipo_incidente where i.id_usuario="+IdUsuario;

            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {   
                if(lista==null)
                    lista = new ArrayList<clsIncidente>();
                
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
                objclsIncidente.setInt_rapides(dr.getInt(10));
                objclsIncidente.setInt_conformidad(dr.getInt(10));
                
                lista.add(objclsIncidente);                
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
        return lista;
    }
    
     public static List<clsIncidente> listarXEstado(int estado,int IdUsuario) throws Exception 
    {
        List<clsIncidente> lista = null;
        
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
             String sql="SELECT i.id_incidente,i.latitud,i.longuitud,i.detalle,i.fecha_registro,i.estado,\n" +
                        "i.foto,ti.id_tipo_incidente,ti.nombre,u.id_usuario,u.apellido,u.nombre,u.celular,\n" +
                        "u.dni,u.email,u.fecha_nacimiento,u.sexo,i.rapides,i.conformidad FROM incidente i inner join tipo_incidente \n" +
                        "ti on i.id_tipo_incidente=ti.id_tipo_incidente inner join usuario u on\n" +
                        "u.id_usuario=i.id_usuario where i.estado="+estado;
                        if(IdUsuario>0)
                            sql+=" and i.id_usuario!="+IdUsuario;

            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {   
                if(lista==null)
                    lista = new ArrayList<clsIncidente>();
                
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
                objclsIncidente.setInt_rapides(dr.getInt(18));
                objclsIncidente.setInt_conformidad(dr.getInt(19));
                objclsIncidente.setObjTipoIncidente(objTipoIncidente);
                objclsIncidente.setObjUsuario(objUsuario);
                lista.add(objclsIncidente);                
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
        return lista;
    }
     public  static int insertar(clsIncidente entidad) throws Exception
    {
        int rpta = 0;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
            
           String sql="insert into incidente (id_tipo_incidente,id_usuario,latitud,"
                   + "longuitud,detalle,foto,fecha_registro,estado,rapides,conformidad) values"
                   + "(?,?,?,?,?,?,now(),0,0,0)";
           
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            stmt.setInt(1, entidad.getObjTipoIncidente().getInt_id_tipo_incidente());
            stmt.setInt(2, entidad.getObjUsuario().getInt_id_usuario());
            stmt.setDouble(3, entidad.getDou_latitud());
            stmt.setDouble(4, entidad.getDou_longitud());
            stmt.setString(5, entidad.getStr_detalle());
            stmt.setBytes(6,entidad.getByte_foto());

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
    
    public static boolean calificar(clsIncidente entidad) throws Exception
    {
        boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
             String sql="UPDATE incidente SET rapides = ?,conformidad = ? WHERE id_incidente = ? and id_usuario = ?";
            conn = clsConexion.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareCall(sql);
            stmt.setInt(1, entidad.getInt_rapides());
            stmt.setInt(2, entidad.getInt_conformidad());
            stmt.setInt(3, entidad.getInt_id_incidente());
            stmt.setInt(4, entidad.getObjUsuario().getInt_id_usuario());
            rpta = stmt.executeUpdate() == 1;          
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
