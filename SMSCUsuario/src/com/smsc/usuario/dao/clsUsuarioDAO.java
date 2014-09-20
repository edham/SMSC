/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smsc.usuario.dao;




import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.smsc.usuario.entidades.clsUsuario;
import java.util.Date;




/**
 *
 * @author Toditos
 */
public class clsUsuarioDAO {
    
    private static String NOMBRE_TABLA="USUARIO";
    
     public static int Agregar(Context context,clsUsuario entidad)
    {
        int id = 0;
        bdSQLite admin=new bdSQLite(context,null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        if(bd!=null)
        {
            ContentValues registro=new ContentValues();
            registro.put("int_id_usuario",entidad.getInt_id_usuario());
            registro.put("str_nombre",entidad.getStr_nombre());
            registro.put("str_apellido",entidad.getStr_apellido());
            registro.put("str_email",entidad.getStr_email());
            registro.put("str_celular",entidad.getStr_celular());
            registro.put("str_dni",entidad.getStr_dni());
            registro.put("dat_fecha_nacimiento",entidad.getDat_fecha_nacimiento().getTime());
            if(entidad.isBool_sexo())
                registro.put("bool_sexo",1);
            else
                registro.put("bool_sexo",0);
            id = (int) bd.insert(NOMBRE_TABLA, null, registro);
        }
        bd.close();  
        return id;
        
    }   
   
     public static  clsUsuario Buscar(Context context)
     {
        clsUsuario  entidad=null;
        bdSQLite admin=new bdSQLite(context,null); 
        SQLiteDatabase bd=admin.getWritableDatabase();
         if(bd!=null)
         {
            String query="select int_id_usuario,str_nombre,str_apellido,str_email,str_celular,"
                    + "str_dni,dat_fecha_nacimiento,bool_sexo from "+NOMBRE_TABLA;

            Cursor fila=bd.rawQuery(query,null);

            if (fila.moveToFirst())
            {                    
                entidad= new clsUsuario();            
                entidad.setInt_id_usuario(fila.getInt(0));
                entidad.setStr_nombre(fila.getString(1));
                entidad.setStr_apellido(fila.getString(2));
                entidad.setStr_email(fila.getString(3));
                entidad.setStr_celular(fila.getString(4));
                entidad.setStr_dni(fila.getString(5));
                entidad.setDat_fecha_nacimiento(new Date(fila.getLong(6)));          
                if(fila.getInt(7)==1)                
                entidad.setBool_sexo(true);
                else
                entidad.setBool_sexo(false);
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
