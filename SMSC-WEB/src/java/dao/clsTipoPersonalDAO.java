/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;


import entidades.clsTipoPersonal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author virgil
 */
public class clsTipoPersonalDAO {
    
    public static List<clsTipoPersonal> listar() throws Exception 
    {
        List<clsTipoPersonal> lista = null;
        
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
             String sql="SELECT id_tipo_personal,nombre,descripcion,estado FROM tipo_personal;";

            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {   
                if(lista==null)
                    lista = new ArrayList<clsTipoPersonal>();
                
                clsTipoPersonal objclsTipoPersonal = new clsTipoPersonal();
                objclsTipoPersonal.setInt_id_tipo_personal(dr.getInt(1));
                objclsTipoPersonal.setStr_nombre(dr.getString(2));
                objclsTipoPersonal.setStr_descripcion(dr.getString(3));    
                objclsTipoPersonal.setInt_estado(dr.getInt(4)); 
                lista.add(objclsTipoPersonal);                
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
    
  
}
