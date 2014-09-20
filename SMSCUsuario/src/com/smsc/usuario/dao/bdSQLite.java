package com.smsc.usuario.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class bdSQLite extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "SMSCUsuario"; 
    private static final int DATABASE_VERSION = 1;        

        private static final String CREATE_USUARIO = "CREATE TABLE USUARIO ("
                                + "int_id_usuario integer NOT NULL PRIMARY KEY,"
                                + "str_nombre text NOT NULL,"
                                + "str_apellido text NOT NULL,"
                                + "str_email text NOT NULL,"
                                + "str_celular text NOT NULL,"
                                + "str_dni text NOT NULL,"
                                + "dat_fecha_nacimiento numeric NOT NULL,"
                                + "bool_sexo integer NOT NULL)";
        
        private static final String CREATE_INCIDENTE = "CREATE TABLE INCIDENTE ("
                                + "int_id_incidente integer NOT NULL PRIMARY KEY,"
                                + "dou_latitud numeric NOT NULL,"
                                + "dou_longitud numeric NOT NULL,"
                                + "str_detalle text NOT NULL,"
                                + "dat_fecha_registro numeric NOT NULL,"
                                + "int_estado integer NOT NULL,"
                                + "int_id_tipo_incidente integer NOT NULL,"
                                + "str_tipo_incidente_nombre text NOT NULL,"
                                + "int_id_usuario integer NOT NULL,"
                                + "byte_foto blob)";

	public bdSQLite(Context context, CursorFactory factory) {
		super(context, DATABASE_NAME, factory, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
                db.execSQL(CREATE_USUARIO);
                db.execSQL(CREATE_INCIDENTE);
                
        }   
         
	@Override
	public void onUpgrade(SQLiteDatabase db, int versionAnte, int versionNue) {

                db.execSQL("drop table if exists USUARIO");
                db.execSQL(CREATE_USUARIO);
                
                db.execSQL("drop table if exists INCIDENTE");
                db.execSQL(CREATE_INCIDENTE);
	}	
        
}