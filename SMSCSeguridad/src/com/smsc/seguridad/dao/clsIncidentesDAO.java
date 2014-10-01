/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smsc.seguridad.dao;




import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.smsc.seguridad.entidades.clsIncidente;
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
        registro.put("str_usuario_nombre",entidad.getStr_usuario_nombre());
        registro.put("str_usuario_apellido",entidad.getStr_usuario_apellido());
        registro.put("str_usuario_celular",entidad.getStr_usuario_celular());
        registro.put("str_usuario_dni",entidad.getStr_usuario_dni());
        registro.put("str_usuario_email",entidad.getStr_usuario_email());
        registro.put("int_id_respuesta_incidente",entidad.getInt_id_respuesta_incidente());
        registro.put("dat_usuario_fecha_nacimiento",entidad.getDat_usuario_fecha_nacimiento().getTime());
        if(entidad.isBool_usuario_sexo())
                registro.put("bool_usuario_sexo",1);
            else
                registro.put("bool_usuario_sexo",0);
        
        if(entidad.getByte_foto()!=null)
            registro.put("byte_foto",entidad.getByte_foto());

        
        id = (int) bd.insert(NOMBRE_TABLA, null, registro);
        bd.close();    
        return id;        
    }   

  
     public static  clsIncidente Buscar(Context context)
     {
        clsIncidente  entidad=null;
        bdSQLite admin=new bdSQLite(context,null); 
        SQLiteDatabase bd=admin.getWritableDatabase();
         if(bd!=null)
         {
             String query="select int_id_incidente,dou_latitud,dou_longitud,str_detalle,dat_fecha_registro,"
                     + "int_estado,int_id_tipo_incidente,str_tipo_incidente_nombre,int_id_usuario,str_usuario_nombre,"
                     + "str_usuario_apellido,str_usuario_celular,str_usuario_dni,str_usuario_email,dat_usuario_fecha_nacimiento,"
                     + "bool_usuario_sexo,byte_foto,int_id_respuesta_incidente from "+NOMBRE_TABLA;

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
                entidad.setStr_usuario_nombre(fila.getString(9));
                entidad.setStr_usuario_apellido(fila.getString(10));
                entidad.setStr_usuario_celular(fila.getString(11));
                entidad.setStr_usuario_dni(fila.getString(12));
                entidad.setStr_usuario_email(fila.getString(13));
                entidad.setDat_usuario_fecha_nacimiento(new Date(fila.getLong(14)));
                 if(fila.getInt(15)==1)                
                entidad.setBool_usuario_sexo(true);
                else
                entidad.setBool_usuario_sexo(false);
                entidad.setByte_foto(fila.getBlob(16));
                entidad.setInt_id_respuesta_incidente(fila.getInt(17));
            }
        }
        bd.close();   
        return entidad;
     }
     
   
        
     public static void Borrar(Context context) {
     bdSQLite admin=new bdSQLite(context,null);
     SQLiteDatabase bd=admin.getWritableDatabase();
     bd.delete(NOMBRE_TABLA, null, null);
     bd.close();
    }
   
}
