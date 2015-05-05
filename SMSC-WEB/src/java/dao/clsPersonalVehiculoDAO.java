/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;


import entidades.clsDetallePersonalVehiculo;
import entidades.clsDistrito;
import entidades.clsPersonal;
import entidades.clsPersonalVehiculo;
import entidades.clsRecorridoSesionPersonalVehiculo;
import entidades.clsPersonalVehiculo;
import entidades.clsTipoPersonal;
import entidades.clsPersonalVehiculo;
import entidades.clsVehiculo;
import java.sql.Blob;
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
public class clsPersonalVehiculoDAO {
    
   public static List<clsPersonalVehiculo> listar(boolean estado) throws Exception 
    {
        List<clsPersonalVehiculo> listar = null;
        
        Connection conn =null;
        CallableStatement stmt = null;        
        ResultSet dr = null;
        try {
               String sql="select pv.id_personal_vehiculo,pv.estado,pv.id_vehiculo,"
                       + "v.marca,v.modelo,v.placa,v.numero from personal_vehiculo pv "
                       + "inner join vehiculo v on pv.id_vehiculo=v.id_vehiculo";
                 if(estado)
                    sql+=" where pv.estado=0";

            conn = clsConexion.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {   
                if(listar==null)
                    listar = new ArrayList<clsPersonalVehiculo>();
                clsVehiculo objVehiculo = new clsVehiculo();
                objVehiculo.setInt_id_vehiculo(dr.getInt(3));
                objVehiculo.setStr_marca(dr.getString(4));
                objVehiculo.setStr_modelo(dr.getString(5));
                objVehiculo.setStr_placa(dr.getString(6));
                objVehiculo.setStr_numero(dr.getString(7));
                
                clsPersonalVehiculo objPersonalVehiculo = new clsPersonalVehiculo();
                objPersonalVehiculo.setInt_id_personal_vehiculo(dr.getInt(1));
                objPersonalVehiculo.setInt_estado(dr.getInt(2));
                objPersonalVehiculo.setObjVehiculo(objVehiculo);
                listar.add(objPersonalVehiculo);
                
                 List<clsDetallePersonalVehiculo> lista=null;
                sql="select dpv.id_detalle_personal_vehiculo,dpv.id_personal_vehiculo,p.id_personal,p.nombre,p.apellido_paterno,\n" +
                    "p.apellido_materno,p.telefono,p.celular,p.email,p.direccion,p.dni,p.clave,p.puntos,p.foto,p.fecha_nacimiento,\n" +
                    "p.fecha_registro,p.fecha_actualizacion,p.estado,p.id_tipo_personal,tp.nombre,p.id_distrito,d.nombre from \n" +
                    "personal p inner join detalle_personal_vehiculo dpv on p.id_personal=dpv.id_personal inner join tipo_personal \n" +
                    "tp on p.id_tipo_personal=tp.id_tipo_personal inner join distrito d on p.id_distrito=d.id_distrito \n" +
                    "where dpv.id_personal_vehiculo="+objPersonalVehiculo.getInt_id_personal_vehiculo();

                CallableStatement csDetalle = conn.prepareCall(sql);
                ResultSet rsDetalle = csDetalle.executeQuery();
                
                while(rsDetalle.next())
                {
                    if(lista==null)
                        lista=new ArrayList<clsDetallePersonalVehiculo>();
                    clsDistrito objDistrito = new clsDistrito();
                    objDistrito.setInt_id_distrito(rsDetalle.getInt(21));
                    objDistrito.setStr_nombre(rsDetalle.getString(22));
                    
                    clsTipoPersonal objTipoPersonal = new clsTipoPersonal();
                    objTipoPersonal.setInt_id_tipo_personal(rsDetalle.getInt(19));
                    objTipoPersonal.setStr_nombre(rsDetalle.getString(20));
                    
                    clsPersonal objPersonal = new clsPersonal();
                    objPersonal.setInt_id_personal(rsDetalle.getInt(3));
                    objPersonal.setStr_nombre(rsDetalle.getString(4));
                    objPersonal.setStr_apellido_paterno(rsDetalle.getString(5));
                    objPersonal.setStr_apellido_materno(rsDetalle.getString(6));
                    objPersonal.setStr_telefono(rsDetalle.getString(7));
                    objPersonal.setStr_celular(rsDetalle.getString(8));
                    objPersonal.setStr_email(rsDetalle.getString(9));
                    objPersonal.setStr_direccion(rsDetalle.getString(10));
                    objPersonal.setStr_dni(rsDetalle.getString(11));
                    objPersonal.setStr_clave(rsDetalle.getString(12));
                    objPersonal.setInt_puntos(rsDetalle.getInt(13));
                    
                    Blob image = rsDetalle.getBlob(14);
                    objPersonal.setByte_foto(image.getBytes(1,(int)image.length()));
                    objPersonal.setDat_fecha_nacimiento(rsDetalle.getTimestamp(15)); 
                    objPersonal.setDat_fecha_registro(rsDetalle.getTimestamp(16)); 
                    objPersonal.setDat_fecha_actualizacion(rsDetalle.getTimestamp(17)); 
                    objPersonal.setInt_estado(rsDetalle.getInt(18));
                    objPersonal.setObjTipoPersonal(objTipoPersonal);
                    objPersonal.setObjDistrito(objDistrito);
                    
                    clsDetallePersonalVehiculo objDetallePersonalVehiculo = new clsDetallePersonalVehiculo();
                    objDetallePersonalVehiculo.setId_detalle_personal_vehiculo(rsDetalle.getInt(1));
                    objDetallePersonalVehiculo.setId_personal_vehiculo(rsDetalle.getInt(2));
                    objDetallePersonalVehiculo.setObjPersonal(objPersonal);
                    lista.add(objDetallePersonalVehiculo);
                }
                csDetalle.close();
                rsDetalle.close();
                
                objPersonalVehiculo.setLista(lista);
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
   
    public  static int insertar(int idVehiculo) throws Exception
    {
        int rpta = 0;
        Connection conn =null;
        PreparedStatement stmt = null;
        try {
            
           String sql="INSERT INTO personal_vehiculo(id_vehiculo,fecha_registro,estado)"
                   + "VALUES(?,now(),0);";
           
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1,idVehiculo);
           
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
    
     public  static int insertarDetalle(int idVehiculoVehiculo,int idPersonal) throws Exception
    {
        int rpta = 0;
        Connection conn =null;
        PreparedStatement stmt = null;
        try {
            
           String sql="INSERT INTO detalle_personal_vehiculo(id_personal_vehiculo,id_personal)"
                   + "VALUES(?,?);";
           
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1,idVehiculoVehiculo);
            stmt.setInt(2,idPersonal);
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
      public static boolean quitar(int IdDetalle) throws Exception
    {
        boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
             String sql="delete from detalle_personal_vehiculo where id_detalle_personal_vehiculo= ?";
             
            conn = clsConexion.getConnection();
            stmt = conn.prepareCall(sql);             
             stmt.setInt(1,IdDetalle);
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
