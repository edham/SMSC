/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

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
    private String str_email;
    private String str_telefono;
    private String str_celular;
    private String str_dni;
    private String str_direccion;
    private String str_clave;
    private int int_puntos;
    private byte[] byte_foto;
    private Date dat_fecha_nacimiento;
    private Date dat_fecha_registro;
    private Date dat_fecha_actualizacion;
    private int int_estado;
    private clsDistrito objDistrito;
    private clsTipoPersonal objTipoPersonal;

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

    public String getStr_email() {
        return str_email;
    }

    public void setStr_email(String str_email) {
        this.str_email = str_email;
    }

    public String getStr_telefono() {
        return str_telefono;
    }

    public void setStr_telefono(String str_telefono) {
        this.str_telefono = str_telefono;
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

    public String getStr_direccion() {
        return str_direccion;
    }

    public void setStr_direccion(String str_direccion) {
        this.str_direccion = str_direccion;
    }

    public String getStr_clave() {
        return str_clave;
    }

    public void setStr_clave(String str_clave) {
        this.str_clave = str_clave;
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

    public Date getDat_fecha_registro() {
        return dat_fecha_registro;
    }

    public void setDat_fecha_registro(Date dat_fecha_registro) {
        this.dat_fecha_registro = dat_fecha_registro;
    }

    public Date getDat_fecha_actualizacion() {
        return dat_fecha_actualizacion;
    }

    public void setDat_fecha_actualizacion(Date dat_fecha_actualizacion) {
        this.dat_fecha_actualizacion = dat_fecha_actualizacion;
    }

    public int getInt_estado() {
        return int_estado;
    }

    public void setInt_estado(int int_estado) {
        this.int_estado = int_estado;
    }

    public clsDistrito getObjDistrito() {
        return objDistrito;
    }

    public void setObjDistrito(clsDistrito objDistrito) {
        this.objDistrito = objDistrito;
    }

    public clsTipoPersonal getObjTipoPersonal() {
        return objTipoPersonal;
    }

    public void setObjTipoPersonal(clsTipoPersonal objTipoPersonal) {
        this.objTipoPersonal = objTipoPersonal;
    }
    
}
