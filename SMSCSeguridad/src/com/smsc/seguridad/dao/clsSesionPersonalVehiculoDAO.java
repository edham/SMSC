/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smsc.seguridad.dao;




import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.smsc.seguridad.entidades.clsSesionPersonalVehiculo;
import java.util.Date;




/**
 *
 * @author Toditos
 */
public class clsSesionPersonalVehiculoDAO {
    
    private static String NOMBRE_TABLA="SESION_PERSONAL_VEHICULO";
     public static int Agregar(Context context,clsSesionPersonalVehiculo entidad)
    {
        int id = 0;
        bdSQLite admin=new bdSQLite(context,null);
        SQLiteDatabase bd=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("int_sesion_personal_vehiculo",entidad.getInt_sesion_personal_vehiculo());
        registro.put("dat_fecha_entrada",entidad.getDat_fecha_entrada().getTime());
        registro.put("str_vehiculoe_marca",entidad.getStr_vehiculoe_marca());
        registro.put("str_vehiculoe_modelo",entidad.getStr_vehiculoe_modelo());
        registro.put("str_vehiculoe_placa",entidad.getStr_vehiculoe_placa());
        registro.put("str_vehiculoe_numero",entidad.getStr_vehiculoe_numero());
       

        id = (int) bd.insert(NOMBRE_TABLA, null, registro);
        bd.close();    
        return id;        
    }   

  
     public static  clsSesionPersonalVehiculo Buscar(Context context)
     {
        clsSesionPersonalVehiculo  entidad=null;
        bdSQLite admin=new bdSQLite(context,null); 
        SQLiteDatabase bd=admin.getWritableDatabase();
         if(bd!=null)
         {
             String query="select int_sesion_personal_vehiculo,dat_fecha_entrada,str_vehiculoe_marca,"
                     + "str_vehiculoe_modelo,str_vehiculoe_placa,str_vehiculoe_numero from "+NOMBRE_TABLA;

            Cursor fila=bd.rawQuery(query,null);
            if (fila.moveToFirst())
            {                    
                entidad= new clsSesionPersonalVehiculo();            
                entidad.setInt_sesion_personal_vehiculo(fila.getInt(0));
                entidad.setDat_fecha_entrada(new Date(fila.getLong(1)));
                entidad.setStr_vehiculoe_marca(fila.getString(2));
                entidad.setStr_vehiculoe_modelo(fila.getString(3));
                entidad.setStr_vehiculoe_placa(fila.getString(4));
                entidad.setStr_vehiculoe_numero(fila.getString(5));
               
               
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
