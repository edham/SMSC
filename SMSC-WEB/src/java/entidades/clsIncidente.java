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
public class clsIncidente {
    private int int_id_incidente;
    private clsTipoIncidente objTipoIncidente;
    private clsUsuario objUsuario;
    private double dou_latitud;
    private double dou_longitud;
    private String str_detalle;
    private byte[] byte_foto;
    private Date dat_fecha_registro;
    private int int_estado;

    public clsIncidente() {
        this.byte_foto=null;
    }

    public int getInt_id_incidente() {
        return int_id_incidente;
    }

    public void setInt_id_incidente(int int_id_incidente) {
        this.int_id_incidente = int_id_incidente;
    }

    public clsTipoIncidente getObjTipoIncidente() {
        return objTipoIncidente;
    }

    public void setObjTipoIncidente(clsTipoIncidente objTipoIncidente) {
        this.objTipoIncidente = objTipoIncidente;
    }

    public clsUsuario getObjUsuario() {
        return objUsuario;
    }

    public void setObjUsuario(clsUsuario objUsuario) {
        this.objUsuario = objUsuario;
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
    
}
