/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;


import entidades.clsDistrito;
import entidades.clsPersonal;
import entidades.clsTipoPersonal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author virgil
 */
public class clsPersonalDAO {
    public static clsPersonal login(String dni,String clave) throws Exception 
    {
        clsPersonal objPersonal = null;
        
        Connection conn =null;
        CallableStatement stmt = null;        
        ResultSet dr = null;
        try {
             String sql="select p.id_personal,p.nombre,p.apellido_paterno,p.apellido_materno,p.telefono,p.celular,\n" +
                "p.email,p.direccion,p.dni,p.clave,p.puntos,p.foto,p.fecha_nacimiento,p.fecha_registro,\n" +
                "p.fecha_actualizacion,p.estado,p.id_tipo_personal,tp.nombre,p.id_distrito,d.nombre from \n" +
                "personal p inner join tipo_personal tp on p.id_tipo_personal=tp.id_tipo_personal inner join \n" +
                "distrito d on p.id_distrito=d.id_distrito where p.id_tipo_personal=1 and  p.dni='"+dni+"' \n" +
                "and p.clave='"+clave+"'";

            conn = clsConexion.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            if(dr.next())
            {   
                clsDistrito objDistrito = new clsDistrito();
                    objDistrito.setInt_id_distrito(dr.getInt(19));
                    objDistrito.setStr_nombre(dr.getString(20));
                    
                    clsTipoPersonal objTipoPersonal = new clsTipoPersonal();
                    objTipoPersonal.setInt_id_tipo_personal(dr.getInt(17));
                    objTipoPersonal.setStr_nombre(dr.getString(18));
                    
                    objPersonal = new clsPersonal();
                    objPersonal.setInt_id_personal(dr.getInt(1));
                    objPersonal.setStr_nombre(dr.getString(2));
                    objPersonal.setStr_apellido_paterno(dr.getString(3));
                    objPersonal.setStr_apellido_materno(dr.getString(4));
                    objPersonal.setStr_telefono(dr.getString(5));
                    objPersonal.setStr_celular(dr.getString(6));
                    objPersonal.setStr_email(dr.getString(7));
                    objPersonal.setStr_direccion(dr.getString(8));
                    objPersonal.setStr_dni(dr.getString(9));
                    objPersonal.setStr_clave(dr.getString(10));
                    objPersonal.setInt_puntos(dr.getInt(11));
                    objPersonal.setByte_foto(dr.getBytes(12));
                    objPersonal.setDat_fecha_nacimiento(dr.getTimestamp(13)); 
                    objPersonal.setDat_fecha_registro(dr.getTimestamp(14)); 
                    objPersonal.setDat_fecha_actualizacion(dr.getTimestamp(15)); 
                    objPersonal.setInt_estado(dr.getInt(16));
                    objPersonal.setObjTipoPersonal(objTipoPersonal);
                    objPersonal.setObjDistrito(objDistrito);
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
        return objPersonal;
    }
    
}
