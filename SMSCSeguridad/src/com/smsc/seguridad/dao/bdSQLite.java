package com.smsc.seguridad.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class bdSQLite extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "SMSCUsuario"; 
    private static final int DATABASE_VERSION = 1;        

        private static final String CREATE_SESION_PERSONAL_VEHICULO = "CREATE TABLE SESION_PERSONAL_VEHICULO ("
                                + "int_sesion_personal_vehiculo integer NOT NULL PRIMARY KEY,"
                                + "dat_fecha_entrada numeric NOT NULL,"
                                + "str_vehiculoe_marca text NOT NULL,"
                                + "str_vehiculoe_modelo text NOT NULL,"
                                + "str_vehiculoe_placa text NOT NULL,"
                                + "str_vehiculoe_numero text NOT NULL)";
        
        private static final String CREATE_PERSONAL = "CREATE TABLE PERSONAL ("
                                + "int_id_personal integer NOT NULL PRIMARY KEY,"
                                + "str_nombre text NOT NULL,"
                                + "str_apellido_paterno text NOT NULL,"
                                + "str_apellido_materno text NOT NULL,"
                                + "str_dni text NOT NULL,"
                                + "int_puntos integer NOT NULL,"
                                + "dat_fecha_nacimiento numeric NOT NULL,"
                                + "str_nombre_distrito text NOT NULL,"
                                + "str_nombre_tipo_personal text NOT NULL,"
                                + "byte_foto blob)";


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
                                + "str_usuario_nombre text NOT NULL,"
                                + "str_usuario_apellido text NOT NULL,"
                                + "str_usuario_celular text NOT NULL,"
                                + "str_usuario_dni text NOT NULL,"
                                + "str_usuario_email text NOT NULL,"
                                + "dat_usuario_fecha_nacimiento numeric NOT NULL,"
                                + "bool_usuario_sexo integer NOT NULL,"
                                + "int_id_respuesta_incidente integer NOT NULL,"
                                + "byte_foto blob)";

	public bdSQLite(Context context, CursorFactory factory) {
		super(context, DATABASE_NAME, factory, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
                db.execSQL(CREATE_SESION_PERSONAL_VEHICULO);
                db.execSQL(CREATE_PERSONAL);
                db.execSQL(CREATE_INCIDENTE);
                
        }   
         
	@Override
	public void onUpgrade(SQLiteDatabase db, int versionAnte, int versionNue) {

                db.execSQL("drop table if exists SESION_PERSONAL_VEHICULO");
                db.execSQL(CREATE_SESION_PERSONAL_VEHICULO);
                
                db.execSQL("drop table if exists PERSONAL");
                db.execSQL(CREATE_PERSONAL);
                
                db.execSQL("drop table if exists INCIDENTE");
                db.execSQL(CREATE_INCIDENTE);
	}	
        
}