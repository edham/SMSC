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
    private Date dat_fecha_nacimiento;
    private int int_cantidad_falso;
    private int int_estado;

    public clsUsuario() {
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

    public int getInt_cantidad_falso() {
        return int_cantidad_falso;
    }

    public void setInt_cantidad_falso(int int_cantidad_falso) {
        this.int_cantidad_falso = int_cantidad_falso;
    }

    public int getInt_estado() {
        return int_estado;
    }

    public void setInt_estado(int int_estado) {
        this.int_estado = int_estado;
    }
    
}
