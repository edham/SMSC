/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;


import entidades.clsIncidente;
import entidades.clsTipoIncidente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
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
                     + "i.foto,ti.id_tipo_incidente,ti.nombre FROM incidente i inner join tipo_incidente ti "
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
}
