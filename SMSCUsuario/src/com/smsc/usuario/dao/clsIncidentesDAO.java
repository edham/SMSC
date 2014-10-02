/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smsc.usuario.dao;




import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.smsc.usuario.entidades.clsIncidente;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;




/**
 *
 * @author Toditos
 */
public class clsIncidentesDAO {
    
    private static String NOMBRE_TABLA="INCIDENTE";
     public static int Agregar(Context context,clsIncidente entidad)
    {
        int id = 0;
        bdSQLite admin=new bdSQLite(context,null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("int_id_incidente",entidad.getInt_id_incidente());
        registro.put("dou_latitud",entidad.getDou_latitud());
        registro.put("dou_longitud",entidad.getDou_longitud());
        registro.put("str_detalle",entidad.getStr_detalle());
        registro.put("dat_fecha_registro",entidad.getDat_fecha_registro().getTime());
        registro.put("int_estado",entidad.getInt_estado());
        registro.put("int_id_tipo_incidente",entidad.getInt_id_tipo_incidente());
        registro.put("str_tipo_incidente_nombre",entidad.getStr_tipo_incidente_nombre());
        registro.put("int_id_usuario",entidad.getInt_id_usuario());
        
        if(entidad.getByte_foto()!=null)
            registro.put("byte_foto",entidad.getByte_foto());

        id = (int) bd.insert(NOMBRE_TABLA, null, registro);
        bd.close();    
        return id;        
    }   

  
     public static  clsIncidente Buscar(Context context,int id)
     {
        clsIncidente  entidad=null;
        bdSQLite admin=new bdSQLite(context,null); 
        SQLiteDatabase bd=admin.getWritableDatabase();
         if(bd!=null)
         {
             String query="select int_id_incidente,dou_latitud,dou_longitud,str_detalle,dat_fecha_registro,"
                     + "int_estado,int_id_tipo_incidente,str_tipo_incidente_nombre,int_id_usuario,byte_foto from "
                     +NOMBRE_TABLA+" where int_id_incidente="+id;

            Cursor fila=bd.rawQuery(query,null);
            if (fila.moveToFirst())
            {                    
                entidad= new clsIncidente();            
                entidad.setInt_id_incidente(fila.getInt(0));
                entidad.setDou_latitud(fila.getDouble(1));
                entidad.setDou_longitud(fila.getDouble(2));
                entidad.setStr_detalle(fila.getString(3));
                entidad.setDat_fecha_registro(new Date(fila.getLong(4)));
                entidad.setInt_estado(fila.getInt(5));
                entidad.setInt_id_tipo_incidente(fila.getInt(6));
                entidad.setStr_tipo_incidente_nombre(fila.getString(7));
                entidad.setInt_id_usuario(fila.getInt(8));
                entidad.setByte_foto(fila.getBlob(9));

            }
        }
        bd.close();   
        return entidad;
     }
     
     public static  List<clsIncidente> Listar(Context context,boolean personal)
     {
        List<clsIncidente> list=new ArrayList<clsIncidente>();
        bdSQLite admin=new bdSQLite(context,null); 
        SQLiteDatabase bd=admin.getWritableDatabase();
         if(bd!=null)
         {
            String query="select int_id_incidente,dou_latitud,dou_longitud,str_detalle,"
                    + "dat_fecha_registro,int_estado,int_id_tipo_incidente,str_tipo_incidente_nombre,"
                    + "int_id_usuario,byte_foto from "+NOMBRE_TABLA;
                     if(personal)
                         query+=" where int_id_usuario>0";

            Cursor fila=bd.rawQuery(query,null);
            int numRows = fila.getCount();   
            fila.moveToFirst();   
                for (int i = 0; i < numRows; ++i) 
                {   
                    clsIncidente entidad= new clsIncidente();            
                    entidad.setInt_id_incidente(fila.getInt(0));
                    entidad.setDou_latitud(fila.getDouble(1));
                    entidad.setDou_longitud(fila.getDouble(2));
                    entidad.setStr_detalle(fila.getString(3));
                    entidad.setDat_fecha_registro(new Date(fila.getLong(4)));
                    entidad.setInt_estado(fila.getInt(5));
                    entidad.setInt_id_tipo_incidente(fila.getInt(6));
                    entidad.setStr_tipo_incidente_nombre(fila.getString(7));
                    entidad.setInt_id_usuario(fila.getInt(8));
                    entidad.setByte_foto(fila.getBlob(9));
                    
                    list.add(entidad);
                       
                    fila.moveToNext();   
                }   
         }
        bd.close();   
        return list;
     }   
     
      public static  List<clsIncidente> ListarEstado(Context context,int estado)
     {
        List<clsIncidente> list=new ArrayList<clsIncidente>();
        bdSQLite admin=new bdSQLite(context,null); 
        SQLiteDatabase bd=admin.getWritableDatabase();
         if(bd!=null)
         {
            String query="select int_id_incidente,dou_latitud,dou_longitud,str_detalle,"
                    + "dat_fecha_registro,int_estado,int_id_tipo_incidente,str_tipo_incidente_nombre,"
                    + "int_id_usuario,byte_foto from "+NOMBRE_TABLA+" where int_estado="+estado;

            Cursor fila=bd.rawQuery(query,null);
            int numRows = fila.getCount();   
            fila.moveToFirst();   
                for (int i = 0; i < numRows; ++i) 
                {   
                    clsIncidente entidad= new clsIncidente();            
                    entidad.setInt_id_incidente(fila.getInt(0));
                    entidad.setDou_latitud(fila.getDouble(1));
                    entidad.setDou_longitud(fila.getDouble(2));
                    entidad.setStr_detalle(fila.getString(3));
                    entidad.setDat_fecha_registro(new Date(fila.getLong(4)));
                    entidad.setInt_estado(fila.getInt(5));
                    entidad.setInt_id_tipo_incidente(fila.getInt(6));
                    entidad.setStr_tipo_incidente_nombre(fila.getString(7));
                    entidad.setInt_id_usuario(fila.getInt(8));
                    entidad.setByte_foto(fila.getBlob(9));
                    
                    list.add(entidad);
                       
                    fila.moveToNext();   
                }   
         }
        bd.close();   
        return list;
     }   
        
     public static void Borrar(Context context) {
     bdSQLite admin=new bdSQLite(context,null);
     SQLiteDatabase bd=admin.getWritableDatabase();
     bd.delete(NOMBRE_TABLA, null, null);
     bd.close();
    }
   
}
