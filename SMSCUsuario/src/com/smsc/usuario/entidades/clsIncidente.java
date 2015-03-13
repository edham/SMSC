/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.smsc.usuario.entidades;

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
    private int int_rapides;
    private int int_conformidad;
    
    public clsIncidente() {
    }

    public clsIncidente(String entidad,int idUsuario) {
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
         this.int_rapides = Integer.parseInt(parametro[9].trim());
         this.int_conformidad = Integer.parseInt(parametro[10].trim());
         this.int_id_usuario=idUsuario;
         
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

    public int getInt_rapides() {
        return int_rapides;
    }

    public void setInt_rapides(int int_rapides) {
        this.int_rapides = int_rapides;
    }

    public int getInt_conformidad() {
        return int_conformidad;
    }

    public void setInt_conformidad(int int_conformidad) {
        this.int_conformidad = int_conformidad;
    }
    
}
