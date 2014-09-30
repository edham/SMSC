/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.smsc.usuario.entidades;

import java.util.Date;

/**
 *
 * @author EdHam
 */
public class clsUsuario {
    private int int_id_usuario;
    private String str_nombre;
    private String str_apellido;
    private String str_email;
    private String str_celular;
    private String str_dni;
    private boolean bool_sexo;
    private String str_clave;
    private Date dat_fecha_nacimiento;

    public clsUsuario() {
    }

    public clsUsuario(String entidad) {
        String [] parametro = entidad.split("\\<+parametro+>");   
        this.int_id_usuario = Integer.parseInt(parametro[0].trim());
        this.str_nombre = parametro[1].trim();
        this.str_apellido = parametro[2].trim();
        this.str_email = parametro[3].trim();
        this.str_celular = parametro[4].trim();
        this.str_dni = parametro[5].trim();
        this.dat_fecha_nacimiento = new Date(Long.parseLong(parametro[6].trim()));
        this.bool_sexo = Boolean.parseBoolean(parametro[7].trim());
    }

    public int getInt_id_usuario() {
        return int_id_usuario;
    }

    public void setInt_id_usuario(int int_id_usuario) {
        this.int_id_usuario = int_id_usuario;
    }

    public String getStr_nombre() {
        return str_nombre;
    }

    public void setStr_nombre(String str_nombre) {
        this.str_nombre = str_nombre;
    }

    public String getStr_apellido() {
        return str_apellido;
    }

    public void setStr_apellido(String str_apellido) {
        this.str_apellido = str_apellido;
    }
    
    public String getStr_email() {
        return str_email;
    }

    public void setStr_email(String str_email) {
        this.str_email = str_email;
    }

    public String getStr_celular() {
        return str_celular;
    }

    public void setStr_celular(String str_celular) {
        this.str_celular = str_celular;
    }

    public String getStr_dni() {
        return str_dni;
    }

    public void setStr_dni(String str_dni) {
        this.str_dni = str_dni;
    }

    public boolean isBool_sexo() {
        return bool_sexo;
    }

    public void setBool_sexo(boolean bool_sexo) {
        this.bool_sexo = bool_sexo;
    }

    public Date getDat_fecha_nacimiento() {
        return dat_fecha_nacimiento;
    }

    public void setDat_fecha_nacimiento(Date dat_fecha_nacimiento) {
        this.dat_fecha_nacimiento = dat_fecha_nacimiento;
    }

    public String getStr_clave() {
        return str_clave;
    }

    public void setStr_clave(String str_clave) {
        this.str_clave = str_clave;
    }
    
}
