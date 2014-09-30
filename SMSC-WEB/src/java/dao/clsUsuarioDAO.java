/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;


import entidades.clsUsuario;
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
public class clsUsuarioDAO {
    public static clsUsuario login(String dni,String clave) throws Exception 
    {
        clsUsuario objclsUsuario = null;
        
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
             String sql="select id_usuario,nombre,apellido,email,celular,dni,sexo,clave,fecha_nacimiento,fecha_registro,"
                     + "cantidad_falso,estado from usuario where dni like '"+dni+"' and clave like '"+clave+"'";

            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            if(dr.next())
            {   
                objclsUsuario = new clsUsuario();
                objclsUsuario.setInt_id_usuario(dr.getInt(1));
                objclsUsuario.setStr_nombre(dr.getString(2));
                objclsUsuario.setStr_apellido(dr.getString(3));
                objclsUsuario.setStr_email(dr.getString(4));
                objclsUsuario.setStr_celular(dr.getString(5));      
                objclsUsuario.setStr_dni(dr.getString(6));      
                objclsUsuario.setBool_sexo(dr.getBoolean(7));
                objclsUsuario.setStr_clave(dr.getString(8));  
                objclsUsuario.setDat_fecha_nacimiento(dr.getTimestamp(9)); 
                objclsUsuario.setDat_fecha_registro(dr.getTimestamp(10)); 
                objclsUsuario.setInt_cantidad_falso(dr.getInt(11));
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
        return objclsUsuario;
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
