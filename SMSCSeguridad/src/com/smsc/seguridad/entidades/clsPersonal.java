/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.smsc.seguridad.entidades;

import android.util.Base64;
import java.util.Date;

/**
 *
 * @author EdHam
 */
public class clsPersonal {
    private int int_id_personal;
    private String str_nombre;
    private String str_apellido_paterno;
    private String str_apellido_materno;
    private String str_dni;
    private int int_puntos;
    private byte[] byte_foto;
    private Date dat_fecha_nacimiento;
    private String str_nombre_distrito;
    private String  str_nombre_tipo_personal;

    public clsPersonal(String entidad) {
        String [] parametro = entidad.split("\\<+parametro+>");   
        this.int_id_personal = Integer.parseInt(parametro[0].trim());
        this.str_nombre = parametro[1].trim();
        this.str_apellido_paterno = parametro[2].trim();
        this.str_apellido_materno = parametro[3].trim();
        this.str_dni = parametro[4].trim();
        this.int_puntos = Integer.parseInt(parametro[5].trim());    
        if(parametro[6].trim().equals("0"))
            this.byte_foto = null;
        else
            this.byte_foto = Base64.decode(parametro[6].trim(),Base64.NO_WRAP|Base64.URL_SAFE);     
        this.dat_fecha_nacimiento = new Date(Long.parseLong(parametro[7].trim()));
        this.str_nombre_distrito = parametro[8].trim();
        this.str_nombre_tipo_personal = parametro[9].trim();
    }
    
    public clsPersonal() {
    }

    public clsPersonal(int int_id_personal) {
        this.int_id_personal = int_id_personal;
    }

    public int getInt_id_personal() {
        return int_id_personal;
    }

    public void setInt_id_personal(int int_id_personal) {
        this.int_id_personal = int_id_personal;
    }

    public String getStr_nombre() {
        return str_nombre;
    }

    public void setStr_nombre(String str_nombre) {
        this.str_nombre = str_nombre;
    }

    public String getStr_apellido_paterno() {
        return str_apellido_paterno;
    }

    public void setStr_apellido_paterno(String str_apellido_paterno) {
        this.str_apellido_paterno = str_apellido_paterno;
    }

    public String getStr_apellido_materno() {
        return str_apellido_materno;
    }

    public void setStr_apellido_materno(String str_apellido_materno) {
        this.str_apellido_materno = str_apellido_materno;
    }

  

    public int getInt_puntos() {
        return int_puntos;
    }

    public void setInt_puntos(int int_puntos) {
        this.int_puntos = int_puntos;
    }

    public byte[] getByte_foto() {
        return byte_foto;
    }

    public void setByte_foto(byte[] byte_foto) {
        this.byte_foto = byte_foto;
    }

    public Date getDat_fecha_nacimiento() {
        return dat_fecha_nacimiento;
    }

    public void setDat_fecha_nacimiento(Date dat_fecha_nacimiento) {
        this.dat_fecha_nacimiento = dat_fecha_nacimiento;
    }
    
    public String getStr_nombre_distrito() {
        return str_nombre_distrito;
    }

    public void setStr_nombre_distrito(String str_nombe_distrito) {
        this.str_nombre_distrito = str_nombe_distrito;
    }

    public String getStr_nombre_tipo_personal() {
        return str_nombre_tipo_personal;
    }

    public void setStr_nombre_tipo_personal(String str_nombre_tipo_personal) {
        this.str_nombre_tipo_personal = str_nombre_tipo_personal;
    }

    public String getStr_dni() {
        return str_dni;
    }

    public void setStr_dni(String str_dni) {
        this.str_dni = str_dni;
    }

   
    
}
