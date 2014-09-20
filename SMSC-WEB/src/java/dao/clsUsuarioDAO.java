/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;


import entidades.clsUsuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
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
}
