/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smsc.seguridad.dao;




import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.smsc.seguridad.entidades.clsPersonal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;




/**
 *
 * @author Toditos
 */
public class clsPersonalDAO {
    
    private static String NOMBRE_TABLA="PERSONAL";
    
     public static int Agregar(Context context,clsPersonal entidad)
    {
        int id = 0;
        bdSQLite admin=new bdSQLite(context,null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("int_id_personal",entidad.getInt_id_personal());
        registro.put("str_nombre",entidad.getStr_nombre());
        registro.put("str_apellido_paterno",entidad.getStr_apellido_paterno());
        registro.put("str_apellido_materno",entidad.getStr_apellido_materno());
        registro.put("str_dni",entidad.getStr_dni());
        registro.put("int_puntos",entidad.getInt_puntos());
        registro.put("dat_fecha_nacimiento",entidad.getDat_fecha_nacimiento().getTime());
        registro.put("str_nombre_distrito",entidad.getStr_nombre_distrito());
        registro.put("str_nombre_tipo_personal",entidad.getStr_nombre_tipo_personal());      
        if(entidad.getByte_foto()!=null)
            registro.put("byte_foto",entidad.getByte_foto());

        id = (int) bd.insert(NOMBRE_TABLA, null, registro);
        bd.close();    
        return id;        
    }   

  
       public static  List<clsPersonal> Listar(Context context)
     {
        List<clsPersonal> list=new ArrayList<clsPersonal>();
        bdSQLite admin=new bdSQLite(context,null); 
        SQLiteDatabase bd=admin.getWritableDatabase();
         if(bd!=null)
         {
            String query="select int_id_personal,str_nombre,str_apellido_paterno,str_apellido_materno,"
                    + "str_dni,int_puntos,dat_fecha_nacimiento,str_nombre_distrito,str_nombre_tipo_personal,"
                    + "byte_foto from "+NOMBRE_TABLA;

            Cursor fila=bd.rawQuery(query,null);
            int numRows = fila.getCount();   
            fila.moveToFirst();   
                for (int i = 0; i < numRows; ++i) 
                {   
                    clsPersonal entidad= new clsPersonal();            
                    entidad.setInt_id_personal(fila.getInt(0));
                    entidad.setStr_nombre(fila.getString(1));
                    entidad.setStr_apellido_paterno(fila.getString(2));
                    entidad.setStr_apellido_materno(fila.getString(3));
                    entidad.setStr_dni(fila.getString(4));
                    entidad.setInt_puntos(fila.getInt(5));
                    entidad.setDat_fecha_nacimiento(new Date(fila.getLong(6)));
                    entidad.setStr_nombre_distrito(fila.getString(7));
                    entidad.setStr_nombre_tipo_personal(fila.getString(8));
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
