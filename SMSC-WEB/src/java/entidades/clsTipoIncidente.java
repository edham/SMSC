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
public class clsTipoIncidente {
    private int int_id_tipo_incidente;
    private String str_nombre;
    private String str_descripcion;
    private byte[] byte_imagen;
    private Date dat_fecha_registro;
    private Date dat_fecha_actualizacion;
    private int int_estado;

    public clsTipoIncidente() {
    }

    public clsTipoIncidente(int int_id_tipo_incidente) {
        this.int_id_tipo_incidente = int_id_tipo_incidente;
    }

    public int getInt_id_tipo_incidente() {
        return int_id_tipo_incidente;
    }

    public void setInt_id_tipo_incidente(int int_id_tipo_incidente) {
        this.int_id_tipo_incidente = int_id_tipo_incidente;
    }

    public String getStr_nombre() {
        return str_nombre;
    }

    public void setStr_nombre(String str_nombre) {
        this.str_nombre = str_nombre;
    }

    public String getStr_descripcion() {
        return str_descripcion;
    }

    public void setStr_descripcion(String str_descripcion) {
        this.str_descripcion = str_descripcion;
    }

    public byte[] getByte_imagen() {
        return byte_imagen;
    }

    public void setByte_imagen(byte[] byte_imagen) {
        this.byte_imagen = byte_imagen;
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
    
}
