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
public class clsIncidente {
    private int int_id_incidente;
    private double dou_latitud;
    private double dou_longitud;
    private String str_detalle;
    private byte[] byte_foto;
    private Date dat_fecha_registro;
    private int int_estado;
    private int int_id_tipo_incidente;
    private String str_tipo_incidente_nombre;
    private int int_id_usuario;
    private String str_usuario_nombre;
    private String str_usuario_apellido;
    private String str_usuario_celular;
    private String str_usuario_dni;
    private String str_usuario_email;
    private Date dat_usuario_fecha_nacimiento;
    private boolean bool_usuario_sexo;

    public clsIncidente() {
    }

    public clsIncidente(String entidad) {
        String [] parametro = entidad.split("\\<+parametro+>");   
        this.int_id_incidente = Integer.parseInt(parametro[0].trim());
        this.dou_latitud = Double.parseDouble(parametro[1].trim());
        this.dou_longitud = Double.parseDouble(parametro[2].trim());
        this.str_detalle = parametro[3].trim();
        this.dat_fecha_registro = new Date(Long.parseLong(parametro[4].trim()));
        this.int_estado = Integer.parseInt(parametro[5].trim());
        if(parametro[6].trim().equals("0"))
            this.byte_foto = null;
        else
            this.byte_foto = Base64.decode(parametro[6].trim(),Base64.NO_WRAP|Base64.URL_SAFE);     
        this.int_id_tipo_incidente = Integer.parseInt(parametro[7].trim());
        this.str_tipo_incidente_nombre = parametro[8].trim();
        this.int_id_usuario=Integer.parseInt(parametro[9].trim());
        this.str_usuario_nombre = parametro[10].trim();
        this.str_usuario_apellido = parametro[11].trim();
        this.str_usuario_celular = parametro[12].trim();
        this.str_usuario_dni = parametro[13].trim();
        this.str_usuario_email = parametro[14].trim();
        this.dat_usuario_fecha_nacimiento = new Date(Long.parseLong(parametro[15].trim()));
        this.bool_usuario_sexo = Boolean.parseBoolean(parametro[16].trim());
    }

    public int getInt_id_incidente() {
        return int_id_incidente;
    }

    public void setInt_id_incidente(int int_id_incidente) {
        this.int_id_incidente = int_id_incidente;
    }

    public double getDou_latitud() {
        return dou_latitud;
    }

    public void setDou_latitud(double dou_latitud) {
        this.dou_latitud = dou_latitud;
    }

    public double getDou_longitud() {
        return dou_longitud;
    }

    public void setDou_longitud(double dou_longitud) {
        this.dou_longitud = dou_longitud;
    }

    public String getStr_detalle() {
        return str_detalle;
    }

    public void setStr_detalle(String str_detalle) {
        this.str_detalle = str_detalle;
    }

    public byte[] getByte_foto() {
        return byte_foto;
    }

    public void setByte_foto(byte[] byte_foto) {
        this.byte_foto = byte_foto;
    }

    public Date getDat_fecha_registro() {
        return dat_fecha_registro;
    }

    public void setDat_fecha_registro(Date dat_fecha_registro) {
        this.dat_fecha_registro = dat_fecha_registro;
    }

    public int getInt_estado() {
        return int_estado;
    }

    public void setInt_estado(int int_estado) {
        this.int_estado = int_estado;
    }

    public int getInt_id_tipo_incidente() {
        return int_id_tipo_incidente;
    }

    public void setInt_id_tipo_incidente(int int_id_tipo_incidente) {
        this.int_id_tipo_incidente = int_id_tipo_incidente;
    }

    public String getStr_tipo_incidente_nombre() {
        return str_tipo_incidente_nombre;
    }

    public void setStr_tipo_incidente_nombre(String str_tipo_incidente_nombre) {
        this.str_tipo_incidente_nombre = str_tipo_incidente_nombre;
    }

    public int getInt_id_usuario() {
        return int_id_usuario;
    }

    public void setInt_id_usuario(int int_id_usuario) {
        this.int_id_usuario = int_id_usuario;
    }

    public String getStr_usuario_nombre() {
        return str_usuario_nombre;
    }

    public void setStr_usuario_nombre(String str_usuario_nombre) {
        this.str_usuario_nombre = str_usuario_nombre;
    }

    public String getStr_usuario_apellido() {
        return str_usuario_apellido;
    }

    public void setStr_usuario_apellido(String str_usuario_apellido) {
        this.str_usuario_apellido = str_usuario_apellido;
    }

    public String getStr_usuario_celular() {
        return str_usuario_celular;
    }

    public void setStr_usuario_celular(String str_usuario_celular) {
        this.str_usuario_celular = str_usuario_celular;
    }

    public String getStr_usuario_dni() {
        return str_usuario_dni;
    }

    public void setStr_usuario_dni(String str_usuario_dni) {
        this.str_usuario_dni = str_usuario_dni;
    }

    public String getStr_usuario_email() {
        return str_usuario_email;
    }

    public void setStr_usuario_email(String str_usuario_email) {
        this.str_usuario_email = str_usuario_email;
    }

    public Date getDat_usuario_fecha_nacimiento() {
        return dat_usuario_fecha_nacimiento;
    }

    public void setDat_usuario_fecha_nacimiento(Date dat_usuario_fecha_nacimiento) {
        this.dat_usuario_fecha_nacimiento = dat_usuario_fecha_nacimiento;
    }

    public boolean isBool_usuario_sexo() {
        return bool_usuario_sexo;
    }

    public void setBool_usuario_sexo(boolean bool_usuario_sexo) {
        this.bool_usuario_sexo = bool_usuario_sexo;
    }

  
}
