/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;


import entidades.clsDepartamento;
import entidades.clsDistrito;
import entidades.clsPersonal;
import entidades.clsProvincia;
import entidades.clsTipoPersonal;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
                Blob image = dr.getBlob(12);
                objPersonal.setByte_foto(image.getBytes(1,(int)image.length())); 
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

     public static List<clsPersonal> listar(boolean estado) throws Exception 
    {
        List<clsPersonal> listar = null;
        
        Connection conn =null;
        CallableStatement stmt = null;        
        ResultSet dr = null;
        try {
               String sql="select p.id_personal,p.nombre,p.apellido_paterno,p.apellido_materno,p.telefono,p.celular,\n" +
                "p.email,p.direccion,p.dni,p.clave,p.puntos,p.foto,p.fecha_nacimiento,p.fecha_registro,\n" +
                "p.fecha_actualizacion,p.estado,p.id_tipo_personal,tp.nombre,p.id_distrito,d.nombre,pro.id_provincia,"+ 
                "pro.nombre,de.id_departamento,de.nombre from \n" +
                "personal p inner join tipo_personal tp on p.id_tipo_personal=tp.id_tipo_personal inner join \n" +
                "distrito d on p.id_distrito=d.id_distrito inner join provincia pro on pro.id_provincia=d.id_provincia "+ 
                "inner join departamento de on de.id_departamento=pro.id_departamento  where p.id_personal>1";
                 if(estado)
                    sql+=" and  p.estado=0";

       
            conn = clsConexion.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {   
                if(listar==null)
                    listar = new ArrayList<clsPersonal>();
                
                clsDepartamento objclsDepartamento = new clsDepartamento();
                objclsDepartamento.setInt_id_departamento(dr.getInt(23));
                objclsDepartamento.setStr_nombre(dr.getString(24));
                
                clsProvincia objProvincia = new clsProvincia();
                objProvincia.setInt_id_provincia(dr.getInt(21));
                objProvincia.setStr_nombre(dr.getString(22));
                objProvincia.setObjDepartamento(objclsDepartamento);
                
                
                clsDistrito objDistrito = new clsDistrito();
                objDistrito.setInt_id_distrito(dr.getInt(19));
                objDistrito.setStr_nombre(dr.getString(20));
                objDistrito.setObjProvincia(objProvincia);
                
                clsTipoPersonal objTipoPersonal = new clsTipoPersonal();
                objTipoPersonal.setInt_id_tipo_personal(dr.getInt(17));
                objTipoPersonal.setStr_nombre(dr.getString(18));

                clsPersonal objPersonal = new clsPersonal();
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
                Blob image = dr.getBlob(12);
                objPersonal.setByte_foto(image.getBytes(1,(int)image.length())); 
                objPersonal.setDat_fecha_nacimiento(dr.getTimestamp(13)); 
                objPersonal.setDat_fecha_registro(dr.getTimestamp(14)); 
                objPersonal.setDat_fecha_actualizacion(dr.getTimestamp(15)); 
                objPersonal.setInt_estado(dr.getInt(16));
                objPersonal.setObjTipoPersonal(objTipoPersonal);
                objPersonal.setObjDistrito(objDistrito);
                    listar.add(objPersonal);
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
        return listar;
    }
     
      public static List<clsPersonal> listarxAsignar() throws Exception 
    {
        List<clsPersonal> listar = null;
        
        Connection conn =null;
        CallableStatement stmt = null;        
        ResultSet dr = null;
        try {
               String sql="select p.id_personal,p.nombre,p.apellido_paterno,p.apellido_materno,"
                       + "p.telefono,p.celular,p.email,p.direccion,p.dni,p.clave,p.puntos,p.foto,"
                       + "p.fecha_nacimiento,p.fecha_registro,p.fecha_actualizacion,p.estado,"
                       + "p.id_tipo_personal,tp.nombre,p.id_distrito,d.nombre,pro.id_provincia,"
                       + "pro.nombre,de.id_departamento,de.nombre from personal p inner join "
                       + "tipo_personal tp on p.id_tipo_personal=tp.id_tipo_personal inner join "
                       + "distrito d on p.id_distrito=d.id_distrito inner join provincia pro on "
                       + "pro.id_provincia=d.id_provincia inner join departamento de on "
                       + "de.id_departamento=pro.id_departamento left join detalle_personal_vehiculo "
                       + "dpv on p.id_personal=dpv.id_personal where dpv.id_detalle_personal_vehiculo "
                       + "is null and p.id_tipo_personal=2";

       
            conn = clsConexion.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {   
                if(listar==null)
                    listar = new ArrayList<clsPersonal>();
                
                clsDepartamento objclsDepartamento = new clsDepartamento();
                objclsDepartamento.setInt_id_departamento(dr.getInt(23));
                objclsDepartamento.setStr_nombre(dr.getString(24));
                
                clsProvincia objProvincia = new clsProvincia();
                objProvincia.setInt_id_provincia(dr.getInt(21));
                objProvincia.setStr_nombre(dr.getString(22));
                objProvincia.setObjDepartamento(objclsDepartamento);
                
                
                clsDistrito objDistrito = new clsDistrito();
                objDistrito.setInt_id_distrito(dr.getInt(19));
                objDistrito.setStr_nombre(dr.getString(20));
                objDistrito.setObjProvincia(objProvincia);
                
                clsTipoPersonal objTipoPersonal = new clsTipoPersonal();
                objTipoPersonal.setInt_id_tipo_personal(dr.getInt(17));
                objTipoPersonal.setStr_nombre(dr.getString(18));

                clsPersonal objPersonal = new clsPersonal();
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
                Blob image = dr.getBlob(12);
                objPersonal.setByte_foto(image.getBytes(1,(int)image.length())); 
                objPersonal.setDat_fecha_nacimiento(dr.getTimestamp(13)); 
                objPersonal.setDat_fecha_registro(dr.getTimestamp(14)); 
                objPersonal.setDat_fecha_actualizacion(dr.getTimestamp(15)); 
                objPersonal.setInt_estado(dr.getInt(16));
                objPersonal.setObjTipoPersonal(objTipoPersonal);
                objPersonal.setObjDistrito(objDistrito);
                    listar.add(objPersonal);
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
        return listar;
    }
     
      public  static int insertar(clsPersonal entidad) throws Exception
    {
        int rpta = 0;
        Connection conn =null;
        PreparedStatement stmt = null;
        try {
            
           String sql="INSERT INTO personal (id_tipo_personal,id_distrito,nombre,"
                   + "apellido_paterno,apellido_materno,telefono,celular,email,"
                   + "direccion,dni,clave,puntos,fecha_nacimiento,fecha_registro,"
                   + "fecha_actualizacion,estado,foto)"
                   + "VALUES(?,?,?,?,?,?,?,?,?,?,?,0,?,now(),now(),0,?);";
           
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, entidad.getObjTipoPersonal().getInt_id_tipo_personal());
            stmt.setInt(2, entidad.getObjDistrito().getInt_id_distrito());
            stmt.setString(3, entidad.getStr_nombre());
            stmt.setString(4, entidad.getStr_apellido_paterno());
            stmt.setString(5, entidad.getStr_apellido_materno());
            stmt.setString(6, entidad.getStr_telefono());
            stmt.setString(7, entidad.getStr_celular());
            stmt.setString(8, entidad.getStr_email());
            stmt.setString(9, entidad.getStr_direccion());
            stmt.setString(10, entidad.getStr_dni());
            stmt.setString(11, entidad.getStr_clave());
            stmt.setDate(12, new Date(entidad.getDat_fecha_nacimiento().getTime()));
            stmt.setBytes(13, entidad.getByte_foto());
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
      
    public static boolean actualizar(clsPersonal entidad) throws Exception
    {
        boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
             String sql="UPDATE personal SET id_tipo_personal=?,id_distrito=?,nombre=?,"
                     + "apellido_paterno=?,apellido_materno=?,telefono=?,celular=?,"
                     + "email=?,direccion=?,dni=?,clave=?,fecha_nacimiento=?"
                     + ",fecha_actualizacion=now(),estado=?,foto=? WHERE id_personal = ?";
             
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);             
             stmt.setInt(1, entidad.getObjTipoPersonal().getInt_id_tipo_personal());
            stmt.setInt(2, entidad.getObjDistrito().getInt_id_distrito());
            stmt.setString(3, entidad.getStr_nombre());
            stmt.setString(4, entidad.getStr_apellido_paterno());
            stmt.setString(5, entidad.getStr_apellido_materno());
            stmt.setString(6, entidad.getStr_telefono());
            stmt.setString(7, entidad.getStr_celular());
            stmt.setString(8, entidad.getStr_email());
            stmt.setString(9, entidad.getStr_direccion());
            stmt.setString(10, entidad.getStr_dni());
            stmt.setString(11, entidad.getStr_clave());
            stmt.setDate(12, new Date(entidad.getDat_fecha_nacimiento().getTime()));
            stmt.setInt(13, entidad.getInt_estado());
            
            stmt.setBytes(14, entidad.getByte_foto());
            stmt.setInt(15, entidad.getInt_id_personal());
           rpta = stmt.executeUpdate() == 1;
        } catch (Exception e) {
            throw new Exception("Error Actualizar "+e.getMessage(), e);
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
